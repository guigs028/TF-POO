package dados;

public abstract class Transporte {
	private int numero;
	private String nomeCliente;
	private String descricao;
	private double peso;
	private double latitudeOrigem;
	private double latitudeDestino;
	private double longitudeOrigem;
	private double longitudeDestino;
	private Estado situacao;
	private Drone drone;

	public Transporte(int numero, String nomeCliente, String descricao, double peso, double latitudeOrigem, double latitudeDestino, double longitudeOrigem, double longitudeDestino, Estado situacao) {
		this.numero = numero;
		this.nomeCliente = nomeCliente;
		this.descricao = descricao;
		this.peso = peso;
		this.latitudeOrigem = latitudeOrigem;
		this.latitudeDestino = latitudeDestino;
		this.longitudeOrigem = longitudeOrigem;
		this.longitudeDestino = longitudeDestino;
		this.situacao = situacao;
	}

	//GETTERS E SETTERS
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getLatitudeOrigem() {
		return latitudeOrigem;
	}

	public void setLatitudeOrigem(double latitudeOrigem) {
		this.latitudeOrigem = latitudeOrigem;
	}

	public double getLatitudeDestino() {
		return latitudeDestino;
	}

	public void setLatitudeDestino(double latitudeDestino) {
		this.latitudeDestino = latitudeDestino;
	}

	public double getLongitudeOrigem() {
		return longitudeOrigem;
	}

	public void setLongitudeOrigem(double longitudeOrigem) {
		this.longitudeOrigem = longitudeOrigem;
	}

	public double getLongitudeDestino() {
		return longitudeDestino;
	}

	public void setLongitudeDestino(double longitudeDestino) {
		this.longitudeDestino = longitudeDestino;
	}

	public Estado getSituacao() {
		return situacao;
	}

	public void setSituacao(Estado situacao) {
		this.situacao = situacao;
	}

	public Drone getDrone() {
		return drone;
	}

	public void setDrone(Drone drone) {
		this.drone = drone;
	}

	public double calcularDistancia() {
		double deltaLatitude = latitudeDestino - latitudeOrigem;
		double deltaLongitude = longitudeDestino - longitudeOrigem;
		return Math.sqrt(Math.pow(deltaLatitude, 2) + Math.pow(deltaLongitude, 2));
	}
	

		@Override
	public String toString() {
		return "Transporte =>" +
			"número: " + numero +
			", cliente: '" + nomeCliente + '\'' +
			", descrição: '" + descricao + '\'' +
			", peso: " + peso +
			", latitudeOrigem: " + latitudeOrigem +
			", longitudeOrigem: " + longitudeOrigem +
			", latitudeDestino: " + latitudeDestino +
			", longitudeDestino: " + longitudeDestino +
			", situação: " + situacao +
			", drone: " + (drone != null ? drone.getCodigo() : "Não alocado");
	}


	public abstract double calculaCusto();

	public abstract double calcularAcrescimoVariavel();
}
