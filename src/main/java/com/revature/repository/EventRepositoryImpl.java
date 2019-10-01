package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Event;
import com.revature.util.ConnectionClosers;
import com.revature.util.ConnectionFactory;

public class EventRepositoryImpl implements EventRepository{

	public List<Event> getAllEvents() {
		ArrayList<Event> events = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		final String SQL = "select * from event";
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.createStatement();
			set = stmt.executeQuery(SQL);
			
			while(set.next()) {
				events.add(
						new Event (
								set.getInt(1),
								set.getString(2),
								set.getInt(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeResultSet(set);
			ConnectionClosers.closeStatement(stmt);
		}
		return events;
	}

	@Override
	public Event getEventById(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		Event event = new Event();

		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement("select * from event where id_event = ?"); // Select By ID Query
			stmt.setInt(1, id);
			set = stmt.executeQuery(); // To execute:

			while (set.next()) {
				System.out.println(set.getInt(1) + "," + set.getString(2) + set.getInt(3));

				// this result set fills in the empty event object
				int id_event = set.getInt(1); // getting result set (position 1) assigning it to id_event
				event.setId_event(id_event); // this puts the value of the id_event into the object
				
				String coverage_name = set.getString(2);
				event.setCoverage_name(coverage_name);
				
				int percentage = set.getInt(3);
				event.setPercentage(percentage);

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
		return event;
	}

}
