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

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.training.students.model.Student;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Student in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class StudentCacheModel implements CacheModel<Student>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof StudentCacheModel)) {
			return false;
		}

		StudentCacheModel studentCacheModel = (StudentCacheModel)object;

		if (idStudent == studentCacheModel.idStudent) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, idStudent);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{idStudent=");
		sb.append(idStudent);
		sb.append(", documentNumber=");
		sb.append(documentNumber);
		sb.append(", typeDocument=");
		sb.append(typeDocument);
		sb.append(", name=");
		sb.append(name);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", university=");
		sb.append(university);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Student toEntityModel() {
		StudentImpl studentImpl = new StudentImpl();

		studentImpl.setIdStudent(idStudent);

		if (documentNumber == null) {
			studentImpl.setDocumentNumber("");
		}
		else {
			studentImpl.setDocumentNumber(documentNumber);
		}

		if (typeDocument == null) {
			studentImpl.setTypeDocument("");
		}
		else {
			studentImpl.setTypeDocument(typeDocument);
		}

		if (name == null) {
			studentImpl.setName("");
		}
		else {
			studentImpl.setName(name);
		}

		if (lastName == null) {
			studentImpl.setLastName("");
		}
		else {
			studentImpl.setLastName(lastName);
		}

		if (university == null) {
			studentImpl.setUniversity("");
		}
		else {
			studentImpl.setUniversity(university);
		}

		studentImpl.resetOriginalValues();

		return studentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		idStudent = objectInput.readLong();
		documentNumber = objectInput.readUTF();
		typeDocument = objectInput.readUTF();
		name = objectInput.readUTF();
		lastName = objectInput.readUTF();
		university = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(idStudent);

		if (documentNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(documentNumber);
		}

		if (typeDocument == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(typeDocument);
		}

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (lastName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		if (university == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(university);
		}
	}

	public long idStudent;
	public String documentNumber;
	public String typeDocument;
	public String name;
	public String lastName;
	public String university;

}