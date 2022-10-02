package com.CSVloader;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

public class Utils {

    public static Connection connection() throws SQLException{
        Connection connection = null;
    
        String jdbcURL = "jdbc:mysql://localhost:3306/db_test";
        String username = "springuser";
        String password = "ThePassword";
    
        connection = DriverManager.getConnection(jdbcURL, username, password);
        connection.setAutoCommit(false);

        System.out.println("conected to MySQL");
        
       
        return connection;
    }
    
    public static List<String> selectDNI(Connection connection) throws SQLException {

        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery ("select * from userdata");
        List<String> rslist = new ArrayList<String>();

            while (rs.next())
                {
                String patata = rs.getString(4);
                rslist.add(patata);
                    }
    
        return rslist;
        
        
    }
    public static void insert( String url, Connection connection) throws SQLException, IOException{
        
        String sql = "INSERT INTO userdata (Id, FirstName, LastName, DNI, Birthdate, Email) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement insertstatement = connection.prepareStatement(sql);
      
    
        BufferedReader in = new BufferedReader(new FileReader(url));
            String lineText = null;
            
            long lines = 0;
            in.readLine();
    
            while ((lineText = in.readLine()) != null) {
    
    
                String[] data = lineText.split(";");
                lines++;
                String Id = data[0];
                String FirstName = data[1];
                String LastName = data[2];
                String DNI = data[3];
                String Birthdate = data[4];
                String Email = data[5];
                
                if (!(compareDni(lineText, connection))){
                
                    insertstatement.setString(1, Id);
                    insertstatement.setString(2, FirstName);
                    insertstatement.setString(3, LastName);
                    insertstatement.setString(4, DNI);
                    insertstatement.setString(5, Birthdate);
                    insertstatement.setString(6, Email);
                    System.out.println(lineText);
                
                    insertstatement.addBatch();
                    insertstatement.executeBatch();
                }
                System.out.println("Total read rows = "+ lines);
            }
            in.close();
            //insertstatement.executeBatch();
            }
            
    
    public static boolean compareDni(String lineText, Connection connection) throws SQLException{
        
        List<String> sepList = Arrays.asList(lineText.split(";"));
        List<String> dniList = Utils.selectDNI(connection);
        
        boolean contains = false;

        if(CollectionUtils.containsAny(sepList,dniList)){
            contains=true;
        }
    
        return contains; 
}
}