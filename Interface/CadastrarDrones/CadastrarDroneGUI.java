package Interface.CadastrarDrones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarDroneGUI extends JFrame {
    public CadastrarDroneGUI() {
        // Configurações da janela
        setTitle("Cadastrar Drone");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha apenas esta janela
        setLocationRelativeTo(null);

        // Painel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10));

        // Botões para cada tipo de drone
        JButton droneCargaInanimadaButton = new JButton("Drone de Carga Inanimada");
        JButton droneCargaVivaButton = new JButton("Drone de Carga Viva");
        JButton dronePessoalButton = new JButton("Drone Pessoal");

        // Adicionando botões ao painel
        panel.add(droneCargaInanimadaButton);
        panel.add(droneCargaVivaButton);
        panel.add(dronePessoalButton);

        // Adiciona o painel à janela
        add(panel, BorderLayout.CENTER);

        // Exibe a janela
        setVisible(true);

        // Adiciona ações aos botões
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
