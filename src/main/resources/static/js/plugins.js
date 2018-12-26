$(document).ready(function() {
	
/*Sidebar Navigation*/	
$(".btnArrow").on("click",function(){$("#sidebar").toggleClass("active"),$(this).find("i").toggleClass("fa-angle-double-left fa-angle-double-right")}),$(window).width()>1280?$("#sidebar").removeClass("active"):$("#sidebar").addClass("active");

// Main Navigation
$("#sidebar .sidebar-dropdown > a").click(function(){$(".sidebar-submenu").slideUp(200),$(this).parent().hasClass("active")?($("#sidebar .sidebar-dropdown").removeClass("active"),$(this).parent().removeClass("active")):($("#sidebar .sidebar-dropdown").removeClass("active"),$(this).next("#sidebar .sidebar-submenu").slideDown(200),$(this).parent().addClass("active"))});

// Delete Table Row Globally
$(".delBtn").on("click",function(t){$(this).closest("tr").remove()});

// Create Questionnaire Page
$(".depCreate, .depEdit").hide(),$("input[name='dependCreate']").click(function(){$("#yesCreate").is(":checked")?$(".depCreate").show():$(".depCreate").hide()}),$("#qusType").change(function(){"dropdown"==$("#qusType").val()?$(".dvalues").show():$(".dvalues").hide()}),$("input[name='depEdit']").click(function(){$("#yesEdit").is(":checked")?$(".depEdit").show():$(".depEdit").hide()});

/* Assesement Page */
$('.crtStart').datepicker({ uiLibrary: 'bootstrap' });
$('.crtEnd').datepicker({ uiLibrary: 'bootstrap' });
$('.editStart').datepicker({ uiLibrary: 'bootstrap' });
$('.editEnd').datepicker({ uiLibrary: 'bootstrap' });

// Template Page
$("#createDual").partsSelector();
$("#editDual").partsSelector();   



	
});


/* -------------------------------- Document Ready Function End -------------------------------- */

var pgurl=window.location.href.substr(window.location.href.lastIndexOf("/")+1);$(".menu li a").each(function(){$(this).attr("href")!=pgurl&&""!=$(this).attr("href")||$(this).addClass("current")});*/