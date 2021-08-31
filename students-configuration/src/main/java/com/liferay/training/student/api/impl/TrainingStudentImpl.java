package com.liferay.training.student.api.impl;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.training.student.api.api.TYPEDocumentConfiguration;
import com.liferay.training.student.api.api.TrainingStudent;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;


@Component(immediate = true,
service = TrainingStudent.class,
configurationPid="com.liferay.training.student.api.api.TYPEDocumentConfiguration")

public class TrainingStudentImpl implements TrainingStudent{
	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_Configuration = ConfigurableUtil.createConfigurable(TYPEDocumentConfiguration.class, properties);
	}
	
	public volatile TYPEDocumentConfiguration _Configuration;

	@Override
	public String[] getqueryTypeDocument() {
		
		return _Configuration.typeDocument();
	}
	
}
