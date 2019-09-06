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

package com.liferay.portal.kernel.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;

/**
 * Provides the remote service utility for ClassName. This utility wraps
 * <code>com.liferay.portal.service.impl.ClassNameServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see ClassNameService
 * @generated
 */
public class ClassNameServiceUtil {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.portal.service.impl.ClassNameServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ClassNameServiceUtil} to access the class name remote service. Add custom service methods to <code>com.liferay.portal.service.impl.ClassNameServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static com.liferay.portal.kernel.model.ClassName fetchByClassNameId(
		long classNameId) {

		return getService().fetchByClassNameId(classNameId);
	}

	public static com.liferay.portal.kernel.model.ClassName fetchClassName(
		String value) {

		return getService().fetchClassName(value);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static ClassNameService getService() {
		if (_service == null) {
			_service = (ClassNameService)PortalBeanLocatorUtil.locate(
				ClassNameService.class.getName());
		}

		return _service;
	}

	private static ClassNameService _service;

}