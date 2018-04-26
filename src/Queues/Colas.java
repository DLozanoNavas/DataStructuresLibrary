/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author dlozanonavas
 */
public class Colas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner es = new Scanner(System.in);
        String stmp;
        float avg = 0;
        Queue<Student> cola = new LinkedList();
        Queue<Student> cola2 = new LinkedList();
        Queue<Student> aprobados = new LinkedList();
        Queue<Student> reprobados = new LinkedList();
        while (true) {
            for (int i = 0; i < 5; i++) {
                System.out.println("Nombre: ");
                String name = es.next();
                System.out.println("Nota: ");
                int nota = es.nextInt();
                Student s = new Student(name, nota);
                cola.add(s);
            }

            //System.out.println("\nPeeked: "+cola.peek());
            //System.out.print("\n Removed: "+cola.remove());
            //while (!cola.isEmpty()) {
            //    System.out.print(cola.toString());
            //}
            while (!cola.isEmpty()) {
                Student s = cola.remove();
                avg += s.getNota();
                if (s.getNota() >= 3.0) {
                    aprobados.add(s);
                } else {
                    reprobados.add(s);
                }
                System.out.println("Procesado: " + s.getNombre() + ". Nota: " + s.getNota());
                cola2.add(s);
            }
            if (cola.isEmpty()) {
                while (!cola2.isEmpty()) {
                    cola.add(cola2.remove());
                }
            }
            //System.out.print(cola.toString());
            System.out.println("El promedio es: " + (avg / 5));
            while (!reprobados.isEmpty()) {
                Student print = reprobados.remove();
                System.out.println("Reprobado. Nombre: " + print.getNombre() + ". Nota: " + print.getNota());
            }
            while (!aprobados.isEmpty()) {
                Student print = aprobados.remove();
                System.out.println("Aprobado. Nombre: " + print.getNombre() + ". Nota: " + print.getNota());
            }

        }
        
    }
}
