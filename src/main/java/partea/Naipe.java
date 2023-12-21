package partea;

import java.util.Random;
import java.util.List;
import java.util.Arrays;

/**
 *
 * @author acebedo
 */
public class Naipe {

    // Atributos de la carta.
    private Palo palo;
    private int numeroCarta;

    // Constructor sin parámetros que genera una carta aleatoria.
    public Naipe() {
        this.palo = generarPaloAleatorio();
        this.numeroCarta = generarNumeroCartaAleatorio();
    }

    // Constructor con parámetros para crear una carta específica.
    public Naipe(Palo palo, int numeroCarta) {
        this.palo = palo;
        this.numeroCarta = numeroCarta;

        // Verificar la validez del número de carta
        if (!esNumeroValido(numeroCarta)) {
            throw new IllegalArgumentException("Numero de carta no valido.");
        }
    }

    // Métodos get y set para el palo y número de la carta.
    public Palo getPalo() {
        return palo;
    }

    public int getNumeroCarta() {
        return numeroCarta;
    }

    public void setPalo(Palo palo) {
        this.palo = palo;
    }

    public void setNumeroCarta(int numero) {
        // Si queremos cambiar el número de carta y el valor esta fuera de los 
        // valores permitidos, entonces no se cambiará el atributo.
        if (esNumeroValido(numero)) {
            this.numeroCarta = numero;
        }
    }

    // Método para generar un número de carta aleatorio entre 1 y 10.
    private int generarNumeroCartaAleatorio() {
        return new Random().nextInt(10) + 1;
    }

    // Método para generar un palo aleatorio.
    private Palo generarPaloAleatorio() {
        List<Palo> palos = Arrays.asList(Palo.values());
        int iAleatorio = new Random().nextInt(palos.size());
        return palos.get(iAleatorio);
    }

    // Método para verificar la validez del número de la carta.
    private boolean esNumeroValido(int numero) {
        return numero >= 1 && numero <= 10;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Naipe{");
        sb.append("palo=").append(palo);
        sb.append(", numeroCarta=");
        switch (numeroCarta) {
            case 8 ->
                sb.append("Sota");
            case 9 ->
                sb.append("Caballo");
            case 10 ->
                sb.append("Rey");
            default ->
                sb.append(numeroCarta);
        }
        sb.append('}');
        return sb.toString();
    }

}
