import javax.swing.SwingUtilities;

import Interface.InterfaceGrafica;
import aplicacao.ACMEAirDrones;

public class Main {

	public static void main(String[] args) {
		ACMEAirDrones app = new ACMEAirDrones();
		
		SwingUtilities.invokeLater(() -> new InterfaceGrafica(app));
	}

}
