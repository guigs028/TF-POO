package Interface.CadastrarDrones;

import dados.*;
import javax.swing.*;

import aplicacao.ACMEAirDrones;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarDronePessoal extends JFrame {
    ACMEAirDrones sistema;

    public CadastrarDronePessoal(ACMEAirDrones sistema) {
        this.sistema = sistema;

        setTitle("Cadastrar Drone Pessoal");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));

        JTextField codigoField = new JTextField();
        JTextField custoFixoField = new JTextField();
        JTextField autonomiaField = new JTextField();
        JTextField maxPessoas = new JTextField();

        panel.add(new JLabel("Código:"));
        panel.add(codigoField);
        panel.add(new JLabel("Custo Fixo:"));
        panel.add(custoFixoField);
        panel.add(new JLabel("Autonomia:"));
        panel.add(autonomiaField);
        panel.add(new JLabel("Quantidade Máxima de Pessoas:"));
        panel.add(maxPessoas);

        JButton salvarBotao = new JButton("Salvar");
        salvarBotao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int codigo = Integer.parseInt(codigoField.getText());
                    double custoFixo = Double.parseDouble(custoFixoField.getText());
                    double autonomia = Double.parseDouble(autonomiaField.getText());
                    int pessoasMax = Integer.parseInt(maxPessoas.getText());

                    DronePessoal drone = new DronePessoal(codigo, custoFixo, autonomia, pessoasMax);

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


