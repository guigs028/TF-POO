package Interface.CadastrarDrones;

import dados.*;
import javax.swing.*;

import aplicacao.ACMEAirDrones;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarDroneCargaInanimada extends JFrame {
    ACMEAirDrones sistema;

    public CadastrarDroneCargaInanimada(ACMEAirDrones sistema) {
        this.sistema = sistema;

        setTitle("Cadastrar Drone de Carga Inanimada");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));

        JTextField codigoField = new JTextField();
        JTextField custoFixoField = new JTextField();
        JTextField autonomiaField = new JTextField();
        JTextField pesoMaximoField = new JTextField();
        JCheckBox protecaoCheckBox = new JCheckBox("Proteção");

        panel.add(new JLabel("Código:"));
        panel.add(codigoField);
        panel.add(new JLabel("Custo Fixo:"));
        panel.add(custoFixoField);
        panel.add(new JLabel("Autonomia:"));
        panel.add(autonomiaField);
        panel.add(new JLabel("Peso Máximo:"));
        panel.add(pesoMaximoField);
        panel.add(new JLabel("Proteção:"));
        panel.add(protecaoCheckBox);

        JButton salvarBotao = new JButton("Salvar");
        salvarBotao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int codigo = Integer.parseInt(codigoField.getText());
                    double custoFixo = Double.parseDouble(custoFixoField.getText());
                    double autonomia = Double.parseDouble(autonomiaField.getText());
                    double pesoMaximo = Double.parseDouble(pesoMaximoField.getText());
                    boolean protecao = protecaoCheckBox.isSelected();

                    DroneCargaInanimada drone = new DroneCargaInanimada(codigo, custoFixo, autonomia, pesoMaximo, protecao);

                    if (sistema.adicionarDrone(drone)) {
                        JOptionPane.showMessageDialog(null, "Drone cadastrado com sucesso!");
                        dispose(); 
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro: Já existe um drone com este código.");
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira valores válidos!");
                }
            }
        });

        add(panel, BorderLayout.CENTER);
        add(salvarBotao, BorderLayout.SOUTH);
    }
}

