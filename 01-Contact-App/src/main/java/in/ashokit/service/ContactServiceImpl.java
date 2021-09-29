package in.ashokit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import in.ashokit.entity.Contact;
import in.ashokit.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	private ContactRepository contactRepo;

	@Autowired
	public ContactServiceImpl(ContactRepository contactRepo) {
		this.contactRepo = contactRepo;
	}

	@Override
	public Boolean saveContact(Contact contact) {
		contact.setActiveSw("Y");
		Contact savedEntity = contactRepo.save(contact);
		if (savedEntity != null && savedEntity.getContactId() != null) {
			return true;
		}
		return false;
	}

	@Override
	public List<Contact> getAllContacts() {
		Contact contactFilter = new Contact();
		contactFilter.setActiveSw("Y");

		Example<Contact> example = Example.of(contactFilter);

		return contactRepo.findAll(example);
	}

	@Override
	public Page<Contact> getAllContactsNew(Integer pageNo, Integer pageSize) {
		Contact contactFilter = new Contact();
		contactFilter.setActiveSw("Y");

		Example<Contact> example = Example.of(contactFilter);

		PageRequest pageRequest = PageRequest.of(pageNo, pageSize);

		return contactRepo.findAll(example, pageRequest);

	}

	@Override
	public Contact getContactById(Integer contactId) {
		Optional<Contact> findById = contactRepo.findById(contactId);
		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public Boolean deleteContactById(Integer contactId) {
		Optional<Contact> findById = contactRepo.findById(contactId);
		if (findById.isPresent()) {
			Contact contact = findById.get();
			contact.setActiveSw("N");
			contactRepo.save(contact);
			return true;
		}

		return false;
	}

	@Override
	public Boolean isContactExists(Contact contact) {
		Example<Contact> example = Example.of(contact);
		return contactRepo.exists(example);
	}
}
