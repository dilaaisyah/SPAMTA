/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ta;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Rachman Marangga
 */
public class test {
    koneksi database = new koneksi();
	
    public void coba(){
        try {
            database.con=DriverManager.getConnection(database.url+database.db, "root", "");
            Statement s = database.con.createStatement();
            String ubahtable = "SELECT * FROM index_akhir";
            ResultSet k = s.executeQuery(ubahtable);
            if(k.next()){
                int id_index = k.getInt(1);
                Statement st4 = database.con.createStatement();
                //String upid_index = "";
                for (int i = 1,j=id_index; i <= 5508; i++,j++) {
                    String upid_index = "UPDATE index_akhir SET id_index="+i+" WHERE id_index = "+j+"";
                    //st4.executeUpdate(upid_index);
                    System.out.println(upid_index);
                }
            }
        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Error : "+x,"Warning",JOptionPane.WARNING_MESSAGE);
        }
    }
	public static void main(String[] args) {
            test t = new test();
            t.coba();
//            String iddok []=new String[2];
//            String pang = "";
//            for (int i = 1; i <= 10; i++) {
//                int Ra = (int) Math.floor(Math.random()*301);
//            String Ca = String.valueOf(Ra);
//            String id = ((Ca+"").length()==1?("0"+Ca):Ca);
//            iddok[1]=", D"+id;
//            pang=pang+iddok[1];
//            }
//            System.out.println(pang);
//            int i,j;
//            for (i = 2,j=223119; i <= 300; i++,j++) {
//                String a = i<10?"0"+i:i+"";
//                int b=i-1;
//                System.out.println("UPDATE `maman`.`kmcentroid` SET `id_index` = '"+i+"' WHERE `kmcentroid`.`id_centroid_baru` = "+i+";");
//            }
        }
}