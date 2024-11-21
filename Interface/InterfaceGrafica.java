package Interface;

import javax.swing.*;

import Interface.CadastrarDrones.CadastrarDroneGUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceGrafica extends JFrame {
    
    public InterfaceGrafica() {
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

        // Adiciona o painel principal à janela
        add(mainPanel, BorderLayout.CENTER);

        cadastrarDroneButton.addActionListener(e -> {
            new CadastrarDroneGUI();
        });

        // Exibe a janela
        setVisible(true);
    }
}
