package Interface.CadastrarDrones;

import javax.swing.*;

import aplicacao.ACMEAirDrones;

import java.awt.*;

public class CadastrarDroneGUI extends JFrame {
    private ACMEAirDrones sistema;


    public CadastrarDroneGUI(ACMEAirDrones sistema) {
        this.sistema = sistema;

        setTitle("Cadastrar Drone");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10));

        JButton droneCargaInanimadaBotao = new JButton("Drone de Carga Inanimada");
        JButton droneCargaVivaBotao = new JButton("Drone de Carga Viva");
        JButton dronePessoalBotao = new JButton("Drone Pessoal");

        panel.add(droneCargaInanimadaBotao);
        panel.add(droneCargaVivaBotao);
        panel.add(dronePessoalBotao);

        add(panel, BorderLayout.CENTER);

        setVisible(true);

        droneCargaInanimadaBotao.addActionListener(e -> abrirFormularioCadastro("Drone de Carga Inanimada"));
        droneCargaVivaBotao.addActionListener(e -> abrirFormularioCadastro("Drone de Carga Viva"));
        dronePessoalBotao.addActionListener(e -> abrirFormularioCadastro("Drone Pessoal"));
    }

    private void abrirFormularioCadastro(String tipoDrone) {
        switch (tipoDrone) {
            case "Drone de Carga Inanimada":
                new CadastrarDroneCargaInanimada(sistema).setVisible(true);
                break;
            case "Drone de Carga Viva":
                new CadastrarDroneCargaViva(sistema).setVisible(true);
                break;
            case "Drone Pessoal":
                new CadastrarDronePessoal(sistema).setVisible(true);
                break;
            default:
                JOptionPane.showMessageDialog(this, "Tipo de drone não reconhecido!");
                break;
        }
    }
    
}
