package aplicacao;

import dados.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GerenciaDrones {
    private static List<Drone> drones = new ArrayList<>();

    public static boolean adicionarDrone (Drone drone) {
        for (Drone d : drones) {
            if (drone.getCodigo() == d.getCodigo()) {
                return false;
            }
        }
        drones.add(drone);
        ordenarDrones();
        return true;
    }

    public static List<Drone> getDrones() {
        return drones;
    }

    private static void ordenarDrones() {
        drones.sort(Comparator.comparingInt(Drone::getCodigo));
    }
}