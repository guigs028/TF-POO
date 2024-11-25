package Interface.CadastrarTransportes;

import javax.swing.*;

import aplicacao.ACMEAirDrones;

import java.awt.*;

public class CadastrarTransporteGUI extends JFrame {
    private ACMEAirDrones sistema;

    public CadastrarTransporteGUI(ACMEAirDrones sistema) {
        this.sistema = sistema;

        setTitle("Cadastrar Transporte");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10));

        JButton transporteCargaInanimadaButton = new JButton("Transporte de Carga Inanimada");
        JButton transporteCargaVivaButton = new JButton("Transporte de Carga Viva");
        JButton transportePessoalButton = new JButton("Transporte Pessoal");

        panel.add(transporteCargaInanimadaButton);
        panel.add(transporteCargaVivaButton);
        panel.add(transportePessoalButton);

        add(panel, BorderLayout.CENTER);

        setVisible(true);

        transporteCargaInanimadaButton.addActionListener(e -> abrirFormularioCadastro("Transporte de Carga Inanimada"));
        transporteCargaVivaButton.addActionListener(e -> abrirFormularioCadastro("Transporte de Carga Viva"));
        transportePessoalButton.addActionListener(e -> abrirFormularioCadastro("Transporte Pessoal"));
    }

    private void abrirFormularioCadastro(String tipoTransporte) {
        switch (tipoTransporte) {
            case "Transporte de Carga Inanimada":
                new CadastrarTransporteCargaInanimada(sistema).setVisible(true);
                break;
            case "Transporte de Carga Viva":
                new CadastrarTransporteCargaViva(sistema).setVisible(true);
                break;
            case "Transporte Pessoal":
                new CadastrarTransportePessoal(sistema).setVisible(true);
                break;
            default:
                JOptionPane.showMessageDialog(this, "Tipo de transporte não reconhecido!");
                break;
        }
    }
}
