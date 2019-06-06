$(document).ready(function() {
			
			$.getJSON("http://localhost:8080/school/service/allServices",	function(data) {
				var txt = '';
				$.each(data, function(k,v){
						txt += '<tr>';
						txt += '<td>' + v.description + '</td>'
						txt += '</tr>';

					});
			var s = $('#mytable').append(txt);
			console.log(s);
		});

});
	