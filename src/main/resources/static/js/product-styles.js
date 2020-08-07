$(document).ready(function() {
	$("#sideCollapseOpen").click(function() {
		$("#menuNavbar").toggleClass("active");
		$("#leftContents").toggleClass("active");
		$("#userInfo").toggleClass("active");
		$("#headerBar").toggleClass("active");
		$("#productContent").toggleClass("active");
	});
});