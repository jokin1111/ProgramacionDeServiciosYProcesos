/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joaquin.antequera
 */
public class Emisor2 {
    
    static int puertoAlQueEnvia = 6500;
    static int puertoPorElQueRecibe = 5000;

    public static void main(String[] args) {

        System.out.println(RecibeObjetos.recibe(puertoPorElQueRecibe));

        EnviaObjetos.Envia("Mensaje desde el emisor2", "localhost", puertoAlQueEnvia);

        System.out.println(RecibeObjetos.recibe(puertoPorElQueRecibe));

        EnviaObjetos.Envia("Otro mensaje desde el emisor2", "localhost", puertoAlQueEnvia);
    }
}
