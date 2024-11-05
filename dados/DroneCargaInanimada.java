package dados;

public class DroneCargaInanimada extends DroneCarga {
	private boolean protecao;

	public DroneCargaInanimada(int codigo, double custoFixo, double autonomia, double pesoMaximo, boolean protecao){
		super(codigo, custoFixo, autonomia,	pesoMaximo);
		this.protecao = protecao;
	}

	//getter e setter
	public boolean isProtecao() {
		return protecao;
	}

	public void setProtecao(boolean protecao) {
		this.protecao = protecao;
	}

	@Override
	public double calcularCustoVariavel() {
		if(isProtecao()) return 10;
		else return 5;
	}

	@Override
	public double calculaCustoKm() {
		return 0;
	}
}
