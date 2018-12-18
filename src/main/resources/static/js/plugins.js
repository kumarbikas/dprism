$(document).ready(function() {
	
/*Sidebar Navigation*/	
$(".btnArrow").on("click",function(){$("#sidebar").toggleClass("active"),$(this).find("i").toggleClass("fa-angle-double-left fa-angle-double-right")}),$(window).width()>1280?$("#sidebar").removeClass("active"):$("#sidebar").addClass("active");

// Main Navigation
$("#sidebar .sidebar-dropdown > a").click(function(){$(".sidebar-submenu").slideUp(200),$(this).parent().hasClass("active")?($("#sidebar .sidebar-dropdown").removeClass("active"),$(this).parent().removeClass("active")):($("#sidebar .sidebar-dropdown").removeClass("active"),$(this).next("#sidebar .sidebar-submenu").slideDown(200),$(this).parent().addClass("active"))});

/* Login Page Validation*/
checkLogin(); $(document).on('click', '#logoutStorage',function(){ localStorage.removeItem("login"); });

// Delete Table Row Globally
$(".delBtn").on("click",function(t){$(this).closest("tr").remove()});

// Create Questionnaire Page
$(".depCreate, .depEdit").hide(),$("input[name='dependCreate']").click(function(){$("#yesCreate").is(":checked")?$(".depCreate").show():$(".depCreate").hide()}),$("#qusType").change(function(){"dropdown"==$("#qusType").val()?$(".dvalues").show():$(".dvalues").hide()}),$("input[name='depEdit']").click(function(){$("#yesEdit").is(":checked")?$(".depEdit").show():$(".depEdit").hide()});

/* Assesement Page */
$('.crtStart').datepicker({ uiLibrary: 'bootstrap' });
$('.crtEnd').datepicker({ uiLibrary: 'bootstrap' });

$('.editStart').datepicker({ uiLibrary: 'bootstrap' });
$('.editEnd').datepicker({ uiLibrary: 'bootstrap' });
/*$('#startDate').datepicker({ uiLibrary: 'bootstrap' });
$('#enDate').datepicker({ uiLibrary: 'bootstrap' });*/    
   



	
});
/* -------------------------------- Document Ready Function End -------------------------------- */

/* Login Page Validation*/

/*function check(r){if("rahulkhandhari"!=r.userid.value||"rahulkhandhari"!=r.pwd.value)return alert("Error Password or Username"),!1;window.location="index.html"}
function submitForm(){var t=$("#userid").val(),e=$("#userpass").val(),a=$("#userid").attr("data-user"),o=$("#userid").attr("data-supplier");return""===t||""===e?($('input[type="text"],input[type="password"]').addClass("error"),!1):t===a&&"kandhari@1970"===e||t===o&&"kandhari@1970"===e?($("form")[0].reset(),$('input[type="text"],input[type="password"]').removeClass("error"),t===a?(localStorage.setItem("login","true"),!0):t===o?(localStorage.setItem("login","false"),!0):void 0):($('input[type="text"],input[type="password"]').addClass("error"),!1)}function checkLogin(){var t=window.location.pathname,e=t.substring(t.lastIndexOf("/")+1);"true"==localStorage.login&&"login.html"==e?window.location="index.html":null===localStorage.getItem("login")&&"login.html"!=e&&(window.location="login.html")}*/

/* Template Page */
$(function() { $( "#createDual" ).partsSelector(); });
$(function() { $( "#editDual" ).partsSelector(); });