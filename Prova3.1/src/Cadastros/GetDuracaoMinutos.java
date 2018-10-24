package Cadastros;

public class GetDuracaoMinutos {
	
	Viagem viagem;
	
	public GetDuracaoMinutos(Viagem _viagem) {
		
		this.viagem = _viagem;
	}
	
	public int compute() {
		
		if (viagem.getMinutosTermino() > viagem.getMinutoInicio()) 
			viagem.duracaoMinutos = viagem.getMinutosTermino() - viagem.getMinutoInicio();
		else {
			viagem.duracaoMinutos = 60 - viagem.getMinutoInicio() + viagem.getMinutosTermino();
			if (viagem.duracaoMinutos == 60) //caso especial
				viagem.duracaoMinutos = 0;
		}
		return viagem.duracaoMinutos;
	}
}
