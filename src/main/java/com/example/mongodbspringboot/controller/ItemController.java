package com.example.mongodbspringboot.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.mongodbspringboot.entity.GroseryItem;
import com.example.mongodbspringboot.repository.ItemRepo;
import com.example.mongodbspringboot.service.GroseryService;


@Controller
public class ItemController{

    @Autowired
    private GroseryService groseryService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(){
        return "index";
    }
    
    @RequestMapping(value = "/add-grosery", method = RequestMethod.POST)
    public String submit( @ModelAttribute("grosery") GroseryItem groseryItem, BindingResult result, Model model){
        if(result.hasErrors()){
            System.out.println(result);
            return "error";
        }
        groseryService.addGrosery(groseryItem);
        model.addAttribute("grosery",new GroseryItem());
        model.addAttribute("groseries",groseryService.listAllGrosery());
        
        return "groseryadd";
    } 
    
    @RequestMapping(value = "/add-grosery", method = RequestMethod.GET)
    public String view(Model model){ 
    	model.addAttribute("grosery", new GroseryItem());
    	model.addAttribute("groseries",groseryService.listAllGrosery());
//    	System.out.println(groseryService.listAllGrosery());
        return "groseryadd";
    }
    
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.POST)
    public String viewDetailId(@PathVariable String id, Model model) {
    	model.addAttribute("grosery", groseryService.detailGrosery(id));
    	model.addAttribute("groseries",new ArrayList<GroseryItem>());
		return "groseryadd";
    	
    }
} 