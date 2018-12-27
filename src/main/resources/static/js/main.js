
/**
 * 
 */
$(document).ready(function(){
	//default settings
	pageLoadSetting();
	//company edit and create
	$('.nBtn, .table .eBtn').on('click',function(event){		
		event.preventDefault();
		var href=$(this).attr('href');
		console.log("href"+href);
		var text=$(this).text();
		console.log(text);
		//alert("called here:"+text);		
		if(text=="Edit"){
			
		$.get(href,function(company,status){
			console.log(status+":"+company);
			$('.companyForm #companyId').val(company.companyId);
			$('.companyForm #companyName').val(company.companyName);
			$('.companyForm #description').val(company.description);
			$('.companyForm #createdBy').val(company.createdBy);
			//added//
			$('.companyForm #companyModal').modal();
			
		});
		}
		if(text=="New Service"){
			
			$('.servicesForm #serviceId').prop( "disabled", true );
			$('.servicesForm #serviceName').val('');
			$('.servicesForm #description').val('');
			$('.servicesForm #createdBy').prop( "disabled", true );
			$('.servicesForm #servicesModal').modal();
			return;
		}
		if(text=="Edit Service"){
			
		$.get(href,function(services,status){
			console.log("******"+status+":"+services);
			console.log("TEST"+JSON.stringify(services));
			
			$('.servicesForm #serviceId').val(services.serviceId);
			$('.servicesForm #serviceName').val(services.serviceName);
			$('.servicesForm #description').val(services.description);
			$('.servicesForm #createdBy').val(services.createdBy);
			
			$('.servicesForm #servicesModal').modal();
			
		});
		return;
		}
		else{
			$('.companyForm #companyId').prop( "disabled", true );
			$('.companyForm #companyName').val('');
			$('.companyForm #description').val('');
			$('.companyForm #createdBy').val('');
			//added//
			$('.companyForm #companyModal').modal();
		}
		//$('.companyForm #companyModal').modal();
	});
	
	$('.table .delBtn').on('click',function(event){
		event.preventDefault();
		var href=$(this).attr('href');
		console.log(href);
		var text=$(this).text();
		console.log("delete text"+ text);
		if(text=='Delete Service'){
			$('#deleteServiesModal #delRefService').attr('href',href);
			$('#deleteServiesModal').modal();
			return;
		}else{
		$('#deleteCompanyModal #delRef').attr('href',href);
		$('#deleteCompanyModal').modal();
		}
	});
	
//Create and edit Assessment	
	
	$('.createAsmt').on('click',function(event){
		console.log("Create Assessment Clicked1");
		event.preventDefault();
		$('.createAsmtForm #assessmentId').prop( "disabled", true );
		$('.createAsmtForm #assessmentName').val('');		
		//added//
		$('#createAssessment').modal();
		console.log("Create Assessment Clicked2");		
	});
//Edit Assessment	
	$('.editAsmt').on('click',function(event){
		console.log("Edit Assessment Clicked1");
		event.preventDefault();
		var href=$(this).attr('href');
		console.log("href:"+href);
		$.get(href,function(assessment,status){
		$('.editAsmtForm #assessmentId').val(assessment.assessmentId);
		$('.editAsmtForm #assessmentCode').val(assessment.assessmentCode);
		$('.editAsmtForm #assessmentName').val(assessment.assessmentName);
		$('.editAsmtForm #description').val(assessment.description);
		console.log(assessment.startDate);
		$('.editAsmtForm #active').val(assessment.active);
		$('.editAsmtForm #startDate').val(assessment.startDate);
		$('.editAsmtForm #endDate').val(assessment.endDate);
		$('#editAssessment').modal();
		});
	});
	
});


/**
 * javascript functions
*/
function func_pageSize(){
	var pageSize=$('#pageSize').val();
	//alert("calling pagesize"+pageSize);
	window.location = "/assessment?page=0&pageSize="+pageSize;
 }

//default setting to be called on load of page
function pageLoadSetting(){
	//alert("page load session:"+$('#ssnPageSize').val());
	$("div.pagination select").val($('#ssnPageSize').val());

 }