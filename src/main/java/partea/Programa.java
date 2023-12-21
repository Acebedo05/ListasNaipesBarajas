package partea;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acebedo
 */
public class Programa {

    public static void main(String[] args) {
        // Lista para almacenar naipes generados aleatoriamente.
        List<Naipe> naipes = new ArrayList<>();

        // Bucle para generar naipes aleatorios y mostrarlos en consola.
        while (true) {
            Naipe naipe = new Naipe();
            naipes.add(naipe);
            System.out.println(naipe);

            // Verificar si el naipe es el Rey de Oros.
            if (naipe.getPalo() == Palo.OROS && naipe.getNumeroCarta() == 10) {
                System.out.println("Se ha encontrado el Rey de Oros.");
                break;
            }
        }
    }
}
