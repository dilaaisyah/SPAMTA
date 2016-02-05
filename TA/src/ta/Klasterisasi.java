/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ta;

import Control.StopWatch;
import Control.Time;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.StringTokenizer;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public class Klasterisasi extends javax.swing.JFrame {
    koneksi database = new koneksi();
    ecsstemmer ecs = new ecsstemmer();
    Text_Mining txt_min = new Text_Mining();
    TF_IDF tf_idf = new TF_IDF();
    Pengujian uji = new Pengujian();
    public Klasterisasi() {
        initComponents();
        setTitle("Klasterisasi ABC-KM");
        setIconImage(new ImageIcon(getClass().getResource("icon.png")).getImage());  
        setExtendedState(MAXIMIZED_BOTH);
        String ACTION_KEY = "Action";

        AbstractAction action = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                btnloginActionPerformed(e);
            }
        };

        KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
        InputMap inputMap = btnlogin.getInputMap();
        inputMap.put(keyStroke, ACTION_KEY);
        ActionMap actionMap= btnlogin.getActionMap();
        actionMap.put(ACTION_KEY, action);
        btnlogin.setActionMap(actionMap);
        
        tablebuku.setVisible(false);
        scrollbuku.setVisible(false);
        lblusername.setVisible(true);
        txtusername.setVisible(true);
        lblpassword.setVisible(true);
        txtpassword.setVisible(true);
        btnlogin.setVisible(true);
        lbllogin.setVisible(true);
        
        preprocesing.setEnabled(false);
        klaster.setEnabled(false);
        logout.setVisible(false);
        lihatbuku.setEnabled(false);
        lihatklaster.setEnabled(false);
        AksiTextMining.setVisible(false);
        AksiTFIDF.setVisible(false);
        Aksiklaster.setVisible(false);
        progressBar.setVisible(false);
        lblinfo.setVisible(false);
        pengujian.setEnabled(false);
        kmeansuji.setVisible(false);
        //abckmuji.setVisible(false);
        
    }
    
    private int s=0, m=0, h=0;
    Timer timer;
    private int interval = 100;

    public void stop() {
        timer.stop();
    }
    
    private void initMulai(){
        timer = new Timer(interval,new ActionListener() {
            public void actionPerformed(ActionEvent ev) {setWaktu();
            }
        });
        timer.start();
    }

    public void setWaktu(){
        if(s==60){
            s=0;
            m++;
        }else s++;
        if(m==60){
            m=0;
            h++;
        }
        StopWatch tm = new StopWatch();
        Time t = tm.timeFormat(s, m, h);
        txtwaktukomputasikmeans.setText( t.getJam()+" : "+ t.getMenit()+" : " + t.getDetik());
        txtwaktukomputasiabckm.setText( t.getJam()+" : "+ t.getMenit()+" : " + t.getDetik());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        Aksiklaster = new javax.swing.JTabbedPane();
        panelKmeans = new javax.swing.JPanel();
        jLayeredPane8 = new javax.swing.JLayeredPane();
        lblkompkmeans = new javax.swing.JLabel();
        txtwaktukomputasikmeans = new javax.swing.JLabel();
        ScrollPanekmeans = new javax.swing.JScrollPane();
        txtkmeans = new javax.swing.JTextArea();
        progkmeans = new javax.swing.JProgressBar();
        btnmulaikmeans = new javax.swing.JButton();
        btnbersihkankmeans = new javax.swing.JButton();
        ScrollPanepenjelasankmeans = new javax.swing.JScrollPane();
        txtpenjelasankmeans = new javax.swing.JTextArea();
        panelabckm = new javax.swing.JPanel();
        jLayeredPane9 = new javax.swing.JLayeredPane();
        lblkompabckm = new javax.swing.JLabel();
        txtwaktukomputasiabckm = new javax.swing.JLabel();
        ScrollPaneabckm = new javax.swing.JScrollPane();
        txtabckm = new javax.swing.JTextArea();
        progabckm = new javax.swing.JProgressBar();
        btnmulaiabckm = new javax.swing.JButton();
        btnbersihkanabckm = new javax.swing.JButton();
        ScrollPanepenjelasanabckm = new javax.swing.JScrollPane();
        txtpenjelasanabckm = new javax.swing.JTextArea();
        lblinfo = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        lblusername = new javax.swing.JLabel();
        txtusername = new javax.swing.JTextField();
        lblpassword = new javax.swing.JLabel();
        txtpassword = new javax.swing.JPasswordField();
        btnlogin = new javax.swing.JButton();
        lbllogin = new javax.swing.JLabel();
        scrollbuku = new javax.swing.JScrollPane();
        tablebuku = new javax.swing.JTable();
        AksiTextMining = new javax.swing.JTabbedPane();
        panelcase = new javax.swing.JPanel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        ScrollPanecase = new javax.swing.JScrollPane();
        txtcase = new javax.swing.JTextArea();
        progcase = new javax.swing.JProgressBar();
        btnmulaicase = new javax.swing.JButton();
        btnbersihkancase = new javax.swing.JButton();
        ScrollPanepenjelasancase = new javax.swing.JScrollPane();
        txtpenjelasancase = new javax.swing.JTextArea();
        panelfiltering = new javax.swing.JPanel();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        ScrollPanefiltering = new javax.swing.JScrollPane();
        txtfiltering = new javax.swing.JTextArea();
        progfiltering = new javax.swing.JProgressBar();
        btnmulaifiltering = new javax.swing.JButton();
        btnbersihkanfiltering = new javax.swing.JButton();
        ScrollPanepenjelasanfiltering = new javax.swing.JScrollPane();
        txtpenjelasanfiltering = new javax.swing.JTextArea();
        panelstemming = new javax.swing.JPanel();
        jLayeredPane4 = new javax.swing.JLayeredPane();
        ScrollPanestemming = new javax.swing.JScrollPane();
        txtstemming = new javax.swing.JTextArea();
        progstemming = new javax.swing.JProgressBar();
        btnmulaistemming = new javax.swing.JButton();
        btnbersihkanstemming = new javax.swing.JButton();
        ScrollPanepenjelasanstemming = new javax.swing.JScrollPane();
        txtpenjelasanstemming = new javax.swing.JTextArea();
        AksiTFIDF = new javax.swing.JTabbedPane();
        paneltf = new javax.swing.JPanel();
        jLayeredPane5 = new javax.swing.JLayeredPane();
        ScrollPanetf = new javax.swing.JScrollPane();
        txttf = new javax.swing.JTextArea();
        progtf = new javax.swing.JProgressBar();
        btnmulaitf = new javax.swing.JButton();
        btnbersihkantf = new javax.swing.JButton();
        ScrollPanepenjelasantf = new javax.swing.JScrollPane();
        txtpenjelasantf = new javax.swing.JTextArea();
        panelidf = new javax.swing.JPanel();
        jLayeredPane6 = new javax.swing.JLayeredPane();
        ScrollPaneidf = new javax.swing.JScrollPane();
        txtidf = new javax.swing.JTextArea();
        progidf = new javax.swing.JProgressBar();
        btnmulaiidf = new javax.swing.JButton();
        btnbersihkanidf = new javax.swing.JButton();
        ScrollPanepenjelasanidf = new javax.swing.JScrollPane();
        txtpenjelasanidf = new javax.swing.JTextArea();
        panelnolmalisasi = new javax.swing.JPanel();
        jLayeredPane7 = new javax.swing.JLayeredPane();
        ScrollPanenormalisasi = new javax.swing.JScrollPane();
        txtnormalisasi = new javax.swing.JTextArea();
        prognormalisasi = new javax.swing.JProgressBar();
        btnmulainormalisasi = new javax.swing.JButton();
        btnbersihkannormalisasi = new javax.swing.JButton();
        ScrollPanepenjelasannormalisasi = new javax.swing.JScrollPane();
        txtpenjelasannormalisasi = new javax.swing.JTextArea();
        bground = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        file = new javax.swing.JMenu();
        login = new javax.swing.JMenuItem();
        logout = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        lihatbuku = new javax.swing.JMenuItem();
        lihatklaster = new javax.swing.JMenu();
        basickmeans = new javax.swing.JMenuItem();
        abckmeans = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        keluar = new javax.swing.JMenuItem();
        preprocesing = new javax.swing.JMenu();
        textmining = new javax.swing.JMenuItem();
        tfidf = new javax.swing.JMenuItem();
        klaster = new javax.swing.JMenu();
        sentroidawal = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        mulaiklaster = new javax.swing.JMenuItem();
        kmeansuji = new javax.swing.JMenuItem();
        abckmuji = new javax.swing.JMenuItem();
        pengujian = new javax.swing.JMenu();
        precision = new javax.swing.JMenuItem();
        recall = new javax.swing.JMenuItem();
        fmeasure = new javax.swing.JMenuItem();
        waktu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblkompkmeans.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblkompkmeans.setText("Waktu Komputasi");
        lblkompkmeans.setBounds(10, 0, 360, 30);
        jLayeredPane8.add(lblkompkmeans, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtwaktukomputasikmeans.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtwaktukomputasikmeans.setText("00 : 00 : 00");
        txtwaktukomputasikmeans.setBounds(270, 0, 100, 30);
        jLayeredPane8.add(txtwaktukomputasikmeans, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtkmeans.setColumns(20);
        txtkmeans.setRows(5);
        ScrollPanekmeans.setViewportView(txtkmeans);

        ScrollPanekmeans.setBounds(0, 30, 370, 320);
        jLayeredPane8.add(ScrollPanekmeans, javax.swing.JLayeredPane.DEFAULT_LAYER);
        progkmeans.setBounds(0, 360, 370, 20);
        jLayeredPane8.add(progkmeans, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnmulaikmeans.setText("MULAI");
        btnmulaikmeans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmulaikmeansActionPerformed(evt);
            }
        });
        btnmulaikmeans.setBounds(0, 390, 180, 30);
        jLayeredPane8.add(btnmulaikmeans, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnbersihkankmeans.setText("BERSIHKAN");
        btnbersihkankmeans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbersihkankmeansActionPerformed(evt);
            }
        });
        btnbersihkankmeans.setBounds(180, 390, 190, 30);
        jLayeredPane8.add(btnbersihkankmeans, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtpenjelasankmeans.setColumns(20);
        txtpenjelasankmeans.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txtpenjelasankmeans.setRows(5);
        txtpenjelasankmeans.setText("- Basic K-Means\nDalam statistic dan mesin pembelajaran, pengelompokkan K-Means merupakan metode analisis \nkelompok yang mengarah pada pemartisian N objek pengamatan ke dalam K kelompok (cluster) \ndi mana setiap objek pengamatan dimiliki oleh sebuah kelompok dengan mean (rata-rata) \nterdekat.\n\nK-Means merupakan salah satu metode pengelompokan data yang berusaha mempartisi data \nyang ada ke dalam bentuk dua atau lebih kelompok. Metode ini memartisi data ke dalam \nkelompok sehingga data yang berkarakteristik sama dimasukkan ke dalam satu kelompok yang \nsama dan data yang berkarakteristik berbeda dikelompokkan ke dalam kelompok yang lain. \nAdapun tujuan pengelompokan data ini adalah untuk meminimalkan fungsi objektif yang \ndiset dalam proses pengelompokan, yang pada umumnya berusaha meminimalkan variasi didalam \nsuatu kelompok dan memaksimalkan variasi antar kelompok.");
        ScrollPanepenjelasankmeans.setViewportView(txtpenjelasankmeans);

        ScrollPanepenjelasankmeans.setBounds(430, 30, 810, 360);
        jLayeredPane8.add(ScrollPanepenjelasankmeans, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panelKmeansLayout = new javax.swing.GroupLayout(panelKmeans);
        panelKmeans.setLayout(panelKmeansLayout);
        panelKmeansLayout.setHorizontalGroup(
            panelKmeansLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 1275, Short.MAX_VALUE)
        );
        panelKmeansLayout.setVerticalGroup(
            panelKmeansLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
        );

        Aksiklaster.addTab("K-Means", panelKmeans);

        lblkompabckm.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblkompabckm.setText("Waktu Komputasi");
        lblkompabckm.setBounds(10, 0, 170, 30);
        jLayeredPane9.add(lblkompabckm, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtwaktukomputasiabckm.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtwaktukomputasiabckm.setText("00 : 00 : 00");
        txtwaktukomputasiabckm.setBounds(270, 0, 100, 30);
        jLayeredPane9.add(txtwaktukomputasiabckm, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtabckm.setColumns(20);
        txtabckm.setRows(5);
        ScrollPaneabckm.setViewportView(txtabckm);

        ScrollPaneabckm.setBounds(0, 30, 370, 320);
        jLayeredPane9.add(ScrollPaneabckm, javax.swing.JLayeredPane.DEFAULT_LAYER);
        progabckm.setBounds(0, 360, 370, 20);
        jLayeredPane9.add(progabckm, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnmulaiabckm.setText("MULAI");
        btnmulaiabckm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmulaiabckmActionPerformed(evt);
            }
        });
        btnmulaiabckm.setBounds(0, 390, 180, 30);
        jLayeredPane9.add(btnmulaiabckm, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnbersihkanabckm.setText("BERSIHKAN");
        btnbersihkanabckm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbersihkanabckmActionPerformed(evt);
            }
        });
        btnbersihkanabckm.setBounds(180, 390, 190, 30);
        jLayeredPane9.add(btnbersihkanabckm, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtpenjelasanabckm.setColumns(20);
        txtpenjelasanabckm.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txtpenjelasanabckm.setRows(5);
        txtpenjelasanabckm.setText("- ABC-KM\nMetode Artificial Bee Colony (ABC) pertama kali diperkenalkan oleh Karaboga pada tahun 2005. \nMetode ini terinspirasi dari perilaku alami lebah madu dalam proses mendapatkan sumber \nmakanan dengan mengetahui kualitas dan lokasi lebah madu[11]. Dalam model metode ABC ini, \nkoloni lebah tiruan terdiri dari tiga kelompok lebah yaitu : lebah pekerja (employee bee), \nlebah penunggu (onlooker) dan lebah scout (penjelajah).\n\nDalam model metode ABC ini, ada tiga jenis artificial bee dalam koloni lebah yang digunakan \nyaitu lebah pekerja (employed bee), lebah penunggu (onlooker) dan lebah pengintai (scout). \nSetengah jumlah koloni terdiri atas lebah pekerja dan setengahnya adalah lebah penunggu.\n\nMetode ABC-KM dihasilkan melalui hibridasi anatara metode Artificial Bee Colony dan metode \nbasic K-Means Clustering. Seperti yang telah dipaparkan pada bagian pendahuluan bahwa hal \nyang mendasari dilakukan hibridasi ini adalah menitik beratkan pada masih terdapatnya \nkelemahan pada metode K-Means untuk menangani permasalahan konvergensi terhadap lokal \noptimal. Kelemahan ini muncul akibat inisialisasi titik pusat klaster awal yang dilakukan \nsecara random sehingga untuk dapat mengatasi permasalahan inisialisasi ini diperlukan sebuah \nmetode yang memiliki karakteristik pencarian solusi global optimal.\n");
        ScrollPanepenjelasanabckm.setViewportView(txtpenjelasanabckm);

        ScrollPanepenjelasanabckm.setBounds(430, 30, 810, 360);
        jLayeredPane9.add(ScrollPanepenjelasanabckm, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panelabckmLayout = new javax.swing.GroupLayout(panelabckm);
        panelabckm.setLayout(panelabckmLayout);
        panelabckmLayout.setHorizontalGroup(
            panelabckmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 1275, Short.MAX_VALUE)
        );
        panelabckmLayout.setVerticalGroup(
            panelabckmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
        );

        Aksiklaster.addTab("ABC-KM", panelabckm);

        Aksiklaster.setBounds(40, 130, 1280, 450);
        jLayeredPane1.add(Aksiklaster, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lblinfo.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblinfo.setBounds(600, 190, 190, 40);
        jLayeredPane1.add(lblinfo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        progressBar.setBounds(530, 310, 310, 30);
        jLayeredPane1.add(progressBar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lblusername.setFont(new java.awt.Font("Showcard Gothic", 0, 11)); // NOI18N
        lblusername.setForeground(new java.awt.Color(255, 255, 255));
        lblusername.setText("Username");
        lblusername.setBounds(530, 300, 90, 20);
        jLayeredPane1.add(lblusername, javax.swing.JLayeredPane.DEFAULT_LAYER);
        txtusername.setBounds(630, 290, 210, 30);
        jLayeredPane1.add(txtusername, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lblpassword.setFont(new java.awt.Font("Showcard Gothic", 0, 11)); // NOI18N
        lblpassword.setForeground(new java.awt.Color(255, 255, 255));
        lblpassword.setText("Password");
        lblpassword.setBounds(530, 340, 90, 15);
        jLayeredPane1.add(lblpassword, javax.swing.JLayeredPane.DEFAULT_LAYER);
        txtpassword.setBounds(630, 330, 210, 30);
        jLayeredPane1.add(txtpassword, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnlogin.setText("Masuk");
        btnlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloginActionPerformed(evt);
            }
        });
        btnlogin.setBounds(770, 370, 70, 30);
        jLayeredPane1.add(btnlogin, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbllogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/log.png"))); // NOI18N
        lbllogin.setBounds(510, 220, 350, 210);
        jLayeredPane1.add(lbllogin, javax.swing.JLayeredPane.DEFAULT_LAYER);

        scrollbuku.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        tablebuku.setFont(new java.awt.Font("Traditional Arabic", 1, 12)); // NOI18N
        tablebuku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scrollbuku.setViewportView(tablebuku);

        scrollbuku.setBounds(40, 130, 1280, 450);
        jLayeredPane1.add(scrollbuku, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtcase.setColumns(20);
        txtcase.setRows(5);
        ScrollPanecase.setViewportView(txtcase);

        ScrollPanecase.setBounds(0, 0, 370, 350);
        jLayeredPane2.add(ScrollPanecase, javax.swing.JLayeredPane.DEFAULT_LAYER);
        progcase.setBounds(0, 360, 370, 20);
        jLayeredPane2.add(progcase, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnmulaicase.setText("MULAI");
        btnmulaicase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmulaicaseActionPerformed(evt);
            }
        });
        btnmulaicase.setBounds(0, 390, 180, 30);
        jLayeredPane2.add(btnmulaicase, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnbersihkancase.setText("BERSIHKAN");
        btnbersihkancase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbersihkancaseActionPerformed(evt);
            }
        });
        btnbersihkancase.setBounds(180, 390, 190, 30);
        jLayeredPane2.add(btnbersihkancase, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtpenjelasancase.setColumns(20);
        txtpenjelasancase.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txtpenjelasancase.setRows(5);
        txtpenjelasancase.setText("- Casefolding\nCase folding adalah mengubah semua huruf dalam dokumen menjadi huruf kecil.\nHanya huruf ‘a’ sampai dengan ‘z’ yang diterima.\nKarakter selain huruf dihilangkan dan dianggap delimiter.\nSetelah melewati tahapan ini, maka data yang tersisa adalah kumpulan kata yang hanya\ndipisahkan oleh spasi.\n\n- Tokenizing\nTokenizing atau sering juga di sebut parsing adalah sebuah proses yang dilakukan oleh\nseseorang untuk menjadikan sebuah kalimat menjadi lebih bermakna dengan cara memecah \nkalimat tersebut menjadi kata-kata atau frase-frase. Parsing di dalam pembuatan \naplikasi text mining ini merupakan proses penguraian deskripsi yang semula berupa \nkalimat-kalimat berisi kata-kata dan tanda pemisah antara kata menjadi kata-kata saja \nbaik itu berupa kata-kata penting maupun kata-kata tidak penting.");
        ScrollPanepenjelasancase.setViewportView(txtpenjelasancase);

        ScrollPanepenjelasancase.setBounds(430, 30, 810, 360);
        jLayeredPane2.add(ScrollPanepenjelasancase, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panelcaseLayout = new javax.swing.GroupLayout(panelcase);
        panelcase.setLayout(panelcaseLayout);
        panelcaseLayout.setHorizontalGroup(
            panelcaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1275, Short.MAX_VALUE)
        );
        panelcaseLayout.setVerticalGroup(
            panelcaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
        );

        AksiTextMining.addTab("Case Folding & Tokenizing", panelcase);

        txtfiltering.setColumns(20);
        txtfiltering.setRows(5);
        ScrollPanefiltering.setViewportView(txtfiltering);

        ScrollPanefiltering.setBounds(0, 0, 370, 350);
        jLayeredPane3.add(ScrollPanefiltering, javax.swing.JLayeredPane.DEFAULT_LAYER);
        progfiltering.setBounds(0, 360, 370, 20);
        jLayeredPane3.add(progfiltering, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnmulaifiltering.setText("MULAI");
        btnmulaifiltering.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmulaifilteringActionPerformed(evt);
            }
        });
        btnmulaifiltering.setBounds(0, 390, 180, 30);
        jLayeredPane3.add(btnmulaifiltering, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnbersihkanfiltering.setText("BERSIHKAN");
        btnbersihkanfiltering.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbersihkanfilteringActionPerformed(evt);
            }
        });
        btnbersihkanfiltering.setBounds(180, 390, 190, 30);
        jLayeredPane3.add(btnbersihkanfiltering, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtpenjelasanfiltering.setColumns(20);
        txtpenjelasanfiltering.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txtpenjelasanfiltering.setRows(5);
        txtpenjelasanfiltering.setText("- Filtering\nKebanyakan bahasa resmi di berbagai Negara memiliki kata kunci dan kata sambung seperti \nartikel dan preposisi yang hampir selalu muncul pada dokumen-dokumen text. \nBiasanya kata-kata ini memiliki arti yang lebih dalam demi memenuhi kebutuhan sorang \npencari untuk mendapatkan informasi. Kata-kata tersebut (misalnya a, an, the on pada \nbahasa Inggris) disebut sebagai stopwords. Di dalam bahasa Indonesia, stopwords dapat \ndisebut sebagai kata tidak penting misalnya “di”, “oleh”, “pada”, “sebuah”, “karena”. \nSebelum proses stopwords removal dilakukan terlebih dahulu dibuat daftar stopwords (stoplist).\n\nStopwords removal merupakan proses penghilangan kata tidak penting pada deskripsi melalui \npengecekan kata-kata hasil tokenizing. Pengecekan dilakukan dengan mencari deskripsi, \napakah termasuk kata di dalam daftar kata tidak penting (stoplist) atau tidak. \nJika termasuk dalam daftar kata tidak penting maka kata-kata tersebut akan di-remove \ndari deskripsi, sehingga kata-kata yang tersisa di dalam deskripsi dianggap sebagai \nkata-kata penting atau keywords");
        ScrollPanepenjelasanfiltering.setViewportView(txtpenjelasanfiltering);

        ScrollPanepenjelasanfiltering.setBounds(430, 30, 810, 360);
        jLayeredPane3.add(ScrollPanepenjelasanfiltering, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panelfilteringLayout = new javax.swing.GroupLayout(panelfiltering);
        panelfiltering.setLayout(panelfilteringLayout);
        panelfilteringLayout.setHorizontalGroup(
            panelfilteringLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1275, Short.MAX_VALUE)
        );
        panelfilteringLayout.setVerticalGroup(
            panelfilteringLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
        );

        AksiTextMining.addTab("Filtering", panelfiltering);

        txtstemming.setColumns(20);
        txtstemming.setRows(5);
        ScrollPanestemming.setViewportView(txtstemming);

        ScrollPanestemming.setBounds(0, 0, 370, 350);
        jLayeredPane4.add(ScrollPanestemming, javax.swing.JLayeredPane.DEFAULT_LAYER);
        progstemming.setBounds(0, 360, 370, 20);
        jLayeredPane4.add(progstemming, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnmulaistemming.setText("MULAI");
        btnmulaistemming.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmulaistemmingActionPerformed(evt);
            }
        });
        btnmulaistemming.setBounds(0, 390, 180, 30);
        jLayeredPane4.add(btnmulaistemming, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnbersihkanstemming.setText("BERSIHKAN");
        btnbersihkanstemming.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbersihkanstemmingActionPerformed(evt);
            }
        });
        btnbersihkanstemming.setBounds(180, 390, 190, 30);
        jLayeredPane4.add(btnbersihkanstemming, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtpenjelasanstemming.setColumns(20);
        txtpenjelasanstemming.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txtpenjelasanstemming.setRows(5);
        txtpenjelasanstemming.setText("- Stemming\nStemming adalah proses pemetaan dan penguraian berbagai bentuk (variant) dari suatu kata \nmenjadi kata dasarnya (term). Proses ini juga disebut sebagai conflation. \nProses stemming secara luas sudah digunakan di dalam Information Retrrieval \n(temu kembali informasi) untuk meningkatkan kualitas informasi yang didapatkan. \nKualitas informasi yang dimaksud misalnya untuk mendapatkan hubungan antara variant \nkata yang satu dengan yang lainnya. Sebagai contoh kata “dibawa”, “membawa” \n(melakukan tindakan membawa) dan “pembawa” (orang yang membawa) yang semula mengandung \narti berbeda dapat di-stem menjadi sebuah kata “bawa” yang memiliki arti yang sama \nsehingga kata-kata diatas saling berhubungan.\n\nSelain itu, stemming juga dapat digunakan untuk mengurangi ukuran dari suatu ukuran \nindex file. Misalnya dalam suatu deskripsi terdapat variant kata “merasakan”, \n“dirasakan”, “merasa” dan “dirasa” hanya memiliki akar kata (stem) yaitu “rasa”. \nUkuran file daftar index yang semula berjumlah empat record di-reduce sehingga \nmenjadi satu record saja. \n");
        ScrollPanepenjelasanstemming.setViewportView(txtpenjelasanstemming);

        ScrollPanepenjelasanstemming.setBounds(430, 30, 810, 360);
        jLayeredPane4.add(ScrollPanepenjelasanstemming, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panelstemmingLayout = new javax.swing.GroupLayout(panelstemming);
        panelstemming.setLayout(panelstemmingLayout);
        panelstemmingLayout.setHorizontalGroup(
            panelstemmingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1275, Short.MAX_VALUE)
        );
        panelstemmingLayout.setVerticalGroup(
            panelstemmingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
        );

        AksiTextMining.addTab("Stemming", panelstemming);

        AksiTextMining.setBounds(40, 130, 1280, 450);
        jLayeredPane1.add(AksiTextMining, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txttf.setColumns(20);
        txttf.setRows(5);
        ScrollPanetf.setViewportView(txttf);

        ScrollPanetf.setBounds(0, 0, 370, 350);
        jLayeredPane5.add(ScrollPanetf, javax.swing.JLayeredPane.DEFAULT_LAYER);
        progtf.setBounds(0, 360, 370, 20);
        jLayeredPane5.add(progtf, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnmulaitf.setText("MULAI");
        btnmulaitf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmulaitfActionPerformed(evt);
            }
        });
        btnmulaitf.setBounds(0, 390, 180, 30);
        jLayeredPane5.add(btnmulaitf, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnbersihkantf.setText("BERSIHKAN");
        btnbersihkantf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbersihkantfActionPerformed(evt);
            }
        });
        btnbersihkantf.setBounds(180, 390, 190, 30);
        jLayeredPane5.add(btnbersihkantf, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtpenjelasantf.setColumns(20);
        txtpenjelasantf.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txtpenjelasantf.setRows(5);
        txtpenjelasantf.setText("- Term Frequency (TF)\nDalam perhitungan bobot menggunakan TF-IDF, nilai TF dihitung perkata dengan bobot \nmasing-masing kata adalah 1.");
        ScrollPanepenjelasantf.setViewportView(txtpenjelasantf);

        ScrollPanepenjelasantf.setBounds(430, 30, 810, 360);
        jLayeredPane5.add(ScrollPanepenjelasantf, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout paneltfLayout = new javax.swing.GroupLayout(paneltf);
        paneltf.setLayout(paneltfLayout);
        paneltfLayout.setHorizontalGroup(
            paneltfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1275, Short.MAX_VALUE)
        );
        paneltfLayout.setVerticalGroup(
            paneltfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
        );

        AksiTFIDF.addTab("TF", paneltf);

        txtidf.setColumns(20);
        txtidf.setRows(5);
        ScrollPaneidf.setViewportView(txtidf);

        ScrollPaneidf.setBounds(0, 0, 370, 350);
        jLayeredPane6.add(ScrollPaneidf, javax.swing.JLayeredPane.DEFAULT_LAYER);
        progidf.setBounds(0, 360, 370, 20);
        jLayeredPane6.add(progidf, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnmulaiidf.setText("MULAI");
        btnmulaiidf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmulaiidfActionPerformed(evt);
            }
        });
        btnmulaiidf.setBounds(0, 390, 180, 30);
        jLayeredPane6.add(btnmulaiidf, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnbersihkanidf.setText("BERSIHKAN");
        btnbersihkanidf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbersihkanidfActionPerformed(evt);
            }
        });
        btnbersihkanidf.setBounds(180, 390, 190, 30);
        jLayeredPane6.add(btnbersihkanidf, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtpenjelasanidf.setColumns(20);
        txtpenjelasanidf.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txtpenjelasanidf.setRows(5);
        txtpenjelasanidf.setText("- Invers Document Frequency (IDF)\nIDF, dihasilkan dari persamaan berikut ini:\n\nIDF(word)=log td/df\n\ndimana IDF(word) adalah nilai IDF dari setiap kata yang akan dicari, td adalah jumlah \nkeseluruhan dokumen yang ada dan df adalah jumlah kemunculan kata pada semua dokumen.\n\nSetelah mendapat bobot dari masing-masing TF dan IDF, maka untuk mendapatkan bobot akhir \ndari TF-IDF bobot tersebut digabungkan seperti pada persamaan berikut ini:\n\nw(word_i)=TF(word_i)X(IDF)\n\ndimana w(word_i) adalah nilai bobot dari setiap kata, TF(word_i) adalah hasil perhitungan \ndari TF dan IDF adalah hasil perhitungan dari IDF.\n");
        ScrollPanepenjelasanidf.setViewportView(txtpenjelasanidf);

        ScrollPanepenjelasanidf.setBounds(430, 30, 810, 360);
        jLayeredPane6.add(ScrollPanepenjelasanidf, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panelidfLayout = new javax.swing.GroupLayout(panelidf);
        panelidf.setLayout(panelidfLayout);
        panelidfLayout.setHorizontalGroup(
            panelidfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1275, Short.MAX_VALUE)
        );
        panelidfLayout.setVerticalGroup(
            panelidfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
        );

        AksiTFIDF.addTab("IDF", panelidf);

        txtnormalisasi.setColumns(20);
        txtnormalisasi.setRows(5);
        ScrollPanenormalisasi.setViewportView(txtnormalisasi);

        ScrollPanenormalisasi.setBounds(0, 0, 370, 350);
        jLayeredPane7.add(ScrollPanenormalisasi, javax.swing.JLayeredPane.DEFAULT_LAYER);
        prognormalisasi.setBounds(0, 360, 370, 20);
        jLayeredPane7.add(prognormalisasi, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnmulainormalisasi.setText("MULAI");
        btnmulainormalisasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmulainormalisasiActionPerformed(evt);
            }
        });
        btnmulainormalisasi.setBounds(0, 390, 180, 30);
        jLayeredPane7.add(btnmulainormalisasi, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnbersihkannormalisasi.setText("BERSIHKAN");
        btnbersihkannormalisasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbersihkannormalisasiActionPerformed(evt);
            }
        });
        btnbersihkannormalisasi.setBounds(180, 390, 190, 30);
        jLayeredPane7.add(btnbersihkannormalisasi, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtpenjelasannormalisasi.setColumns(20);
        txtpenjelasannormalisasi.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txtpenjelasannormalisasi.setRows(5);
        txtpenjelasannormalisasi.setText("- Normalisasi\nNormalisasi dilakukan untuk mendapat nilai bobot terbaik di dalam setiap kata pada TF-IDF. \nUntuk menormalisasi kata pada setiap dokumen, dapat dilakukan dengan menggunakan persamaan \nberikut ini:\n\nw(word)=(w(word))/√(w^2 (word_1)+w^2 (word_2 )+...+w^2 (word_n))\n\ndimana w(word_i) merupakan nilai bobot dari setiap kata. \nNormalisasi dilakukan dengan menghitung satu kata dan di normalkan dengan semua kata pada \nsatu dokumen.\n");
        ScrollPanepenjelasannormalisasi.setViewportView(txtpenjelasannormalisasi);

        ScrollPanepenjelasannormalisasi.setBounds(430, 30, 810, 360);
        jLayeredPane7.add(ScrollPanepenjelasannormalisasi, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panelnolmalisasiLayout = new javax.swing.GroupLayout(panelnolmalisasi);
        panelnolmalisasi.setLayout(panelnolmalisasiLayout);
        panelnolmalisasiLayout.setHorizontalGroup(
            panelnolmalisasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 1275, Short.MAX_VALUE)
        );
        panelnolmalisasiLayout.setVerticalGroup(
            panelnolmalisasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
        );

        AksiTFIDF.addTab("Normalisasi", panelnolmalisasi);

        AksiTFIDF.setBounds(40, 130, 1280, 450);
        jLayeredPane1.add(AksiTFIDF, javax.swing.JLayeredPane.DEFAULT_LAYER);

        bground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bg1.png"))); // NOI18N
        bground.setBounds(0, 0, 1370, 690);
        jLayeredPane1.add(bground, javax.swing.JLayeredPane.DEFAULT_LAYER);

        file.setText("File");

        login.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/user-icon.png"))); // NOI18N
        login.setText("Login");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        file.add(login);

        logout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/user-icon.png"))); // NOI18N
        logout.setText("Logout");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        file.add(logout);
        file.add(jSeparator2);

        lihatbuku.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        lihatbuku.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Folder-Data-icon.png"))); // NOI18N
        lihatbuku.setText("Lihat Buku");
        lihatbuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lihatbukuActionPerformed(evt);
            }
        });
        file.add(lihatbuku);

        lihatklaster.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/database-icon.png"))); // NOI18N
        lihatklaster.setText("Lihat Klaster");

        basickmeans.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/database-icon.png"))); // NOI18N
        basickmeans.setText("Basic K-Means");
        basickmeans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                basickmeansActionPerformed(evt);
            }
        });
        lihatklaster.add(basickmeans);

        abckmeans.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/database-icon.png"))); // NOI18N
        abckmeans.setText("Artificial Bee Colony K-Means");
        abckmeans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abckmeansActionPerformed(evt);
            }
        });
        lihatklaster.add(abckmeans);

        file.add(lihatklaster);
        file.add(jSeparator1);

        keluar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        keluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/power-icon.png"))); // NOI18N
        keluar.setText("Tutup");
        keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarActionPerformed(evt);
            }
        });
        file.add(keluar);

        jMenuBar1.add(file);

        preprocesing.setText("Pre Procesing");

        textmining.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        textmining.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/folder-live-data-icon.png"))); // NOI18N
        textmining.setText("Text Mining");
        textmining.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textminingActionPerformed(evt);
            }
        });
        preprocesing.add(textmining);

        tfidf.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        tfidf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Folder-Live-Data-icon1.png"))); // NOI18N
        tfidf.setText("TF-IDF");
        tfidf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfidfActionPerformed(evt);
            }
        });
        preprocesing.add(tfidf);

        jMenuBar1.add(preprocesing);

        klaster.setText("Klaster");

        sentroidawal.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        sentroidawal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/database-icon1.png"))); // NOI18N
        sentroidawal.setText("Atur Sentroid Awal");
        sentroidawal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sentroidawalActionPerformed(evt);
            }
        });
        klaster.add(sentroidawal);
        klaster.add(jSeparator3);

        mulaiklaster.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        mulaiklaster.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/database-development-icon.png"))); // NOI18N
        mulaiklaster.setText("Mulai Klaster");
        mulaiklaster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mulaiklasterActionPerformed(evt);
            }
        });
        klaster.add(mulaiklaster);

        kmeansuji.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        kmeansuji.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/database-development-icon.png"))); // NOI18N
        kmeansuji.setText("Basic K-Mans");
        kmeansuji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kmeansujiActionPerformed(evt);
            }
        });
        klaster.add(kmeansuji);

        abckmuji.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        abckmuji.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/database-development-icon.png"))); // NOI18N
        abckmuji.setText("ABC K-Means");
        abckmuji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abckmujiActionPerformed(evt);
            }
        });
        klaster.add(abckmuji);

        jMenuBar1.add(klaster);

        pengujian.setText("Pengujian");

        precision.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        precision.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/database-icon.png"))); // NOI18N
        precision.setText("Precision");
        precision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precisionActionPerformed(evt);
            }
        });
        pengujian.add(precision);

        recall.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        recall.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/database-icon.png"))); // NOI18N
        recall.setText("Recall");
        recall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recallActionPerformed(evt);
            }
        });
        pengujian.add(recall);

        fmeasure.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        fmeasure.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/database-icon.png"))); // NOI18N
        fmeasure.setText("F-Measure");
        fmeasure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fmeasureActionPerformed(evt);
            }
        });
        pengujian.add(fmeasure);

        waktu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        waktu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/database-icon.png"))); // NOI18N
        waktu.setText("Waktu");
        waktu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                waktuActionPerformed(evt);
            }
        });
        pengujian.add(waktu);

        jMenuBar1.add(pengujian);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1370, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_keluarActionPerformed

    private void lihatbukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lihatbukuActionPerformed
        tablebuku.setVisible(true);
        scrollbuku.setVisible(true);
        
        lblusername.setVisible(false);
        txtusername.setVisible(false);
        lblpassword.setVisible(false);
        txtpassword.setVisible(false);
        btnlogin.setVisible(false);
        lbllogin.setVisible(false);
        AksiTextMining.setVisible(false);
        AksiTFIDF.setVisible(false);
        Aksiklaster.setVisible(false);
        progressBar.setVisible(false);
        lblinfo.setVisible(false);
        DefaultTableModel isitable = new DefaultTableModel();
        isitable.addColumn("Nomor");
        isitable.addColumn("Judul Buku");
        isitable.addColumn("Pengarang Buku");
        isitable.addColumn("Penerbit Buku");
        isitable.addColumn("Tahun Buku");
        isitable.addColumn("Sinopsis Buku");
        try {
            database.con=DriverManager.getConnection(database.url+database.db, "root", "");
            Statement st = database.con.createStatement();
            String sql ="SELECT * FROM data_buku";
            ResultSet kl = st.executeQuery(sql);
            while(kl.next()){
                isitable.addRow(new Object[]{
                    kl.getString(1),kl.getString(2),
                    kl.getString(3),kl.getString(4),
                    kl.getString(5),kl.getString(6)});
            }
            tablebuku.setModel(isitable);
        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Error : "+x,"Warning",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_lihatbukuActionPerformed

    private void tfidfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfidfActionPerformed
        tablebuku.setVisible(false);
        scrollbuku.setVisible(false);
        AksiTFIDF.setVisible(true);
        lblusername.setVisible(false);
        txtusername.setVisible(false);
        lblpassword.setVisible(false);
        txtpassword.setVisible(false);
        lbllogin.setVisible(false);
        AksiTextMining.setVisible(false);
        Aksiklaster.setVisible(false);
        txtpenjelasantf.setEditable(false);
        txtpenjelasanidf.setEditable(false);
        txtpenjelasannormalisasi.setEditable(false);
        progtf.setVisible(false);
        progidf.setVisible(false);
        prognormalisasi.setVisible(false);
        progressBar.setVisible(false);
        lblinfo.setVisible(false);
    }//GEN-LAST:event_tfidfActionPerformed

    private void textminingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textminingActionPerformed
        tablebuku.setVisible(false);
        scrollbuku.setVisible(false);
        lblusername.setVisible(false);
        txtusername.setVisible(false);
        lblpassword.setVisible(false);
        txtpassword.setVisible(false);
        btnlogin.setVisible(false);
        lbllogin.setVisible(false);
        AksiTextMining.setVisible(true);
        txtpenjelasancase.setEditable(false);
        txtpenjelasanfiltering.setEditable(false);
        txtpenjelasanstemming.setEditable(false);
        AksiTFIDF.setVisible(false);
        Aksiklaster.setVisible(false);
        progcase.setVisible(false);
        progfiltering.setVisible(false);
        progstemming.setVisible(false);
        progressBar.setVisible(false);
        lblinfo.setVisible(false);
    }//GEN-LAST:event_textminingActionPerformed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        tablebuku.setVisible(false);
        scrollbuku.setVisible(false);
        AksiTextMining.setVisible(false);
        AksiTFIDF.setVisible(false);
        Aksiklaster.setVisible(false);
        lblusername.setVisible(true);
        txtusername.setVisible(true);
        lblpassword.setVisible(true);
        txtpassword.setVisible(true);
        btnlogin.setVisible(true);
        lbllogin.setVisible(true);
        progressBar.setVisible(false);
        lblinfo.setVisible(false);
    }//GEN-LAST:event_loginActionPerformed

    private void btnloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloginActionPerformed
        //login admin
        tablebuku.setVisible(false);
        scrollbuku.setVisible(false);
        lblusername.setVisible(false);
        txtusername.setVisible(false);
        lblpassword.setVisible(false);
        txtpassword.setVisible(false);
        btnlogin.setVisible(false);
        lbllogin.setVisible(false);
        
        preprocesing.setEnabled(false);
        klaster.setEnabled(false);
        logout.setVisible(false);
        lihatbuku.setEnabled(false);
        lihatklaster.setEnabled(false);
        AksiTextMining.setVisible(false);
        AksiTFIDF.setVisible(false);
        Aksiklaster.setVisible(false);
        progressBar.setVisible(true);
        lblinfo.setVisible(false);
        Task task = new Task();                
        task.start();
    }//GEN-LAST:event_btnloginActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        tablebuku.setVisible(false);
        scrollbuku.setVisible(false);
        lblusername.setVisible(true);
        txtusername.setVisible(true);
        lblpassword.setVisible(true);
        txtpassword.setVisible(true);
        btnlogin.setVisible(true);
        lbllogin.setVisible(true);
        preprocesing.setEnabled(false);
        klaster.setEnabled(false);
        logout.setVisible(false);
        lihatbuku.setEnabled(false);
        lihatklaster.setEnabled(false);
        AksiTextMining.setVisible(false);
        Aksiklaster.setVisible(false);
        login.setVisible(true);
        AksiTFIDF.setVisible(false);
        progressBar.setVisible(false);
        lblinfo.setVisible(false);
        pengujian.setEnabled(false);
        txtusername.setText("");
        txtpassword.setText("");
    }//GEN-LAST:event_logoutActionPerformed
        
    private void kmeansujiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kmeansujiActionPerformed
        tablebuku.setVisible(false);
        scrollbuku.setVisible(false);
        lblusername.setVisible(false);
        txtusername.setVisible(false);
        lblpassword.setVisible(false);
        txtpassword.setVisible(false);
        btnlogin.setVisible(false);
        lbllogin.setVisible(false);
        AksiTextMining.setVisible(false);
        AksiTFIDF.setVisible(false);
        Aksiklaster.setVisible(false);
        progressBar.setVisible(false);
        lblinfo.setVisible(false);
        //Panggil K-Means
        new K_Means();
    }//GEN-LAST:event_kmeansujiActionPerformed

    private void abckmujiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abckmujiActionPerformed
        tablebuku.setVisible(false);
        scrollbuku.setVisible(false);
        lblusername.setVisible(false);
        txtusername.setVisible(false);
        lblpassword.setVisible(false);
        txtpassword.setVisible(false);
        btnlogin.setVisible(false);
        lbllogin.setVisible(false);
        AksiTextMining.setVisible(false);
        AksiTFIDF.setVisible(false);
        Aksiklaster.setVisible(false);
        progressBar.setVisible(false);
        lblinfo.setVisible(false);
        //Panggil ABC-KM
        new ABC_K_Means();
    }//GEN-LAST:event_abckmujiActionPerformed

    private void basickmeansActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_basickmeansActionPerformed
        tablebuku.setVisible(true);
        scrollbuku.setVisible(true);
        AksiTextMining.setVisible(false);
        Aksiklaster.setVisible(false);
        lblusername.setVisible(false);
        txtusername.setVisible(false);
        lblpassword.setVisible(false);
        txtpassword.setVisible(false);
        lbllogin.setVisible(false);
        AksiTFIDF.setVisible(false);
        progressBar.setVisible(false);
        lblinfo.setVisible(false);
        //Tampilkan Data Klaster Buku Pada Klasterisasi K-Means
        DefaultTableModel isitable = new DefaultTableModel();
        isitable.addColumn("Nomor");
        isitable.addColumn("Judul Buku");
        isitable.addColumn("Pengarang Buku");
        isitable.addColumn("Penerbit Buku");
        isitable.addColumn("Tahun Buku");
        isitable.addColumn("Sinopsis Buku");
        isitable.addColumn("Klaster");
        try {
            database.con=DriverManager.getConnection(database.url+database.db, "root", "");
            Statement st = database.con.createStatement();
            String sql ="SELECT id_klaster, judul_buku, pengarang_buku, penerbit_buku, tahun_buku, isi_buku, kmklaster_baru.klaster FROM data_buku, kmklaster_baru WHERE data_buku.id_data_buku=kmklaster_baru.id_data_buku";
            ResultSet kl = st.executeQuery(sql);
            while(kl.next()){
                isitable.addRow(new Object[]{
                    kl.getString(1),kl.getString(2),
                    kl.getString(3),kl.getString(4),
                    kl.getString(5),kl.getString(6),
                    kl.getString(7)});
            }
            tablebuku.setModel(isitable);
        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Error : "+x,"Warning",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_basickmeansActionPerformed

    private void abckmeansActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abckmeansActionPerformed
        tablebuku.setVisible(true);
        scrollbuku.setVisible(true);
        AksiTextMining.setVisible(false);
        lblusername.setVisible(false);
        txtusername.setVisible(false);
        lblpassword.setVisible(false);
        txtpassword.setVisible(false);
        btnlogin.setVisible(false);
        Aksiklaster.setVisible(false);
        lbllogin.setVisible(false);
        AksiTFIDF.setVisible(false);
        progressBar.setVisible(false);
        lblinfo.setVisible(false);
        //Tampilkan Data Buku Pada Klasterisasi ABC-KM
        DefaultTableModel isitable = new DefaultTableModel();
        isitable.addColumn("Nomor");
        isitable.addColumn("Judul Buku");
        isitable.addColumn("Pengarang Buku");
        isitable.addColumn("Penerbit Buku");
        isitable.addColumn("Tahun Buku");
        isitable.addColumn("Sinopsis Buku");
        isitable.addColumn("Klaster");
        try {
            database.con=DriverManager.getConnection(database.url+database.db, "root", "");
            Statement st = database.con.createStatement();
            String sql ="SELECT id_klaster_abc, judul_buku, pengarang_buku, penerbit_buku, tahun_buku, isi_buku, klaster_abc FROM data_buku, abcklaster_baru WHERE data_buku.id_data_buku=abcklaster_baru.id_data_buku";
            ResultSet kl = st.executeQuery(sql);
            while(kl.next()){
                isitable.addRow(new Object[]{
                    kl.getString(1),kl.getString(2),
                    kl.getString(3),kl.getString(4),
                    kl.getString(5),kl.getString(6),
                    kl.getString(7)});
            }
            tablebuku.setModel(isitable);
        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Error : "+x,"Warning",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_abckmeansActionPerformed
    
    private void sentroidawalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sentroidawalActionPerformed
        tablebuku.setVisible(false);
        scrollbuku.setVisible(false);
        lblusername.setVisible(false);
        txtusername.setVisible(false);
        lblpassword.setVisible(false);
        txtpassword.setVisible(false);
        btnlogin.setVisible(false);
        lbllogin.setVisible(false);
        Aksiklaster.setVisible(false);
        AksiTextMining.setVisible(false);
        AksiTFIDF.setVisible(false);
        progressBar.setVisible(false);
        lblinfo.setVisible(false);
        //panggil sentroid awal
        new Sentroid_Awal();
    }//GEN-LAST:event_sentroidawalActionPerformed
        
    private WorkerLoopCaseToken workerLoopCaseToken;
    private void btnmulaicaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmulaicaseActionPerformed
        progcase.setVisible(true);
        progfiltering.setVisible(false);
        progstemming.setVisible(false);
        
        txt_min.HapusTextMining();
        txtfiltering.setText("");
        progcase.setIndeterminate(true);
        workerLoopCaseToken = new WorkerLoopCaseToken();
        workerLoopCaseToken.execute();
    }//GEN-LAST:event_btnmulaicaseActionPerformed

    private void btnbersihkancaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbersihkancaseActionPerformed
        txtcase.setText("");
    }//GEN-LAST:event_btnbersihkancaseActionPerformed
    
    private WorkerLoopFiltering workerLoopFiltering;
    private void btnmulaifilteringActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmulaifilteringActionPerformed
        progcase.setVisible(false);
        progfiltering.setVisible(true);
        progstemming.setVisible(false);
        txtfiltering.setText("Kata Tidak Penting");
        progfiltering.setIndeterminate(true);
        workerLoopFiltering = new WorkerLoopFiltering();
        workerLoopFiltering.execute();
    }//GEN-LAST:event_btnmulaifilteringActionPerformed

    private void btnbersihkanfilteringActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbersihkanfilteringActionPerformed
        txtfiltering.setText("");
    }//GEN-LAST:event_btnbersihkanfilteringActionPerformed

    private WorkerLoopStemming workerLoopStemming;
    private void btnmulaistemmingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmulaistemmingActionPerformed
        progcase.setVisible(false);
        progfiltering.setVisible(false);
        progstemming.setVisible(true);
        txtstemming.setText("Hasil Stemming");
        progstemming.setIndeterminate(true);
        workerLoopStemming = new WorkerLoopStemming();
        workerLoopStemming.execute();
    }//GEN-LAST:event_btnmulaistemmingActionPerformed

    private void btnbersihkanstemmingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbersihkanstemmingActionPerformed
        txtstemming.setText("");
    }//GEN-LAST:event_btnbersihkanstemmingActionPerformed
    
    private WorkerLoopTF workerLoopTF;
    private void btnmulaitfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmulaitfActionPerformed
        tf_idf.TF();
        progtf.setVisible(true);
        progidf.setVisible(false);
        prognormalisasi.setVisible(false);
        txttf.setText("Kata | Dokumen | Bobot");
        progtf.setIndeterminate(true);
        workerLoopTF = new WorkerLoopTF();
        workerLoopTF.execute();
    }//GEN-LAST:event_btnmulaitfActionPerformed

    private void btnbersihkantfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbersihkantfActionPerformed
        txttf.setText("");
    }//GEN-LAST:event_btnbersihkantfActionPerformed

    private WorkerLoopIDF workerLoopIDF;
    private void btnmulaiidfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmulaiidfActionPerformed
        tf_idf.IDF();
        progtf.setVisible(false);
        progidf.setVisible(true);
        prognormalisasi.setVisible(false);
        txtidf.setText("kata | td | df | idf");
        progidf.setIndeterminate(true);
        workerLoopIDF = new WorkerLoopIDF();
        workerLoopIDF.execute();
    }//GEN-LAST:event_btnmulaiidfActionPerformed

    private void btnbersihkanidfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbersihkanidfActionPerformed
        txtidf.setText("");
    }//GEN-LAST:event_btnbersihkanidfActionPerformed

    private WorkerLoopNormalisasi workerLoopNormalisasi;
    private void btnmulainormalisasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmulainormalisasiActionPerformed
        tf_idf.Normalisasi();
        progtf.setVisible(false);
        progidf.setVisible(false);
        prognormalisasi.setVisible(true);
        txtnormalisasi.setText("kata | dokumen | bobot");
        prognormalisasi.setIndeterminate(true);
        workerLoopNormalisasi = new WorkerLoopNormalisasi();
        workerLoopNormalisasi.execute();
    }//GEN-LAST:event_btnmulainormalisasiActionPerformed

    private void btnbersihkannormalisasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbersihkannormalisasiActionPerformed
        txtnormalisasi.setText("");
    }//GEN-LAST:event_btnbersihkannormalisasiActionPerformed

    private void precisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precisionActionPerformed
        uji.Precision();
    }//GEN-LAST:event_precisionActionPerformed

    private void recallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recallActionPerformed
        uji.Recall();
    }//GEN-LAST:event_recallActionPerformed

    private void fmeasureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fmeasureActionPerformed
        uji.FMeasure();
    }//GEN-LAST:event_fmeasureActionPerformed

    private WorkerLoopKMeans workerLoopKmeans;
    private void btnmulaikmeansActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmulaikmeansActionPerformed
        progkmeans.setVisible(true);
        progabckm.setVisible(false);
        progkmeans.setIndeterminate(true);
        workerLoopKmeans = new WorkerLoopKMeans();
        workerLoopKmeans.execute();
        initMulai();
    }//GEN-LAST:event_btnmulaikmeansActionPerformed

    private void btnbersihkankmeansActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbersihkankmeansActionPerformed
        s=0; m=0; h=0;
        Time t = new Time();
        t.setDetik("00");
        t.setJam("00");
        t.setMenit("00");
        txtwaktukomputasikmeans.setText( t.getJam()+" : "+ t.getMenit()+" : " + t.getDetik());
    }//GEN-LAST:event_btnbersihkankmeansActionPerformed

    private void btnmulaiabckmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmulaiabckmActionPerformed
        initMulai();
    }//GEN-LAST:event_btnmulaiabckmActionPerformed

    private void btnbersihkanabckmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbersihkanabckmActionPerformed
        s=0; m=0; h=0;
        Time t = new Time();
        t.setDetik("00");
        t.setJam("00");
        t.setMenit("00");
        txtwaktukomputasiabckm.setText( t.getJam()+" : "+ t.getMenit()+" : " + t.getDetik());
    }//GEN-LAST:event_btnbersihkanabckmActionPerformed

    private void mulaiklasterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mulaiklasterActionPerformed
        tablebuku.setVisible(false);
        scrollbuku.setVisible(false);
        lblusername.setVisible(false);
        txtusername.setVisible(false);
        lblpassword.setVisible(false);
        txtpassword.setVisible(false);
        btnlogin.setVisible(false);
        lbllogin.setVisible(false);
        AksiTextMining.setVisible(false);
        txtpenjelasancase.setEnabled(false);
        txtpenjelasanfiltering.setEnabled(false);
        txtpenjelasanstemming.setEnabled(false);
        txtpenjelasanabckm.setEditable(false);
        txtpenjelasankmeans.setEditable(false);
        AksiTFIDF.setVisible(false);
        Aksiklaster.setVisible(true);
        progcase.setVisible(false);
        progfiltering.setVisible(false);
        progstemming.setVisible(false);
        progressBar.setVisible(false);
        lblinfo.setVisible(false);
    }//GEN-LAST:event_mulaiklasterActionPerformed

    private void waktuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_waktuActionPerformed
        uji.Waktu();
    }//GEN-LAST:event_waktuActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Klasterisasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Klasterisasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Klasterisasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Klasterisasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Klasterisasi().setVisible(true);
                
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane AksiTFIDF;
    private javax.swing.JTabbedPane AksiTextMining;
    private javax.swing.JTabbedPane Aksiklaster;
    private javax.swing.JScrollPane ScrollPaneabckm;
    private javax.swing.JScrollPane ScrollPanecase;
    private javax.swing.JScrollPane ScrollPanefiltering;
    private javax.swing.JScrollPane ScrollPaneidf;
    private javax.swing.JScrollPane ScrollPanekmeans;
    private javax.swing.JScrollPane ScrollPanenormalisasi;
    private javax.swing.JScrollPane ScrollPanepenjelasanabckm;
    private javax.swing.JScrollPane ScrollPanepenjelasancase;
    private javax.swing.JScrollPane ScrollPanepenjelasanfiltering;
    private javax.swing.JScrollPane ScrollPanepenjelasanidf;
    private javax.swing.JScrollPane ScrollPanepenjelasankmeans;
    private javax.swing.JScrollPane ScrollPanepenjelasannormalisasi;
    private javax.swing.JScrollPane ScrollPanepenjelasanstemming;
    private javax.swing.JScrollPane ScrollPanepenjelasantf;
    private javax.swing.JScrollPane ScrollPanestemming;
    private javax.swing.JScrollPane ScrollPanetf;
    private javax.swing.JMenuItem abckmeans;
    private javax.swing.JMenuItem abckmuji;
    private javax.swing.JMenuItem basickmeans;
    private javax.swing.JLabel bground;
    private javax.swing.JButton btnbersihkanabckm;
    private javax.swing.JButton btnbersihkancase;
    private javax.swing.JButton btnbersihkanfiltering;
    private javax.swing.JButton btnbersihkanidf;
    private javax.swing.JButton btnbersihkankmeans;
    private javax.swing.JButton btnbersihkannormalisasi;
    private javax.swing.JButton btnbersihkanstemming;
    private javax.swing.JButton btnbersihkantf;
    private javax.swing.JButton btnlogin;
    private javax.swing.JButton btnmulaiabckm;
    private javax.swing.JButton btnmulaicase;
    private javax.swing.JButton btnmulaifiltering;
    private javax.swing.JButton btnmulaiidf;
    private javax.swing.JButton btnmulaikmeans;
    private javax.swing.JButton btnmulainormalisasi;
    private javax.swing.JButton btnmulaistemming;
    private javax.swing.JButton btnmulaitf;
    private javax.swing.JMenu file;
    private javax.swing.JMenuItem fmeasure;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JLayeredPane jLayeredPane4;
    private javax.swing.JLayeredPane jLayeredPane5;
    private javax.swing.JLayeredPane jLayeredPane6;
    private javax.swing.JLayeredPane jLayeredPane7;
    private javax.swing.JLayeredPane jLayeredPane8;
    private javax.swing.JLayeredPane jLayeredPane9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JMenuItem keluar;
    private javax.swing.JMenu klaster;
    private javax.swing.JMenuItem kmeansuji;
    private javax.swing.JLabel lblinfo;
    private javax.swing.JLabel lblkompabckm;
    private javax.swing.JLabel lblkompkmeans;
    private javax.swing.JLabel lbllogin;
    private javax.swing.JLabel lblpassword;
    private javax.swing.JLabel lblusername;
    private javax.swing.JMenuItem lihatbuku;
    private javax.swing.JMenu lihatklaster;
    private javax.swing.JMenuItem login;
    private javax.swing.JMenuItem logout;
    private javax.swing.JMenuItem mulaiklaster;
    private javax.swing.JPanel panelKmeans;
    private javax.swing.JPanel panelabckm;
    private javax.swing.JPanel panelcase;
    private javax.swing.JPanel panelfiltering;
    private javax.swing.JPanel panelidf;
    private javax.swing.JPanel panelnolmalisasi;
    private javax.swing.JPanel panelstemming;
    private javax.swing.JPanel paneltf;
    private javax.swing.JMenu pengujian;
    private javax.swing.JMenuItem precision;
    private javax.swing.JMenu preprocesing;
    private javax.swing.JProgressBar progabckm;
    private javax.swing.JProgressBar progcase;
    private javax.swing.JProgressBar progfiltering;
    private javax.swing.JProgressBar progidf;
    private javax.swing.JProgressBar progkmeans;
    private javax.swing.JProgressBar prognormalisasi;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JProgressBar progstemming;
    private javax.swing.JProgressBar progtf;
    private javax.swing.JMenuItem recall;
    private javax.swing.JScrollPane scrollbuku;
    private javax.swing.JMenuItem sentroidawal;
    private javax.swing.JTable tablebuku;
    private javax.swing.JMenuItem textmining;
    private javax.swing.JMenuItem tfidf;
    private javax.swing.JTextArea txtabckm;
    private javax.swing.JTextArea txtcase;
    private javax.swing.JTextArea txtfiltering;
    private javax.swing.JTextArea txtidf;
    private javax.swing.JTextArea txtkmeans;
    private javax.swing.JTextArea txtnormalisasi;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextArea txtpenjelasanabckm;
    private javax.swing.JTextArea txtpenjelasancase;
    private javax.swing.JTextArea txtpenjelasanfiltering;
    private javax.swing.JTextArea txtpenjelasanidf;
    private javax.swing.JTextArea txtpenjelasankmeans;
    private javax.swing.JTextArea txtpenjelasannormalisasi;
    private javax.swing.JTextArea txtpenjelasanstemming;
    private javax.swing.JTextArea txtpenjelasantf;
    private javax.swing.JTextArea txtstemming;
    private javax.swing.JTextArea txttf;
    private javax.swing.JTextField txtusername;
    private javax.swing.JLabel txtwaktukomputasiabckm;
    private javax.swing.JLabel txtwaktukomputasikmeans;
    private javax.swing.JMenuItem waktu;
    // End of variables declaration//GEN-END:variables
    
    //PREPROSESING
    //1. TEXT MINING
    //1.1 CASEFOLDING DAN TOKENIZING
    private class WorkerLoopCaseToken extends SwingWorker<String, Void>{

        @Override
        protected void done() {
            try {
                if (get() != null) {
                    txtcase.append(get());
                }
                // stop progress bar
                progcase.setIndeterminate(false);
            } catch (InterruptedException ex) {
                Logger.getLogger(Klasterisasi.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(Klasterisasi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        protected String doInBackground() throws Exception {
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
                    txtcase.append(sqlinsert+"\n");
                }
            }
            st.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Case Folding & Tokenizing!","Information",JOptionPane.INFORMATION_MESSAGE);
            database.con.close();
            progcase.setVisible(false);
            progfiltering.setVisible(false);
            progstemming.setVisible(false);
        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Error : "+x,"Warning",JOptionPane.WARNING_MESSAGE);
        }
           return "\n\nSelesai";
        }
    } 
    //1.2 FILTERING
    private class WorkerLoopFiltering extends SwingWorker<String, Void>{

        @Override
        protected void done() {
            try {
                if (get() != null) {
                    txtfiltering.append(get());
                }
                // stop progress bar
                progfiltering.setIndeterminate(false);
            } catch (InterruptedException ex) {
                Logger.getLogger(Klasterisasi.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(Klasterisasi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        protected String doInBackground() throws Exception {
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
                    txtfiltering.append("\n"+stop);
               }
               st.close();
               JOptionPane.showMessageDialog(null, "Kata Berhasil Di Filter !","Information",JOptionPane.INFORMATION_MESSAGE);
               database.con.close();
               progcase.setVisible(false);
            progfiltering.setVisible(false);
            progstemming.setVisible(false);
           } catch (Exception x) {
                JOptionPane.showMessageDialog(null, "Error : "+x,"Warning",JOptionPane.WARNING_MESSAGE);
           }
           return "\n\nSelesai";
        }
    } 
    //1.3 STEMMING
    private class WorkerLoopStemming extends SwingWorker<String, Void>{

        @Override
        protected void done() {
            try {
                if (get() != null) {
                    txtfiltering.append(get());
                }
                // stop progress bar
                progfiltering.setIndeterminate(false);
            } catch (InterruptedException ex) {
                Logger.getLogger(Klasterisasi.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(Klasterisasi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        protected String doInBackground() throws Exception {
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
                    txtstemming.append("\n"+a.Enhanced_CS(stemm));
                    st2.executeUpdate(sqlupdate);
                }
                st.close();
                JOptionPane.showMessageDialog(null, "Kata Berhasil Di Stemming !","Information",JOptionPane.INFORMATION_MESSAGE);
                database.con.close();
                progcase.setVisible(false);
                progfiltering.setVisible(false);
                progstemming.setVisible(false);
            } catch (Exception x) {
                JOptionPane.showMessageDialog(null, "Error : "+x,"Warning",JOptionPane.WARNING_MESSAGE);
            }
            return "\n\nSelesai";
        }
    } 
    //2 TF-IDF
    //2.1 TF
    private class WorkerLoopTF extends SwingWorker<String, Void>{

        @Override
        protected void done() {
            try {
                if (get() != null) {
                    txtfiltering.append(get());
                }
                // stop progress bar
                progfiltering.setIndeterminate(false);
            } catch (InterruptedException ex) {
                Logger.getLogger(Klasterisasi.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(Klasterisasi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        protected String doInBackground() throws Exception {
            try {
                database.con=DriverManager.getConnection(database.url+database.db, "root", "");
                Statement st = database.con.createStatement();
                String sql ="SELECT kata, id_data_buku,count(kata) FROM `simpan_kata` where kata != '' group by kata, id_data_buku";
                ResultSet kl = st.executeQuery(sql);           
                String temp = "", id_buku = "", bobot = "", id="";
                boolean sts = true;
                int df = 0;
                while(kl.next()){
                    String a = kl.getString(1);
                    String b = kl.getString(2);
                    String c = kl.getString(3);
                    Statement st2 = database.con.createStatement();
                    String sqlinsert = "";
                    if(!a.equals(temp)){                
                        if(!sts){ // exec
                            sqlinsert = "INSERT INTO file_index (file_word, "+id_buku+" df, id_data_buku)"
                                    + "values ('"+temp+"',"+bobot+" '"+df+"', '"+id+"')";
                            txttf.append("\n"+temp+" | "+id_buku+" | "+bobot);
                            df = 0;
                            id_buku = "";
                            bobot = "";
                            id="";
                            System.out.println(sqlinsert);
                            st2.executeUpdate(sqlinsert);
                        }
                        sts = false; // sts = false
                        temp = a; // temp = apa
                    }
                    if(a.equals(temp)){ // aja == aja
                        id_buku += "D"+b+","; //D5,
                        bobot += "'"+c+"',"; //'3',
                        id += ((b+"").length()==1?("0"+b):b)+",";                    
                        df++;
                    }
                }
                st.close(); 
                JOptionPane.showMessageDialog(null, "File Index !","Information",JOptionPane.INFORMATION_MESSAGE);
                database.con.close();
                progtf.setVisible(false);
                progidf.setVisible(false);
                prognormalisasi.setVisible(false);
            } catch (Exception x) {
                JOptionPane.showMessageDialog(null, "Error : "+x,"Warning",JOptionPane.WARNING_MESSAGE);
            }
            return "\n\nSelesai";
        }
    } 
    //2.2 IDF
    private class WorkerLoopIDF extends SwingWorker<String, Void>{

        @Override
        protected void done() {
            try {
                if (get() != null) {
                    txtfiltering.append(get());
                }
                // stop progress bar
                progfiltering.setIndeterminate(false);
            } catch (InterruptedException ex) {
                Logger.getLogger(Klasterisasi.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(Klasterisasi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        protected String doInBackground() throws Exception {
            try {
                database.con=DriverManager.getConnection(database.url+database.db, "root", "");
                Statement st = database.con.createStatement();
                String sql ="select * from file_index";
                ResultSet kl = st.executeQuery(sql);
                double td=0;
                while(kl.next()){
                    String id = kl.getString(1);
                    String word = kl.getString(2);
                    String iddata = kl.getString(304);
                    String c = kl.getString(303);
                    Statement st3 = database.con.createStatement();
                    String sqlselect = "SELECT count(id_data_buku) from data_buku";
                    ResultSet kl3 = st3.executeQuery(sqlselect);
                    while(kl3.next()){
                        td=kl3.getDouble(1);
                    }
                    double df =Double.parseDouble(c);
                    double idf=Math.log10(td/df);
                    Statement st2 = database.con.createStatement();
                    String sqlinsert = "insert into idf (word,td,df,idf,id_data_buku,id_file_index)values('"+word+"',"+td+","+df+","+idf+",'"+iddata+"','"+id+"')";
                    st2.executeUpdate(sqlinsert);
                    System.out.println(sqlinsert);
                    txtidf.append("\n"+word+"| "+td+" | "+df+" | "+idf);
               }
               st.close();
               JOptionPane.showMessageDialog(null, "Nilai IDF OK !","Information",JOptionPane.INFORMATION_MESSAGE);
               database.con.close();
               progtf.setVisible(false);
               progidf.setVisible(false);
               prognormalisasi.setVisible(false);
           } catch (Exception x) {
               JOptionPane.showMessageDialog(null, "Error : "+x,"Warning",JOptionPane.WARNING_MESSAGE);
           }
           return "\n\nSelesai";
        }
    } 
    //2.3 NORMALISASI
    private class WorkerLoopNormalisasi extends SwingWorker<String, Void>{

        @Override
        protected void done() {
            try {
                if (get() != null) {
                    txtfiltering.append(get());
                }
                // stop progress bar
                progfiltering.setIndeterminate(false);
            } catch (InterruptedException ex) {
                Logger.getLogger(Klasterisasi.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(Klasterisasi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        protected String doInBackground() throws Exception {
            try {
                database.con=DriverManager.getConnection(database.url+database.db, "root", "");
                Statement   st = database.con.createStatement(), 
                            st2 = database.con.createStatement(), 
                            st3 = database.con.createStatement();
                String sql ="select * from idf";
                ResultSet kl = st.executeQuery(sql);            
                String temp="", temp1="", bobot="",id_buku="";
                boolean sts=true;
                double bobotidf = 0;
                while(kl.next()){ 
                    String word = kl.getString(2);
                    double idf = kl.getDouble(5);
                    String id_data_buku = kl.getString(6);
                    System.out.println(id_data_buku);
                    String [] arr_id = id_data_buku.split(",");
                    for (int i = 0; i < arr_id.length; i++) {
                        sql = "select idf*idf from idf where id_data_buku like '%"+arr_id[i]+"%'";
                        ResultSet res = st2.executeQuery(sql);
                        double sum = 0;
                        while (res.next()) {                        
                            sum += res.getDouble(1);
                        }
                        double sqrt = Math.sqrt(sum);
                        bobotidf = idf/sqrt;
                        String sqlinsert="";
                        if(!word.equals(temp) || !id_data_buku.equals(temp1)){
                            if(!sts){
                                sqlinsert = "insert into index_akhir (word "+id_buku+",id_data_buku) values ('"+temp+"'"+bobot+",'"+temp1+"')";
                                txtnormalisasi.append("\n"+temp+"| "+id_buku+" | "+bobot);
                                id_buku="";
                                bobot="";
                                System.out.println(sqlinsert);
                                st3.executeUpdate(sqlinsert);
                            }
                            sts=false;
                            temp=word;
                            temp1=id_data_buku;
                        }
                        if(word.equals(temp) || id_data_buku.equals(temp1)){
                            id_buku+=",D"+arr_id[i]+"";
                            bobot+=",'"+bobotidf+"'";
                        }
                    }
                }
                st.close();
                JOptionPane.showMessageDialog(null, "TF-IDF OK !","Information",JOptionPane.INFORMATION_MESSAGE);
                database.con.close();
                progtf.setVisible(false);
                progidf.setVisible(false);
                prognormalisasi.setVisible(false);
            } catch (Exception x) {
                JOptionPane.showMessageDialog(null, "Error : "+x,"Warning",JOptionPane.WARNING_MESSAGE);
            }
            return "\n\nSelesai";
        }
    } 
    
    //3 Klaster
    //3.1 K-Means
    private class WorkerLoopKMeans extends SwingWorker<String, Void>{

        @Override
        protected void done() {
            try {
                if (get() != null) {
                    txtfiltering.append(get());
                }
                // stop progress bar
                progfiltering.setIndeterminate(false);
            } catch (InterruptedException ex) {
                Logger.getLogger(Klasterisasi.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(Klasterisasi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        protected String doInBackground() throws Exception {
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
                    stop();
                    JOptionPane.showMessageDialog(null, "Sentroid Sama,\nAlgoritma Berhenti!","Information",JOptionPane.INFORMATION_MESSAGE);
                }else{
                    txtkmeans.append("Sentroid Berbeda, Lakukan Klasterisasi\n");
                    K_Means kmns = new K_Means();
                    kmns.Euclidean();
                    kmns.Klaster();
                    kmns.CentroidBaru();
                    kmns.Rekursif();
                }
            }
            progkmeans.setVisible(false);
            progabckm.setVisible(false);
        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Error : "+x,"Warning",JOptionPane.WARNING_MESSAGE);
        }
           return "\n\nSelesai";
        }
    } 
    
    private class Task extends Thread {    
      public Task(){
      }

      public void run(){
         for(int i =0; i<= 100; i+=5){
            final int progress = i;
            SwingUtilities.invokeLater(new Runnable() {
               public void run() {
                  progressBar.setValue(progress);
               }
            });
            try {
               Thread.sleep(100);
            } catch (InterruptedException e) {}
         }
         try {
            database.con=DriverManager.getConnection(database.url+database.db, "root", "");
            Statement st = database.con.createStatement();
            String sql = "SELECT * from admin where ( username like '"+txtusername.getText()+"' and password  like '"+txtpassword.getText()+"');";
            ResultSet kl = st.executeQuery(sql);
            if(kl.next()){
                lblinfo.setVisible(false);
                login.setVisible(false);
                preprocesing.setEnabled(true);
                klaster.setEnabled(true);
                logout.setVisible(true);
                lihatbuku.setEnabled(true);
                lihatklaster.setEnabled(true);
                progressBar.setVisible(false);
                pengujian.setEnabled(true);
            }else{
                lblinfo.setVisible(true);
                lblinfo.setText("LOGIN GAGAL");
                tablebuku.setVisible(false);
                scrollbuku.setVisible(false);
                login.setVisible(true);
                lbllogin.setVisible(true);
                lblusername.setVisible(true);
                txtusername.setVisible(true);
                lblpassword.setVisible(true);
                txtpassword.setVisible(true);
                btnlogin.setVisible(true);
                AksiTextMining.setVisible(false);
                AksiTFIDF.setVisible(false);
                progressBar.setVisible(false);
            }
        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Error : "+x,"Warning",JOptionPane.WARNING_MESSAGE);
        }
        txtusername.setText("");
        txtpassword.setText("");
      }
   }
}
