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
        setSize(400, 600); 
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(11, 2, 10, 10)); 

        JTextField numeroField = new JTextField();
        JTextField nomeClienteField = new JTextField();
        JTextField descricaoField = new JTextField();
        JTextField pesoField = new JTextField();
        JTextField temperaturaMinField = new JTextField();
        JTextField temperaturaMaxField = new JTextField();
        JTextField latitudeOrigemField = new JTextField();  
        JTextField longitudeOrigemField = new JTextField(); 
        JTextField latitudeDestinoField = new JTextField();  
        JTextField longitudeDestinoField = new JTextField(); 

        // Adicionando os componentes ao painel
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
                double temperaturaMinima = Double.parseDouble(temperaturaMinField.getText());
                double temperaturaMaxima = Double.parseDouble(temperaturaMaxField.getText());
                double latitudeOrigem = Double.parseDouble(latitudeOrigemField.getText()); 
                double longitudeOrigem = Double.parseDouble(longitudeOrigemField.getText()); 
                double latitudeDestino = Double.parseDouble(latitudeDestinoField.getText()); 
                double longitudeDestino = Double.parseDouble(longitudeDestinoField.getText());

                TransporteCargaViva transporte = new TransporteCargaViva(
                    numero, nomeCliente, descricao, peso, latitudeOrigem, longitudeOrigem, latitudeDestino, longitudeDestino, Estado.PENDENTE, temperaturaMinima, temperaturaMaxima
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
