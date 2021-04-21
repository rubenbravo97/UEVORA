package org.thefarm.tweb.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private static final Logger log = LoggerFactory.getLogger(org.thefarm.tweb.jpa.HomeController.class);

    @Autowired
    private ProductsRepository repository;

    @GetMapping("/")
    public String listProducts(
            @RequestParam(name="pesquisa", required=false, defaultValue="ALL") String pesquisa,
            @RequestParam(name="pagina", required=false, defaultValue="1") int pagina,
            @RequestParam(name="min", required=false, defaultValue="0") int min,
            @RequestParam(name="max", required=false, defaultValue="10000") int max,
            Model model) {


        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String user = auth.getName();

        //sem pesquisa especifica
        if (pesquisa.equals("ALL")){
            //vai ao repositorio buscar todos os produtos
            List<Product> List = (List<Product>) repository.findAllByPriceBetween(min,max);
            int count = List.size();                                                    //ve quantos sao
            int totalpaginas = (count / 5);                               //quantas paginas teremos no total
            if (count % 5 > 0){
                totalpaginas++;
            }

            int paginai = (pagina-1) * 5;                                                    //index do promeiro produto desta pagina

            List<Product> fiveprod = new ArrayList<Product>();                          //seleciona apenas 5 produtos de entre todos
            if (count - ((pagina-1)*5) < 5){
                for (int i = paginai; i < paginai+(count-((pagina-1)*5)); i++){
                    fiveprod.add(List.get(i));
                }
            }
            else{
                for (int i = paginai; i < paginai+5; i++){
                    fiveprod.add(List.get(i));
                }
            }


            List<Integer> paginas = new ArrayList<Integer>();                           //cria um array com todas as paginas
            for(int i = 1; i<=totalpaginas;i++){
                paginas.add(i);
            }

            model.addAttribute("tipo", pesquisa);
            model.addAttribute("paginas", paginas);
            model.addAttribute("count", count);
            model.addAttribute("fiveprod", fiveprod);
            model.addAttribute("user", user);
            return "index";
        }
        if (pesquisa.equals("ANIMAIS")){
            //vai ao repositorio buscar todos os produtos ANIMAIS
            List<Product> List = (List<Product>) repository.findAllByTypeAndPriceBetween("ANIMAIS",min,max);

            int count = List.size();                                                    //ve quantos sao
            int totalpaginas = (count / 5) + (count % 5);                               //quantas paginas teremos no total


            int paginai = (pagina-1) * 5;                                                    //index do promeiro produto desta pagina

            List<Product> fiveprod = new ArrayList<Product>();                          //seleciona apenas 5 produtos de entre todos
            if (count - ((pagina-1)*5) < 5){
                for (int i = paginai; i < paginai+(count-((pagina-1)*5)); i++){
                    fiveprod.add(List.get(i));
                }
            }
            else{
                for (int i = paginai; i < paginai+5; i++){
                    fiveprod.add(List.get(i));
                }
            }


            List<Integer> paginas = new ArrayList<Integer>();                           //cria um array com todas as paginas
            for(int i = 1; i<totalpaginas+1;i++){
                paginas.add(i);
            }


            model.addAttribute("tipo", pesquisa);
            model.addAttribute("paginas", paginas);
            model.addAttribute("count", count);
            model.addAttribute("fiveprod", fiveprod);
            model.addAttribute("user", user);
            return "index";
        }
        if (pesquisa.equals("COMIDA")){
            //vai ao repositorio buscar todos os produtos ANIMAIS
            List<Product> List = (List<Product>) repository.findAllByTypeAndPriceBetween("COMIDA",min,max);

            int count = List.size();                                                    //ve quantos sao
            int totalpaginas = (count / 5) + (count % 5);                               //quantas paginas teremos no total


            int paginai = (pagina-1) * 5;                                                    //index do promeiro produto desta pagina

            List<Product> fiveprod = new ArrayList<Product>();                          //seleciona apenas 5 produtos de entre todos
            if (count - ((pagina-1)*5) < 5){
                for (int i = paginai; i < paginai+(count-((pagina-1)*5)); i++){
                    fiveprod.add(List.get(i));
                }
            }
            else{
                for (int i = paginai; i < paginai+5; i++){
                    fiveprod.add(List.get(i));
                }
            }

            List<Integer> paginas = new ArrayList<Integer>();                           //cria um array com todas as paginas
            for(int i = 1; i<totalpaginas+1;i++){
                paginas.add(i);
            }


            model.addAttribute("tipo", pesquisa);
            model.addAttribute("paginas", paginas);
            model.addAttribute("count", count);
            model.addAttribute("fiveprod", fiveprod);
            model.addAttribute("user", user);
            return "index";
        }
        if (pesquisa.equals("ACESSORIOS")){
            //vai ao repositorio buscar todos os produtos ANIMAIS
            List<Product> List = (List<Product>) repository.findAllByTypeAndPriceBetween("ACESSORIOS",min,max);

            int count = List.size();                                                    //ve quantos sao
            int totalpaginas = (count / 5) + (count % 5);                               //quantas paginas teremos no total


            int paginai = (pagina-1) * 5;                                                    //index do promeiro produto desta pagina

            List<Product> fiveprod = new ArrayList<Product>();                          //seleciona apenas 5 produtos de entre todos
            if (count - ((pagina-1)*5) < 5){
                for (int i = paginai; i < paginai+(count-((pagina-1)*5)); i++){
                    fiveprod.add(List.get(i));
                }
            }
            else{
                for (int i = paginai; i < paginai+5; i++){
                    fiveprod.add(List.get(i));
                }
            }


            List<Integer> paginas = new ArrayList<Integer>();                           //cria um array com todas as paginas
            for(int i = 1; i<totalpaginas+1;i++){
                paginas.add(i);
            }


            model.addAttribute("tipo", pesquisa);
            model.addAttribute("paginas", paginas);
            model.addAttribute("count", count);
            model.addAttribute("fiveprod", fiveprod);
            model.addAttribute("user", user);
            return "index";
        }
        else{
            //vai ao repositorio buscar todos os produtos ANIMAIS
            List<Product> List = (List<Product>) repository.findAllByName(pesquisa);

            int count = List.size();                                                    //ve quantos sao
            int totalpaginas = (count / 5) + (count % 5);                               //quantas paginas teremos no total


            int paginai = (pagina-1) * 5;                                                    //index do promeiro produto desta pagina

            List<Product> fiveprod = new ArrayList<Product>();                          //seleciona apenas 5 produtos de entre todos
            if (count - ((pagina-1)*5) < 5){
                for (int i = paginai; i < paginai+(count-((pagina-1)*5)); i++){
                    fiveprod.add(List.get(i));
                }
            }
            else{
                for (int i = paginai; i < paginai+5; i++){
                    fiveprod.add(List.get(i));
                }
            }


            List<Integer> paginas = new ArrayList<Integer>();                           //cria um array com todas as paginas
            for(int i = 1; i<totalpaginas+1;i++){
                paginas.add(i);
            }


            model.addAttribute("tipo", pesquisa);
            model.addAttribute("paginas", paginas);
            model.addAttribute("count", count);
            model.addAttribute("fiveprod", fiveprod);
            model.addAttribute("user", user);
            return "index";
        }





    }
}


