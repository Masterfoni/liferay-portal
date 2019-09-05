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

package com.liferay.portal.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserTracker;
import com.liferay.portal.kernel.model.UserTrackerModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the UserTracker service. Represents a row in the &quot;UserTracker&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>UserTrackerModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link UserTrackerImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserTrackerImpl
 * @generated
 */
public class UserTrackerModelImpl
	extends BaseModelImpl<UserTracker> implements UserTrackerModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a user tracker model instance should use the <code>UserTracker</code> interface instead.
	 */
	public static final String TABLE_NAME = "UserTracker";

	public static final Object[][] TABLE_COLUMNS = {
		{"mvccVersion", Types.BIGINT}, {"userTrackerId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"modifiedDate", Types.TIMESTAMP}, {"sessionId", Types.VARCHAR},
		{"remoteAddr", Types.VARCHAR}, {"remoteHost", Types.VARCHAR},
		{"userAgent", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userTrackerId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("sessionId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("remoteAddr", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("remoteHost", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("userAgent", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table UserTracker (mvccVersion LONG default 0 not null,userTrackerId LONG not null primary key,companyId LONG,userId LONG,modifiedDate DATE null,sessionId VARCHAR(200) null,remoteAddr VARCHAR(75) null,remoteHost VARCHAR(75) null,userAgent VARCHAR(200) null)";

	public static final String TABLE_SQL_DROP = "drop table UserTracker";

	public static final String ORDER_BY_JPQL =
		" ORDER BY userTracker.userTrackerId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY UserTracker.userTrackerId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.util.PropsUtil.get(
			"value.object.entity.cache.enabled.com.liferay.portal.kernel.model.UserTracker"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.util.PropsUtil.get(
			"value.object.finder.cache.enabled.com.liferay.portal.kernel.model.UserTracker"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.util.PropsUtil.get(
			"value.object.column.bitmask.enabled.com.liferay.portal.kernel.model.UserTracker"),
		true);

	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	public static final long SESSIONID_COLUMN_BITMASK = 2L;

	public static final long USERID_COLUMN_BITMASK = 4L;

	public static final long USERTRACKERID_COLUMN_BITMASK = 8L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.portal.util.PropsUtil.get(
			"lock.expiration.time.com.liferay.portal.kernel.model.UserTracker"));

	public UserTrackerModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _userTrackerId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setUserTrackerId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _userTrackerId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return UserTracker.class;
	}

	@Override
	public String getModelClassName() {
		return UserTracker.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<UserTracker, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<UserTracker, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<UserTracker, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((UserTracker)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<UserTracker, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<UserTracker, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(UserTracker)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<UserTracker, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<UserTracker, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, UserTracker>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			UserTracker.class.getClassLoader(), UserTracker.class,
			ModelWrapper.class);

		try {
			Constructor<UserTracker> constructor =
				(Constructor<UserTracker>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException roe) {
					throw new InternalError(roe);
				}
			};
		}
		catch (NoSuchMethodException nsme) {
			throw new InternalError(nsme);
		}
	}

	private static final Map<String, Function<UserTracker, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<UserTracker, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<UserTracker, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<UserTracker, Object>>();
		Map<String, BiConsumer<UserTracker, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<UserTracker, ?>>();

		attributeGetterFunctions.put(
			"mvccVersion", UserTracker::getMvccVersion);
		attributeSetterBiConsumers.put(
			"mvccVersion",
			(BiConsumer<UserTracker, Long>)UserTracker::setMvccVersion);
		attributeGetterFunctions.put(
			"userTrackerId", UserTracker::getUserTrackerId);
		attributeSetterBiConsumers.put(
			"userTrackerId",
			(BiConsumer<UserTracker, Long>)UserTracker::setUserTrackerId);
		attributeGetterFunctions.put("companyId", UserTracker::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<UserTracker, Long>)UserTracker::setCompanyId);
		attributeGetterFunctions.put("userId", UserTracker::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<UserTracker, Long>)UserTracker::setUserId);
		attributeGetterFunctions.put(
			"modifiedDate", UserTracker::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<UserTracker, Date>)UserTracker::setModifiedDate);
		attributeGetterFunctions.put("sessionId", UserTracker::getSessionId);
		attributeSetterBiConsumers.put(
			"sessionId",
			(BiConsumer<UserTracker, String>)UserTracker::setSessionId);
		attributeGetterFunctions.put("remoteAddr", UserTracker::getRemoteAddr);
		attributeSetterBiConsumers.put(
			"remoteAddr",
			(BiConsumer<UserTracker, String>)UserTracker::setRemoteAddr);
		attributeGetterFunctions.put("remoteHost", UserTracker::getRemoteHost);
		attributeSetterBiConsumers.put(
			"remoteHost",
			(BiConsumer<UserTracker, String>)UserTracker::setRemoteHost);
		attributeGetterFunctions.put("userAgent", UserTracker::getUserAgent);
		attributeSetterBiConsumers.put(
			"userAgent",
			(BiConsumer<UserTracker, String>)UserTracker::setUserAgent);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getMvccVersion() {
		return _mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		_mvccVersion = mvccVersion;
	}

	@Override
	public long getUserTrackerId() {
		return _userTrackerId;
	}

	@Override
	public void setUserTrackerId(long userTrackerId) {
		_userTrackerId = userTrackerId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@Override
	public String getSessionId() {
		if (_sessionId == null) {
			return "";
		}
		else {
			return _sessionId;
		}
	}

	@Override
	public void setSessionId(String sessionId) {
		_columnBitmask |= SESSIONID_COLUMN_BITMASK;

		if (_originalSessionId == null) {
			_originalSessionId = _sessionId;
		}

		_sessionId = sessionId;
	}

	public String getOriginalSessionId() {
		return GetterUtil.getString(_originalSessionId);
	}

	@Override
	public String getRemoteAddr() {
		if (_remoteAddr == null) {
			return "";
		}
		else {
			return _remoteAddr;
		}
	}

	@Override
	public void setRemoteAddr(String remoteAddr) {
		_remoteAddr = remoteAddr;
	}

	@Override
	public String getRemoteHost() {
		if (_remoteHost == null) {
			return "";
		}
		else {
			return _remoteHost;
		}
	}

	@Override
	public void setRemoteHost(String remoteHost) {
		_remoteHost = remoteHost;
	}

	@Override
	public String getUserAgent() {
		if (_userAgent == null) {
			return "";
		}
		else {
			return _userAgent;
		}
	}

	@Override
	public void setUserAgent(String userAgent) {
		_userAgent = userAgent;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), UserTracker.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public UserTracker toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, UserTracker>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		UserTrackerImpl userTrackerImpl = new UserTrackerImpl();

		userTrackerImpl.setMvccVersion(getMvccVersion());
		userTrackerImpl.setUserTrackerId(getUserTrackerId());
		userTrackerImpl.setCompanyId(getCompanyId());
		userTrackerImpl.setUserId(getUserId());
		userTrackerImpl.setModifiedDate(getModifiedDate());
		userTrackerImpl.setSessionId(getSessionId());
		userTrackerImpl.setRemoteAddr(getRemoteAddr());
		userTrackerImpl.setRemoteHost(getRemoteHost());
		userTrackerImpl.setUserAgent(getUserAgent());

		userTrackerImpl.resetOriginalValues();

		return userTrackerImpl;
	}

	@Override
	public int compareTo(UserTracker userTracker) {
		long primaryKey = userTracker.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserTracker)) {
			return false;
		}

		UserTracker userTracker = (UserTracker)obj;

		long primaryKey = userTracker.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		UserTrackerModelImpl userTrackerModelImpl = this;

		userTrackerModelImpl._originalCompanyId =
			userTrackerModelImpl._companyId;

		userTrackerModelImpl._setOriginalCompanyId = false;

		userTrackerModelImpl._originalUserId = userTrackerModelImpl._userId;

		userTrackerModelImpl._setOriginalUserId = false;

		userTrackerModelImpl._originalSessionId =
			userTrackerModelImpl._sessionId;

		userTrackerModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<UserTracker> toCacheModel() {
		UserTrackerCacheModel userTrackerCacheModel =
			new UserTrackerCacheModel();

		userTrackerCacheModel.mvccVersion = getMvccVersion();

		userTrackerCacheModel.userTrackerId = getUserTrackerId();

		userTrackerCacheModel.companyId = getCompanyId();

		userTrackerCacheModel.userId = getUserId();

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			userTrackerCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			userTrackerCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		userTrackerCacheModel.sessionId = getSessionId();

		String sessionId = userTrackerCacheModel.sessionId;

		if ((sessionId != null) && (sessionId.length() == 0)) {
			userTrackerCacheModel.sessionId = null;
		}

		userTrackerCacheModel.remoteAddr = getRemoteAddr();

		String remoteAddr = userTrackerCacheModel.remoteAddr;

		if ((remoteAddr != null) && (remoteAddr.length() == 0)) {
			userTrackerCacheModel.remoteAddr = null;
		}

		userTrackerCacheModel.remoteHost = getRemoteHost();

		String remoteHost = userTrackerCacheModel.remoteHost;

		if ((remoteHost != null) && (remoteHost.length() == 0)) {
			userTrackerCacheModel.remoteHost = null;
		}

		userTrackerCacheModel.userAgent = getUserAgent();

		String userAgent = userTrackerCacheModel.userAgent;

		if ((userAgent != null) && (userAgent.length() == 0)) {
			userTrackerCacheModel.userAgent = null;
		}

		return userTrackerCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<UserTracker, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<UserTracker, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<UserTracker, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((UserTracker)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<UserTracker, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<UserTracker, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<UserTracker, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((UserTracker)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, UserTracker>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _mvccVersion;
	private long _userTrackerId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private Date _modifiedDate;
	private String _sessionId;
	private String _originalSessionId;
	private String _remoteAddr;
	private String _remoteHost;
	private String _userAgent;
	private long _columnBitmask;
	private UserTracker _escapedModel;

}