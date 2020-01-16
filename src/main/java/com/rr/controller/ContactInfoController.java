package com.rr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rr.frombean.Contact;
import com.rr.service.ContactServiceImpl;

@Controller
public class ContactInfoController {
	@Autowired
	private ContactServiceImpl contactService;

	/**
	 *this method is display only first page 
	 * @param model
	 * @return
	 */
	@RequestMapping("/")
	public String displayContactFrom(Model model) {
		model.addAttribute("contact", new Contact());
		return "contact";
	}

	/**
	 * this method is used save the contact
	 * 
	 * @param c
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/contact")
	public String handleSubmitById(@ModelAttribute("contact") Contact c, Model model,RedirectAttributes attribut) {
		boolean saveContact = contactService.saveContact(c);
		if (saveContact)
			attribut.addFlashAttribute("succesResult", "Succesfully Contact Is Saved");
		else
			attribut.addFlashAttribute("ErrorResult", "Contact Is not Saved try onces");
		return "redirect:/saveData";

	}

	/**
	 * this method  is going to save  the data in  contact 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/saveData")
	public String createMgsSeccess(Model model) {
		model.addAttribute("contact", new Contact());
		return "contact";

	}
	/**
	 * this method going to show data in in view contact page
	 * @param model
	 * @return
	 */
	@RequestMapping("/ViewContact")
	public String viewContacts(Model model) {
		List<Contact> allContactList = contactService.getAllContacts();
		model.addAttribute("allList",allContactList);
		return "ViewContact";
		
	}

}
