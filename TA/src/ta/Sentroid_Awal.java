/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ta;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Rachman
 */
public class Sentroid_Awal {
    koneksi database = new koneksi();
    
    public Sentroid_Awal(){
        UpdateIdIndex();
        RandomCendtroid();
    }
    
    public void UpdateIdIndex(){
        try {
            database.con=DriverManager.getConnection(database.url+database.db, "root", "");
            Statement s = database.con.createStatement();
            String ubahtable = "SELECT * FROM index_akhir";
            ResultSet k = s.executeQuery(ubahtable);
            if(k.next()){
                int id_index = k.getInt(1);
                Statement st4 = database.con.createStatement();
                for (int i = 1,j=id_index; i <= 5508; i++,j++) {
                    String upid_index = "UPDATE index_akhir SET id_index="+i+" WHERE id_index = "+j+"";
                    st4.executeUpdate(upid_index);
                    System.out.println(upid_index);
                }
            }
        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Error : "+x,"Warning",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void RandomCendtroid(){      
        try {
            //Random Sentroid
            int randomsentroid = 0;
            String arr_sent []=new String[2];
            String pangil_sent = "";
            database.con=DriverManager.getConnection(database.url+database.db, "root", "");
            for (int i = 1; i <= 10; i++) {
                randomsentroid = (int) Math.floor(Math.random()*301);
                String casting = String.valueOf(randomsentroid);
                String pisah = ((casting+"").length()==1?("0"+casting):casting);
                arr_sent[1]=", D"+pisah;
                pangil_sent=pangil_sent+arr_sent[1];  
                Statement centabc = database.con.createStatement();
                String insertcentabc = "UPDATE abckm SET C"+i+"='"+randomsentroid+"' WHERE id_cabckm=1";
                centabc.executeUpdate(insertcentabc);
            }
            //atur sentroid k-means
            Statement st = database.con.createStatement();
            String sql="SELECT id_index "+pangil_sent+" FROM index_akhir";
            ResultSet klc = st.executeQuery(sql);
            double a=0,b=0,c=0,d=0,e=0,f=0,g=0,h=0,i=0,j=0;
            int id=0;
            while(klc.next()){
                id=klc.getInt(1);
                a=klc.getDouble(2);
                b=klc.getDouble(3);
                c=klc.getDouble(4);
                d=klc.getDouble(5);
                e=klc.getDouble(6);
                f=klc.getDouble(7);
                g=klc.getDouble(8);
                h=klc.getDouble(9);
                i=klc.getDouble(10);
                j=klc.getDouble(11);
                Statement st1 = database.con.createStatement();
                String insert = "UPDATE index_akhir SET km_c1='"+a+"', km_c2='"+b+"', km_c3='"+c+"', km_c4='"+d+"', km_c5='"+e+"',"
                                + " km_c6='"+f+"', km_c7='"+g+"', km_c8='"+h+"', km_c9='"+i+"', km_c10='"+j+"' WHERE id_index="+id+"";
                st1.executeUpdate(insert);
            }
            
            Statement stl = database.con.createStatement();
            String lama = "SELECT * from kmcentroid";
            ResultSet kl = stl.executeQuery(lama);
            while(kl.next()){
                int id_centroid = kl.getInt(1);
                Statement stlama = database.con.createStatement();
                String ubah = "UPDATE kmcentroid SET kmb_c1=0, kmb_c2=0, kmb_c3=0, kmb_c4=0, kmb_c5=0, kmb_c6=0, kmb_c7=0, kmb_c8=0, kmb_c9=0, kmb_c10=0 WHERE id_centroid_lama = "+id_centroid+"";
                stlama.executeUpdate(ubah);
            }
            
            //Info
            JOptionPane.showMessageDialog(null, "Sentroid Awal Berhasil Ditentukan!","Information",JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Error : "+x,"Warning",JOptionPane.WARNING_MESSAGE);
        }
    }
}
