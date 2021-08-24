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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.training.students.service.http.StudentServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class StudentSoap implements Serializable {

	public static StudentSoap toSoapModel(Student model) {
		StudentSoap soapModel = new StudentSoap();

		soapModel.setIdStudent(model.getIdStudent());
		soapModel.setDocumentNumber(model.getDocumentNumber());
		soapModel.setTypeDocument(model.getTypeDocument());
		soapModel.setName(model.getName());
		soapModel.setLastName(model.getLastName());
		soapModel.setUniversity(model.getUniversity());

		return soapModel;
	}

	public static StudentSoap[] toSoapModels(Student[] models) {
		StudentSoap[] soapModels = new StudentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StudentSoap[][] toSoapModels(Student[][] models) {
		StudentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StudentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StudentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StudentSoap[] toSoapModels(List<Student> models) {
		List<StudentSoap> soapModels = new ArrayList<StudentSoap>(
			models.size());

		for (Student model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StudentSoap[soapModels.size()]);
	}

	public StudentSoap() {
	}

	public long getPrimaryKey() {
		return _idStudent;
	}

	public void setPrimaryKey(long pk) {
		setIdStudent(pk);
	}

	public long getIdStudent() {
		return _idStudent;
	}

	public void setIdStudent(long idStudent) {
		_idStudent = idStudent;
	}

	public String getDocumentNumber() {
		return _documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		_documentNumber = documentNumber;
	}

	public String getTypeDocument() {
		return _typeDocument;
	}

	public void setTypeDocument(String typeDocument) {
		_typeDocument = typeDocument;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public String getUniversity() {
		return _university;
	}

	public void setUniversity(String university) {
		_university = university;
	}

	private long _idStudent;
	private String _documentNumber;
	private String _typeDocument;
	private String _name;
	private String _lastName;
	private String _university;

}