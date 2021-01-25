package PEP3T1;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class CambiaVocales {
    public static void main (String[]args){
        //Flujo de entrada para escribir del teclado
        Scanner teclado = new Scanner(System.in);
        FileWriter fw = null;
        //Flujo de salida para grabar en el fichero
        PrintWriter salida = null;
        //Flujo de entrada para leer elfichero
        FileReader fr = null;
        String cadena;
        try{// Se crea fichero
            fw = new FileWriter("src/CambiaVocales.txt");
            // Se referencia fichero
            salida = new PrintWriter(fw);
            System.out.println("\n\t\t PROGRAMA CAMBIAVOCALES\n\t\t ______________________\n\n\nIntroduzca el texto (Para finalizar escriba 'FIN'): \n");
            cadena = teclado.nextLine();
            // Mientras la cadena no contenga la cadena FIN
            while (!cadena.equalsIgnoreCase("FIN")){
                //Se limita la línea a 80 caracteres
                if (cadena.length() < 80) {
                    //Se graba la cadena en el fichero
                    salida.println(cadena);
                    //Se introduce por teclado una nueva cadena de texto en nueva línea (enter al final)
                    cadena = teclado.nextLine();
                // Si la cadena tiene más de 80 caracteres no grabará el contenido, y pedirá un nuevo texto menor a 80 caracteres
                }else {
                    System.out.println("\n\too00 Última línea no incluida en el fichero. El texto debe tener menos de 80 caracteres. 00oo  \n\nVuelva a introducir el texto (Para finalizar escriba 'FIN'):  ");
                    //Se introduce por teclado una nueva cadena de texto en nueva línea (enter al final)
                    cadena = teclado.nextLine();
                }
            }
            System.out.println("\n\too00 Las líneas se han grabado en el fichero 00oo\n");
            // Momento barrendero LIPASAM
            salida.flush();

            // LECTURA DE FICHERO

            // Se referencia fichero
            System.out.println("\nEl texto almacenado, una vez procesado:\n ");
            fr = new FileReader("src/CambiaVocales.txt");
            BufferedReader entrada = new BufferedReader(fr);
            //Se lee la primera línea del fichero
            cadena = entrada.readLine();
            //Mientras no se llegue al final del fichero
            while (cadena != null) {
                // Sustituye 'a' por 'i' y 'e' por 'o'
                cadena = cadena.replace('a', 'i').replace('e', 'o');
                //Se muestra por la pantalla
                System.out.println(cadena);
                //Se leen las siguientes líneas que haya en el fichero
                cadena = entrada.readLine();
            }
            System.out.println("\n\too00 Se acabó el programa 00oo\n");
        }catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }
        }
        //CERRAR EL FLUJO CON EL FICHERO
        salida.close();
    }
}
