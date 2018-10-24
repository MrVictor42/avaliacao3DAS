package Cadastros;

public class GetDuracaoHoras {
	
	Viagem viagem;
	
	public GetDuracaoHoras(Viagem _viagem) {
		
		this.viagem = _viagem;
	}
	
	public int compute() {
		
		if (viagem.getHoraTermino() == viagem.getHoraInicio())
			viagem.duracaoHoras = 0;
		if (viagem.getHoraTermino() > viagem.getHoraInicio()) //varias possibilidades... 
			if (viagem.getHoraTermino() == viagem.getHoraInicio() + 1) {  
				if (viagem.getMinutosTermino() < viagem.getMinutoInicio())  //nao chegou a uma hora
					viagem.duracaoHoras = 0;
				else //durou pelo menos uma hora
					viagem.duracaoHoras = 1;
			} else { //possivelmente ultrapassou duas horas
				if (viagem.getHoraTermino() - viagem.getHoraInicio() > 2) //
					viagem.duracaoHoras = viagem.getHoraTermino() - viagem.getHoraInicio();
				else if (viagem.getHoraTermino() - viagem.getHoraInicio() == 2 &&   //certamente menos de duas horas  
						viagem.getMinutosTermino() < viagem.getMinutoInicio())    //e mais de uma hora
					viagem.duracaoHoras = 1;
				else //duracao de duas horas, certamente
					viagem.duracaoHoras = 2;
					
			}
		if (viagem.getHoraTermino() < viagem.getHoraInicio()) 
			viagem.duracaoHoras = -1; //para casos em que a hora de termino nao foi registrada
		return viagem.duracaoHoras;
	}
}
