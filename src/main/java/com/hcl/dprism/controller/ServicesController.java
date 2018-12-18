package com.hcl.dprism.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hcl.dprism.domain.Assessment;
import com.hcl.dprism.domain.Company;
import com.hcl.dprism.domain.Services;
import com.hcl.dprism.repositories.ServicesRepository;

@Controller
public class ServicesController {
	@Autowired
	private ServicesRepository servicesRepo;
	@GetMapping("/services")
	public String showServices(Model model,@RequestParam(defaultValue="0")int page){
		/*System.out.println("TESTING 1");
		model.addAttribute("data",servicesRepo.findAll(PageRequest.of(page, 4)));
		
		model.addAttribute("currentPage", page);*/
		return "services";
	}
	@PostMapping("/saveServices")
	public String saveServices(Services services) {
		System.out.println("saving services***********"+services.getServiceId()+"CREATED BY"+services.getCreatedBy()+"SERVICE NAME"+services.getServiceName()+"description"+services.getDescription());
		
		if(StringUtils.isEmpty(services.getCreatedBy())) {
		services.setActive(1);
		services.setCreatedOn(System.currentTimeMillis());
		
		
		services.setCreatedBy("harleen_kaur");
		Assessment assessment=new Assessment();
		assessment.setAssessmentName("TestAssessment3");
		assessment.setDescription("assessmentdesc3");
		assessment.setActive(1);
		assessment.setAssessmentCode("ASC000003");
		assessment.setCreatedOn(System.currentTimeMillis());
		assessment.setCreatedBy("harleen_kaur");// will be replaced by looged in user//
		assessment.setModifiedBy("harleen_kaur");// will be replaced by looged in user//
		assessment.setModifiedOn(System.currentTimeMillis());
		
		services.setAssessment(assessment);
		}else {
			System.out.println("Edit services"+services.toString());
			Services servicesObject=servicesRepo.findById(services.getServiceId()).get();
			services.setAssessment(servicesObject.getAssessment());
			services.setCreatedOn(servicesObject.getCreatedOn());
			services.setActive(servicesObject.getActive());
			services.setModifiedOn(System.currentTimeMillis());
			services.setModifiedBy("harleen_kaur");
		}
		
		
		servicesRepo.save(services);
		
		System.out.println("printing servicesid:"+services.getServiceId());
		return "redirect:/services";
		
	}
	@GetMapping("/deleteServices")
	public String deleteServices(Integer serviceId) {
		servicesRepo.deleteById(serviceId);
		return "redirect:/services";
		
	}
	@GetMapping("/findOneServices")
	@ResponseBody
	public Services findOne(Integer serviceId){	
		//companyRepo.findOne(companyId);
		System.out.println("find service for edit"+serviceId);
		return servicesRepo.findById(serviceId).get();
		
	}
}
