package parteb;

import java.util.List;
import partea.Naipe;

/**
 *
 * @author acebedo
 */
public class PruebaBaraja {

    public static void main(String[] args) {
        // Crear una instancia de Baraja
        Baraja baraja = new Baraja();

        // Mostrar la baraja antes de barajar
        System.out.println("Baraja antes de barajar:\n" + baraja.toString());

        // Barajar la baraja con 10 movimientos
        baraja.barajar(10);

        // Mostrar la baraja después de barajar
        System.out.println("Baraja después de barajar:\n" + baraja.toString());

        // Sacar 2 cartas de la baraja
        List<Naipe> cartasSacadas = baraja.sacar(2);

        // Mostrar las cartas sacadas
        System.out.println("Cartas sacadas de la baraja:\n" + cartasSacadas);

        // Mostrar la baraja después de sacar cartas
        System.out.println("Baraja después de sacar cartas:\n" + baraja.toString());

        // Obtener y mostrar las cartas no nulas después de sacar cartas
        List<Naipe> cartasNoNulas = baraja.obtenerCartasNoNulas();
        System.out.println("Cartas no nulas después de sacar cartas:");
        for (Naipe naipe : cartasNoNulas) {
            System.out.println(naipe);
        }
    }

}
