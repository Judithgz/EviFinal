package org.example.VISTA;

import java.util.Scanner;

public class Vista {

    // Scanner para leer entrada
    private static Scanner sc = new Scanner(System.in);

    // Metodo para mostrar un mensaje
    public static void imprimir(Object mensaje) {
        System.out.print(mensaje);
    }

    // Metodo para pedir al usuario un dato de tipo String
    public static String entrada() {
        String eString = "";
        try {
            eString = sc.nextLine();
        } catch (Exception e) {
            imprimir("Error al leer la entrada");
            return entrada();
        }
        return eString;
    }

    // Metodo para pedir al usuario un dato de tipo int
    public static int entradaInt(int min, int max) {
        String eString = entrada();
        int eInt = 0;
        try {
            eInt = Integer.parseInt(eString);
            if (eInt < min || eInt > max) {
                imprimir("El valor introducido no es correcto\n"
                        + "Introduzca un valor entre " + min + " y " + max + ": ");
                return entradaInt(min, max);
            }
        } catch (Exception e) {
            imprimir("Error: " + eString + " no es un numero\n"
                    + "Introduzca un valor numerico entre " + min + " y " + max + ": ");
            return entradaInt(min, max);
        }
        return eInt;
    }

    public static String entradaString(String string) {
        String eString = entrada();
        // string contiene los caracteres que se pueden introducir
        if (!string.contains(eString)) {
            imprimir("Error: " + eString + " no es un caracter valido\n"
                    + "Introduzca un caracter valido: ");
            return entradaString(string);
        }
        return eString;
    }
}
