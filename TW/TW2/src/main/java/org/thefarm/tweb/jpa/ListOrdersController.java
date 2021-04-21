package org.thefarm.tweb.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class ListOrdersController {

	private static final Logger log = LoggerFactory.getLogger(ListOrdersController.class);

    @Autowired
    private OrdersRepository ordersRepository;

	@GetMapping("/list-orders")
	public String listOrders(
			Model model)
	{
		List<Orders> ordersList = (List<Orders>) ordersRepository.findAll();

		log.info("Customers found with findAll():");
		log.info("-------------------------------");
		for (Orders orders : ordersRepository.findAll()) {
			log.info(orders.toString());
		}
		log.info("");

		model.addAttribute("ordersList", ordersList);
		return "list-orders-view";
	}
}
