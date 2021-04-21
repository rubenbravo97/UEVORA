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
import java.util.Optional;

@Controller
public class RemoveProductController {

    private static final Logger log = LoggerFactory.getLogger(RemoveProductController.class);

    @Autowired
    private ProductsRepository repository;

    @PostMapping("/remove-product-c")
    public String newClient(
            @RequestParam(name="id", required=true) long id,
            Model model) throws IOException {

        Product product = repository.findById(id);

        if (product == null){
            return "not-removed-product-view";
        }
        String imagename = product.getImagename();

        repository.deleteById(id);

        String path = "src/main/resources/static/images/";
        File file = new File(path + imagename);
        file.delete();

        model.addAttribute("id", id);

        return "removed-product-view";
    }
}