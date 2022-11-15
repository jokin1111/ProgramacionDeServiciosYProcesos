/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg01.capitulo1;

/**
 *
 * @author joaquin.antequera
 */
public class Hebra extends Thread {
    int array[];
    Hebra(int array[]) {
        this.array = array;
    }
    public static void burbuja(int[] array) {
        int i, j, aux;
        for (i = 0; i < array.length - 1; i++) {
            for (j = 0; j < array.length - i - 1; j++) {
                if (array[j + 1] < array[j]) {
                    aux = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = aux;
                }
            }
        }
        for (int valor : array) {
            System.out.print(valor + "\t");
        }
        System.out.println("");
        System.out.println("");
    }
    public void run() {
        burbuja(array);
    }
}

