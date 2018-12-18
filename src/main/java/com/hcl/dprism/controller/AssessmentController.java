package com.hcl.dprism.controller;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AssessmentController {
	@GetMapping("/assessment")
	public String showAssessment(Model model,@RequestParam(defaultValue="0")int page){		
		/*model.addAttribute("data",companyRepo.findAll(PageRequest.of(page, 4)));
		model.addAttribute("currentPage", page);*/
		return "assessment";
	}
}
