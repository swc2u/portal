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

package cscl.appointment.booking.service.base;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
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

import cscl.appointment.booking.model.CsclApproverMapping;
import cscl.appointment.booking.service.CsclApproverMappingLocalService;
import cscl.appointment.booking.service.persistence.CsclApproverMappingPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the cscl approver mapping local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link cscl.appointment.booking.service.impl.CsclApproverMappingLocalServiceImpl}.
 * </p>
 *
 * @author @rnab
 * @see cscl.appointment.booking.service.impl.CsclApproverMappingLocalServiceImpl
 * @generated
 */
@ProviderType
public abstract class CsclApproverMappingLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements CsclApproverMappingLocalService, AopService,
			   IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>CsclApproverMappingLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>cscl.appointment.booking.service.CsclApproverMappingLocalServiceUtil</code>.
	 */

	/**
	 * Adds the cscl approver mapping to the database. Also notifies the appropriate model listeners.
	 *
	 * @param csclApproverMapping the cscl approver mapping
	 * @return the cscl approver mapping that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CsclApproverMapping addCsclApproverMapping(
		CsclApproverMapping csclApproverMapping) {

		csclApproverMapping.setNew(true);

		return csclApproverMappingPersistence.update(csclApproverMapping);
	}

	/**
	 * Creates a new cscl approver mapping with the primary key. Does not add the cscl approver mapping to the database.
	 *
	 * @param id_ the primary key for the new cscl approver mapping
	 * @return the new cscl approver mapping
	 */
	@Override
	@Transactional(enabled = false)
	public CsclApproverMapping createCsclApproverMapping(long id_) {
		return csclApproverMappingPersistence.create(id_);
	}

	/**
	 * Deletes the cscl approver mapping with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_ the primary key of the cscl approver mapping
	 * @return the cscl approver mapping that was removed
	 * @throws PortalException if a cscl approver mapping with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CsclApproverMapping deleteCsclApproverMapping(long id_)
		throws PortalException {

		return csclApproverMappingPersistence.remove(id_);
	}

	/**
	 * Deletes the cscl approver mapping from the database. Also notifies the appropriate model listeners.
	 *
	 * @param csclApproverMapping the cscl approver mapping
	 * @return the cscl approver mapping that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CsclApproverMapping deleteCsclApproverMapping(
		CsclApproverMapping csclApproverMapping) {

		return csclApproverMappingPersistence.remove(csclApproverMapping);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			CsclApproverMapping.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return csclApproverMappingPersistence.findWithDynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>cscl.appointment.booking.model.impl.CsclApproverMappingModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return csclApproverMappingPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>cscl.appointment.booking.model.impl.CsclApproverMappingModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return csclApproverMappingPersistence.findWithDynamicQuery(
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
		return csclApproverMappingPersistence.countWithDynamicQuery(
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

		return csclApproverMappingPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public CsclApproverMapping fetchCsclApproverMapping(long id_) {
		return csclApproverMappingPersistence.fetchByPrimaryKey(id_);
	}

	/**
	 * Returns the cscl approver mapping with the primary key.
	 *
	 * @param id_ the primary key of the cscl approver mapping
	 * @return the cscl approver mapping
	 * @throws PortalException if a cscl approver mapping with the primary key could not be found
	 */
	@Override
	public CsclApproverMapping getCsclApproverMapping(long id_)
		throws PortalException {

		return csclApproverMappingPersistence.findByPrimaryKey(id_);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			csclApproverMappingLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(CsclApproverMapping.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("id_");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			csclApproverMappingLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(
			CsclApproverMapping.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("id_");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			csclApproverMappingLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(CsclApproverMapping.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("id_");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return csclApproverMappingLocalService.deleteCsclApproverMapping(
			(CsclApproverMapping)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return csclApproverMappingPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the cscl approver mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>cscl.appointment.booking.model.impl.CsclApproverMappingModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl approver mappings
	 * @param end the upper bound of the range of cscl approver mappings (not inclusive)
	 * @return the range of cscl approver mappings
	 */
	@Override
	public List<CsclApproverMapping> getCsclApproverMappings(
		int start, int end) {

		return csclApproverMappingPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of cscl approver mappings.
	 *
	 * @return the number of cscl approver mappings
	 */
	@Override
	public int getCsclApproverMappingsCount() {
		return csclApproverMappingPersistence.countAll();
	}

	/**
	 * Updates the cscl approver mapping in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param csclApproverMapping the cscl approver mapping
	 * @return the cscl approver mapping that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CsclApproverMapping updateCsclApproverMapping(
		CsclApproverMapping csclApproverMapping) {

		return csclApproverMappingPersistence.update(csclApproverMapping);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			CsclApproverMappingLocalService.class,
			IdentifiableOSGiService.class, PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		csclApproverMappingLocalService =
			(CsclApproverMappingLocalService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return CsclApproverMappingLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return CsclApproverMapping.class;
	}

	protected String getModelClassName() {
		return CsclApproverMapping.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				csclApproverMappingPersistence.getDataSource();

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

	protected CsclApproverMappingLocalService csclApproverMappingLocalService;

	@Reference
	protected CsclApproverMappingPersistence csclApproverMappingPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

}