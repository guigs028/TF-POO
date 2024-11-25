package Interface.AlterarStatusTransporte;

import aplicacao.ACMEAirDrones;
import dados.Transporte;
import dados.Estado;

import javax.swing.*;
import java.awt.*;

public class AlterarSituacaoTransporte extends JFrame {
    private ACMEAirDrones sistema;
    private JTextField numeroField;
    private JTextArea dadosTransporteArea;
    private JComboBox<Estado> situacaoComboBox;

    public AlterarSituacaoTransporte(ACMEAirDrones sistema) {
        this.sistema = sistema;

        setTitle("Alterar Situação do Transporte");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));

        numeroField = new JTextField();
        dadosTransporteArea = new JTextArea();
        dadosTransporteArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(dadosTransporteArea);

        situacaoComboBox = new JComboBox<>(Estado.values());

        JButton buscarButton = new JButton("Buscar");
        buscarButton.addActionListener(e -> buscarTransporte());

        JButton alterarButton = new JButton("Alterar");
        alterarButton.addActionListener(e -> alterarSituacao());

        panel.add(new JLabel("Número do Transporte:"));
        panel.add(numeroField);
        panel.add(new JLabel("Dados do Transporte:"));
        panel.add(scrollPane);
        panel.add(new JLabel("Nova Situação:"));
        panel.add(situacaoComboBox);
        panel.add(buscarButton);
        panel.add(alterarButton);

        add(panel);
    }

    private void buscarTransporte() {
        try {
            int numero = Integer.parseInt(numeroField.getText());
            Transporte transporte = sistema.getTransportePorNumero(numero);

            if (transporte == null) {
                dadosTransporteArea.setText("Transporte não encontrado.");
            } else if (transporte.getSituacao() == Estado.TERMINADO || transporte.getSituacao() == Estado.CANCELADO) {
                dadosTransporteArea.setText("Transporte não pode ser alterado. Situação: " + transporte.getSituacao());
            } else {
                dadosTransporteArea.setText(transporte.toString());
            }
        } catch (NumberFormatException ex) {
            dadosTransporteArea.setText("Por favor, insira um número válido.");
        }
    }

    private void alterarSituacao() {
        try {
            int numero = Integer.parseInt(numeroField.getText());
            Transporte transporte = sistema.getTransportePorNumero(numero);

            if (transporte == null) {
                JOptionPane.showMessageDialog(this, "Transporte não encontrado.");
            } else if (transporte.getSituacao() == Estado.TERMINADO || transporte.getSituacao() == Estado.CANCELADO) {
                JOptionPane.showMessageDialog(this, "Transporte não pode ser alterado. Situação: " + transporte.getSituacao());
            } else {
                Estado novaSituacao = (Estado) situacaoComboBox.getSelectedItem();
                transporte.setSituacao(novaSituacao);
                JOptionPane.showMessageDialog(this, "Situação alterada com sucesso.");
                dadosTransporteArea.setText(transporte.toString());
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um número válido.");
        }
    }
}