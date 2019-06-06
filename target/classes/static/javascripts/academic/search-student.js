var modal = $('#searchStudentModal');
var inputNameSearch = $('#nameSearchModal');
var errorMsg = $('.js-error-messages');

var search = function() {
	var url = 'students/' + inputNameSearch.val();
	$.get(url).success(function(data) {
		onSuccess(data);
	}).error(function() {
		onError();
	});
};

var transation=$('#transation');
transation.val(Math.random());


console.log(transation);


//$("#classe").change(function() {
//	var str = "";
//	$("select option:selected").each(function() {
//		str += $(this).text() + " ";
//	});
//	$("#result").text(str);
//});



//var getClassComboPromisse = $.ajax({
//	url : 'getAllClass',
//	method : 'GET'
//});

//getClassComboPromisse.done(function(classes) {
//	var getIdComboClass = $('#classe')
//	classes.forEach(function(clas) {
//		var optionClass = $('<option>').val(clas.id).text(clas.description);
//		getIdComboClass.append(optionClass);
//		var value = $('#value');
//
//	console.log(classes);
//
//	});
//});
//
//$("#classe").change(function() {
//	var str = "";
//	$("select option:selected").each(function() {
//		str += $(this).text() + " ";
//	});
//	$("#result").text(str);
//}).change();
//
//getClassComboPromisse.fail(function() {
//	alert("some Error Ocorred");
//});

function onModalShow() {
	inputNameSearch.focus();
}

function onModalClose() {
	inputNameSearch.val('');
	errorMsg.addClass('hidden');
}

function onSuccess(data) {
	errorMsg.addClass('hidden');
	var rsp = '';
	$.each(data, function(k, v) {
		rsp += '<tr>';
		rsp += '<td hidden>' + v.id + '</td>'

		rsp += '<td>' + v.ownid + '</td>'
		rsp += '<td>' + v.name + '</td>'
		rsp += '<td>' + v.surname + '</td>'
		rsp += '<td hidden>' + v.gender + '</td>'

		rsp += '</tr>';

	});
	$('#table_from_students').append(rsp);
}

function emptyTable(data) {
	errorMsg.addClass('hidden');
	var rsp = '';
	$.each(data, function(k, v) {
		rsp += '<tr>';
		rsp += '<td hidden>' + v.id + '</td>'
		rsp += '<td>' + v.ownid + '</td>'
		rsp += '<td>' + v.name + '</td>'
		rsp += '<td>' + v.surname + '</td>'
		rsp += '<td hidden>' + v.gender + '</td>'
		rsp += '</tr>';
	});
	$('#table_from_students').append(rsp);
}



function onClickTable() {
	var rowData = $(this).children("td").map(function(a, b) {

		return $(this).text();
	}).get();
	$("#id").val(rowData[0])

	$("#ownid").val(rowData[1])
	$("#name").val(rowData[2])
	$("#surname").val(rowData[3])
	$("#gender").val(rowData[4])

	modal.modal('hide');
};



function onError() {
	errorMsg.removeClass('hidden');
}

$(document).ready(function() {

	$('#btn-find').on('click', search);
	$('#btn-empty').on('click', emptyTable);

	modal.on('shown.bs.modal', onModalShow());
	modal.on('hide.bs.modal', onModalClose());
	$("#table_from_students tbody").on('click', 'tr', onClickTable);

});