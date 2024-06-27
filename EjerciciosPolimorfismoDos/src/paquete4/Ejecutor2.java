/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete4;

import java.util.ArrayList;
import java.util.Scanner;
import paquete2.Arriendo;
import paquete3.ArriendoLocalComercial;
import paquete3.ArriendoLocalComida;
import paquete3.ArriendoLocalSesiones;

public class Ejecutor2 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String nombreCentroComercial;
        String nombreArrendatario;
        String cadena;
        double cuotaBase;

        double valorAdicionalFijo;

        double valorLuz;
        double valorAgua;
        double iva;

        double valorSillas;
        double valorAmplificacion;

        int tipoArriendo;

        ArrayList<Arriendo> listaArriendos = new ArrayList<>();

        System.out.printf("Ingrese el nombre del Centro Comercial: ");
        nombreCentroComercial = entrada.nextLine();

        System.out.println("Cuantos Locales van a arrendar: ");
        int n = entrada.nextInt();

        for (int i = 0; i < n; i++) {

            System.out.printf("1: ArriendoLocalComercial\n"
                    + "2: ArriendoLocalComida\n"
                    + "3: ArriendoLocalSesiones\n");

            tipoArriendo = entrada.nextInt();
            entrada.nextLine();

            System.out.println("Ingrese el nombre del arrendatario: ");
            nombreArrendatario = entrada.nextLine();

            System.out.println("Ingrese la cuota base: ");
            cuotaBase = entrada.nextDouble();

            if (tipoArriendo == 1) {

                System.out.println("Ingrese el valor adicional fijo: ");
                valorAdicionalFijo = entrada.nextDouble();

                ArriendoLocalComercial arriendoComercial = new ArriendoLocalComercial(
                        nombreArrendatario, cuotaBase, valorAdicionalFijo);
                listaArriendos.add(arriendoComercial);
            } else {
                if (tipoArriendo == 2) {

                    System.out.println("Ingrese el valor de la Luz: ");
                    valorLuz = entrada.nextDouble();
                    System.out.println("Ingrese el valor del Agua: ");
                    valorAgua = entrada.nextDouble();
                    System.out.println("Ingrese el valor del IVA: ");
                    iva = entrada.nextDouble();
                    ArriendoLocalComida arriendoComida = new ArriendoLocalComida(
                            nombreArrendatario, cuotaBase, valorLuz, valorAgua, iva);

                    listaArriendos.add(arriendoComida);

                } else {
                    if (tipoArriendo == 3) {
                        System.out.println("Ingrese el costo de las sillas: ");
                        valorSillas = entrada.nextDouble();
                        System.out.println("Ingrese el costo de la Amplificacion: ");
                        valorAmplificacion = entrada.nextDouble();
                        entrada.nextLine();
                        ArriendoLocalSesiones arriendoSesiones = new ArriendoLocalSesiones(
                                nombreArrendatario, cuotaBase, valorSillas, valorAmplificacion);

                        listaArriendos.add(arriendoSesiones);
                    }
                }
            }
        }

        // ciclo que permite comprobar el polimorfismo
        // este código no debe ser modificado.
        cadena = String.format("\nDATOS CENTRO COMERCIAL\n"
                + "-----------------------------------\n"
                + "Nombre del Centro Comercial: %s\n\n"
                + "---------LISTA DE LOCALES----------\n\n", nombreCentroComercial);

        for (int i = 0; i < listaArriendos.size(); i++) {
            // 1.  
            listaArriendos.get(i).establecerArriendoMensual();

            cadena = String.format("\n%s(%d) "
                    + "%s\n",
                    cadena,
                    i + 1,
                    listaArriendos.get(i));

        }

        System.out.printf(cadena);

    }
}
