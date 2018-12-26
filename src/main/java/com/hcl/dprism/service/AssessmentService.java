package com.hcl.dprism.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.hcl.dprism.domain.Assessment;

@Service
public interface AssessmentService {
	
	Page<Assessment> findAllAssessmentPagewise(int page,int pageSize);
	
	public void save(Assessment assessment);

}
