package org.thefarm.tweb.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class NewOrderController {

	private static final Logger log = LoggerFactory.getLogger(NewOrderController.class);

    @Autowired
    private OrdersRepository ordersRepository;

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/new-orders")
	public String newOrders(
			@RequestParam(name="id", required=true) long id,
			@RequestParam(name="entrada", required=false, defaultValue="World") String entrada,
			@RequestParam(name="principal", required=false, defaultValue="World") String principal,
			@RequestParam(name="bebida", required=false, defaultValue="World") String bebida,
			@RequestParam(name="sobremesa", required=false, defaultValue="World") String sobremesa,
			Model model)
	{

		User user1 = userRepository.findById(id);
		ordersRepository.save(new Orders(user1,entrada,principal,bebida,sobremesa));
/*
		log.info("Customers found with findAll():");
		log.info("-------------------------------");
		for (Orders orders : ordersRepository.findAll()) {
			log.info(orders.toString());
		}
		log.info("");
*/


		model.addAttribute("id", id);
		model.addAttribute("entrada", entrada);
		model.addAttribute("principal", principal);
		model.addAttribute("bebida", bebida);
		model.addAttribute("sobremesa", sobremesa);
		return "new-orders-view";
	}
}

