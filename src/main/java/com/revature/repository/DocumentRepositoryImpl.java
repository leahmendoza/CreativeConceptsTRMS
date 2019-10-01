package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Document;
import com.revature.util.ConnectionClosers;
import com.revature.util.ConnectionFactory;

public class DocumentRepositoryImpl {

	public List<Document> getAllDocuments() {
		ArrayList<Document> documents = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		final String SQL = "select * from document";
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.createStatement();
			set = stmt.executeQuery(SQL);
			
			while(set.next()) {
				documents.add(
						new Document (
								set.getInt(1),
								set.getString(2),
								set.getByte(3),
								set.getBoolean(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionClosers.closeConnection(conn);
			ConnectionClosers.closeResultSet(set);
			ConnectionClosers.closeStatement(stmt);
		}
		return documents;
	}
	
	
	public Document getDocumentById(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		Document doc = new Document();

		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement("select * from document where id_document = ?"); // Select By ID Query
			stmt.setInt(1, id);
			set = stmt.executeQuery(); // To execute:

			while (set.next()) {
				System.out.println(set.getInt(1) + "," + set.getString(2) + set.getString(3));

				// this result set fills in the empty document object
				int id_document = set.getInt(1); // getting result set (position 1) assigning it to id_document
				doc.setId_document(id_document); // this puts the value of the id_document into the object
				
				String document_type = set.getString(2);
				doc.setDocument_type(document_type);
				
				byte document_upload = set.getByte(3);
				doc.setDocument_upload(document_upload);
				
				boolean approved = set.getBoolean(4);
				doc.setApproved(approved);
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
		return doc;
	}

}
