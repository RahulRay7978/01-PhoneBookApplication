package com.rr.persistance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Contact_tab")
@Data
public class ContactDetailsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer contactId;
	
	@Column(name = "Contact_Name", length = 20)
	private String contactName;
	
	@Column(name = "Contact_Email", length = 30)
	private String contactEmail;
	
	@Column(name = "Contact_Phno", length = 10)
	private Long phno;
	
	@Column(name="contact_sw",length=10)
	private String contactSw;
	
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
	public String getContactSw() {
		return contactSw;
	}
	public void setContactSw(String contactSw) {
		this.contactSw = contactSw;
	}
	 

}
