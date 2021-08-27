package com.liferay.training.student.configuration.api;
import aQute.bnd.annotation.metatype.Meta;

/**
 * @author carlos.machacon
 */

@Meta.OCD(
	    id = "com.liferay.training.student.configuration.api.typeDocumentConfiguration",
	    localization = "content/Language", 
	    name = "typeDocumentConfiguration"
)


public interface typeDocumentConfiguration {
	@Meta.AD(
	        name = "typeDocuments",
	        optionLabels = {"citizenship card", "passport","Identity Card","foreigner's card","special permission to stay"},
	        optionValues = {"citizenship card", "passport","Identity Card","foreigner's card","special permission to stay"}, 
	        required = false
	         )
		 public String typeDocument();
}