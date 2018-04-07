/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author dlozanonavas
 */
public class DoblementeEnlazada {

    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    private int lengthOfDLL(DoublyLLNode head) {
        DoublyLLNode currentNode = head;
        int length = 0;
        while (currentNode != null) {
            currentNode = currentNode.getNext();
            length++;
        }
        return length;
    }

    public DoublyLLNode insertData(DoublyLLNode head,
            DoublyLLNode nodeToInsert, int position) {

        if (head == null) {
            // This is the first element in the list
            return nodeToInsert;
        }
        int size = lengthOfDLL(head);
        if (position < 1 || position > size + 1) {
            System.out.println("Dato inválido. Ingresa un número enntre 1 y "
                    + (size + 1));
            return head;
        }

        if (position == 1) { // Inserting in the 1st position
            nodeToInsert.setNext(head);
            head.setPrev(nodeToInsert);
            return nodeToInsert;
        } else { // Inserting at last or in middle
            DoublyLLNode prevNode = head;
            int count = 1;
            while (count < position - 1) {
                prevNode = prevNode.getNext();
                count++;
            }
            DoublyLLNode currentNode = prevNode.getNext();
            nodeToInsert.setPrev(prevNode);
            nodeToInsert.setNext(currentNode);
            prevNode.setNext(nodeToInsert);
            if (currentNode != null) {
                currentNode.setPrev(nodeToInsert);
            }
            return head;

        }
    }

    public DoublyLLNode deleteData(DoublyLLNode head, int position) {
        if (head == null) {
            System.out.println("La lista está vacía.");
            return null;
        }
        int size = lengthOfDLL(head);
        if (position < 1 || position > size) {
            System.out.println("Dato inválido. Ingresa un número enntre 1 y " + size);
            return head;
        }
        if (position == 1) {
            // Deleting the first element in the list
            DoublyLLNode currentNode = head.getNext();
            if (currentNode != null) {
                currentNode.setPrev(null);
            }
            head = null;
            return currentNode;
        } else {
            // Delete middle or last element
            DoublyLLNode prevNode = head;
            int count = 1;
            while (count < position - 1) {
                prevNode = prevNode.getNext();
                count++;
            }
            DoublyLLNode currentNode = prevNode.getNext();
            prevNode.setNext(currentNode.getNext());
            if (currentNode.getNext() != null) {
                currentNode.getNext().setPrev(prevNode);
            }
            currentNode = null;
            return head;
        }
    }

    public void borrarLista(DoublyLLNode head) {
        DoublyLLNode iterator = head;
        DoublyLLNode auxilaryNode;
        while (iterator != null) {
            auxilaryNode = iterator.getNext();
            iterator = null;
            iterator = auxilaryNode;
        }
        System.out.println("Se ha eliminado la lista.");
    }

    public void printLL(DoublyLLNode head) {
        if (head == null) {
            System.out.println("La lista está vacia.");
        }
        DoublyLLNode currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.getData() + " - ");
            currentNode = currentNode.getNext();
        }
        System.out.println();
    }

    public class DoublyLLNode {

        private int data;
        private DoublyLLNode prev;
        private DoublyLLNode next;

        public DoublyLLNode(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public DoublyLLNode getPrev() {
            return prev;
        }

        public void setPrev(DoublyLLNode prev) {
            this.prev = prev;
        }

        public DoublyLLNode getNext() {
            return next;
        }

        public void setNext(DoublyLLNode next) {
            this.next = next;
        }
    }
}
