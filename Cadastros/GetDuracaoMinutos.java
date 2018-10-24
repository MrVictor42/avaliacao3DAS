package Cadastros;

public class GetDuracaoMinutos {
	
	Viagem viagem;
	
	public GetDuracaoMinutos(Viagem _viagem) {
		
		this.viagem = _viagem;
	}
	
	public int compute() {
		
		if (minutosTerminoMaiorInicio()) 
			viagem.duracaoMinutos = minutosTerminoMenosInicio();
		else {
			viagem.duracaoMinutos = 60 - viagem.getMinutoInicio() + viagem.getMinutosTermino();
			if (viagem.duracaoMinutos == 60) //caso especial
				viagem.duracaoMinutos = 0;
		}
		return viagem.duracaoMinutos;
	}

	private int minutosTerminoMenosInicio() {
		return viagem.getMinutosTermino() - viagem.getMinutoInicio();
	}

	private boolean minutosTerminoMaiorInicio() {
		return viagem.getMinutosTermino() > viagem.getMinutoInicio();
	}
}
