package dados;

public class TransporteCargaViva extends Transporte {
	private double temperaturaMinima;
	private double temperaturaMaxima;

	public TransporteCargaViva(int numero, String nomeCliente, String descricao, double peso, double latitudeOrigem, double latitudeDestino, double longitudeOrigem, double longitudeDestino, Estado situacao, double temperaturaMinima, double temperaturaMaxima) {
		super(numero, nomeCliente, descricao, peso, latitudeOrigem, latitudeDestino, longitudeOrigem, longitudeDestino, situacao);
		this.temperaturaMinima = temperaturaMinima;
		this.temperaturaMaxima = temperaturaMaxima;
	}

	//getters e setters
	public double getTemperaturaMinima() {
		return temperaturaMinima;
	}

	public void setTemperaturaMinima(double temperaturaMinima) {
		this.temperaturaMinima = temperaturaMinima;
	}

	public double getTemperaturaMaxima() {
		return temperaturaMaxima;
	}

	public void setTemperaturaMaxima(double temperaturaMaxima) {
		this.temperaturaMaxima = temperaturaMaxima;
	}

	@Override
	public double calcularAcrescimoVariavel() {
		if(temperaturaMaxima - temperaturaMinima > 10) return 1000;
		else return 0;
	}

	@Override
	public double calculaCusto() {
		return 0;
	}

	@Override
	public String toString() {
		return super.toString() + " Tipo: Transporte Carga Viva" +
		", Acréscimo: " + calcularAcrescimoVariavel();
	}
}
