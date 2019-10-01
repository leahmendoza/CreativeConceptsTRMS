package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.model.Reimbursement_Form;
import com.revature.service.DocumentService;
import com.revature.service.EmployeeService;
import com.revature.service.EventService;
import com.revature.service.Reimbursement_FormService;
import com.revature.service.RoleService;

public class RequestHelper {
	
	/*
	 * Let's create a logger:
	 */
	
	private static final Logger loge = LogManager.getLogger(RequestHelper.class);
	
	/*
	 * This Request Helper will be used to implement the logic that
	 * determines what our Front Controller will send back to
	 * the client side.
	 */
	public static Object processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		loge.debug("In the Request Helper");
		
		String uri = request.getRequestURI().replace("/P1Servlet/creativeconcepts", "");
		
		loge.debug(uri);
		
		switch(uri) {
		//This end point returns a list of different db table data
		
				case "/reimburesmentforms":
					return new Reimbursement_FormService().getAllReimbursement_Forms();
				
				//Cases for all employee related logic	
					case "/reimburesmentforms/emp_username":
						return new Reimbursement_FormService().getAllReimbursement_Form_By_Username("emp_username");
					
					//case "/reimburesmentforms/form_by_id":
					//	return new Reimbursement_FormService().getReimbursement_FormById(id);
						
					case "/reimburesmentforms/emp_pending":
						return new Reimbursement_FormService().getAllReimbursement_Form_Emp_Pending("emp_username");
						
					case "/reimburesmentforms/emp_log":
						return new Reimbursement_FormService().getAllReimbursement_Form_Emp_Log("emp_username");
						
					case "/reimburesmentforms/emp_submit":
						String campus = request.getParameter("campus");
						String date_received = request.getParameter("date_received");
						String grading_format = request.getParameter("grading_format");
						String reason = request.getParameter("reason");
						String description = request.getParameter("description");
						Double cost = Double.parseDouble(request.getParameter("cost"));
						String timeOfAbsence_FROM = request.getParameter("timeOfAbsence_FROM");
						String timeOfAbsence_TO = request.getParameter("timeOfAbsence_TO");
						String event_type = request.getParameter("event_type");
						
						Reimbursement_Form f = new Reimbursement_Form();
						f.setDate_received(date_received);
						f.setCampus(campus);
						f.setGrading_format(grading_format);
						f.setReason(reason);
						f.setDescription(description);
						f.setCost(cost);
						f.setTimeOfAbsence_FROM(timeOfAbsence_FROM);
						f.setTimeOfAbsence_TO(timeOfAbsence_TO);
						f.setEvent_type(event_type);
						f.setApproved_by_sup(0);
						f.setApproved_by_dh(0);
						f.setApproved_by_benco(0);
						f.setUsername(request.getSession().getAttribute("username").toString());
						
						new Reimbursement_FormService().insertReimburesment_Form(f);
						return "Form Submitted!";
						
				//Cases for all supervisor related logic
					case "/reimburesmentforms/super_username":
						return new Reimbursement_FormService().getAllReimbursement_Form_By_Username("super_username");
	
					case "/reimburesmentforms/supervisor_pending":
						return new Reimbursement_FormService().getAllReimbursement_Form_Sup_Pending("super_username");
						
					case "/reimburesmentforms/sup_log":
						return new Reimbursement_FormService().getAllReimbursement_Form_Sup_Log("super_username");
						
					case "/sub_action":
						String username = request.getParameter("username");
						int id = Integer.parseInt(request.getParameter("id_reimbursement"));
						int value = Integer.parseInt(request.getParameter("action"));
						if (value == 1) {
							new Reimbursement_FormService().approve_Reimbursement_Form(username, id);
						} else if (value == 2) {
							new Reimbursement_FormService().deny_Reimbursement_Form(username, id);
						}
						response.sendRedirect("../views/direct_supervisor/status.html");
					return"Action submitted!";
					
					case "/reimburesmentforms/sup_submit":
						String sup_campus = request.getParameter("campus");
						String sup_date_received = request.getParameter("date_received");
						String sup_grading_format = request.getParameter("grading_format");
						String sup_reason = request.getParameter("reason");
						String sup_description = request.getParameter("description");
						Double sup_cost = Double.parseDouble(request.getParameter("cost"));
						String sup_timeOfAbsence_FROM = request.getParameter("timeOfAbsence_FROM");
						String sup_timeOfAbsence_TO = request.getParameter("timeOfAbsence_TO");
						String sup_event_type = request.getParameter("event_type");
						
						Reimbursement_Form sup_f = new Reimbursement_Form();
						sup_f.setDate_received(sup_date_received);
						sup_f.setCampus(sup_campus);
						sup_f.setGrading_format(sup_grading_format);
						sup_f.setReason(sup_reason);
						sup_f.setDescription(sup_description);
						sup_f.setCost(sup_cost);
						sup_f.setTimeOfAbsence_FROM(sup_timeOfAbsence_FROM);
						sup_f.setTimeOfAbsence_TO(sup_timeOfAbsence_TO);
						sup_f.setEvent_type(sup_event_type);
						sup_f.setApproved_by_sup(0);
						sup_f.setApproved_by_dh(0);
						sup_f.setApproved_by_benco(0);
						sup_f.setUsername(request.getSession().getAttribute("username").toString());
						
						new Reimbursement_FormService().insertReimburesment_Form_Sup(sup_f);
						response.sendRedirect("../views/direct_supervisor/status.html");
						return "Form Submitted!";
				
				//Cases for all department head related logic	
					case "/reimburesmentforms/dh_username":
						return new Reimbursement_FormService().getAllReimbursement_Form_By_Username("directhead_username");	
					
					case "/reimburesmentforms/dh_submit":
						String dh_campus = request.getParameter("campus");
						String dh_date_received = request.getParameter("date_received");
						String dh_grading_format = request.getParameter("grading_format");
						String dh_reason = request.getParameter("reason");
						String dh_description = request.getParameter("description");
						Double dh_cost = Double.parseDouble(request.getParameter("cost"));
						String dh_timeOfAbsence_FROM = request.getParameter("timeOfAbsence_FROM");
						String dh_timeOfAbsence_TO = request.getParameter("timeOfAbsence_TO");
						String dh_event_type = request.getParameter("event_type");
						
						Reimbursement_Form dh_f = new Reimbursement_Form();
						dh_f.setDate_received(dh_date_received);
						dh_f.setCampus(dh_campus);
						dh_f.setGrading_format(dh_grading_format);
						dh_f.setReason(dh_reason);
						dh_f.setDescription(dh_description);
						dh_f.setCost(dh_cost);
						dh_f.setTimeOfAbsence_FROM(dh_timeOfAbsence_FROM);
						dh_f.setTimeOfAbsence_TO(dh_timeOfAbsence_TO);
						dh_f.setEvent_type(dh_event_type);
						dh_f.setApproved_by_sup(1);
						dh_f.setApproved_by_dh(1);
						dh_f.setApproved_by_benco(0);
						dh_f.setUsername(request.getSession().getAttribute("username").toString());
						
						new Reimbursement_FormService().insertReimburesment_Form_DH(dh_f);
						return "Form Submitted!";
						
					case "/reimburesmentforms/dh_pending":
						return new Reimbursement_FormService().getAllReimbursement_Form_DH_Pending("directhead_username");
						
					case "/pending_under_dh":
						return new Reimbursement_FormService().getAllReimbursement_Form_Pending_UnderDH();
						
					case "/reimburesmentforms/dh_log":
						return new Reimbursement_FormService().getAllReimbursement_Form_DH_Log("directhead_username");
					
					case "/dh_action":
						String dh_username = request.getParameter("username");
						int dh_id = Integer.parseInt(request.getParameter("id_reimbursement"));
						int dh_value = Integer.parseInt(request.getParameter("action"));
						if (dh_value == 1) {
							new Reimbursement_FormService().DH_approve_Reimbursement_Form(dh_username, dh_id);
						} else if (dh_value == 2) {
							new Reimbursement_FormService().DH_deny_Reimbursement_Form(dh_username, dh_id);
						}
						response.sendRedirect("../views/direct_supervisor/status.html");
					return"Action submitted!";
						
				//Cases for all benefits coordinator related logic
					case "/reimburesmentforms/benco_username":
						return new Reimbursement_FormService().getAllReimbursement_Form_By_Username("benco_username");	
						
					case "/reimburesmentforms/benco_submit":
						String benco_campus = request.getParameter("campus");
						String benco_date_received = request.getParameter("date_received");
						String benco_grading_format = request.getParameter("grading_format");
						String benco_reason = request.getParameter("reason");
						String benco_description = request.getParameter("description");
						Double benco_cost = Double.parseDouble(request.getParameter("cost"));
						String benco_timeOfAbsence_FROM = request.getParameter("timeOfAbsence_FROM");
						String benco_timeOfAbsence_TO = request.getParameter("timeOfAbsence_TO");
						String benco_event_type = request.getParameter("event_type");
						
						Reimbursement_Form benco_f = new Reimbursement_Form();
						benco_f.setDate_received(benco_date_received);
						benco_f.setCampus(benco_campus);
						benco_f.setGrading_format(benco_grading_format);
						benco_f.setReason(benco_reason);
						benco_f.setDescription(benco_description);
						benco_f.setCost(benco_cost);
						benco_f.setTimeOfAbsence_FROM(benco_timeOfAbsence_FROM);
						benco_f.setTimeOfAbsence_TO(benco_timeOfAbsence_TO);
						benco_f.setEvent_type(benco_event_type);
						benco_f.setApproved_by_sup(1);
						benco_f.setApproved_by_dh(1);
						benco_f.setApproved_by_benco(0);
						benco_f.setUsername(request.getSession().getAttribute("username").toString());
						
						new Reimbursement_FormService().insertReimburesment_Form_Benco(benco_f);
						return "Form Submitted!";
				
					case "/reimburesmentforms/benco_log":
						return new Reimbursement_FormService().getAllReimbursement_Form_Benco_Log("benco_username");
				
					//Cases for fetching all data in other tables	
					case "/employees":
						return new EmployeeService().getAllEmployees();
						
					case "/events":
						return new EventService().getAllEvents();
						
					case "/roles":
						return new RoleService().getAllRoles();
						
					case "/documents":
						return new DocumentService().getAllDocuments();
				
				//This end point is the default if no match is found.
					default:
						return "No such endpoint";
		}
		
	}
}
