package com.hcl.dprism.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="ASSESSMENT_MASTER")
public class Assessment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ASSESSMENT_ID")
	private int assessmentId;
	
	@Column(name="ASSESSMENT_CODE")
	private String assessmentCode;
	
	@Column(name="ASSESSMENT_NAME")
	private String assessmentName;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="Active")
	private String active;
	
	@Column(name="CREATED_BY")
	private String createdBy;

	@Column(name="CREATED_ON")
	private Long createdOn;
	
	@Column(name="MODIFIED_BY")
	private String modifiedBy;
	
	@Column(name="MODIFIED_ON")
	private Long modifiedOn;
	
	@Column(name="STARTS_ON")
	private Long startsOn;
	
	@Column(name="ENDS_ON")
	private Long endsOn;
	
	@Transient
	private String startDate;
	
	@Transient
	private String endDate;

	@Transient
	public String getStartDate() {
		return startDate;
	}
	
	
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	@Transient
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public Long getStartsOn() {
		return startsOn;
	}
	public void setStartsOn(Long startsOn) {
		this.startsOn = startsOn;
	}
	public Long getEndsOn() {
		return endsOn;
	}
	public void setEndsOn(Long endsOn) {
		this.endsOn = endsOn;
	}
	public int getAssessmentId() {
		return assessmentId;
	}
	public void setAssessmentId(int assessmentId) {
		this.assessmentId = assessmentId;
	}
	public String getAssessmentCode() {
		return assessmentCode;
	}
	public void setAssessmentCode(String assessmentCode) {
		this.assessmentCode = assessmentCode;
	}
	public String getAssessmentName() {
		return assessmentName;
	}
	public void setAssessmentName(String assessmentName) {
		this.assessmentName = assessmentName;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Long getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Long createdOn) {
		this.createdOn = createdOn;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Long getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Long modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getActive() {
		return "1".equals(active)?"Active":"InActive";
	}
	public void setActive(String active) {
		this.active = active;
	}
	/*public Services getServices() {
		return services;
	}
	public void setServices(Services services) {
		this.services = services;
	}*/
	
}
