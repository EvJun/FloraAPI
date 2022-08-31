package com.evanl.springidp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpringFloraController {
	
	@Autowired //tells spring it needs dependency injection
	private FloralService floralService;
	@Autowired
	private NonFloralService nonFloralService;
	@Autowired
	private FungusService fungusService;
	
	@GetMapping("")
	public String viewHomePage(Model model) {
		return "index";
	}
	
	/*
	 * ===================
	 * FLORAL HTTP METHODS
	 * ===================
	 */
	
	@GetMapping("/floral")
	public String getFloral(Model model) {
		model.addAttribute("listFloral", floralService.getAllFloral());
		return "floral_dashboard";
	}
	
	@GetMapping("/floral/{floralId}")
	public Floral getFloralById(@PathVariable long floralId) {
			return floralService.getFloralById(floralId);
	}
	
	@RequestMapping("/addFloralItem")
	public String showFloralForm(Model model) {
		Floral floral = new Floral();
		model.addAttribute("floral", floral);
		return "addFloralItem";
	}
		
	@PostMapping("/saveFloral") //saves new item to DB
	public String saveFloral(@ModelAttribute("floral") Floral floral) {
		floralService.saveFloral(floral);
		return "redirect:/floral";	
	}
	
    @GetMapping("/updateFloralItem/{floralId}") //PathVariable is binded to this id annotation
    public String updateFloralItem(@PathVariable(value="floralId") long floralId, Model model) {
    	Floral floral = floralService.getFloralById(floralId);
    	model.addAttribute("floral", floral);
    	return "updateFloral";
    }

    @GetMapping("/deleteFloralEntry/{floralId}")
    public String deleteFloralEntry(@PathVariable(value = "floralId") long floralId) {
        this.floralService.deleteFloralById(floralId); 
        return "redirect:/floral";
    }
    
	/*
	 * ===================
	 * NONFLORAL HTTP METHODS
	 * ===================
	 */
    
	@GetMapping("/nonfloral")
	public String getNonFloral(Model model) {
		model.addAttribute("listNonFloral", nonFloralService.getAllNonFloral());
		return "nonfloral_dashboard";
	}
	
	@GetMapping("/nonfloral/{nonFloralId}")
	public NonFloral getNonFloralById(@PathVariable long nonFloralId) {
		return nonFloralService.getNonFloralById(nonFloralId);
		
	}
	
	@RequestMapping("/addNonFloralItem") //gets form to add new item to DB
	public String showNonFloralForm(Model model) {
		NonFloral nonFloral = new NonFloral();
		model.addAttribute("nonFloral", nonFloral);
		return "addNonFloralItem";
	}
	
	@PostMapping("/saveNonFloral")
	public String saveNonFloral(@ModelAttribute("nonFloral") NonFloral nonFloral) { //maps Floral object into the html form
		nonFloralService.saveNonFloral(nonFloral); //add item to db
		return "redirect:/nonfloral";
	}
	

    @GetMapping("/updateNonFloral/{nonFloralId}") //PathVariable is binded to this id annotation
    public String updateNonFloral(@PathVariable(value = "nonFloralId") long nonFloralId, Model model) {
    	NonFloral nonFloral = nonFloralService.getNonFloralById(nonFloralId);
        model.addAttribute("nonFloral", nonFloral);
        return "updateNonFloral";
    }
    
    @GetMapping("/deleteNonFloralEntry/{nonFloralId}")
    public String deleteNonFloralEntry(@PathVariable(value = "nonFloralId") long nonFloralId) {
        this.nonFloralService.deleteNonFloralById(nonFloralId); 
        return "redirect:/nonfloral";
    }
    
	/*
	 * ===================
	 * FUNGUS HTTP METHODS
	 * ===================
	 */
    
	@GetMapping("/fungi")
	public String getFungus(Model model) {
		model.addAttribute("listFungi", fungusService.getAllFungi());
		return "fungi_dashboard";
	}
	
	@GetMapping("/fungi/{fungusId}")
	public Fungi getFungusById(@PathVariable long fungusId) {
		return fungusService.getFungusById(fungusId);
		
	}

	@RequestMapping("/addFungusItem") //gets form to add new item to DB
	public String showFungusForm(Model model) {
		Fungi fungi = new Fungi();
		model.addAttribute("fungi", fungi);
		return "addFungusItem";
	}
	
	@PostMapping("/saveFungus")
	public String saveFungus(@ModelAttribute("fungi") Fungi fungi) { //maps Floral object into the html form
		fungusService.saveFungus(fungi); //add item to db
		return "redirect:/fungi";
	}
	
    @GetMapping("/updateFungus/{fungusId}") //PathVariable is binded to this id annotation
    public String updateFungus(@PathVariable(value = "fungusId") long fungusId, Model model) {
    	Fungi fungi = fungusService.getFungusById(fungusId);
    	model.addAttribute("fungi", fungi);
        return "updateFungus";
    }
    
    @GetMapping("/deleteFungusEntry/{fungusId}")
    public String deleteFungusEntry(@PathVariable(value = "fungusId") long fungusId) {
        this.fungusService.deleteFungusById(fungusId); 
        return "redirect:/fungi";
    }
	}

