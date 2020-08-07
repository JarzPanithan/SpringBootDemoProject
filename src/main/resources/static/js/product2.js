var products = {};
var ajaxRes;

$(document).ready(function() {
	$("#product2Table").DataTable({
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
		$("#product2Content").toggleClass("active");
	});
	searchAllProducts();
});

function searchAllProducts() {
	ajaxRes = $.ajax({
		type: "POST",
		data: JSON.stringify(),
		url: "/product2",
		contentType: "application/json; charset=utf-8",
		dataType: "json",
		success: function(result, status) {
			products = result;
			// alert(status + ": " + JSON.stringify(products));
			var dataTable = $("#product2Table").DataTable();
			dataTable.clear().draw();
			
			if (products.length == 0) {
				alert(status + ": " + "No product found!!");
			}
			$.each(products, function(index, value) {
				var product = value;
				var appendHtml = "<tr>" +
									"<td class='text-center align-middle'>" + product.productId + "</td>" +
									"<td class='text-center align-middle'>" + product.productCode + "</td>" +
									"<td class='text-center align-middle'>" + product.productName + "</td>" +
									"<td class='text-center align-middle'>" + product.productPrice + "</td>" +
									"<td class='text-center align-middle'>" + product.productAddress + "</td>" +
									 "<td>" +
									 	"<a id='" + product.productId + "' class='btn btn-warning' href='edit/?id=" + product.productId + "''><i class='fa fa-edit'></i></a>" +
									 	"&nbsp;&nbsp;&nbsp" +
									 	"<a id='" + product.productId + "' class='btn btn-danger' href='remove/" + product.productId + "''><i class='fa fa-trash'></i></a>" +
									 "</td>" +
								 "</tr>"
				dataTable.rows.add($(appendHtml)).draw();
			});
		},
		error: function(error, status) {
			alert(status + ": " + "Search failed!!");
		}
	});
}