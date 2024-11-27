package Interface;

import javax.swing.*;

import Interface.AlterarStatusTransporte.AlterarSituacaoTransporte;
import Interface.CadastrarDrones.CadastrarDroneGUI;
import Interface.CadastrarTransportes.CadastrarTransporteGUI;
import Interface.MostrarDadosTransportes.MostrarTodosTransportes;
import Interface.data.EscreveDados;
import Interface.data.CarregaDados;
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
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new GridLayout(4, 2, 10, 10));

        // Botões de funcionalidades
        JButton cadastrarDroneBotao = new JButton("Cadastrar Drone");
        JButton cadastrarTransporteBotao = new JButton("Cadastrar Transporte");
        JButton processarTransportesBotao = new JButton("Processar Transportes Pendentes");
        JButton mostrarRelatorioBotao = new JButton("Mostrar Relatório Geral");
        JButton mostrarTransportesBotao = new JButton("Mostrar Todos os Transportes");
        JButton alterarSituacaoBotao = new JButton("Alterar Situação de Transporte");
        JButton carregarDadosBotao = new JButton("Carregar Dados");
        JButton salvarDadosBotao = new JButton("Salvar Dados");

        // Adicionando botões ao painel
        painelPrincipal.add(cadastrarDroneBotao);
        painelPrincipal.add(cadastrarTransporteBotao);
        painelPrincipal.add(processarTransportesBotao);
        painelPrincipal.add(mostrarRelatorioBotao);
        painelPrincipal.add(mostrarTransportesBotao);
        painelPrincipal.add(alterarSituacaoBotao);
        painelPrincipal.add(carregarDadosBotao);
        painelPrincipal.add(salvarDadosBotao);

        // Painel de mensagens
        mensagemArea = new JTextArea();
        mensagemArea.setEditable(false); // Impede edição
        JScrollPane scrollPane = new JScrollPane(mensagemArea); // Permite rolagem
        scrollPane.setPreferredSize(new Dimension(500, 50)); // Largura 500, Altura 50

        // Adiciona o painel principal à janela
        setLayout(new BorderLayout());
        add(painelPrincipal, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        cadastrarDroneBotao.addActionListener(e -> {
            new CadastrarDroneGUI(sistema);
        });

        cadastrarTransporteBotao.addActionListener(e -> {
            new CadastrarTransporteGUI(sistema);
        });

        processarTransportesBotao.addActionListener(e -> {
            processarTransportesPendentes();
        });

        mostrarTransportesBotao.addActionListener(e -> {
            new MostrarTodosTransportes(sistema).setVisible(true);
        });
        alterarSituacaoBotao.addActionListener(e -> {
            new AlterarSituacaoTransporte(sistema).setVisible(true);
        });

        mostrarRelatorioBotao.addActionListener(e -> {
            mostrarRelatorio();
        });

        carregarDadosBotao.addActionListener(e -> {
            new CarregaDados(sistema).carregarDados();
        });

        salvarDadosBotao.addActionListener(e -> {
            new EscreveDados(sistema).salvarDados();
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

    private void mostrarRelatorio() {
        List<String> relatorio = sistema.gerarRelatorioGeral();

        mensagemArea.setText("");
        for (String string : relatorio) {
            mensagemArea.append(string + "\n");
        }
    }
}