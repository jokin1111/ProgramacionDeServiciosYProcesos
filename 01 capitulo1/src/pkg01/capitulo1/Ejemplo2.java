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
class Ejemplo2_HilosThread {
    static int array1[] = new int[1000];
    static int array2[] = new int[1000];
    public static void main(String args[]) {
        try {
               long tiempoInicial;
               for (int i = 0; i < array1.length; i++) {
                   array1[i] = (int) (Math.random() * 10000);
               }
               for (int i = 0; i < array2.length; i++) {
                   array2[i] = (int) (Math.random() * 10000);
               }
               tiempoInicial = System.currentTimeMillis();
               Hebra h1 = new Hebra(array1);
               Hebra h2 = new Hebra(array2);
               h1.start();
               h2.start();
               h1.join();
               h2.join();
               System.out.println("Tiempo de ejecución: " + (System.currentTimeMillis() - tiempoInicial) + " ms");
           } catch (InterruptedException ex) {
           }    }
}


