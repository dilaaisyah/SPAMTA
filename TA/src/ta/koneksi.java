/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ta;

import java.sql.Connection;

/**
 *
 * @author Rachman Marangga
 */
public class koneksi {
    Connection con;
    String url,db,driver,user;
    
    koneksi(){
        con=null;
        url="jdbc:mysql://localhost:3306/";
        db="maman";
        driver="com.mysql.jdbc.Driver";
        try{
            Class.forName(driver);
        }catch(ClassNotFoundException cnfe){
            System.err.println("Class driver tidak ada : "+cnfe.getMessage());
        }
    }
}
