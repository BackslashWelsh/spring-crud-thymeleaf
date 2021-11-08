package com.backslashwelsh.myquery.controller;

import com.backslashwelsh.myquery.model.store.OrderItem;
import com.backslashwelsh.myquery.repository.OrderItemRepository;
import com.backslashwelsh.myquery.service.OrderItemService;
import com.backslashwelsh.myquery.service.ProductService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/order-items")
public class OrderItemController {
    private final OrderItemService itemService;
    private final ProductService productService;

    public OrderItemController(OrderItemRepository repository,
                               OrderItemService itemService, ProductService productService) {
        this.itemService = itemService;
        this.productService = productService;
    }

    @GetMapping("/all")
    public ModelAndView showItems() {
        return new ModelAndView("order-items/show-all-items")
                .addObject("items", itemService.findAll())
                .addObject("products", productService.findAll(Sort.by("name")));
    }

    @GetMapping("/{orderId}")
    public ModelAndView showItemsInOrder(@PathVariable("orderId") int orderId) {
        return new ModelAndView("order-items/show-items")
                .addObject("items", itemService.findAllByOrderId(orderId))
                .addObject("orderId", orderId);
    }

    @GetMapping("/{orderId}/new")
    public ModelAndView showAddForm(@PathVariable("orderId") int orderId,
                                    @ModelAttribute("item") OrderItem item) {
        return new ModelAndView("order-items/new-item")
                .addObject("orderId", orderId)
                .addObject("item", item)
                .addObject("products", productService.findAll(Sort.by("name")));
    }

    @PostMapping("/{orderId}")
    public String addItem(@PathVariable("orderId") int orderId,
                          @ModelAttribute("item") @Valid OrderItem item,
                          BindingResult result) {
        if (result.hasErrors()) {
            return "order-items/new-item";
        }
        itemService.add(orderId, item);
        return "redirect:/order-items/{orderId}";
    }
}
