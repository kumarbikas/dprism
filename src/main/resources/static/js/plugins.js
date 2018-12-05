$(document).ready(function() {
	
/*Sidebar Navigation*/	
$('.btnArrow').on('click', function () {
 		$('#sidebar').toggleClass('active');
		$(this).find("i").toggleClass('fa-angle-double-left fa-angle-double-right');		
});
if ($(window).width() > 1280) {
		$("#sidebar").removeClass('active');
    }
    else{
  		$("#sidebar").addClass('active');
}

// Main Navigation
$("#sidebar .sidebar-dropdown > a").click(function () {
	$(".sidebar-submenu").slideUp(200);
	if ($(this).parent().hasClass("active")) {
		$("#sidebar .sidebar-dropdown").removeClass("active");
		$(this).parent().removeClass("active");
	} else {
		$("#sidebar .sidebar-dropdown").removeClass("active");
		$(this).next("#sidebar .sidebar-submenu").slideDown(200);
		$(this).parent().addClass("active");
	}

});


// Delete Table Row
$(".delBtn").on('click', function(e) {
    var whichtr = $(this).closest("tr");
        whichtr.remove();      
});
   
   


	
});
/* =================== Document Ready Function End =================== */