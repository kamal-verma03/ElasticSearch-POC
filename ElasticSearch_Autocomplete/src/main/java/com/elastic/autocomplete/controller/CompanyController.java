package com.elastic.autocomplete.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.elastic.autocomplete.model.Company;
import com.elastic.autocomplete.service.CompanyService;

@Controller
public class CompanyController {

	@Autowired
	CompanyService service;

	@RequestMapping(value = "/searchnames", method = RequestMethod.GET)
	@ResponseBody
	List<String> search(@RequestParam("term") String name) throws Exception {
		long startTime = System.currentTimeMillis();
		List<Company> companies = service.getAllByName(name);
		List<String> autocompleteList = new ArrayList<String>();
		for (Company company : companies) {
			autocompleteList.add(company.getName());
		}
		long endTime = System.currentTimeMillis();
		System.out.print("Time took to get the response : ");
		System.out.println(endTime - startTime + " milliseconds");
		return autocompleteList;
	}

	@RequestMapping(value = "/*", method = RequestMethod.GET)
	public ModelAndView autocomplete() {

		ModelAndView model = new ModelAndView("autocomplete");
		return model;

	}

	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public ModelAndView result(@RequestParam("name") String name) {
		ModelAndView model = new ModelAndView("result");
		return model;

	}
	
	// This method is used to check the reponse through some rest client (like Postman).

	@RequestMapping(value = "/getAll/{name}")
	public @ResponseBody
	List<Company> getAll(@PathVariable("name") String name) {

		long startTime = System.currentTimeMillis();
		List<Company> comapanies = service.getAllByName(name);
		long endTime = System.currentTimeMillis();
		System.out.print("Time took to get the response : ");
		System.out.println(endTime - startTime + " milliseconds");
	
		return comapanies;
	}

}
