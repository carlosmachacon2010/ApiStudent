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

package com.liferay.training.students.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.training.students.exception.NoSuchStudentException;
import com.liferay.training.students.model.Student;
import com.liferay.training.students.model.impl.StudentImpl;
import com.liferay.training.students.model.impl.StudentModelImpl;
import com.liferay.training.students.service.persistence.StudentPersistence;
import com.liferay.training.students.service.persistence.impl.constants.TrainingPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the student service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = StudentPersistence.class)
public class StudentPersistenceImpl
	extends BasePersistenceImpl<Student> implements StudentPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>StudentUtil</code> to access the student persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		StudentImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByFindStudentBynumberType;
	private FinderPath
		_finderPathWithoutPaginationFindByFindStudentBynumberType;
	private FinderPath _finderPathCountByFindStudentBynumberType;

	/**
	 * Returns all the students where documentNumber = &#63; and typeDocument = &#63;.
	 *
	 * @param documentNumber the document number
	 * @param typeDocument the type document
	 * @return the matching students
	 */
	@Override
	public List<Student> findByFindStudentBynumberType(
		String documentNumber, String typeDocument) {

		return findByFindStudentBynumberType(
			documentNumber, typeDocument, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

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
	@Override
	public List<Student> findByFindStudentBynumberType(
		String documentNumber, String typeDocument, int start, int end) {

		return findByFindStudentBynumberType(
			documentNumber, typeDocument, start, end, null);
	}

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
	@Override
	public List<Student> findByFindStudentBynumberType(
		String documentNumber, String typeDocument, int start, int end,
		OrderByComparator<Student> orderByComparator) {

		return findByFindStudentBynumberType(
			documentNumber, typeDocument, start, end, orderByComparator, true);
	}

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
	@Override
	public List<Student> findByFindStudentBynumberType(
		String documentNumber, String typeDocument, int start, int end,
		OrderByComparator<Student> orderByComparator, boolean useFinderCache) {

		documentNumber = Objects.toString(documentNumber, "");
		typeDocument = Objects.toString(typeDocument, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByFindStudentBynumberType;
				finderArgs = new Object[] {documentNumber, typeDocument};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByFindStudentBynumberType;
			finderArgs = new Object[] {
				documentNumber, typeDocument, start, end, orderByComparator
			};
		}

		List<Student> list = null;

		if (useFinderCache) {
			list = (List<Student>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Student student : list) {
					if (!documentNumber.equals(student.getDocumentNumber()) ||
						!typeDocument.equals(student.getTypeDocument())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_STUDENT_WHERE);

			boolean bindDocumentNumber = false;

			if (documentNumber.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_FINDSTUDENTBYNUMBERTYPE_DOCUMENTNUMBER_3);
			}
			else {
				bindDocumentNumber = true;

				sb.append(
					_FINDER_COLUMN_FINDSTUDENTBYNUMBERTYPE_DOCUMENTNUMBER_2);
			}

			boolean bindTypeDocument = false;

			if (typeDocument.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_FINDSTUDENTBYNUMBERTYPE_TYPEDOCUMENT_3);
			}
			else {
				bindTypeDocument = true;

				sb.append(
					_FINDER_COLUMN_FINDSTUDENTBYNUMBERTYPE_TYPEDOCUMENT_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(StudentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDocumentNumber) {
					queryPos.add(documentNumber);
				}

				if (bindTypeDocument) {
					queryPos.add(typeDocument);
				}

				list = (List<Student>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first student in the ordered set where documentNumber = &#63; and typeDocument = &#63;.
	 *
	 * @param documentNumber the document number
	 * @param typeDocument the type document
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student
	 * @throws NoSuchStudentException if a matching student could not be found
	 */
	@Override
	public Student findByFindStudentBynumberType_First(
			String documentNumber, String typeDocument,
			OrderByComparator<Student> orderByComparator)
		throws NoSuchStudentException {

		Student student = fetchByFindStudentBynumberType_First(
			documentNumber, typeDocument, orderByComparator);

		if (student != null) {
			return student;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("documentNumber=");
		sb.append(documentNumber);

		sb.append(", typeDocument=");
		sb.append(typeDocument);

		sb.append("}");

		throw new NoSuchStudentException(sb.toString());
	}

	/**
	 * Returns the first student in the ordered set where documentNumber = &#63; and typeDocument = &#63;.
	 *
	 * @param documentNumber the document number
	 * @param typeDocument the type document
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student, or <code>null</code> if a matching student could not be found
	 */
	@Override
	public Student fetchByFindStudentBynumberType_First(
		String documentNumber, String typeDocument,
		OrderByComparator<Student> orderByComparator) {

		List<Student> list = findByFindStudentBynumberType(
			documentNumber, typeDocument, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last student in the ordered set where documentNumber = &#63; and typeDocument = &#63;.
	 *
	 * @param documentNumber the document number
	 * @param typeDocument the type document
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student
	 * @throws NoSuchStudentException if a matching student could not be found
	 */
	@Override
	public Student findByFindStudentBynumberType_Last(
			String documentNumber, String typeDocument,
			OrderByComparator<Student> orderByComparator)
		throws NoSuchStudentException {

		Student student = fetchByFindStudentBynumberType_Last(
			documentNumber, typeDocument, orderByComparator);

		if (student != null) {
			return student;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("documentNumber=");
		sb.append(documentNumber);

		sb.append(", typeDocument=");
		sb.append(typeDocument);

		sb.append("}");

		throw new NoSuchStudentException(sb.toString());
	}

	/**
	 * Returns the last student in the ordered set where documentNumber = &#63; and typeDocument = &#63;.
	 *
	 * @param documentNumber the document number
	 * @param typeDocument the type document
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student, or <code>null</code> if a matching student could not be found
	 */
	@Override
	public Student fetchByFindStudentBynumberType_Last(
		String documentNumber, String typeDocument,
		OrderByComparator<Student> orderByComparator) {

		int count = countByFindStudentBynumberType(
			documentNumber, typeDocument);

		if (count == 0) {
			return null;
		}

		List<Student> list = findByFindStudentBynumberType(
			documentNumber, typeDocument, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public Student[] findByFindStudentBynumberType_PrevAndNext(
			long idStudent, String documentNumber, String typeDocument,
			OrderByComparator<Student> orderByComparator)
		throws NoSuchStudentException {

		documentNumber = Objects.toString(documentNumber, "");
		typeDocument = Objects.toString(typeDocument, "");

		Student student = findByPrimaryKey(idStudent);

		Session session = null;

		try {
			session = openSession();

			Student[] array = new StudentImpl[3];

			array[0] = getByFindStudentBynumberType_PrevAndNext(
				session, student, documentNumber, typeDocument,
				orderByComparator, true);

			array[1] = student;

			array[2] = getByFindStudentBynumberType_PrevAndNext(
				session, student, documentNumber, typeDocument,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Student getByFindStudentBynumberType_PrevAndNext(
		Session session, Student student, String documentNumber,
		String typeDocument, OrderByComparator<Student> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_STUDENT_WHERE);

		boolean bindDocumentNumber = false;

		if (documentNumber.isEmpty()) {
			sb.append(_FINDER_COLUMN_FINDSTUDENTBYNUMBERTYPE_DOCUMENTNUMBER_3);
		}
		else {
			bindDocumentNumber = true;

			sb.append(_FINDER_COLUMN_FINDSTUDENTBYNUMBERTYPE_DOCUMENTNUMBER_2);
		}

		boolean bindTypeDocument = false;

		if (typeDocument.isEmpty()) {
			sb.append(_FINDER_COLUMN_FINDSTUDENTBYNUMBERTYPE_TYPEDOCUMENT_3);
		}
		else {
			bindTypeDocument = true;

			sb.append(_FINDER_COLUMN_FINDSTUDENTBYNUMBERTYPE_TYPEDOCUMENT_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(StudentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindDocumentNumber) {
			queryPos.add(documentNumber);
		}

		if (bindTypeDocument) {
			queryPos.add(typeDocument);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(student)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Student> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the students where documentNumber = &#63; and typeDocument = &#63; from the database.
	 *
	 * @param documentNumber the document number
	 * @param typeDocument the type document
	 */
	@Override
	public void removeByFindStudentBynumberType(
		String documentNumber, String typeDocument) {

		for (Student student :
				findByFindStudentBynumberType(
					documentNumber, typeDocument, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(student);
		}
	}

	/**
	 * Returns the number of students where documentNumber = &#63; and typeDocument = &#63;.
	 *
	 * @param documentNumber the document number
	 * @param typeDocument the type document
	 * @return the number of matching students
	 */
	@Override
	public int countByFindStudentBynumberType(
		String documentNumber, String typeDocument) {

		documentNumber = Objects.toString(documentNumber, "");
		typeDocument = Objects.toString(typeDocument, "");

		FinderPath finderPath = _finderPathCountByFindStudentBynumberType;

		Object[] finderArgs = new Object[] {documentNumber, typeDocument};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_STUDENT_WHERE);

			boolean bindDocumentNumber = false;

			if (documentNumber.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_FINDSTUDENTBYNUMBERTYPE_DOCUMENTNUMBER_3);
			}
			else {
				bindDocumentNumber = true;

				sb.append(
					_FINDER_COLUMN_FINDSTUDENTBYNUMBERTYPE_DOCUMENTNUMBER_2);
			}

			boolean bindTypeDocument = false;

			if (typeDocument.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_FINDSTUDENTBYNUMBERTYPE_TYPEDOCUMENT_3);
			}
			else {
				bindTypeDocument = true;

				sb.append(
					_FINDER_COLUMN_FINDSTUDENTBYNUMBERTYPE_TYPEDOCUMENT_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDocumentNumber) {
					queryPos.add(documentNumber);
				}

				if (bindTypeDocument) {
					queryPos.add(typeDocument);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_FINDSTUDENTBYNUMBERTYPE_DOCUMENTNUMBER_2 =
			"student.documentNumber = ? AND ";

	private static final String
		_FINDER_COLUMN_FINDSTUDENTBYNUMBERTYPE_DOCUMENTNUMBER_3 =
			"(student.documentNumber IS NULL OR student.documentNumber = '') AND ";

	private static final String
		_FINDER_COLUMN_FINDSTUDENTBYNUMBERTYPE_TYPEDOCUMENT_2 =
			"student.typeDocument = ?";

	private static final String
		_FINDER_COLUMN_FINDSTUDENTBYNUMBERTYPE_TYPEDOCUMENT_3 =
			"(student.typeDocument IS NULL OR student.typeDocument = '')";

	public StudentPersistenceImpl() {
		setModelClass(Student.class);

		setModelImplClass(StudentImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the student in the entity cache if it is enabled.
	 *
	 * @param student the student
	 */
	@Override
	public void cacheResult(Student student) {
		entityCache.putResult(
			entityCacheEnabled, StudentImpl.class, student.getPrimaryKey(),
			student);

		student.resetOriginalValues();
	}

	/**
	 * Caches the students in the entity cache if it is enabled.
	 *
	 * @param students the students
	 */
	@Override
	public void cacheResult(List<Student> students) {
		for (Student student : students) {
			if (entityCache.getResult(
					entityCacheEnabled, StudentImpl.class,
					student.getPrimaryKey()) == null) {

				cacheResult(student);
			}
			else {
				student.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all students.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StudentImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the student.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Student student) {
		entityCache.removeResult(
			entityCacheEnabled, StudentImpl.class, student.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Student> students) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Student student : students) {
			entityCache.removeResult(
				entityCacheEnabled, StudentImpl.class, student.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, StudentImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new student with the primary key. Does not add the student to the database.
	 *
	 * @param idStudent the primary key for the new student
	 * @return the new student
	 */
	@Override
	public Student create(long idStudent) {
		Student student = new StudentImpl();

		student.setNew(true);
		student.setPrimaryKey(idStudent);

		return student;
	}

	/**
	 * Removes the student with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param idStudent the primary key of the student
	 * @return the student that was removed
	 * @throws NoSuchStudentException if a student with the primary key could not be found
	 */
	@Override
	public Student remove(long idStudent) throws NoSuchStudentException {
		return remove((Serializable)idStudent);
	}

	/**
	 * Removes the student with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the student
	 * @return the student that was removed
	 * @throws NoSuchStudentException if a student with the primary key could not be found
	 */
	@Override
	public Student remove(Serializable primaryKey)
		throws NoSuchStudentException {

		Session session = null;

		try {
			session = openSession();

			Student student = (Student)session.get(
				StudentImpl.class, primaryKey);

			if (student == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStudentException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(student);
		}
		catch (NoSuchStudentException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Student removeImpl(Student student) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(student)) {
				student = (Student)session.get(
					StudentImpl.class, student.getPrimaryKeyObj());
			}

			if (student != null) {
				session.delete(student);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (student != null) {
			clearCache(student);
		}

		return student;
	}

	@Override
	public Student updateImpl(Student student) {
		boolean isNew = student.isNew();

		if (!(student instanceof StudentModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(student.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(student);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in student proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Student implementation " +
					student.getClass());
		}

		StudentModelImpl studentModelImpl = (StudentModelImpl)student;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(student);

				student.setNew(false);
			}
			else {
				student = (Student)session.merge(student);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {
				studentModelImpl.getDocumentNumber(),
				studentModelImpl.getTypeDocument()
			};

			finderCache.removeResult(
				_finderPathCountByFindStudentBynumberType, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByFindStudentBynumberType,
				args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((studentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByFindStudentBynumberType.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					studentModelImpl.getOriginalDocumentNumber(),
					studentModelImpl.getOriginalTypeDocument()
				};

				finderCache.removeResult(
					_finderPathCountByFindStudentBynumberType, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFindStudentBynumberType,
					args);

				args = new Object[] {
					studentModelImpl.getDocumentNumber(),
					studentModelImpl.getTypeDocument()
				};

				finderCache.removeResult(
					_finderPathCountByFindStudentBynumberType, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFindStudentBynumberType,
					args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, StudentImpl.class, student.getPrimaryKey(),
			student, false);

		student.resetOriginalValues();

		return student;
	}

	/**
	 * Returns the student with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the student
	 * @return the student
	 * @throws NoSuchStudentException if a student with the primary key could not be found
	 */
	@Override
	public Student findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStudentException {

		Student student = fetchByPrimaryKey(primaryKey);

		if (student == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStudentException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return student;
	}

	/**
	 * Returns the student with the primary key or throws a <code>NoSuchStudentException</code> if it could not be found.
	 *
	 * @param idStudent the primary key of the student
	 * @return the student
	 * @throws NoSuchStudentException if a student with the primary key could not be found
	 */
	@Override
	public Student findByPrimaryKey(long idStudent)
		throws NoSuchStudentException {

		return findByPrimaryKey((Serializable)idStudent);
	}

	/**
	 * Returns the student with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param idStudent the primary key of the student
	 * @return the student, or <code>null</code> if a student with the primary key could not be found
	 */
	@Override
	public Student fetchByPrimaryKey(long idStudent) {
		return fetchByPrimaryKey((Serializable)idStudent);
	}

	/**
	 * Returns all the students.
	 *
	 * @return the students
	 */
	@Override
	public List<Student> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Student> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<Student> findAll(
		int start, int end, OrderByComparator<Student> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<Student> findAll(
		int start, int end, OrderByComparator<Student> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Student> list = null;

		if (useFinderCache) {
			list = (List<Student>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_STUDENT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_STUDENT;

				sql = sql.concat(StudentModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Student>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the students from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Student student : findAll()) {
			remove(student);
		}
	}

	/**
	 * Returns the number of students.
	 *
	 * @return the number of students
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_STUDENT);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "idStudent";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_STUDENT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return StudentModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the student persistence.
	 */
	@Activate
	public void activate() {
		StudentModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		StudentModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, StudentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, StudentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByFindStudentBynumberType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, StudentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByFindStudentBynumberType",
			new String[] {
				String.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByFindStudentBynumberType =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled, StudentImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByFindStudentBynumberType",
				new String[] {String.class.getName(), String.class.getName()},
				StudentModelImpl.DOCUMENTNUMBER_COLUMN_BITMASK |
				StudentModelImpl.TYPEDOCUMENT_COLUMN_BITMASK |
				StudentModelImpl.LASTNAME_COLUMN_BITMASK);

		_finderPathCountByFindStudentBynumberType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByFindStudentBynumberType",
			new String[] {String.class.getName(), String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(StudentImpl.class.getName());

		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = TrainingPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.liferay.training.students.model.Student"),
			true);
	}

	@Override
	@Reference(
		target = TrainingPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = TrainingPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_STUDENT =
		"SELECT student FROM Student student";

	private static final String _SQL_SELECT_STUDENT_WHERE =
		"SELECT student FROM Student student WHERE ";

	private static final String _SQL_COUNT_STUDENT =
		"SELECT COUNT(student) FROM Student student";

	private static final String _SQL_COUNT_STUDENT_WHERE =
		"SELECT COUNT(student) FROM Student student WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "student.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Student exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Student exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		StudentPersistenceImpl.class);

	static {
		try {
			Class.forName(TrainingPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}