package com.revature.repository;

import java.util.List;

import com.revature.model.Reimbursement_Form;

public interface ReimbursementRepository {
	List<Reimbursement_Form> getAllReimbursement_Forms(); //iterate through all forms
	List<Reimbursement_Form> getAllReimbursement_Form_By_Username(String username); //Get form by user name
	List<Reimbursement_Form> getAllReimbursement_Form_Pending_UnderDH(); //Get pending employee info under DH
	Reimbursement_Form getReimbursement_FormById(int id); //get form data by id

	/*
	 * Employee's specific methods
	 */
	List<Reimbursement_Form> getAllReimbursement_Form_Emp_Pending(String username); //Get pending employee info
	List<Reimbursement_Form> getAllReimbursement_Form_Emp_Log(String username);
	void insertReimbursement_Form(Reimbursement_Form f); //insert form
	
	/*
	 * Supervisor's specific methods
	 */
	List<Reimbursement_Form> getAllReimbursement_Form_Sup_Pending(String username); //Get pending supervisor info
	List<Reimbursement_Form> getAllReimbursement_Form_Sup_Log(String username);
	//void insertReimburesment_Form_Sup(Reimbursement_Form sup_f);
	void approve_Reimbursement_Form(String username, int id); //Method for approving form
	void deny_Reimbursement_Form(String username, int id); //Method for denying form
	
	/*
	 * Department head's specific methods
	 */
	List<Reimbursement_Form> getAllReimbursement_Form_DH_Pending(String username); //Get pending DH info
	List<Reimbursement_Form> getAllReimbursement_Form_DH_Log(String username);
	//void insertReimburesment_Form_DH(Reimbursement_Form dh_f);
	void DH_approve_Reimbursement_Form(String username, int id); //Method for approving form
	void DH_deny_Reimbursement_Form(String username, int id); //Method for denying form
	
	/*
	 * Benco's specific methods
	 */
	List<Reimbursement_Form> getAllReimbursement_Form_Benco_Pending(String username); //Get pending Benco info
	List<Reimbursement_Form> getAllReimbursement_Form_Benco_Log(String username);
	//void insertReimburesment_Form_Benco(Reimbursement_Form benco_f);
	void Benco_approve_Reimbursement_Form(String username, int id); //Method for approving form
	void Benco_deny_Reimbursement_Form(String username, int id); //Method for denying form
	
}
