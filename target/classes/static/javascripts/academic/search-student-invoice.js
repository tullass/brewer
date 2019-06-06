var modal = $('#searchStudentInvoiceModal');
var inputNameSearch = $('#nameSearchModalInvoice');
var errorMsg = $('.js-error-messages');
var input = $('#mulct');
var total = $('#total');
var mulctToral = $('#mulctTotal');

var search = function() {
	var url = 'invoice/' + inputNameSearch.val();
	$.get(url).success(function(data) {
		console.log('result: '+data);
		console.log(url);
		onSuccess(data);
	}).error(function() {
		onError();
	});
};

var transation = $('#transation');
transation.val(Math.random());
console.log(transation);

function onModalShow() {
	inputNameSearch.focus();
	cleanField();
}

function onModalClose() {
	cleanField();
	errorMsg.addClass('hidden');
}

function onSuccess(data) {
	errorMsg.addClass('hidden');
	var rsp = '';
	$.each(data, function(k, v) {
		rsp += '<tr>';
		rsp += '<td hidden>' + v.id + '</td>'

		rsp += '<td>' + v.student.ownid + '</td>'
		rsp += '<td>' + v.student.name + '</td>'
		rsp += '<td>' + v.student.surname + '</td>'
		rsp += '<td style="color: red">' + v.grade.description + '</td>'

		rsp += '<td>' + v.grade.grade.price + '</td>'

		rsp += '</tr>';

	});
	$('#table_from_students_invoice').append(rsp);
}
function cleanField() {
	inputNameSearch.val('');
	input.val('0');
	total.val('0');
	mulctToral.val('0');
}

$(input).keyup(function(e) {
	var v = input.val();
	var price = $('#price').val();
	if (v > 100) {
		cleanField();
		alert('Percentagem invalida');
		return;
	}
	var r = v * price;
	var t = 1 * r + 1 * price;
	console.log(price);
	console.log(t);
	total.val(t);
	mulctToral.val(r);
	console.log(r);

});

function onClickTable() {
	var rowData = $(this).children("td").map(function(a, b) {
		return $(this).text();
	}).get();
	$("#id").val(rowData[0])

	$("#ownid").val(rowData[1])
	$("#name").val(rowData[2])
	$("#surname").val(rowData[3])
	$("#classRom").val(rowData[4])
	$("#price").val(rowData[5])

	modal.modal('hide');
	cleanField()
};

function onError() {
	errorMsg.removeClass('hidden');
}
$(document).ready(function() {

	$('#btn-find-student-invoice').on('click', search);
	modal.on('shown.bs.modal', onModalShow());
	modal.on('hide.bs.modal', onModalClose());
	$("#table_from_students_invoice tbody").on('click', 'tr', onClickTable);

});