package com.hcl.dprism.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.hcl.dprism.domain.Assessment;
import com.hcl.dprism.repositories.AssessmentRepository;
import com.hcl.dprism.utils.DateConverter;

@Service
public class AssessmentServiceImpl implements AssessmentService{

	@Autowired
	private AssessmentRepository assessmentRepo;	
	
	@Autowired
	private DateConverter dateconverter;	
	
	@Override
	public Page<Assessment> findAllAssessmentPagewise(int page,int pageSize) {
		// TODO Auto-generated method stub
		return assessmentRepo.findAll(PageRequest.of(page, pageSize));
	}

	@Override
	public void save(Assessment assessment) {
		//save assessment object
		assessment.setStartsOn(dateconverter.deserialize(assessment.getStartDate()));
		assessment.setEndsOn(dateconverter.deserialize(assessment.getEndDate()));
		assessment.setCreatedOn(System.currentTimeMillis());
		assessment.setModifiedOn(System.currentTimeMillis());
		assessmentRepo.save(assessment);
	}

	@Override
	public Assessment findById(Integer assessmentId) {
		// TODO Auto-generated method stub
		Assessment assessment = assessmentRepo.findById(assessmentId).get();
		assessment.setStartDate(dateconverter.serialize(assessment.getStartsOn()));
		assessment.setEndDate(dateconverter.serialize(assessment.getEndsOn()));
		return assessment;
	}

	@Override
	public void deleteById(Integer assessmentId) {
		// TODO Auto-generated method stub
		assessmentRepo.deleteById(assessmentId);
	}
	
	

}
