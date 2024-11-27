package Interface.CadastrarTransportes;

import dados.*;
import aplicacao.ACMEAirDrones;

import javax.swing.*;
import java.awt.*;

public class CadastrarTransporteCargaInanimada extends JFrame {
    ACMEAirDrones sistema;

    public CadastrarTransporteCargaInanimada(ACMEAirDrones sistema) {
        this.sistema = sistema;

        setTitle("Cadastrar Transporte - Carga Inanimada");
        setSize(400, 600); 
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(10, 2, 10, 10)); 

        JTextField numeroField = new JTextField();
        JTextField nomeClienteField = new JTextField();
        JTextField descricaoField = new JTextField();
        JTextField pesoField = new JTextField();
        JTextField latitudeOrigemField = new JTextField();  
        JTextField longitudeOrigemField = new JTextField(); 
        JTextField latitudeDestinoField = new JTextField();  
        JTextField longitudeDestinoField = new JTextField(); 
        JCheckBox cargaPerigosaCheckbox = new JCheckBox("Carga Perigosa");

        panel.add(new JLabel("Número:"));
        panel.add(numeroField);
        panel.add(new JLabel("Nome Cliente:"));
        panel.add(nomeClienteField);
        panel.add(new JLabel("Descrição:"));
        panel.add(descricaoField);
        panel.add(new JLabel("Peso:"));
        panel.add(pesoField);
        panel.add(new JLabel("Latitude Origem:"));  
        panel.add(latitudeOrigemField);  
        panel.add(new JLabel("Longitude Origem:")); 
        panel.add(longitudeOrigemField);  
        panel.add(new JLabel("Latitude Destino:"));  
        panel.add(latitudeDestinoField); 
        panel.add(new JLabel("Longitude Destino:"));
        panel.add(longitudeDestinoField);  
        panel.add(new JLabel(""));  
        panel.add(cargaPerigosaCheckbox);

        JButton salvarBotao = new JButton("Salvar");
        salvarBotao.addActionListener(e -> {
            try {
                int numero = Integer.parseInt(numeroField.getText());
                String nomeCliente = nomeClienteField.getText();
                String descricao = descricaoField.getText();
                double peso = Double.parseDouble(pesoField.getText());
                double latitudeOrigem = Double.parseDouble(latitudeOrigemField.getText()); 
                double longitudeOrigem = Double.parseDouble(longitudeOrigemField.getText());
                double latitudeDestino = Double.parseDouble(latitudeDestinoField.getText());  
                double longitudeDestino = Double.parseDouble(longitudeDestinoField.getText()); 
                boolean cargaPerigosa = cargaPerigosaCheckbox.isSelected();

                TransporteCargaInanimada transporte = new TransporteCargaInanimada(
                    numero, nomeCliente, descricao, peso, latitudeOrigem, longitudeOrigem, latitudeDestino, longitudeDestino, Estado.PENDENTE, cargaPerigosa
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
        add(salvarBotao, BorderLayout.SOUTH);
    }
}
