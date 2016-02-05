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
public class TF_IDF {
    koneksi database = new koneksi();
    public TF_IDF(){
//        HapusTFIDF();
//        TF();
//        IDF();
//        Normalisasi();
    }
        
    public void TF(){
        try {
            database.con=DriverManager.getConnection(database.url+database.db, "root", "");
            Statement st = database.con.createStatement();
            String sql ="delete from file_index";
            st.executeUpdate(sql);
            st.close();
            database.con.close();
        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Error : "+x,"Warning",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void IDF(){
        try {
            database.con=DriverManager.getConnection(database.url+database.db, "root", "");
            Statement st = database.con.createStatement();
            String sql ="delete from idf";
            st.executeUpdate(sql);
            st.close();
            database.con.close();
        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Error : "+x,"Warning",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void Normalisasi(){
        try {
            database.con=DriverManager.getConnection(database.url+database.db, "root", "");
            Statement st = database.con.createStatement();
            String sql ="delete from index_akhir";
            st.executeUpdate(sql);
            st.close();
            database.con.close();
        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Error : "+x,"Warning",JOptionPane.WARNING_MESSAGE);
        }
    }
}
