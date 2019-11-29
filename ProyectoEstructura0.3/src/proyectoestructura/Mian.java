package proyectoestructura;

import java.util.Scanner;

public class Mian {

    static Scanner leer = new Scanner(System.in);

    //terminadito
    public static void main(String[] args) {
        int opcion = 0;
        ArbolB t = new ArbolB(6);

        while (opcion != 4) {

            System.out.println("Inserte una de la siguientes opciones: ");
            System.out.println("1) Insertar");
            System.out.println("2) Buscar");
            System.out.println("3) Imprimir");
            System.out.println("4) Salir");

            opcion = leer.nextInt();

            switch (opcion) {
                case 1:

                    for (int i = 1; i < 1000; i++) {
                        t.insert(i);
                    }


                    break;
                case 2:
                    String cadena2 = "";
                    int k = 0;
                    System.out.println("Ingrese el dato a buscar: ");
                    cadena2 = leer.next();
                    k = Integer.parseInt(cadena2);
                    NodosArbol x = t.Buscar(k);
                    if (x != null) {

                        for (int i = 0; i < x.getLlaves().size(); i++) {
                            System.out.println(x.getLlaves().get(i));
                        }

                        System.out.println("El dato si esta presente en el arbol");
                    } else {
                        System.out.println("El dato no esta en el arbol");
                    }
                    break;
                case 3:
                    System.out.println("El recorrido del árbol construido es");
                    t.Imprimir();
                    break;
                case 4:
                    System.out.println("El programa se cerrara");
                    break;

                case 5:
//                    t.eliminar(486);
                    System.out.println("ingrese el numero que desea elminar");
                    int num = leer.nextInt();
                    t.eliminar(num);
                    break;

                default:
                    System.out.println("La opcion ingresada es incorrecta");
                    break;
            }
        }

    }

}
