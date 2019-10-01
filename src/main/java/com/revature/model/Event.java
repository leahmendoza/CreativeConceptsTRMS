package com.revature.model;

public class Event {
	//Event Info Variables
	public int id_event;
	public String coverage_name;
	public int percentage;
	
	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Event(int id_event, String coverage_name, int percentage) {
		super();
		this.id_event = id_event;
		this.coverage_name = coverage_name;
		this.percentage = percentage;
	}

	public int getId_event() {
		return id_event;
	}

	public void setId_event(int id_event) {
		this.id_event = id_event;
	}

	public String getCoverage_name() {
		return coverage_name;
	}

	public void setCoverage_name(String coverage_name) {
		this.coverage_name = coverage_name;
	}

	public int getPercentage() {
		return percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}

	@Override
	public String toString() {
		return "Event [id_event=" + id_event + ", coverage_name=" + coverage_name + ", percentage=" + percentage + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coverage_name == null) ? 0 : coverage_name.hashCode());
		result = prime * result + id_event;
		result = prime * result + percentage;
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
		Event other = (Event) obj;
		if (coverage_name == null) {
			if (other.coverage_name != null)
				return false;
		} else if (!coverage_name.equals(other.coverage_name))
			return false;
		if (id_event != other.id_event)
			return false;
		if (percentage != other.percentage)
			return false;
		return true;
	}
	
}
