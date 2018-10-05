/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.lpkg.deployer.internal;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.util.PropsValues;

import java.io.File;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.osgi.framework.BundleContext;

/**
 * @author Matthew Tambara
 */
public class ContainerLPKGUtil {

	public static List<File> deploy(File lpkgFile, BundleContext bundleContext)
		throws IOException {

		if (_isLPKGContainer(lpkgFile)) {
			List<File> lpkgFiles = new ArrayList<>();

			Path deployerDirPath = Paths.get(
				GetterUtil.getString(
					bundleContext.getProperty("lpkg.deployer.dir"),
					PropsValues.MODULE_FRAMEWORK_MARKETPLACE_DIR));

			try (ZipFile zipFile = new ZipFile(lpkgFile)) {
				Enumeration<? extends ZipEntry> zipEntries = zipFile.entries();

				while (zipEntries.hasMoreElements()) {
					ZipEntry zipEntry = zipEntries.nextElement();

					Path lpkgPath = deployerDirPath.resolve(zipEntry.getName());

					Files.copy(
						zipFile.getInputStream(zipEntry), lpkgPath,
						StandardCopyOption.REPLACE_EXISTING);

					lpkgFiles.add(lpkgPath.toFile());
				}
			}

			lpkgFile.delete();

			return lpkgFiles;
		}

		return null;
	}

	private static boolean _isLPKGContainer(File file) throws IOException {
		boolean lpkgContainer = false;

		try (ZipFile zipFile = new ZipFile(file)) {
			Enumeration<? extends ZipEntry> zipEntries = zipFile.entries();

			while (zipEntries.hasMoreElements()) {
				ZipEntry zipEntry = zipEntries.nextElement();

				String name = zipEntry.getName();

				if (name.endsWith(".lpkg")) {
					lpkgContainer = true;
				}
				else {
					return false;
				}
			}
		}

		return lpkgContainer;
	}

}