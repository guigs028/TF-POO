package dados;

public class TransportePessoal extends Transporte {
	private int qtdPessoas;

	public TransportePessoal(int numero, String nomeCliente, String descricao, double peso, double latitudeOrigem, double latitudeDestino, double longitudeOrigem, double longitudeDestino, Estado situacao, int qtdPessoas) {
		super(numero, nomeCliente, descricao, peso, latitudeOrigem, latitudeDestino, longitudeOrigem, longitudeDestino, situacao);
		this.qtdPessoas = qtdPessoas;
	}

	//getters e setters
	public int getQtdPessoas() {
		return qtdPessoas;
	}

	public void setQtdPessoas(int qtdPessoas) {
		this.qtdPessoas = qtdPessoas;
	}

	@Override
	public double calcularAcrescimoVariavel() {
		return qtdPessoas*10;
	} 

	@Override
	public double calculaCusto() {
		return 0;
	}

	@Override
	public String toString() {
		return super.toString() + " Tipo: Transporte Pessoal" +
		", qtd Pessoas: " + qtdPessoas +
		"Acréscimo: " + calcularAcrescimoVariavel();
	}

}
