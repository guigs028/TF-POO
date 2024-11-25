package Interface.CadastrarDrones;

import javax.swing.*;
import java.awt.*;

public class CadastrarDroneGUI extends JFrame {
    public CadastrarDroneGUI() {
        setTitle("Cadastrar Drone");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10));

        JButton droneCargaInanimadaButton = new JButton("Drone de Carga Inanimada");
        JButton droneCargaVivaButton = new JButton("Drone de Carga Viva");
        JButton dronePessoalButton = new JButton("Drone Pessoal");

        panel.add(droneCargaInanimadaButton);
        panel.add(droneCargaVivaButton);
        panel.add(dronePessoalButton);

        add(panel, BorderLayout.CENTER);

        setVisible(true);

        droneCargaInanimadaButton.addActionListener(e -> abrirFormularioCadastro("Drone de Carga Inanimada"));
        droneCargaVivaButton.addActionListener(e -> abrirFormularioCadastro("Drone de Carga Viva"));
        dronePessoalButton.addActionListener(e -> abrirFormularioCadastro("Drone Pessoal"));
    }

    private void abrirFormularioCadastro(String tipoDrone) {
        switch (tipoDrone) {
            case "Drone de Carga Inanimada":
                new CadastrarDroneCargaInanimadaGUI().setVisible(true);
                break;
            case "Drone de Carga Viva":
                new CadastrarDroneCargaViva().setVisible(true);
                break;
            case "Drone Pessoal":
                JOptionPane.showMessageDialog(this, "Formulário para Drone Pessoal em desenvolvimento!");
                break;
            default:
                JOptionPane.showMessageDialog(this, "Tipo de drone não reconhecido!");
                break;
        }
    }
    
}
