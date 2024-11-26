package dados;

public class DroneCargaViva extends DroneCarga {
	private boolean climatizado;

	public DroneCargaViva(int codigo, double custoFixo, double autonomia, double pesoMaximo, boolean climatizado){
		super(codigo, custoFixo, autonomia,	pesoMaximo);
		this.climatizado = climatizado;
	}

	//getters e setters
	public boolean isClimatizado() {
		return climatizado;
	}

	public void setClimatizado(boolean climatizado) {
		this.climatizado = climatizado;
	}

	@Override
	public double calcularCustoVariavel() {
		if(isClimatizado()) return 20;
		else return 10;
	}

	@Override
	public double calculaCustoKm() {
		return 0;
	}

	@Override
    public String toString() {
        return super.toString() + 
               ", tipo: CargaViva" +
			   ", climatizado: " + (climatizado ? "Sim" : "Não") +
               ", custo variável: " + calcularCustoVariavel();
    }
}
