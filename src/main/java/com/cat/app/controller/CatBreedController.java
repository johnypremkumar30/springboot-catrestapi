package com.cat.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cat.app.service.CatBreedService;
import com.cat.appmodel.CatBreed;

@RestController
public class CatBreedController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CatBreed.class);

	@Autowired
	CatBreedService catBreedService;

	@GetMapping("/")
	public ModelAndView viewHomePage(Model model) {
		return findPaginated(1, "id", "asc", model);
	}

	@GetMapping("/page/{pageNo}")
	public ModelAndView findPaginated(@PathVariable(value = "pageNo") int pageNo,
			@RequestParam("sortField") String sortField, @RequestParam("sortDir") String sortDir, Model model) {
		int pageSize = 8;
		ModelAndView mav = new ModelAndView("homePage");

		Page<CatBreed> page = catBreedService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<CatBreed> cat = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());

		LOGGER.info("TOTAL PAGES = " + page.getTotalPages());

		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("cat", cat);
		// List<CatBreed> cb=catBreedService.getAllCatBreed();
		// mav.addObject("cat",cb);
		mav.addObject("CatBreed", model);
		return mav;
	}

	@GetMapping("/showNewCatForm")
	public ModelAndView showNewCatForm() {
		// create model attribute to bind form data
		ModelAndView mav = new ModelAndView("new_catbreed");
		CatBreed catBreed = new CatBreed();
		mav.addObject("CatBreed", catBreed);
		return mav;
	}

	@PostMapping("/saveCat")
	public ModelAndView saveCat(@ModelAttribute CatBreed catBreed) {
		// save cat to database
		catBreedService.addBreed(catBreed);
		ModelAndView mav = new ModelAndView("homePage");
		List<CatBreed> cb = catBreedService.getAllCatBreed();
		mav.addObject("cat", cb);
		mav.setStatus(HttpStatus.CREATED);
		LOGGER.info("inside save employee");
		return mav;
	}

	@GetMapping("/breeds")
	public ResponseEntity<List<CatBreed>> getAllBreeds() {
		return ResponseEntity.ok().body(catBreedService.getAllCatBreed());
	}
	
}
