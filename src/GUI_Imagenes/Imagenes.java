/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Imagenes;

import static GUI_Generales.Principal.Procesos;
import static GUI_Generales.Principal.maxImagenes;
import static GUI_Generales.Principal.maxPuntos;
import static herramientas.GestorImagenes.rutas;

import GUI_Generales.Editar;
import GUI_Generales.Instrucciones;
import GUI_Generales.Seguridad;
import puntos.Hilo;
import puntos.Nodo;
import herramientas.GestorImagenes;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

/**
 *
 * @author Alejandra
 */
public class Imagenes extends javax.swing.JInternalFrame {

    public static ArrayList<Nodo> vectorNodo;
    public static BufferedImage btn;
    public static boolean bandera;
    public static boolean retorno = true;
    public static int forma;
        
    public BufferedImage imagenMas,imagenMenos;
    private List<JButton> botones;
    public BufferedImage leerImagen;
    public JButton boton;
    public int indice = 0;
    public List<BufferedImage> listaIm;
    public File extension;
    public Editar editar;
    private JDesktopPane principal;
    public Seguridad ventanaSeguridad;
    public String areaFaltante,proceso,rutaUsuario;
    public Pasos pasos;
    public Instrucciones instrucciones;
    public int respuestaSeguridad;
    public int numPuntos;
    public int valorFalta = maxPuntos+1, valorVa = 0;
    /**
     * Creates new form AbrirImagen
     */
    public Imagenes() {
        initComponents();
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        botones = new ArrayList<>();
        listaIm = new ArrayList<>();
        mostrar();
        this.vectorNodo = new ArrayList<>();
        
        numPuntos = 0;
        
        this.titulo.setText("4.- Seleccionar máximo " + (maxPuntos+1) + " puntos de interés");
        this.setLocation((this.principal.getWidth()-this.getWidth())/2,(this.principal.getHeight()-this.getHeight())/2);
    }

