package com.example.mongodbspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.mongodbspringboot.dto.Item;
import com.example.mongodbspringboot.entity.GroseryItem;
import com.example.mongodbspringboot.service.GroseryService;


@Controller
@RequestMapping("/grosery")
public class ItemController{

    @Autowired
    private GroseryService groseryService;
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String submit( 
    		@ModelAttribute("grosery") GroseryItem groseryItem, 
    		BindingResult result, Model model
    ){
        if(result.hasErrors()){
            return "error";
        }
        groseryService.addGrosery(groseryItem);
        model.addAttribute("grosery",new GroseryItem());
        return "grosery/add";
    } 
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(Model model){
    	model.addAttribute("id", new Item());
    	model.addAttribute("groseries",groseryService.listAllGrosery());
        return "grosery/list";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String detail(@PathVariable String id, Model model) {
    	model.addAttribute("grosery", groseryService.detailGrosery(id));
		return "grosery/add";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String update(
    		@PathVariable String id, Model model,
    		@ModelAttribute("grosery") GroseryItem groseryItem,
    		BindingResult result
    		) {
    	if(result.hasErrors()) {
    		return "error";
    	}
    	System.out.println(groseryItem);
    	groseryService.updateGrosery(groseryItem);
    	model.addAttribute("grosery", groseryService.detailGrosery(id));
    	return "grosery/add";
    }
    
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String delete(
    		@ModelAttribute("id") Item item,
    		BindingResult result,
    		Model model) {
    	if(result.hasErrors()) {
    		return "error";
    	}

    	groseryService.delete(item.getId());
    	model.addAttribute("groseries",groseryService.listAllGrosery());
    	return "grosery/list";
    }
} 