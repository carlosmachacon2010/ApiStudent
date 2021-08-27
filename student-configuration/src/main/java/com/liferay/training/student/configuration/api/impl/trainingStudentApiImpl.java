package com.liferay.training.student.configuration.api.impl;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;

import com.liferay.training.student.configuration.api.trainingStudentApi;
import com.liferay.training.student.configuration.api.typeDocumentConfiguration;
import com.liferay.training.students.model.Student;
import com.liferay.training.students.service.StudentLocalService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Reference;

import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.Modified;

@Component(immediate = true, properties = "com.liferay.training.student.configuration.api.typeDocumentConfiguration")

public class trainingStudentApiImpl implements trainingStudentApi {
	@Reference
	StudentLocalService studentlocalservice;

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_Configuration = ConfigurableUtil.createConfigurable(typeDocumentConfiguration.class, properties);
	}

	public volatile typeDocumentConfiguration _Configuration;

	@Override
	public List<Student> getqueryTypeDocument() {
		// TODO Auto-generated method stub	
		System.out.println("tipos desde api" + studentlocalservice.getqueryTypeDocument(_Configuration.typeDocument()) );
		return studentlocalservice.getqueryTypeDocument(_Configuration.typeDocument());
	}

}
