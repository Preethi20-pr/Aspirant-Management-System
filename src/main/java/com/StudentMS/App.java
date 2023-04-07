package com.StudentMS;

import java.sql.*;
import java.util.Scanner;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	Scanner scan=new Scanner(System.in);
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/aspirantms";
        String username="root";
        String password="72041999";
        Connection bs=DriverManager.getConnection(url,username,password);
        System.out.println("*******adpirant Data********");
        System.out.println("Enter aspirant id ");
        int aid=scan.nextInt();
        System.out.println("Enter aspirant name");
        scan.nextLine();
        String aname=scan.nextLine();    
        System.out.println("Enter aspirant class");
        int aclass=scan.nextInt();
        System.out.println("Enter aspirant grade");
        scan.nextLine();
        String agrade=scan.nextLine();
        String query="insert into aspirant values(?,?,?,?)";
        PreparedStatement pst=bs.prepareStatement(query);
        pst.setInt(1, aid);
        pst.setString(2, aname);
        pst.setInt(3, aclass);
        pst.setString(4, agrade);
        int count=pst.executeUpdate();
        System.out.println(count+" row(s) effected");
        bs.close();
        scan.close();
    }
}