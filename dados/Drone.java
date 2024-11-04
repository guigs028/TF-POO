package dados;

public abstract class Drone {
	private int codigo;
	private double custoFixo;
	private double autonomia;

	public Drone(int codigo, double custoFixo, double autonomia) {
		this.codigo = codigo;
		this.custoFixo = custoFixo;
		this.autonomia = autonomia;
	}

	//GETTERS E SETTERS
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getCustoFixo() {
		return custoFixo;
	}

	public void setCustoFixo(double custoFixo) {
		this.custoFixo = custoFixo;
	}

	public double getAutonomia() {
		return autonomia;
	}

	public void setAutonomia(double autonomia) {
		this.autonomia = autonomia;
	}

	public abstract double calculaCustoKm();

}
