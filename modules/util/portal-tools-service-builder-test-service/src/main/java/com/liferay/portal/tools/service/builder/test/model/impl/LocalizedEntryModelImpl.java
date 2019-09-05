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

package com.liferay.portal.tools.service.builder.test.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.tools.service.builder.test.model.LocalizedEntry;
import com.liferay.portal.tools.service.builder.test.model.LocalizedEntryLocalization;
import com.liferay.portal.tools.service.builder.test.model.LocalizedEntryModel;
import com.liferay.portal.tools.service.builder.test.service.LocalizedEntryLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the LocalizedEntry service. Represents a row in the &quot;LocalizedEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>LocalizedEntryModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LocalizedEntryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LocalizedEntryImpl
 * @generated
 */
public class LocalizedEntryModelImpl
	extends BaseModelImpl<LocalizedEntry> implements LocalizedEntryModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a localized entry model instance should use the <code>LocalizedEntry</code> interface instead.
	 */
	public static final String TABLE_NAME = "LocalizedEntry";

	public static final Object[][] TABLE_COLUMNS = {
		{"defaultLanguageId", Types.VARCHAR}, {"localizedEntryId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("defaultLanguageId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("localizedEntryId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table LocalizedEntry (defaultLanguageId VARCHAR(75) null,localizedEntryId LONG not null primary key)";

	public static final String TABLE_SQL_DROP = "drop table LocalizedEntry";

	public static final String ORDER_BY_JPQL =
		" ORDER BY localizedEntry.localizedEntryId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY LocalizedEntry.localizedEntryId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.tools.service.builder.test.service.util.ServiceProps.
			get(
				"value.object.entity.cache.enabled.com.liferay.portal.tools.service.builder.test.model.LocalizedEntry"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.tools.service.builder.test.service.util.ServiceProps.
			get(
				"value.object.finder.cache.enabled.com.liferay.portal.tools.service.builder.test.model.LocalizedEntry"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = false;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.portal.tools.service.builder.test.service.util.ServiceProps.
			get(
				"lock.expiration.time.com.liferay.portal.tools.service.builder.test.model.LocalizedEntry"));

	public LocalizedEntryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _localizedEntryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setLocalizedEntryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _localizedEntryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return LocalizedEntry.class;
	}

	@Override
	public String getModelClassName() {
		return LocalizedEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<LocalizedEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<LocalizedEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<LocalizedEntry, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((LocalizedEntry)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<LocalizedEntry, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<LocalizedEntry, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(LocalizedEntry)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<LocalizedEntry, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<LocalizedEntry, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, LocalizedEntry>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			LocalizedEntry.class.getClassLoader(), LocalizedEntry.class,
			ModelWrapper.class);

		try {
			Constructor<LocalizedEntry> constructor =
				(Constructor<LocalizedEntry>)proxyClass.getConstructor(
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

	private static final Map<String, Function<LocalizedEntry, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<LocalizedEntry, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<LocalizedEntry, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<LocalizedEntry, Object>>();
		Map<String, BiConsumer<LocalizedEntry, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<LocalizedEntry, ?>>();

		attributeGetterFunctions.put(
			"defaultLanguageId",
			new Function<LocalizedEntry, Object>() {

				@Override
				public Object apply(LocalizedEntry localizedEntry) {
					return localizedEntry.getDefaultLanguageId();
				}

			});
		attributeSetterBiConsumers.put(
			"defaultLanguageId",
			new BiConsumer<LocalizedEntry, Object>() {

				@Override
				public void accept(
					LocalizedEntry localizedEntry, Object defaultLanguageId) {

					localizedEntry.setDefaultLanguageId(
						(String)defaultLanguageId);
				}

			});
		attributeGetterFunctions.put(
			"localizedEntryId",
			new Function<LocalizedEntry, Object>() {

				@Override
				public Object apply(LocalizedEntry localizedEntry) {
					return localizedEntry.getLocalizedEntryId();
				}

			});
		attributeSetterBiConsumers.put(
			"localizedEntryId",
			new BiConsumer<LocalizedEntry, Object>() {

				@Override
				public void accept(
					LocalizedEntry localizedEntry, Object localizedEntryId) {

					localizedEntry.setLocalizedEntryId((Long)localizedEntryId);
				}

			});

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public String[] getAvailableLanguageIds() {
		List<LocalizedEntryLocalization> localizedEntryLocalizations =
			LocalizedEntryLocalServiceUtil.getLocalizedEntryLocalizations(
				getPrimaryKey());

		String[] availableLanguageIds =
			new String[localizedEntryLocalizations.size()];

		for (int i = 0; i < availableLanguageIds.length; i++) {
			LocalizedEntryLocalization localizedEntryLocalization =
				localizedEntryLocalizations.get(i);

			availableLanguageIds[i] =
				localizedEntryLocalization.getLanguageId();
		}

		return availableLanguageIds;
	}

	@Override
	public String getTitle() {
		return getTitle(getDefaultLanguageId(), false);
	}

	@Override
	public String getTitle(String languageId) {
		return getTitle(languageId, true);
	}

	@Override
	public String getTitle(String languageId, boolean useDefault) {
		if (useDefault) {
			return LocalizationUtil.getLocalization(
				new Function<String, String>() {

					@Override
					public String apply(String languageId) {
						return _getTitle(languageId);
					}

				},
				languageId, getDefaultLanguageId());
		}

		return _getTitle(languageId);
	}

	@Override
	public String getTitleMapAsXML() {
		return LocalizationUtil.getXml(
			getLanguageIdToTitleMap(), getDefaultLanguageId(), "Title");
	}

	@Override
	public Map<String, String> getLanguageIdToTitleMap() {
		Map<String, String> languageIdToTitleMap =
			new HashMap<String, String>();

		List<LocalizedEntryLocalization> localizedEntryLocalizations =
			LocalizedEntryLocalServiceUtil.getLocalizedEntryLocalizations(
				getPrimaryKey());

		for (LocalizedEntryLocalization localizedEntryLocalization :
				localizedEntryLocalizations) {

			languageIdToTitleMap.put(
				localizedEntryLocalization.getLanguageId(),
				localizedEntryLocalization.getTitle());
		}

		return languageIdToTitleMap;
	}

	private String _getTitle(String languageId) {
		LocalizedEntryLocalization localizedEntryLocalization =
			LocalizedEntryLocalServiceUtil.fetchLocalizedEntryLocalization(
				getPrimaryKey(), languageId);

		if (localizedEntryLocalization == null) {
			return "";
		}

		return localizedEntryLocalization.getTitle();
	}

	@Override
	public String getContent() {
		return getContent(getDefaultLanguageId(), false);
	}

	@Override
	public String getContent(String languageId) {
		return getContent(languageId, true);
	}

	@Override
	public String getContent(String languageId, boolean useDefault) {
		if (useDefault) {
			return LocalizationUtil.getLocalization(
				new Function<String, String>() {

					@Override
					public String apply(String languageId) {
						return _getContent(languageId);
					}

				},
				languageId, getDefaultLanguageId());
		}

		return _getContent(languageId);
	}

	@Override
	public String getContentMapAsXML() {
		return LocalizationUtil.getXml(
			getLanguageIdToContentMap(), getDefaultLanguageId(), "Content");
	}

	@Override
	public Map<String, String> getLanguageIdToContentMap() {
		Map<String, String> languageIdToContentMap =
			new HashMap<String, String>();

		List<LocalizedEntryLocalization> localizedEntryLocalizations =
			LocalizedEntryLocalServiceUtil.getLocalizedEntryLocalizations(
				getPrimaryKey());

		for (LocalizedEntryLocalization localizedEntryLocalization :
				localizedEntryLocalizations) {

			languageIdToContentMap.put(
				localizedEntryLocalization.getLanguageId(),
				localizedEntryLocalization.getContent());
		}

		return languageIdToContentMap;
	}

	private String _getContent(String languageId) {
		LocalizedEntryLocalization localizedEntryLocalization =
			LocalizedEntryLocalServiceUtil.fetchLocalizedEntryLocalization(
				getPrimaryKey(), languageId);

		if (localizedEntryLocalization == null) {
			return "";
		}

		return localizedEntryLocalization.getContent();
	}

	@Override
	public String getDefaultLanguageId() {
		if (_defaultLanguageId == null) {
			return "";
		}
		else {
			return _defaultLanguageId;
		}
	}

	@Override
	public void setDefaultLanguageId(String defaultLanguageId) {
		_defaultLanguageId = defaultLanguageId;
	}

	@Override
	public long getLocalizedEntryId() {
		return _localizedEntryId;
	}

	@Override
	public void setLocalizedEntryId(long localizedEntryId) {
		_localizedEntryId = localizedEntryId;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, LocalizedEntry.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public LocalizedEntry toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, LocalizedEntry>
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
		LocalizedEntryImpl localizedEntryImpl = new LocalizedEntryImpl();

		localizedEntryImpl.setDefaultLanguageId(getDefaultLanguageId());
		localizedEntryImpl.setLocalizedEntryId(getLocalizedEntryId());

		localizedEntryImpl.resetOriginalValues();

		return localizedEntryImpl;
	}

	@Override
	public int compareTo(LocalizedEntry localizedEntry) {
		long primaryKey = localizedEntry.getPrimaryKey();

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

		if (!(obj instanceof LocalizedEntry)) {
			return false;
		}

		LocalizedEntry localizedEntry = (LocalizedEntry)obj;

		long primaryKey = localizedEntry.getPrimaryKey();

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
	}

	@Override
	public CacheModel<LocalizedEntry> toCacheModel() {
		LocalizedEntryCacheModel localizedEntryCacheModel =
			new LocalizedEntryCacheModel();

		localizedEntryCacheModel.defaultLanguageId = getDefaultLanguageId();

		String defaultLanguageId = localizedEntryCacheModel.defaultLanguageId;

		if ((defaultLanguageId != null) && (defaultLanguageId.length() == 0)) {
			localizedEntryCacheModel.defaultLanguageId = null;
		}

		localizedEntryCacheModel.localizedEntryId = getLocalizedEntryId();

		return localizedEntryCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<LocalizedEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<LocalizedEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<LocalizedEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((LocalizedEntry)this));
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
		Map<String, Function<LocalizedEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<LocalizedEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<LocalizedEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((LocalizedEntry)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, LocalizedEntry>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _defaultLanguageId;
	private long _localizedEntryId;
	private LocalizedEntry _escapedModel;

}