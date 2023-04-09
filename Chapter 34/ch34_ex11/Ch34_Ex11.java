package ch34_ex11;
/*
Name: Phong Tran
Date: 10/7/22
Project: Chapter 34_Ex11
Description: This program read data from a url and store them into a mysql database table
 */
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Ch34_Ex11 {
    static Connection connection;
    static PreparedStatement stmt;
    public static void main(String[] args) {
        initializeDB();
        //loop to get data from 2001 to 2010
        for(int year = 2001;year < 2010;year++){
            try{
                String urlString = "https://liveexample.pearsoncmg.com/data/babynamesranking" + year + ".txt";
                URL url = new URL(urlString);
                //scan url for data
                Scanner scan = new Scanner(url.openStream());
                //store data from url into a list
                while (scan.hasNext()){
                    ArrayList<String> list = new ArrayList<>();
                    for (int i = 0;i < 5;i++){
                        list.add(i,scan.next());
                    }
                    //insert year,name,gender,and count into table
                    insertBoy(year,list.get(1),list.get(2));
                    insertGirl(year,list.get(3),list.get(4));
                }
            }
            catch(MalformedURLException ex){
                System.out.println("Invalid URL");
            }
            catch(IOException ex){
                System.out.print("No file");
            }
        }
    }//insert boy into table
    private static void insertBoy(int year,String name,String count){
        String gender = "M";
        try{
            //create query string with placeholders
            String query = "INSERT INTO Babyname values(?,?,?,?)";
            stmt = connection.prepareStatement(query);
            //place values into table
            stmt.setInt(1, year);
            stmt.setString(2, name);
            stmt.setString(3, gender);
            stmt.setInt(4, Integer.parseInt(count));
            //execute query
            stmt.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    //insert girl into table
    private static void insertGirl(int year,String name,String count){
        String gender = "F";
        try{
            //create query string with placeholders
            String query = "INSERT INTO Babyname values(?,?,?,?)";
            stmt = connection.prepareStatement(query);
            //place values into table
            stmt.setInt(1, year);
            stmt.setString(2, name);
            stmt.setString(3, gender);
            stmt.setInt(4, Integer.parseInt(count));
            //execute query
            stmt.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    //load driver and connect to database
    private static void initializeDB(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.print("Driver loaded");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","password");
            System.out.print("Database Connected");
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
