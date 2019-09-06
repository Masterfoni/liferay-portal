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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.AuditedModel;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.MVCCModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.WorkflowedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the CTCollection service. Represents a row in the &quot;CTCollection&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.change.tracking.model.impl.CTCollectionModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.change.tracking.model.impl.CTCollectionImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CTCollection
 * @generated
 */
@ProviderType
public interface CTCollectionModel
	extends AuditedModel, BaseModel<CTCollection>, MVCCModel, ShardedModel,
			WorkflowedModel {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a ct collection model instance should use the {@link CTCollection} interface instead.
	 */

	/**
	 * Returns the primary key of this ct collection.
	 *
	 * @return the primary key of this ct collection
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this ct collection.
	 *
	 * @param primaryKey the primary key of this ct collection
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the mvcc version of this ct collection.
	 *
	 * @return the mvcc version of this ct collection
	 */
	@Override
	public long getMvccVersion();

	/**
	 * Sets the mvcc version of this ct collection.
	 *
	 * @param mvccVersion the mvcc version of this ct collection
	 */
	@Override
	public void setMvccVersion(long mvccVersion);

	/**
	 * Returns the ct collection ID of this ct collection.
	 *
	 * @return the ct collection ID of this ct collection
	 */
	public long getCtCollectionId();

	/**
	 * Sets the ct collection ID of this ct collection.
	 *
	 * @param ctCollectionId the ct collection ID of this ct collection
	 */
	public void setCtCollectionId(long ctCollectionId);

	/**
	 * Returns the company ID of this ct collection.
	 *
	 * @return the company ID of this ct collection
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this ct collection.
	 *
	 * @param companyId the company ID of this ct collection
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this ct collection.
	 *
	 * @return the user ID of this ct collection
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this ct collection.
	 *
	 * @param userId the user ID of this ct collection
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this ct collection.
	 *
	 * @return the user uuid of this ct collection
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this ct collection.
	 *
	 * @param userUuid the user uuid of this ct collection
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this ct collection.
	 *
	 * @return the user name of this ct collection
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this ct collection.
	 *
	 * @param userName the user name of this ct collection
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this ct collection.
	 *
	 * @return the create date of this ct collection
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this ct collection.
	 *
	 * @param createDate the create date of this ct collection
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this ct collection.
	 *
	 * @return the modified date of this ct collection
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this ct collection.
	 *
	 * @param modifiedDate the modified date of this ct collection
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the name of this ct collection.
	 *
	 * @return the name of this ct collection
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this ct collection.
	 *
	 * @param name the name of this ct collection
	 */
	public void setName(String name);

	/**
	 * Returns the description of this ct collection.
	 *
	 * @return the description of this ct collection
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this ct collection.
	 *
	 * @param description the description of this ct collection
	 */
	public void setDescription(String description);

	/**
	 * Returns the status of this ct collection.
	 *
	 * @return the status of this ct collection
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this ct collection.
	 *
	 * @param status the status of this ct collection
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this ct collection.
	 *
	 * @return the status by user ID of this ct collection
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this ct collection.
	 *
	 * @param statusByUserId the status by user ID of this ct collection
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this ct collection.
	 *
	 * @return the status by user uuid of this ct collection
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this ct collection.
	 *
	 * @param statusByUserUuid the status by user uuid of this ct collection
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this ct collection.
	 *
	 * @return the status by user name of this ct collection
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this ct collection.
	 *
	 * @param statusByUserName the status by user name of this ct collection
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this ct collection.
	 *
	 * @return the status date of this ct collection
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this ct collection.
	 *
	 * @param statusDate the status date of this ct collection
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns <code>true</code> if this ct collection is approved.
	 *
	 * @return <code>true</code> if this ct collection is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this ct collection is denied.
	 *
	 * @return <code>true</code> if this ct collection is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this ct collection is a draft.
	 *
	 * @return <code>true</code> if this ct collection is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this ct collection is expired.
	 *
	 * @return <code>true</code> if this ct collection is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this ct collection is inactive.
	 *
	 * @return <code>true</code> if this ct collection is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this ct collection is incomplete.
	 *
	 * @return <code>true</code> if this ct collection is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this ct collection is pending.
	 *
	 * @return <code>true</code> if this ct collection is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this ct collection is scheduled.
	 *
	 * @return <code>true</code> if this ct collection is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled();

}