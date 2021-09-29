package in.ashokit.service;

import java.util.List;

import org.springframework.data.domain.Page;

import in.ashokit.entity.Contact;

public interface ContactService {

	public Boolean saveContact(Contact contact);

	public List<Contact> getAllContacts();

	public Page<Contact> getAllContactsNew(Integer pageNo, Integer pageSize);

	public Contact getContactById(Integer contactId);

	public Boolean deleteContactById(Integer contactId);
	
	public Boolean isContactExists(Contact contact);

}