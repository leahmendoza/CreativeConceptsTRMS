package com.revature.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Reimbursement_Form;
import com.revature.util.ConnectionClosers;
import com.revature.util.ConnectionFactory;

public class Reimbursement_FormRepositoryImpl implements ReimbursementRepository {

	/*
	 * METHOD FOR GETTING ACCUMULATIVE DATA FROM POSTGRES
	 */
	public List<Reimbursement_Form> getAllReimbursement_Forms() {
		ArrayList<Reimbursement_Form> reimbursement_forms = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		final String SQL = "select * from form";

		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.createStatement();
			set = stmt.executeQuery(SQL);

			while (set.next()) {
				reimbursement_forms.add(new Reimbursement_Form(set.getInt(1), set.getString(2), set.getString(3),
						set.getString(4), set.getString(5), set.getString(6), set.getDouble(7), set.getBytes(8),
						set.getString(9), set.getString(10), set.getBoolean(11), set.getBoolean(12), set.getInt(13),
						set.getInt(14), set.getInt(15), set.getString(16), set.getString(17)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeResultSet(set);
			ConnectionClosers.closeStatement(stmt);
		}
		return reimbursement_forms;
	}

	/*
	 * METHOD FOR GETTING ACCUMLATIVE DATA BY USERNAME
	 */
	public List<Reimbursement_Form> getAllReimbursement_Form_By_Username(String username) {
		ArrayList<Reimbursement_Form> reimbursement_forms = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		final String SQL = "select * from form where username = ?";

		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setString(1, username);
			set = stmt.executeQuery();

			while (set.next()) {
				reimbursement_forms.add(new Reimbursement_Form(set.getInt(1), set.getString(2), set.getString(3),
						set.getString(4), set.getString(5), set.getString(6), set.getDouble(7), set.getBytes(8),
						set.getString(9), set.getString(10), set.getBoolean(11), set.getBoolean(12), set.getInt(13),
						set.getInt(14), set.getInt(15), set.getString(16), set.getString(17)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeResultSet(set);
			ConnectionClosers.closeStatement(stmt);
		}
		return reimbursement_forms;
	}

	/*
	 * METHOD FOR GETTING ACCUMLATIVE DATA BY ID
	 */
	public Reimbursement_Form getReimbursement_FormById(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		Reimbursement_Form form = new Reimbursement_Form();
		form.setId_reimburesment(id);

		try {
			conn = ConnectionFactory.getConnection();
			//Query for selecting form by id
			stmt = conn.prepareStatement("select * from form where id_reimbursement_form =" + id); 
			// stmt.setInt(1, id);
			set = stmt.executeQuery(); // To execute:

			while (set.next()) {
				System.out.println(set.getInt(1) + "," + set.getString(2) + set.getString(3));

				// this result set fills in the empty reimbursement form object
				int id_reimbursement_form = set.getInt(1); // getting result set (position 1) assigning it to
															// id_reimbursement form
				form.setId_reimburesment(id_reimbursement_form); // this puts the value of the id_reimbursement form
																	// into the object
				String campus = set.getString(2);
				form.setCampus(campus);

				String date_received = set.getString(3);
				form.setDate_received(date_received);

				String grading_format = set.getString(4);
				form.setGrading_format(grading_format);

				String reason = set.getString(5);
				form.setReason(reason);

				String description = set.getString(6);
				form.setDescription(description);

				double cost = set.getDouble(7);
				form.setCost(cost);

				byte[] supporting_document = set.getBytes(8);
				form.setSupporting_document(supporting_document);

				String timeOfAbsence_FROM = set.getString(9);
				form.setTimeOfAbsence_FROM(timeOfAbsence_FROM);

				String timeOfAbsence_TO = set.getString(10);
				form.setTimeOfAbsence_TO(timeOfAbsence_TO);

				boolean exceeding_funds = set.getBoolean(11);
				form.setExceeding_funds(exceeding_funds);

				boolean urgent = set.getBoolean(12);
				form.setUrgent(urgent);

				int approved_by_sup = set.getInt(13);
				form.setApproved_by_sup(approved_by_sup);

				int approved_by_dh = set.getInt(14);
				form.setApproved_by_dh(approved_by_dh);

				int approved_by_benco = set.getInt(15);
				form.setApproved_by_benco(approved_by_benco);

				String event_type = set.getString(16);
				form.setTimeOfAbsence_TO(event_type);

				String username = set.getString(17);
				form.setTimeOfAbsence_TO(username);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close(); // closing connection
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return form;
	}
	
	/*
	 * METHOD FOR GETTING ALL PENDING FORMS FROM EMPLOYEES !!!UNDER!!! DEPARTMENT HEAD
	 */
	public List<Reimbursement_Form> getAllReimbursement_Form_Pending_UnderDH() {
		ArrayList<Reimbursement_Form> reimbursement_forms = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;

		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement("select * from form where username = 'emp_username' and approved_by_sup = 1 and approved_by_dh = 0 union select * from form where username = 'super_username' and approved_by_dh = 0");
			set = stmt.executeQuery();

			while (set.next()) {
				System.out.println("HEREEEEE");
				reimbursement_forms.add(new Reimbursement_Form(set.getInt(1), set.getString(2), set.getString(3),
						set.getString(4), set.getString(5), set.getString(6), set.getDouble(7), set.getBytes(8),
						set.getString(9), set.getString(10), set.getBoolean(11), set.getBoolean(12), set.getInt(13),
						set.getInt(14), set.getInt(15), set.getString(16), set.getString(17)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close(); // closing connection
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return reimbursement_forms;
	}
	
	/*
	 * METHOD FOR INSERTING EMPLOYEES FORM INTO POSTGRES DB
	 */
	public void insertReimbursement_Form(Reimbursement_Form f) {
		// Making connection
		Connection conn = null;
		// Statement that is executed to insert into the reimbursement_form table in the
		// postgres db
		Date received_date = java.sql.Date.valueOf(f.date_received);
		System.out.println(f.date_received);
		Date timeOfAbsence_from = java.sql.Date.valueOf(f.timeOfAbsence_FROM);
		Date timeOfAbsence_to = java.sql.Date.valueOf(f.timeOfAbsence_TO);
		PreparedStatement stmt = null;

		try {
			conn = ConnectionFactory.getConnection();

			stmt = conn.prepareStatement(
					"insert into form (id_reimbursement_form ,campus, date_received, grading_format, reason, description, cost, timeOfAbsence_FROM, "
							+ "timeOfAbsence_TO, approved_by_sup, approved_by_dh, approved_by_benco, event_type, username) values(default, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			// Insert Query is stated above
			stmt.setString(1, f.campus);
			stmt.setDate(2, received_date);
			stmt.setString(3, f.grading_format);
			stmt.setString(4, f.reason);
			stmt.setString(5, f.description);
			stmt.setDouble(6, f.cost);
			stmt.setDate(7, timeOfAbsence_from);
			stmt.setDate(8, timeOfAbsence_to);
			// stmt.setBoolean(10, f.exceeding_funds);
			// stmt.setBoolean(11, f.urgent);
			stmt.setInt(9, f.approved_by_sup);
			stmt.setInt(10, f.approved_by_dh);
			stmt.setInt(11, f.approved_by_benco);
			stmt.setString(12, f.event_type);
			stmt.setString(13, f.username);
			stmt.execute(); // To execute:

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close(); // closing connection
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	
	/*
	 * REGULAR EMPLOYEE'S METHOD FOR GETTING PENDING FORMS
	 */
	public List<Reimbursement_Form> getAllReimbursement_Form_Emp_Pending(String username) {
		ArrayList<Reimbursement_Form> reimbursement_forms = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		final String SQL = "select * from form where username = ?  and approved_by_sup = 0 and approved_by_dh = 0 and approved_by_benco = 0";

		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setString(1, username);
			set = stmt.executeQuery();

			while (set.next()) {
				reimbursement_forms.add(new Reimbursement_Form(set.getInt(1), set.getString(2), set.getString(3),
						set.getString(4), set.getString(5), set.getString(6), set.getDouble(7), set.getBytes(8),
						set.getString(9), set.getString(10), set.getBoolean(11), set.getBoolean(12), set.getInt(13),
						set.getInt(14), set.getInt(15), set.getString(16), set.getString(17)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeResultSet(set);
			ConnectionClosers.closeStatement(stmt);
		}
		return reimbursement_forms;
	}

	/*
	 * REGULAR EMPLOYEE'S METHOD FOR LOG
	 */
	public List<Reimbursement_Form> getAllReimbursement_Form_Emp_Log(String username) {
		ArrayList<Reimbursement_Form> reimbursement_forms = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		final String SQL = "select * from form where username = ? and approved_by_sup != 0 ";

		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setString(1, username);
			set = stmt.executeQuery();

			while (set.next()) {
				reimbursement_forms.add(new Reimbursement_Form(set.getInt(1), set.getString(2), set.getString(3),
						set.getString(4), set.getString(5), set.getString(6), set.getDouble(7), set.getBytes(8),
						set.getString(9), set.getString(10), set.getBoolean(11), set.getBoolean(12), set.getInt(13),
						set.getInt(14), set.getInt(15), set.getString(16), set.getString(17)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeResultSet(set);
			ConnectionClosers.closeStatement(stmt);
		}
		return reimbursement_forms;
	}

	/*
	 * SUPERVISOR'S METHOD FOR GETTING PENDING FORMS
	 */
	public List<Reimbursement_Form> getAllReimbursement_Form_Sup_Pending(String username) {
		ArrayList<Reimbursement_Form> reimbursement_forms = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		final String SQL = "select * from form where username = ? and approved_by_dh = 0";

		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setString(1, username);
			set = stmt.executeQuery();

			while (set.next()) {
				reimbursement_forms.add(new Reimbursement_Form(set.getInt(1), set.getString(2), set.getString(3),
						set.getString(4), set.getString(5), set.getString(6), set.getDouble(7), set.getBytes(8),
						set.getString(9), set.getString(10), set.getBoolean(11), set.getBoolean(12), set.getInt(13),
						set.getInt(14), set.getInt(15), set.getString(16), set.getString(17)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeResultSet(set);
			ConnectionClosers.closeStatement(stmt);
		}
		return reimbursement_forms;
	}

	/*
	 * SUPERVISOR'S METHOD FOR LOG
	 */
	public List<Reimbursement_Form> getAllReimbursement_Form_Sup_Log(String username) {
		ArrayList<Reimbursement_Form> reimbursement_forms = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		final String SQL = "select * from form where username = ? and approved_by_dh != 0 ";

		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setString(1, username);
			set = stmt.executeQuery();

			while (set.next()) {
				reimbursement_forms.add(new Reimbursement_Form(set.getInt(1), set.getString(2), set.getString(3),
						set.getString(4), set.getString(5), set.getString(6), set.getDouble(7), set.getBytes(8),
						set.getString(9), set.getString(10), set.getBoolean(11), set.getBoolean(12), set.getInt(13),
						set.getInt(14), set.getInt(15), set.getString(16), set.getString(17)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeResultSet(set);
			ConnectionClosers.closeStatement(stmt);
		}
		return reimbursement_forms;
	}
	
	/*
	 * SUPERVISOR'S APPROVAL METHOD // APPROVE = 1
	 */
	public void approve_Reimbursement_Form(String username, int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
//		final String SQL = "update form set approved_by_sup = 1 where username = ? and id_reimbursement_form = ?";
//		System.out.println(username+" "+id);
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement("update form set approved_by_sup = 1 where username = ? and id_reimbursement_form = ?");
			stmt.setString(1, username);
			stmt.setInt(2, id);
			stmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
		}
	}
	/*
	 * SUPERVISOR'S DENIAL METHOD // DENY = 2
	 */
	public void deny_Reimbursement_Form(String username, int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		//final String SQL = "update form set approved_by_sup = 2 where username = ? and id_reimbursement_form = ?";

		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement("update form set approved_by_sup = 2 where username = ? and id_reimbursement_form = ?");
			stmt.setString(1, username);
			stmt.setInt(2, id);
			stmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
		}
	}

	/*
	 * DEPARTMENT HEAD'S METHOD FOR GETTING PENDING FORMS
	 */
	public List<Reimbursement_Form> getAllReimbursement_Form_DH_Pending(String username) {
		ArrayList<Reimbursement_Form> reimbursement_forms = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;

		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement("select * from form where username = ? and approved_by_benco = 0");
			stmt.setString(1, username);
			set = stmt.executeQuery();

			while (set.next()) {
				reimbursement_forms.add(new Reimbursement_Form(set.getInt(1), set.getString(2), set.getString(3),
						set.getString(4), set.getString(5), set.getString(6), set.getDouble(7), set.getBytes(8),
						set.getString(9), set.getString(10), set.getBoolean(11), set.getBoolean(12), set.getInt(13),
						set.getInt(14), set.getInt(15), set.getString(16), set.getString(17)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeResultSet(set);
			ConnectionClosers.closeStatement(stmt);
		}
		return reimbursement_forms;
	}
	
	/*
	 * METHOD FOR INSERTING DEPARTMENT HEAD'S FORM INTO POSTGRES DB
	 */
	public void insertReimbursement_Form_DH(Reimbursement_Form dh_f) {
		// Making connection
				Connection conn = null;
				// Statement that is executed to insert into the reimbursement_form table in the
				// postgres db
				Date received_date = java.sql.Date.valueOf(dh_f.date_received);
				System.out.println(dh_f.date_received);
				Date timeOfAbsence_from = java.sql.Date.valueOf(dh_f.timeOfAbsence_FROM);
				Date timeOfAbsence_to = java.sql.Date.valueOf(dh_f.timeOfAbsence_TO);
				PreparedStatement stmt = null;

				try {
					conn = ConnectionFactory.getConnection();

					stmt = conn.prepareStatement(
							"insert into form (id_reimbursement_form ,campus, date_received, grading_format, reason, description, cost, timeOfAbsence_FROM, "
									+ "timeOfAbsence_TO, approved_by_sup, approved_by_dh, approved_by_benco, event_type, username) values(default, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
					// Insert Query is stated above
					stmt.setString(1, dh_f.campus);
					stmt.setDate(2, received_date);
					stmt.setString(3, dh_f.grading_format);
					stmt.setString(4, dh_f.reason);
					stmt.setString(5, dh_f.description);
					stmt.setDouble(6, dh_f.cost);
					stmt.setDate(7, timeOfAbsence_from);
					stmt.setDate(8, timeOfAbsence_to);
					// stmt.setBoolean(10, f.exceeding_funds);
					// stmt.setBoolean(11, f.urgent);
					stmt.setInt(9, dh_f.approved_by_sup);
					stmt.setInt(10, dh_f.approved_by_dh);
					stmt.setInt(11, dh_f.approved_by_benco);
					stmt.setString(12, dh_f.event_type);
					stmt.setString(13, dh_f.username);
					stmt.execute(); // To execute:

				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						conn.close(); // closing connection
						stmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
	}
	
	/*
	 * DEPARTMENT HEAD'S METHOD FOR LOG
	 */
	public List<Reimbursement_Form> getAllReimbursement_Form_DH_Log(String username) {
		ArrayList<Reimbursement_Form> reimbursement_forms = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		final String SQL = "select * from form where username = ? and approved_by_benco != 0";

		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setString(1, username);
			set = stmt.executeQuery();

			while (set.next()) {
				reimbursement_forms.add(new Reimbursement_Form(set.getInt(1), set.getString(2), set.getString(3),
						set.getString(4), set.getString(5), set.getString(6), set.getDouble(7), set.getBytes(8),
						set.getString(9), set.getString(10), set.getBoolean(11), set.getBoolean(12), set.getInt(13),
						set.getInt(14), set.getInt(15), set.getString(16), set.getString(17)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeResultSet(set);
			ConnectionClosers.closeStatement(stmt);
		}
		return reimbursement_forms;
	}
	
	// DEPARTMENT HEAD APPROVAL // APPROVE = 1
	public void DH_approve_Reimbursement_Form(String username, int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement("update form set approved_by_dh = 1 where username = ? and id_reimbursement_form = ?");
			stmt.setString(1, username);
			stmt.setInt(2, id);
			stmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
		}
		
	}
	
	// DEPARTMENT HEAD DENIAL // DENY = 2
	public void DH_deny_Reimbursement_Form(String username, int id) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement("update form set approved_by_dh = 2 where username = ? and id_reimbursement_form = ?");
			stmt.setString(1, username);
			stmt.setInt(2, id);
			stmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeStatement(stmt);
		}
		
	}

	
	/*
	 * BENCO'S PENDING FORMS
	 */
	@Override
	public List<Reimbursement_Form> getAllReimbursement_Form_Benco_Pending(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	 * METHOD FOR INSERTING SUPERVISORS FORM INTO POSTGRES DB
	 */
	public void insertReimbursement_Form_Sup(Reimbursement_Form sup_f) {
		// Making connection
		Connection conn = null;
		// Statement that is executed to insert into the reimbursement_form table in the
		// postgres db
		Date received_date = java.sql.Date.valueOf(sup_f.date_received);
		System.out.println(sup_f.date_received);
		Date timeOfAbsence_from = java.sql.Date.valueOf(sup_f.timeOfAbsence_FROM);
		Date timeOfAbsence_to = java.sql.Date.valueOf(sup_f.timeOfAbsence_TO);
		PreparedStatement stmt = null;

		try {
			conn = ConnectionFactory.getConnection();

			stmt = conn.prepareStatement(
					"insert into form (id_reimbursement_form ,campus, date_received, grading_format, reason, description, cost, timeOfAbsence_FROM, "
							+ "timeOfAbsence_TO, approved_by_sup, approved_by_dh, approved_by_benco, event_type, username) values(default, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			// Insert Query is stated above
			stmt.setString(1, sup_f.campus);
			stmt.setDate(2, received_date);
			stmt.setString(3, sup_f.grading_format);
			stmt.setString(4, sup_f.reason);
			stmt.setString(5, sup_f.description);
			stmt.setDouble(6, sup_f.cost);
			stmt.setDate(7, timeOfAbsence_from);
			stmt.setDate(8, timeOfAbsence_to);
			// stmt.setBoolean(10, f.exceeding_funds);
			// stmt.setBoolean(11, f.urgent);
			stmt.setInt(9, sup_f.approved_by_sup);
			stmt.setInt(10, sup_f.approved_by_dh);
			stmt.setInt(11, sup_f.approved_by_benco);
			stmt.setString(12, sup_f.event_type);
			stmt.setString(13, sup_f.username);
			stmt.execute(); // To execute:

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close(); // closing connection
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	
	/*
	 * METHOD FOR INSERTING BENCO'S FORM INTO POSTGRES DB
	 */
	public void insertReimbursement_Form_Benco(Reimbursement_Form benco_f) {
		// Making connection
				Connection conn = null;
				// Statement that is executed to insert into the reimbursement_form table in the
				// postgres db
				Date received_date = java.sql.Date.valueOf(benco_f.date_received);
				System.out.println(benco_f.date_received);
				Date timeOfAbsence_from = java.sql.Date.valueOf(benco_f.timeOfAbsence_FROM);
				Date timeOfAbsence_to = java.sql.Date.valueOf(benco_f.timeOfAbsence_TO);
				PreparedStatement stmt = null;

				try {
					conn = ConnectionFactory.getConnection();

					stmt = conn.prepareStatement(
							"insert into form (id_reimbursement_form ,campus, date_received, grading_format, reason, description, cost, timeOfAbsence_FROM, "
									+ "timeOfAbsence_TO, approved_by_sup, approved_by_dh, approved_by_benco, event_type, username) values(default, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
					// Insert Query is stated above
					stmt.setString(1, benco_f.campus);
					stmt.setDate(2, received_date);
					stmt.setString(3, benco_f.grading_format);
					stmt.setString(4, benco_f.reason);
					stmt.setString(5, benco_f.description);
					stmt.setDouble(6, benco_f.cost);
					stmt.setDate(7, timeOfAbsence_from);
					stmt.setDate(8, timeOfAbsence_to);
					stmt.setInt(9, benco_f.approved_by_sup);
					stmt.setInt(10, benco_f.approved_by_dh);
					stmt.setInt(11, benco_f.approved_by_benco);
					stmt.setString(12, benco_f.event_type);
					stmt.setString(13, benco_f.username);
					stmt.execute(); // To execute:

				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						conn.close(); // closing connection
						stmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
		
	}
	
	/*
	 * METHOD FOR GETTING BENCO'S LOG
	 */
	public List<Reimbursement_Form> getAllReimbursement_Form_Benco_Log(String username) {
		ArrayList<Reimbursement_Form> reimbursement_forms = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		final String SQL = "select * from form where username = ? and approved_by_benco != 0";

		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setString(1, username);
			set = stmt.executeQuery();

			while (set.next()) {
				reimbursement_forms.add(new Reimbursement_Form(set.getInt(1), set.getString(2), set.getString(3),
						set.getString(4), set.getString(5), set.getString(6), set.getDouble(7), set.getBytes(8),
						set.getString(9), set.getString(10), set.getBoolean(11), set.getBoolean(12), set.getInt(13),
						set.getInt(14), set.getInt(15), set.getString(16), set.getString(17)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeResultSet(set);
			ConnectionClosers.closeStatement(stmt);
		}
		return reimbursement_forms;
	}

	@Override
	public void Benco_approve_Reimbursement_Form(String username, int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Benco_deny_Reimbursement_Form(String username, int id) {
		// TODO Auto-generated method stub
		
	}

}
