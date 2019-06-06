var Brewer = Brewer || {};

Brewer.ComboEstado = (function() {
	
	function ComboEstado() {
		this.combo = $('#estado');
		this.emitter = $({});
		this.on = this.emitter.on.bind(this.emitter);
	}
	
	ComboEstado.prototype.iniciar = function() {
		this.combo.on('change', onEstadoAlterado.bind(this));
	}
	
	function onEstadoAlterado() {
		this.emitter.trigger('alterado', this.combo.val());
	}
	
	return ComboEstado;
	
}());

Brewer.ComboCidade = (function() {
	
	function ComboCidade(comboEstado) {
		this.comboEstado = comboEstado;
		this.combo = $('#cidade');
		this.value= $('#value');
		this.grade= $('#grade');
		this.room= $('#room');

		this.imgLoading = $('.js-img-loading');
	}
	
	ComboCidade.prototype.iniciar = function() {
		reset.call(this);
		this.comboEstado.on('alterado', onEstadoAlterado.bind(this));
	}
	
	function onEstadoAlterado(evento, codigoEstado) {
		if (codigoEstado) {
			var resposta = $.ajax({
				url: 'matricula/'+codigoEstado,
				method: 'GET',
				contentType: 'application/json',
				beforeSend: iniciarRequisicao.bind(this),
				complete: finalizarRequisicao.bind(this)
			});
			resposta.done(onBuscarCidadesFinalizado.bind(this));
		} else {
			reset.call(this);
		}
	}
	
	var decimal = $('.js-decimal');
	decimal.maskMoney();
	var input=$('#mulct');
	var resul=$('#resul');

	$(input).keyup(function(e) {
		var v =	input.val();
		var s= $('#value').val();
		if(v>100.00){
			input.val('0');
			resul.val('0');
			alert('Percentagem invalida');
			

			return;
		}
		var r=v*s;
		var t=1*r+1*s;
		console.log(t);
		resul.val(t);
	});


		function onBuscarCidadesFinalizado(grades) {
		var options = [];
		var value = $('#value');
		var mulct = $('#mulct');
		var r=$('#resul');
		var gradee = $('#grade');
		grades.forEach(function(grade) {

			value.val(grade.grade.price);
			gradee.val(grade.grade.description);
			r.val('0');
			mulct.val('0');
			
		});
		
//		r=parseInt(grade)*parseInt(mulct);
//		console.log(r);
		console.log('awaited value'+value);
	}
	
	function reset() {

//		this.combo.html('<option value="">Selecione a cidade</option>');
		this.combo.val('');
		 this.value.val('');
		 this.room.val('');
		 this.grade.val('');

		this.combo.attr('disabled', 'enabled');

	}
	
	function iniciarRequisicao() {
		reset.call(this);
		this.imgLoading.show();
	}
	
	function finalizarRequisicao() {
		this.imgLoading.hide();
	}
	
	return ComboCidade;
	
}());

$(function() {
	
	var comboEstado = new Brewer.ComboEstado();
	comboEstado.iniciar();
	
	var comboCidade = new Brewer.ComboCidade(comboEstado);
	comboCidade.iniciar();
	
});

