package dados;

public class DronePessoal extends Drone {
	private int qtdMaxPessoas;

	public DronePessoal(int codigo, double custoFixo, double autonomia, double pesoMaximo, int qtdMaxPessoas) {
		super(codigo, custoFixo, autonomia);
		this.qtdMaxPessoas = qtdMaxPessoas;
	}

	//getters e setters
	public int getQtdMaxPessoas() {
		return qtdMaxPessoas;
	}

	public void setQtdMaxPessoas(int qtdMaxPessoas) {
		this.qtdMaxPessoas = qtdMaxPessoas;
	}

	@Override
	public double calculaCustoKm() {
		return 0;
	}
}
