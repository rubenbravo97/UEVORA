package org.thefarm.tweb.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

@Controller
public class NewProductController {

    private static final Logger log = LoggerFactory.getLogger(NewProductController.class);

    @Autowired
    private ProductsRepository repository;

    @PostMapping("/new-product-c")
    public String newClient(
            @RequestParam(name="name", required=false, defaultValue="produto") String name,
            @RequestParam(name="price", required=false, defaultValue="20") int price,
            @RequestParam(name="descricao", required=false, defaultValue="...") String descricao,
            @RequestParam(name="type", required=false, defaultValue="ANIMAIS") String type,
            @RequestParam(name="file", required=false) MultipartFile file ,
            Model model) throws IOException {

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        String uploadDir = "src/main/resources/static/images";
        FileUploadUtil.saveFile(uploadDir, fileName, file);

        repository.save(new Product(name, price, descricao, type, fileName));

        /*
        log.info("Customers found with findAll():");
        log.info("-------------------------------");
        for (User aUser : repository.findAll()) {
            log.info(aUser.toString());
        }
        log.info("");
        */


        model.addAttribute("name", name);
        model.addAttribute("price", price);
        model.addAttribute("descricao", descricao);
        model.addAttribute("type", type);
        return "new-product-view";
    }
}