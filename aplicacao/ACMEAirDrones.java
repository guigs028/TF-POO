package aplicacao;

import dados.*;
import java.util.*;

public class ACMEAirDrones {
    private List<Drone> dronesDisponiveis = new ArrayList<>();
    private List<Transporte> transportesPendentes = new ArrayList<>();
    private Set<Integer> transportesNumeros = new HashSet<>();

    // -------- Métodos de Gerenciamento de Drones --------
    public boolean adicionarDrone(Drone drone) {
        for (Drone d : dronesDisponiveis) {
            if (drone.getCodigo() == d.getCodigo()) {
                return false; // Código duplicado, não adiciona o drone
            }
        }
        dronesDisponiveis.add(drone);
        ordenarDrones();
        return true;
    }

    public List<Drone> getDronesDisponiveis() {
        return dronesDisponiveis;
    }

    private void ordenarDrones() {
        dronesDisponiveis.sort(Comparator.comparingInt(Drone::getCodigo));
    }

    // -------- Métodos de Gerenciamento de Transportes --------
    public boolean adicionarTransporte(Transporte transporte) {
        if (transportesNumeros.contains(transporte.getNumero())) {
            return false; // Número duplicado, não adiciona o transporte
        } else {
            transportesPendentes.add(transporte);
            transportesNumeros.add(transporte.getNumero());
            return true;
        }
    }

    public List<String> processarTransportesPendentes() {
        Iterator<Transporte> iterator = transportesPendentes.iterator();
        List<String> mensagens = new ArrayList<>();
    
        while (iterator.hasNext()) {
            Transporte transporte = iterator.next();
    
            // Procurar um drone disponível que atenda aos requisitos
            Drone droneAdequado = encontrarDroneAdequado(transporte);
    
            if (droneAdequado != null) {
                // Associar o drone ao transporte
                transporte.setDrone(droneAdequado);
                transporte.setSituacao(Estado.ALOCADO);
                iterator.remove(); // Remover da fila de pendentes
                dronesDisponiveis.remove(droneAdequado); // Remover drone da lista de disponíveis
                //add da lista// 
                transportesProcessados.add(transporte); // Adicionar à lista de processados
                mensagens.add("Transporte " + transporte.getNumero() + " alocado ao drone " + droneAdequado.getCodigo());
            } else {
                // Transporte sem drone adequado
                mensagens.add("Nenhum drone disponível para o transporte " + transporte.getNumero());
            }
        }
    
        // Verifica se ainda há transportes pendentes
        if (transportesPendentes.isEmpty() && mensagens.isEmpty()) {
            mensagens.add("Todos os transportes pendentes foram processados.");
        }
    
        return mensagens;
    }    

    private Drone encontrarDroneAdequado(Transporte transporte) {
        for (Drone drone : dronesDisponiveis) {
            // Verifica se o drone é compatível com o tipo de transporte
            if (drone instanceof DronePessoal && transporte instanceof TransportePessoal) {
                return drone;
            } else if (drone instanceof DroneCargaInanimada && transporte instanceof TransporteCargaInanimada) {
                return drone;
            } else if (drone instanceof DroneCargaViva && transporte instanceof TransporteCargaViva) {
                return drone;
            }
        }
        return null; // Retorna null se nenhum drone for adequado
    }

    // codigos necessarios para as 2 telas //
    public Transporte getTransportePorNumero(int numero) {
        for (Transporte transporte : transportesPendentes) {
            if (transporte.getNumero() == numero) {
                return transporte;
            }
        }
        return null;
    }

    private List<Transporte> transportesProcessados = new ArrayList<>();
    
    public List<Transporte> getTodosTransportes() {
        List<Transporte> todosTransportes = new ArrayList<>(transportesPendentes);
        todosTransportes.addAll(transportesProcessados);
        return todosTransportes;
    }

}
