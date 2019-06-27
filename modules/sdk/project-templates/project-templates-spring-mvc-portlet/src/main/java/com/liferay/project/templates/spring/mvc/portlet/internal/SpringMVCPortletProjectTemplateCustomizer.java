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

package com.liferay.project.templates.spring.mvc.portlet.internal;

import com.liferay.project.templates.ProjectTemplateCustomizer;
import com.liferay.project.templates.ProjectTemplatesArgs;
import com.liferay.project.templates.internal.util.FileUtil;

import java.io.File;
import java.nio.file.Path;
import java.util.regex.Pattern;

import org.apache.maven.archetype.ArchetypeGenerationRequest;
import org.apache.maven.archetype.ArchetypeGenerationResult;

/**
 * @author Neil Griffin
 * @author Lawrence Lee
 */
public class SpringMVCPortletProjectTemplateCustomizer
	implements ProjectTemplateCustomizer {

	@Override
	public void onAfterGenerateProject(
			ProjectTemplatesArgs projectTemplatesArgs, File destinationDir,
			ArchetypeGenerationResult archetypeGenerationResult)
		throws Exception {

		Path destinationDirPath = destinationDir.toPath();

		String name = projectTemplatesArgs.getName();

		Path projectPath = destinationDirPath.resolve(name);

		File buildDir = projectPath.toFile();

		File viewsDir = new File(buildDir, "src/main/webapp/WEB-INF/views");

		String packageName = projectTemplatesArgs.getPackageName();

		File spring4JavaPkgDir = new File(
			buildDir,
			"src/main/java/" + packageName.replaceAll("[.]", "/") +
				"/spring4");

		String viewType = projectTemplatesArgs.getViewType();

		if (viewType.equals("jsp")) {
			Pattern pattern = Pattern.compile(".*.html");

			FileUtil.deleteFilesByPattern(viewsDir.toPath(), pattern);

		}
		else {
			Pattern pattern = Pattern.compile(".*.jspx");

			FileUtil.deleteFilesByPattern(viewsDir.toPath(), pattern);
		}

		String framework = projectTemplatesArgs.getFramework();

		if (viewType.equals("jsp") ||
			framework.equals("portletmvc4spring")) {

			FileUtil.deleteDir(spring4JavaPkgDir.toPath());
		}
	}

	@Override
	public void onBeforeGenerateProject(
			ProjectTemplatesArgs projectTemplatesArgs,
			ArchetypeGenerationRequest archetypeGenerationRequest)
		throws Exception {
	}

}