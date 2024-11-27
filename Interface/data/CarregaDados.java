package Interface.data;

import aplicacao.ACMEAirDrones;
import dados.*;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CarregaDados {
    private ACMEAirDrones sistema;

    public CarregaDados(ACMEAirDrones sistema) {
        this.sistema = sistema;
    }

    public void carregarDados() {
        String nomeArquivo = JOptionPane.showInputDialog(null, "Digite o nome do arquivo (sem extensão):");
        if (nomeArquivo != null && !nomeArquivo.trim().isEmpty()) {
            boolean sucesso = carregarDrones(nomeArquivo) && carregarTransportes(nomeArquivo);
            if (sucesso) {
                JOptionPane.showMessageDialog(null, "Dados carregados com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao carregar dados.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nome de arquivo inválido.");
        }
    }

    private boolean carregarDrones(String nomeArquivo) {
        String caminhoArquivo = "resources/" + nomeArquivo + ".csv";
        if (!Files.exists(Paths.get(caminhoArquivo))) {
            JOptionPane.showMessageDialog(null, "Arquivo de drones não encontrado: " + caminhoArquivo);
            return false;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            br.readLine(); // Pular cabeçalho
            while ((linha = br.readLine()) != null) {
                String[] campos = linha.split(";");
                int tipo = Integer.parseInt(campos[0]);
                int codigo = Integer.parseInt(campos[1]);
                double custoFixo = Double.parseDouble(campos[2]);
                double autonomia = Double.parseDouble(campos[3]);
                double pesoMaximo = Double.parseDouble(campos[4]);
                boolean protecaoClimatizado = campos.length > 5 && Boolean.parseBoolean(campos[5]);

                Drone drone;
                if (tipo == 1) {
                    drone = new DronePessoal(codigo, custoFixo, autonomia, (int) pesoMaximo);
                } else if (tipo == 2) {
                    drone = new DroneCargaViva(codigo, custoFixo, autonomia, pesoMaximo, protecaoClimatizado);
                } else {
                    drone = new DroneCargaInanimada(codigo, custoFixo, autonomia, pesoMaximo, protecaoClimatizado);
                }

                sistema.adicionarDrone(drone);
            }
            return true;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar drones: " + e.getMessage());
            return false;
        }
    }

    private boolean carregarTransportes(String nomeArquivo) {
        String caminhoArquivo = "resources/" + nomeArquivo + ".csv";
        if (!Files.exists(Paths.get(caminhoArquivo))) {
            JOptionPane.showMessageDialog(null, "Arquivo de transportes não encontrado: " + caminhoArquivo);
            return false;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            br.readLine(); // Pular cabeçalho
            while ((linha = br.readLine()) != null) {
                String[] campos = linha.split(";");
                int tipo = Integer.parseInt(campos[0]);
                int numero = Integer.parseInt(campos[1]);
                String nomeCliente = campos[2];
                String descricao = campos[3];
                double peso = Double.parseDouble(campos[4]);
                double latOrigem = Double.parseDouble(campos[5]);
                double longOrigem = Double.parseDouble(campos[6]);
                double latDestino = Double.parseDouble(campos[7]);
                double longDestino = Double.parseDouble(campos[8]);

                Transporte transporte;
                if (tipo == 1) {
                    int qtdPessoas = Integer.parseInt(campos[9]);
                    transporte = new TransportePessoal(numero, nomeCliente, descricao, peso, latOrigem, longOrigem, latDestino, longDestino, Estado.PENDENTE, qtdPessoas);
                } else if (tipo == 2) {
                    boolean cargaPerigosa = Boolean.parseBoolean(campos[9]);
                    transporte = new TransporteCargaInanimada(numero, nomeCliente, descricao, peso, latOrigem, longOrigem, latDestino, longDestino, Estado.PENDENTE, cargaPerigosa);
                } else {
                    double tempMin = Double.parseDouble(campos[9]);
                    double tempMax = Double.parseDouble(campos[10]);
                    transporte = new TransporteCargaViva(numero, nomeCliente, descricao, peso, latOrigem, longOrigem, latDestino, longDestino, Estado.PENDENTE, tempMin, tempMax);
                }

                sistema.adicionarTransporte(transporte);
            }
            return true;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar transportes: " + e.getMessage());
            return false;
        }
    }
}