    Imagenes(JDesktopPane principal) {
        initComponents();
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        this.setResizable(true);
        mostrar();
        
        for(int i=0;i<Procesos.size();i++){
            String proceso = Procesos.get(i);
            nomProceso.addItem(proceso);
        }
        
        botones = new ArrayList<>();
        listaIm = new ArrayList<>();
        this.principal = principal;
        
        this.vectorNodo = new ArrayList<>();
        
        numPuntos = 0;
        
        this.titulo.setText("4.- Seleccionar máximo " + (maxPuntos+1) + " puntos de interés");
        this.setLocation((this.principal.getWidth()-this.getWidth())/2,(this.principal.getHeight()-this.getHeight())/2);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        nomProceso = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        nombreProceso = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        grupo = new javax.swing.JTextField();
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
        Pp = new puntos.LabelPaint();
        jPanel15 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        puntosVan4 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        puntosFaltan4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        regresar = new javax.swing.JButton();
        aceptar = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 4));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setEnabled(false);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "2.- Tipos de proceso", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 16), new java.awt.Color(0, 153, 153))); // NOI18N

        nomProceso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona una opcion" }));
        nomProceso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nomProceso.setEnabled(false);
        nomProceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomProcesoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nomProceso, 0, 201, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(nomProceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "3.- Datos Generales", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 16), new java.awt.Color(0, 153, 153))); // NOI18N

        jLabel4.setText("Nombre del Proceso:");

        nombreProceso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nombreProceso.setEnabled(false);
        nombreProceso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreProcesoKeyTyped(evt);
            }
        });

        jLabel6.setText("Nombre del Alumno:");

        nombre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nombre.setEnabled(false);
        nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreKeyTyped(evt);
            }
        });

        jLabel7.setText("Grupo o Cargo:");

        grupo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        grupo.setEnabled(false);
        grupo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                grupoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombre)
                    .addComponent(grupo)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(nombreProceso))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel6)
                .addGap(8, 8, 8)
                .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(grupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombreProceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        titulo.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        titulo.setForeground(new java.awt.Color(0, 153, 153));
        titulo.setText("s");

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
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(formas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editarF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(coordenadaX, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(coordenadaY, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(formas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editarF)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(agregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

        Pp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Pp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PpMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pp, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
        );

        jLabel16.setText("Puntos seleccionados:");

        jLabel17.setText("Puntos restantes:");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(puntosVan4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(puntosFaltan4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(puntosFaltan4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(puntosVan4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel17)
                        .addComponent(jLabel16)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap(18, Short.MAX_VALUE)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(titulo)
                .addGap(35, 35, 35)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "1.- Selección de Imágenes", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 16), new java.awt.Color(0, 153, 153))); // NOI18N

        panel.setLayout(new java.awt.GridLayout(4, 1));
        jScrollPane1.setViewportView(panel);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        regresar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        regresar.setForeground(new java.awt.Color(0, 153, 153));
        regresar.setText("Regresar");
        regresar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 153), 1, true));
        regresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });

        aceptar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        aceptar.setForeground(new java.awt.Color(0, 153, 153));
        aceptar.setText("Aceptar");
        aceptar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 153), 1, true));
        aceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        aceptar.setEnabled(false);
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(180, 180, 180))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(regresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 9, Short.MAX_VALUE)))
                .addGap(5, 5, 5)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        if(nombre.getText().length()<1 || grupo.getText().length()<1 || nombreProceso.getText().length()<1){
            areaFaltante = "Datos Generales";
            datosFaltan();
        }else if(formas.getSelectedIndex()==0 || Editar.gc==false || Instrucciones.ac==false || vectorNodo.size()==0){
            areaFaltante = "Selección de puntos de interés";
            datosFaltan();
        }else{
            dispose();
            CorreccionImagenes ci = new CorreccionImagenes(this.principal,listaIm);
            
            int index = nomProceso.getSelectedIndex();
            String nProceso = nomProceso.getItemAt(index);
            String nom = nombre.getText();
            String g = grupo.getText();
            String np = nombreProceso.getText();
            
            int f = formas.getSelectedIndex();
            
            ci.pasarProceso(nProceso,nom,g,np);
            ci.forma(f);
            
            this.principal.add(ci);
            ci.setVisible(true);
            ci.muestra();
            guardarI();
        }
    }//GEN-LAST:event_aceptarActionPerformed

    private void editarFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarFActionPerformed
        editar = new Editar(this.principal,1);
        editar.colocarPp(Pp);
        principal.add(editar);
        editar.setVisible(true); 
        agregar.setEnabled(true);
    }//GEN-LAST:event_editarFActionPerformed

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed

        instrucciones = new Instrucciones(this.principal,1);
        principal.add(instrucciones);
        instrucciones.setVisible(true);
       
        Hilo h = new Hilo(Pp,coordenadaX,coordenadaY);
        if(h.isAlive()){
            
        }else{
            //Finalmente, comienza la ejecución del Hilo.
             h.start();
        }
        
        System.out.println("Numero de puntos seleccionados : "+this.numPuntos);
       
        for(int x = 0 ; x<this.vectorNodo.size();x++){
            System.out.println("# "+x+" X : "+vectorNodo.get(x).getX()+" Y : "+vectorNodo.get(x).getY());
        }
    }//GEN-LAST:event_agregarActionPerformed

    private void PpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PpMouseClicked
        if(this.bandera == true && Instrucciones.ac == true && retorno == false){
            if(evt.getButton() == MouseEvent.BUTTON1){
                if(numPuntos<=maxPuntos){
                    Nodo n = new Nodo(evt.getX(),evt.getY(),1);
                    this.vectorNodo.add(n);
                    System.out.println("X: "+evt.getX()+" , Y: "+evt.getY());
                    numPuntos++;
                    
                    valorFalta = valorFalta - 1; //Para mostrar cuantos puntos faltan por seleccionar
                    this.puntosFaltan4.setText(""+valorFalta);
                    valorVa = valorVa + 1; //Para mostrar cuantos puntos se seleccionaron
                    this.puntosVan4.setText(""+valorVa);
                    
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

                Nodo aux = new Nodo(x,y,1);
                for(int i = 0 ; i < vectorNodo.size() ; i++){
                    double xGuardado = vectorNodo.get(i).getX();
                    if(xGuardado >= minX && xGuardado <= maxX ){  // 12<x<15
                        double yGuardado = vectorNodo.get(i).getY();
                        if(yGuardado >= minY && yGuardado <= maxY ){
                            vectorNodo.remove(i);
                            numPuntos--;
                            
                            valorFalta = valorFalta + 1; //Para mostrar cuantos puntos faltan por seleccionar
                            this.puntosFaltan4.setText(""+valorFalta);
                            valorVa = valorVa - 1; //Para mostrar cuantos puntos se seleccionaron
                            this.puntosVan4.setText(""+valorVa);
                            
                            break;
                        }
                    }
                }
                Pp.repaint();
            }
        }
    }//GEN-LAST:event_PpMouseClicked

    private void formasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formasActionPerformed
        switch(formas.getSelectedIndex()){
            case 0:
                this.editarF.setEnabled(false);
                this.agregar.setEnabled(false);
                coordenadaX.setText("");
                coordenadaY.setText("");
                retorno = true;
                Instrucciones.ac = false;
                vectorNodo.clear();
                numPuntos = 0;
                valorFalta = maxPuntos+1;
                valorVa = 0;
                Pp.repaint();
                break;
            case 1:
                this.editarF.setEnabled(true);
                retorno = false;
                Pp.repaint();
                break;
            case 2:
                this.editarF.setEnabled(true);
                retorno = false;
                Pp.repaint();
                break;
            case 3:
                this.editarF.setEnabled(true);
                retorno = false;
                Pp.repaint();
                break;
        }
        forma = formas.getSelectedIndex();
    }//GEN-LAST:event_formasActionPerformed

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        nombre.setText("");
        grupo.setText("");
        nombreProceso.setText("");
        formas.setSelectedIndex(0);
        Instrucciones.ac = false;
        vectorNodo.clear();
        rutas.clear();
        listaIm.clear();
        botones.clear();
        btn = null;
        Pp.repaint();
        
        if(editar != null){
            Editar.sColor.setValue(0);
            Editar.sTamanio.setValue(0);
            Editar.sGrosor.setValue(0);
        }
        
        
        dispose();
        GUI_Generales.Principal.archivos.setEnabled(true);
        GUI_Generales.Principal.creditos.setEnabled(true);
