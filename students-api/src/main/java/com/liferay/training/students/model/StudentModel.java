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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Student service. Represents a row in the &quot;students_Student&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.training.students.model.impl.StudentModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.training.students.model.impl.StudentImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Student
 * @generated
 */
@ProviderType
public interface StudentModel extends BaseModel<Student> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a student model instance should use the {@link Student} interface instead.
	 */

	/**
	 * Returns the primary key of this student.
	 *
	 * @return the primary key of this student
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this student.
	 *
	 * @param primaryKey the primary key of this student
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the id student of this student.
	 *
	 * @return the id student of this student
	 */
	public long getIdStudent();

	/**
	 * Sets the id student of this student.
	 *
	 * @param idStudent the id student of this student
	 */
	public void setIdStudent(long idStudent);

	/**
	 * Returns the document number of this student.
	 *
	 * @return the document number of this student
	 */
	@AutoEscape
	public String getDocumentNumber();

	/**
	 * Sets the document number of this student.
	 *
	 * @param documentNumber the document number of this student
	 */
	public void setDocumentNumber(String documentNumber);

	/**
	 * Returns the type document of this student.
	 *
	 * @return the type document of this student
	 */
	@AutoEscape
	public String getTypeDocument();

	/**
	 * Sets the type document of this student.
	 *
	 * @param typeDocument the type document of this student
	 */
	public void setTypeDocument(String typeDocument);

	/**
	 * Returns the name of this student.
	 *
	 * @return the name of this student
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this student.
	 *
	 * @param name the name of this student
	 */
	public void setName(String name);

	/**
	 * Returns the last name of this student.
	 *
	 * @return the last name of this student
	 */
	@AutoEscape
	public String getLastName();

	/**
	 * Sets the last name of this student.
	 *
	 * @param lastName the last name of this student
	 */
	public void setLastName(String lastName);

	/**
	 * Returns the university of this student.
	 *
	 * @return the university of this student
	 */
	@AutoEscape
	public String getUniversity();

	/**
	 * Sets the university of this student.
	 *
	 * @param university the university of this student
	 */
	public void setUniversity(String university);

}