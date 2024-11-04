package dados;

public abstract class DroneCarga extends Drone {
	private double pesoMaximo;

	public DroneCarga(int codigo, double custoFixo, double autonomia, double pesoMaximo) {
		super(codigo, custoFixo, autonomia);
		this.pesoMaximo = pesoMaximo;
	}

	//GETTERS E SETTERS
	public double getPesoMaximo() {
		return pesoMaximo;
	}

	public void setPesoMaximo(double pesoMaximo) {
		this.pesoMaximo = pesoMaximo;
	}

}
