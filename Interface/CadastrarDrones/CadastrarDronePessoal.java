package Interface.CadastrarDrones;

import dados.*;
import javax.swing.*;

import aplicacao.GerenciaDrones;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarDronePessoal extends JFrame {

    public CadastrarDronePessoal() {
        setTitle("Cadastrar Drone Pessoal");
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
        JTextField maxPessoas = new JTextField();

        // Adiciona os campos ao painel
        panel.add(new JLabel("Código:"));
        panel.add(codigoField);
        panel.add(new JLabel("Custo Fixo:"));
        panel.add(custoFixoField);
        panel.add(new JLabel("Autonomia:"));
        panel.add(autonomiaField);
        panel.add(new JLabel("Quantidade Máxima de Pessoas:"));
        panel.add(maxPessoas);

        // Botão de salvar
        JButton salvarButton = new JButton("Salvar");
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int codigo = Integer.parseInt(codigoField.getText());
                    double custoFixo = Double.parseDouble(custoFixoField.getText());
                    double autonomia = Double.parseDouble(autonomiaField.getText());
                    int pessoasMax = Integer.parseInt(maxPessoas.getText());

                    // Aqui você cria o objeto DroneCargaInanimada
                    DronePessoal drone = new DronePessoal(codigo, custoFixo, autonomia, pessoasMax);

                    if (GerenciaDrones.adicionarDrone(drone)) {
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


