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

package com.liferay.change.tracking.model.impl;

import com.liferay.change.tracking.model.CTEntry;
import com.liferay.change.tracking.model.CTEntryModel;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
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
 * The base model implementation for the CTEntry service. Represents a row in the &quot;CTEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>CTEntryModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CTEntryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CTEntryImpl
 * @generated
 */
public class CTEntryModelImpl
	extends BaseModelImpl<CTEntry> implements CTEntryModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a ct entry model instance should use the <code>CTEntry</code> interface instead.
	 */
	public static final String TABLE_NAME = "CTEntry";

	public static final Object[][] TABLE_COLUMNS = {
		{"mvccVersion", Types.BIGINT}, {"ctEntryId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"ctCollectionId", Types.BIGINT}, {"modelClassNameId", Types.BIGINT},
		{"modelClassPK", Types.BIGINT}, {"modelResourcePrimKey", Types.BIGINT},
		{"changeType", Types.INTEGER}, {"collision", Types.BOOLEAN},
		{"status", Types.INTEGER}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("ctEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("ctCollectionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("modelClassNameId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("modelClassPK", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("modelResourcePrimKey", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("changeType", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("collision", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE =
		"create table CTEntry (mvccVersion LONG default 0 not null,ctEntryId LONG not null primary key,companyId LONG,userId LONG,createDate DATE null,modifiedDate DATE null,ctCollectionId LONG,modelClassNameId LONG,modelClassPK LONG,modelResourcePrimKey LONG,changeType INTEGER,collision BOOLEAN,status INTEGER)";

	public static final String TABLE_SQL_DROP = "drop table CTEntry";

	public static final String ORDER_BY_JPQL =
		" ORDER BY ctEntry.ctEntryId ASC";

	public static final String ORDER_BY_SQL = " ORDER BY CTEntry.ctEntryId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long CTCOLLECTIONID_COLUMN_BITMASK = 1L;

	public static final long MODELCLASSNAMEID_COLUMN_BITMASK = 2L;

	public static final long MODELCLASSPK_COLUMN_BITMASK = 4L;

	public static final long MODELRESOURCEPRIMKEY_COLUMN_BITMASK = 8L;

	public static final long STATUS_COLUMN_BITMASK = 16L;

	public static final long CTENTRYID_COLUMN_BITMASK = 32L;

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	public CTEntryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _ctEntryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCtEntryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ctEntryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CTEntry.class;
	}

	@Override
	public String getModelClassName() {
		return CTEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CTEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CTEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CTEntry, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((CTEntry)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CTEntry, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CTEntry, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CTEntry)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CTEntry, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CTEntry, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, CTEntry>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			CTEntry.class.getClassLoader(), CTEntry.class, ModelWrapper.class);

		try {
			Constructor<CTEntry> constructor =
				(Constructor<CTEntry>)proxyClass.getConstructor(
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

	private static final Map<String, Function<CTEntry, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<CTEntry, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<CTEntry, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<CTEntry, Object>>();
		Map<String, BiConsumer<CTEntry, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<CTEntry, ?>>();

		attributeGetterFunctions.put("mvccVersion", CTEntry::getMvccVersion);
		attributeSetterBiConsumers.put(
			"mvccVersion", (BiConsumer<CTEntry, Long>)CTEntry::setMvccVersion);
		attributeGetterFunctions.put("ctEntryId", CTEntry::getCtEntryId);
		attributeSetterBiConsumers.put(
			"ctEntryId", (BiConsumer<CTEntry, Long>)CTEntry::setCtEntryId);
		attributeGetterFunctions.put("companyId", CTEntry::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId", (BiConsumer<CTEntry, Long>)CTEntry::setCompanyId);
		attributeGetterFunctions.put("userId", CTEntry::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<CTEntry, Long>)CTEntry::setUserId);
		attributeGetterFunctions.put("createDate", CTEntry::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate", (BiConsumer<CTEntry, Date>)CTEntry::setCreateDate);
		attributeGetterFunctions.put("modifiedDate", CTEntry::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<CTEntry, Date>)CTEntry::setModifiedDate);
		attributeGetterFunctions.put(
			"ctCollectionId", CTEntry::getCtCollectionId);
		attributeSetterBiConsumers.put(
			"ctCollectionId",
			(BiConsumer<CTEntry, Long>)CTEntry::setCtCollectionId);
		attributeGetterFunctions.put(
			"modelClassNameId", CTEntry::getModelClassNameId);
		attributeSetterBiConsumers.put(
			"modelClassNameId",
			(BiConsumer<CTEntry, Long>)CTEntry::setModelClassNameId);
		attributeGetterFunctions.put("modelClassPK", CTEntry::getModelClassPK);
		attributeSetterBiConsumers.put(
			"modelClassPK",
			(BiConsumer<CTEntry, Long>)CTEntry::setModelClassPK);
		attributeGetterFunctions.put(
			"modelResourcePrimKey", CTEntry::getModelResourcePrimKey);
		attributeSetterBiConsumers.put(
			"modelResourcePrimKey",
			(BiConsumer<CTEntry, Long>)CTEntry::setModelResourcePrimKey);
		attributeGetterFunctions.put("changeType", CTEntry::getChangeType);
		attributeSetterBiConsumers.put(
			"changeType", (BiConsumer<CTEntry, Integer>)CTEntry::setChangeType);
		attributeGetterFunctions.put("collision", CTEntry::getCollision);
		attributeSetterBiConsumers.put(
			"collision", (BiConsumer<CTEntry, Boolean>)CTEntry::setCollision);
		attributeGetterFunctions.put("status", CTEntry::getStatus);
		attributeSetterBiConsumers.put(
			"status", (BiConsumer<CTEntry, Integer>)CTEntry::setStatus);

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
	public long getCtEntryId() {
		return _ctEntryId;
	}

	@Override
	public void setCtEntryId(long ctEntryId) {
		_ctEntryId = ctEntryId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
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

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@Override
	public long getCtCollectionId() {
		return _ctCollectionId;
	}

	@Override
	public void setCtCollectionId(long ctCollectionId) {
		_columnBitmask |= CTCOLLECTIONID_COLUMN_BITMASK;

		if (!_setOriginalCtCollectionId) {
			_setOriginalCtCollectionId = true;

			_originalCtCollectionId = _ctCollectionId;
		}

		_ctCollectionId = ctCollectionId;
	}

	public long getOriginalCtCollectionId() {
		return _originalCtCollectionId;
	}

	@Override
	public long getModelClassNameId() {
		return _modelClassNameId;
	}

	@Override
	public void setModelClassNameId(long modelClassNameId) {
		_columnBitmask |= MODELCLASSNAMEID_COLUMN_BITMASK;

		if (!_setOriginalModelClassNameId) {
			_setOriginalModelClassNameId = true;

			_originalModelClassNameId = _modelClassNameId;
		}

		_modelClassNameId = modelClassNameId;
	}

	public long getOriginalModelClassNameId() {
		return _originalModelClassNameId;
	}

	@Override
	public long getModelClassPK() {
		return _modelClassPK;
	}

	@Override
	public void setModelClassPK(long modelClassPK) {
		_columnBitmask |= MODELCLASSPK_COLUMN_BITMASK;

		if (!_setOriginalModelClassPK) {
			_setOriginalModelClassPK = true;

			_originalModelClassPK = _modelClassPK;
		}

		_modelClassPK = modelClassPK;
	}

	public long getOriginalModelClassPK() {
		return _originalModelClassPK;
	}

	@Override
	public long getModelResourcePrimKey() {
		return _modelResourcePrimKey;
	}

	@Override
	public void setModelResourcePrimKey(long modelResourcePrimKey) {
		_columnBitmask |= MODELRESOURCEPRIMKEY_COLUMN_BITMASK;

		if (!_setOriginalModelResourcePrimKey) {
			_setOriginalModelResourcePrimKey = true;

			_originalModelResourcePrimKey = _modelResourcePrimKey;
		}

		_modelResourcePrimKey = modelResourcePrimKey;
	}

	public long getOriginalModelResourcePrimKey() {
		return _originalModelResourcePrimKey;
	}

	@Override
	public int getChangeType() {
		return _changeType;
	}

	@Override
	public void setChangeType(int changeType) {
		_changeType = changeType;
	}

	@Override
	public boolean getCollision() {
		return _collision;
	}

	@Override
	public boolean isCollision() {
		return _collision;
	}

	@Override
	public void setCollision(boolean collision) {
		_collision = collision;
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_columnBitmask |= STATUS_COLUMN_BITMASK;

		if (!_setOriginalStatus) {
			_setOriginalStatus = true;

			_originalStatus = _status;
		}

		_status = status;
	}

	public int getOriginalStatus() {
		return _originalStatus;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), CTEntry.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CTEntry toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CTEntry>
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
		CTEntryImpl ctEntryImpl = new CTEntryImpl();

		ctEntryImpl.setMvccVersion(getMvccVersion());
		ctEntryImpl.setCtEntryId(getCtEntryId());
		ctEntryImpl.setCompanyId(getCompanyId());
		ctEntryImpl.setUserId(getUserId());
		ctEntryImpl.setCreateDate(getCreateDate());
		ctEntryImpl.setModifiedDate(getModifiedDate());
		ctEntryImpl.setCtCollectionId(getCtCollectionId());
		ctEntryImpl.setModelClassNameId(getModelClassNameId());
		ctEntryImpl.setModelClassPK(getModelClassPK());
		ctEntryImpl.setModelResourcePrimKey(getModelResourcePrimKey());
		ctEntryImpl.setChangeType(getChangeType());
		ctEntryImpl.setCollision(isCollision());
		ctEntryImpl.setStatus(getStatus());

		ctEntryImpl.resetOriginalValues();

		return ctEntryImpl;
	}

	@Override
	public int compareTo(CTEntry ctEntry) {
		long primaryKey = ctEntry.getPrimaryKey();

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

		if (!(obj instanceof CTEntry)) {
			return false;
		}

		CTEntry ctEntry = (CTEntry)obj;

		long primaryKey = ctEntry.getPrimaryKey();

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
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
	}

	@Override
	public void resetOriginalValues() {
		CTEntryModelImpl ctEntryModelImpl = this;

		ctEntryModelImpl._setModifiedDate = false;

		ctEntryModelImpl._originalCtCollectionId =
			ctEntryModelImpl._ctCollectionId;

		ctEntryModelImpl._setOriginalCtCollectionId = false;

		ctEntryModelImpl._originalModelClassNameId =
			ctEntryModelImpl._modelClassNameId;

		ctEntryModelImpl._setOriginalModelClassNameId = false;

		ctEntryModelImpl._originalModelClassPK = ctEntryModelImpl._modelClassPK;

		ctEntryModelImpl._setOriginalModelClassPK = false;

		ctEntryModelImpl._originalModelResourcePrimKey =
			ctEntryModelImpl._modelResourcePrimKey;

		ctEntryModelImpl._setOriginalModelResourcePrimKey = false;

		ctEntryModelImpl._originalStatus = ctEntryModelImpl._status;

		ctEntryModelImpl._setOriginalStatus = false;

		ctEntryModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CTEntry> toCacheModel() {
		CTEntryCacheModel ctEntryCacheModel = new CTEntryCacheModel();

		ctEntryCacheModel.mvccVersion = getMvccVersion();

		ctEntryCacheModel.ctEntryId = getCtEntryId();

		ctEntryCacheModel.companyId = getCompanyId();

		ctEntryCacheModel.userId = getUserId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			ctEntryCacheModel.createDate = createDate.getTime();
		}
		else {
			ctEntryCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			ctEntryCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			ctEntryCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		ctEntryCacheModel.ctCollectionId = getCtCollectionId();

		ctEntryCacheModel.modelClassNameId = getModelClassNameId();

		ctEntryCacheModel.modelClassPK = getModelClassPK();

		ctEntryCacheModel.modelResourcePrimKey = getModelResourcePrimKey();

		ctEntryCacheModel.changeType = getChangeType();

		ctEntryCacheModel.collision = isCollision();

		ctEntryCacheModel.status = getStatus();

		return ctEntryCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CTEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CTEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CTEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((CTEntry)this));
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
		Map<String, Function<CTEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CTEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CTEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((CTEntry)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, CTEntry>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _mvccVersion;
	private long _ctEntryId;
	private long _companyId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _ctCollectionId;
	private long _originalCtCollectionId;
	private boolean _setOriginalCtCollectionId;
	private long _modelClassNameId;
	private long _originalModelClassNameId;
	private boolean _setOriginalModelClassNameId;
	private long _modelClassPK;
	private long _originalModelClassPK;
	private boolean _setOriginalModelClassPK;
	private long _modelResourcePrimKey;
	private long _originalModelResourcePrimKey;
	private boolean _setOriginalModelResourcePrimKey;
	private int _changeType;
	private boolean _collision;
	private int _status;
	private int _originalStatus;
	private boolean _setOriginalStatus;
	private long _columnBitmask;
	private CTEntry _escapedModel;

}