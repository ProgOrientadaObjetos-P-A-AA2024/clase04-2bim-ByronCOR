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
        String nombresEst;
        String arriendoMensual;
        String cuotaBase;
        int edadEst;
        double costoCred;
        int numeroCreds;
        double costoAsig;
        int numeroAsigs;
        int tipoArriendo;
        int nP = 0;
        int nD = 0;

        ArrayList<Arriendo> listaArriendos = new ArrayList<>();

        System.out.println("Cuantos interacciones van a ingresar");
        int n = entrada.nextInt();

        for (int i = 0; i < n; i++) {

            System.out.printf("1: ArriendoLocalComercial"
                    + "2: ArriendoLocalComida"
                    + "3: ArriendoLocalSesiones");

            tipoArriendo = entrada.nextInt();
            entrada.nextLine();

            System.out.println("Ingrese el nombre del arrendatario");
            nombresEst = entrada.nextLine();
            System.out.println("Ingrese el arriendo mensual");
            arriendoMensual = entrada.nextLine();
            System.out.println("Ingrese la cuota base");
            cuotaBase = entrada.nextDouble();
          

            if (tipoArriendo == 1) {
                System.out.println("Ingrese el número de créditos");
                numeroCreds = entrada.nextInt();
                System.out.println("Ingrese el costo de cada créditos");
                costoCred = entrada.nextDouble();
                ArriendoLocalComercial arriendoComercial = new ArriendoLocalComercial(
                "Andrew Schroeder", 400);
        arriendoComercial.establecerValorAdicionalFijo(100);
                nP--;
            } else {
                if (tipoArriendo == 2) {
                    System.out.println("Ingrese el número de asignaturas");
                    numeroAsigs = entrada.nextInt();
                    System.out.println("Ingrese el costo de cada asignatura");
                    costoAsig = entrada.nextDouble();
                    EstudianteDistancia estD = new EstudianteDistancia(nombresEst,
                            apellidosEst,
                            identificacionEst,
                            edadEst,
                            numeroAsigs, costoAsig);
                    listaArriendos.add(estD);
                    nD--;
                }else{
                if (tipoArriendo == 3) {
                    System.out.println("Ingrese el número de asignaturas");
                    numeroAsigs = entrada.nextInt();
                    System.out.println("Ingrese el costo de cada asignatura");
                    costoAsig = entrada.nextDouble();
                    EstudianteDistancia estD = new EstudianteDistancia(nombresEst,
                            apellidosEst,
                            identificacionEst,
                            edadEst,
                            numeroAsigs, costoAsig);
                    listaArriendos.add(estD);
                    nD--;
                }
                }
            }
        }

        // ciclo que permite comprobar el polimorfismo
        // este código no debe ser modificado.
        for (int i = 0;
                i < listaArriendos.size();
                i++) {
            // 1.  
            listaArriendos.get(i).calcularMatricula();

            System.out.printf("Lista Arriendos\n"
                    + "%s\n",
                    listaArriendos.get(i));

        }

        ArrayList<Arriendo> listaArriendos = new ArrayList<>();

        ArriendoLocalComida arriendoComida = new ArriendoLocalComida(
                "Christian Shepherd", 300);
        arriendoComida.establecerIva(10); // en porcentaje
        arriendoComida.establecerValorAgua(20.2); // en $
        arriendoComida.establecerValorLuz(40.2); // en $

        ArriendoLocalComercial arriendoComercial = new ArriendoLocalComercial(
                "Andrew Schroeder", 400);
        arriendoComercial.establecerValorAdicionalFijo(100); // en $

        ArriendoLocalSesiones arriendoSesiones = new ArriendoLocalSesiones(
                "Angela Watson", 350);
        arriendoSesiones.establecerValorSillas(10); // en $
        arriendoSesiones.establecerValorAmplificacion(20); // en $

        listaArriendos.add(arriendoComida);
        listaArriendos.add(arriendoComercial);
        listaArriendos.add(arriendoSesiones);

        for (int i = 0; i < listaArriendos.size(); i++) {
            listaArriendos.get(i).establecerArriendoMensual();
        }

        CentroComercial centro = new CentroComercial("La Pradera",
                listaArriendos);
        centro.establecerTotalArriendosBaseMensual();
        centro.establecerTotalArriendosFinalMensual();
        System.out.println(centro);

    }
}
