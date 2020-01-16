package com.rr.frombean;

import lombok.Data;

@Data
public class Contact {
	private Integer contactId;
	private String contactName;
	private String contactEmail;
	private Long phno;
	private String contactSw;

	public String getContactSw() {
		return contactSw;
	}

	public void setContactSw(String contactSw) {
		this.contactSw = contactSw;
	}

	public Integer getContactId() {
		return contactId;
	}

	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public Long getPhno() {
		return phno;
	}

	public void setPhno(Long phno) {
		this.phno = phno;
	}

	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", contactName=" + contactName + ", contactEmail=" + contactEmail
				+ ", phno=" + phno + ", contactSw=" + contactSw + "]";
	}

	

}
