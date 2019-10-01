package com.revature.repository;

import java.util.List;

import com.revature.model.Document;

public interface DocumentRepository {

	List<Document> getAllDocuments();
	Document getDocumenteById(int id);
	
}
