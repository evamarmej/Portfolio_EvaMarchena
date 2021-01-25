package Puntuable3;

import java.util.Scanner;

public class PeliculasImpl {
    public static void main (String [] args){
        Scanner teclado = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        Peliculas pt = new Peliculas();


        while(!salir){
            pt.opciones();
            System.out.println("Elige una opción: ");
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion){
                case 1:   pt.presentar();
                          break;
                case 2:
                          pt.anadirnodo();
                          break;
                case 3:
                          pt.modificarnodo();
                          break;
                case 4:
                          pt.eliminarnodo();
                          break;
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }
}
