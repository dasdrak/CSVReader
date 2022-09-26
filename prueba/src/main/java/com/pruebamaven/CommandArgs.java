package com.pruebamaven;


import java.io.*;
import java.net.*;


import com.opencsv.exceptions.CsvException;

public class CommandArgs{
	protected String url;

    /**
	 * 
	 * @param args the command line arguments
     * @throws IOException
     * @throws FileNotFoundException
     * @throws CsvException
	 */
    public static void main(String[] args) throws FileNotFoundException, IOException, CsvException {
   
        Console console = System.console();
        String fileRoute = console.readLine("Por favor introduzca la URL: ");

        

        if (fileRoute.contains(".csv")||fileRoute.startsWith("http")||fileRoute.startsWith("www")){
            System.out.println("La URL introducida es correcta");
            System.out.println("cargando "+fileRoute);


            if (fileRoute.startsWith("http")||fileRoute.startsWith("www")){
                URL oracle = new URL(fileRoute);
                BufferedReader in = new BufferedReader(
                new InputStreamReader(oracle.openStream()));

            String inputLine;
                while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
            in.close();
            }
            if (fileRoute.contains(".csv")){
                URL oracle = new URL("file:///"+fileRoute);
                BufferedReader in = new BufferedReader(
                new InputStreamReader(oracle.openStream()));

            String inputLine;
                while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
            in.close();
            }  
        }
        else 
            System.out.println("La URL introducida no es correcta, asegurate de que la extensión sea .csv");

        
       // if (sc != null)
         //   sc.close();
    }
    public String GetUrl(){
        return url;
    };

};