/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Generales;

import GUI_Imagenes.Imagenes;
import GUI_Video.Video;
import java.awt.Dimension;
import java.awt.Image;
import javafx.application.Platform;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

/**
 *
 * @author rebel
 */
public class Cargando extends javax.swing.JInternalFrame {
    
    public JDesktopPane principal;
    public Imagenes VentanaImagenes;
    public Image abrirImagenes;
    public ImageIcon cargando;
    public Video ventanaVideo;
    public Dimension centro,internal;
    public long vInfo;
    public int respuestaSeguridad;
    
    /**
     * Creates new form cargando
     */
    public Cargando() {
        initComponents();
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        mostrarImagen();
        this.setLocation((this.principal.getWidth()-this.getWidth())/2,(this.principal.getHeight()-this.getHeight())/2);
        Platform.setImplicitExit(false);
    }

    public Cargando(JDesktopPane principal, long vInfo) {
        initComponents();
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        this.principal = principal;
        this.vInfo = vInfo;
        mostrarImagen();
        this.setLocation((this.principal.getWidth()-this.getWidth())/2,(this.principal.getHeight()-this.getHeight())/2);
        Platform.setImplicitExit(false);
    }
    
    public void mostrarImagen(){
        cargando = new ImageIcon("src\\Fotos\\car_.gif");
        cargando.setImage(cargando.getImage().getScaledInstance(300,70,Image.SCALE_DEFAULT));
        this.gif.setIcon(cargando);
        cargando.setImageObserver(gif);
    }
    
    public void mostrarVideo(Video v){
        ventanaVideo = v;
        int maximo = GUI_Generales.Principal.duracionVideo * 1000;
        int min = GUI_Generales.Principal.duracionVideo/60;
        if(vInfo>30000){
            if(vInfo>maximo){
                JOptionPane.showConfirmDialog(null,"El video dura mas de "+min+" minutos, solo se procesaran 5 minutos",null,
                      JOptionPane.CLOSED_OPTION,JOptionPane.WARNING_MESSAGE);
            }
            this.principal.add(ventanaVideo);
            ventanaVideo.setVisible(true);
        }else{
            respuestaSeguridad = JOptionPane.showConfirmDialog(null,"El video debe ser mayor a 30 segundos",null,
                      JOptionPane.CLOSED_OPTION,JOptionPane.WARNING_MESSAGE);
            while(respuestaSeguridad!=0){
                      respuestaSeguridad = JOptionPane.showConfirmDialog(null,"El video debe ser mayor a 30 segundos",null,
                              JOptionPane.CLOSED_OPTION,JOptionPane.WARNING_MESSAGE);
            }
            GUI_Generales.Principal.archivos.setEnabled(true);
            GUI_Generales.Principal.creditos.setEnabled(true);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        gif = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 6));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setText("Cargando");

        jLabel3.setText("(Espere unos segundos)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(gif, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jLabel3)))
                .addGap(90, 90, 90))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(15, 15, 15)
                .addComponent(gif, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel3)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel gif;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}