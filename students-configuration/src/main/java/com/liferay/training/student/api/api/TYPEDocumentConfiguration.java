package com.liferay.training.student.api.api;
import aQute.bnd.annotation.metatype.Meta;


/**
 * @author carlos.machacon
 */


@Meta.OCD(
	    id = "com.liferay.training.student.api.api.TYPEDocumentConfiguration",
	    localization = "content/Language", 
	    name = "typeDocumentConfiguration"
)


public interface TYPEDocumentConfiguration {
	@Meta.AD(
	        name = "typeDocuments",
	        
	        
	        required = false
	         )
		 public String[] typeDocument();
}