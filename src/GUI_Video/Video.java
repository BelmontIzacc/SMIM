/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Video;


import static GUI_Generales.Prueba.Procesos;
import static GUI_Generales.Prueba.Tiempo;

import GUI_Generales.Cargando;
import GUI_Generales.HiloTest;
import herramientas.GestorVideo;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.MultimediaInfo;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.media.MediaPlayer;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.bytedeco.javacv.OpenCVFrameConverter;

/**
 *
 * @author Alejandra
 */
public final class Video extends javax.swing.JInternalFrame {
    
    public static String ruta;
    public static String rutaGeneral;
    public static String tipoProcesoSelect;
    
    public boolean abrirVideo;
    public JDesktopPane principal;
    public int respuestaSeguridad, respuesta;
    public Cargando cargando;
    public File file;
    public MediaPlayer oracleVid;
    public long vInfo;
    public File rutaCbat;
    public long maximo;
    public String rutaNueva;
    public String rutaUsuario;

    /**
     * Creates new form Video
     */
    public Video() {
        initComponents();
        Platform.setImplicitExit(false);
    }

    public Video(JDesktopPane principal) {
        initComponents();
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        this.principal = principal;
        this.setResizable(false);
        this.setLocation((this.principal.getWidth()-this.getWidth())/2,(this.principal.getHeight()-this.getHeight())/2);
               
        for(int i=0;i<Procesos.size();i++){
            tipoProceso.addItem(Procesos.get(i));
        }
        
        for(int y=0; y<Tiempo.size(); y++){
            tiempoImagenes.addItem(Tiempo.get(y));
        }
        
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
        datos = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        nombreProceso = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        nombreAlumno = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Grupo = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        tiempoImagenes = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        tipoProceso = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        regresar = new javax.swing.JButton();
        aceptar = new javax.swing.JButton();

        setResizable(true);

        datos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setText("Nombre del Proceso:");

        nombreProceso.setEnabled(false);
        nombreProceso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreProcesoKeyTyped(evt);
            }
        });

        jLabel6.setText("Nombre del alumno o Profesor:");

        nombreAlumno.setEnabled(false);
        nombreAlumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreAlumnoKeyTyped(evt);
            }
        });

        jLabel7.setText("Grupo o Cargo:");

        Grupo.setEnabled(false);
        Grupo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                GrupoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombreProceso, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                    .addComponent(nombreAlumno)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(Grupo))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nombreProceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nombreAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Grupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setText("Tiempo para obtención de imágenes:");

        tiempoImagenes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar una opcion" }));
        tiempoImagenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tiempoImagenesActionPerformed(evt);
            }
        });

        jLabel3.setText("Tipo de Proceso:");

        tipoProceso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona una opcion" }));
        tipoProceso.setEnabled(false);
        tipoProceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoProcesoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabel3)
                        .addGap(0, 73, Short.MAX_VALUE)))
                .addGap(27, 27, 27))
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tipoProceso, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tiempoImagenes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tiempoImagenes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(tipoProceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout datosLayout = new javax.swing.GroupLayout(datos);
        datos.setLayout(datosLayout);
        datosLayout.setHorizontalGroup(
            datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        datosLayout.setVerticalGroup(
            datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
                .addComponent(aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceptar)
                    .addComponent(regresar))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(datos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(datos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        dispose();
        ruta = "";
        GestorVideo.video = null;
        System.gc();
        eliminarArchivo(rutaGeneral);
        abrirV();
    }//GEN-LAST:event_regresarActionPerformed

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        if(tiempoImagenes.getSelectedIndex()==0 || nombreProceso.getText().length()==0 
                || nombreAlumno.getText().length()==0 || Grupo.getText().length()==0){
            respuesta = JOptionPane.showConfirmDialog(null,"Falta completar un campo",null,
                      JOptionPane.CLOSED_OPTION,JOptionPane.WARNING_MESSAGE);
            while(respuesta!=0){
                      respuesta = JOptionPane.showConfirmDialog(null,"Falta completar un campo",null,
                          JOptionPane.CLOSED_OPTION,JOptionPane.WARNING_MESSAGE);
            }
        }else{
            dispose();
            int tipoP = this.tipoProceso.getSelectedIndex();
            
            String tipo = this.tipoProceso.getItemAt(tipoP);
            String g = this.Grupo.getText();
            String al = this.nombreAlumno.getText();
            String np = this.nombreProceso.getText();
                    
            tipoProcesoSelect = tipo;
            
            PuntosVideo pv = new PuntosVideo(this.principal,rutaNueva,(tiempoImagenes.getSelectedIndex()-1),tipo,
                np,al,g);
            principal.add(pv);
            pv.setVisible(true);
        }
    }//GEN-LAST:event_aceptarActionPerformed

    private void nombreProcesoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreProcesoKeyTyped
        this.nombreAlumno.setEnabled(true);
    }//GEN-LAST:event_nombreProcesoKeyTyped

    private void nombreAlumnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreAlumnoKeyTyped
        this.Grupo.setEnabled(true);
    }//GEN-LAST:event_nombreAlumnoKeyTyped

    private void GrupoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GrupoKeyTyped
        this.aceptar.setEnabled(true);
    }//GEN-LAST:event_GrupoKeyTyped

    private void tiempoImagenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tiempoImagenesActionPerformed
        switch(tiempoImagenes.getSelectedIndex()){
            case 0:
                tipoProceso.setEnabled(false);
                tipoProceso.setSelectedIndex(0);
                nombreProceso.setEnabled(false);
                nombreProceso.setText("");
                nombreAlumno.setEnabled(false);
                nombreAlumno.setText("");
                Grupo.setEnabled(false);
                Grupo.setText("");
                aceptar.setEnabled(false);
                break;
            case 1:
                tipoProceso.setEnabled(true);
                break;
            case 2:
                tipoProceso.setEnabled(true);
                break;
            case 3:
                tipoProceso.setEnabled(true);
                break;
        }
    }//GEN-LAST:event_tiempoImagenesActionPerformed

    private void tipoProcesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoProcesoActionPerformed
        switch(tipoProceso.getSelectedIndex()){
            case 0:
                nombreProceso.setEnabled(false);
                nombreProceso.setText("");
                nombreAlumno.setEnabled(false);
                nombreAlumno.setText("");
                Grupo.setEnabled(false);
                Grupo.setText("");
                aceptar.setEnabled(false);
                break;
            case 1:
                nombreProceso.setEnabled(true);
                break;
            case 2:
                nombreProceso.setEnabled(true);
                break;
            case 3:
                nombreProceso.setEnabled(true);
                break;
        }
    }//GEN-LAST:event_tipoProcesoActionPerformed

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
            Frame frame = frameGrabber.grabImage();
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
        Frame frame = grabberConverter.convert( src );
        
        return paintConverter.getBufferedImage( frame,1 );
    } 
    
    public void crearCbat(){
        Encoder encoder = new Encoder();
        MultimediaInfo info;
        long dInfo = 0;
        maximo = GUI_Generales.Prueba.duracionVideo*1000;
        try {
            File vAux = new File(GestorVideo.video);
            info = encoder.getInfo(vAux);
            dInfo = info.getDuration();
            rutaUsuario = System.getProperty("user.home");
            
            rutaGeneral = rutaUsuario+"\\Documents\\SMIM\\Proceso\\";
            
            File rG = new File(rutaGeneral);
            rutaCbat = new File(rG.getAbsolutePath() + "\\c.bat");
            rutaNueva = rutaUsuario+"\\Documents\\SMIM\\Proceso\\VideoReducido.mp4";
            if(!rG.exists()){
                rG.mkdirs();
            }
            BufferedWriter bw;
            bw = new BufferedWriter(new FileWriter(rutaCbat));
            if(dInfo>maximo){
                bw.write("@echo No sierre la ventana, al terminar se cierra sola\n" +
                "ffmpeg -y -i "+ GestorVideo.video + " -preset superfast -t "+GUI_Generales.Prueba.duracionVideo+" -s 440x440 -ab 98k -an " +
                rutaNueva + "\n" + "@echo termino!\n" + "exit");
            }else{
                bw.write("@echo No sierre la ventana, al terminar se cierra sola\n" +
                "ffmpeg -y -i "+ GestorVideo.video + " -preset superfast -s 440x440 -ab 98k -an "+ rutaNueva + "\n" +
                "@echo termino!\n" + "exit");
            }            
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Video.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EncoderException ex) {
            Logger.getLogger(Video.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    public String cmd(){
        crearCbat();
        Runtime rt = Runtime.getRuntime();
        try {
            
            String linea;
            Process p = rt.exec(new String[]{"cmd.exe","/c","start","/MIN",rutaCbat.getAbsolutePath()});
            BufferedReader input = new BufferedReader (new InputStreamReader(p.getInputStream()));
            while((linea=input.readLine())!=null){
                System.out.println(linea);
            }
            input.close();
            
            String rutaFin = rutaGeneral+"\\Video.mp4.bak";
            Path origen = Paths.get(rutaNueva);
            Path fin = Paths.get(rutaFin);
            Files.copy(origen, fin,StandardCopyOption.REPLACE_EXISTING);
            
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        rt.runFinalization();
        
        return rutaNueva;
    }
    
    public void abrirV(){
        abrirVideo = GestorVideo.abrirVideo();
        long dInfo = duracionVideo();
        if(abrirVideo==true){
            abrirS();
            if(respuestaSeguridad==0){
                cargando = new Cargando(this.principal,dInfo);
                this.principal.add(cargando);
                HiloTest.active  = true;
                HiloTest h = new HiloTest(cargando);
                h.start();
                h.interrupt();
            }else if(respuestaSeguridad==1){
                abrirV();
            }
        }
    }
    
    public long duracionVideo(){
        if(GestorVideo.video==null){
            vInfo = 0;
            return vInfo;
        }else{
            Encoder encoder = new Encoder();
            MultimediaInfo info;
            try {
                File vAux = new File(GestorVideo.video);
                info = encoder.getInfo(vAux);
                vInfo = info.getDuration();
                System.out.println(""+vInfo);
            } catch (EncoderException ex) {
                Logger.getLogger(Video.class.getName()).log(Level.SEVERE, null, ex);
            }
            return vInfo;
        }
    }
    
    public void abrirS(){
        respuestaSeguridad = JOptionPane.showConfirmDialog(null,"¿Estas seguro de la selección?",null,
                      JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        while(respuestaSeguridad!=0 && respuestaSeguridad!=1){
                  respuestaSeguridad = JOptionPane.showConfirmDialog(null,"¿Estas seguro de la selección?",null,
                          JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void eliminarArchivo(String ruta){
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
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField Grupo;
    private javax.swing.JButton aceptar;
    private javax.swing.JPanel datos;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    public javax.swing.JTextField nombreAlumno;
    public javax.swing.JTextField nombreProceso;
    private javax.swing.JButton regresar;
    public javax.swing.JComboBox<String> tiempoImagenes;
    public javax.swing.JComboBox<String> tipoProceso;
    // End of variables declaration//GEN-END:variables

}