package com.revature.service;

import java.util.List;

import com.revature.model.Reimbursement_Form;
import com.revature.repository.Reimbursement_FormRepositoryImpl;

public class Reimbursement_FormService {
	
	/*
	 * GETTING ACCUMALATIVE DATA FROM POSTGRES DB
	 */
			public List<Reimbursement_Form> getAllReimbursement_Forms(){
				return new Reimbursement_FormRepositoryImpl().getAllReimbursement_Forms();
			}
			
			public List<Reimbursement_Form> getAllReimbursement_Form_By_Username(String username) {
				//Get by user name
				return new Reimbursement_FormRepositoryImpl().getAllReimbursement_Form_By_Username(username); 
			}
			
			public List<Reimbursement_Form> getAllReimbursement_Form_Pending_UnderDH(){
				//Get by user name
				return new Reimbursement_FormRepositoryImpl().getAllReimbursement_Form_Pending_UnderDH(); 
			}
			
			public void getReimbursement_FormById(int id){
				//Get form by id
				new Reimbursement_FormRepositoryImpl().getReimbursement_FormById(id); 
			}
			
	/*
	 * EMPLOYEE'S METHODS
	 */
			public List<Reimbursement_Form> getAllReimbursement_Form_Emp_Pending(String username) {
				//Get pending approvals for employee
				return new Reimbursement_FormRepositoryImpl().getAllReimbursement_Form_Emp_Pending(username); 
			}
			
			public List<Reimbursement_Form> getAllReimbursement_Form_Emp_Log(String username) {
				//Get log for employee
				return new Reimbursement_FormRepositoryImpl().getAllReimbursement_Form_Emp_Log(username); 
			}
	/*
	 * SUPERVISOR'S METHODS
	 */
			public List<Reimbursement_Form> getAllReimbursement_Form_Sup_Pending(String username) {
				//Get pending approvals for supervisor
				return new Reimbursement_FormRepositoryImpl().getAllReimbursement_Form_Sup_Pending(username); 
			}
			
			public List<Reimbursement_Form> getAllReimbursement_Form_Sup_Log(String username) {
				//Get log for supervisor
				return new Reimbursement_FormRepositoryImpl().getAllReimbursement_Form_Sup_Log(username); 
			}
			
			public void approve_Reimbursement_Form(String username, int id){
				//Get form by id
				new Reimbursement_FormRepositoryImpl().approve_Reimbursement_Form(username, id); 
			}
			
			public void deny_Reimbursement_Form(String username, int id){
				//Get form by id
				new Reimbursement_FormRepositoryImpl().deny_Reimbursement_Form(username, id); 
			}
	/*
	 * DEP HEAD'S METHODS
	 */
			public List<Reimbursement_Form> getAllReimbursement_Form_DH_Pending(String username) {
				//Get pending approvals for employee
				return new Reimbursement_FormRepositoryImpl().getAllReimbursement_Form_DH_Pending(username); 
			}
			
			public List<Reimbursement_Form> getAllReimbursement_Form_DH_Log(String username) {
				//Get log for department head
				return new Reimbursement_FormRepositoryImpl().getAllReimbursement_Form_DH_Log(username); 
			}
			
			public void DH_approve_Reimbursement_Form(String username, int id){
				//Get form by id
				new Reimbursement_FormRepositoryImpl().DH_approve_Reimbursement_Form(username, id); 
			}
			
			public void DH_deny_Reimbursement_Form(String username, int id){
				//Get form by id
				new Reimbursement_FormRepositoryImpl().DH_deny_Reimbursement_Form(username, id); 
			}
	/*
	 * BENCO'S METHODS
	 */
			public List<Reimbursement_Form> getAllReimbursement_Form_Benco_Log(String username) {
				//Get log for department head
				return new Reimbursement_FormRepositoryImpl().getAllReimbursement_Form_Benco_Log(username); 
			}	
	
	/*
	 * INSERT DATA INTO POSTGRES DB
	 */
			public void insertReimburesment_Form(Reimbursement_Form f){
				//Calling the method that inserts employees form
				new Reimbursement_FormRepositoryImpl().insertReimbursement_Form(f); 
			}
			
			public void insertReimburesment_Form_Sup(Reimbursement_Form sup_f){
				//Calling the method that inserts supervisors form
				new Reimbursement_FormRepositoryImpl().insertReimbursement_Form_Sup(sup_f); 
			}
			
			public void insertReimburesment_Form_DH(Reimbursement_Form dh_f){
				//Calling the method that inserts department head's form
				new Reimbursement_FormRepositoryImpl().insertReimbursement_Form_DH(dh_f); 
			}
			
			public void insertReimburesment_Form_Benco(Reimbursement_Form benco_f){
				//Calling the method that inserts benco's form
				new Reimbursement_FormRepositoryImpl().insertReimbursement_Form_Benco(benco_f); 
			}
			
}