//        abrirI();
    }//GEN-LAST:event_regresarActionPerformed

    private void grupoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_grupoKeyTyped
        this.nombreProceso.setEnabled(true);
    }//GEN-LAST:event_grupoKeyTyped

    private void nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreKeyTyped
        this.grupo.setEnabled(true);
    }//GEN-LAST:event_nombreKeyTyped

    private void nombreProcesoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreProcesoKeyTyped
        //        this.agregar.setEnabled(true);
        this.formas.setEnabled(true);
        //        this.editarF.setEnabled(true);
        this.aceptar.setEnabled(true);
    }//GEN-LAST:event_nombreProcesoKeyTyped

    private void nomProcesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomProcesoActionPerformed
        if(nomProceso.getSelectedIndex()==0){
            this.nombre.setEnabled(false);
            this.nombre.setText("");
            this.nombre.setEnabled(false);
            this.nombre.setText("");
            this.nombreProceso.setEnabled(false);
            this.nombreProceso.setText("");
            this.grupo.setEnabled(false);
            this.grupo.setText("");
            formas.setSelectedIndex(0);
            formas.setEnabled(false);
        }else{
            this.nombre.setEnabled(true);
            proceso = Procesos.get(nomProceso.getSelectedIndex()-1);
        }
    }//GEN-LAST:event_nomProcesoActionPerformed
        
    public void mostrar(){        
        ImageIcon mas = new ImageIcon("src\\Fotos\\mas.png");
        mas.setImage(mas.getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT));
        agregar.setIcon(mas);
        agregar.setContentAreaFilled(false);
        agregar.setRolloverIcon(new ImageIcon(mas.getImage().getScaledInstance(65,
                        65,Image.SCALE_DEFAULT)));
    }
    
    public void muestraSeleccion(){
        //Aqui se define el tamaño del Grid, columnas -- Filas
        panel.setLayout(new GridLayout(rutas.size(),0));
        //Crea los botones, se les define la imagen y se crea actionPerfomed a cada boton
        for(int i=0;i<rutas.size();i++){
            try {
                extension = new File(rutas.get(i));
//                leerImagen = ImageIO.read(extension);
                ImageIO.setUseCache(false);
                leerImagen = ImageIO.read(extension.toURI().toURL());
                boton = new JButton(""+(i+1));

                boton.setContentAreaFilled(false);
                //Se acomoda el numero de la imagen en la parte inferior
                boton.setHorizontalTextPosition(SwingConstants.CENTER);
                boton.setVerticalTextPosition(SwingConstants.BOTTOM);
                int g = (panel.getWidth())-((35*panel.getWidth())/100);
                int g2 = (panel.getWidth())-((26*panel.getWidth())/100);
                boton.setRolloverIcon(new ImageIcon(leerImagen.getScaledInstance(g2,
                        g2,Image.SCALE_DEFAULT)));
                
                listaIm.add(leerImagen);

                boton.setIcon(new ImageIcon(leerImagen.getScaledInstance(g,
                        g,Image.SCALE_DEFAULT)));
                
                boton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        //remover icono anterior
                        boton.removeAll();
                        int x = Integer.parseInt(ae.getActionCommand().toString());
                        btn = listaIm.get(x-1);
                        Pp.repaint();
                        System.out.println(" "+ae.getActionCommand().toString());
///////////////////Para verificar  que si seleccionan una opcion/////////////////
                        bandera = true;
                        System.out.println("*************"+bandera+"*************");
                        nomProceso.setEnabled(true);
                    }
                });
                botones.add(boton);
                panel.add(boton);
                
                panel.updateUI();
                System.out.println(i+"\n");
                indice++;
            } catch (IOException ex1) {
                Logger.getLogger(Imagenes.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    public void datosFaltan(){
        int respuesta = JOptionPane.showConfirmDialog(null,"Falta completar área de "+areaFaltante,null,
                      JOptionPane.CLOSED_OPTION,JOptionPane.WARNING_MESSAGE);
        while(respuesta!=0){
                  respuesta = JOptionPane.showConfirmDialog(null,"Falta completar área de "+areaFaltante,null,
                      JOptionPane.CLOSED_OPTION,JOptionPane.WARNING_MESSAGE);
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
    
    public void abrirI(){
        boolean abrirImagenes = GestorImagenes.abrirImagenes();
        if(abrirImagenes==true){
            abrirS();
            if(respuestaSeguridad==0){
                  if(rutas.size() <= maxImagenes){
                        pasos = new Pasos(this.principal);
                        this.principal.add(pasos);
                        pasos.setVisible(true);
                    }else{
                        Validacion v = new Validacion(principal);
                        this.principal.add(v);
                        v.setVisible(true);
                    }
              }else if(respuestaSeguridad==1){
                  abrirI();
              }
        }
    }
    
    public void guardarI() {
        try {
            rutaUsuario = System.getProperty("user.home");
            File rutaGeneral = new File(rutaUsuario+"\\Documents\\SMIM\\Proceso\\");
            File rutaImagen = new File(rutaGeneral.getAbsolutePath() + "\\imagenPrincipal.png");
            if(!rutaGeneral.exists()){
                rutaGeneral.mkdirs();
            }
            ImageIO.write(btn, "png", rutaImagen);
        } catch (IOException ex) {
            Logger.getLogger(Imagenes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel Pp;
    private javax.swing.JButton aceptar;
    public javax.swing.JButton agregar;
    public javax.swing.JLabel coordenadaX;
    public javax.swing.JLabel coordenadaY;
    private javax.swing.JButton editarF;
    public javax.swing.JComboBox<String> formas;
    public javax.swing.JTextField grupo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JComboBox<String> nomProceso;
    public javax.swing.JTextField nombre;
    public javax.swing.JTextField nombreProceso;
    public javax.swing.JPanel panel;
    private javax.swing.JLabel puntosFaltan4;
    private javax.swing.JLabel puntosVan4;
    private javax.swing.JButton regresar;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables

}
