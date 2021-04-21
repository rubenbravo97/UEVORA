package org.thefarm.tweb.jpa;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ListUserController {

	private static final Logger log = LoggerFactory.getLogger(ListUserController.class);

    @Autowired
    private UserRepository repository;

	@GetMapping("/list-users")
	public String listUsers(
			Model model) 
	{		
		List<User> customerList = (List<User>) repository.findAll();

		log.info("Customers found with findAll():");
		log.info("-------------------------------");
		for (User user : repository.findAll()) {
			log.info(user.toString());
		}
		log.info("");

		model.addAttribute("customerList", customerList);
		return "list-users-view";
	}
}
