/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ta;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Man
 */
public class Pengujian {
    koneksi database = new koneksi();
    public Pengujian(){
        
    }
    
    public void Precision(){
        DefaultCategoryDataset dcd = new DefaultCategoryDataset();
        for (int km = 5; km >=1; km--) {
            try {
                database.con=DriverManager.getConnection(database.url+database.db, "root", "");
                Statement st = database.con.createStatement();
                String sql ="SELECT * FROM pengujian_precision ORDER BY id_pengujian_precision DESC limit "+km+"";
                ResultSet kl = st.executeQuery(sql);
                double kmeans [] = new double[2];
                double abckm [] = new double[2];
                while(kl.next()){
                    kmeans [1] = kl.getDouble(2);
                    abckm [1] = kl.getDouble(3);                           
                }
                String ubah =String.valueOf(km);
                dcd.setValue(kmeans[1], "K-Means",ubah);//Value,RowKey/ColumnKey
                dcd.setValue(abckm[1], "ABC-KM",ubah);

                System.out.println(kmeans[1]+" | "+abckm[1]);
                st.close();
                database.con.close();
            } catch (Exception x) {
                JOptionPane.showMessageDialog(null, "Error : "+x,"Warning",JOptionPane.WARNING_MESSAGE);
            }
        }
        JFreeChart freeChart = ChartFactory.createBarChart("Pengujian Precision","Pengujian Ke","Hasil Precision(Dalam Persen / %)", dcd, PlotOrientation.VERTICAL,true, true,true); //String arg0,String arg1,String arg2,Category Datasheet,Plot Orientation,boolean arg4,boolean arg5,boolean arg6
        ChartFrame cf = new ChartFrame("Pengujian Precision",freeChart);
        cf.setSize(800,500);
        cf.setVisible(true);
        cf.setLocationRelativeTo(null);
    }
    
    public void Recall(){
        DefaultCategoryDataset dcd = new DefaultCategoryDataset();
        for (int km = 5; km >=1; km--) {
            try {
                database.con=DriverManager.getConnection(database.url+database.db, "root", "");
                Statement st = database.con.createStatement();
                String sql ="SELECT * FROM pengujian_recall ORDER BY id_pengujian_recall DESC limit "+km+"";
                ResultSet kl = st.executeQuery(sql);
                double kmeans [] = new double[2];
                double abckm [] = new double[2];
                while(kl.next()){
                    kmeans [1] = kl.getDouble(2);
                    abckm [1] = kl.getDouble(3);                           
                }
                String ubah =String.valueOf(km);
                dcd.setValue(kmeans[1], "K-Means",ubah);//Value,RowKey/ColumnKey
                dcd.setValue(abckm[1], "ABC-KM",ubah);

                System.out.println(kmeans[1]+" | "+abckm[1]);
                st.close();
                database.con.close();
            } catch (Exception x) {
                JOptionPane.showMessageDialog(null, "Error : "+x,"Warning",JOptionPane.WARNING_MESSAGE);
            }
        }
        JFreeChart freeChart = ChartFactory.createBarChart("Pengujian Recall","Pengujian Ke","Hasil Recall(Dalam Persen / %)", dcd, PlotOrientation.VERTICAL,true, true,true); //String arg0,String arg1,String arg2,Category Datasheet,Plot Orientation,boolean arg4,boolean arg5,boolean arg6
        ChartFrame cf = new ChartFrame("Pengujian Recall",freeChart);
        cf.setSize(800,500);
        cf.setVisible(true);
        cf.setLocationRelativeTo(null);
    }
    
    public void FMeasure(){
        DefaultCategoryDataset dcd = new DefaultCategoryDataset();
        for (int km = 5; km >=1; km--) {
            try {
                database.con=DriverManager.getConnection(database.url+database.db, "root", "");
                Statement st = database.con.createStatement();
                String sql ="SELECT * FROM pengujian_fmeasure ORDER BY id_pengujian_fmeasure DESC limit "+km+"";
                ResultSet kl = st.executeQuery(sql);
                double kmeans [] = new double[2];
                double abckm [] = new double[2];
                while(kl.next()){
                    kmeans [1] = kl.getDouble(2);
                    abckm [1] = kl.getDouble(3);                           
                }
                String ubah =String.valueOf(km);
                dcd.setValue(kmeans[1], "K-Means",ubah);
                dcd.setValue(abckm[1], "ABC-KM",ubah);

                System.out.println(kmeans[1]+" | "+abckm[1]);
                st.close();
                database.con.close();
            } catch (Exception x) {
                JOptionPane.showMessageDialog(null, "Error : "+x,"Warning",JOptionPane.WARNING_MESSAGE);
            }
        }
        JFreeChart freeChart = ChartFactory.createBarChart("Pengujian F-Measure","Pengujian Ke","Hasil F-Measure(Dalam Persen / %)", dcd, PlotOrientation.VERTICAL,true, true,true);
        ChartFrame cf = new ChartFrame("Pengujian F-Measure",freeChart);
        cf.setSize(800,500);
        cf.setVisible(true);
        cf.setLocationRelativeTo(null);
    }
    
    public void Waktu(){
        DefaultCategoryDataset dcd = new DefaultCategoryDataset();
        for (int km = 5; km >=1; km--) {
            try {
                database.con=DriverManager.getConnection(database.url+database.db, "root", "");
                Statement st = database.con.createStatement();
                String sql ="SELECT * FROM pengujian_waktu ORDER BY id_pengujian_waktu DESC limit "+km+"";
                ResultSet kl = st.executeQuery(sql);
                double kmeans [] = new double[2];
                double abckm [] = new double[2];
                while(kl.next()){
                    kmeans [1] = kl.getDouble(2);
                    abckm [1] = kl.getDouble(3);                           
                }
                String ubah =String.valueOf(km);
                dcd.setValue(kmeans[1], "K-Means",ubah);
                dcd.setValue(abckm[1], "ABC-KM",ubah);

                System.out.println(kmeans[1]+" | "+abckm[1]);
                st.close();
                database.con.close();
            } catch (Exception x) {
                JOptionPane.showMessageDialog(null, "Error : "+x,"Warning",JOptionPane.WARNING_MESSAGE);
            }
        }
        JFreeChart freeChart = ChartFactory.createBarChart("Pengujian Waktu Komputasi","Pengujian Ke","Hasil Waktu(Dalam Detik)", dcd, PlotOrientation.VERTICAL,true, true,true);
        ChartFrame cf = new ChartFrame("Pengujian Waktu Komputasi",freeChart);
        cf.setSize(800,500);
        cf.setVisible(true);
        cf.setLocationRelativeTo(null);
    }
}
