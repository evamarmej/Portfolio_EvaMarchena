package CTelefonica;

import java.io.*;
import java.util.Scanner;

public class CompTeleClases {

    int numabo;
    String nombreabo;
    float valorfra;
    boolean salir = false;
    FileOutputStream fos = null;
    DataOutputStream salida = null;
    Scanner teclado = new Scanner(System.in);
    static RandomAccessFile fichero = null;

    public void MenuOpciones() {
        System.out.println("\n\t\tPROGRAMA GESTIÓN COMPAÑÍA TELEFÓNICA\n\t\t___________________________________\n\n");
        System.out.println("\t\t\tMenú de opciones\n\t\t\t================\n\n");
        System.out.println("\t\t1) Altas de nuevas facturas");
        System.out.println("\t\t2) Modificación del valor de factura");
        System.out.println("\t\t3) Consulta del dato de facturación de un abonado");
        System.out.println("\t\t4) Consulta del dato de facturación total de la compañía");
        System.out.println("\t\t5) Eliminar fichero");
        System.out.println("\t\t6) Salir\n\n");
        System.out.println("\t\tOpción: ");
    }

    public void altaNuevasFacturas() {
        try {
            //Crea el fichero si no existe y lo abre para escritura
            fos = new FileOutputStream("src/facturas_telf.dat", true);
            salida = new DataOutputStream(fos);

            System.out.println("Número de abonado: ");
            numabo = teclado.nextInt();
            salida.writeInt(numabo);
            teclado.nextLine();


            System.out.println("Nombre: ");
            nombreabo = teclado.next();
            salida.writeUTF(nombreabo);


            System.out.println("Valor de la factura: ");
            valorfra = teclado.nextFloat();
            salida.writeFloat(valorfra);


            System.out.println("Datos incorporados al fichero");

        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
                if (salida != null) {
                    salida.close();
                }
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }

        }
    }

    public void modificacionValorFactura(){
        boolean identificador = true;
        try{
            long pos;

            //Abre el fichero para lectura-escritura
            fichero = new RandomAccessFile("src/facturas_telf.dat", "rw");

            fichero.seek(0);

            System.out.print("Número de abonado: ");
            int num = teclado.nextInt();

            while(true) {
                numabo = fichero.readInt();
                fichero.readUTF();

                //Almacena posición de la línea actual que va a leer
                pos = fichero.getFilePointer();

                if (numabo == num) {
                    valorfra = fichero.readFloat();
                    System.out.println("Valor de la factura: " + valorfra + " €");


                    System.out.println("Nuevo Valor factura: ");
                    valorfra = teclado.nextFloat();

                    fichero.seek(pos);

                    fichero.writeFloat(valorfra);

                    System.out.println("Dato modificado en el fichero");

                    identificador = false;

                } else{
                    fichero.readFloat();
                }

            }

        }catch (EOFException eofe) { //Por si llega al final del fichero
            if (identificador){
                System.out.println("Abonado no registrado");
            }
        }catch (FileNotFoundException fnfe) { //Por si no encuentra el fichero
            System.out.println(fnfe.getMessage());
        } catch (IOException ioe) { //Por si alguien intenta escribir en un fichero de sólo lectura
            System.out.println(ioe.getMessage());
        } finally {
            try {
                if (fichero != null) {
                    fichero.close();
                }
            } catch (IOException eio) {
                System.out.println(eio.getMessage());
            }
        }
    }

    public void datoFacturacionAbonado() {
        boolean identificador = true;
        try {

            //Abre el fichero para lectura-escritura
            fichero = new RandomAccessFile("src/facturas_telf.dat", "r");

            fichero.seek(0);

            System.out.print("Número de abonado: ");
            int num = teclado.nextInt();

            while(true) {
                numabo = fichero.readInt();
                fichero.readUTF();
                if (numabo == num) {
                    valorfra = fichero.readFloat();
                    System.out.printf("Valor de la factura: %.2f €\n", valorfra);
                    identificador = false;
                } else{
                    fichero.readFloat();
                }
            }


        } catch (EOFException eofe) { //Por si llega al final del fichero
            if (identificador){
                System.out.println("Abonado no registrado");
            }
        }catch (FileNotFoundException fnfe) { //Por si no encuentra el fichero
            System.out.println(fnfe.getMessage());
        } catch (IOException ioe) { //Por si alguien intenta escribir en un fichero de sólo lectura
            System.out.println(ioe.getMessage());
        } finally {
            try {
                if (fichero != null) {
                    fichero.close();
                }
            } catch (IOException eio) {
                System.out.println(eio.getMessage());
            }
        }


    }

    public void datoFacturacionTotal(){
        double suma = 0;
        try{//Abre el fichero para lectura-escritura
            fichero = new RandomAccessFile("src/facturas_telf.dat", "r");

            fichero.seek(0);


            while(true) {
                fichero.readInt();
                fichero.readUTF();
                valorfra = fichero.readFloat();
                suma = suma + valorfra;
            }

        }catch (EOFException eofe) { //Por si llega al final del fichero
            System.out.printf("Facturación total: %.2f €\n", suma);
        }catch (FileNotFoundException fnfe) { //Por si no encuentra el fichero
            System.out.println(fnfe.getMessage());
        } catch (IOException ioe) { //Por si alguien intenta escribir en un fichero de sólo lectura
            System.out.println(ioe.getMessage());
        } finally {
            try {
                if (fichero != null) {
                    fichero.close();
                }
            } catch (IOException eio) {
                System.out.println(eio.getMessage());
            }
        }
    }

    public void eliminarFichero(){
        File miFich = new File("src/facturas_telf.dat");
        boolean borrado = miFich.delete();
        if (borrado) {
            System.out.println("Fichero eliminado");
        }
        else {
            System.out.println("Problema al borrar el fichero.");
        }
    }

}
