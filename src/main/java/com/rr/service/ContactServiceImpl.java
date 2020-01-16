package com.rr.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rr.frombean.Contact;
import com.rr.persistance.ContactDetailsEntity;
import com.rr.persistance.ContactDetailsRepositry;
import com.rr.util.emailUtiliti;
@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	 private ContactDetailsRepositry contactdetailsRepo;
	@Autowired
	private emailUtiliti mailUtil;
	
	@Override
	public boolean saveContact(Contact c) {
		ContactDetailsEntity entity=new ContactDetailsEntity();
		BeanUtils.copyProperties(c, entity);
		entity.setContactSw("Y");
		entity = contactdetailsRepo.save(entity);
		if(entity.getContactId()==1) {
			try {
				sendEmailTo(c);
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return entity.getContactId()>0;

	}
	/**
	 * this method is to get all contact from database
	 */

	@Override
	public List<Contact> getAllContacts() {
		List<Contact> listContact=new ArrayList<>();
		List<ContactDetailsEntity> listentity = contactdetailsRepo.findAll();
		List<ContactDetailsEntity> filterlist=listentity.stream().filter(entity->"Y".equals(entity.getContactSw())).collect(Collectors.toList());
		if(!filterlist.isEmpty()) {
			filterlist.forEach(entity->{
				Contact c=new Contact();
				BeanUtils.copyProperties(entity, c);
				listContact.add(c);
			});	
		}
		return listContact;
	}
  
	@Override
	public Contact getContactById(Integer cid) {
		
		Optional<ContactDetailsEntity> optional = contactdetailsRepo.findById(cid);
		Contact c=new Contact();
		if(optional.isPresent()) {
		ContactDetailsEntity entity = optional.get();
		BeanUtils.copyProperties(entity, c);
		}
		return c;
	}
	public void sendEmailTo(Contact c) throws Exception{
		String fileName="MailTemplate";
		StringBuilder sb=new StringBuilder();
		FileReader reader=new FileReader(new File(fileName));
		BufferedReader br=new BufferedReader(reader);
		String line=br.readLine();
		while(line!=null){
			if(line.contains("${NAME}")) {
				line=line.replace("$NAME}", c.getContactName());
				sb.append(line);
				line=br.readLine();
			}
			if(line.contains("${PHNO}")){
				line=line.replace("${PHNO}",String.valueOf(c.getPhno()));
				sb.append(line);
				line=br.readLine();
			}
		}
		mailUtil.sendEmail(c.getContactEmail(),sb.toString(),"for greeting to...my frnd");
	}
	@Override
	public void deleteContactById(Integer cid) {
		contactdetailsRepo.update("N", cid);
	}

}
