package es.vedruna;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;


public class AdivinarNumeroTest {

    @Test
    public void NumeroAleatorioDentroDeRango() {
        System.out.println("generarNumeroAleatorio");
        for (int i = 0; i < 100; i++) {
            int numero = AdivinarNumero.generarNumeroAleatorio(0, 100);
            Assertions.assertTrue(numero >= 0 && numero <= 100);
        }
    }

    @Test
    public void NumeroValidoEnRango() {
        System.out.println("número válido dentro del rango");
        String entradaSimulada = "50";
        InputStream entrada = new java.io.ByteArrayInputStream(entradaSimulada.getBytes());
        System.setIn(entrada);
        Scanner scanner = new Scanner(System.in);
        int resultado = AdivinarNumero.IntroducirNumeroValido(scanner, 0, 100);
        Assertions.assertEquals(50, resultado);
    }

    @Test
    public void mostrarPistaMayor() {
        System.out.println("mostrarPista - número usuario menor");
        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(salida));
        AdivinarNumero.mostrarPista(3, 8);
        Assertions.assertTrue(salida.toString().contains("Es mayor."));
    }

    @Test
    public void mostrarPistaMenor() {
        System.out.println("mostrarPista - número usuario mayor");
        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(salida));
        AdivinarNumero.mostrarPista(10, 4);
        Assertions.assertTrue(salida.toString().contains("Es menor."));
    }

    @Test
    public void mostrarGanador() {
        System.out.println("mostrarGanador");
        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(salida));
        AdivinarNumero.mostrarGanador(4);
        String textoSalida = salida.toString();
        Assertions.assertTrue(textoSalida.contains("¡Felicidades!"));
        Assertions.assertTrue(textoSalida.contains("Intentos: 4"));
    }


}