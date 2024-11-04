package dados;

public class TransporteCargaInanimada extends Transporte {
	private boolean cargaPerigosa;

	public TransporteCargaInanimada(int numero, String nomeCliente, String descricao, double peso, double latitudeOrigem, double latitudeDestino, double longitudeOrigem, double longitudeDestino, Estado situacao, boolean cargaPerigosa) {
		super(numero, nomeCliente, descricao, peso, latitudeOrigem, latitudeDestino, longitudeOrigem, longitudeDestino, situacao);
		this.cargaPerigosa = cargaPerigosa;
	}

	//getters e setters
	public boolean isCargaPerigosa() {
		return cargaPerigosa;
	}

	public void setCargaPerigosa(boolean cargaPerigosa) {
		this.cargaPerigosa = cargaPerigosa;
	}

	@Override
	public double calculaCusto() {
		return 0;
	}
}
