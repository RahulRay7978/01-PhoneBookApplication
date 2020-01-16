package com.rr.service;

import java.util.List;

import com.rr.frombean.Contact;

public interface ContactService {

	public boolean saveContact(Contact c);
	public List<Contact>getAllContacts();
	public Contact getContactById(Integer cid);
	public void deleteContactById(Integer cid);
}
