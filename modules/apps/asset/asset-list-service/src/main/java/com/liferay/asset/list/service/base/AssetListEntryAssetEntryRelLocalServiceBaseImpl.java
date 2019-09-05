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

package com.liferay.asset.list.service.base;

import com.liferay.asset.list.model.AssetListEntryAssetEntryRel;
import com.liferay.asset.list.service.AssetListEntryAssetEntryRelLocalService;
import com.liferay.asset.list.service.persistence.AssetListEntryAssetEntryRelPersistence;
import com.liferay.exportimport.kernel.lar.ExportImportHelperUtil;
import com.liferay.exportimport.kernel.lar.ManifestSummary;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the asset list entry asset entry rel local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.asset.list.service.impl.AssetListEntryAssetEntryRelLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.asset.list.service.impl.AssetListEntryAssetEntryRelLocalServiceImpl
 * @generated
 */
public abstract class AssetListEntryAssetEntryRelLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AssetListEntryAssetEntryRelLocalService, AopService,
			   IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>AssetListEntryAssetEntryRelLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.asset.list.service.AssetListEntryAssetEntryRelLocalServiceUtil</code>.
	 */

	/**
	 * Adds the asset list entry asset entry rel to the database. Also notifies the appropriate model listeners.
	 *
	 * @param assetListEntryAssetEntryRel the asset list entry asset entry rel
	 * @return the asset list entry asset entry rel that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public AssetListEntryAssetEntryRel addAssetListEntryAssetEntryRel(
		AssetListEntryAssetEntryRel assetListEntryAssetEntryRel) {

		assetListEntryAssetEntryRel.setNew(true);

		return assetListEntryAssetEntryRelPersistence.update(
			assetListEntryAssetEntryRel);
	}

	/**
	 * Creates a new asset list entry asset entry rel with the primary key. Does not add the asset list entry asset entry rel to the database.
	 *
	 * @param assetListEntryAssetEntryRelId the primary key for the new asset list entry asset entry rel
	 * @return the new asset list entry asset entry rel
	 */
	@Override
	@Transactional(enabled = false)
	public AssetListEntryAssetEntryRel createAssetListEntryAssetEntryRel(
		long assetListEntryAssetEntryRelId) {

		return assetListEntryAssetEntryRelPersistence.create(
			assetListEntryAssetEntryRelId);
	}

	/**
	 * Deletes the asset list entry asset entry rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param assetListEntryAssetEntryRelId the primary key of the asset list entry asset entry rel
	 * @return the asset list entry asset entry rel that was removed
	 * @throws PortalException if a asset list entry asset entry rel with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public AssetListEntryAssetEntryRel deleteAssetListEntryAssetEntryRel(
			long assetListEntryAssetEntryRelId)
		throws PortalException {

		return assetListEntryAssetEntryRelPersistence.remove(
			assetListEntryAssetEntryRelId);
	}

	/**
	 * Deletes the asset list entry asset entry rel from the database. Also notifies the appropriate model listeners.
	 *
	 * @param assetListEntryAssetEntryRel the asset list entry asset entry rel
	 * @return the asset list entry asset entry rel that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public AssetListEntryAssetEntryRel deleteAssetListEntryAssetEntryRel(
		AssetListEntryAssetEntryRel assetListEntryAssetEntryRel) {

		return assetListEntryAssetEntryRelPersistence.remove(
			assetListEntryAssetEntryRel);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			AssetListEntryAssetEntryRel.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return assetListEntryAssetEntryRelPersistence.findWithDynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.asset.list.model.impl.AssetListEntryAssetEntryRelModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return assetListEntryAssetEntryRelPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.asset.list.model.impl.AssetListEntryAssetEntryRelModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return assetListEntryAssetEntryRelPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return assetListEntryAssetEntryRelPersistence.countWithDynamicQuery(
			dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection) {

		return assetListEntryAssetEntryRelPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public AssetListEntryAssetEntryRel fetchAssetListEntryAssetEntryRel(
		long assetListEntryAssetEntryRelId) {

		return assetListEntryAssetEntryRelPersistence.fetchByPrimaryKey(
			assetListEntryAssetEntryRelId);
	}

	/**
	 * Returns the asset list entry asset entry rel matching the UUID and group.
	 *
	 * @param uuid the asset list entry asset entry rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching asset list entry asset entry rel, or <code>null</code> if a matching asset list entry asset entry rel could not be found
	 */
	@Override
	public AssetListEntryAssetEntryRel
		fetchAssetListEntryAssetEntryRelByUuidAndGroupId(
			String uuid, long groupId) {

		return assetListEntryAssetEntryRelPersistence.fetchByUUID_G(
			uuid, groupId);
	}

	/**
	 * Returns the asset list entry asset entry rel with the primary key.
	 *
	 * @param assetListEntryAssetEntryRelId the primary key of the asset list entry asset entry rel
	 * @return the asset list entry asset entry rel
	 * @throws PortalException if a asset list entry asset entry rel with the primary key could not be found
	 */
	@Override
	public AssetListEntryAssetEntryRel getAssetListEntryAssetEntryRel(
			long assetListEntryAssetEntryRelId)
		throws PortalException {

		return assetListEntryAssetEntryRelPersistence.findByPrimaryKey(
			assetListEntryAssetEntryRelId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			assetListEntryAssetEntryRelLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(AssetListEntryAssetEntryRel.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"assetListEntryAssetEntryRelId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			assetListEntryAssetEntryRelLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(
			AssetListEntryAssetEntryRel.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"assetListEntryAssetEntryRelId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			assetListEntryAssetEntryRelLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(AssetListEntryAssetEntryRel.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"assetListEntryAssetEntryRelId");
	}

	@Override
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		final PortletDataContext portletDataContext) {

		final ExportActionableDynamicQuery exportActionableDynamicQuery =
			new ExportActionableDynamicQuery() {

				@Override
				public long performCount() throws PortalException {
					ManifestSummary manifestSummary =
						portletDataContext.getManifestSummary();

					StagedModelType stagedModelType = getStagedModelType();

					long modelAdditionCount = super.performCount();

					manifestSummary.addModelAdditionCount(
						stagedModelType, modelAdditionCount);

					long modelDeletionCount =
						ExportImportHelperUtil.getModelDeletionCount(
							portletDataContext, stagedModelType);

					manifestSummary.addModelDeletionCount(
						stagedModelType, modelDeletionCount);

					return modelAdditionCount;
				}

			};

		initActionableDynamicQuery(exportActionableDynamicQuery);

		exportActionableDynamicQuery.setAddCriteriaMethod(
			new ActionableDynamicQuery.AddCriteriaMethod() {

				@Override
				public void addCriteria(DynamicQuery dynamicQuery) {
					portletDataContext.addDateRangeCriteria(
						dynamicQuery, "modifiedDate");
				}

			});

		exportActionableDynamicQuery.setCompanyId(
			portletDataContext.getCompanyId());

		exportActionableDynamicQuery.setGroupId(
			portletDataContext.getScopeGroupId());

		exportActionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<AssetListEntryAssetEntryRel>() {

				@Override
				public void performAction(
						AssetListEntryAssetEntryRel assetListEntryAssetEntryRel)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, assetListEntryAssetEntryRel);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(
					AssetListEntryAssetEntryRel.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return assetListEntryAssetEntryRelLocalService.
			deleteAssetListEntryAssetEntryRel(
				(AssetListEntryAssetEntryRel)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return assetListEntryAssetEntryRelPersistence.findByPrimaryKey(
			primaryKeyObj);
	}

	/**
	 * Returns all the asset list entry asset entry rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the asset list entry asset entry rels
	 * @param companyId the primary key of the company
	 * @return the matching asset list entry asset entry rels, or an empty list if no matches were found
	 */
	@Override
	public List<AssetListEntryAssetEntryRel>
		getAssetListEntryAssetEntryRelsByUuidAndCompanyId(
			String uuid, long companyId) {

		return assetListEntryAssetEntryRelPersistence.findByUuid_C(
			uuid, companyId);
	}

	/**
	 * Returns a range of asset list entry asset entry rels matching the UUID and company.
	 *
	 * @param uuid the UUID of the asset list entry asset entry rels
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of asset list entry asset entry rels
	 * @param end the upper bound of the range of asset list entry asset entry rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching asset list entry asset entry rels, or an empty list if no matches were found
	 */
	@Override
	public List<AssetListEntryAssetEntryRel>
		getAssetListEntryAssetEntryRelsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<AssetListEntryAssetEntryRel> orderByComparator) {

		return assetListEntryAssetEntryRelPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the asset list entry asset entry rel matching the UUID and group.
	 *
	 * @param uuid the asset list entry asset entry rel's UUID
	 * @param groupId the primary key of the group
	 * @return the matching asset list entry asset entry rel
	 * @throws PortalException if a matching asset list entry asset entry rel could not be found
	 */
	@Override
	public AssetListEntryAssetEntryRel
			getAssetListEntryAssetEntryRelByUuidAndGroupId(
				String uuid, long groupId)
		throws PortalException {

		return assetListEntryAssetEntryRelPersistence.findByUUID_G(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the asset list entry asset entry rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.asset.list.model.impl.AssetListEntryAssetEntryRelModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of asset list entry asset entry rels
	 * @param end the upper bound of the range of asset list entry asset entry rels (not inclusive)
	 * @return the range of asset list entry asset entry rels
	 */
	@Override
	public List<AssetListEntryAssetEntryRel> getAssetListEntryAssetEntryRels(
		int start, int end) {

		return assetListEntryAssetEntryRelPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of asset list entry asset entry rels.
	 *
	 * @return the number of asset list entry asset entry rels
	 */
	@Override
	public int getAssetListEntryAssetEntryRelsCount() {
		return assetListEntryAssetEntryRelPersistence.countAll();
	}

	/**
	 * Updates the asset list entry asset entry rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param assetListEntryAssetEntryRel the asset list entry asset entry rel
	 * @return the asset list entry asset entry rel that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public AssetListEntryAssetEntryRel updateAssetListEntryAssetEntryRel(
		AssetListEntryAssetEntryRel assetListEntryAssetEntryRel) {

		return assetListEntryAssetEntryRelPersistence.update(
			assetListEntryAssetEntryRel);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			AssetListEntryAssetEntryRelLocalService.class,
			IdentifiableOSGiService.class, PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		assetListEntryAssetEntryRelLocalService =
			(AssetListEntryAssetEntryRelLocalService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return AssetListEntryAssetEntryRelLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return AssetListEntryAssetEntryRel.class;
	}

	protected String getModelClassName() {
		return AssetListEntryAssetEntryRel.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				assetListEntryAssetEntryRelPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	protected AssetListEntryAssetEntryRelLocalService
		assetListEntryAssetEntryRelLocalService;

	@Reference
	protected AssetListEntryAssetEntryRelPersistence
		assetListEntryAssetEntryRelPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

}