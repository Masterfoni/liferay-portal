/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
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

package com.liferay.portlet.bookmarks.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.GroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the BookmarksFolder service. Represents a row in the &quot;BookmarksFolder&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portlet.bookmarks.model.impl.BookmarksFolderModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portlet.bookmarks.model.impl.BookmarksFolderImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BookmarksFolder
 * @see com.liferay.portlet.bookmarks.model.impl.BookmarksFolderImpl
 * @see com.liferay.portlet.bookmarks.model.impl.BookmarksFolderModelImpl
 * @generated
 */
public interface BookmarksFolderModel extends BaseModel<BookmarksFolder>,
	GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a bookmarks folder model instance should use the {@link BookmarksFolder} interface instead.
	 */

	/**
	 * Gets the primary key of this bookmarks folder.
	 *
	 * @return the primary key of this bookmarks folder
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this bookmarks folder
	 *
	 * @param primaryKey the primary key of this bookmarks folder
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Gets the uuid of this bookmarks folder.
	 *
	 * @return the uuid of this bookmarks folder
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this bookmarks folder.
	 *
	 * @param uuid the uuid of this bookmarks folder
	 */
	public void setUuid(String uuid);

	/**
	 * Gets the folder ID of this bookmarks folder.
	 *
	 * @return the folder ID of this bookmarks folder
	 */
	public long getFolderId();

	/**
	 * Sets the folder ID of this bookmarks folder.
	 *
	 * @param folderId the folder ID of this bookmarks folder
	 */
	public void setFolderId(long folderId);

	/**
	 * Gets the group ID of this bookmarks folder.
	 *
	 * @return the group ID of this bookmarks folder
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this bookmarks folder.
	 *
	 * @param groupId the group ID of this bookmarks folder
	 */
	public void setGroupId(long groupId);

	/**
	 * Gets the company ID of this bookmarks folder.
	 *
	 * @return the company ID of this bookmarks folder
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this bookmarks folder.
	 *
	 * @param companyId the company ID of this bookmarks folder
	 */
	public void setCompanyId(long companyId);

	/**
	 * Gets the user ID of this bookmarks folder.
	 *
	 * @return the user ID of this bookmarks folder
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this bookmarks folder.
	 *
	 * @param userId the user ID of this bookmarks folder
	 */
	public void setUserId(long userId);

	/**
	 * Gets the user uuid of this bookmarks folder.
	 *
	 * @return the user uuid of this bookmarks folder
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this bookmarks folder.
	 *
	 * @param userUuid the user uuid of this bookmarks folder
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Gets the user name of this bookmarks folder.
	 *
	 * @return the user name of this bookmarks folder
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this bookmarks folder.
	 *
	 * @param userName the user name of this bookmarks folder
	 */
	public void setUserName(String userName);

	/**
	 * Gets the create date of this bookmarks folder.
	 *
	 * @return the create date of this bookmarks folder
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this bookmarks folder.
	 *
	 * @param createDate the create date of this bookmarks folder
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Gets the modified date of this bookmarks folder.
	 *
	 * @return the modified date of this bookmarks folder
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this bookmarks folder.
	 *
	 * @param modifiedDate the modified date of this bookmarks folder
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Gets the parent folder ID of this bookmarks folder.
	 *
	 * @return the parent folder ID of this bookmarks folder
	 */
	public long getParentFolderId();

	/**
	 * Sets the parent folder ID of this bookmarks folder.
	 *
	 * @param parentFolderId the parent folder ID of this bookmarks folder
	 */
	public void setParentFolderId(long parentFolderId);

	/**
	 * Gets the name of this bookmarks folder.
	 *
	 * @return the name of this bookmarks folder
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this bookmarks folder.
	 *
	 * @param name the name of this bookmarks folder
	 */
	public void setName(String name);

	/**
	 * Gets the description of this bookmarks folder.
	 *
	 * @return the description of this bookmarks folder
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this bookmarks folder.
	 *
	 * @param description the description of this bookmarks folder
	 */
	public void setDescription(String description);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public void setEscapedModel(boolean escapedModel);

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(BookmarksFolder bookmarksFolder);

	public int hashCode();

	public BookmarksFolder toEscapedModel();

	public String toString();

	public String toXmlString();
}