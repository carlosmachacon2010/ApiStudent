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

package com.liferay.training.students.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.training.students.model.Student;
import com.liferay.training.students.model.StudentModel;
import com.liferay.training.students.model.StudentSoap;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Student service. Represents a row in the &quot;Training_Student&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>StudentModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link StudentImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StudentImpl
 * @generated
 */
@JSON(strict = true)
public class StudentModelImpl
	extends BaseModelImpl<Student> implements StudentModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a student model instance should use the <code>Student</code> interface instead.
	 */
	public static final String TABLE_NAME = "Training_Student";

	public static final Object[][] TABLE_COLUMNS = {
		{"idStudent", Types.BIGINT}, {"documentNumber", Types.VARCHAR},
		{"typeDocument", Types.VARCHAR}, {"name", Types.VARCHAR},
		{"lastName", Types.VARCHAR}, {"university", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("idStudent", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("documentNumber", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("typeDocument", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("lastName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("university", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table Training_Student (idStudent LONG not null primary key,documentNumber VARCHAR(75) null,typeDocument VARCHAR(75) null,name VARCHAR(75) null,lastName VARCHAR(75) null,university VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table Training_Student";

	public static final String ORDER_BY_JPQL = " ORDER BY student.lastName ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY Training_Student.lastName ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long DOCUMENTNUMBER_COLUMN_BITMASK = 1L;

	public static final long TYPEDOCUMENT_COLUMN_BITMASK = 2L;

	public static final long LASTNAME_COLUMN_BITMASK = 4L;

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
	public static Student toModel(StudentSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Student model = new StudentImpl();

		model.setIdStudent(soapModel.getIdStudent());
		model.setDocumentNumber(soapModel.getDocumentNumber());
		model.setTypeDocument(soapModel.getTypeDocument());
		model.setName(soapModel.getName());
		model.setLastName(soapModel.getLastName());
		model.setUniversity(soapModel.getUniversity());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Student> toModels(StudentSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Student> models = new ArrayList<Student>(soapModels.length);

		for (StudentSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public StudentModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _idStudent;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setIdStudent(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _idStudent;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Student.class;
	}

	@Override
	public String getModelClassName() {
		return Student.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Student, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Student, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Student, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Student)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Student, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Student, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Student)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Student, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Student, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Student>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Student.class.getClassLoader(), Student.class, ModelWrapper.class);

		try {
			Constructor<Student> constructor =
				(Constructor<Student>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<Student, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Student, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Student, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Student, Object>>();
		Map<String, BiConsumer<Student, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Student, ?>>();

		attributeGetterFunctions.put("idStudent", Student::getIdStudent);
		attributeSetterBiConsumers.put(
			"idStudent", (BiConsumer<Student, Long>)Student::setIdStudent);
		attributeGetterFunctions.put(
			"documentNumber", Student::getDocumentNumber);
		attributeSetterBiConsumers.put(
			"documentNumber",
			(BiConsumer<Student, String>)Student::setDocumentNumber);
		attributeGetterFunctions.put("typeDocument", Student::getTypeDocument);
		attributeSetterBiConsumers.put(
			"typeDocument",
			(BiConsumer<Student, String>)Student::setTypeDocument);
		attributeGetterFunctions.put("name", Student::getName);
		attributeSetterBiConsumers.put(
			"name", (BiConsumer<Student, String>)Student::setName);
		attributeGetterFunctions.put("lastName", Student::getLastName);
		attributeSetterBiConsumers.put(
			"lastName", (BiConsumer<Student, String>)Student::setLastName);
		attributeGetterFunctions.put("university", Student::getUniversity);
		attributeSetterBiConsumers.put(
			"university", (BiConsumer<Student, String>)Student::setUniversity);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getIdStudent() {
		return _idStudent;
	}

	@Override
	public void setIdStudent(long idStudent) {
		_idStudent = idStudent;
	}

	@JSON
	@Override
	public String getDocumentNumber() {
		if (_documentNumber == null) {
			return "";
		}
		else {
			return _documentNumber;
		}
	}

	@Override
	public void setDocumentNumber(String documentNumber) {
		_columnBitmask |= DOCUMENTNUMBER_COLUMN_BITMASK;

		if (_originalDocumentNumber == null) {
			_originalDocumentNumber = _documentNumber;
		}

		_documentNumber = documentNumber;
	}

	public String getOriginalDocumentNumber() {
		return GetterUtil.getString(_originalDocumentNumber);
	}

	@JSON
	@Override
	public String getTypeDocument() {
		if (_typeDocument == null) {
			return "";
		}
		else {
			return _typeDocument;
		}
	}

	@Override
	public void setTypeDocument(String typeDocument) {
		_columnBitmask |= TYPEDOCUMENT_COLUMN_BITMASK;

		if (_originalTypeDocument == null) {
			_originalTypeDocument = _typeDocument;
		}

		_typeDocument = typeDocument;
	}

	public String getOriginalTypeDocument() {
		return GetterUtil.getString(_originalTypeDocument);
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
	public String getLastName() {
		if (_lastName == null) {
			return "";
		}
		else {
			return _lastName;
		}
	}

	@Override
	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	@JSON
	@Override
	public String getUniversity() {
		if (_university == null) {
			return "";
		}
		else {
			return _university;
		}
	}

	@Override
	public void setUniversity(String university) {
		_university = university;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, Student.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Student toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Student>
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
		StudentImpl studentImpl = new StudentImpl();

		studentImpl.setIdStudent(getIdStudent());
		studentImpl.setDocumentNumber(getDocumentNumber());
		studentImpl.setTypeDocument(getTypeDocument());
		studentImpl.setName(getName());
		studentImpl.setLastName(getLastName());
		studentImpl.setUniversity(getUniversity());

		studentImpl.resetOriginalValues();

		return studentImpl;
	}

	@Override
	public int compareTo(Student student) {
		int value = 0;

		value = getLastName().compareTo(student.getLastName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Student)) {
			return false;
		}

		Student student = (Student)object;

		long primaryKey = student.getPrimaryKey();

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
		_originalDocumentNumber = _documentNumber;

		_originalTypeDocument = _typeDocument;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<Student> toCacheModel() {
		StudentCacheModel studentCacheModel = new StudentCacheModel();

		studentCacheModel.idStudent = getIdStudent();

		studentCacheModel.documentNumber = getDocumentNumber();

		String documentNumber = studentCacheModel.documentNumber;

		if ((documentNumber != null) && (documentNumber.length() == 0)) {
			studentCacheModel.documentNumber = null;
		}

		studentCacheModel.typeDocument = getTypeDocument();

		String typeDocument = studentCacheModel.typeDocument;

		if ((typeDocument != null) && (typeDocument.length() == 0)) {
			studentCacheModel.typeDocument = null;
		}

		studentCacheModel.name = getName();

		String name = studentCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			studentCacheModel.name = null;
		}

		studentCacheModel.lastName = getLastName();

		String lastName = studentCacheModel.lastName;

		if ((lastName != null) && (lastName.length() == 0)) {
			studentCacheModel.lastName = null;
		}

		studentCacheModel.university = getUniversity();

		String university = studentCacheModel.university;

		if ((university != null) && (university.length() == 0)) {
			studentCacheModel.university = null;
		}

		return studentCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Student, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Student, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Student, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Student)this));
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
		Map<String, Function<Student, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Student, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Student, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Student)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Student>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _idStudent;
	private String _documentNumber;
	private String _originalDocumentNumber;
	private String _typeDocument;
	private String _originalTypeDocument;
	private String _name;
	private String _lastName;
	private String _university;
	private long _columnBitmask;
	private Student _escapedModel;

}