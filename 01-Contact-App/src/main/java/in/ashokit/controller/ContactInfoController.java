package in.ashokit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import in.ashokit.constants.AppConstants;
import in.ashokit.entity.Contact;
import in.ashokit.service.ContactService;

@Controller
public class ContactInfoController {

	private ContactService contactService;

	public ContactInfoController(ContactService contactService) {
		this.contactService = contactService;
	}

	@GetMapping(value = { "/loadForm", "/" })
	public String loadForm(Model model) {
		Contact cobj = new Contact();

		model.addAttribute(AppConstants.CONTACT, cobj);
		return AppConstants.CONTACT;
	}

	@PostMapping("/saveContact")
	public String handleSaveBtnClick(@Valid Contact contact, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return AppConstants.CONTACT;
		}

		Boolean contactExists = contactService.isContactExists(contact);
		if (contactExists) {
			model.addAttribute("errMsg", "Duplicate Contact Found");
		} else {
			Boolean isSaved = contactService.saveContact(contact);
			if (isSaved) {
				model.addAttribute("succMsg", "Contact Saved Successfully");
			} else {
				model.addAttribute("errMsg", "Failed To Save Contact");
			}
		}
		return AppConstants.CONTACT;
	}

	@GetMapping("/viewContacts")
	public ModelAndView handleViewAllContactsClick(HttpServletRequest req) {

		Integer pageSize = 3;

		Integer pageNumber = 1;

		String reqParam = req.getParameter("pno");
		if (reqParam != null && !"".equals(reqParam)) {
			pageNumber = Integer.parseInt(reqParam);
		}

		Page<Contact> page = contactService.getAllContactsNew(pageNumber - 1, pageSize);

		int totalPages = page.getTotalPages();

		List<Contact> allContacts = page.getContent();

		ModelAndView mav = new ModelAndView();

		// Setting data to model in Key-Value pair format
		mav.addObject("contacts", allContacts);
		mav.addObject("tp", totalPages);
		mav.addObject("currPno", pageNumber);

		// Setting Logical view name
		mav.setViewName("viewContacts");

		return mav;
	}
}