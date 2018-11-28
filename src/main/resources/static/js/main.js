
/**
 * 
 */
$(document).ready(function(){
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
	
});



