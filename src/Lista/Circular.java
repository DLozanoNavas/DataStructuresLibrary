/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lista;

/**
 *
 * @author dlozanonavas
 */
public class Circular {

    public int size = 0;
    public CircularNode head = null;
    public CircularNode tail = null;

    //add a new node at the start of the linked list
    public void addNodeAtStart(int data) {
        System.out.println("Agregando nodo " + data + " al inicio.");
        CircularNode n = new CircularNode(data);
        if (size == 0) {
            head = n;
            tail = n;
            n.next = head;
        } else {
            CircularNode temp = head;
            n.next = temp;
            head = n;
            tail.next = head;
        }
        size++;
    }

    public void addNodeAtEnd(int data) {
        if (size == 0) {
            addNodeAtStart(data);
        } else {
            CircularNode n = new CircularNode(data);
            tail.next = n;
            tail = n;
            tail.next = head;
            size++;
        }
        System.out.println("\nEl nodo " + data + " ha sido añadido al final de la lista.");
    }

    public void deleteNodeFromStart() {
        if (size == 0) {
            System.out.println("\nLa lista está vacía.");
        } else {
            System.out.println("\nEliminando nodo " + head.data + " del inicio");
            head = head.next;
            tail.next = head;
            size--;
        }
    }

    public int elementAt(int index) {
        if (index > size) {
            return -1;
        }
        CircularNode n = head;
        while (index - 1 != 0) {
            n = n.next;
            index--;
        }
        return n.data;
    }

    //print the linked list
    public void print() {
        System.out.print("Lista circular::");
        CircularNode temp = head;
        if (size <= 0) {
            System.out.print("La lista está vacía.");
        } else {
            do {
                System.out.print(" " + temp.data);
                temp = temp.next;
            } while (temp != head);
        }
        System.out.println();
    }

    //get Size
    public int getSize() {
        return size;
    }

}

class CircularNode {

    int data;
    CircularNode next;

    public CircularNode(int data) {
        this.data = data;
    }
}
