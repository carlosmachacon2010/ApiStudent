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

package com.liferay.training.students.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Student}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Student
 * @generated
 */
public class StudentWrapper
	extends BaseModelWrapper<Student>
	implements ModelWrapper<Student>, Student {

	public StudentWrapper(Student student) {
		super(student);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idStudent", getIdStudent());
		attributes.put("documentNumber", getDocumentNumber());
		attributes.put("typeDocument", getTypeDocument());
		attributes.put("name", getName());
		attributes.put("lastName", getLastName());
		attributes.put("university", getUniversity());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long idStudent = (Long)attributes.get("idStudent");

		if (idStudent != null) {
			setIdStudent(idStudent);
		}

		String documentNumber = (String)attributes.get("documentNumber");

		if (documentNumber != null) {
			setDocumentNumber(documentNumber);
		}

		String typeDocument = (String)attributes.get("typeDocument");

		if (typeDocument != null) {
			setTypeDocument(typeDocument);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String university = (String)attributes.get("university");

		if (university != null) {
			setUniversity(university);
		}
	}

	/**
	 * Returns the document number of this student.
	 *
	 * @return the document number of this student
	 */
	@Override
	public String getDocumentNumber() {
		return model.getDocumentNumber();
	}

	/**
	 * Returns the id student of this student.
	 *
	 * @return the id student of this student
	 */
	@Override
	public long getIdStudent() {
		return model.getIdStudent();
	}

	/**
	 * Returns the last name of this student.
	 *
	 * @return the last name of this student
	 */
	@Override
	public String getLastName() {
		return model.getLastName();
	}

	/**
	 * Returns the name of this student.
	 *
	 * @return the name of this student
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this student.
	 *
	 * @return the primary key of this student
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the type document of this student.
	 *
	 * @return the type document of this student
	 */
	@Override
	public String getTypeDocument() {
		return model.getTypeDocument();
	}

	/**
	 * Returns the university of this student.
	 *
	 * @return the university of this student
	 */
	@Override
	public String getUniversity() {
		return model.getUniversity();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the document number of this student.
	 *
	 * @param documentNumber the document number of this student
	 */
	@Override
	public void setDocumentNumber(String documentNumber) {
		model.setDocumentNumber(documentNumber);
	}

	/**
	 * Sets the id student of this student.
	 *
	 * @param idStudent the id student of this student
	 */
	@Override
	public void setIdStudent(long idStudent) {
		model.setIdStudent(idStudent);
	}

	/**
	 * Sets the last name of this student.
	 *
	 * @param lastName the last name of this student
	 */
	@Override
	public void setLastName(String lastName) {
		model.setLastName(lastName);
	}

	/**
	 * Sets the name of this student.
	 *
	 * @param name the name of this student
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this student.
	 *
	 * @param primaryKey the primary key of this student
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the type document of this student.
	 *
	 * @param typeDocument the type document of this student
	 */
	@Override
	public void setTypeDocument(String typeDocument) {
		model.setTypeDocument(typeDocument);
	}

	/**
	 * Sets the university of this student.
	 *
	 * @param university the university of this student
	 */
	@Override
	public void setUniversity(String university) {
		model.setUniversity(university);
	}

	@Override
	protected StudentWrapper wrap(Student student) {
		return new StudentWrapper(student);
	}

}