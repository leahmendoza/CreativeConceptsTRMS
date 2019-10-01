package com.revature.model;

import java.util.Arrays;

public class Reimbursement_Form {
	//Reimbursement Form Info Variables
	public int id_reimburesment;
	public String campus;
	public String date_received;
	public String grading_format;
	public String reason;
	public String description;
	public double cost;
	public byte[] supporting_document;
	public String timeOfAbsence_FROM;
	public String timeOfAbsence_TO;
	public boolean exceeding_funds;
	public boolean urgent;
	public int approved_by_sup;
	public int approved_by_dh;
	public int approved_by_benco;
	public String event_type;
	public String username;
	
	public Reimbursement_Form() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reimbursement_Form(int id_reimburesment, String campus, String date_received, String grading_format,
			String reason, String description, double cost, byte[] supporting_document, String timeOfAbsence_FROM,
			String timeOfAbsence_TO, boolean exceeding_funds, boolean urgent, int approved_by_sup, int approved_by_dh,
			int approved_by_benco, String event_type, String username) {
		super();
		this.id_reimburesment = id_reimburesment;
		this.campus = campus;
		this.date_received = date_received;
		this.grading_format = grading_format;
		this.reason = reason;
		this.description = description;
		this.cost = cost;
		this.supporting_document = supporting_document;
		this.timeOfAbsence_FROM = timeOfAbsence_FROM;
		this.timeOfAbsence_TO = timeOfAbsence_TO;
		this.exceeding_funds = exceeding_funds;
		this.urgent = urgent;
		this.approved_by_sup = approved_by_sup;
		this.approved_by_dh = approved_by_dh;
		this.approved_by_benco = approved_by_benco;
		this.event_type = event_type;
		this.username = username;
	}

	public int getId_reimburesment() {
		return id_reimburesment;
	}

	public void setId_reimburesment(int id_reimburesment) {
		this.id_reimburesment = id_reimburesment;
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public String getDate_received() {
		return date_received;
	}

	public void setDate_received(String date_received) {
		this.date_received = date_received;
	}

	public String getGrading_format() {
		return grading_format;
	}

	public void setGrading_format(String grading_format) {
		this.grading_format = grading_format;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public byte[] getSupporting_document() {
		return supporting_document;
	}

	public void setSupporting_document(byte[] supporting_document) {
		this.supporting_document = supporting_document;
	}

	public String getTimeOfAbsence_FROM() {
		return timeOfAbsence_FROM;
	}

	public void setTimeOfAbsence_FROM(String timeOfAbsence_FROM) {
		this.timeOfAbsence_FROM = timeOfAbsence_FROM;
	}

	public String getTimeOfAbsence_TO() {
		return timeOfAbsence_TO;
	}

	public void setTimeOfAbsence_TO(String timeOfAbsence_TO) {
		this.timeOfAbsence_TO = timeOfAbsence_TO;
	}

	public boolean isExceeding_funds() {
		return exceeding_funds;
	}

	public void setExceeding_funds(boolean exceeding_funds) {
		this.exceeding_funds = exceeding_funds;
	}

	public boolean isUrgent() {
		return urgent;
	}

	public void setUrgent(boolean urgent) {
		this.urgent = urgent;
	}

	public int getApproved_by_sup() {
		return approved_by_sup;
	}

	public void setApproved_by_sup(int approved_by_sup) {
		this.approved_by_sup = approved_by_sup;
	}

	public int getApproved_by_dh() {
		return approved_by_dh;
	}

	public void setApproved_by_dh(int approved_by_dh) {
		this.approved_by_dh = approved_by_dh;
	}

	public int getApproved_by_benco() {
		return approved_by_benco;
	}

	public void setApproved_by_benco(int approved_by_benco) {
		this.approved_by_benco = approved_by_benco;
	}

	public String getEvent_type() {
		return event_type;
	}

	public void setEvent_type(String event_type) {
		this.event_type = event_type;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Reimbursement_Form [id_reimburesment=" + id_reimburesment + ", campus=" + campus + ", date_received="
				+ date_received + ", grading_format=" + grading_format + ", reason=" + reason + ", description="
				+ description + ", cost=" + cost + ", supporting_document=" + Arrays.toString(supporting_document)
				+ ", timeOfAbsence_FROM=" + timeOfAbsence_FROM + ", timeOfAbsence_TO=" + timeOfAbsence_TO
				+ ", exceeding_funds=" + exceeding_funds + ", urgent=" + urgent + ", approved_by_sup=" + approved_by_sup
				+ ", approved_by_dh=" + approved_by_dh + ", approved_by_benco=" + approved_by_benco + ", event_type="
				+ event_type + ", username=" + username + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + approved_by_benco;
		result = prime * result + approved_by_dh;
		result = prime * result + approved_by_sup;
		result = prime * result + ((campus == null) ? 0 : campus.hashCode());
		long temp;
		temp = Double.doubleToLongBits(cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((date_received == null) ? 0 : date_received.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((event_type == null) ? 0 : event_type.hashCode());
		result = prime * result + (exceeding_funds ? 1231 : 1237);
		result = prime * result + ((grading_format == null) ? 0 : grading_format.hashCode());
		result = prime * result + id_reimburesment;
		result = prime * result + ((reason == null) ? 0 : reason.hashCode());
		result = prime * result + Arrays.hashCode(supporting_document);
		result = prime * result + ((timeOfAbsence_FROM == null) ? 0 : timeOfAbsence_FROM.hashCode());
		result = prime * result + ((timeOfAbsence_TO == null) ? 0 : timeOfAbsence_TO.hashCode());
		result = prime * result + (urgent ? 1231 : 1237);
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursement_Form other = (Reimbursement_Form) obj;
		if (approved_by_benco != other.approved_by_benco)
			return false;
		if (approved_by_dh != other.approved_by_dh)
			return false;
		if (approved_by_sup != other.approved_by_sup)
			return false;
		if (campus == null) {
			if (other.campus != null)
				return false;
		} else if (!campus.equals(other.campus))
			return false;
		if (Double.doubleToLongBits(cost) != Double.doubleToLongBits(other.cost))
			return false;
		if (date_received == null) {
			if (other.date_received != null)
				return false;
		} else if (!date_received.equals(other.date_received))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (event_type == null) {
			if (other.event_type != null)
				return false;
		} else if (!event_type.equals(other.event_type))
			return false;
		if (exceeding_funds != other.exceeding_funds)
			return false;
		if (grading_format == null) {
			if (other.grading_format != null)
				return false;
		} else if (!grading_format.equals(other.grading_format))
			return false;
		if (id_reimburesment != other.id_reimburesment)
			return false;
		if (reason == null) {
			if (other.reason != null)
				return false;
		} else if (!reason.equals(other.reason))
			return false;
		if (!Arrays.equals(supporting_document, other.supporting_document))
			return false;
		if (timeOfAbsence_FROM == null) {
			if (other.timeOfAbsence_FROM != null)
				return false;
		} else if (!timeOfAbsence_FROM.equals(other.timeOfAbsence_FROM))
			return false;
		if (timeOfAbsence_TO == null) {
			if (other.timeOfAbsence_TO != null)
				return false;
		} else if (!timeOfAbsence_TO.equals(other.timeOfAbsence_TO))
			return false;
		if (urgent != other.urgent)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	
}
