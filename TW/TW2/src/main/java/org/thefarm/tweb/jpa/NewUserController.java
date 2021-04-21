package org.thefarm.tweb.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class NewUserController {

	private static final Logger log = LoggerFactory.getLogger(NewUserController.class);

    @Autowired
    private UserRepository repository;
    
	@PostMapping("/new-user-c")
	public String newClient(
			@RequestParam(name= "Username", required=false, defaultValue="user") String Username,
			@RequestParam(name="password", required=false, defaultValue="123") String password,
			@RequestParam(name="role", required=false, defaultValue="ROLE_USER") String role,
			Model model)
	{


		String encodedPassword = new BCryptPasswordEncoder().encode(password);

		repository.save(new User(Username,encodedPassword, role));


		log.info("Customers found with findAll():");
		log.info("-------------------------------");
		for (User aUser : repository.findAll()) {
			log.info(aUser.toString());
		}
		log.info("");


		
		model.addAttribute("name", Username);
		model.addAttribute("role", role);
		return "new-user-view";
	}
}
