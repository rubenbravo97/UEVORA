package org.thefarm.tweb.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ListProductsController {

    private static final Logger log = LoggerFactory.getLogger(org.thefarm.tweb.jpa.ListProductsController.class);

    @Autowired
    private ProductsRepository repository;

    @GetMapping("/list-products")
    public String listProducts(
            Model model) {

        List<Product> List = (List<Product>) repository.findAll();

        log.info("Customers found with findAll():");
        log.info("-------------------------------");
        for (Product product : repository.findAll()) {
            log.info(product.toString());
        }
        log.info("");

        model.addAttribute("List", List);
        return "list-products-view";
    }
}


