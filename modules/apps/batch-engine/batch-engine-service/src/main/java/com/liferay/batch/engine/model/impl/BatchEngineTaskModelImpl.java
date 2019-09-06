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

package com.liferay.batch.engine.model.impl;

import com.liferay.batch.engine.model.BatchEngineTask;
import com.liferay.batch.engine.model.BatchEngineTaskContentBlobModel;
import com.liferay.batch.engine.model.BatchEngineTaskModel;
import com.liferay.batch.engine.service.BatchEngineTaskLocalServiceUtil;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the BatchEngineTask service. Represents a row in the &quot;BatchEngineTask&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>BatchEngineTaskModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link BatchEngineTaskImpl}.
 * </p>
 *
 * @author Shuyang Zhou
 * @see BatchEngineTaskImpl
 * @generated
 */
public class BatchEngineTaskModelImpl
	extends BaseModelImpl<BatchEngineTask> implements BatchEngineTaskModel {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a batch engine task model instance should use the <code>BatchEngineTask</code> interface instead.
	 */
	public static final String TABLE_NAME = "BatchEngineTask";

	public static final Object[][] TABLE_COLUMNS = {
		{"mvccVersion", Types.BIGINT}, {"uuid_", Types.VARCHAR},
		{"batchEngineTaskId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"batchSize", Types.BIGINT}, {"className", Types.VARCHAR},
		{"content", Types.BLOB}, {"contentType", Types.VARCHAR},
		{"endTime", Types.TIMESTAMP}, {"errorMessage", Types.VARCHAR},
		{"executeStatus", Types.VARCHAR}, {"operation", Types.VARCHAR},
		{"startTime", Types.TIMESTAMP}, {"version", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("batchEngineTaskId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("batchSize", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("className", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("content", Types.BLOB);
		TABLE_COLUMNS_MAP.put("contentType", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("endTime", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("errorMessage", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("executeStatus", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("operation", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("startTime", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("version", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table BatchEngineTask (mvccVersion LONG default 0 not null,uuid_ VARCHAR(75) null,batchEngineTaskId LONG not null primary key,companyId LONG,createDate DATE null,modifiedDate DATE null,batchSize LONG,className VARCHAR(75) null,content BLOB,contentType VARCHAR(75) null,endTime DATE null,errorMessage VARCHAR(75) null,executeStatus VARCHAR(75) null,operation VARCHAR(75) null,startTime DATE null,version VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table BatchEngineTask";

	public static final String ORDER_BY_JPQL =
		" ORDER BY batchEngineTask.batchEngineTaskId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY BatchEngineTask.batchEngineTaskId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	public static final long UUID_COLUMN_BITMASK = 2L;

	public static final long BATCHENGINETASKID_COLUMN_BITMASK = 4L;

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	public BatchEngineTaskModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _batchEngineTaskId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBatchEngineTaskId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _batchEngineTaskId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return BatchEngineTask.class;
	}

	@Override
	public String getModelClassName() {
		return BatchEngineTask.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<BatchEngineTask, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<BatchEngineTask, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<BatchEngineTask, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((BatchEngineTask)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<BatchEngineTask, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<BatchEngineTask, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(BatchEngineTask)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<BatchEngineTask, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<BatchEngineTask, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, BatchEngineTask>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			BatchEngineTask.class.getClassLoader(), BatchEngineTask.class,
			ModelWrapper.class);

		try {
			Constructor<BatchEngineTask> constructor =
				(Constructor<BatchEngineTask>)proxyClass.getConstructor(
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

	private static final Map<String, Function<BatchEngineTask, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<BatchEngineTask, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<BatchEngineTask, Object>>
			attributeGetterFunctions =
				new LinkedHashMap<String, Function<BatchEngineTask, Object>>();
		Map<String, BiConsumer<BatchEngineTask, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<BatchEngineTask, ?>>();

		attributeGetterFunctions.put(
			"mvccVersion", BatchEngineTask::getMvccVersion);
		attributeSetterBiConsumers.put(
			"mvccVersion",
			(BiConsumer<BatchEngineTask, Long>)BatchEngineTask::setMvccVersion);
		attributeGetterFunctions.put("uuid", BatchEngineTask::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<BatchEngineTask, String>)BatchEngineTask::setUuid);
		attributeGetterFunctions.put(
			"batchEngineTaskId", BatchEngineTask::getBatchEngineTaskId);
		attributeSetterBiConsumers.put(
			"batchEngineTaskId",
			(BiConsumer<BatchEngineTask, Long>)
				BatchEngineTask::setBatchEngineTaskId);
		attributeGetterFunctions.put(
			"companyId", BatchEngineTask::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<BatchEngineTask, Long>)BatchEngineTask::setCompanyId);
		attributeGetterFunctions.put(
			"createDate", BatchEngineTask::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<BatchEngineTask, Date>)BatchEngineTask::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", BatchEngineTask::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<BatchEngineTask, Date>)
				BatchEngineTask::setModifiedDate);
		attributeGetterFunctions.put(
			"batchSize", BatchEngineTask::getBatchSize);
		attributeSetterBiConsumers.put(
			"batchSize",
			(BiConsumer<BatchEngineTask, Long>)BatchEngineTask::setBatchSize);
		attributeGetterFunctions.put(
			"className", BatchEngineTask::getClassName);
		attributeSetterBiConsumers.put(
			"className",
			(BiConsumer<BatchEngineTask, String>)BatchEngineTask::setClassName);
		attributeGetterFunctions.put("content", BatchEngineTask::getContent);
		attributeSetterBiConsumers.put(
			"content",
			(BiConsumer<BatchEngineTask, Blob>)BatchEngineTask::setContent);
		attributeGetterFunctions.put(
			"contentType", BatchEngineTask::getContentType);
		attributeSetterBiConsumers.put(
			"contentType",
			(BiConsumer<BatchEngineTask, String>)
				BatchEngineTask::setContentType);
		attributeGetterFunctions.put("endTime", BatchEngineTask::getEndTime);
		attributeSetterBiConsumers.put(
			"endTime",
			(BiConsumer<BatchEngineTask, Date>)BatchEngineTask::setEndTime);
		attributeGetterFunctions.put(
			"errorMessage", BatchEngineTask::getErrorMessage);
		attributeSetterBiConsumers.put(
			"errorMessage",
			(BiConsumer<BatchEngineTask, String>)
				BatchEngineTask::setErrorMessage);
		attributeGetterFunctions.put(
			"executeStatus", BatchEngineTask::getExecuteStatus);
		attributeSetterBiConsumers.put(
			"executeStatus",
			(BiConsumer<BatchEngineTask, String>)
				BatchEngineTask::setExecuteStatus);
		attributeGetterFunctions.put(
			"operation", BatchEngineTask::getOperation);
		attributeSetterBiConsumers.put(
			"operation",
			(BiConsumer<BatchEngineTask, String>)BatchEngineTask::setOperation);
		attributeGetterFunctions.put(
			"startTime", BatchEngineTask::getStartTime);
		attributeSetterBiConsumers.put(
			"startTime",
			(BiConsumer<BatchEngineTask, Date>)BatchEngineTask::setStartTime);
		attributeGetterFunctions.put("version", BatchEngineTask::getVersion);
		attributeSetterBiConsumers.put(
			"version",
			(BiConsumer<BatchEngineTask, String>)BatchEngineTask::setVersion);

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
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		_columnBitmask |= UUID_COLUMN_BITMASK;

		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@Override
	public long getBatchEngineTaskId() {
		return _batchEngineTaskId;
	}

	@Override
	public void setBatchEngineTaskId(long batchEngineTaskId) {
		_batchEngineTaskId = batchEngineTaskId;
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
	public long getBatchSize() {
		return _batchSize;
	}

	@Override
	public void setBatchSize(long batchSize) {
		_batchSize = batchSize;
	}

	@Override
	public String getClassName() {
		if (_className == null) {
			return "";
		}
		else {
			return _className;
		}
	}

	@Override
	public void setClassName(String className) {
		_className = className;
	}

	@Override
	public Blob getContent() {
		if (_contentBlobModel == null) {
			try {
				_contentBlobModel =
					BatchEngineTaskLocalServiceUtil.getContentBlobModel(
						getPrimaryKey());
			}
			catch (Exception e) {
			}
		}

		Blob blob = null;

		if (_contentBlobModel != null) {
			blob = _contentBlobModel.getContentBlob();
		}

		return blob;
	}

	@Override
	public void setContent(Blob content) {
		if (_contentBlobModel == null) {
			_contentBlobModel = new BatchEngineTaskContentBlobModel(
				getPrimaryKey(), content);
		}
		else {
			_contentBlobModel.setContentBlob(content);
		}
	}

	@Override
	public String getContentType() {
		if (_contentType == null) {
			return "";
		}
		else {
			return _contentType;
		}
	}

	@Override
	public void setContentType(String contentType) {
		_contentType = contentType;
	}

	@Override
	public Date getEndTime() {
		return _endTime;
	}

	@Override
	public void setEndTime(Date endTime) {
		_endTime = endTime;
	}

	@Override
	public String getErrorMessage() {
		if (_errorMessage == null) {
			return "";
		}
		else {
			return _errorMessage;
		}
	}

	@Override
	public void setErrorMessage(String errorMessage) {
		_errorMessage = errorMessage;
	}

	@Override
	public String getExecuteStatus() {
		if (_executeStatus == null) {
			return "";
		}
		else {
			return _executeStatus;
		}
	}

	@Override
	public void setExecuteStatus(String executeStatus) {
		_executeStatus = executeStatus;
	}

	@Override
	public String getOperation() {
		if (_operation == null) {
			return "";
		}
		else {
			return _operation;
		}
	}

	@Override
	public void setOperation(String operation) {
		_operation = operation;
	}

	@Override
	public Date getStartTime() {
		return _startTime;
	}

	@Override
	public void setStartTime(Date startTime) {
		_startTime = startTime;
	}

	@Override
	public String getVersion() {
		if (_version == null) {
			return "";
		}
		else {
			return _version;
		}
	}

	@Override
	public void setVersion(String version) {
		_version = version;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(BatchEngineTask.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), BatchEngineTask.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public BatchEngineTask toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, BatchEngineTask>
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
		BatchEngineTaskImpl batchEngineTaskImpl = new BatchEngineTaskImpl();

		batchEngineTaskImpl.setMvccVersion(getMvccVersion());
		batchEngineTaskImpl.setUuid(getUuid());
		batchEngineTaskImpl.setBatchEngineTaskId(getBatchEngineTaskId());
		batchEngineTaskImpl.setCompanyId(getCompanyId());
		batchEngineTaskImpl.setCreateDate(getCreateDate());
		batchEngineTaskImpl.setModifiedDate(getModifiedDate());
		batchEngineTaskImpl.setBatchSize(getBatchSize());
		batchEngineTaskImpl.setClassName(getClassName());
		batchEngineTaskImpl.setContentType(getContentType());
		batchEngineTaskImpl.setEndTime(getEndTime());
		batchEngineTaskImpl.setErrorMessage(getErrorMessage());
		batchEngineTaskImpl.setExecuteStatus(getExecuteStatus());
		batchEngineTaskImpl.setOperation(getOperation());
		batchEngineTaskImpl.setStartTime(getStartTime());
		batchEngineTaskImpl.setVersion(getVersion());

		batchEngineTaskImpl.resetOriginalValues();

		return batchEngineTaskImpl;
	}

	@Override
	public int compareTo(BatchEngineTask batchEngineTask) {
		long primaryKey = batchEngineTask.getPrimaryKey();

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

		if (!(obj instanceof BatchEngineTask)) {
			return false;
		}

		BatchEngineTask batchEngineTask = (BatchEngineTask)obj;

		long primaryKey = batchEngineTask.getPrimaryKey();

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
		BatchEngineTaskModelImpl batchEngineTaskModelImpl = this;

		batchEngineTaskModelImpl._originalUuid = batchEngineTaskModelImpl._uuid;

		batchEngineTaskModelImpl._originalCompanyId =
			batchEngineTaskModelImpl._companyId;

		batchEngineTaskModelImpl._setOriginalCompanyId = false;

		batchEngineTaskModelImpl._setModifiedDate = false;

		batchEngineTaskModelImpl._contentBlobModel = null;

		batchEngineTaskModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<BatchEngineTask> toCacheModel() {
		BatchEngineTaskCacheModel batchEngineTaskCacheModel =
			new BatchEngineTaskCacheModel();

		batchEngineTaskCacheModel.mvccVersion = getMvccVersion();

		batchEngineTaskCacheModel.uuid = getUuid();

		String uuid = batchEngineTaskCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			batchEngineTaskCacheModel.uuid = null;
		}

		batchEngineTaskCacheModel.batchEngineTaskId = getBatchEngineTaskId();

		batchEngineTaskCacheModel.companyId = getCompanyId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			batchEngineTaskCacheModel.createDate = createDate.getTime();
		}
		else {
			batchEngineTaskCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			batchEngineTaskCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			batchEngineTaskCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		batchEngineTaskCacheModel.batchSize = getBatchSize();

		batchEngineTaskCacheModel.className = getClassName();

		String className = batchEngineTaskCacheModel.className;

		if ((className != null) && (className.length() == 0)) {
			batchEngineTaskCacheModel.className = null;
		}

		batchEngineTaskCacheModel.contentType = getContentType();

		String contentType = batchEngineTaskCacheModel.contentType;

		if ((contentType != null) && (contentType.length() == 0)) {
			batchEngineTaskCacheModel.contentType = null;
		}

		Date endTime = getEndTime();

		if (endTime != null) {
			batchEngineTaskCacheModel.endTime = endTime.getTime();
		}
		else {
			batchEngineTaskCacheModel.endTime = Long.MIN_VALUE;
		}

		batchEngineTaskCacheModel.errorMessage = getErrorMessage();

		String errorMessage = batchEngineTaskCacheModel.errorMessage;

		if ((errorMessage != null) && (errorMessage.length() == 0)) {
			batchEngineTaskCacheModel.errorMessage = null;
		}

		batchEngineTaskCacheModel.executeStatus = getExecuteStatus();

		String executeStatus = batchEngineTaskCacheModel.executeStatus;

		if ((executeStatus != null) && (executeStatus.length() == 0)) {
			batchEngineTaskCacheModel.executeStatus = null;
		}

		batchEngineTaskCacheModel.operation = getOperation();

		String operation = batchEngineTaskCacheModel.operation;

		if ((operation != null) && (operation.length() == 0)) {
			batchEngineTaskCacheModel.operation = null;
		}

		Date startTime = getStartTime();

		if (startTime != null) {
			batchEngineTaskCacheModel.startTime = startTime.getTime();
		}
		else {
			batchEngineTaskCacheModel.startTime = Long.MIN_VALUE;
		}

		batchEngineTaskCacheModel.version = getVersion();

		String version = batchEngineTaskCacheModel.version;

		if ((version != null) && (version.length() == 0)) {
			batchEngineTaskCacheModel.version = null;
		}

		return batchEngineTaskCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{mvccVersion=");
		sb.append(getMvccVersion());
		sb.append(", uuid=");
		sb.append(getUuid());
		sb.append(", batchEngineTaskId=");
		sb.append(getBatchEngineTaskId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", batchSize=");
		sb.append(getBatchSize());
		sb.append(", className=");
		sb.append(getClassName());
		sb.append(", contentType=");
		sb.append(getContentType());
		sb.append(", endTime=");
		sb.append(getEndTime());
		sb.append(", errorMessage=");
		sb.append(getErrorMessage());
		sb.append(", executeStatus=");
		sb.append(getExecuteStatus());
		sb.append(", operation=");
		sb.append(getOperation());
		sb.append(", startTime=");
		sb.append(getStartTime());
		sb.append(", version=");
		sb.append(getVersion());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(52);

		sb.append("<model><model-name>");
		sb.append("com.liferay.batch.engine.model.BatchEngineTask");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>mvccVersion</column-name><column-value><![CDATA[");
		sb.append(getMvccVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>batchEngineTaskId</column-name><column-value><![CDATA[");
		sb.append(getBatchEngineTaskId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>batchSize</column-name><column-value><![CDATA[");
		sb.append(getBatchSize());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>className</column-name><column-value><![CDATA[");
		sb.append(getClassName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contentType</column-name><column-value><![CDATA[");
		sb.append(getContentType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endTime</column-name><column-value><![CDATA[");
		sb.append(getEndTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>errorMessage</column-name><column-value><![CDATA[");
		sb.append(getErrorMessage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>executeStatus</column-name><column-value><![CDATA[");
		sb.append(getExecuteStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>operation</column-name><column-value><![CDATA[");
		sb.append(getOperation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startTime</column-name><column-value><![CDATA[");
		sb.append(getStartTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>version</column-name><column-value><![CDATA[");
		sb.append(getVersion());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, BatchEngineTask>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _mvccVersion;
	private String _uuid;
	private String _originalUuid;
	private long _batchEngineTaskId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _batchSize;
	private String _className;
	private BatchEngineTaskContentBlobModel _contentBlobModel;
	private String _contentType;
	private Date _endTime;
	private String _errorMessage;
	private String _executeStatus;
	private String _operation;
	private Date _startTime;
	private String _version;
	private long _columnBitmask;
	private BatchEngineTask _escapedModel;

}