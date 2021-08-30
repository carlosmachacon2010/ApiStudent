package com.liferay.training.student.configuration.api.impl;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;


import com.liferay.training.student.configuration.api.trainingStudentApi;
import com.liferay.training.student.configuration.api.typeDocumentConfiguration;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Reference;

import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.Modified;

@Component(immediate = true, 
configurationPid="com.liferay.training.student.configuration.api.typeDocumentConfiguration")

public class trainingStudentApiImpl implements trainingStudentApi {
	

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_Configuration = ConfigurableUtil.createConfigurable(typeDocumentConfiguration.class, properties);
	}

	public volatile typeDocumentConfiguration _Configuration;

	@Override
	public String[] getqueryTypeDocument() {
		// TODO Auto-generated method stub	
		
		return  _Configuration.typeDocument();
	}
}
	
