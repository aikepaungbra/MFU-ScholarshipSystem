package com.example.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mvc.AdminEntity.Admin;
import com.example.mvc.AdminEntity.AdminDto;
import com.example.mvc.Entity.ScholarInfo;
import com.example.mvc.service.AdminService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/api")
public class AdminController {

    @Autowired
    private AdminService adminService;
    
    
    @GetMapping("/adminAdd")
    public String addAdmin(Model model){
        model.addAttribute("adminDto",new AdminDto());
        return "createAdmin";
    }

    @PostMapping("/showAdmin")
    public String showAdmin(@ModelAttribute("adminDto") AdminDto adminDto,Model model){
        adminService.saveAdmin(adminDto);
        model.addAttribute("adminDto",adminDto);
        return "login";
        }    
    
    


    
    @PostMapping("/admin/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
        
    	if (adminService.login(email, password)) {
            
    		session.setAttribute("adminEmail", email);
            return "redirect:/admin/scholarships/create"; 
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "login"; 
        }
    }


    
    @GetMapping("/admin/scholarships/create")
    public String showCreateScholarshipForm(HttpSession session, Model model) {
        

    	if (session.getAttribute("adminEmail") == null) {
            return "redirect:/admin/login"; 
        }
        model.addAttribute("scholarInfo", new ScholarInfo());
        return "createNewScholarship";  
    }

    
   
    @PostMapping("/admin/scholarships/create")
    public String createNewScholarship(@ModelAttribute("scholarInfo") ScholarInfo scholarInfo, HttpSession session) {
        
        String adminEmail = (String) session.getAttribute("adminEmail");
        if (adminEmail == null) {
            return "redirect:/admin/login"; 
        }

        adminService.createNewScholarship(scholarInfo);
        return "redirect:/admin/scholarships";  
    }

}
