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
public class K_Means {
    koneksi database = new koneksi();
    int K = 10;
    
    public K_Means(){
        Rekursif();
    }
    
    public void Euclidean(){
        try {    
            database.con=DriverManager.getConnection(database.url+database.db, "root", "");
            Statement st = database.con.createStatement();
                    String sql ="SELECT * FROM km";
                    ResultSet kl = st.executeQuery(sql);
                    int centroid [] = new int[11];
                    while(kl.next()){                
                        for (int l = 1; l < centroid.length; l++) {
                            centroid[l] = kl.getInt(l+1);
                        }   
                    }

                    Statement st1 = database.con.createStatement();
                    String select = "SELECT * FROM index_akhir";
                    ResultSet kl1 = st1.executeQuery(select);

                    double ind_akhir [][] = new double[11][301];
                    double duadimensi [][]=new double[ind_akhir[1].length][];
                    while (kl1.next()) {                        
                        for (int j = 1, cc = 1; j < ind_akhir.length; j++, cc++) {
                            double xx = kl1.getDouble(centroid[cc]+2);
                            for (int i = 1; i < ind_akhir[j].length; i++) {
                                ind_akhir[j][i] += Math.pow(xx-kl1.getDouble(i+2), 2.0);
                            }
                        }
                    }
                    for (int row = 1; row < ind_akhir[1].length; row++){
                        duadimensi[row]=new double[ind_akhir.length];
                    } 
                    for (int row = 1; row < ind_akhir.length; row++){
                        for (int col = 1; col < ind_akhir[row].length; col++){
                            duadimensi[col][row]=ind_akhir[row][col];
                        }
                    }
                    for (int row = 1; row < duadimensi.length; row++){
                        //System.out.println(Arrays.toString(duadimensi[row]));
                        double a = Math.min(Math.sqrt(duadimensi[row][1]), Math.sqrt(duadimensi[row][2]));
                        double b = Math.min(Math.sqrt(duadimensi[row][3]), Math.sqrt(duadimensi[row][4]));
                        double c = Math.min(Math.sqrt(duadimensi[row][5]), Math.sqrt(duadimensi[row][6]));
                        double d = Math.min(Math.sqrt(duadimensi[row][7]), Math.sqrt(duadimensi[row][8]));
                        double e = Math.min(Math.sqrt(duadimensi[row][9]), Math.sqrt(duadimensi[row][10]));
                        double f = Math.min(a, b);
                        double g = Math.min(c, d);
                        double h = Math.min(e, f);
                        double i = Math.min(g, h);
                        Statement st2 = database.con.createStatement();
                        String upjarak = "UPDATE JARAK SET C1="+Math.sqrt(duadimensi[row][1])+","
                                + "C2="+Math.sqrt(duadimensi[row][2])+",C3="+Math.sqrt(duadimensi[row][3])+","
                                + "C4="+Math.sqrt(duadimensi[row][4])+",C5="+Math.sqrt(duadimensi[row][5])+","
                                + "C6="+Math.sqrt(duadimensi[row][6])+",C7="+Math.sqrt(duadimensi[row][7])+","
                                + "C8="+Math.sqrt(duadimensi[row][8])+",C9="+Math.sqrt(duadimensi[row][9])+","
                                + "C10="+Math.sqrt(duadimensi[row][10])+",jarak_terpendek="+i+" WHERE "
                                + "id_jarak="+row+"";
                        st2.executeUpdate(upjarak);
                    }
        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Error : "+x,"Warning",JOptionPane.WARNING_MESSAGE);    
        }
    }
    
