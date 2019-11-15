/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Generales;

import static herramientas.GestorImagenes.toBufferedImage;

import GUI_Imagenes.CorreccionPuntosI;
import GUI_Video.PuntosVideo;
import GUI_Video.CorreccionPuntosV;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

/**
 *
 * @author rebel
 */
public class Editar extends javax.swing.JInternalFrame {
    
    public static int tamanioS;
    public static int grosorS;
    public static int nC;
    public static Color colorS;
    public static Color ini;
    public static boolean gc=false;
    
    public JDesktopPane Principal;
    
    public ArrayList<Color> color;
    public int menos,mas;
    public int ventana; 
    public JLabel Pp;
    /**
     * Creates new form Editar
     */
    public Editar() {
        initComponents();
        cargarColor();
        numero.setHorizontalAlignment(SwingConstants.CENTER);
        if(gc==false){
            ini = new Color(this.color.get(0).getRGB());
            botonColor.setBackground(ini);
            numero.setText(this.sTamanio.getMinimum()+"");
        }else if(gc==true){
///////////Si ya habian editado algo se muestre lo seleccionado de color
            ini = this.colorS;
            botonColor.setBackground(colorS);
            this.sColor.setValue(nC);
///////////Si ya habian editado algo se muestre lo seleccionado de tamaño
            this.sTamanio.setValue(tamanioS);
            this.numero.setText(tamanioS+"");
///////////Si ya habian editado algo se muestre lo seleccionado del grosor
            this.sGrosor.setValue(grosorS);
            Border border = BorderFactory.createLineBorder(Color.BLACK, grosorS);
            this.lGrosor.setBorder(border);
        }
    }

