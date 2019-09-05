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

package com.liferay.asset.list.model.impl;

import com.liferay.asset.list.model.AssetListEntryUsage;
import com.liferay.asset.list.service.AssetListEntryUsageLocalServiceUtil;

/**
 * The extended model base implementation for the AssetListEntryUsage service. Represents a row in the &quot;AssetListEntryUsage&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AssetListEntryUsageImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AssetListEntryUsageImpl
 * @see AssetListEntryUsage
 * @generated
 */
public abstract class AssetListEntryUsageBaseImpl
	extends AssetListEntryUsageModelImpl implements AssetListEntryUsage {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a asset list entry usage model instance should use the <code>AssetListEntryUsage</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			AssetListEntryUsageLocalServiceUtil.addAssetListEntryUsage(this);
		}
		else {
			AssetListEntryUsageLocalServiceUtil.updateAssetListEntryUsage(this);
		}
	}

}