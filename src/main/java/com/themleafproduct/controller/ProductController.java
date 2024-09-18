package com.themleafproduct.controller;

import com.themleafproduct.model.Product;
import com.themleafproduct.service.IProductService;
import com.themleafproduct.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final IProductService iProductService = new ProductService();
    @GetMapping("")
    public String showList(Model model){
        List<Product> products = iProductService.findAll();
        model.addAttribute("products", products);
        return  "list";
    }
    @GetMapping("/{id}/view")
    public String showProductFindId(@PathVariable Long id, Model model){
       model.addAttribute("product",iProductService.findById(id));
       return "view";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id, Model model){
        model.addAttribute("product", iProductService.findById(id));
        return  "delete";
    }
    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect){
        iProductService.remove(product.getId());
        redirect.addAttribute("success","Removed product successfully!");
        return "redirect:/products";
    }
    @GetMapping("/{id}/edit")
    public String updateProduct(@PathVariable Long id, Model model){
        model.addAttribute("product", iProductService.findById(id));
        return "edit";
    }
   @PostMapping("/update")
    public String update(Product product, RedirectAttributes redirect){
        iProductService.update(product.getId(), product);
        redirect.addAttribute("success", "Update product successfully!");
        return "redirect:/products";
   }
   @GetMapping("/create")
    public String create (Model model){
        model.addAttribute("product", new Product());
        return "create";
   }
   @PostMapping("/save")
    public String create(Product product){
        iProductService.save(product);
        return"redirect:/products";
   }
   @PostMapping("/search")
    public String findByName(@RequestParam("name") String name, Model model){
        List<Product> productName = iProductService.FindByName(name);
        model.addAttribute("productName", productName);
        return "viewName";
   }

}
