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

package com.liferay.training.students.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.training.students.exception.NoSuchStudentException;
import com.liferay.training.students.model.Student;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the student service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StudentUtil
 * @generated
 */
@ProviderType
public interface StudentPersistence extends BasePersistence<Student> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StudentUtil} to access the student persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the students where typeDocument = &#63;.
	 *
	 * @param typeDocument the type document
	 * @return the matching students
	 */
	public java.util.List<Student> findByqueryTypeDocument(String typeDocument);

	/**
	 * Returns a range of all the students where typeDocument = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentModelImpl</code>.
	 * </p>
	 *
	 * @param typeDocument the type document
	 * @param start the lower bound of the range of students
	 * @param end the upper bound of the range of students (not inclusive)
	 * @return the range of matching students
	 */
	public java.util.List<Student> findByqueryTypeDocument(
		String typeDocument, int start, int end);

	/**
	 * Returns an ordered range of all the students where typeDocument = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentModelImpl</code>.
	 * </p>
	 *
	 * @param typeDocument the type document
	 * @param start the lower bound of the range of students
	 * @param end the upper bound of the range of students (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching students
	 */
	public java.util.List<Student> findByqueryTypeDocument(
		String typeDocument, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Student>
			orderByComparator);

	/**
	 * Returns an ordered range of all the students where typeDocument = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentModelImpl</code>.
	 * </p>
	 *
	 * @param typeDocument the type document
	 * @param start the lower bound of the range of students
	 * @param end the upper bound of the range of students (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching students
	 */
	public java.util.List<Student> findByqueryTypeDocument(
		String typeDocument, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Student>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first student in the ordered set where typeDocument = &#63;.
	 *
	 * @param typeDocument the type document
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student
	 * @throws NoSuchStudentException if a matching student could not be found
	 */
	public Student findByqueryTypeDocument_First(
			String typeDocument,
			com.liferay.portal.kernel.util.OrderByComparator<Student>
				orderByComparator)
		throws NoSuchStudentException;

	/**
	 * Returns the first student in the ordered set where typeDocument = &#63;.
	 *
	 * @param typeDocument the type document
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student, or <code>null</code> if a matching student could not be found
	 */
	public Student fetchByqueryTypeDocument_First(
		String typeDocument,
		com.liferay.portal.kernel.util.OrderByComparator<Student>
			orderByComparator);

	/**
	 * Returns the last student in the ordered set where typeDocument = &#63;.
	 *
	 * @param typeDocument the type document
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student
	 * @throws NoSuchStudentException if a matching student could not be found
	 */
	public Student findByqueryTypeDocument_Last(
			String typeDocument,
			com.liferay.portal.kernel.util.OrderByComparator<Student>
				orderByComparator)
		throws NoSuchStudentException;

	/**
	 * Returns the last student in the ordered set where typeDocument = &#63;.
	 *
	 * @param typeDocument the type document
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student, or <code>null</code> if a matching student could not be found
	 */
	public Student fetchByqueryTypeDocument_Last(
		String typeDocument,
		com.liferay.portal.kernel.util.OrderByComparator<Student>
			orderByComparator);

	/**
	 * Returns the students before and after the current student in the ordered set where typeDocument = &#63;.
	 *
	 * @param idStudent the primary key of the current student
	 * @param typeDocument the type document
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next student
	 * @throws NoSuchStudentException if a student with the primary key could not be found
	 */
	public Student[] findByqueryTypeDocument_PrevAndNext(
			long idStudent, String typeDocument,
			com.liferay.portal.kernel.util.OrderByComparator<Student>
				orderByComparator)
		throws NoSuchStudentException;

	/**
	 * Removes all the students where typeDocument = &#63; from the database.
	 *
	 * @param typeDocument the type document
	 */
	public void removeByqueryTypeDocument(String typeDocument);

	/**
	 * Returns the number of students where typeDocument = &#63;.
	 *
	 * @param typeDocument the type document
	 * @return the number of matching students
	 */
	public int countByqueryTypeDocument(String typeDocument);

	/**
	 * Returns all the students where documentNumber = &#63; and typeDocument = &#63;.
	 *
	 * @param documentNumber the document number
	 * @param typeDocument the type document
	 * @return the matching students
	 */
	public java.util.List<Student> findByFindStudentBynumberType(
		String documentNumber, String typeDocument);

	/**
	 * Returns a range of all the students where documentNumber = &#63; and typeDocument = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentModelImpl</code>.
	 * </p>
	 *
	 * @param documentNumber the document number
	 * @param typeDocument the type document
	 * @param start the lower bound of the range of students
	 * @param end the upper bound of the range of students (not inclusive)
	 * @return the range of matching students
	 */
	public java.util.List<Student> findByFindStudentBynumberType(
		String documentNumber, String typeDocument, int start, int end);

	/**
	 * Returns an ordered range of all the students where documentNumber = &#63; and typeDocument = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentModelImpl</code>.
	 * </p>
	 *
	 * @param documentNumber the document number
	 * @param typeDocument the type document
	 * @param start the lower bound of the range of students
	 * @param end the upper bound of the range of students (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching students
	 */
	public java.util.List<Student> findByFindStudentBynumberType(
		String documentNumber, String typeDocument, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Student>
			orderByComparator);

	/**
	 * Returns an ordered range of all the students where documentNumber = &#63; and typeDocument = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentModelImpl</code>.
	 * </p>
	 *
	 * @param documentNumber the document number
	 * @param typeDocument the type document
	 * @param start the lower bound of the range of students
	 * @param end the upper bound of the range of students (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching students
	 */
	public java.util.List<Student> findByFindStudentBynumberType(
		String documentNumber, String typeDocument, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Student>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first student in the ordered set where documentNumber = &#63; and typeDocument = &#63;.
	 *
	 * @param documentNumber the document number
	 * @param typeDocument the type document
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student
	 * @throws NoSuchStudentException if a matching student could not be found
	 */
	public Student findByFindStudentBynumberType_First(
			String documentNumber, String typeDocument,
			com.liferay.portal.kernel.util.OrderByComparator<Student>
				orderByComparator)
		throws NoSuchStudentException;

	/**
	 * Returns the first student in the ordered set where documentNumber = &#63; and typeDocument = &#63;.
	 *
	 * @param documentNumber the document number
	 * @param typeDocument the type document
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student, or <code>null</code> if a matching student could not be found
	 */
	public Student fetchByFindStudentBynumberType_First(
		String documentNumber, String typeDocument,
		com.liferay.portal.kernel.util.OrderByComparator<Student>
			orderByComparator);

	/**
	 * Returns the last student in the ordered set where documentNumber = &#63; and typeDocument = &#63;.
	 *
	 * @param documentNumber the document number
	 * @param typeDocument the type document
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student
	 * @throws NoSuchStudentException if a matching student could not be found
	 */
	public Student findByFindStudentBynumberType_Last(
			String documentNumber, String typeDocument,
			com.liferay.portal.kernel.util.OrderByComparator<Student>
				orderByComparator)
		throws NoSuchStudentException;

	/**
	 * Returns the last student in the ordered set where documentNumber = &#63; and typeDocument = &#63;.
	 *
	 * @param documentNumber the document number
	 * @param typeDocument the type document
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student, or <code>null</code> if a matching student could not be found
	 */
	public Student fetchByFindStudentBynumberType_Last(
		String documentNumber, String typeDocument,
		com.liferay.portal.kernel.util.OrderByComparator<Student>
			orderByComparator);

	/**
	 * Returns the students before and after the current student in the ordered set where documentNumber = &#63; and typeDocument = &#63;.
	 *
	 * @param idStudent the primary key of the current student
	 * @param documentNumber the document number
	 * @param typeDocument the type document
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next student
	 * @throws NoSuchStudentException if a student with the primary key could not be found
	 */
	public Student[] findByFindStudentBynumberType_PrevAndNext(
			long idStudent, String documentNumber, String typeDocument,
			com.liferay.portal.kernel.util.OrderByComparator<Student>
				orderByComparator)
		throws NoSuchStudentException;

	/**
	 * Removes all the students where documentNumber = &#63; and typeDocument = &#63; from the database.
	 *
	 * @param documentNumber the document number
	 * @param typeDocument the type document
	 */
	public void removeByFindStudentBynumberType(
		String documentNumber, String typeDocument);

	/**
	 * Returns the number of students where documentNumber = &#63; and typeDocument = &#63;.
	 *
	 * @param documentNumber the document number
	 * @param typeDocument the type document
	 * @return the number of matching students
	 */
	public int countByFindStudentBynumberType(
		String documentNumber, String typeDocument);

	/**
	 * Caches the student in the entity cache if it is enabled.
	 *
	 * @param student the student
	 */
	public void cacheResult(Student student);

	/**
	 * Caches the students in the entity cache if it is enabled.
	 *
	 * @param students the students
	 */
	public void cacheResult(java.util.List<Student> students);

	/**
	 * Creates a new student with the primary key. Does not add the student to the database.
	 *
	 * @param idStudent the primary key for the new student
	 * @return the new student
	 */
	public Student create(long idStudent);

	/**
	 * Removes the student with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param idStudent the primary key of the student
	 * @return the student that was removed
	 * @throws NoSuchStudentException if a student with the primary key could not be found
	 */
	public Student remove(long idStudent) throws NoSuchStudentException;

	public Student updateImpl(Student student);

	/**
	 * Returns the student with the primary key or throws a <code>NoSuchStudentException</code> if it could not be found.
	 *
	 * @param idStudent the primary key of the student
	 * @return the student
	 * @throws NoSuchStudentException if a student with the primary key could not be found
	 */
	public Student findByPrimaryKey(long idStudent)
		throws NoSuchStudentException;

	/**
	 * Returns the student with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param idStudent the primary key of the student
	 * @return the student, or <code>null</code> if a student with the primary key could not be found
	 */
	public Student fetchByPrimaryKey(long idStudent);

	/**
	 * Returns all the students.
	 *
	 * @return the students
	 */
	public java.util.List<Student> findAll();

	/**
	 * Returns a range of all the students.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of students
	 * @param end the upper bound of the range of students (not inclusive)
	 * @return the range of students
	 */
	public java.util.List<Student> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the students.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of students
	 * @param end the upper bound of the range of students (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of students
	 */
	public java.util.List<Student> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Student>
			orderByComparator);

	/**
	 * Returns an ordered range of all the students.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of students
	 * @param end the upper bound of the range of students (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of students
	 */
	public java.util.List<Student> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Student>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the students from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of students.
	 *
	 * @return the number of students
	 */
	public int countAll();

}