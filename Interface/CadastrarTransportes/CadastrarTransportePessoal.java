package Interface.CadastrarTransportes;

import dados.*;
import aplicacao.GerenciaTransportes;
import javax.swing.*;
import java.awt.*;

public class CadastrarTransportePessoal extends JFrame {
    public CadastrarTransportePessoal() {
        setTitle("Cadastrar Transporte - Pessoal");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));

        JTextField numeroField = new JTextField();
        JTextField nomeClienteField = new JTextField();
        JTextField descricaoField = new JTextField();
        JTextField pesoField = new JTextField();
        JTextField qtdPessoasField = new JTextField();

        panel.add(new JLabel("Número:"));
        panel.add(numeroField);
        panel.add(new JLabel("Nome Cliente:"));
        panel.add(nomeClienteField);
        panel.add(new JLabel("Descrição:"));
        panel.add(descricaoField);
        panel.add(new JLabel("Peso:"));
        panel.add(pesoField);
        panel.add(new JLabel("Quantidade de Pessoas:"));
        panel.add(qtdPessoasField);

        JButton salvarButton = new JButton("Salvar");
        salvarButton.addActionListener(e -> {
            try {
                int numero = Integer.parseInt(numeroField.getText());
                String nomeCliente = nomeClienteField.getText();
                String descricao = descricaoField.getText();
                double peso = Double.parseDouble(pesoField.getText());
                int qtdPessoas = Integer.parseInt(qtdPessoasField.getText());

                TransportePessoal transporte = new TransportePessoal(
                    numero, nomeCliente, descricao, peso, 0, 0, 0, 0, Estado.PENDENTE, qtdPessoas
                );

                if (GerenciaTransportes.adicionarTransporte(transporte)) {
                    JOptionPane.showMessageDialog(null, "Transporte cadastrado com sucesso!");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Erro: Número já cadastrado.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Por favor, insira valores válidos!");
            }
        });

        add(panel, BorderLayout.CENTER);
        add(salvarButton, BorderLayout.SOUTH);
    }
}
