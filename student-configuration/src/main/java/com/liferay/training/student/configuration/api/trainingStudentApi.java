package com.liferay.training.student.configuration.api;

import com.liferay.training.students.model.Student;
import com.liferay.training.students.service.StudentLocalService;


import java.util.List;

import org.osgi.service.component.annotations.Reference;

public interface trainingStudentApi {
	
     public List<Student> getqueryTypeDocument(); 
}
