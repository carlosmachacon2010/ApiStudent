package com.liferay.training.student.web.portlet;

import com.liferay.training.student.web.constants.StudentPortletKeys;

import com.liferay.training.students.service.StudentLocalService;

import java.io.IOException;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author carlos.machacon
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Student",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + StudentPortletKeys.STUDENT,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class StudentPortlet extends MVCPortlet {
	@Reference
	StudentLocalService studentlocalservice;
	
	
	
	
  @ProcessAction(name="createStudent")
  public void createStudent(ActionRequest request,ActionResponse response) throws IOException,PortletException,SystemException,PortalException{
	  String name=ParamUtil.getString(request,StudentPortletKeys.NAME);
	  String lastName=ParamUtil.getString(request,StudentPortletKeys.lASTNAME);
	  String documentNumber=ParamUtil.getString(request,StudentPortletKeys.DOCUMENTNUMBER);
	  String typeDocument=ParamUtil.getString(request,StudentPortletKeys.TYPEDOCUMENT);
	  String university=ParamUtil.getString(request,StudentPortletKeys.UNIVERSITY);
	  
	  
	  
	  
	  if(studentlocalservice.addStudent(documentNumber, typeDocument, name, lastName, university)!=null) {
		  SessionMessages.add(request, "entryAdded");  
		  
	  }else {
		  SessionErrors.add(request,"error"); 
		  
	     } 
	  
	    request.setAttribute("Messages","algo");
	  
	  
	  
  }  
	
  @ProcessAction(name="Search")
  public void Search(ActionRequest request,ActionResponse response) throws IOException,PortletException,SystemException,PortalException{
	  String documentNumber=ParamUtil.getString(request,StudentPortletKeys.DOCUMENTNUMBER);
	  String typeDocument=ParamUtil.getString(request,StudentPortletKeys.TYPEDOCUMENT);
	  request.setAttribute("student",studentlocalservice.getfindByStudentnumberTypeDocument(documentNumber, typeDocument));
  }
}