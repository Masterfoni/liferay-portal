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

package com.liferay.change.tracking.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CTEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CTEntry
 * @generated
 */
public class CTEntryWrapper
	extends BaseModelWrapper<CTEntry>
	implements CTEntry, ModelWrapper<CTEntry> {

	public CTEntryWrapper(CTEntry ctEntry) {
		super(ctEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("ctEntryId", getCtEntryId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("ctCollectionId", getCtCollectionId());
		attributes.put("modelClassNameId", getModelClassNameId());
		attributes.put("modelClassPK", getModelClassPK());
		attributes.put("modelResourcePrimKey", getModelResourcePrimKey());
		attributes.put("changeType", getChangeType());
		attributes.put("collision", isCollision());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mvccVersion = (Long)attributes.get("mvccVersion");

		if (mvccVersion != null) {
			setMvccVersion(mvccVersion);
		}

		Long ctEntryId = (Long)attributes.get("ctEntryId");

		if (ctEntryId != null) {
			setCtEntryId(ctEntryId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long ctCollectionId = (Long)attributes.get("ctCollectionId");

		if (ctCollectionId != null) {
			setCtCollectionId(ctCollectionId);
		}

		Long modelClassNameId = (Long)attributes.get("modelClassNameId");

		if (modelClassNameId != null) {
			setModelClassNameId(modelClassNameId);
		}

		Long modelClassPK = (Long)attributes.get("modelClassPK");

		if (modelClassPK != null) {
			setModelClassPK(modelClassPK);
		}

		Long modelResourcePrimKey = (Long)attributes.get(
			"modelResourcePrimKey");

		if (modelResourcePrimKey != null) {
			setModelResourcePrimKey(modelResourcePrimKey);
		}

		Integer changeType = (Integer)attributes.get("changeType");

		if (changeType != null) {
			setChangeType(changeType);
		}

		Boolean collision = (Boolean)attributes.get("collision");

		if (collision != null) {
			setCollision(collision);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	 * Returns the change type of this ct entry.
	 *
	 * @return the change type of this ct entry
	 */
	@Override
	public int getChangeType() {
		return model.getChangeType();
	}

	/**
	 * Returns the collision of this ct entry.
	 *
	 * @return the collision of this ct entry
	 */
	@Override
	public boolean getCollision() {
		return model.getCollision();
	}

	/**
	 * Returns the company ID of this ct entry.
	 *
	 * @return the company ID of this ct entry
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this ct entry.
	 *
	 * @return the create date of this ct entry
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the ct collection ID of this ct entry.
	 *
	 * @return the ct collection ID of this ct entry
	 */
	@Override
	public long getCtCollectionId() {
		return model.getCtCollectionId();
	}

	/**
	 * Returns the ct entry ID of this ct entry.
	 *
	 * @return the ct entry ID of this ct entry
	 */
	@Override
	public long getCtEntryId() {
		return model.getCtEntryId();
	}

	/**
	 * Returns the model class name ID of this ct entry.
	 *
	 * @return the model class name ID of this ct entry
	 */
	@Override
	public long getModelClassNameId() {
		return model.getModelClassNameId();
	}

	/**
	 * Returns the model class pk of this ct entry.
	 *
	 * @return the model class pk of this ct entry
	 */
	@Override
	public long getModelClassPK() {
		return model.getModelClassPK();
	}

	/**
	 * Returns the model resource prim key of this ct entry.
	 *
	 * @return the model resource prim key of this ct entry
	 */
	@Override
	public long getModelResourcePrimKey() {
		return model.getModelResourcePrimKey();
	}

	/**
	 * Returns the modified date of this ct entry.
	 *
	 * @return the modified date of this ct entry
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the mvcc version of this ct entry.
	 *
	 * @return the mvcc version of this ct entry
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the primary key of this ct entry.
	 *
	 * @return the primary key of this ct entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this ct entry.
	 *
	 * @return the status of this ct entry
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the user ID of this ct entry.
	 *
	 * @return the user ID of this ct entry
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this ct entry.
	 *
	 * @return the user uuid of this ct entry
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this ct entry is collision.
	 *
	 * @return <code>true</code> if this ct entry is collision; <code>false</code> otherwise
	 */
	@Override
	public boolean isCollision() {
		return model.isCollision();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the change type of this ct entry.
	 *
	 * @param changeType the change type of this ct entry
	 */
	@Override
	public void setChangeType(int changeType) {
		model.setChangeType(changeType);
	}

	/**
	 * Sets whether this ct entry is collision.
	 *
	 * @param collision the collision of this ct entry
	 */
	@Override
	public void setCollision(boolean collision) {
		model.setCollision(collision);
	}

	/**
	 * Sets the company ID of this ct entry.
	 *
	 * @param companyId the company ID of this ct entry
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this ct entry.
	 *
	 * @param createDate the create date of this ct entry
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the ct collection ID of this ct entry.
	 *
	 * @param ctCollectionId the ct collection ID of this ct entry
	 */
	@Override
	public void setCtCollectionId(long ctCollectionId) {
		model.setCtCollectionId(ctCollectionId);
	}

	/**
	 * Sets the ct entry ID of this ct entry.
	 *
	 * @param ctEntryId the ct entry ID of this ct entry
	 */
	@Override
	public void setCtEntryId(long ctEntryId) {
		model.setCtEntryId(ctEntryId);
	}

	/**
	 * Sets the model class name ID of this ct entry.
	 *
	 * @param modelClassNameId the model class name ID of this ct entry
	 */
	@Override
	public void setModelClassNameId(long modelClassNameId) {
		model.setModelClassNameId(modelClassNameId);
	}

	/**
	 * Sets the model class pk of this ct entry.
	 *
	 * @param modelClassPK the model class pk of this ct entry
	 */
	@Override
	public void setModelClassPK(long modelClassPK) {
		model.setModelClassPK(modelClassPK);
	}

	/**
	 * Sets the model resource prim key of this ct entry.
	 *
	 * @param modelResourcePrimKey the model resource prim key of this ct entry
	 */
	@Override
	public void setModelResourcePrimKey(long modelResourcePrimKey) {
		model.setModelResourcePrimKey(modelResourcePrimKey);
	}

	/**
	 * Sets the modified date of this ct entry.
	 *
	 * @param modifiedDate the modified date of this ct entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the mvcc version of this ct entry.
	 *
	 * @param mvccVersion the mvcc version of this ct entry
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the primary key of this ct entry.
	 *
	 * @param primaryKey the primary key of this ct entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this ct entry.
	 *
	 * @param status the status of this ct entry
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the user ID of this ct entry.
	 *
	 * @param userId the user ID of this ct entry
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this ct entry.
	 *
	 * @param userUuid the user uuid of this ct entry
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected CTEntryWrapper wrap(CTEntry ctEntry) {
		return new CTEntryWrapper(ctEntry);
	}

}