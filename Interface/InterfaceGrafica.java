package Interface;

import javax.swing.*;

import Interface.AlterarStatusTransporte.AlterarSituacaoTransporte;
import Interface.CadastrarDrones.CadastrarDroneGUI;
import Interface.CadastrarTransportes.CadastrarTransporteGUI;
import Interface.MostrarDadosTransportes.MostrarTodosTransportesGUI;
import aplicacao.ACMEAirDrones;
import java.util.List;

import java.awt.*;

public class InterfaceGrafica extends JFrame {
    private ACMEAirDrones sistema;
    private JTextArea mensagemArea; 
    
    public InterfaceGrafica(ACMEAirDrones sistema) {
        this.sistema = sistema;

        // Configurações da janela principal
        setTitle("Sistema de Gerenciamento ACMEAirDrones");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4, 2, 10, 10));

        // Botões de funcionalidades
        JButton cadastrarDroneButton = new JButton("Cadastrar Drone");
        JButton cadastrarTransporteButton = new JButton("Cadastrar Transporte");
        JButton processarTransportesButton = new JButton("Processar Transportes Pendentes");
        JButton mostrarRelatorioButton = new JButton("Mostrar Relatório Geral");
        JButton mostrarTransportesButton = new JButton("Mostrar Todos os Transportes");
        JButton alterarSituacaoButton = new JButton("Alterar Situação de Transporte");
        JButton carregarDadosButton = new JButton("Carregar Dados");
        JButton salvarDadosButton = new JButton("Salvar Dados");

        // Adicionando botões ao painel
        mainPanel.add(cadastrarDroneButton);
        mainPanel.add(cadastrarTransporteButton);
        mainPanel.add(processarTransportesButton);
        mainPanel.add(mostrarRelatorioButton);
        mainPanel.add(mostrarTransportesButton);
        mainPanel.add(alterarSituacaoButton);
        mainPanel.add(carregarDadosButton);
        mainPanel.add(salvarDadosButton);

         // Painel de mensagens
         mensagemArea = new JTextArea();
         mensagemArea.setEditable(false); // Impede edição
         JScrollPane scrollPane = new JScrollPane(mensagemArea); // Permite rolagem
         scrollPane.setPreferredSize(new Dimension(500, 200)); // Largura 500, Altura 200


        // Adiciona o painel principal à janela
        setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        cadastrarDroneButton.addActionListener(e -> {
            new CadastrarDroneGUI(sistema);
        });

        cadastrarTransporteButton.addActionListener(e -> {
            new CadastrarTransporteGUI(sistema);
        });

        processarTransportesButton.addActionListener(e -> {
            processarTransportesPendentes();
        });

        mostrarTransportesButton.addActionListener(e -> {
            new MostrarTodosTransportesGUI(sistema).setVisible(true);
        });
        alterarSituacaoButton.addActionListener(e -> {
            new AlterarSituacaoTransporte(sistema).setVisible(true);
        });

        // Exibe a janela
        setVisible(true);

    }

    private void processarTransportesPendentes() {
        List<String> mensagens = sistema.processarTransportesPendentes();

        // Exibe as mensagens na área de texto
        mensagemArea.setText(""); // Limpa mensagens anteriores
        for (String mensagem : mensagens) {
            mensagemArea.append(mensagem + "\n");
        }
    }
}
