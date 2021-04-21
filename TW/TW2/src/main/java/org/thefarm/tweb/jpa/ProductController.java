package org.thefarm.tweb.jpa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ProductController {


    @Autowired
    private ProductsRepository repository;

    @PostMapping("/product")
    public String product(
            @RequestParam(name="id", required=false, defaultValue="1") int id,
            Model model) {



        //model.addAttribute("id",id);
        System.out.print(id);

        return "product-view";
    }
}