
package javaapplication17;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joaquin.antequera
 */
public class PrimeraPracticaAccesoaDatos {
    
    public static void Encriptar(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la ruta del fichero");
        String reg = sc.nextLine();
        File f = new File(reg);
        
        if(f.exists()){
            String entrada = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"; 
            String salida = "jklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghi567890123";
            System.out.println("Introduce la contraseña");
            
            try {
                BufferedWriter escribir = new BufferedWriter(new FileWriter(f));
                escribir.write("Contrasenia: " + sc.nextLine());
                escribir.close();
                System.out.println("Introduce el texto a encriptar");
                String texto = sc.nextLine();
                BufferedWriter escribirTexto = new BufferedWriter(new FileWriter("C:\\dam\\AAD\\Encriptado.txt"));
                String texto2 = "";
                for (int i = 0; i < texto.length(); i++) {
                    if (texto.charAt(i) == ' '){
                        texto2 += " ";
                    }
                    else{
                        int x = entrada.indexOf(texto.charAt(i));
                        salida.charAt(x);
                        texto2 += salida.charAt(x);
                    } 
                        
                }
                
                escribirTexto.write(texto2);
                
                escribirTexto.close();
            } catch (IOException ex) {
                
            }
        }
        else{
            System.out.println("No existe el fichero");
        }
            
    }
    
    public static void Desencriptar(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la ruta del fichero");
        
        String reg = sc.nextLine();
        File f = new File(reg);
        
        if(f.exists()){
            
        }
        else{
            System.out.println("No existe el fichero");
        }
    }
    
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribre 1 para encriptar un fichero");
        System.out.println("Escribre 2 para desencriptar el fichero");
        System.out.println("Escribre 3 para salir");
        
        int reg = sc.nextInt();
        
        for(;;){
            
            if (reg == 1){
                Encriptar();
                break;
            }
            else if (reg == 2){
                Desencriptar();
                break;
            }else if (reg == 3){
                break;
            }else{
                System.out.println("Introduce 1, 2 o 3 por favor");
                reg = sc.nextInt();
            }
                
        }      
            
    }
    
}
