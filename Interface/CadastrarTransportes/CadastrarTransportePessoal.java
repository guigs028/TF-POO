package Interface.CadastrarTransportes;

import dados.*;
import aplicacao.ACMEAirDrones;
import javax.swing.*;
import java.awt.*;

public class CadastrarTransportePessoal extends JFrame {
    ACMEAirDrones sistema;

    public CadastrarTransportePessoal(ACMEAirDrones sistema) {
        this.sistema = sistema;

        setTitle("Cadastrar Transporte - Pessoal");
        setSize(400, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(8, 2, 10, 10));

        JTextField numeroField = new JTextField();
        JTextField nomeClienteField = new JTextField();
        JTextField descricaoField = new JTextField();
        JTextField pesoField = new JTextField();
        JTextField qtdPessoasField = new JTextField();
        JTextField latitudeOrigemField = new JTextField();
        JTextField longitudeOrigemField = new JTextField();
        JTextField latitudeDestinoField = new JTextField();
        JTextField longitudeDestinoField = new JTextField();

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
        panel.add(new JLabel("Latitude Origem:"));
        panel.add(latitudeOrigemField);
        panel.add(new JLabel("Longitude Origem:"));
        panel.add(longitudeOrigemField);
        panel.add(new JLabel("Latitude Destino:"));
        panel.add(latitudeDestinoField);
        panel.add(new JLabel("Longitude Destino:"));
        panel.add(longitudeDestinoField);

        JButton salvarButton = new JButton("Salvar");
        salvarButton.addActionListener(e -> {
            try {
                int numero = Integer.parseInt(numeroField.getText());
                String nomeCliente = nomeClienteField.getText();
                String descricao = descricaoField.getText();
                double peso = Double.parseDouble(pesoField.getText());
                int qtdPessoas = Integer.parseInt(qtdPessoasField.getText());
                double latitudeOrigem = Double.parseDouble(latitudeOrigemField.getText());
                double longitudeOrigem = Double.parseDouble(longitudeOrigemField.getText());
                double latitudeDestino = Double.parseDouble(latitudeDestinoField.getText());
                double longitudeDestino = Double.parseDouble(longitudeDestinoField.getText());

                TransportePessoal transporte = new TransportePessoal(
                    numero, nomeCliente, descricao, peso, latitudeOrigem, longitudeOrigem, latitudeDestino, longitudeDestino, Estado.PENDENTE, qtdPessoas
                );

                if (sistema.adicionarTransporte(transporte)) {
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
