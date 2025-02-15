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

package com.liferay.microblogs.service.http;

import com.liferay.microblogs.service.MicroblogsEntryServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * <code>MicroblogsEntryServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.liferay.microblogs.model.MicroblogsEntrySoap</code>. If the method in the
 * service utility returns a
 * <code>com.liferay.microblogs.model.MicroblogsEntry</code>, that is translated to a
 * <code>com.liferay.microblogs.model.MicroblogsEntrySoap</code>. Methods that SOAP
 * cannot safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MicroblogsEntryServiceHttp
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class MicroblogsEntryServiceSoap {

	public static com.liferay.microblogs.model.MicroblogsEntrySoap
			addMicroblogsEntry(
				long userId, String content, int type,
				long parentMicroblogsEntryId, int socialRelationType,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {

		try {
			com.liferay.microblogs.model.MicroblogsEntry returnValue =
				MicroblogsEntryServiceUtil.addMicroblogsEntry(
					userId, content, type, parentMicroblogsEntryId,
					socialRelationType, serviceContext);

			return com.liferay.microblogs.model.MicroblogsEntrySoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.microblogs.model.MicroblogsEntrySoap
			deleteMicroblogsEntry(long microblogsEntryId)
		throws RemoteException {

		try {
			com.liferay.microblogs.model.MicroblogsEntry returnValue =
				MicroblogsEntryServiceUtil.deleteMicroblogsEntry(
					microblogsEntryId);

			return com.liferay.microblogs.model.MicroblogsEntrySoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.microblogs.model.MicroblogsEntrySoap[]
			getMicroblogsEntries(int start, int end)
		throws RemoteException {

		try {
			java.util.List<com.liferay.microblogs.model.MicroblogsEntry>
				returnValue = MicroblogsEntryServiceUtil.getMicroblogsEntries(
					start, end);

			return com.liferay.microblogs.model.MicroblogsEntrySoap.
				toSoapModels(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.microblogs.model.MicroblogsEntrySoap[]
			getMicroblogsEntries(String assetTagName, int start, int end)
		throws RemoteException {

		try {
			java.util.List<com.liferay.microblogs.model.MicroblogsEntry>
				returnValue = MicroblogsEntryServiceUtil.getMicroblogsEntries(
					assetTagName, start, end);

			return com.liferay.microblogs.model.MicroblogsEntrySoap.
				toSoapModels(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static int getMicroblogsEntriesCount() throws RemoteException {
		try {
			int returnValue =
				MicroblogsEntryServiceUtil.getMicroblogsEntriesCount();

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static int getMicroblogsEntriesCount(String assetTagName)
		throws RemoteException {

		try {
			int returnValue =
				MicroblogsEntryServiceUtil.getMicroblogsEntriesCount(
					assetTagName);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.microblogs.model.MicroblogsEntrySoap
			getMicroblogsEntry(long microblogsEntryId)
		throws RemoteException {

		try {
			com.liferay.microblogs.model.MicroblogsEntry returnValue =
				MicroblogsEntryServiceUtil.getMicroblogsEntry(
					microblogsEntryId);

			return com.liferay.microblogs.model.MicroblogsEntrySoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.microblogs.model.MicroblogsEntrySoap[]
			getUserMicroblogsEntries(
				long microblogsEntryUserId, int start, int end)
		throws RemoteException {

		try {
			java.util.List<com.liferay.microblogs.model.MicroblogsEntry>
				returnValue =
					MicroblogsEntryServiceUtil.getUserMicroblogsEntries(
						microblogsEntryUserId, start, end);

			return com.liferay.microblogs.model.MicroblogsEntrySoap.
				toSoapModels(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.microblogs.model.MicroblogsEntrySoap[]
			getUserMicroblogsEntries(
				long microblogsEntryUserId, int type, int start, int end)
		throws RemoteException {

		try {
			java.util.List<com.liferay.microblogs.model.MicroblogsEntry>
				returnValue =
					MicroblogsEntryServiceUtil.getUserMicroblogsEntries(
						microblogsEntryUserId, type, start, end);

			return com.liferay.microblogs.model.MicroblogsEntrySoap.
				toSoapModels(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static int getUserMicroblogsEntriesCount(long microblogsEntryUserId)
		throws RemoteException {

		try {
			int returnValue =
				MicroblogsEntryServiceUtil.getUserMicroblogsEntriesCount(
					microblogsEntryUserId);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static int getUserMicroblogsEntriesCount(
			long microblogsEntryUserId, int type)
		throws RemoteException {

		try {
			int returnValue =
				MicroblogsEntryServiceUtil.getUserMicroblogsEntriesCount(
					microblogsEntryUserId, type);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.microblogs.model.MicroblogsEntrySoap
			updateMicroblogsEntry(
				long microblogsEntryId, String content, int socialRelationType,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {

		try {
			com.liferay.microblogs.model.MicroblogsEntry returnValue =
				MicroblogsEntryServiceUtil.updateMicroblogsEntry(
					microblogsEntryId, content, socialRelationType,
					serviceContext);

			return com.liferay.microblogs.model.MicroblogsEntrySoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		MicroblogsEntryServiceSoap.class);

}