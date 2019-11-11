/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Generales;

import GUI_Imagenes.Validacion;
import GUI_Imagenes.Pasos;
import GUI_Video.Video;
import herramientas.GestorImagenes;
import static herramientas.GestorImagenes.rutas;
import herramientas.GestorVideo;
import java.awt.Image;
import javax.swing.JDesktopPane;

/**
 *
 * @author Alejandra
 */
public class Seguridad extends javax.swing.JInternalFrame {

    private JDesktopPane principal;
    public boolean abrirImagenes;
    public boolean abrirVideo;
    public Seguridad ventanaSeguridad;
    public Video ventanaVideo;
    public int identificador;
    public Pasos pasos;
    
    public Seguridad() {
        initComponents();
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
    }

    Seguridad( JDesktopPane principal,int identificador) {
        initComponents();
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        this.principal = principal;
        this.identificador = identificador;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Si = new javax.swing.JButton();
        No = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0), 3));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("¿Estas seguro de la selección?");

        Si.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        Si.setText("SI");
        Si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SiActionPerformed(evt);
            }
        });

        No.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        No.setText("NO");
        No.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(56, 56, 56))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(Si)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(No)
                .addGap(87, 87, 87))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(No)
                    .addComponent(Si))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SiActionPerformed
        this.dispose();
        switch (identificador) {
            case 1:
                if(rutas.size()<=30){
                    pasos = new Pasos(this.principal);
                    this.principal.add(pasos);
                    pasos.setVisible(true);
                }else{
                    Validacion v = new Validacion(principal);
                    this.principal.add(v);
                    v.setVisible(true);
                }   break;
            case 2:
                ventanaVideo = new Video(this.principal);
                this.principal.add(ventanaVideo);
                ventanaVideo.setVisible(true);
                break;
            default:
                break;
        }
        
    }//GEN-LAST:event_SiActionPerformed

    private void NoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoActionPerformed
        this.dispose();
        switch(identificador){
            case 1:
                abrirImagenes = GestorImagenes.abrirImagenes();
                if(abrirImagenes==true){
                    ventanaSeguridad = new Seguridad(principal,1);
                    principal.add(ventanaSeguridad);
                    ventanaSeguridad.setVisible(true);
                }else{}
            case 2:
                abrirVideo = GestorVideo.abrirVideo();
                if(abrirVideo==true){
                    ventanaSeguridad = new Seguridad(principal,2);
                    principal.add(ventanaSeguridad);
                    ventanaSeguridad.setVisible(true);
                }else{}
        }
        
    }//GEN-LAST:event_NoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton No;
    private javax.swing.JButton Si;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
