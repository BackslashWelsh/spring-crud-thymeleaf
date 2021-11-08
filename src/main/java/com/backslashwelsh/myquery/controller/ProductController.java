package com.backslashwelsh.myquery.controller;

import com.backslashwelsh.myquery.model.store.Product;
import com.backslashwelsh.myquery.service.ProductService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView showProducts(Pageable pageable) {
        List<Product> products = service.findAll(pageable.getSort());
        return new ModelAndView("products/show-products")
                .addObject("products", products);
    }

    @GetMapping("/new")
    public String showCreateForm(@ModelAttribute("product") Product product) {
        return "products/new-product";
    }

    @PostMapping
    public String create(@ModelAttribute("product") @Valid Product product,
                         BindingResult result) {
        if (result.hasErrors()) {
            return "products/new-product";
        }
        service.create(product);
        return "redirect:/products";
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showUpdateForm(@PathVariable("id") int id) {
        return new ModelAndView("products/edit-product")
                .addObject("product", service.findById(id));
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable("id") int id,
                         @ModelAttribute("product") @Valid Product product,
                         BindingResult result) {
        if (result.hasErrors()) {
            return "products/edit-product";
        }
        service.update(id, product);
        return "redirect:/products";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id, RedirectAttributes attributes) {
        if (service.isDependsOnOrderItem(id)) {
            attributes.addFlashAttribute("dependsError",
                    "Other table is depends on this product.");
            return "redirect:/products";
        }
        service.delete(id);
        return "redirect:/products";
    }
}
