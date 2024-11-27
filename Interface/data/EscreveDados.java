package Interface.data;

import aplicacao.ACMEAirDrones;
import dados.*;
import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EscreveDados {
    private ACMEAirDrones sistema;

    public EscreveDados(ACMEAirDrones sistema) {
        this.sistema = sistema;
    }

    public void salvarDados() {
        String nomeArquivo = JOptionPane.showInputDialog(null, "Digite o nome do arquivo (sem extensão):");
        if (nomeArquivo != null && !nomeArquivo.trim().isEmpty()) {
            boolean sucesso = salvarDrones(nomeArquivo) && salvarTransportes(nomeArquivo);
            if (sucesso) {
                JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao salvar dados.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nome de arquivo inválido.");
        }
    }

    private boolean salvarDrones(String nomeArquivo) {
        String caminhoArquivo = "resources/" + nomeArquivo + "-drones.csv";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            bw.write("tipo;codigo;custofixo;autonomia;qtdmaxpessoas_pesomaximo;protecao_climatizado\n");
            for (Drone drone : sistema.getDronesDisponiveis()) {
                if (drone instanceof DronePessoal) {
                    DronePessoal dp = (DronePessoal) drone;
                    bw.write(String.format("1;%d;%.2f;%.2f;%d\n", dp.getCodigo(), dp.getCustoFixo(), dp.getAutonomia(), dp.getQtdMaxPessoas()));
                } else if (drone instanceof DroneCargaViva) {
                    DroneCargaViva dcv = (DroneCargaViva) drone;
                    bw.write(String.format("2;%d;%.2f;%.2f;%.2f;%b\n", dcv.getCodigo(), dcv.getCustoFixo(), dcv.getAutonomia(), dcv.getPesoMaximo(), dcv.isClimatizado()));
                } else if (drone instanceof DroneCargaInanimada) {
                    DroneCargaInanimada dci = (DroneCargaInanimada) drone;
                    bw.write(String.format("3;%d;%.2f;%.2f;%.2f;%b\n", dci.getCodigo(), dci.getCustoFixo(), dci.getAutonomia(), dci.getPesoMaximo(), dci.isProtecao()));
                }
            }
            return true;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar drones: " + e.getMessage());
            return false;
        }
    }

    private boolean salvarTransportes(String nomeArquivo) {
        String caminhoArquivo = "resources/" + nomeArquivo + "-transportes.csv";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            bw.write("tipo;numero;nomecliente;descricao;peso;latorigem;longorigem;latdestino;longdestino;qtdpessoas;perigosa;tempmin;tempmax\n");
            for (Transporte transporte : sistema.getTodosTransportes()) {
                if (transporte instanceof TransportePessoal) {
                    TransportePessoal tp = (TransportePessoal) transporte;
                    bw.write(String.format("1;%d;%s;%s;%.2f;%.6f;%.6f;%.6f;%.6f;%d\n", tp.getNumero(), tp.getNomeCliente(), tp.getDescricao(), tp.getPeso(), tp.getLatitudeOrigem(), tp.getLongitudeOrigem(), tp.getLatitudeDestino(), tp.getLongitudeDestino(), tp.getQtdPessoas()));
                } else if (transporte instanceof TransporteCargaInanimada) {
                    TransporteCargaInanimada tci = (TransporteCargaInanimada) transporte;
                    bw.write(String.format("2;%d;%s;%s;%.2f;%.6f;%.6f;%.6f;%.6f;%b\n", tci.getNumero(), tci.getNomeCliente(), tci.getDescricao(), tci.getPeso(), tci.getLatitudeOrigem(), tci.getLongitudeOrigem(), tci.getLatitudeDestino(), tci.getLongitudeDestino(), tci.isCargaPerigosa()));
                } else if (transporte instanceof TransporteCargaViva) {
                    TransporteCargaViva tcv = (TransporteCargaViva) transporte;
                    bw.write(String.format("3;%d;%s;%s;%.2f;%.6f;%.6f;%.6f;%.6f;%.2f;%.2f\n", tcv.getNumero(), tcv.getNomeCliente(), tcv.getDescricao(), tcv.getPeso(), tcv.getLatitudeOrigem(), tcv.getLongitudeOrigem(), tcv.getLatitudeDestino(), tcv.getLongitudeDestino(), tcv.getTemperaturaMinima(), tcv.getTemperaturaMaxima()));
                }
            }
            return true;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar transportes: " + e.getMessage());
            return false;
        }
    }
}