    public Editar(JDesktopPane principal, int n) {
        initComponents();
        this.ventana = n;
        this.Principal = principal;
        this.setLocation((this.Principal.getWidth()-this.getWidth())/2,(this.Principal.getHeight()-this.getHeight())/2);
        cargarColor();
        numero.setHorizontalAlignment(SwingConstants.CENTER);
        if(gc==false){
            ini = new Color(this.color.get(0).getRGB());
            botonColor.setBackground(ini);
            numero.setText(this.sTamanio.getMinimum()+"");
        }else if(gc==true){
///////////Si ya habian editado algo se muestre lo seleccionado de color
            ini = this.colorS;
            botonColor.setBackground(colorS);
            sColor.setValue(nC);
///////////Si ya habian editado algo se muestre lo seleccionado de tamaño
            sTamanio.setValue(tamanioS);
            numero.setText(tamanioS+"");
///////////Si ya habian editado algo se muestre lo seleccionado del grosor
            sGrosor.setValue(grosorS);
            Border border = BorderFactory.createLineBorder(Color.BLACK, grosorS);
            lGrosor.setBorder(border);
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
        sColor = new javax.swing.JSlider();
        menosC = new javax.swing.JButton();
        masC = new javax.swing.JButton();
        botonColor = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        numero = new javax.swing.JLabel();
        sTamanio = new javax.swing.JSlider();
        jLabel3 = new javax.swing.JLabel();
        sGrosor = new javax.swing.JSlider();
        lGrosor = new javax.swing.JLabel();
        cambios = new javax.swing.JButton();
        menosT = new javax.swing.JButton();
        masT = new javax.swing.JButton();
        menosG = new javax.swing.JButton();
        masG = new javax.swing.JButton();

        jLabel1.setText("Color:");

        sColor.setMaximum(73);
        sColor.setPaintLabels(true);
        sColor.setPaintTicks(true);
        sColor.setSnapToTicks(true);
        sColor.setValue(0);
        sColor.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sColorStateChanged(evt);
            }
        });

        menosC.setText("<");
        menosC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menosCActionPerformed(evt);
            }
        });

        masC.setText(">");
        masC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masCActionPerformed(evt);
            }
        });

        jLabel2.setText("Tamaño:");

        numero.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        sTamanio.setMaximum(40);
        sTamanio.setMinimum(20);
        sTamanio.setPaintTicks(true);
        sTamanio.setSnapToTicks(true);
        sTamanio.setToolTipText("");
        sTamanio.setValue(0);
        sTamanio.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sTamanioStateChanged(evt);
            }
        });

        jLabel3.setText("Grosor:");

        sGrosor.setMaximum(5);
        sGrosor.setMinimum(1);
        sGrosor.setPaintLabels(true);
        sGrosor.setPaintTicks(true);
        sGrosor.setSnapToTicks(true);
        sGrosor.setValue(1);
        sGrosor.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sGrosorStateChanged(evt);
            }
        });

        lGrosor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cambios.setText("Guardar Cambios");
        cambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiosActionPerformed(evt);
            }
        });

        menosT.setText("<");
        menosT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menosTActionPerformed(evt);
            }
        });

        masT.setText(">");
        masT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masTActionPerformed(evt);
            }
        });

        menosG.setText("<");
        menosG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menosGActionPerformed(evt);
            }
        });

        masG.setText(">");
        masG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masGActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(menosC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(menosT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(65, 65, 65)
                                .addComponent(numero, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(sTamanio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(sColor, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(masC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(masT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(menosG)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(sGrosor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(masG, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(78, 78, 78)
                                .addComponent(lGrosor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(cambios)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(botonColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(masC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menosC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(numero, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(masT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menosT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sTamanio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lGrosor, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(masG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menosG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sGrosor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addComponent(cambios)
                .addContainerGap(44, Short.MAX_VALUE))
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

    private void sTamanioStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sTamanioStateChanged
        int valor  = sTamanio.getValue();
        numero.setText(valor+"");
    }//GEN-LAST:event_sTamanioStateChanged

    private void sColorStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sColorStateChanged
        int valorC = sColor.getValue();
        Color c = new Color(color.get(valorC).getRGB());
        botonColor.setBackground(c);
    }//GEN-LAST:event_sColorStateChanged

    private void menosCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menosCActionPerformed
        menos = sColor.getValue()-1;
        if(menos >= 0){
            sColor.setValue(menos);
        }
    }//GEN-LAST:event_menosCActionPerformed

    private void masCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masCActionPerformed
        mas = sColor.getValue()+1;
        if(mas<=73){
            sColor.setValue(mas);
        }
    }//GEN-LAST:event_masCActionPerformed

    private void menosTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menosTActionPerformed
        menos = sTamanio.getValue()-1;
        if(menos >= 20){
            sTamanio.setValue(menos);
        }
    }//GEN-LAST:event_menosTActionPerformed

    private void masTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masTActionPerformed
        mas = sTamanio.getValue()+1;
        if(mas<=40){
            sTamanio.setValue(mas);
        }
    }//GEN-LAST:event_masTActionPerformed

    private void menosGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menosGActionPerformed
        menos = sGrosor.getValue()-1;
        if(menos >= 1){
            sGrosor.setValue(menos);
            Border border = BorderFactory.createLineBorder(Color.BLACK, menos);
            this.lGrosor.setBorder(border);
        }
    }//GEN-LAST:event_menosGActionPerformed

    private void masGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masGActionPerformed
        mas = sGrosor.getValue()+1;
        if(mas<=5){
            sGrosor.setValue(mas);
            Border border = BorderFactory.createLineBorder(Color.BLACK, mas);
            this.lGrosor.setBorder(border);
        }
    }//GEN-LAST:event_masGActionPerformed

    private void cambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiosActionPerformed
        colorS = new Color(this.botonColor.getBackground().getRGB());
//////////////////////// Para setear valor anterior///////////////////////
        nC = sColor.getValue();
        tamanioS = sTamanio.getValue();
        grosorS = sGrosor.getValue();
        gc = true;
        if(ventana == 1){
            Pp.repaint();
        }else if(ventana ==2){
            Pp.repaint();
        }else if(ventana ==3){
            Pp.repaint();
        }else if(ventana == 4){
            CorreccionPuntosV.agregar.setEnabled(true);
            CorreccionPuntosV.Pp.repaint();
        }
        dispose();
    }//GEN-LAST:event_cambiosActionPerformed

    private void sGrosorStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sGrosorStateChanged
        int valorG = sGrosor.getValue();
        Border border = BorderFactory.createLineBorder(Color.BLACK, valorG);
        this.lGrosor.setBorder(border);
    }//GEN-LAST:event_sGrosorStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonColor;
    private javax.swing.JButton cambios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lGrosor;
    private javax.swing.JButton masC;
    private javax.swing.JButton masG;
    private javax.swing.JButton masT;
    private javax.swing.JButton menosC;
    private javax.swing.JButton menosG;
    private javax.swing.JButton menosT;
    private javax.swing.JLabel numero;
    public static javax.swing.JSlider sColor;
    public static javax.swing.JSlider sGrosor;
    public static javax.swing.JSlider sTamanio;
    // End of variables declaration//GEN-END:variables
    
    public void colocarPp(JLabel Pp){
        this.Pp = Pp;
    }
    
    private void cargarColor() {
        try {
            this.color = new ArrayList<>();
            File c = new File("src\\Fotos\\Paleta.png");
            Image i = ImageIO.read(c);
            
            BufferedImage bi = toBufferedImage(i);
            
            for(int x = 0 ; x<bi.getHeight() ; x++){
                if(this.color.isEmpty()){
                    int mitad = (int)bi.getWidth()/2;
                    int rgb = bi.getRGB(mitad, x);
                    this.color.add(new Color(rgb));
//                    this.color.add(new Color(0,0,0));
                }else{
                    int mitad = (int)bi.getWidth()/2;
                    int rgb = bi.getRGB(mitad, x);
                    int crgb = this.color.get(this.color.size()-1).getRGB();
                    if(rgb != crgb){
                        this.color.add(new Color(rgb));
                    }
                }
            }
            this.color.set(0, Color.BLACK);
        } catch (IOException ex) { }
    }
    
}
