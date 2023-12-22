package parteb;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import partea.Naipe;
import partea.Palo;

/**
 *
 * @author acebedo
 */
public class Baraja {

    // Atributos de la clase.
    private final List<Naipe> naipes;
    public static int CARTAS_BARAJA = 40;

    // Constructor que inicializa una baraja completa.
    public Baraja() {
        this.naipes = new ArrayList<>();
        inicializarBaraja();
    }

    // Método para inicializar la baraja con cartas ordenadas.
    private void inicializarBaraja() {
        // Bucle a través de todos los valores del enum.
        for (Palo palo : Palo.values()) {
            for (int numero = 1; numero <= 10; numero++) {
                this.naipes.add(new Naipe(palo, numero));
            }
        }
    }

    // Método para obtener la lista de naipes.
    public List<Naipe> getNaipes() {
        return naipes;
    }

    // Método para barajar la baraja un número de veces específico.
    public void barajar(int movimientos) {
        Random random = new Random();
        for (int i = 0; i < movimientos; i++) {
            // Implementar el algoritmo de Fisher-Yates para barajar la lista.
            for (int j = naipes.size() - 1; j > 0; j--) {
                int indiceAleatorio = random.nextInt(j + 1);
                // Intercambiar elementos en las posiciones j e indiceAleatorio.
                Naipe temp = naipes.get(j);
                naipes.set(j, naipes.get(indiceAleatorio));
                naipes.set(indiceAleatorio, temp);
            }
        }
    }

    // Método para sacar un número específico de cartas aleatorias.
    public List<Naipe> sacar(int numCartas) {
        if (numCartas < 1 || numCartas > CARTAS_BARAJA) {
            return new ArrayList<>();  // Devuelve una lista vacía.
        }

        List<Naipe> cartasSacadas = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < numCartas; i++) {
            int posicion;

            // Busca una posición válida en la baraja.
            do {
                posicion = random.nextInt(naipes.size());
            } while (naipes.get(posicion) == null);

            // Saca la carta y establece su valor a null en la baraja.
            cartasSacadas.add(naipes.get(posicion));
            naipes.set(posicion, null);
        }

        return cartasSacadas;
    }

    public List<Naipe> obtenerCartasNoNulas() {
        List<Naipe> cartasNoNulas = new ArrayList<>();

        for (Naipe naipe : naipes) {
            if (naipe != null) {
                cartasNoNulas.add(naipe);
            }
        }

        return cartasNoNulas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Naipe naipe : naipes) {
            sb.append(naipe).append("\n");
        }
        return sb.toString();
    }
}
