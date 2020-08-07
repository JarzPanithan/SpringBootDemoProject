var request = {};
var ajaxRes;

$(document).ready(function() {
	$("#fileTable").DataTable({
		"autoWidth": false,
		"columns": [
			{width: "6%"},
			{width: "30%"},
			{width: "10%"},
			{width: "10%"},
			null
		],
		"lengthMenu": [10, 25, 50],
		"searching": true
	});
	$("#sideCollapseOpen").click(function() {
		$("#menuNavbar").toggleClass("active");
		$("#leftContents").toggleClass("active");
		$("#userInfo").toggleClass("active");
		$("#headerBar").toggleClass("active");
		$("#product2Content").toggleClass("active");
		$("#uploadContent").toggleClass("active");
		$("#tableContent").toggleClass("active");
	});
	searchAllFiles();
});

function searchAllFiles() {
	ajaxRes = $.ajax({
		type: "POST",
		data: JSON.stringify(),
		url: "/files",
		contentType: "application/json; charset=utf-8",
		dataType: "json",
		success: function(result, status) {
			files = result;
			// alert(status + ": " + JSON.stringify(files));
			var dataTable = $("#fileTable").DataTable();
			dataTable.clear().draw();
			
			if (files.length === 0) {
				alert(status + ": " + "No file found!!");
			}
			$.each(files, function(index, value) {
				var file = value;
				var appendHtml = "<tr>" + 
								 	"<td class='text-center align-middle'>" + file.docId + "</td>" +
								 	"<td class='text-center align-middle'>" + file.docName + "</td>" +
								 	"<td class='text-center align-middle'>" + file.docType + "</td>" +
								 	"<td class='text-center align-middle'>" +
							 			"<a id='" + file.docId + "' class='btn btn-success' href='downloadFile/" + file.docId + "''><i class='fa fa-download'></i></a>" +
							 			"&nbsp;&nbsp;&nbsp;" +
							 			"<a id='" + file.docId + "' class='btn btn-danger' href='deleteFile/" + file.docId + "''><i class='fa fa-trash'></i></a>" +
							 		"</td>" +
								 	"<td class='text-center align-middle hideDocData'>" + file.docData + "</td>" +
								 "</tr>"
				dataTable.rows.add($(appendHtml)).draw();
			});
		},
		error: function(error, status) {
			alert(status+ ": " + "Search failed!!");
		}
	});
}

$(".custom-file-input").on("change", function() {
	var fileName = $(this).val().split("\\").pop();
	$(this).siblings(".custom-file-label").addClass("selected").html(fileName);
});