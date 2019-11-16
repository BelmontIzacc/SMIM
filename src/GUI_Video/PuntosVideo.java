/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Video;

import GUI_Generales.Editar;
import GUI_Generales.Instrucciones;
import static GUI_Generales.Prueba.Tiempo;
import static GUI_Generales.Prueba.maxPuntos;
import static GUI_Video.Video.rutaGeneral;
import puntos.HiloV;
import puntos.Nodo;
import herramientas.GestorVideo;
import static herramientas.GestorVideo.video;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.SwingConstants;
import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.bytedeco.javacv.OpenCVFrameConverter;
import javax.swing.JOptionPane;


import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.MultimediaInfo;
import it.sauronsoftware.jave.VideoInfo;

/**
 *
 * @author rebel
 */
public class PuntosVideo extends javax.swing.JInternalFrame {
    
    public static int forma;
    public static BufferedImage im;
    public static ArrayList<Nodo> vectorNodo;
    
    public JDesktopPane principal;
    public String rutaNueva,areaFaltante;
    public File file,mas;
    public MediaPlayer oracleVid;
    private JFXPanel jfxPanel = new JFXPanel();
    public Editar editar;
    public int valorFalta = maxPuntos+1, valorVa = 0,respuesta;
    public BufferedImage imagenMas;
    public Instrucciones instrucciones;
    public int tiempo;
    public int duracionV;
    public List<BufferedImage> listaIm;
    public int vInfo;
    public int numPuntos = 0;
    public String tipoProceso;
    public String nombreProc;
    public String nombreAlummno;
    public String grupo;
    /**
     * Creates new form PuntosVideo
     */
    public PuntosVideo() {
        initComponents();
        Platform.setImplicitExit(false);
    }

