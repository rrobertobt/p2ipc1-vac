/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.robertob.p2ipc1.frames;

import com.robertob.p2ipc1.utils.list.DoubleLinkedListException;
import com.robertob.p2ipc1.utils.list.FileHandler;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author robertob
 */
public class LoadFilesDialog extends javax.swing.JDialog {

    FileHandler fileHandler = new FileHandler();
    private int CONSUME_FUEL_TIME;
    private int LANDING_TIME;
    private int DISEMBARKING_TIME;
    private int MAINTENANCE_TIME;
    private int TAKE_OFF_TIME;
    MainFrame mainFrame;
    
    public LoadFilesDialog(java.awt.Frame parent, boolean modal, MainFrame mainFrame) {
        super(parent, modal);
        initComponents();
        this.mainFrame = mainFrame;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        planesFileBtn = new javax.swing.JButton();
        tracksFileBtn = new javax.swing.JButton();
        controlStationsFileBtn = new javax.swing.JButton();
        disembarkingStationsFileBtn = new javax.swing.JButton();
        maintenanceStationsFileBtn = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        planesFileNameLbl = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tracksFileNameLbl = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        controlStationsFileNameLbl = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        disembarkingStationsFileNameLbl = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        maintenanceStationsFileNameLbl = new javax.swing.JLabel();
        continueBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Cargar archivos");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Open Sans", 1, 21)); // NOI18N
        jLabel1.setText("CARGAR ARCHIVOS");

        jLabel2.setFont(new java.awt.Font("Open Sans", 0, 20)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/robertob/p2ipc1/images/landingTrackBlack.png"))); // NOI18N
        jLabel2.setText("Pistas de aterrizaje");

        jLabel3.setFont(new java.awt.Font("Open Sans", 0, 20)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/robertob/p2ipc1/images/planeBlack.png"))); // NOI18N
        jLabel3.setText("Aviones");

        jLabel4.setFont(new java.awt.Font("Open Sans", 0, 20)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/robertob/p2ipc1/images/controlStationBlack.png"))); // NOI18N
        jLabel4.setText("Estaciones de control");

        jLabel5.setFont(new java.awt.Font("Open Sans", 0, 20)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/robertob/p2ipc1/images/otherStationBlack.png"))); // NOI18N
        jLabel5.setText("Estaciones de desabordaje");

        jLabel6.setFont(new java.awt.Font("Open Sans", 0, 20)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/robertob/p2ipc1/images/otherStationBlack.png"))); // NOI18N
        jLabel6.setText("Estaciones de mantenimiento");

        planesFileBtn.setBackground(new java.awt.Color(0, 153, 153));
        planesFileBtn.setFont(new java.awt.Font("Open Sans", 0, 15)); // NOI18N
        planesFileBtn.setForeground(new java.awt.Color(255, 255, 255));
        planesFileBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/robertob/p2ipc1/images/selectFileBlack.png"))); // NOI18N
        planesFileBtn.setText("Selecionar archivo...");
        planesFileBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        planesFileBtn.setMargin(new java.awt.Insets(2, 5, 2, 5));
        planesFileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                planesFileBtnActionPerformed(evt);
            }
        });

        tracksFileBtn.setBackground(new java.awt.Color(0, 153, 153));
        tracksFileBtn.setFont(new java.awt.Font("Open Sans", 0, 15)); // NOI18N
        tracksFileBtn.setForeground(new java.awt.Color(255, 255, 255));
        tracksFileBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/robertob/p2ipc1/images/selectFileBlack.png"))); // NOI18N
        tracksFileBtn.setText("Selecionar archivo...");
        tracksFileBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tracksFileBtn.setMargin(new java.awt.Insets(2, 5, 2, 5));
        tracksFileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tracksFileBtnActionPerformed(evt);
            }
        });

        controlStationsFileBtn.setBackground(new java.awt.Color(0, 153, 153));
        controlStationsFileBtn.setFont(new java.awt.Font("Open Sans", 0, 15)); // NOI18N
        controlStationsFileBtn.setForeground(new java.awt.Color(255, 255, 255));
        controlStationsFileBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/robertob/p2ipc1/images/selectFileBlack.png"))); // NOI18N
        controlStationsFileBtn.setText("Selecionar archivo...");
        controlStationsFileBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        controlStationsFileBtn.setMargin(new java.awt.Insets(2, 5, 2, 5));
        controlStationsFileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                controlStationsFileBtnActionPerformed(evt);
            }
        });

        disembarkingStationsFileBtn.setBackground(new java.awt.Color(0, 153, 153));
        disembarkingStationsFileBtn.setFont(new java.awt.Font("Open Sans", 0, 15)); // NOI18N
        disembarkingStationsFileBtn.setForeground(new java.awt.Color(255, 255, 255));
        disembarkingStationsFileBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/robertob/p2ipc1/images/selectFileBlack.png"))); // NOI18N
        disembarkingStationsFileBtn.setText("Selecionar archivo...");
        disembarkingStationsFileBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        disembarkingStationsFileBtn.setMargin(new java.awt.Insets(2, 5, 2, 5));
        disembarkingStationsFileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disembarkingStationsFileBtnActionPerformed(evt);
            }
        });

        maintenanceStationsFileBtn.setBackground(new java.awt.Color(0, 153, 153));
        maintenanceStationsFileBtn.setFont(new java.awt.Font("Open Sans", 0, 15)); // NOI18N
        maintenanceStationsFileBtn.setForeground(new java.awt.Color(255, 255, 255));
        maintenanceStationsFileBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/robertob/p2ipc1/images/selectFileBlack.png"))); // NOI18N
        maintenanceStationsFileBtn.setText("Selecionar archivo...");
        maintenanceStationsFileBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        maintenanceStationsFileBtn.setMargin(new java.awt.Insets(2, 5, 2, 5));
        maintenanceStationsFileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maintenanceStationsFileBtnActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Open Sans", 0, 17)); // NOI18N
        jLabel7.setText("Archivo:");

        planesFileNameLbl.setFont(new java.awt.Font("Open Sans", 3, 17)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Open Sans", 0, 17)); // NOI18N
        jLabel9.setText("cargado");

        jLabel10.setFont(new java.awt.Font("Open Sans", 0, 17)); // NOI18N
        jLabel10.setText("cargado");

        jLabel11.setFont(new java.awt.Font("Open Sans", 0, 17)); // NOI18N
        jLabel11.setText("Archivo:");

        tracksFileNameLbl.setFont(new java.awt.Font("Open Sans", 3, 17)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Open Sans", 0, 17)); // NOI18N
        jLabel13.setText("cargado");

        jLabel14.setFont(new java.awt.Font("Open Sans", 0, 17)); // NOI18N
        jLabel14.setText("Archivo:");

        controlStationsFileNameLbl.setFont(new java.awt.Font("Open Sans", 3, 17)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Open Sans", 0, 17)); // NOI18N
        jLabel16.setText("cargado");

        jLabel17.setFont(new java.awt.Font("Open Sans", 0, 17)); // NOI18N
        jLabel17.setText("Archivo:");

        disembarkingStationsFileNameLbl.setFont(new java.awt.Font("Open Sans", 3, 17)); // NOI18N

        jLabel19.setFont(new java.awt.Font("Open Sans", 0, 17)); // NOI18N
        jLabel19.setText("cargado");

        jLabel20.setFont(new java.awt.Font("Open Sans", 0, 17)); // NOI18N
        jLabel20.setText("Archivo:");

        maintenanceStationsFileNameLbl.setFont(new java.awt.Font("Open Sans", 3, 17)); // NOI18N

        continueBtn.setBackground(new java.awt.Color(0, 204, 153));
        continueBtn.setFont(new java.awt.Font("Open Sans", 1, 20)); // NOI18N
        continueBtn.setForeground(new java.awt.Color(51, 51, 51));
        continueBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/robertob/p2ipc1/images/nextBlack.png"))); // NOI18N
        continueBtn.setText("Continuar");
        continueBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        continueBtn.setIconTextGap(1);
        continueBtn.setMargin(new java.awt.Insets(2, 5, 2, 5));
        continueBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continueBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator4)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(disembarkingStationsFileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(disembarkingStationsFileNameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jSeparator2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tracksFileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tracksFileNameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(controlStationsFileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(controlStationsFileNameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jSeparator5)
                    .addComponent(jSeparator3)
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(planesFileNameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(planesFileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(152, 407, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(maintenanceStationsFileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(maintenanceStationsFileNameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(206, 206, 206))
            .addGroup(layout.createSequentialGroup()
                .addGap(215, 215, 215)
                .addComponent(continueBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(planesFileNameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(planesFileBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tracksFileNameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(tracksFileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(controlStationsFileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(controlStationsFileNameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(disembarkingStationsFileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(disembarkingStationsFileNameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(maintenanceStationsFileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(continueBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(maintenanceStationsFileNameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(204, 204, 204))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void planesFileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_planesFileBtnActionPerformed
        try {
            fileHandler.createPlanesFileChooser();
            planesFileNameLbl.setText(fileHandler.getPlanesFileName());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LoadFilesDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_planesFileBtnActionPerformed

    private void tracksFileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tracksFileBtnActionPerformed
        try {
            fileHandler.createTracksFileChooser();
            tracksFileNameLbl.setText(fileHandler.getTracksFileName());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LoadFilesDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tracksFileBtnActionPerformed

    private void controlStationsFileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_controlStationsFileBtnActionPerformed
        try {
            fileHandler.createControlStationsFileChooser();
            controlStationsFileNameLbl.setText(fileHandler.getControlStationsFileName());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LoadFilesDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_controlStationsFileBtnActionPerformed

    private void disembarkingStationsFileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disembarkingStationsFileBtnActionPerformed
        try {
            fileHandler.createDisembarkStationsFileChooser();
            disembarkingStationsFileNameLbl.setText(fileHandler.getDisembarkStationsFileName());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LoadFilesDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_disembarkingStationsFileBtnActionPerformed

    private void maintenanceStationsFileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maintenanceStationsFileBtnActionPerformed
        try {
            fileHandler.createMaintenanceStationsFileChooser();
            maintenanceStationsFileNameLbl.setText(fileHandler.getMaintenanceStationsFileName());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LoadFilesDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_maintenanceStationsFileBtnActionPerformed

    private void continueBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continueBtnActionPerformed
        if(!fileHandler.allFilesLoad()){
            JOptionPane.showMessageDialog(null, "Parece que no se han cargado correctamente todos los archivos, intente de nuevo", "Archivos no cargados", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                mainFrame.getCurrentSimulation().setPlanes(fileHandler.getPlanes());
                mainFrame.getCurrentSimulation().setLandingTracks(fileHandler.getLandingTracks());
                mainFrame.getCurrentSimulation().setControlStations(fileHandler.getControlStations());
                mainFrame.getCurrentSimulation().setDisembarkStations(fileHandler.getDisembarkStations());
                mainFrame.getCurrentSimulation().setMaintenanceStations(fileHandler.getMaintenanceStations());
                mainFrame.startSimulation();
                this.dispose();
            } catch (DoubleLinkedListException ex) {
                ex.printStackTrace();
            }
        
        }
    }//GEN-LAST:event_continueBtnActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton continueBtn;
    private javax.swing.JButton controlStationsFileBtn;
    private javax.swing.JLabel controlStationsFileNameLbl;
    private javax.swing.JButton disembarkingStationsFileBtn;
    private javax.swing.JLabel disembarkingStationsFileNameLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JButton maintenanceStationsFileBtn;
    private javax.swing.JLabel maintenanceStationsFileNameLbl;
    private javax.swing.JButton planesFileBtn;
    private javax.swing.JLabel planesFileNameLbl;
    private javax.swing.JButton tracksFileBtn;
    private javax.swing.JLabel tracksFileNameLbl;
    // End of variables declaration//GEN-END:variables
}
