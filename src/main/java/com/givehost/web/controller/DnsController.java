package com.givehost.web.controller;

import com.givehost.web.model.DnsHostingForm;
import com.givehost.web.model.Order;
import com.givehost.web.serviice.OrderDnsHostingService;
import com.givehost.web.serviice.SecurityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DnsController {
    private SecurityService securityService;
    private OrderDnsHostingService orderDnsHostingService;

    public DnsController(SecurityService securityService, OrderDnsHostingService orderDnsHostingService) {
        this.securityService = securityService;
        this.orderDnsHostingService = orderDnsHostingService;
    }

    @GetMapping("/dns")
    public String showDnsHostingPage(Model model) {
        if (securityService.isAuthenticated()) {
            model.addAttribute("isDnsPage", true);
            final List<Order> orders = orderDnsHostingService.getMyOrders();
            model.addAttribute("orders", orders);
            return "/pages/user-dns-page";
        } else {
            return "/pages/home";
        }
    }


    @GetMapping("/order-dns-hosting")
    public String showOrderDnsPage(Model model) {
        if (securityService.isAuthenticated()) {
            model.addAttribute("isDnsPage", true);
            return "/pages/user-order-dns-page";
        } else {
            return "/pages/home";
        }
    }
    @PostMapping("/order-dns-hosting")
    public String orderDnsHosting(@ModelAttribute DnsHostingForm domainsCount) {
        if (securityService.isAuthenticated()) {
            orderDnsHostingService.doOrder(domainsCount.getDomainsCount());
            return "redirect:/dns";
        } else {
            return "redirect:/";
        }
    }

}
