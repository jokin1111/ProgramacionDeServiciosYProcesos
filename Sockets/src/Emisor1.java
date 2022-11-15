/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joaquin.antequera
 */
public class Emisor1 {

    static int puertoAlQueEnvia = 5000;
    static int puertoPorElQueRecibe = 6500;

    public static void main(String[] args) {

        EnviaObjetos.Envia("Hola desde el emisor1", "localhost", puertoAlQueEnvia);

        System.out.println(RecibeObjetos.recibe(puertoPorElQueRecibe));

        EnviaObjetos.Envia("2º mensaje desde el emisor1", "localhost", puertoAlQueEnvia);

        System.out.println(RecibeObjetos.recibe(puertoPorElQueRecibe));

    }
}

