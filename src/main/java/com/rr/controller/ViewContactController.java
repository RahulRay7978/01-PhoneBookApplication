package com.rr.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rr.frombean.Contact;
import com.rr.service.ContactServiceImpl;

@Controller
public class ViewContactController {
	@Autowired
	private ContactServiceImpl contactService;  
	
@RequestMapping("/editContact")
	public String editContact(HttpServletRequest req,Model model) {
		String cid=req.getParameter("contactId");
		int cnctid=Integer.parseInt(cid);
		Contact contact=contactService.getContactById(cnctid);
		model.addAttribute("contact",contact);
		return "contact";
		
	}
@RequestMapping("/deletContact")
public String delectContact(HttpServletRequest req) {
	String cid=req.getParameter("contactId");
	if(cid!=null && !"".equals(cid)) {
		int cnctid=Integer.parseInt(cid);
		contactService.deleteContactById(cnctid);
	}
	return "redirect:/ViewContact";
	
}
}
