var products = {};
var ajaxRes;

$(document).ready(function() {
	$("#productTable").DataTable({
		"autoWidth": false,
		"columns": [
			{width: "5%"},
			null,
			null,
			null,
			null,
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
		$("#productContent").toggleClass("active");
	});
	searchAllProducts();
});

function searchAllProducts() {
	ajaxRes = $.ajax({
		type: "POST",
		data: JSON.stringify(),
		url: "/product",
		contentType: "application/json; charset=utf-8",
		dataType: "json",
		success: function(result, status) {
			products = result;
			// alert(status + ": " + JSON.stringify(products));
			var dataTable = $("#productTable").DataTable();
			dataTable.clear().draw();
			
			if (products.length == 0) {
				alert(status + ": " + "No product found!!");
			}
			$.each(products, function(index, value) {
				var product = value;
				var appendHtml = "<tr>" +
									 "<td class='text-center align-middle'>" + product.id + "</td>" +
									 "<td class='text-center align-middle'>" + product.name + "</td>" +
									 "<td class='text-center align-middle'>" + product.price + "</td>" +
									 "<td class='text-center align-middle'>" + product.developer + "</td>" +
									 "<td class='text-center align-middle'>" + product.publisher + "</td>" +
									 "<td>" +
									 	"<a id='" + product.id + "' class='btn btn-warning' href='edit/?id=" + product.id + "''><i class='fa fa-edit'></i></a>" +
									 	"&nbsp;&nbsp;&nbsp" +
									 	"<a id='" + product.id + "' class='btn btn-danger' href='remove/" + product.id + "''><i class='fa fa-trash'></i></a>" +
									 "</td>" +
								 "</tr>";
				dataTable.rows.add($(appendHtml)).draw();
			});
		},
		error: function(error, status) {
			alert(status + ": " + "Search failed!!");
		}
	});
}