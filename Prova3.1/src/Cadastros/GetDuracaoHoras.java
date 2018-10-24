package Cadastros;

public class GetDuracaoHoras {
	
	Viagem viagem;
	
	public GetDuracaoHoras(Viagem _viagem) {
		
		this.viagem = _viagem;
	}
	
	public int compute() {
		
		if (saidaEntradaIguais())
			viagem.duracaoHoras = 0;
		
		if (horaTerminoMaiorInicio()) //varias possibilidades... 
			if (viagem.getHoraTermino() == viagem.getHoraInicio() + 1) {  
				if (minutoTerminoMenorInicio())  //nao chegou a uma hora
					viagem.duracaoHoras = 0;
				else //durou pelo menos uma hora
					viagem.duracaoHoras = 1;
			} else { //possivelmente ultrapassou duas horas
				if (horaTerminoMenosInicio() > 2) //
					viagem.duracaoHoras = horaTerminoMenosInicio();
				else if (horaTerminoMenosInicio() == 2 &&   //certamente menos de duas horas  
						minutoTerminoMenorInicio())    //e mais de uma hora
					viagem.duracaoHoras = 1;
				else //duracao de duas horas, certamente
					viagem.duracaoHoras = 2;
					
			}
		if (horaTerminoMenorInicio()) 
			viagem.duracaoHoras = -1; //para casos em que a hora de termino nao foi registrada
		return viagem.duracaoHoras;
	}

	private boolean horaTerminoMaiorInicio() {
		return viagem.getHoraTermino() > viagem.getHoraInicio();
	}

	private boolean horaTerminoMenorInicio() {
		return viagem.getHoraTermino() < viagem.getHoraInicio();
	}

	private int horaTerminoMenosInicio() {
		return viagem.getHoraTermino() - viagem.getHoraInicio();
	}

	private boolean minutoTerminoMenorInicio() {
		return viagem.getMinutosTermino() < viagem.getMinutoInicio();
	}

	private boolean saidaEntradaIguais() {
		return viagem.getHoraTermino() == viagem.getHoraInicio();
	}
}
