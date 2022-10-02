package com.CSVloader;


import java.io.*;
import java.sql.*;





public class CSVRead{
	protected String url;


    /**
	 * 
	 * @param args the command line arguments
     * @throws IOException
     * @throws SQLException
     * @throws FileNotFoundException
     * 
	 */
    public static void main(String[] args) throws IOException, SQLException {
        Console console = System.console();
        Connection connection = Utils.connection();
        String url = System.getProperty("URL");

        

        if(url != null) {
            urlrun(url, connection);
           }
        else {
            System.out.println("The URL provided is not valid");
            url = console.readLine("Please introduce a URL: ");
            urlrun(url, connection);
    
}
}
public static void urlrun(String url, Connection connection) throws SQLException, IOException{

if (url.contains(".csv")|| url.startsWith("http")|| url.startsWith("www")){
    System.out.println("The url is correct");
    System.out.println("..... Cargando: "+url+" .......");
    Utils.insert(url, connection);
    
    connection.commit();
    connection.close();

           
}
else{
System.out.println("The url is not correct");
}
}
}