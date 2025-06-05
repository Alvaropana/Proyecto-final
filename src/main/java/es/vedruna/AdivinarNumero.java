package es.vedruna;
import java.util.Random;
import java.util.Scanner;

public class AdivinarNumero {
    //Metodo para jugar 
    public static void jugar() {
        Scanner scanner = new Scanner(System.in);
        int numeroObjetivo = generarNumeroAleatorio(0, 100);
        int rondas = 0;
        int numeroJugador;

        System.out.println("Adivina el número entre 0 y 100.");
        do {
            numeroJugador = IntroducirNumeroValido(scanner, 0, 100);
            rondas++;
            mostrarPista(numeroJugador, numeroObjetivo);
        } while (numeroJugador != numeroObjetivo);

        mostrarGanador(rondas);
    }
    // metodo que genera el numero que hay que adivinar
    public static int generarNumeroAleatorio(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    // Este metodo lo que hace es pedir el numeor al jugador y tambien valida que el jugador introduzca un numero dentro del rango y que solo queta nuemeros
    public static int IntroducirNumeroValido(Scanner scanner, int min, int max) {
        int numero;

        while (true) {
            System.out.print("Introduce un número entre: ");
            try {
                numero = scanner.nextInt();
                if (numero >= min && numero <= max) {
                    return numero;
                } else {
                    System.out.println("Número fuera de rango.");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida. Solo se permiten números enteros.");
                scanner.next();
            }
        }
    }
    // Muetra si el jugador a in troducido un numero menor y mayor al que tiene que adivinar
    public static void mostrarPista(int numeroUsuario, int numeroObjetivo) {
        if (numeroUsuario < numeroObjetivo) {
            System.out.println("Es mayor.");
        } else if (numeroUsuario > numeroObjetivo) {
            System.out.println("Es menor.");
        }
    }
    // Muestra que has gando y te dice cunatos intentos has tadardo qeu adivinarlo
    public static void mostrarGanador(int rondas) {
        System.out.println("¡Felicidades! Has adivinado el número.");
        System.out.println("Intentos: " + rondas);
    }

}
