/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ta;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rachman
 */
public class Text_Mining {
    koneksi database = new koneksi();
    public Text_Mining(){
//        HapusTextMining();
//        CaseToken();
//        Filtering();
//        Stemming();       
    }
    
    public void HapusTextMining(){
        try {
            database.con=DriverManager.getConnection(database.url+database.db, "root", "");
            Statement st = database.con.createStatement();
            String sql ="delete from simpan_kata";
            st.executeUpdate(sql);
            st.close();
            database.con.close();
        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Error : "+x,"Warning",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void CaseToken(){
        try {
            database.con=DriverManager.getConnection(database.url+database.db, "root", "");
            Statement st = database.con.createStatement();
            String sql ="SELECT id_data_buku, judul_buku, isi_buku FROM data_buku";
            ResultSet kl = st.executeQuery(sql);
            while(kl.next()){
                String a = kl.getString(1);
                String b = kl.getString(2);
                String c = kl.getString(3);
                StringTokenizer objectToken = new StringTokenizer(b.toLowerCase()+"\n"+c.toLowerCase(),",.!@#$%^&*(/)_+?<>â€œ[]˜ ™â€{};:|\\\\`\\\"”“‘’'~-= \\\n \\\t \\\r 1234567890 \\ ");                        
                while(objectToken.hasMoreTokens()){
                    Statement st2 = database.con.createStatement();
                    String sqlinsert = "INSERT INTO simpan_kata (kata,bobot,id_data_buku) values ('"+objectToken.nextToken()+"',1,'"+a+"')";
                    st2.executeUpdate(sqlinsert);
                    System.out.println(sqlinsert);
                }
            }
            st.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Case Folding & Tokenizing!","Information",JOptionPane.INFORMATION_MESSAGE);
            database.con.close();
        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Error : "+x,"Warning",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void Filtering(){
        try {
            database.con=DriverManager.getConnection(database.url+database.db, "root", "");
            Statement st = database.con.createStatement();
            String sql ="SELECT * FROM tb_stoplist";
            ResultSet kl = st.executeQuery(sql);
            String stop = "";
            while(kl.next()){
                stop = kl.getString(2);
                Statement st2 = database.con.createStatement();
                String sqldelete = "DELETE FROM simpan_kata WHERE kata='"+stop+"'";
                st2.executeUpdate(sqldelete);
                System.out.println(stop);
           }
           st.close();
           JOptionPane.showMessageDialog(null, "Kata Berhasil Di Filter !","Information",JOptionPane.INFORMATION_MESSAGE);
           database.con.close();
       } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Error : "+x,"Warning",JOptionPane.WARNING_MESSAGE);
       }
    }
    
    public void Stemming(){
        //Stemming
        try {
            database.con=DriverManager.getConnection(database.url+database.db, "root", "");
            Statement st = database.con.createStatement();
            String sql = "SELECT * from simpan_kata";
            ResultSet kl = st.executeQuery(sql);
            while(kl.next()){
                ecsstemmer a = new ecsstemmer();
                String id = kl.getString(1);
                String stemm = kl.getString(2);
                Statement st2 = database.con.createStatement();
                String sqlupdate = "update simpan_kata set kata = '"+a.Enhanced_CS(stemm)+"' where id_temp_kata='"+id+"'"; 
                System.out.println(a.Enhanced_CS(stemm));
                st2.executeUpdate(sqlupdate);
            }
            st.close();
            JOptionPane.showMessageDialog(null, "Kata Berhasil Di Stemming !","Information",JOptionPane.INFORMATION_MESSAGE);
            database.con.close();
        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Error : "+x,"Warning",JOptionPane.WARNING_MESSAGE);
        }
    }
}
