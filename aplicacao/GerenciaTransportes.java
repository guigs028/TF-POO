package aplicacao;

import dados.*;

import java.util.*;

public class GerenciaTransportes {
    private static Queue<Transporte> filaTransportesPendentes = new LinkedList<>();
    private static Set<Integer> transportesNumeros = new HashSet<>();

    public static boolean adicionarTransporte(Transporte transporte) {
        if (transportesNumeros.contains(transporte.getNumero())) {
            return false; 
        } else {
            filaTransportesPendentes.add(transporte);
            transportesNumeros.add(transporte.getNumero()); 
            return true;
        }
    }

    public static Queue<Transporte> getFilaTransportesPendentes() {
        return filaTransportesPendentes;
    }

    // Método para processar transportes pendentes (exemplo de mudança de estado)
    public static void processarTransportesPendentes() {
        for (Transporte transporte : filaTransportesPendentes) {
            if (transporte.getSituacao() == Estado.PENDENTE) {
                // Alocar o transporte (simulação de processo)
                transporte.setSituacao(Estado.ALOCADO);  // Mudar para alocado
                System.out.println("Transporte " + transporte.getNumero() + " foi alocado.");
            }
        }
    }

    // Método para exibir todos os transportes na fila pendente
    public static void exibirTransportesPendentes() {
        for (Transporte transporte : filaTransportesPendentes) {
            System.out.println("Transporte número: " + transporte.getNumero() + " | Estado: " + transporte.getSituacao());
        }
    }
}
