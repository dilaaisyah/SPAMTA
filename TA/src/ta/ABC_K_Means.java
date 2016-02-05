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
public class ABC_K_Means {
    koneksi database = new koneksi();
    int Klaster = 10, SN = 300, D = 5508, limit = 100, MCN = 100;
    int Gen1 = 0, Gen2 = 0, GenABCKM = 0, K =10;
    int MaxGen1 = 10, MaxGen2 = 1, MaxGenABCKM = 10;
    double i[][]=new double[11][2];
    double j[][]=new double[11][2];
    double k[][]=new double[11][2];
    double l[][]=new double[11][2];
    double m[][]=new double[11][2];
            
    public ABC_K_Means(){
        for (Gen1 = 0; Gen1 < MaxGen1; Gen1++) {
            LebahPekerja();
            UpdateLebahPenunggu();
            LebahPenunggu();
            UpdateLebahScout();
            LebahScout();
            GreedySelection();
        }
        for (GenABCKM = 0;  GenABCKM< MaxGenABCKM; GenABCKM++) {
                EuclideanDistanceABCKM();
                KlasterABCKM();
                for (Gen2 = 0; Gen2 < MaxGen2; Gen2++) {
                    CentroidBaruABCKM();
                }
            }
        JOptionPane.showMessageDialog(null, "Klaster ABC-KMS Selesai,\nAlgoritma Berhenti!","Information",JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void LebahPekerja(){
        
        try {
            database.con=DriverManager.getConnection(database.url+database.db, "root", "");
            Statement st = database.con.createStatement();
            String sql ="SELECT * FROM abckmcentroid_uji";
            ResultSet kl = st.executeQuery(sql);
            int centroid [][] = new int[11][2];
            while(kl.next()){                
                for (int l = 1; l < centroid.length; l++) {
                    for (int k = 1; k < centroid[l].length; k++) {
                        centroid[l][k] = kl.getInt(l+1);
                    }
                }
            }
            
            Statement stat = database.con.createStatement();
            String selectbanding = "SELECT * FROM index_akhir";
            ResultSet resul = stat.executeQuery(selectbanding);
            double Vij = 0;
            double Xij = 0; 
            double Xkj = 0
                    ;  
            double Oij = 0;
            while(resul.next()){ 
                int id_ind = resul.getInt(1);
                for (int row = 1; row < i.length; row++) {
                    for (int col = 1; col < i[row].length; col++) {
                        i[row][col]=resul.getDouble(centroid[row][col]);
                    }
                     
                }
                for (int caripekerja = 1; caripekerja <= 10; caripekerja++) {
                    Xij = i[caripekerja][1];
                    Oij = (Math.random()*(2)-1);
                    Xkj = i[(int)(Math.random()*10)][1];
                    Vij = Xij+(Oij*(Xij-Xkj));
                    Statement stupdate = database.con.createStatement();
                    String updatelebahpekerja = "UPDATE lebah_pekerja SET lp"+caripekerja+" = '"+Vij+"' WHERE id_lebahpekerja = "+id_ind+";";
                    stupdate.executeUpdate(updatelebahpekerja);
                }
            }
            System.out.println("Lebah Pekerja");
        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Error : "+x,"Warning",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void UpdateLebahPenunggu(){
        double lp = 0;
        int id = 0;
        try {
            database.con=DriverManager.getConnection(database.url+database.db, "root", "");
            Statement ubahlebahpenunggu = database.con.createStatement();
            String selectlebahpenunggu = "SELECT * FROM lebah_penunggu";
            ResultSet resullebahpenunggu = ubahlebahpenunggu.executeQuery(selectlebahpenunggu);
            while(resullebahpenunggu.next()){
                id=resullebahpenunggu.getInt(1);
                for (int row = 1; row < l.length; row++) {
                    for (int col = 1; col < l[row].length; col++) {
                        l[row][col]=resullebahpenunggu.getDouble(row+1);
                    }    
                }
                for (int uppenunggu = 1; uppenunggu <= 10; uppenunggu++) {
                    lp=l[uppenunggu][1];
                    Statement st4 = database.con.createStatement();
                    String uptable = "UPDATE lebah_penunggu_lama SET lpk"+uppenunggu+" = '"+lp+"' WHERE id_lebahpenunggu_lama = "+id+";";
                    st4.executeUpdate(uptable);
                }
            }
            System.out.println("Update Lebah Penunggu");
        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Error : "+x,"Warning",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void LebahPenunggu(){
        double x = 0, x1 = 0, x2 = 0, x3 = 0, x4 = 0, x5 = 0, x6 = 0, x7 = 0, x8 = 0, x9 = 0, x10 = 0;
        double Cj = 0, Cj1 = 0, Cj2 = 0, Cj3 = 0, Cj4 = 0, Cj5 = 0, Cj6 = 0, Cj7 = 0, Cj8 = 0, Cj9 = 0, Cj10 = 0;
        double Fi = 0, Fi1 = 0, Fi2 = 0, Fi3 = 0, Fi4 = 0, Fi5 = 0, Fi6 = 0, Fi7 = 0, Fi8 = 0, Fi9 = 0, Fi10 = 0;
        double Fit = 0, Fit1 = 0, Fit2 = 0, Fit3 = 0, Fit4 = 0, Fit5 = 0, Fit6 = 0, Fit7 = 0, Fit8 = 0, Fit9 = 0, Fit10 = 0;
        double Pij = 0, Pij1 = 0, Pij2 = 0, Pij3 = 0, Pij4 = 0, Pij5 = 0, Pij6 = 0, Pij7 = 0, Pij8 = 0, Pij9 = 0, Pij10 = 0; 
        double Mcx = 1, Wx = 1, temp = 0, temp1 = 0, Fitn =0;
        try {
            database.con=DriverManager.getConnection(database.url+database.db, "root", "");
            Statement statlebahpekerja = database.con.createStatement();
            String selectlebahpekerja = "SELECT * FROM lebah_pekerja";
            ResultSet resullebahpekerja = statlebahpekerja.executeQuery(selectlebahpekerja);
            while(resullebahpekerja.next()){
                int id_leb = resullebahpekerja.getInt(1);
                for (int row = 1; row < j.length; row++) {
                    for (int col = 1; col < j[row].length; col++) {
                        j[row][col]=resullebahpekerja.getDouble(row+1);
                    }
                    x1=j[1][1];
                    Cj1 = (Mcx*Wx*x1)/(Mcx*Wx);
                    Fi1 = Math.pow(Math.abs(Cj1), 2.0);
                    Fit1 = (1)/(1+Fi1);
                    x2=j[2][1];
                    Cj2 = (Mcx*Wx*x2)/(Mcx*Wx);
                    Fi2 = Math.pow(Math.abs(Cj2), 2.0);
                    Fit2 = (1)/(1+Fi2);
                    x3=j[3][1];
                    Cj3 = (Mcx*Wx*x3)/(Mcx*Wx);
                    Fi3 = Math.pow(Math.abs(Cj3), 2.0);
                    Fit3 = (1)/(1+Fi3);
                    x4=j[4][1];
                    Cj4 = (Mcx*Wx*x4)/(Mcx*Wx);
                    Fi4 = Math.pow(Math.abs(Cj4), 2.0);
                    Fit4 = (1)/(1+Fi4);
                    x5=j[5][1];
                    Cj5 = (Mcx*Wx*x5)/(Mcx*Wx);
                    Fi5 = Math.pow(Math.abs(Cj5), 2.0);
                    Fit5 = (1)/(1+Fi5);
                    x6=j[6][1];
                    Cj6 = (Mcx*Wx*x6)/(Mcx*Wx);
                    Fi6 = Math.pow(Math.abs(Cj6), 2.0);
                    Fit6 = (1)/(1+Fi6);
                    x7=j[7][1];
                    Cj7 = (Mcx*Wx*x7)/(Mcx*Wx);
                    Fi7 = Math.pow(Math.abs(Cj7), 2.0);
                    Fit7 = (1)/(1+Fi7);
                    x8=j[8][1];
                    Cj8 = (Mcx*Wx*x8)/(Mcx*Wx);
                    Fi8 = Math.pow(Math.abs(Cj8), 2.0);
                    Fit8 = (1)/(1+Fi8);
                    x9=j[9][1];
                    Cj9 = (Mcx*Wx*x9)/(Mcx*Wx);
                    Fi9 = Math.pow(Math.abs(Cj9), 2.0);
                    Fit9 = (1)/(1+Fi9);
                    x10=j[10][1];
                    Cj10 = (Mcx*Wx*x10)/(Mcx*Wx);
                    Fi10 = Math.pow(Math.abs(Cj10), 2.0);
                    Fit10 = (1)/(1+Fi10);
                    Fitn = Fit1+Fit2+Fit3+Fit4+Fit5+Fit6+Fit7+Fit8+Fit9+Fit10;
                    Pij1 = (Fit1)/(Fitn);
                    Pij2 = (Fit2)/(Fitn);
                    Pij3 = (Fit3)/(Fitn);
                    Pij4 = (Fit4)/(Fitn);
                    Pij5 = (Fit5)/(Fitn);
                    Pij6 = (Fit6)/(Fitn);
                    Pij7 = (Fit7)/(Fitn);
                    Pij8 = (Fit8)/(Fitn);
                    Pij9 = (Fit9)/(Fitn);
                    Pij10 = (Fit10)/(Fitn);
                }    
                Statement stupdate = database.con.createStatement();
                String updatelebahpenunggu = "UPDATE lebah_penunggu SET lpk1 = '"+Pij1+"', lpk2 = '"+Pij2+"', lpk3 = '"+Pij3+"', "
                        + "lpk4 = '"+Pij4+"', lpk5 = '"+Pij5+"', lpk6 = '"+Pij6+"', lpk7 = '"+Pij7+"', lpk8 = '"+Pij8+"', "
                        + "lpk9 = '"+Pij9+"', lpk10 = '"+Pij10+"'  WHERE id_lebahpenunggu = "+id_leb+";";
                stupdate.executeUpdate(updatelebahpenunggu);
                temp = 0;
            }
            System.out.println("Lebah Pnunggu");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : "+e,"Warning",JOptionPane.WARNING_MESSAGE);            
        }
    }
    
    public void UpdateLebahScout(){
        double sc1 = 0, sc2 = 0, sc3 = 0, sc4 = 0, sc5 = 0, sc6 = 0, sc7 = 0, sc8 = 0, sc9 = 0, sc10 = 0;
        try {
            database.con=DriverManager.getConnection(database.url+database.db, "root", "");
            Statement upscout = database.con.createStatement();
            String selecscout = "SELECT * FROM lebah_scout WHERE id_lebahscout = 1";
            ResultSet resulscout = upscout.executeQuery(selecscout);
            while(resulscout.next()){
                sc1 = resulscout.getDouble(2);
                sc2 = resulscout.getDouble(3);
                sc3 = resulscout.getDouble(4);
                sc4 = resulscout.getDouble(5);
                sc5 = resulscout.getDouble(6);
                sc6 = resulscout.getDouble(7);
                sc7 = resulscout.getDouble(8);
                sc8 = resulscout.getDouble(9);
                sc9 = resulscout.getDouble(10);
                sc10 = resulscout.getDouble(11);
                Statement stupsc = database.con.createStatement();
                String upsc = "UPDATE lebah_scout SET ls1 = '"+sc1+"', ls2 = '"+sc2+"', ls3 = '"+sc3+"', ls4 = '"+sc4+"', ls5 = '"+sc5+"', ls6 = '"+sc6+"', ls7 = '"+sc7+"', ls8 = '"+sc8+"', ls9 = '"+sc9+"', ls10 = '"+sc10+"' WHERE id_lebahscout = 2;";
                stupsc.executeUpdate(upsc);
            }
            System.out.println("Update Lebah Scout");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : "+e,"Warning",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void LebahScout(){
        double xij = 0;
        double Xmax = 0;
        double Xmin = 0;
        try {
            database.con=DriverManager.getConnection(database.url+database.db, "root", "");
            Statement stminmax = database.con.createStatement();
            String selectminmax = "SELECT max(lpk1), max(lpk2), max(lpk3), max(lpk4), max(lpk5), max(lpk6), max(lpk7), max(lpk8), max(lpk9), max(lpk10), min(lpk1), min(lpk2), min(lpk3), min(lpk4), min(lpk5), min(lpk6), min(lpk7), min(lpk8), min(lpk9), min(lpk10) FROM `lebah_penunggu`";
            ResultSet resulminmax = stminmax.executeQuery(selectminmax);
            while(resulminmax.next()){
                for (int cariscout = 1, min=1, max=1; cariscout <= 10; cariscout++, min++, max++) {
                    Xmax = resulminmax.getDouble(max);
                    Xmin = resulminmax.getDouble(min+10);
                    double rand = Math.random()*1;
                    xij = Xmin+(rand*(Xmax-Xmin));
                    Statement scout = database.con.createStatement();
                    String Sscout = "UPDATE lebah_scout SET ls"+cariscout+" = '"+xij+"' WHERE id_lebahscout = 1;";
                    scout.executeUpdate(Sscout);
                }
            }
            System.out.println("Lebah Scout");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : "+e,"Warning",JOptionPane.WARNING_MESSAGE);            
        }
    }
        
    public void PanggilA1(){
        try {
            database.con=DriverManager.getConnection(database.url+database.db, "root", "");
            Statement stpusat = database.con.createStatement();
            String selectpusat = "SELECT id_lebahpenunggu, lpk1, C1 FROM abckm a, lebah_penunggu b WHERE a.id_cabckm = b.id_cabckm";
            ResultSet resulpusat = stpusat.executeQuery(selectpusat);
            while(resulpusat.next()){
                int idlpen = resulpusat.getInt(1);
                double lp = resulpusat.getDouble(2);
                String cabc = resulpusat.getString(3);
                String ubah = ((cabc+"").length()==1?("0"+cabc):cabc);
                Statement sttitik1 = database.con.createStatement();
                String uptitik1 = "UPDATE index_akhir SET D"+ubah+" = '"+lp+"' WHERE id_index = "+idlpen+";";
                sttitik1.executeUpdate(uptitik1);   
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : "+e,"Warning",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void PanggilA2(){
        try {
            database.con=DriverManager.getConnection(database.url+database.db, "root", "");
            Statement stpusat2 = database.con.createStatement();
            String selectpusat2 = "SELECT id_lebahpenunggu_lama, lpk1, C1 FROM abckm a, lebah_penunggu_lama b WHERE a.id_cabckm = b.id_cabckm";
            ResultSet resulpusat2 = stpusat2.executeQuery(selectpusat2);
            while(resulpusat2.next()){
                int idlpen = resulpusat2.getInt(1);
                double lp = resulpusat2.getDouble(2);
                String cabc = resulpusat2.getString(3);
                String ubah = ((cabc+"").length()==1?("0"+cabc):cabc);
                Statement sttitik11 = database.con.createStatement();
                String uptitik11 = "UPDATE index_akhir SET D"+ubah+" = '"+lp+"' WHERE id_index = "+idlpen+";";
                sttitik11.executeUpdate(uptitik11);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : "+e,"Warning",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void PanggilB1(){
        try {
            database.con=DriverManager.getConnection(database.url+database.db, "root", "");
            Statement stpusat = database.con.createStatement();
            String selectpusat = "SELECT id_lebahpenunggu, lpk2, C2 FROM abckm a, lebah_penunggu b WHERE a.id_cabckm = b.id_cabckm";
            ResultSet resulpusat = stpusat.executeQuery(selectpusat);
            while(resulpusat.next()){
                int idlpen = resulpusat.getInt(1);
                double lp = resulpusat.getDouble(2);
                String cabc = resulpusat.getString(3);
                String ubah = ((cabc+"").length()==1?("0"+cabc):cabc);
                Statement sttitik1 = database.con.createStatement();
                String uptitik1 = "UPDATE index_akhir SET D"+ubah+" = '"+lp+"' WHERE id_index = "+idlpen+";";
                sttitik1.executeUpdate(uptitik1);   
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : "+e,"Warning",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void PanggilB2(){
        try {
            database.con=DriverManager.getConnection(database.url+database.db, "root", "");
            Statement stpusat2 = database.con.createStatement();
            String selectpusat2 = "SELECT id_lebahpenunggu_lama, lpk2, C2 FROM abckm a, lebah_penunggu_lama b WHERE a.id_cabckm = b.id_cabckm";
            ResultSet resulpusat2 = stpusat2.executeQuery(selectpusat2);
            while(resulpusat2.next()){
                int idlpen = resulpusat2.getInt(1);
                double lp = resulpusat2.getDouble(2);     
                String cabc = resulpusat2.getString(3);
                String ubah = ((cabc+"").length()==1?("0"+cabc):cabc);
                Statement sttitik11 = database.con.createStatement();
                String uptitik11 = "UPDATE index_akhir SET D"+ubah+" = '"+lp+"' WHERE id_index = "+idlpen+";";
                sttitik11.executeUpdate(uptitik11);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : "+e,"Warning",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void PanggilC1(){
        try {
            database.con=DriverManager.getConnection(database.url+database.db, "root", "");
            Statement stpusat = database.con.createStatement();
            String selectpusat = "SELECT id_lebahpenunggu, lpk3, C3 FROM abckm a, lebah_penunggu b WHERE a.id_cabckm = b.id_cabckm";
            ResultSet resulpusat = stpusat.executeQuery(selectpusat);
            while(resulpusat.next()){
                int idlpen = resulpusat.getInt(1);
                double lp = resulpusat.getDouble(2);
                String cabc = resulpusat.getString(3);
                String ubah = ((cabc+"").length()==1?("0"+cabc):cabc);
                Statement sttitik1 = database.con.createStatement();
                String uptitik1 = "UPDATE index_akhir SET D"+ubah+" = '"+lp+"' WHERE id_index = "+idlpen+";";
                sttitik1.executeUpdate(uptitik1);   
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : "+e,"Warning",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void PanggilC2(){
        try {
            database.con=DriverManager.getConnection(database.url+database.db, "root", "");
            Statement stpusat2 = database.con.createStatement();
            String selectpusat2 = "SELECT id_lebahpenunggu_lama, lpk3, C3 FROM abckm a, lebah_penunggu_lama b WHERE a.id_cabckm = b.id_cabckm";
            ResultSet resulpusat2 = stpusat2.executeQuery(selectpusat2);
            while(resulpusat2.next()){
                int idlpen = resulpusat2.getInt(1);
                double lp = resulpusat2.getDouble(2);
                String cabc = resulpusat2.getString(3);
                String ubah = ((cabc+"").length()==1?("0"+cabc):cabc);
                Statement sttitik11 = database.con.createStatement();
                String uptitik11 = "UPDATE index_akhir SET D"+ubah+" = '"+lp+"' WHERE id_index = "+idlpen+";";
                sttitik11.executeUpdate(uptitik11);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : "+e,"Warning",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void PanggilD1(){
        try {
            database.con=DriverManager.getConnection(database.url+database.db, "root", "");
            Statement stpusat = database.con.createStatement();
            String selectpusat = "SELECT id_lebahpenunggu, lpk4, C4 FROM abckm a, lebah_penunggu b WHERE a.id_cabckm = b.id_cabckm";
            ResultSet resulpusat = stpusat.executeQuery(selectpusat);
            while(resulpusat.next()){
                int idlpen = resulpusat.getInt(1);
                double lp = resulpusat.getDouble(2);
                String cabc = resulpusat.getString(3);
                String ubah = ((cabc+"").length()==1?("0"+cabc):cabc);
                Statement sttitik1 = database.con.createStatement();
                String uptitik1 = "UPDATE index_akhir SET D"+ubah+" = '"+lp+"' WHERE id_index = "+idlpen+";";
                sttitik1.executeUpdate(uptitik1);   
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : "+e,"Warning",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void PanggilD2(){
        try {
            database.con=DriverManager.getConnection(database.url+database.db, "root", "");
            Statement stpusat2 = database.con.createStatement();
            String selectpusat2 = "SELECT id_lebahpenunggu_lama, lpk4, C4 FROM abckm a, lebah_penunggu_lama b WHERE a.id_cabckm = b.id_cabckm";
            ResultSet resulpusat2 = stpusat2.executeQuery(selectpusat2);
            while(resulpusat2.next()){
                int idlpen = resulpusat2.getInt(1);
                double lp = resulpusat2.getDouble(2);
                String cabc = resulpusat2.getString(3);
                String ubah = ((cabc+"").length()==1?("0"+cabc):cabc);
                Statement sttitik11 = database.con.createStatement();
                String uptitik11 = "UPDATE index_akhir SET D"+ubah+" = '"+lp+"' WHERE id_index = "+idlpen+";";
                sttitik11.executeUpdate(uptitik11);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : "+e,"Warning",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void PanggilE1(){
        try {
            database.con=DriverManager.getConnection(database.url+database.db, "root", "");
            Statement stpusat = database.con.createStatement();
            String selectpusat = "SELECT id_lebahpenunggu, lpk5, C5 FROM abckm a, lebah_penunggu b WHERE a.id_cabckm = b.id_cabckm";
            ResultSet resulpusat = stpusat.executeQuery(selectpusat);
            while(resulpusat.next()){
                int idlpen = resulpusat.getInt(1);
                double lp = resulpusat.getDouble(2);
                String cabc = resulpusat.getString(3);
                String ubah = ((cabc+"").length()==1?("0"+cabc):cabc);
                Statement sttitik1 = database.con.createStatement();
                String uptitik1 = "UPDATE index_akhir SET D"+ubah+" = '"+lp+"' WHERE id_index = "+idlpen+";";
                sttitik1.executeUpdate(uptitik1);   
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : "+e,"Warning",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void PanggilE2(){
        try {
            database.con=DriverManager.getConnection(database.url+database.db, "root", "");
            Statement stpusat2 = database.con.createStatement();
            String selectpusat2 = "SELECT id_lebahpenunggu_lama, lpk5, C5 FROM abckm a, lebah_penunggu_lama b WHERE a.id_cabckm = b.id_cabckm";
            ResultSet resulpusat2 = stpusat2.executeQuery(selectpusat2);
            while(resulpusat2.next()){
                int idlpen = resulpusat2.getInt(1);
                double lp = resulpusat2.getDouble(2);
                String cabc = resulpusat2.getString(3);
                String ubah = ((cabc+"").length()==1?("0"+cabc):cabc);
                Statement sttitik11 = database.con.createStatement();
                String uptitik11 = "UPDATE index_akhir SET D"+ubah+" = '"+lp+"' WHERE id_index = "+idlpen+";";
                sttitik11.executeUpdate(uptitik11);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : "+e,"Warning",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void PanggilF1(){
        try {
            database.con=DriverManager.getConnection(database.url+database.db, "root", "");
            Statement stpusat = database.con.createStatement();
            String selectpusat = "SELECT id_lebahpenunggu, lpk6, C6 FROM abckm a, lebah_penunggu b WHERE a.id_cabckm = b.id_cabckm";
            ResultSet resulpusat = stpusat.executeQuery(selectpusat);
            while(resulpusat.next()){
                int idlpen = resulpusat.getInt(1);
                double lp = resulpusat.getDouble(2);
                String cabc = resulpusat.getString(3);
                String ubah = ((cabc+"").length()==1?("0"+cabc):cabc);
                Statement sttitik1 = database.con.createStatement();
                String uptitik1 = "UPDATE index_akhir SET D"+ubah+" = '"+lp+"' WHERE id_index = "+idlpen+";";
                sttitik1.executeUpdate(uptitik1);   
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : "+e,"Warning",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void PanggilF2(){
        try {
            database.con=DriverManager.getConnection(database.url+database.db, "root", "");
            Statement stpusat2 = database.con.createStatement();
            String selectpusat2 = "SELECT id_lebahpenunggu_lama, lpk6, C6 FROM abckm a, lebah_penunggu_lama b WHERE a.id_cabckm = b.id_cabckm";
            ResultSet resulpusat2 = stpusat2.executeQuery(selectpusat2);
            while(resulpusat2.next()){
                int idlpen = resulpusat2.getInt(1);
                double lp = resulpusat2.getDouble(2);
                String cabc = resulpusat2.getString(3);
                String ubah = ((cabc+"").length()==1?("0"+cabc):cabc);
                Statement sttitik11 = database.con.createStatement();
                String uptitik11 = "UPDATE index_akhir SET D"+ubah+" = '"+lp+"' WHERE id_index = "+idlpen+";";
                sttitik11.executeUpdate(uptitik11);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : "+e,"Warning",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void PanggilG1(){
        try {
            database.con=DriverManager.getConnection(database.url+database.db, "root", "");
            Statement stpusat = database.con.createStatement();
            String selectpusat = "SELECT id_lebahpenunggu, lpk7, C7 FROM abckm a, lebah_penunggu b WHERE a.id_cabckm = b.id_cabckm";
            ResultSet resulpusat = stpusat.executeQuery(selectpusat);
            while(resulpusat.next()){
                int idlpen = resulpusat.getInt(1);
                double lp = resulpusat.getDouble(2);        
                String cabc = resulpusat.getString(3);
                String ubah = ((cabc+"").length()==1?("0"+cabc):cabc);
                Statement sttitik1 = database.con.createStatement();
                String uptitik1 = "UPDATE index_akhir SET D"+ubah+" = '"+lp+"' WHERE id_index = "+idlpen+";";
                sttitik1.executeUpdate(uptitik1);   
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : "+e,"Warning",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void PanggilG2(){
        try {
            database.con=DriverManager.getConnection(database.url+database.db, "root", "");
            Statement stpusat2 = database.con.createStatement();
            String selectpusat2 = "SELECT id_lebahpenunggu_lama, lpk7, C7 FROM abckm a, lebah_penunggu_lama b WHERE a.id_cabckm = b.id_cabckm";
            ResultSet resulpusat2 = stpusat2.executeQuery(selectpusat2);
            while(resulpusat2.next()){
                int idlpen = resulpusat2.getInt(1);
                double lp = resulpusat2.getDouble(2);
                String cabc = resulpusat2.getString(3);
                String ubah = ((cabc+"").length()==1?("0"+cabc):cabc);
                Statement sttitik11 = database.con.createStatement();
                String uptitik11 = "UPDATE index_akhir SET D"+ubah+" = '"+lp+"' WHERE id_index = "+idlpen+";";
                sttitik11.executeUpdate(uptitik11);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : "+e,"Warning",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void PanggilH1(){
        try {
            database.con=DriverManager.getConnection(database.url+database.db, "root", "");
            Statement stpusat = database.con.createStatement();
            String selectpusat = "SELECT id_lebahpenunggu, lpk8, C8 FROM abckm a, lebah_penunggu b WHERE a.id_cabckm = b.id_cabckm";
            ResultSet resulpusat = stpusat.executeQuery(selectpusat);
            while(resulpusat.next()){
                int idlpen = resulpusat.getInt(1);
                double lp = resulpusat.getDouble(2);
                String cabc = resulpusat.getString(3);
                String ubah = ((cabc+"").length()==1?("0"+cabc):cabc);
                Statement sttitik1 = database.con.createStatement();
                String uptitik1 = "UPDATE index_akhir SET D"+ubah+" = '"+lp+"' WHERE id_index = "+idlpen+";";
                sttitik1.executeUpdate(uptitik1);   
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : "+e,"Warning",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void PanggilH2(){
        try {
            database.con=DriverManager.getConnection(database.url+database.db, "root", "");
            Statement stpusat2 = database.con.createStatement();
            String selectpusat2 = "SELECT id_lebahpenunggu_lama, lpk8, C8 FROM abckm a, lebah_penunggu_lama b WHERE a.id_cabckm = b.id_cabckm";
            ResultSet resulpusat2 = stpusat2.executeQuery(selectpusat2);
            while(resulpusat2.next()){
                int idlpen = resulpusat2.getInt(1);
                double lp = resulpusat2.getDouble(2);
                String cabc = resulpusat2.getString(3);
                String ubah = ((cabc+"").length()==1?("0"+cabc):cabc);
                Statement sttitik11 = database.con.createStatement();
                String uptitik11 = "UPDATE index_akhir SET D"+ubah+" = '"+lp+"' WHERE id_index = "+idlpen+";";
                sttitik11.executeUpdate(uptitik11);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : "+e,"Warning",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void PanggilI1(){
        try {
            database.con=DriverManager.getConnection(database.url+database.db, "root", "");
            Statement stpusat = database.con.createStatement();
            String selectpusat = "SELECT id_lebahpenunggu, lpk9, C9 FROM abckm a, lebah_penunggu b WHERE a.id_cabckm = b.id_cabckm";
            ResultSet resulpusat = stpusat.executeQuery(selectpusat);
            while(resulpusat.next()){
                int idlpen = resulpusat.getInt(1);
                double lp = resulpusat.getDouble(2);
                String cabc = resulpusat.getString(3);
                String ubah = ((cabc+"").length()==1?("0"+cabc):cabc);
                Statement sttitik1 = database.con.createStatement();
                String uptitik1 = "UPDATE index_akhir SET D"+ubah+" = '"+lp+"' WHERE id_index = "+idlpen+";";
                sttitik1.executeUpdate(uptitik1);   
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : "+e,"Warning",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void PanggilI2(){
        try {
            database.con=DriverManager.getConnection(database.url+database.db, "root", "");
            Statement stpusat2 = database.con.createStatement();
            String selectpusat2 = "SELECT id_lebahpenunggu_lama, lpk9, C9 FROM abckm a, lebah_penunggu_lama b WHERE a.id_cabckm = b.id_cabckm";
            ResultSet resulpusat2 = stpusat2.executeQuery(selectpusat2);
            while(resulpusat2.next()){
                int idlpen = resulpusat2.getInt(1);
                double lp = resulpusat2.getDouble(2);
                String cabc = resulpusat2.getString(3);
                String ubah = ((cabc+"").length()==1?("0"+cabc):cabc);
                Statement sttitik11 = database.con.createStatement();
                String uptitik11 = "UPDATE index_akhir SET D"+ubah+" = '"+lp+"' WHERE id_index = "+idlpen+";";
                sttitik11.executeUpdate(uptitik11);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : "+e,"Warning",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void PanggilJ1(){
        try {
            database.con=DriverManager.getConnection(database.url+database.db, "root", "");
            Statement stpusat = database.con.createStatement();
            String selectpusat = "SELECT id_lebahpenunggu, lpk10, C10 FROM abckm a, lebah_penunggu b WHERE a.id_cabckm = b.id_cabckm";
            ResultSet resulpusat = stpusat.executeQuery(selectpusat);
            while(resulpusat.next()){
                int idlpen = resulpusat.getInt(1);
                double lp = resulpusat.getDouble(2);
                String cabc = resulpusat.getString(3);
                String ubah = ((cabc+"").length()==1?("0"+cabc):cabc);
                Statement sttitik1 = database.con.createStatement();
                String uptitik1 = "UPDATE index_akhir SET D"+ubah+" = '"+lp+"' WHERE id_index = "+idlpen+";";
                sttitik1.executeUpdate(uptitik1);   
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : "+e,"Warning",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void PanggilJ2(){
        try {
            database.con=DriverManager.getConnection(database.url+database.db, "root", "");
            Statement stpusat2 = database.con.createStatement();
            String selectpusat2 = "SELECT id_lebahpenunggu_lama, lpk10, C10 FROM abckm a, lebah_penunggu_lama b WHERE a.id_cabckm = b.id_cabckm";
            ResultSet resulpusat2 = stpusat2.executeQuery(selectpusat2);
            while(resulpusat2.next()){
                int idlpen = resulpusat2.getInt(1);
                double lp = resulpusat2.getDouble(2);
                String cabc = resulpusat2.getString(3);
                String ubah = ((cabc+"").length()==1?("0"+cabc):cabc);
                Statement sttitik11 = database.con.createStatement();
                String uptitik11 = "UPDATE index_akhir SET D"+ubah+" = '"+lp+"' WHERE id_index = "+idlpen+";";
                sttitik11.executeUpdate(uptitik11);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : "+e,"Warning",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void GreedySelection(){
        double a1 = 0, b1 = 0, c1 = 0, d1 = 0, e1 = 0, f1 = 0, g1 = 0, h1 = 0, i1 = 0, j1 = 0;
        double a2 = 0, b2 = 0, c2 = 0, d2 = 0, e2 = 0, f2 = 0, g2 = 0, h2 = 0, i2 = 0, j2 = 0;
        try {
            database.con=DriverManager.getConnection(database.url+database.db, "root", "");
            Statement stgredy1 = database.con.createStatement();
            String selectgredy1 = "SELECT * FROM lebah_scout where id_lebahscout = 1";
            ResultSet resulgredy1 = stgredy1.executeQuery(selectgredy1);
            while(resulgredy1.next()){
                a1 = resulgredy1.getDouble(2);
                b1 = resulgredy1.getDouble(3);
                c1 = resulgredy1.getDouble(4);
                d1 = resulgredy1.getDouble(5);
                e1 = resulgredy1.getDouble(6);
                f1 = resulgredy1.getDouble(7);
                g1 = resulgredy1.getDouble(8);
                h1 = resulgredy1.getDouble(9);
                i1 = resulgredy1.getDouble(10);
                j1 = resulgredy1.getDouble(11);
            }
            
            Statement stgredy2 = database.con.createStatement();
            String selectgredy2 = "SELECT * FROM lebah_scout where id_lebahscout = 2";
            ResultSet resulgredy2 = stgredy2.executeQuery(selectgredy2);
            while(resulgredy2.next()){
                a2 = resulgredy2.getDouble(2);
                b2 = resulgredy2.getDouble(3);
                c2 = resulgredy2.getDouble(4);
                d2 = resulgredy2.getDouble(5);
                e2 = resulgredy2.getDouble(6);
                f2 = resulgredy2.getDouble(7);
                g2 = resulgredy2.getDouble(8);
                h2 = resulgredy2.getDouble(9);
                i2 = resulgredy2.getDouble(10);
                j2 = resulgredy2.getDouble(11);
            }
            //1 = baru, 2 = lama
            if(a1>=a2){
                PanggilA1();
            }
            if(a1<a2){
                PanggilA2();
            }
            if(b1>=b2){
                PanggilB1();
            }
            if(b1<b2){
                PanggilB2();
            }
            if(c1>=c2){
                PanggilC1();
            }
            if(c1<c2){
                PanggilC2();
            }
            if(d1>=d2){
                PanggilD1();
            }
            if(d1<d2){
                PanggilD2();
            }
            if(e1>=e2){
                PanggilE1();
            }
            if(e1<e2){
                PanggilE2();
            }
            if(f1>=f2){
                PanggilF1();
            }
            if(f1<f2){
                PanggilF2();
            }
            if(g1>=g2){
                PanggilG1();
            }
            if(g1<g2){
                PanggilG2();
            }
            if(h1>=h2){
                PanggilH1();
            }
            if(h1<h2){
                PanggilH2();
            }
            if(i1>=i2){
                PanggilI1();
            }
            if(i1<i2){
                PanggilI2();
            }
            if(j1>=j2){
                PanggilJ1();
            }
            if(j1<j2){
                PanggilJ2();
            }
            System.out.println("Greedy Selection");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : "+e,"Warning",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void EuclideanDistanceABCKM(){
        try {    
            database.con=DriverManager.getConnection(database.url+database.db, "root", "");
            Statement st = database.con.createStatement();
                    String sql ="SELECT * FROM abckm";
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
                        String upjarak = "UPDATE ABCJARAK SET C1="+Math.sqrt(duadimensi[row][1])+","
                                + "C2="+Math.sqrt(duadimensi[row][2])+",C3="+Math.sqrt(duadimensi[row][3])+","
                                + "C4="+Math.sqrt(duadimensi[row][4])+",C5="+Math.sqrt(duadimensi[row][5])+","
                                + "C6="+Math.sqrt(duadimensi[row][6])+",C7="+Math.sqrt(duadimensi[row][7])+","
                                + "C8="+Math.sqrt(duadimensi[row][8])+",C9="+Math.sqrt(duadimensi[row][9])+","
                                + "C10="+Math.sqrt(duadimensi[row][10])+",jarak_terpendek="+i+" WHERE "
                                + "id_jarakabc="+row+"";
                        st2.executeUpdate(upjarak);
                    }
                    System.out.println("Euclidean");
        } catch (Exception x) {   
            JOptionPane.showMessageDialog(null, "Error : "+x,"Warning",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void KlasterABCKM(){
        try {
            database.con=DriverManager.getConnection(database.url+database.db, "root", "");                    
                    Statement st3 = database.con.createStatement();
                    String selectjarak = "SELECT * FROM abcjarak";
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
                        String upklaster = "UPDATE abcklaster_baru SET klaster_abc="+klas+" WHERE id_klaster_abc = "+id_jarak+"";
                        st4.executeUpdate(upklaster);
                    }
                    System.out.println("Klaster");
        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Error : "+x,"Warning",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void CentroidBaruABCKM(){
        try {
            database.con=DriverManager.getConnection(database.url+database.db, "root", "");
                    for (int centroidbaru = 1; centroidbaru <= K; centroidbaru++) {
                        int id_klaster = 0, jmlklaster_sementara=0;
                        String dokumen[] = new String[2];
                        String panggil = "";
                        double titikpusat = 0, simpantitikpusat=0;
                        Statement sc = database.con.createStatement();
                        String sltc = "SELECT count(klaster_abc) FROM abcklaster_baru where klaster_abc="+centroidbaru+"";
                        ResultSet kl1c = sc.executeQuery(sltc);
                        while(kl1c.next()){
                            int ccount=kl1c.getInt(1);
                            jmlklaster_sementara=ccount;
                        }
                        Statement st5 = database.con.createStatement();
                        String selectc = "SELECT id_klaster_abc FROM abcklaster_baru where klaster_abc="+centroidbaru+"";
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
                            Statement stcabc = database.con.createStatement();
                            String strcabc = "SELECT C"+centroidbaru+" FROM abckm";
                            ResultSet rscabc = stcabc.executeQuery(strcabc);
                            while(rscabc.next()){
                                String c = rscabc.getString(1);
                                String u = ((c+"").length()==1?("0"+c):c);
                                Statement stcnew = database.con.createStatement();
                                String upcentroid1 = "UPDATE index_akhir SET D"+u+" = "+simpantitikpusat+" WHERE id_index = "+id_titikpusat+"";
                                stcnew.executeUpdate(upcentroid1);
                            }
                        }
                    }
                    System.out.println("Centroid");
        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Error : "+x,"Warning",JOptionPane.WARNING_MESSAGE);
        }
    }
}
