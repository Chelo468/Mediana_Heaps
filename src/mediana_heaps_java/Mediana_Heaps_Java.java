/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediana_heaps_java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author mbrizuela
 */
public class Mediana_Heaps_Java {
    
    public static Heap h0;
    public static Heap h1;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        h0 = new Heap(100, true);//ascendente
        h1 = new Heap(100, false);//descendente
        int opcion = 0;
        Scanner sc = new Scanner(System.in);
        do
        {
            System.out.println("Ingrese \n1 - para agregar un número");
            System.out.println("2 - Ingresar listado completo desde archivo");
            System.out.println("3 - Ingresar listado desde archivo hasta cierto punto");
            System.out.println("4 - Calcular la mediana parcial");
            System.out.println("0 - Salir");
            opcion = sc.nextInt();
            
            switch(opcion)
            {
                case 0:
                    System.out.println("Hasta luego!!");
                    break;
                
                case 1:
                    ingresarNumero();
                    break;
                    
                
                    
                case 2:
                    ingresarDesdeArchivo(false);
                    break;
                    
                case 3:
                    ingresarDesdeArchivo(true);
                    break;
                    
                case 4:
                    float medianaParcial = calcularMediana();
                    System.out.println("La mediana parcial actual es: " + medianaParcial);
                    break;
                    
                   
            }                
        }
        while(opcion != 0);
        
    }

    private static void ingresarNumero() {
        System.out.println("Ingrese el número:");
        
        Scanner sc = new Scanner(System.in);
        
        int num = sc.nextInt();
        ingresarNumero(num);
        /*if(h0.size() == 0 && h1.size() == 0)
            h0.add(num);//Si ninguno tiene elementos agrego en el ascendente
        else
            if(h0.size() == 1 && h1.size() == 0)
                h1.add(num);//Si el ascendente tiene elementos y el descendente no, agrego en el descendente
            else
            {
                if(h0.size() == h1.size())
                {
                    //Si tienen la misma cantidad de elementos                   
                    int cimaH0 = (int)h0.get();
                    if(num < cimaH0)
                    {
                         //Si el numero ingresado es menor al menor del ascendente
                        //Lo agregamos en el descendente
                        h1.add(num);
                    }
                    else
                    {
                        //no es menor que la cima del ascendente
                        h0.add(num);
                    }
                }
                else
                {
                    //No tienen la misma cantidad de elementos
                    if(h1.size() > h0.size())
                    {
                        int cimaH1 = (int)h1.get();
                        if(num < cimaH1)
                        {
                            h1.remove();
                            h0.add(cimaH1);
                            h1.add(num);
                        }
                        else
                        {
                            h0.add(num);
                        }
                    }
                    else
                    {
                        int cimaH0 = (int)h0.get();
                        if(num < cimaH0)
                        {
                            h0.remove();
                            h1.add(cimaH0);
                            h0.add(num);
                        }
                        else
                        {
                            h1.add(num);
                        }
                    }
                }
            }*/
        
        
    }
    
    private static void ingresarNumero(int num) {
        //System.out.println("Ingrese el número:");
        
        //Scanner sc = new Scanner(System.in);
        
        //int num = sc.nextInt();
        
        if(h0.size() == 0 && h1.size() == 0)
            h0.add(num);//Si ninguno tiene elementos agrego en el ascendente
        else
            if(h0.size() == 1 && h1.size() == 0)
                h1.add(num);//Si el ascendente tiene elementos y el descendente no, agrego en el descendente
            else
            {
                if(h0.size() == h1.size())
                {
                    //Si tienen la misma cantidad de elementos                   
                    int cimaH0 = (int)h0.get();
                    if(num < cimaH0)
                    {
                         //Si el numero ingresado es menor al menor del ascendente
                        //Lo agregamos en el descendente
                        h1.add(num);
                    }
                    else
                    {
                        //no es menor que la cima del ascendente
                        h0.add(num);
                    }
                }
                else
                {
                    //No tienen la misma cantidad de elementos
                    if(h1.size() > h0.size())
                    {
                        int cimaH1 = (int)h1.get();
                        if(num < cimaH1)
                        {
                            h1.remove();
                            h0.add(cimaH1);
                            h1.add(num);
                        }
                        else
                        {
                            h0.add(num);
                        }
                    }
                    else
                    {
                        int cimaH0 = (int)h0.get();
                        if(num > cimaH0)
                        {
                            h0.remove();
                            h1.add(cimaH0);
                            h0.add(num);
                        }
                        else
                        {
                            h1.add(num);
                        }
                    }
                }
            }
        
        
    }

    private static float calcularMediana() {
        float medianaParcial = 0f;
        int h0Element;
        int h1Element;
        if(h0.size() > h1.size())
        {
            h0Element = (int)h0.get();
            medianaParcial = h0Element;
        }
        else    
        {
            if(h0.size() < h1.size())
            {
                h1Element = (int)h1.get();
                medianaParcial = h1Element;
            }
            else
            {
                h0Element = (int)h0.get();
                h1Element = (int)h1.get();
                medianaParcial = (float)(h0Element + h1Element);
                medianaParcial = (float)(medianaParcial / 2);
            }
        }
        
        return medianaParcial;
    }

    private static void ingresarDesdeArchivo(boolean conTope) {
        //System.out.println("Ingrese la dirección del archivo");
        
        //Scanner sc = new Scanner(System.in);
        
        int tope = 0;
        Scanner sc = new Scanner(System.in);
        if(conTope)
        {            
            System.out.println("Ingrese la cantidad de elementos que desea agregar desde el archivo");
            tope = sc.nextInt();
        }
        
        
        String filePath = "D:\\Chelo\\UTN\\04 - Cuarto\\DLC\\Mediana_Heaps_Java\\list[100000].txt";//sc.nextLine();
        
        System.out.println("Ingrese la ruta del archivo");
        String fileParam = sc.nextLine();
        
        if(fileParam.compareTo("") != 0)
        {
            filePath = fileParam;
        }
        
        try
        {
            String cadena;
            FileReader f = new FileReader(filePath);
            BufferedReader b = new BufferedReader(f);
            int cont = 0;
            while((cadena = b.readLine())!=null) {
                int num = Integer.parseInt(cadena);
                ingresarNumero(num);   
                cont++;
                if(conTope)
                {
                    if(cont >= tope)
                    {
                        System.out.println("Ingresados: " + cont);
                        b.close();
                        return;
                    }
                }
            }
            b.close();
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
        
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
