package com.revature.model;

public class Document {
	//Document Info Variables
	public int id_document;
	public String document_type;
	public byte document_upload;
	public boolean approved;
	
	public Document() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Document(int id_document, String document_type, byte document_upload, boolean approved) {
		super();
		this.id_document = id_document;
		this.document_type = document_type;
		this.document_upload = document_upload;
		this.approved = approved;
	}

	public int getId_document() {
		return id_document;
	}

	public void setId_document(int id_document) {
		this.id_document = id_document;
	}

	public String getDocument_type() {
		return document_type;
	}

	public void setDocument_type(String document_type) {
		this.document_type = document_type;
	}

	public byte getDocument_upload() {
		return document_upload;
	}

	public void setDocument_upload(byte document_upload) {
		this.document_upload = document_upload;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	@Override
	public String toString() {
		return "Document [id_document=" + id_document + ", document_type=" + document_type + ", document_upload="
				+ document_upload + ", approved=" + approved + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (approved ? 1231 : 1237);
		result = prime * result + ((document_type == null) ? 0 : document_type.hashCode());
		result = prime * result + document_upload;
		result = prime * result + id_document;
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
		Document other = (Document) obj;
		if (approved != other.approved)
			return false;
		if (document_type == null) {
			if (other.document_type != null)
				return false;
		} else if (!document_type.equals(other.document_type))
			return false;
		if (document_upload != other.document_upload)
			return false;
		if (id_document != other.id_document)
			return false;
		return true;
	}
	
}
