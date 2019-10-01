package com.revature.service;

import java.util.List;

import com.revature.model.Document;
import com.revature.repository.DocumentRepositoryImpl;

public class DocumentService {
	public List<Document> getAllDocuments(){
		return new DocumentRepositoryImpl().getAllDocuments();
	}
}
