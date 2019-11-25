/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Video;

import static GUI_Generales.Principal.maxPuntos;

import GUI_Generales.Editar;
import GUI_Generales.Instrucciones;
import puntos.HiloV;
import puntos.Nodo;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

/**
 *
 * @author rebel
 */
public class CorreccionPuntosV extends javax.swing.JInternalFrame {

    public JDesktopPane principal;
    public Editar editar;
    public Instrucciones instrucciones;
    public String areaFaltante;
    public int respuesta,valorFalta = maxPuntos+1 ,valorVa = 0;
    public File mas;
    public BufferedImage imagenMas;
    public int numPuntos = 0;
    /**
     * Creates new form CorreccionPuntosV
     */
    public CorreccionPuntosV() {
        initComponents();
    }

    CorreccionPuntosV(JDesktopPane principal) {
        initComponents();
        
        HiloV h = new HiloV(Pp,coordenadaX,coordenadaY);
        if(h.isAlive()){
            
        }else{
            //Finalmente, comienza la ejecución del hilo.
             h.start();
        }
        
        this.principal = principal;
        muestra();
        this.titulo.setText("Seleccionar un máximo de "+maxPuntos+" puntos de interés");
        this.puntosFaltan.setText(""+valorFalta);
        this.puntosFaltan.setHorizontalAlignment(SwingConstants.CENTER);
        this.puntosVan.setText(""+valorVa);
        this.puntosVan.setHorizontalAlignment(SwingConstants.CENTER);
        formas.setEnabled(true);
        this.setLocation((this.principal.getWidth()-this.getWidth())/2,(this.principal.getHeight()-this.getHeight())/2);
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
        jPanel2 = new javax.swing.JPanel();
        formas = new javax.swing.JComboBox<>();
        editarF = new javax.swing.JButton();
        agregar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        puntosVan = new javax.swing.JLabel();
        puntosFaltan = new javax.swing.JLabel();
        aceptar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        coordenadaX = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        coordenadaY = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Pp = new puntos.LabelPaintV();
        jPanel4 = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

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

        agregar.setEnabled(false);
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });

        jLabel2.setText("Puntos Seleccionados:");

        puntosVan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        puntosFaltan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        aceptar.setText("Aceptar");
        aceptar.setEnabled(false);
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });

        jLabel1.setText("Puntos restantes:");

        coordenadaX.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        coordenadaX.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        coordenadaX.setEnabled(false);

        jLabel8.setText("Coordenadas:");

        coordenadaY.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        coordenadaY.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        coordenadaY.setEnabled(false);

        jLabel10.setText("Y:");

        jLabel9.setText("X:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(formas, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(editarF, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(30, 30, 30))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(24, 24, 24))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(coordenadaX, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel8)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(coordenadaY, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(puntosVan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(aceptar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                    .addComponent(puntosFaltan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGap(32, 32, 32)))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(formas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editarF)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(agregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(11, 11, 11)
                .addComponent(puntosVan, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(puntosFaltan, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(coordenadaX, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(coordenadaY, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(aceptar)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Pp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PpMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pp, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        titulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 101, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formasActionPerformed
        switch(formas.getSelectedIndex()){
            case 0:
                this.editarF.setEnabled(false);
                this.agregar.setEnabled(false);
                Instrucciones.ac = false;
                PuntosVideo.vectorNodo.clear();
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
    }//GEN-LAST:event_formasActionPerformed

    private void editarFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarFActionPerformed
        editar = new Editar(this.principal,4);
        principal.add(editar);
        editar.setVisible(true);
    }//GEN-LAST:event_editarFActionPerformed

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        instrucciones = new Instrucciones(this.principal,4);
        principal.add(instrucciones);
        instrucciones.setVisible(true);
        this.aceptar.setEnabled(true);
    }//GEN-LAST:event_agregarActionPerformed

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        if(formas.getSelectedIndex() == 0){
            areaFaltante = "Formas";
            datosFaltan();
        }else if(Editar.gc == false){
            areaFaltante = "Editar";
            datosFaltan();
        }else if(Instrucciones.ac == false || PuntosVideo.vectorNodo.isEmpty()){
            areaFaltante = "boton agregar";
            datosFaltan();
        }else {
            dispose();
        }
    }//GEN-LAST:event_aceptarActionPerformed

    private void PpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PpMouseClicked
        if(Instrucciones.ac == true){
            if(evt.getButton() == MouseEvent.BUTTON1){
                if(numPuntos<=maxPuntos){
                    Nodo n = new Nodo(evt.getX(),evt.getY(),4);
                    PuntosVideo.vectorNodo.add(n);
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
                ///////////////Preguntar del tamaño////////////////////
                int diametro = GUI_Generales.Editar.tamanioS;
                int radio = (int)diametro/2;

                int minX = evt.getX()-radio;
                int maxX = evt.getX()+radio;

                int minY = evt.getY()-radio;
                int maxY = evt.getY()+radio;

                Nodo aux = new Nodo(x,y,4);
                for(int i = 0 ; i < PuntosVideo.vectorNodo.size() ; i++){
                    double xGuardado = PuntosVideo.vectorNodo.get(i).getX();
                    if(xGuardado >= minX && xGuardado <= maxX ){  // 12<x<15
                        double yGuardado = PuntosVideo.vectorNodo.get(i).getY();
                        if(yGuardado >= minY && yGuardado <= maxY ){
                            PuntosVideo.vectorNodo.remove(i);
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

    public void datosFaltan(){
        respuesta = JOptionPane.showConfirmDialog(null,"Falta completar parte de "+areaFaltante,null,
                      JOptionPane.CLOSED_OPTION,JOptionPane.WARNING_MESSAGE);
        while(respuesta!=0){
                  respuesta = JOptionPane.showConfirmDialog(null,"Falta completar parte de "+areaFaltante,null,
                      JOptionPane.CLOSED_OPTION,JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private void muestra() {
        mas = new File("src\\Fotos\\mas_1.jpg");
        try {
            imagenMas = ImageIO.read(mas);
        } catch (IOException ex) {
            Logger.getLogger(CorreccionPuntosV.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.agregar.setIcon(new ImageIcon(imagenMas));
        this.Pp.setIcon(new ImageIcon(PuntosVideo.im.getScaledInstance(300,
                300, Image.SCALE_DEFAULT)));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel Pp;
    private javax.swing.JButton aceptar;
    public static javax.swing.JButton agregar;
    public javax.swing.JLabel coordenadaX;
    public javax.swing.JLabel coordenadaY;
    private javax.swing.JButton editarF;
    public static javax.swing.JComboBox<String> formas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel puntosFaltan;
    private javax.swing.JLabel puntosVan;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