    public void Klaster(){
        try {
            database.con=DriverManager.getConnection(database.url+database.db, "root", "");
            Statement s = database.con.createStatement();
                    String ubahtable = "SELECT * FROM index_akhir";
                    ResultSet k = s.executeQuery(ubahtable);
                    while(k.next()){
                        int id_c_baru = k.getInt(1);
                        double c_baru1=k.getDouble(304);
                        double c_baru2=k.getDouble(305);
                        double c_baru3=k.getDouble(306);
                        double c_baru4=k.getDouble(307);
                        double c_baru5=k.getDouble(308);
                        double c_baru6=k.getDouble(309);
                        double c_baru7=k.getDouble(310);
                        double c_baru8=k.getDouble(311);
                        double c_baru9=k.getDouble(312);
                        double c_baru10=k.getDouble(313);
                        Statement st4 = database.con.createStatement();
                        String uptable = "UPDATE kmcentroid SET kmb_c1='"+c_baru1+"', kmb_c2='"+c_baru2+"', kmb_c3='"+c_baru3+"', kmb_c4='"+c_baru4+"', kmb_c5='"+c_baru5+"', kmb_c6='"+c_baru6+"', kmb_c7='"+c_baru7+"', kmb_c8='"+c_baru8+"', kmb_c9='"+c_baru9+"', kmb_c10='"+c_baru10+"' WHERE id_centroid_lama = "+id_c_baru+"";
                        st4.executeUpdate(uptable);
                    }
                    
                    Statement st3 = database.con.createStatement();
                    String selectjarak = "SELECT * FROM jarak";
                    ResultSet kl3 = st3.executeQuery(selectjarak);
                    while(kl3.next()){
                        int klas = 0;
                        int id_jarak = kl3.getInt(1);
                        double c = kl3.getDouble(2);
                        double c2 = kl3.getDouble(3);
                        double c3 = kl3.getDouble(4);
                        double c4 = kl3.getDouble(5);
                        double c5 = kl3.getDouble(6);
                        double c6 = kl3.getDouble(7);
                        double c7 = kl3.getDouble(8);
                        double c8 = kl3.getDouble(9);
                        double c9 = kl3.getDouble(10);
                        double c0 = kl3.getDouble(11);
                        double jarak = kl3.getDouble(12);
                        if(c==jarak){
                            klas=1;
                        }else if(c2==jarak){
                            klas=2;
                        }else if(c3==jarak){
                            klas=3;
                        }else if(c4==jarak){
                            klas=4;
                        }else if(c5==jarak){
                            klas=5;
                        }else if(c6==jarak){
                            klas=6;
                        }else if(c7==jarak){
                            klas=7;
                        }else if(c8==jarak){
                            klas=8;
                        }else if(c9==jarak){
                            klas=9;
                        }else if(c0==jarak){
                            klas=10;
                        }else{
                            klas = 0;
                        }
                        Statement st4 = database.con.createStatement();
                        String upklaster = "UPDATE kmklaster_baru SET klaster="+klas+" WHERE ID_KLASTER = "+id_jarak+"";
                        st4.executeUpdate(upklaster);
                    }
        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Error : "+x,"Warning",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void CentroidBaru(){
        try {
            database.con=DriverManager.getConnection(database.url+database.db, "root", "");
                for (int centroidbaru = 1; centroidbaru <= K; centroidbaru++) {
                    int id_klaster = 0, jmlklaster_sementara=0;
                    String dokumen[] = new String[2];
                    String panggil = "";
                    double titikpusat = 0, simpantitikpusat=0;
                    Statement sc = database.con.createStatement();
                    String sltc = "SELECT count(klaster) FROM kmklaster_baru where klaster="+centroidbaru+"";
                    ResultSet kl1c = sc.executeQuery(sltc);
                    while(kl1c.next()){
                        int ccount=kl1c.getInt(1);
                        jmlklaster_sementara=ccount;
                    }
                    Statement st5 = database.con.createStatement();
                    String selectc = "SELECT id_klaster FROM kmklaster_baru where klaster="+centroidbaru+"";
                    ResultSet kl5 = st5.executeQuery(selectc);
                    while(kl5.next()){
                        id_klaster = kl5.getInt(1);
                        String panggildokumen = id_klaster<10?"0"+id_klaster:id_klaster+"";
                        dokumen[1]=", D"+panggildokumen;
                        panggil=panggil+dokumen[1];
                    }
                    Statement stc = database.con.createStatement();
                    String selectstc = "SELECT id_index"+panggil+" FROM index_akhir";
                    ResultSet klc = stc.executeQuery(selectstc);
                    double panggil_arr [][]=new double[2][jmlklaster_sementara+1];
                    while(klc.next()){
                        int id_titikpusat = klc.getInt(1);
                        for (int i = 1; i < panggil_arr.length; i++) {
                            for (int j = 1; j < panggil_arr[i].length; j++) {
                                panggil_arr [i][j] = klc.getDouble(j+1);
                                titikpusat += panggil_arr[i][j];
                            }
                            titikpusat=titikpusat/jmlklaster_sementara;
                        }
                        simpantitikpusat=titikpusat;
                        titikpusat=0;
                    Statement stcnew = database.con.createStatement();
                    String upcentroid1 = "UPDATE index_akhir SET km_c"+centroidbaru+" = "+simpantitikpusat+" WHERE id_index = "+id_titikpusat+"";
                    stcnew.executeUpdate(upcentroid1);
                }
            }
        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Error : "+x,"Warning",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void Rekursif(){
        try {
            database.con=DriverManager.getConnection(database.url+database.db, "root", "");
            Statement stat = database.con.createStatement();
            String selectbanding = "SELECT sum(kmb_c1), sum(km_c1), sum(kmb_c2), sum(km_c2), sum(kmb_c3), sum(km_c3), sum(kmb_c4), sum(km_c4), sum(kmb_c5), sum(km_c5), sum(kmb_c6), sum(km_c6), sum(kmb_c7), sum(km_c7), sum(kmb_c8), sum(km_c8), sum(kmb_c9), sum(km_c9), sum(kmb_c10), sum(km_c10) FROM kmcentroid ia, index_akhir ku WHERE ia.id_index = ku.id_index";
            ResultSet resul = stat.executeQuery(selectbanding);
            while(resul.next()){
                double c_lama1 = resul.getDouble(1);
                double c_baru1 = resul.getDouble(2);
                double c_lama2 = resul.getDouble(3);
                double c_baru2 = resul.getDouble(4);
                double c_lama3 = resul.getDouble(5);
                double c_baru3 = resul.getDouble(6);
                double c_lama4 = resul.getDouble(7);
                double c_baru4 = resul.getDouble(8);
                double c_lama5 = resul.getDouble(9);
                double c_baru5 = resul.getDouble(10);
                double c_lama6 = resul.getDouble(11);
                double c_baru6 = resul.getDouble(12);
                double c_lama7 = resul.getDouble(13);
                double c_baru7 = resul.getDouble(14);
                double c_lama8 = resul.getDouble(15);
                double c_baru8 = resul.getDouble(16);
                double c_lama9 = resul.getDouble(17);
                double c_baru9 = resul.getDouble(18);
                double c_lama10 = resul.getDouble(19);
                double c_baru10 = resul.getDouble(20);
                if(c_lama1==c_baru1 && c_lama2==c_baru2 && c_lama3==c_baru3 && c_lama4==c_baru4 && c_lama5==c_baru5 && c_lama6==c_baru6 && c_lama7==c_baru7 && c_lama8==c_baru8 && c_lama9==c_baru9 && c_lama10==c_baru10){
                    JOptionPane.showMessageDialog(null, "Sentroid Sama,\nAlgoritma Berhenti!","Information",JOptionPane.INFORMATION_MESSAGE);
                }else{
                    System.out.println("Sentroid Berbeda, Lakukan Klasterisasi");
                    Euclidean();
                    Klaster();
                    CentroidBaru();
                    Rekursif();
                }
            }
        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Error : "+x,"Warning",JOptionPane.WARNING_MESSAGE);
        }
    }
}
