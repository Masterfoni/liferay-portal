/**
 * Copyright (c) 2000-2007 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.liferay.portal.service.ejb;

import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserLocalServiceFactory;

import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

/**
 * <a href="UserLocalServiceEJBImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be overwritten
 * the next time is generated.
 * </p>
 *
 * <p>
 * This class is the EJB implementation of the service that is used when Liferay
 * is run inside a full J2EE container.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.liferay.portal.service.UserLocalService
 * @see com.liferay.portal.service.UserLocalServiceUtil
 * @see com.liferay.portal.service.ejb.UserLocalServiceEJB
 * @see com.liferay.portal.service.ejb.UserLocalServiceHome
 * @see com.liferay.portal.service.impl.UserLocalServiceImpl
 *
 */
public class UserLocalServiceEJBImpl implements UserLocalService, SessionBean {
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.DynamicQueryInitializer queryInitializer)
		throws com.liferay.portal.SystemException {
		return UserLocalServiceFactory.getTxImpl().dynamicQuery(queryInitializer);
	}

	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.DynamicQueryInitializer queryInitializer,
		int begin, int end) throws com.liferay.portal.SystemException {
		return UserLocalServiceFactory.getTxImpl().dynamicQuery(queryInitializer,
			begin, end);
	}

	public void addGroupUsers(long groupId, long[] userIds)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		UserLocalServiceFactory.getTxImpl().addGroupUsers(groupId, userIds);
	}

	public void addPasswordPolicyUsers(long passwordPolicyId, long[] userIds)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		UserLocalServiceFactory.getTxImpl().addPasswordPolicyUsers(passwordPolicyId,
			userIds);
	}

	public void addRoleUsers(long roleId, long[] userIds)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		UserLocalServiceFactory.getTxImpl().addRoleUsers(roleId, userIds);
	}

	public void addUserGroupUsers(long userGroupId, long[] userIds)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		UserLocalServiceFactory.getTxImpl().addUserGroupUsers(userGroupId,
			userIds);
	}

	public com.liferay.portal.model.User addUser(long creatorUserId,
		long companyId, boolean autoPassword, java.lang.String password1,
		java.lang.String password2, boolean passwordReset,
		boolean autoScreenName, java.lang.String screenName,
		java.lang.String emailAddress, java.util.Locale locale,
		java.lang.String firstName, java.lang.String middleName,
		java.lang.String lastName, int prefixId, int suffixId, boolean male,
		int birthdayMonth, int birthdayDay, int birthdayYear,
		java.lang.String jobTitle, long organizationId, long locationId,
		boolean sendEmail)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		return UserLocalServiceFactory.getTxImpl().addUser(creatorUserId,
			companyId, autoPassword, password1, password2, passwordReset,
			autoScreenName, screenName, emailAddress, locale, firstName,
			middleName, lastName, prefixId, suffixId, male, birthdayMonth,
			birthdayDay, birthdayYear, jobTitle, organizationId, locationId,
			sendEmail);
	}

	public int authenticateByEmailAddress(long companyId,
		java.lang.String emailAddress, java.lang.String password,
		java.util.Map headerMap, java.util.Map parameterMap)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		return UserLocalServiceFactory.getTxImpl().authenticateByEmailAddress(companyId,
			emailAddress, password, headerMap, parameterMap);
	}

	public int authenticateByScreenName(long companyId,
		java.lang.String screenName, java.lang.String password,
		java.util.Map headerMap, java.util.Map parameterMap)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		return UserLocalServiceFactory.getTxImpl().authenticateByScreenName(companyId,
			screenName, password, headerMap, parameterMap);
	}

	public int authenticateByUserId(long companyId, long userId,
		java.lang.String password, java.util.Map headerMap,
		java.util.Map parameterMap)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		return UserLocalServiceFactory.getTxImpl().authenticateByUserId(companyId,
			userId, password, headerMap, parameterMap);
	}

	public boolean authenticateForJAAS(long userId, java.lang.String encPwd)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		return UserLocalServiceFactory.getTxImpl().authenticateForJAAS(userId,
			encPwd);
	}

	public com.liferay.portal.kernel.util.KeyValuePair decryptUserId(
		long companyId, java.lang.String name, java.lang.String password)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		return UserLocalServiceFactory.getTxImpl().decryptUserId(companyId,
			name, password);
	}

	public void deletePasswordPolicyUser(long passwordPolicyId, long userId)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		UserLocalServiceFactory.getTxImpl().deletePasswordPolicyUser(passwordPolicyId,
			userId);
	}

	public void deleteRoleUser(long roleId, long userId)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		UserLocalServiceFactory.getTxImpl().deleteRoleUser(roleId, userId);
	}

	public void deleteUser(long userId)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		UserLocalServiceFactory.getTxImpl().deleteUser(userId);
	}

	public java.lang.String encryptUserId(java.lang.String name)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		return UserLocalServiceFactory.getTxImpl().encryptUserId(name);
	}

	public com.liferay.portal.model.User getDefaultUser(long companyId)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		return UserLocalServiceFactory.getTxImpl().getDefaultUser(companyId);
	}

	public long getDefaultUserId(long companyId)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		return UserLocalServiceFactory.getTxImpl().getDefaultUserId(companyId);
	}

	public java.util.List getGroupUsers(long groupId)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		return UserLocalServiceFactory.getTxImpl().getGroupUsers(groupId);
	}

	public java.util.List getPermissionUsers(long companyId, long groupId,
		java.lang.String name, java.lang.String primKey,
		java.lang.String actionId, java.lang.String firstName,
		java.lang.String middleName, java.lang.String lastName,
		java.lang.String emailAddress, boolean andOperator, int begin, int end)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		return UserLocalServiceFactory.getTxImpl().getPermissionUsers(companyId,
			groupId, name, primKey, actionId, firstName, middleName, lastName,
			emailAddress, andOperator, begin, end);
	}

	public int getPermissionUsersCount(long companyId, long groupId,
		java.lang.String name, java.lang.String primKey,
		java.lang.String actionId, java.lang.String firstName,
		java.lang.String middleName, java.lang.String lastName,
		java.lang.String emailAddress, boolean andOperator)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		return UserLocalServiceFactory.getTxImpl().getPermissionUsersCount(companyId,
			groupId, name, primKey, actionId, firstName, middleName, lastName,
			emailAddress, andOperator);
	}

	public java.util.List getRoleUsers(long roleId)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		return UserLocalServiceFactory.getTxImpl().getRoleUsers(roleId);
	}

	public com.liferay.portal.model.User getUserByContactId(long contactId)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		return UserLocalServiceFactory.getTxImpl().getUserByContactId(contactId);
	}

	public com.liferay.portal.model.User getUserByEmailAddress(long companyId,
		java.lang.String emailAddress)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		return UserLocalServiceFactory.getTxImpl().getUserByEmailAddress(companyId,
			emailAddress);
	}

	public com.liferay.portal.model.User getUserById(long userId)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		return UserLocalServiceFactory.getTxImpl().getUserById(userId);
	}

	public com.liferay.portal.model.User getUserById(long companyId, long userId)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		return UserLocalServiceFactory.getTxImpl().getUserById(companyId, userId);
	}

	public com.liferay.portal.model.User getUserByScreenName(long companyId,
		java.lang.String screenName)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		return UserLocalServiceFactory.getTxImpl().getUserByScreenName(companyId,
			screenName);
	}

	public long getUserIdByEmailAddress(long companyId,
		java.lang.String emailAddress)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		return UserLocalServiceFactory.getTxImpl().getUserIdByEmailAddress(companyId,
			emailAddress);
	}

	public long getUserIdByScreenName(long companyId,
		java.lang.String screenName)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		return UserLocalServiceFactory.getTxImpl().getUserIdByScreenName(companyId,
			screenName);
	}

	public boolean hasGroupUser(long groupId, long userId)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		return UserLocalServiceFactory.getTxImpl().hasGroupUser(groupId, userId);
	}

	public boolean hasPasswordPolicyUser(long passwordPolicyId, long userId)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		return UserLocalServiceFactory.getTxImpl().hasPasswordPolicyUser(passwordPolicyId,
			userId);
	}

	public boolean hasRoleUser(long roleId, long userId)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		return UserLocalServiceFactory.getTxImpl().hasRoleUser(roleId, userId);
	}

	public boolean hasUserGroupUser(long userGroupId, long userId)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		return UserLocalServiceFactory.getTxImpl().hasUserGroupUser(userGroupId,
			userId);
	}

	public java.util.List search(long companyId, java.lang.String firstName,
		java.lang.String middleName, java.lang.String lastName,
		java.lang.String screenName, java.lang.String emailAddress,
		boolean active, java.util.LinkedHashMap params, boolean andSearch,
		int begin, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return UserLocalServiceFactory.getTxImpl().search(companyId, firstName,
			middleName, lastName, screenName, emailAddress, active, params,
			andSearch, begin, end, obc);
	}

	public int searchCount(long companyId, java.lang.String firstName,
		java.lang.String middleName, java.lang.String lastName,
		java.lang.String screenName, java.lang.String emailAddress,
		boolean active, java.util.LinkedHashMap params, boolean andSearch)
		throws com.liferay.portal.SystemException {
		return UserLocalServiceFactory.getTxImpl().searchCount(companyId,
			firstName, middleName, lastName, screenName, emailAddress, active,
			params, andSearch);
	}

	public void sendPassword(long companyId, java.lang.String emailAddress,
		java.lang.String remoteAddr, java.lang.String remoteHost,
		java.lang.String userAgent)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		UserLocalServiceFactory.getTxImpl().sendPassword(companyId,
			emailAddress, remoteAddr, remoteHost, userAgent);
	}

	public void setGroupUsers(long groupId, long[] userIds)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		UserLocalServiceFactory.getTxImpl().setGroupUsers(groupId, userIds);
	}

	public void setRoleUsers(long roleId, long[] userIds)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		UserLocalServiceFactory.getTxImpl().setRoleUsers(roleId, userIds);
	}

	public void setUserGroupUsers(long userGroupId, long[] userIds)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		UserLocalServiceFactory.getTxImpl().setUserGroupUsers(userGroupId,
			userIds);
	}

	public void unsetGroupUsers(long groupId, long[] userIds)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		UserLocalServiceFactory.getTxImpl().unsetGroupUsers(groupId, userIds);
	}

	public void unsetPasswordPolicyUsers(long passwordPolicyId, long[] userIds)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		UserLocalServiceFactory.getTxImpl().unsetPasswordPolicyUsers(passwordPolicyId,
			userIds);
	}

	public void unsetRoleUsers(long roleId, long[] userIds)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		UserLocalServiceFactory.getTxImpl().unsetRoleUsers(roleId, userIds);
	}

	public void unsetUserGroupUsers(long userGroupId, long[] userIds)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		UserLocalServiceFactory.getTxImpl().unsetUserGroupUsers(userGroupId,
			userIds);
	}

	public com.liferay.portal.model.User updateActive(long userId,
		boolean active)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		return UserLocalServiceFactory.getTxImpl().updateActive(userId, active);
	}

	public com.liferay.portal.model.User updateAgreedToTermsOfUse(long userId,
		boolean agreedToTermsOfUse)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		return UserLocalServiceFactory.getTxImpl().updateAgreedToTermsOfUse(userId,
			agreedToTermsOfUse);
	}

	public com.liferay.portal.model.User updateLastLogin(long userId,
		java.lang.String loginIP)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		return UserLocalServiceFactory.getTxImpl().updateLastLogin(userId,
			loginIP);
	}

	public com.liferay.portal.model.User updatePassword(long userId,
		java.lang.String password1, java.lang.String password2,
		boolean passwordReset)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		return UserLocalServiceFactory.getTxImpl().updatePassword(userId,
			password1, password2, passwordReset);
	}

	public void updatePortrait(long userId, byte[] bytes)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		UserLocalServiceFactory.getTxImpl().updatePortrait(userId, bytes);
	}

	public com.liferay.portal.model.User updateUser(long userId,
		java.lang.String password, java.lang.String screenName,
		java.lang.String emailAddress, java.lang.String languageId,
		java.lang.String timeZoneId, java.lang.String greeting,
		java.lang.String comments, java.lang.String firstName,
		java.lang.String middleName, java.lang.String lastName, int prefixId,
		int suffixId, boolean male, int birthdayMonth, int birthdayDay,
		int birthdayYear, java.lang.String smsSn, java.lang.String aimSn,
		java.lang.String icqSn, java.lang.String jabberSn,
		java.lang.String msnSn, java.lang.String skypeSn,
		java.lang.String ymSn, java.lang.String jobTitle, long organizationId,
		long locationId)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		return UserLocalServiceFactory.getTxImpl().updateUser(userId, password,
			screenName, emailAddress, languageId, timeZoneId, greeting,
			comments, firstName, middleName, lastName, prefixId, suffixId,
			male, birthdayMonth, birthdayDay, birthdayYear, smsSn, aimSn,
			icqSn, jabberSn, msnSn, skypeSn, ymSn, jobTitle, organizationId,
			locationId);
	}

	public void ejbCreate() throws CreateException {
	}

	public void ejbRemove() {
	}

	public void ejbActivate() {
	}

	public void ejbPassivate() {
	}

	public SessionContext getSessionContext() {
		return _sc;
	}

	public void setSessionContext(SessionContext sc) {
		_sc = sc;
	}

	private SessionContext _sc;
}