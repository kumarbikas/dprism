package com.hcl.dprism.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hcl.dprism.domain.Assessment;
import com.hcl.dprism.domain.Company;
import com.hcl.dprism.service.AssessmentService;


@Controller
public class AssessmentController {
	
	@Autowired
	private AssessmentService assessmentService;
	
	@GetMapping("/assessment")
	public String showAssessment(Model model,@RequestParam(defaultValue="0")int page,@RequestParam(defaultValue="0")int pageSize,HttpSession session){			
		if(pageSize<5) {			
			pageSize= !(session.getAttribute("pageSize")==null||session.getAttribute("pageSize").toString().equals(""))?Integer.parseInt(session.getAttribute("pageSize").toString()):5;			
		}
		model.addAttribute("data",assessmentService.findAllAssessmentPagewise(page,pageSize));
		model.addAttribute("currentPage", page);
		System.out.println("pagesize:"+pageSize);
		System.out.println("pagesize:session:"+session.getAttribute("pageSize"));
		session.setAttribute("pageSize", pageSize+"");	
		return "assessment";
	}
	
	@PostMapping("/saveAssessment")
	public String save(Assessment assessment) {
		assessmentService.save(assessment);
		System.out.println("printing assessment id:"+assessment.getAssessmentCode());
		return "redirect:/assessment";
		
	}
	
	@GetMapping("/findOneAssessment")
	@ResponseBody
	public Assessment findOne(Integer assessmentId){	
		return assessmentService.findById(assessmentId);
	}
}
