package Interface.MostrarDadosTransportes;

import aplicacao.ACMEAirDrones;
import dados.Transporte;
import dados.TransporteCargaInanimada;
import dados.TransporteCargaViva;
import dados.TransportePessoal;
import dados.Drone;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MostrarTodosTransportesGUI extends JFrame {
    private ACMEAirDrones sistema;
    private JTextArea transportesArea;

    public MostrarTodosTransportesGUI(ACMEAirDrones sistema) {
        this.sistema = sistema;

        setTitle("Mostrar Todos os Transportes");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        transportesArea = new JTextArea();
        transportesArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(transportesArea);

        JButton fecharButton = new JButton("Fechar");
        fecharButton.addActionListener(e -> dispose());

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(fecharButton, BorderLayout.SOUTH);

        add(panel);

        mostrarTransportes();
    }

    private void mostrarTransportes() {
        List<Transporte> transportes = sistema.getTodosTransportes();

        if (transportes.isEmpty()) {
            transportesArea.setText("Nenhum transporte encontrado.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Transporte transporte : transportes) {
                sb.append("Número: ").append(transporte.getNumero()).append("\n");
                sb.append("Nome Cliente: ").append(transporte.getNomeCliente()).append("\n");
                sb.append("Descrição: ").append(transporte.getDescricao()).append("\n");
                sb.append("Peso: ").append(transporte.getPeso()).append("\n");
                sb.append("Latitude Origem: ").append(transporte.getLatitudeOrigem()).append("\n");
                sb.append("Latitude Destino: ").append(transporte.getLatitudeDestino()).append("\n");
                sb.append("Longitude Origem: ").append(transporte.getLongitudeOrigem()).append("\n");
                sb.append("Longitude Destino: ").append(transporte.getLongitudeDestino()).append("\n");
                sb.append("Situação: ").append(transporte.getSituacao()).append("\n");

                if (transporte instanceof TransporteCargaViva) {
                    TransporteCargaViva cargaViva = (TransporteCargaViva) transporte;
                    sb.append("Temperatura Mínima: ").append(cargaViva.getTemperaturaMinima()).append("\n");
                    sb.append("Temperatura Máxima: ").append(cargaViva.getTemperaturaMaxima()).append("\n");
                } else if (transporte instanceof TransportePessoal) {
                    TransportePessoal pessoal = (TransportePessoal) transporte;
                    sb.append("Quantidade de Pessoas: ").append(pessoal.getQtdPessoas()).append("\n");
                } else if (transporte instanceof TransporteCargaInanimada) {
                    TransporteCargaInanimada cargaInanimada = (TransporteCargaInanimada) transporte;
                    sb.append("Carga Perigosa: ").append(cargaInanimada.isCargaPerigosa()).append("\n");
                }

                Drone droneAlocado = transporte.getDrone();
                if (droneAlocado != null) {
                    sb.append("Drone Alocado: ").append(droneAlocado.toString()).append("\n");
                    sb.append("Custo Final: ").append(transporte.calculaCusto()).append("\n");
                }
                sb.append("\n");
            }
            transportesArea.setText(sb.toString());
        }
    }
}