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

package com.liferay.portal.tools.service.builder.test.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Map;

/**
 * The base model interface for the LocalizedEntry service. Represents a row in the &quot;LocalizedEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.portal.tools.service.builder.test.model.impl.LocalizedEntryModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.portal.tools.service.builder.test.model.impl.LocalizedEntryImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LocalizedEntry
 * @generated
 */
@ProviderType
public interface LocalizedEntryModel extends BaseModel<LocalizedEntry> {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a localized entry model instance should use the {@link LocalizedEntry} interface instead.
	 */

	/**
	 * Returns the primary key of this localized entry.
	 *
	 * @return the primary key of this localized entry
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this localized entry.
	 *
	 * @param primaryKey the primary key of this localized entry
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the default language ID of this localized entry.
	 *
	 * @return the default language ID of this localized entry
	 */
	@AutoEscape
	public String getDefaultLanguageId();

	/**
	 * Sets the default language ID of this localized entry.
	 *
	 * @param defaultLanguageId the default language ID of this localized entry
	 */
	public void setDefaultLanguageId(String defaultLanguageId);

	/**
	 * Returns the localized entry ID of this localized entry.
	 *
	 * @return the localized entry ID of this localized entry
	 */
	public long getLocalizedEntryId();

	/**
	 * Sets the localized entry ID of this localized entry.
	 *
	 * @param localizedEntryId the localized entry ID of this localized entry
	 */
	public void setLocalizedEntryId(long localizedEntryId);

	public String[] getAvailableLanguageIds();

	public String getTitle();

	public String getTitle(String languageId);

	public String getTitle(String languageId, boolean useDefault);

	public String getTitleMapAsXML();

	public Map<String, String> getLanguageIdToTitleMap();

	public String getContent();

	public String getContent(String languageId);

	public String getContent(String languageId, boolean useDefault);

	public String getContentMapAsXML();

	public Map<String, String> getLanguageIdToContentMap();

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(LocalizedEntry localizedEntry);

	@Override
	public int hashCode();

	@Override
	public CacheModel<LocalizedEntry> toCacheModel();

	@Override
	public LocalizedEntry toEscapedModel();

	@Override
	public LocalizedEntry toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();

}