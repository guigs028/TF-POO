package Interface.CadastrarDrones;

import dados.*;
import javax.swing.*;

import aplicacao.ACMEAirDrones;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarDroneCargaViva extends JFrame {
    ACMEAirDrones sistema;

    public CadastrarDroneCargaViva(ACMEAirDrones sistema) {
        this.sistema = sistema;

        setTitle("Cadastrar Drone de Carga Viva");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Painel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));

        // Campos de entrada
        JTextField codigoField = new JTextField();
        JTextField custoFixoField = new JTextField();
        JTextField autonomiaField = new JTextField();
        JTextField pesoMaximoField = new JTextField();
        JCheckBox climatizado = new JCheckBox("Climatizado");

        // Adiciona os campos ao painel
        panel.add(new JLabel("Código:"));
        panel.add(codigoField);
        panel.add(new JLabel("Custo Fixo:"));
        panel.add(custoFixoField);
        panel.add(new JLabel("Autonomia:"));
        panel.add(autonomiaField);
        panel.add(new JLabel("Peso Máximo:"));
        panel.add(pesoMaximoField);
        panel.add(new JLabel("Climatizado:"));
        panel.add(climatizado);

        // Botão de salvar
        JButton salvarButton = new JButton("Salvar");
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int codigo = Integer.parseInt(codigoField.getText());
                    double custoFixo = Double.parseDouble(custoFixoField.getText());
                    double autonomia = Double.parseDouble(autonomiaField.getText());
                    double pesoMaximo = Double.parseDouble(pesoMaximoField.getText());
                    boolean climatização = climatizado.isSelected();

                    // Aqui você cria o objeto DroneCargaInanimada
                    DroneCargaViva drone = new DroneCargaViva(codigo, custoFixo, autonomia, pesoMaximo, climatização);

                    if (sistema.adicionarDrone(drone)) {
                        JOptionPane.showMessageDialog(null, "Drone cadastrado com sucesso!");
                        dispose(); // Fecha a janela
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro: Já existe um drone com este código.");
                    }
                    
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira valores válidos!");
                }
            }
        });

        // Layout da janela
        add(panel, BorderLayout.CENTER);
        add(salvarButton, BorderLayout.SOUTH);
    }
}