    PuntosVideo(JDesktopPane principal, String rutaNueva, int tiempo, String tipo,
            String np, String al, String g) {
        
        initComponents();
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        muestra();
        
        this.tipoProceso = tipo;
        this.nombreProc = np;
        this.nombreAlummno = al;
        this.grupo = g;
        
        this.principal = principal;
        this.rutaNueva = rutaNueva;
        this.tiempo = tiempo;
        titulo.setText("Seleccionar un máximo de "+(maxPuntos+1)+" puntos de interés.");
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        formas.setEnabled(true);
        muestraVideo();
        Pp.setIcon(new ImageIcon(im.getScaledInstance(270,
                270, Image.SCALE_DEFAULT)));
        puntosVan.setText("0");
        puntosFaltan.setText(""+(maxPuntos+1));
        muestraVideo.setLayout(new BorderLayout());
        muestraVideo.add(jfxPanel, BorderLayout.CENTER);
        muestraVideo.repaint();
        this.setLocation((this.principal.getWidth()-this.getWidth())/2,(this.principal.getHeight()-this.getHeight())/2);
        vectorNodo = new ArrayList<>();
        listaIm = new ArrayList<>();
        Platform.setImplicitExit(false);
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
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        agregar = new javax.swing.JButton();
        formas = new javax.swing.JComboBox<>();
        editarF = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        coordenadaY = new javax.swing.JLabel();
        coordenadaX = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        Pp = new puntos.LabelPaintV();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        puntosVan = new javax.swing.JLabel();
        puntosFaltan = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        muestraVideo = new javax.swing.JPanel();
        duracionVideo = new javax.swing.JSlider();
        play = new javax.swing.JButton();
        pause = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        regresar = new javax.swing.JButton();
        aceptar = new javax.swing.JButton();

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        titulo.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel9.setForeground(new java.awt.Color(255, 0, 0));

        agregar.setEnabled(false);
        agregar.setFocusPainted(false);
        agregar.setMaximumSize(new java.awt.Dimension(1377, 1309));
        agregar.setMinimumSize(new java.awt.Dimension(1377, 1309));
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });

        formas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Formas", "Círculo", "Rombo", "Cuadrado" }));
        formas.setEnabled(false);
        formas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formasActionPerformed(evt);
            }
        });

        editarF.setText("Editar forma");
        editarF.setEnabled(false);
        editarF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarFActionPerformed(evt);
            }
        });

        jLabel8.setText("Coordenadas:");

        jLabel9.setText("X:");

        jLabel10.setText("Y:");

        coordenadaY.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        coordenadaY.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        coordenadaY.setEnabled(false);

        coordenadaX.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        coordenadaX.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        coordenadaX.setEnabled(false);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editarF, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(formas, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(coordenadaY, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(coordenadaX, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(formas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(editarF)
                .addGap(18, 18, 18)
                .addComponent(agregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(coordenadaX, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(coordenadaY, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Pp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PpMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel2.setText("Puntos seleccionados:");

        jLabel3.setText("Puntos restantes:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(puntosVan, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(puntosFaltan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(puntosFaltan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(puntosVan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        muestraVideo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout muestraVideoLayout = new javax.swing.GroupLayout(muestraVideo);
        muestraVideo.setLayout(muestraVideoLayout);
        muestraVideoLayout.setHorizontalGroup(
            muestraVideoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 438, Short.MAX_VALUE)
        );
        muestraVideoLayout.setVerticalGroup(
            muestraVideoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 438, Short.MAX_VALUE)
        );

        duracionVideo.setValue(0);

        play.setText(">");
        play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playActionPerformed(evt);
            }
        });

        pause.setText("||");
        pause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(muestraVideo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(duracionVideo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(play)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pause)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(muestraVideo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(duracionVideo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(play)
                        .addComponent(pause)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        regresar.setText("Regresar");
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });

        aceptar.setText("Aceptar");
        aceptar.setEnabled(false);
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(regresar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(aceptar)
                .addGap(150, 150, 150))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(regresar)
                    .addComponent(aceptar))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        instrucciones = new Instrucciones(this.principal,3);
        principal.add(instrucciones);
        instrucciones.setVisible(true);
        aceptar.setEnabled(true);
        
        HiloV h = new HiloV(Pp,coordenadaX,coordenadaY);
        if(h.isAlive()){
            
        }else{
            //Finalmente, comienza la ejecución del hilo.
             h.start();
        }
        
    }//GEN-LAST:event_agregarActionPerformed

    private void formasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formasActionPerformed
        switch(formas.getSelectedIndex()){
            case 0:
                this.editarF.setEnabled(false);
                agregar.setEnabled(false);
                coordenadaX.setText("");
                coordenadaY.setText("");
                Instrucciones.ac = false;
                vectorNodo.clear();
                numPuntos = 0;
                valorFalta = maxPuntos+1;
                valorVa = 0;
                Pp.repaint();
                break;
            case 1:
                this.editarF.setEnabled(true);
                Pp.repaint();
                break;
            case 2:
                this.editarF.setEnabled(true);
                Pp.repaint();
                break;
            case 3:
                this.editarF.setEnabled(true);
                Pp.repaint();
                break;
        }
        forma = formas.getSelectedIndex();
    }//GEN-LAST:event_formasActionPerformed

    private void editarFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarFActionPerformed
        editar = new Editar(this.principal,3);
        editar.colocarPp(Pp);
        principal.add(editar);
        editar.setVisible(true);
        agregar.setEnabled(true);
    }//GEN-LAST:event_editarFActionPerformed

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        formas.setSelectedIndex(0);
        Editar.gc = false;
        Instrucciones.ac = false;
        vectorNodo.clear();
        numPuntos = 0;
        eliminarArchivo(rutaGeneral);
        oracleVid.dispose();
        System.gc();
        dispose();
        Video video = new Video(this.principal);
        principal.add(video);
        video.setVisible(true);
    }//GEN-LAST:event_regresarActionPerformed

    private void playActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playActionPerformed
        int max = duracionVideo.getMaximum() - 1;
        int act = duracionVideo.getValue();
       
        if(max == act){
            oracleVid.stop();
            duracionVideo.setValue(0);
        }
        oracleVid.play();
    }//GEN-LAST:event_playActionPerformed

    private void pauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseActionPerformed
        oracleVid.pause();
    }//GEN-LAST:event_pauseActionPerformed

    private void PpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PpMouseClicked
        if(Instrucciones.ac == true){
            if(evt.getButton() == MouseEvent.BUTTON1){
                if(numPuntos<=maxPuntos){
                    Nodo n = new Nodo(evt.getX(),evt.getY(),3);
                    vectorNodo.add(n);
                    System.out.println("X: "+evt.getX()+" , Y: "+evt.getY());
                    numPuntos++;
                    
                    valorFalta = valorFalta - 1; //Para mostrar cuantos puntos faltan por seleccionar
                    this.puntosFaltan.setText(""+valorFalta);
                    valorVa = valorVa + 1; //Para mostrar cuantos puntos se seleccionaron
                    this.puntosVan.setText(""+valorVa);
                    
                    Pp.repaint();
                }
            }
            if(evt.getButton() == MouseEvent.BUTTON3){
                int x = evt.getX();
                int y = evt.getY();

                int diametro = GUI_Generales.Editar.tamanioS;
                int radio = (int)diametro/2;
                
                int minX = evt.getX()-radio;
                int maxX = evt.getX()+radio;

                int minY = evt.getY()-radio;
                int maxY = evt.getY()+radio;

                Nodo aux = new Nodo(x,y,3);
                for(int i = 0 ; i < vectorNodo.size() ; i++){
                    double xGuardado = vectorNodo.get(i).getX();
                    if(xGuardado >= minX && xGuardado <= maxX ){  // 12<x<15
                        double yGuardado = vectorNodo.get(i).getY();
                        if(yGuardado >= minY && yGuardado <= maxY ){
                            vectorNodo.remove(i);
                            numPuntos--;
                            
                            valorFalta = valorFalta + 1; //Para mostrar cuantos puntos faltan por seleccionar
                            this.puntosFaltan.setText(""+valorFalta);
                            valorVa = valorVa - 1; //Para mostrar cuantos puntos se seleccionaron
                            this.puntosVan.setText(""+valorVa);
                            
                            break;
                        }
                    }
                }
                Pp.repaint();
            }
        }
    }//GEN-LAST:event_PpMouseClicked

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        if(formas.getSelectedIndex()==0){
            areaFaltante = "Formas";
            datosFaltan();
        }else if(Editar.gc == false){
            areaFaltante = "Editar";
            datosFaltan();
        }else if(Instrucciones.ac == false || vectorNodo.isEmpty()){
            areaFaltante = "agregar puntos";
            datosFaltan();
        }else{
            try {
                /////////////////////OBTENER IMAGENES
                Encoder encoder = new Encoder();
                MultimediaInfo info = encoder.getInfo(file);
                VideoInfo vInfo = info.getVideo();
                double fps = vInfo.getFrameRate();
                
                listaIm = GestorVideo.obtenerRutaVideo(video,Integer.parseInt(Tiempo.get(tiempo)),duracionV,fps,
                        nombreProc,nombreAlummno,grupo);
                CorreccionVideo cv = new CorreccionVideo(this.principal,this.rutaNueva,listaIm,duracionV,fps,tipoProceso);
                cv.agregarProyecto(nombreProc, nombreAlummno, grupo);
                
                this.principal.add(cv);
                cv.muestraImagenes();
                cv.muestraVideo();
                cv.setVisible(true);
                dispose();
            } catch (EncoderException ex) {
                Logger.getLogger(PuntosVideo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_aceptarActionPerformed

    private void eliminarArchivo(String ruta) {
        File rutaG = new File(ruta);
        if(rutaG.isDirectory()){
            if(rutaG.list().length == 0){
                rutaG.delete();
            }else{
                for(String temp : rutaG.list()){
                    File file = new File(rutaG,temp);
                    eliminarArchivo(file.getAbsolutePath());
                }
                if(rutaG.list().length == 0){
                    rutaG.delete();
                }
            }
        }else{
            rutaG.delete();
        }
    }
    
    public void muestraVideo(){
        try {
            file = new File(rutaNueva);
            oracleVid = new MediaPlayer(
                        new Media(file.toURI().toString())
            );
            //se añade video al jfxPanel
            im = obtenerImagen(rutaNueva);
            int w = im.getWidth();
            int h = im.getHeight();
            jfxPanel.setPreferredSize(new Dimension(w,h));
            jfxPanel.setScene(new Scene(new Group(new MediaView(oracleVid))));
            oracleVid.currentTimeProperty().addListener((Observable ov) -> {
                duracionVideo.setValue((int) (oracleVid.getCurrentTime().toMillis()/oracleVid.getTotalDuration().toMillis()* 100));
            });
            duracionV = (int) oracleVid.getTotalDuration().toSeconds();
        } catch (FrameGrabber.Exception ex) {
            Logger.getLogger(Video.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void muestra() {
        mas = new File("src\\Fotos\\mas_1.jpg");
        try {
            imagenMas = ImageIO.read(mas);
        } catch (IOException ex) {
            Logger.getLogger(PuntosVideo.class.getName()).log(Level.SEVERE, null, ex);
        }
        agregar.setIcon(new ImageIcon(imagenMas));
    }
    
    public void datosFaltan(){
        respuesta = JOptionPane.showConfirmDialog(null,"Falta completar parte de "+areaFaltante,null,
                      JOptionPane.CLOSED_OPTION,JOptionPane.WARNING_MESSAGE);
        while(respuesta!=0){
                  respuesta = JOptionPane.showConfirmDialog(null,"Falta completar parte de "+areaFaltante,null,
                      JOptionPane.CLOSED_OPTION,JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public BufferedImage obtenerImagen(String ruta) throws FrameGrabber.Exception{
        
        try {
            // ruta donde se selecciona el video para tomar los frames
            FFmpegFrameGrabber frameGrabber = new FFmpegFrameGrabber(ruta);
            // se inicia preparativos para obtener frames
            frameGrabber.start();
            // objeto de tipo frame
            Frame i;
            //objeto del cual convertira el frame del video en imagen
            OpenCVFrameConverter.ToIplImage converterToIplImage = 
                    new OpenCVFrameConverter.ToIplImage();
            int j = 30; //frame numero 30 equivale a 1s
            
            // seleccionas que frame vas a querer, en este caso el frame de 1s en el video, que es el
            // numero 30.
            frameGrabber.setFrameNumber(j);//puede ser cualquier frame
            // se obtiene la imagen
            org.bytedeco.javacv.Frame frame = frameGrabber.grabImage();
            //muestras informacion de la imagen obtenida
//            System.out.println(frame.toString());
            // se inicia la conversion de frame a imagen
            opencv_core.IplImage image = converterToIplImage.convert(frame);
            // se crea un buffered con el frame obtenido
            BufferedImage bi = IplImageToBufferedImage(image);
            
            return bi;
        } catch (FrameGrabber.Exception ex) {
            Logger.getLogger(Video.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    private BufferedImage IplImageToBufferedImage( opencv_core.IplImage src ) {
        
        OpenCVFrameConverter.ToIplImage grabberConverter = 
                new OpenCVFrameConverter.ToIplImage();
        
        Java2DFrameConverter paintConverter = new Java2DFrameConverter();
        org.bytedeco.javacv.Frame frame = grabberConverter.convert( src );
        
        return paintConverter.getBufferedImage( frame,1 );
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel Pp;
    private javax.swing.JButton aceptar;
    public javax.swing.JButton agregar;
    public javax.swing.JLabel coordenadaX;
    public javax.swing.JLabel coordenadaY;
    private javax.swing.JSlider duracionVideo;
    private javax.swing.JButton editarF;
    public javax.swing.JComboBox<String> formas;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel muestraVideo;
    private javax.swing.JButton pause;
    private javax.swing.JButton play;
    private javax.swing.JLabel puntosFaltan;
    private javax.swing.JLabel puntosVan;
    private javax.swing.JButton regresar;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables

}
