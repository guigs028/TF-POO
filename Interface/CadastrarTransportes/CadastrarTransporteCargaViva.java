package Interface.CadastrarTransportes;

import dados.*;
import aplicacao.ACMEAirDrones;

import javax.swing.*;
import java.awt.*;

public class CadastrarTransporteCargaViva extends JFrame {
    ACMEAirDrones sistema;

    public CadastrarTransporteCargaViva(ACMEAirDrones sistema) {
        this.sistema = sistema;

        setTitle("Cadastrar Transporte - Carga Viva");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(7, 2, 10, 10));

        JTextField numeroField = new JTextField();
        JTextField nomeClienteField = new JTextField();
        JTextField descricaoField = new JTextField();
        JTextField pesoField = new JTextField();
        JTextField temperaturaMinField = new JTextField();
        JTextField temperaturaMaxField = new JTextField();

        panel.add(new JLabel("Número:"));
        panel.add(numeroField);
        panel.add(new JLabel("Nome Cliente:"));
        panel.add(nomeClienteField);
        panel.add(new JLabel("Descrição:"));
        panel.add(descricaoField);
        panel.add(new JLabel("Peso:"));
        panel.add(pesoField);
        panel.add(new JLabel("Temperatura Mínima:"));
        panel.add(temperaturaMinField);
        panel.add(new JLabel("Temperatura Máxima:"));
        panel.add(temperaturaMaxField);

        JButton salvarButton = new JButton("Salvar");
        salvarButton.addActionListener(e -> {
            try {
                int numero = Integer.parseInt(numeroField.getText());
                String nomeCliente = nomeClienteField.getText();
                String descricao = descricaoField.getText();
                double peso = Double.parseDouble(pesoField.getText());
                double temperaturaMinima = Double.parseDouble(temperaturaMinField.getText());
                double temperaturaMaxima = Double.parseDouble(temperaturaMaxField.getText());

                TransporteCargaViva transporte = new TransporteCargaViva(
                    numero, nomeCliente, descricao, peso, 0, 0, 0, 0, Estado.PENDENTE, temperaturaMinima, temperaturaMaxima
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
