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

package com.cscl.feedback.model.impl;

import com.cscl.feedback.model.Feedback;
import com.cscl.feedback.model.FeedbackModel;
import com.cscl.feedback.model.FeedbackSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model implementation for the Feedback service. Represents a row in the &quot;cscl_feedback&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>FeedbackModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FeedbackImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FeedbackImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class FeedbackModelImpl
	extends BaseModelImpl<Feedback> implements FeedbackModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a feedback model instance should use the <code>Feedback</code> interface instead.
	 */
	public static final String TABLE_NAME = "cscl_feedback";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"feedbackId", Types.BIGINT},
		{"createdById", Types.BIGINT}, {"createDate", Types.TIMESTAMP},
		{"name", Types.VARCHAR}, {"email", Types.VARCHAR},
		{"mobile", Types.VARCHAR}, {"comments", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("feedbackId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createdById", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("email", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("mobile", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("comments", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table cscl_feedback (uuid_ VARCHAR(75) null,feedbackId LONG not null primary key,createdById LONG,createDate DATE null,name VARCHAR(75) null,email VARCHAR(75) null,mobile VARCHAR(10) null,comments VARCHAR(500) null)";

	public static final String TABLE_SQL_DROP = "drop table cscl_feedback";

	public static final String ORDER_BY_JPQL =
		" ORDER BY feedback.createDate DESC";

	public static final String ORDER_BY_SQL =
		" ORDER BY cscl_feedback.createDate DESC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long UUID_COLUMN_BITMASK = 1L;

	public static final long CREATEDATE_COLUMN_BITMASK = 2L;

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Feedback toModel(FeedbackSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Feedback model = new FeedbackImpl();

		model.setUuid(soapModel.getUuid());
		model.setFeedbackId(soapModel.getFeedbackId());
		model.setCreatedById(soapModel.getCreatedById());
		model.setCreateDate(soapModel.getCreateDate());
		model.setName(soapModel.getName());
		model.setEmail(soapModel.getEmail());
		model.setMobile(soapModel.getMobile());
		model.setComments(soapModel.getComments());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Feedback> toModels(FeedbackSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Feedback> models = new ArrayList<Feedback>(soapModels.length);

		for (FeedbackSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public FeedbackModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _feedbackId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFeedbackId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _feedbackId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Feedback.class;
	}

	@Override
	public String getModelClassName() {
		return Feedback.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Feedback, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Feedback, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Feedback, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Feedback)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Feedback, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Feedback, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Feedback)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Feedback, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Feedback, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Feedback>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Feedback.class.getClassLoader(), Feedback.class,
			ModelWrapper.class);

		try {
			Constructor<Feedback> constructor =
				(Constructor<Feedback>)proxyClass.getConstructor(
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

	private static final Map<String, Function<Feedback, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Feedback, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Feedback, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Feedback, Object>>();
		Map<String, BiConsumer<Feedback, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Feedback, ?>>();

		attributeGetterFunctions.put("uuid", Feedback::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<Feedback, String>)Feedback::setUuid);
		attributeGetterFunctions.put("feedbackId", Feedback::getFeedbackId);
		attributeSetterBiConsumers.put(
			"feedbackId", (BiConsumer<Feedback, Long>)Feedback::setFeedbackId);
		attributeGetterFunctions.put("createdById", Feedback::getCreatedById);
		attributeSetterBiConsumers.put(
			"createdById",
			(BiConsumer<Feedback, Long>)Feedback::setCreatedById);
		attributeGetterFunctions.put("createDate", Feedback::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate", (BiConsumer<Feedback, Date>)Feedback::setCreateDate);
		attributeGetterFunctions.put("name", Feedback::getName);
		attributeSetterBiConsumers.put(
			"name", (BiConsumer<Feedback, String>)Feedback::setName);
		attributeGetterFunctions.put("email", Feedback::getEmail);
		attributeSetterBiConsumers.put(
			"email", (BiConsumer<Feedback, String>)Feedback::setEmail);
		attributeGetterFunctions.put("mobile", Feedback::getMobile);
		attributeSetterBiConsumers.put(
			"mobile", (BiConsumer<Feedback, String>)Feedback::setMobile);
		attributeGetterFunctions.put("comments", Feedback::getComments);
		attributeSetterBiConsumers.put(
			"comments", (BiConsumer<Feedback, String>)Feedback::setComments);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
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

	@JSON
	@Override
	public long getFeedbackId() {
		return _feedbackId;
	}

	@Override
	public void setFeedbackId(long feedbackId) {
		_feedbackId = feedbackId;
	}

	@JSON
	@Override
	public long getCreatedById() {
		return _createdById;
	}

	@Override
	public void setCreatedById(long createdById) {
		_createdById = createdById;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_columnBitmask = -1L;

		_createDate = createDate;
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_name = name;
	}

	@JSON
	@Override
	public String getEmail() {
		if (_email == null) {
			return "";
		}
		else {
			return _email;
		}
	}

	@Override
	public void setEmail(String email) {
		_email = email;
	}

	@JSON
	@Override
	public String getMobile() {
		if (_mobile == null) {
			return "";
		}
		else {
			return _mobile;
		}
	}

	@Override
	public void setMobile(String mobile) {
		_mobile = mobile;
	}

	@JSON
	@Override
	public String getComments() {
		if (_comments == null) {
			return "";
		}
		else {
			return _comments;
		}
	}

	@Override
	public void setComments(String comments) {
		_comments = comments;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, Feedback.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Feedback toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Feedback>
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
		FeedbackImpl feedbackImpl = new FeedbackImpl();

		feedbackImpl.setUuid(getUuid());
		feedbackImpl.setFeedbackId(getFeedbackId());
		feedbackImpl.setCreatedById(getCreatedById());
		feedbackImpl.setCreateDate(getCreateDate());
		feedbackImpl.setName(getName());
		feedbackImpl.setEmail(getEmail());
		feedbackImpl.setMobile(getMobile());
		feedbackImpl.setComments(getComments());

		feedbackImpl.resetOriginalValues();

		return feedbackImpl;
	}

	@Override
	public int compareTo(Feedback feedback) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), feedback.getCreateDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Feedback)) {
			return false;
		}

		Feedback feedback = (Feedback)obj;

		long primaryKey = feedback.getPrimaryKey();

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
		FeedbackModelImpl feedbackModelImpl = this;

		feedbackModelImpl._originalUuid = feedbackModelImpl._uuid;

		feedbackModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Feedback> toCacheModel() {
		FeedbackCacheModel feedbackCacheModel = new FeedbackCacheModel();

		feedbackCacheModel.uuid = getUuid();

		String uuid = feedbackCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			feedbackCacheModel.uuid = null;
		}

		feedbackCacheModel.feedbackId = getFeedbackId();

		feedbackCacheModel.createdById = getCreatedById();

		Date createDate = getCreateDate();

		if (createDate != null) {
			feedbackCacheModel.createDate = createDate.getTime();
		}
		else {
			feedbackCacheModel.createDate = Long.MIN_VALUE;
		}

		feedbackCacheModel.name = getName();

		String name = feedbackCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			feedbackCacheModel.name = null;
		}

		feedbackCacheModel.email = getEmail();

		String email = feedbackCacheModel.email;

		if ((email != null) && (email.length() == 0)) {
			feedbackCacheModel.email = null;
		}

		feedbackCacheModel.mobile = getMobile();

		String mobile = feedbackCacheModel.mobile;

		if ((mobile != null) && (mobile.length() == 0)) {
			feedbackCacheModel.mobile = null;
		}

		feedbackCacheModel.comments = getComments();

		String comments = feedbackCacheModel.comments;

		if ((comments != null) && (comments.length() == 0)) {
			feedbackCacheModel.comments = null;
		}

		return feedbackCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Feedback, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Feedback, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Feedback, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Feedback)this));
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
		Map<String, Function<Feedback, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Feedback, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Feedback, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Feedback)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Feedback>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private String _uuid;
	private String _originalUuid;
	private long _feedbackId;
	private long _createdById;
	private Date _createDate;
	private String _name;
	private String _email;
	private String _mobile;
	private String _comments;
	private long _columnBitmask;
	private Feedback _escapedModel;

}