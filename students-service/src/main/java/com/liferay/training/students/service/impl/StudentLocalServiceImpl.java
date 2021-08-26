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

package com.liferay.training.students.service.impl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.training.students.model.Student;
import com.liferay.training.students.service.base.StudentLocalServiceBaseImpl;
import com.liferay.training.students.service.persistence.StudentPersistence;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the student local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.liferay.training.students.service.StudentLocalService</code>
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StudentLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.liferay.training.students.model.Student", service = AopService.class)
public class StudentLocalServiceImpl extends StudentLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use
	 * <code>com.liferay.training.students.service.StudentLocalService</code> via
	 * injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use
	 * <code>com.liferay.training.students.service.StudentLocalServiceUtil</code>.
	 */

	public Student addStudent(String documentNumber, String typeDocument, String name, String lastName,
			String university) {

		if (studentPersistence.findByFindStudentBynumberType(documentNumber, typeDocument).isEmpty()) {
			Student newStudent = createStudent(counterLocalService.increment());
			newStudent.setDocumentNumber(documentNumber);
			newStudent.setTypeDocument(typeDocument);
			newStudent.setName(name);
			newStudent.setLastName(lastName);
			newStudent.setUniversity(university);
			
			return super.addStudent(newStudent);
		}else {
			
			return null;
		}
		

	}

	public List<Student> getfindByStudentnumberTypeDocument(String documentNumber, String typeDocument) {

		return studentPersistence.findByFindStudentBynumberType(documentNumber, typeDocument);

	}

	public List<Student> getStudentByLastName(int start, int end, OrderByComparator<Student> orderByComparator) {

		
		 return studentPersistence.findAll(start, end, orderByComparator);
		 

		
	}

}