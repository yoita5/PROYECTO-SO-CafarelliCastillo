/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import Codigo.Cola;
import Codigo.Nodo;
import Codigo.Proceso;
import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import proyecto1.gabriele.yoarly.MainClass;
import static proyecto1.gabriele.yoarly.MainClass.ProcesosCPUFCFS;
import static proyecto1.gabriele.yoarly.MainClass.ProcesosCPUHRRN;
import static proyecto1.gabriele.yoarly.MainClass.ProcesosCPURR;
import static proyecto1.gabriele.yoarly.MainClass.ProcesosCPUSPN;
import static proyecto1.gabriele.yoarly.MainClass.ProcesosCPUSRT;
import static proyecto1.gabriele.yoarly.MainClass.ProcesosIOFCFS;
import static proyecto1.gabriele.yoarly.MainClass.ProcesosIOHRRN;
import static proyecto1.gabriele.yoarly.MainClass.ProcesosIORR;
import static proyecto1.gabriele.yoarly.MainClass.ProcesosIOSPN;
import static proyecto1.gabriele.yoarly.MainClass.ProcesosIOSRT;
import static proyecto1.gabriele.yoarly.MainClass.cpu1;
import static proyecto1.gabriele.yoarly.MainClass.cpu2;
import static proyecto1.gabriele.yoarly.MainClass.cpu3;
import static proyecto1.gabriele.yoarly.MainClass.colaListos;
import static proyecto1.gabriele.yoarly.MainClass.colaBloqueados;
import static proyecto1.gabriele.yoarly.MainClass.colaTerminados;
import static proyecto1.gabriele.yoarly.MainClass.mainWindow;



/**
 *
 */
public class MainWindow extends javax.swing.JFrame {
   public CPUpane cpuPane1;
    public CPUpane cpuPane2;
    public CPUpane cpuPane3;
    private int cicloDuracion;
     

   private GraficoTorta graficoTorta;
   private GraficoBarrasTiempo graficoBarrasTiempo;
    /**
     * 
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
        
        
        cargarConfiguracion(); 
        configurarSpinners();
        ActualizarEstadisticas();
        
ListosContainer.setLayout(new BoxLayout(ListosContainer, BoxLayout.X_AXIS));
    Blista.setLayout(new BoxLayout(Blista, BoxLayout.X_AXIS));
        Tlista.setLayout(new BoxLayout(Tlista, BoxLayout.X_AXIS));

    // Iniciar el hilo de actualización
    iniciarActualizacionAutomatica(MainClass.colaListos, ListosContainer, MainClass.colaBloqueados, Blista, MainClass.colaTerminados, Tlista);
        
agregarGraficoThroughput();
agregarGraficoTorta();
iniciarActualizacionGraficoTorta();
agregarGraficoBarrasTiempo();
iniciarActualizacionGraficoBarrasTiempo();
jScrollPane1.setPreferredSize(new java.awt.Dimension(200, 150));

// Crear y añadir los paneles de CPU
 cpuPane1 = new CPUpane(cpu1);
 cpuPane2 = new CPUpane(cpu2);
 cpuPane3 = new CPUpane(cpu3);

cpuContainer1.setLayout(new java.awt.BorderLayout());
cpuContainer1.add(cpuPane1, java.awt.BorderLayout.CENTER);

cpuContainer2.setLayout(new java.awt.BorderLayout());
cpuContainer2.add(cpuPane2, java.awt.BorderLayout.CENTER);

cpuContainer3.setLayout(new java.awt.BorderLayout());
cpuContainer3.add(cpuPane3, java.awt.BorderLayout.CENTER);

cpuContainer1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0)); // Sin margen
cpuContainer2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
cpuContainer3.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

cpuPane1.setPreferredSize(new java.awt.Dimension(200, 150)); // Ancho y alto específicos
cpuPane2.setPreferredSize(new java.awt.Dimension(200, 150));
cpuPane3.setPreferredSize(new java.awt.Dimension(200, 150));


       
         TipoCB.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            // Obtener el elemento seleccionado en el ComboBox
            String tipoSeleccionado = (String) TipoCB.getSelectedItem();

            // Comprobar si es "CPU bound" o "I/O bound"
            if ("CPU bound".equals(tipoSeleccionado)) {
                // Deshabilitar los spinners de ciclos para excepciones
                CiclosParaGenSpinner.setEnabled(false);
                CiclosParaSatisExcSpinner.setEnabled(false);
            } else if ("I/O bound".equals(tipoSeleccionado)) {
                // Habilitar los spinners de ciclos para excepciones
                CiclosParaGenSpinner.setEnabled(true);
                CiclosParaSatisExcSpinner.setEnabled(true);
            }
        }
    });
    }
    
    public int getCicloDuracion() {
    return cicloDuracion; // Retorna la duración del ciclo
}

public void setCicloDuracion(int duracion) {
    this.cicloDuracion = duracion; // Actualiza la duración
}



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TabContainer = new javax.swing.JTabbedPane();
        jPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        TituloCrearProceso = new javax.swing.JLabel();
        NombreTF = new javax.swing.JTextField();
        NombreLabel = new javax.swing.JLabel();
        CantInstruccionesSpinner = new javax.swing.JSpinner();
        CantInstruccionesLabel = new javax.swing.JLabel();
        TipoLabel = new javax.swing.JLabel();
        TipoCB = new javax.swing.JComboBox<>();
        CrearProcesoButton = new javax.swing.JButton();
        CiclosParaSatisExcSpinner = new javax.swing.JSpinner();
        CiclosParaGenSpinner = new javax.swing.JSpinner();
        CiclosParaSatisExcSpinner1 = new javax.swing.JLabel();
        CiclosParaSatisExcSpinner2 = new javax.swing.JLabel();
        CiclosParaGenSpinner1 = new javax.swing.JLabel();
        CiclosParaGenSpinner2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        PoliticadePlanificacionCB = new javax.swing.JComboBox<>();
        TituloCambiarPoliticadePlanificacion = new javax.swing.JLabel();
        GuardarCambiosPlanificacionButton = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        cpuContainer1 = new javax.swing.JPanel();
        cpuContainer2 = new javax.swing.JPanel();
        cpuContainer3 = new javax.swing.JPanel();
        NumciclorrelojLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListosContainer = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Blista = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tlista = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        ConfiguracionTab = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        TituloPpalConfiguracion = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        CambiarnumCPUsLabel = new javax.swing.JLabel();
        CambiarnumCPUsCB = new javax.swing.JComboBox<>();
        GuardarCambiosNumCPU = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        NumeroCPUSACTUALEs = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        CambiarduracionCiclosLabel = new javax.swing.JLabel();
        GuardarCambiosDuracionCiclos = new javax.swing.JButton();
        DuracionCiclosSpinner = new javax.swing.JSpinner();
        SegundostituloLabel = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        NumeroCICLOACTUAL = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        GraficosTab = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        CompTH = new javax.swing.JPanel();
        IOCPU = new javax.swing.JPanel();
        CompTiempos = new javax.swing.JPanel();
        EstadisticasTab = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        ProcesosTotTerminadosLB = new javax.swing.JLabel();
        ThroughputGen = new javax.swing.JLabel();
        CicloActLB = new javax.swing.JLabel();
        ioboundTot = new javax.swing.JLabel();
        cpuboundTot = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        TiempoFCFS = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        nroProcesosFCFSLB = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        IOFCFSLB = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        CPUFCFSLB = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        THFCFS = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        TiempoRR = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        nroProcesosRRLB = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        IORRLB = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        CPURRLB = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        THRR = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        TiempoSPN = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        nroProcesosSPNLB = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        IOSPNLB = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        CPUSPNLB = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        THSPN = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        TiempoSRT = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        nroProcesosSRT = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        IOSRTLB = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        CPUSRTLB = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        THSRT = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        TiempoHRRN = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        nroProcesosHRRN = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        IOHRRNLB = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        CPUHRRNLB = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        THHRRN = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel.setBackground(new java.awt.Color(51, 51, 51));
        jPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(222, 225, 242));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TituloCrearProceso.setText("Crear Proceso");
        jPanel1.add(TituloCrearProceso, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 12, -1, -1));

        NombreTF.setToolTipText("Ingresa el nombre");
        NombreTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreTFActionPerformed(evt);
            }
        });
        jPanel1.add(NombreTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 34, 150, -1));

        NombreLabel.setText("Nombre:");
        jPanel1.add(NombreLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 37, -1, -1));

        CantInstruccionesSpinner.setValue(1);
        jPanel1.add(CantInstruccionesSpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 68, 150, -1));

        CantInstruccionesLabel.setText("Cant. Instrucciones:");
        jPanel1.add(CantInstruccionesLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 71, -1, -1));

        TipoLabel.setText("Tipo:");
        jPanel1.add(TipoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 105, -1, -1));

        TipoCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "I/O bound", "CPU bound" }));
        jPanel1.add(TipoCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 102, 150, -1));

        CrearProcesoButton.setText("Crear Proceso");
        CrearProcesoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearProcesoButtonActionPerformed(evt);
            }
        });
        jPanel1.add(CrearProcesoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 204, -1, -1));

        CiclosParaSatisExcSpinner.setValue(1);
        jPanel1.add(CiclosParaSatisExcSpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 173, 150, -1));

        CiclosParaGenSpinner.setValue(1);
        jPanel1.add(CiclosParaGenSpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 136, 150, -1));

        CiclosParaSatisExcSpinner1.setText("Ciclos para Satisfacer");
        jPanel1.add(CiclosParaSatisExcSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        CiclosParaSatisExcSpinner2.setText("Excepción:");
        jPanel1.add(CiclosParaSatisExcSpinner2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, 20));

        CiclosParaGenSpinner1.setText("Ciclos para Generar");
        jPanel1.add(CiclosParaGenSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        CiclosParaGenSpinner2.setText("Excepción:");
        jPanel1.add(CiclosParaGenSpinner2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, 20));

        jPanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 29, 300, 237));

        jPanel2.setBackground(new java.awt.Color(222, 225, 242));

        PoliticadePlanificacionCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FCFS", "Round Robin", "SPN", "SRT", "HRRN" }));
        PoliticadePlanificacionCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PoliticadePlanificacionCBActionPerformed(evt);
            }
        });

        TituloCambiarPoliticadePlanificacion.setText("Cambiar Política de Planificación");

        GuardarCambiosPlanificacionButton.setText("Guardar Cambios");
        GuardarCambiosPlanificacionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarCambiosPlanificacionButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TituloCambiarPoliticadePlanificacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PoliticadePlanificacionCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(GuardarCambiosPlanificacionButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TituloCambiarPoliticadePlanificacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PoliticadePlanificacionCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(GuardarCambiosPlanificacionButton)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 302, 300, -1));

        jPanel7.setBackground(new java.awt.Color(222, 225, 242));
        jPanel7.setLayout(new java.awt.GridLayout(3, 1, 10, 10));

        javax.swing.GroupLayout cpuContainer1Layout = new javax.swing.GroupLayout(cpuContainer1);
        cpuContainer1.setLayout(cpuContainer1Layout);
        cpuContainer1Layout.setHorizontalGroup(
            cpuContainer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 209, Short.MAX_VALUE)
        );
        cpuContainer1Layout.setVerticalGroup(
            cpuContainer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 177, Short.MAX_VALUE)
        );

        jPanel7.add(cpuContainer1);

        javax.swing.GroupLayout cpuContainer2Layout = new javax.swing.GroupLayout(cpuContainer2);
        cpuContainer2.setLayout(cpuContainer2Layout);
        cpuContainer2Layout.setHorizontalGroup(
            cpuContainer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 209, Short.MAX_VALUE)
        );
        cpuContainer2Layout.setVerticalGroup(
            cpuContainer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 177, Short.MAX_VALUE)
        );

        jPanel7.add(cpuContainer2);

        javax.swing.GroupLayout cpuContainer3Layout = new javax.swing.GroupLayout(cpuContainer3);
        cpuContainer3.setLayout(cpuContainer3Layout);
        cpuContainer3Layout.setHorizontalGroup(
            cpuContainer3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 209, Short.MAX_VALUE)
        );
        cpuContainer3Layout.setVerticalGroup(
            cpuContainer3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 177, Short.MAX_VALUE)
        );

        jPanel7.add(cpuContainer3);

        jPanel.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1035, 29, -1, -1));

        NumciclorrelojLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        NumciclorrelojLabel.setForeground(new java.awt.Color(255, 255, 255));
        NumciclorrelojLabel.setText("0");
        jPanel.add(NumciclorrelojLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 471, 130, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ciclo de reloj Global");
        jPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 437, 290, -1));

        jScrollPane1.setToolTipText("");

        ListosContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ListosContainer.setLayout(new javax.swing.BoxLayout(ListosContainer, javax.swing.BoxLayout.LINE_AXIS));
        jScrollPane1.setViewportView(ListosContainer);

        jPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 51, 659, 152));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cola de Terminados:");
        jPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 420, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Cola de Listos:");
        jPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 29, -1, -1));

        Blista.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout BlistaLayout = new javax.swing.GroupLayout(Blista);
        Blista.setLayout(BlistaLayout);
        BlistaLayout.setHorizontalGroup(
            BlistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 631, Short.MAX_VALUE)
        );
        BlistaLayout.setVerticalGroup(
            BlistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 159, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(Blista);

        jPanel.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 243, 643, 151));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Cola de Bloqueados:");
        jPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 221, -1, -1));

        Tlista.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout TlistaLayout = new javax.swing.GroupLayout(Tlista);
        Tlista.setLayout(TlistaLayout);
        TlistaLayout.setHorizontalGroup(
            TlistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 638, Short.MAX_VALUE)
        );
        TlistaLayout.setVerticalGroup(
            TlistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 158, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(Tlista);

        jPanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 440, 640, 160));

        jButton1.setText("Crear 20 procesos automáticamente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 540, 270, 30));

        TabContainer.addTab("Simulador", jPanel);

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        TituloPpalConfiguracion.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        TituloPpalConfiguracion.setForeground(new java.awt.Color(255, 255, 255));
        TituloPpalConfiguracion.setText("Configuración");

        jPanel4.setBackground(new java.awt.Color(222, 225, 242));

        CambiarnumCPUsLabel.setText("Cambiar número de CPUs activos");

        CambiarnumCPUsCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2", "3" }));
        CambiarnumCPUsCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CambiarnumCPUsCBActionPerformed(evt);
            }
        });

        GuardarCambiosNumCPU.setText("Guardar Cambios");
        GuardarCambiosNumCPU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarCambiosNumCPUActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Actualmente se encuentran");

        NumeroCPUSACTUALEs.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        NumeroCPUSACTUALEs.setText("2");

        jLabel3.setText("CPUs Activos");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel1))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(NumeroCPUSACTUALEs)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NumeroCPUSACTUALEs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(GuardarCambiosNumCPU))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CambiarnumCPUsCB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CambiarnumCPUsLabel, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(CambiarnumCPUsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CambiarnumCPUsCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(GuardarCambiosNumCPU)))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(222, 225, 242));

        CambiarduracionCiclosLabel.setText("Cambiar duración de ciclos de ejecución");

        GuardarCambiosDuracionCiclos.setText("Guardar Cambios");
        GuardarCambiosDuracionCiclos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarCambiosDuracionCiclosActionPerformed(evt);
            }
        });

        DuracionCiclosSpinner.setValue(1);

        SegundostituloLabel.setText("Segundos");

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setText("Duración Actual de Ciclo de ejecución:");

        NumeroCICLOACTUAL.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        NumeroCICLOACTUAL.setText("2");

        jLabel9.setText("Segundos");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel7))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(NumeroCICLOACTUAL)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NumeroCICLOACTUAL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(DuracionCiclosSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(CambiarduracionCiclosLabel)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(SegundostituloLabel))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(GuardarCambiosDuracionCiclos)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(CambiarduracionCiclosLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DuracionCiclosSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SegundostituloLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(GuardarCambiosDuracionCiclos)
                        .addGap(31, 31, 31))))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TituloPpalConfiguracion)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(783, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(TituloPpalConfiguracion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(2813, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ConfiguracionTabLayout = new javax.swing.GroupLayout(ConfiguracionTab);
        ConfiguracionTab.setLayout(ConfiguracionTabLayout);
        ConfiguracionTabLayout.setHorizontalGroup(
            ConfiguracionTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ConfiguracionTabLayout.setVerticalGroup(
            ConfiguracionTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        TabContainer.addTab("Configuración", ConfiguracionTab);

        GraficosTab.setBackground(new java.awt.Color(221, 225, 245));

        jTabbedPane1.setBackground(new java.awt.Color(221, 225, 245));

        javax.swing.GroupLayout CompTHLayout = new javax.swing.GroupLayout(CompTH);
        CompTH.setLayout(CompTHLayout);
        CompTHLayout.setHorizontalGroup(
            CompTHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1069, Short.MAX_VALUE)
        );
        CompTHLayout.setVerticalGroup(
            CompTHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 557, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Comparación Throughputs", CompTH);

        javax.swing.GroupLayout IOCPULayout = new javax.swing.GroupLayout(IOCPU);
        IOCPU.setLayout(IOCPULayout);
        IOCPULayout.setHorizontalGroup(
            IOCPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1069, Short.MAX_VALUE)
        );
        IOCPULayout.setVerticalGroup(
            IOCPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 557, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Comparación I/O bound y CPU bound", IOCPU);

        javax.swing.GroupLayout CompTiemposLayout = new javax.swing.GroupLayout(CompTiempos);
        CompTiempos.setLayout(CompTiemposLayout);
        CompTiemposLayout.setHorizontalGroup(
            CompTiemposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1069, Short.MAX_VALUE)
        );
        CompTiemposLayout.setVerticalGroup(
            CompTiemposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 557, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Comparación Tiempos políticas", CompTiempos);

        javax.swing.GroupLayout GraficosTabLayout = new javax.swing.GroupLayout(GraficosTab);
        GraficosTab.setLayout(GraficosTabLayout);
        GraficosTabLayout.setHorizontalGroup(
            GraficosTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GraficosTabLayout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1069, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 237, Short.MAX_VALUE))
        );
        GraficosTabLayout.setVerticalGroup(
            GraficosTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GraficosTabLayout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2600, Short.MAX_VALUE))
        );

        TabContainer.addTab("Gráficos", GraficosTab);

        jPanel9.setBackground(new java.awt.Color(221, 225, 245));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(192, 204, 255));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 102));
        jLabel8.setText("Estadísticas Generales:");

        jLabel10.setText("Procesos Totales Terminados:");

        jLabel11.setText("Procesos I/O bound Terminados:");

        jLabel12.setText("Procesos CPU bound Terminados:");

        jLabel13.setText("Ciclo Actual:");

        jLabel14.setText("Throughput General:");

        ProcesosTotTerminadosLB.setText("ProcesosTT");

        ThroughputGen.setText("ThroughputGen");

        CicloActLB.setText("CicloActLB");

        ioboundTot.setText("ioboundTot");

        cpuboundTot.setText("cpuboundTot");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(ProcesosTotTerminadosLB))
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(ioboundTot)))
                                .addGap(146, 146, 146)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(ThroughputGen))
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(CicloActLB))))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cpuboundTot)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel13)
                    .addComponent(ProcesosTotTerminadosLB)
                    .addComponent(CicloActLB))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(ThroughputGen)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(ioboundTot))))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cpuboundTot))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1310, 160));

        jPanel11.setBackground(new java.awt.Color(221, 225, 245));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 102));
        jLabel15.setText("Estadisticas FCFS");

        jLabel16.setText("Ciclos ejecutando política:");

        TiempoFCFS.setText("TiempoFCFS");

        jLabel17.setText("Procesos totales ejecutados durante política: ");

        nroProcesosFCFSLB.setText("nroProcesosFCFSLB");

        jLabel18.setText("Procesos I/O bound ejecutados durante política: ");

        IOFCFSLB.setText("IOFCFS");

        jLabel19.setText("Procesos CPU bound ejecutados durante política: ");

        CPUFCFSLB.setText("CPUFCFS");

        jLabel25.setText("Throughput durante política:");

        THFCFS.setText("THFCFS");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nroProcesosFCFSLB))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TiempoFCFS))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IOFCFSLB))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CPUFCFSLB))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(THFCFS, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(TiempoFCFS))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(nroProcesosFCFSLB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(IOFCFSLB))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(CPUFCFSLB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(THFCFS))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        jPanel12.setBackground(new java.awt.Color(221, 225, 245));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 102));
        jLabel20.setText("Estadisticas Round Robin");

        jLabel21.setText("Ciclos ejecutando política:");

        TiempoRR.setText("TiempoFCFS");

        jLabel22.setText("Procesos totales ejecutados durante política: ");

        nroProcesosRRLB.setText("nroProcesosFCFSLB");

        jLabel23.setText("Procesos I/O bound ejecutados durante política: ");

        IORRLB.setText("IOFCFS");

        jLabel24.setText("Procesos CPU bound ejecutados durante política: ");

        CPURRLB.setText("CPUFCFS");

        jLabel26.setText("Throughput durante política:");

        THRR.setText("THFCFS");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nroProcesosRRLB))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TiempoRR))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IORRLB))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CPURRLB))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(THRR, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(TiempoRR))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(nroProcesosRRLB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(IORRLB))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(CPURRLB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(THRR))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 160, -1, 180));

        jPanel13.setBackground(new java.awt.Color(221, 225, 245));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 0, 102));
        jLabel27.setText("Estadisticas SPN");

        jLabel28.setText("Ciclos ejecutando política:");

        TiempoSPN.setText("TiempoFCFS");

        jLabel29.setText("Procesos totales ejecutados durante política: ");

        nroProcesosSPNLB.setText("nroProcesosFCFSLB");

        jLabel30.setText("Procesos I/O bound ejecutados durante política: ");

        IOSPNLB.setText("IOFCFS");

        jLabel31.setText("Procesos CPU bound ejecutados durante política: ");

        CPUSPNLB.setText("CPUFCFS");

        jLabel32.setText("Throughput durante política:");

        THSPN.setText("THFCFS");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel27))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel28)
                .addGap(6, 6, 6)
                .addComponent(TiempoSPN))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel29)
                .addGap(12, 12, 12)
                .addComponent(nroProcesosSPNLB))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel30)
                .addGap(6, 6, 6)
                .addComponent(IOSPNLB))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel31)
                .addGap(6, 6, 6)
                .addComponent(CPUSPNLB))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel32)
                .addGap(6, 6, 6)
                .addComponent(THSPN, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel27)
                .addGap(12, 12, 12)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addComponent(TiempoSPN))
                .addGap(12, 12, 12)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addComponent(nroProcesosSPNLB))
                .addGap(12, 12, 12)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30)
                    .addComponent(IOSPNLB))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31)
                    .addComponent(CPUSPNLB))
                .addGap(12, 12, 12)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32)
                    .addComponent(THSPN)))
        );

        jPanel9.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, -1, 200));

        jPanel14.setBackground(new java.awt.Color(221, 225, 245));

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 0, 102));
        jLabel33.setText("Estadisticas SRT");

        jLabel34.setText("Ciclos ejecutando política:");

        TiempoSRT.setText("TiempoFCFS");

        jLabel35.setText("Procesos totales ejecutados durante política: ");

        nroProcesosSRT.setText("nroProcesosFCFSLB");

        jLabel36.setText("Procesos I/O bound ejecutados durante política: ");

        IOSRTLB.setText("IOFCFS");

        jLabel37.setText("Procesos CPU bound ejecutados durante política: ");

        CPUSRTLB.setText("CPUFCFS");

        jLabel38.setText("Throughput durante política:");

        THSRT.setText("THFCFS");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel33))
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel34)
                .addGap(6, 6, 6)
                .addComponent(TiempoSRT))
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel35)
                .addGap(12, 12, 12)
                .addComponent(nroProcesosSRT))
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel36)
                .addGap(6, 6, 6)
                .addComponent(IOSRTLB))
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel37)
                .addGap(6, 6, 6)
                .addComponent(CPUSRTLB))
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel38)
                .addGap(6, 6, 6)
                .addComponent(THSRT, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel33)
                .addGap(12, 12, 12)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34)
                    .addComponent(TiempoSRT))
                .addGap(12, 12, 12)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel35)
                    .addComponent(nroProcesosSRT))
                .addGap(12, 12, 12)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36)
                    .addComponent(IOSRTLB))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37)
                    .addComponent(CPUSRTLB))
                .addGap(12, 12, 12)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38)
                    .addComponent(THSRT)))
        );

        jPanel9.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 370, 400, 200));

        jPanel15.setBackground(new java.awt.Color(221, 225, 245));

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(0, 0, 102));
        jLabel39.setText("Estadisticas HRRN");

        jLabel40.setText("Ciclos ejecutando política:");

        TiempoHRRN.setText("TiempoFCFS");

        jLabel41.setText("Procesos totales ejecutados durante política: ");

        nroProcesosHRRN.setText("nroProcesosFCFSLB");

        jLabel42.setText("Procesos I/O bound ejecutados durante política: ");

        IOHRRNLB.setText("IOFCFS");

        jLabel43.setText("Procesos CPU bound ejecutados durante política: ");

        CPUHRRNLB.setText("CPUFCFS");

        jLabel44.setText("Throughput durante política:");

        THHRRN.setText("THFCFS");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel39)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel41)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nroProcesosHRRN))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel40)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TiempoHRRN))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel42)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IOHRRNLB))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel43)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CPUHRRNLB))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel44)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(THHRRN, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(TiempoHRRN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(nroProcesosHRRN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(IOHRRNLB))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(CPUHRRNLB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(THHRRN))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel9.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 160, -1, 180));
        jPanel9.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 1260, 20));

        jScrollPane4.setViewportView(jPanel9);

        javax.swing.GroupLayout EstadisticasTabLayout = new javax.swing.GroupLayout(EstadisticasTab);
        EstadisticasTab.setLayout(EstadisticasTabLayout);
        EstadisticasTabLayout.setHorizontalGroup(
            EstadisticasTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EstadisticasTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1294, Short.MAX_VALUE)
                .addContainerGap())
        );
        EstadisticasTabLayout.setVerticalGroup(
            EstadisticasTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EstadisticasTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 3180, Short.MAX_VALUE)
                .addContainerGap())
        );

        TabContainer.addTab("Estadísticas", EstadisticasTab);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TabContainer)
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabContainer)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    private void guardarConfiguracion(String clave, String valor) {
    try {
        File archivo = new File("src/configuracion.txt");
        String contenidoNuevo = "";
        boolean claveEncontrada = false;

        // Leer línea por línea y actualizar la clave
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                if (linea.startsWith(clave + "=")) {
                    contenidoNuevo += clave + "=" + valor + "\n"; // Actualiza el valor
                    claveEncontrada = true;
                } else {
                    contenidoNuevo += linea + "\n"; // Mantén las otras líneas
                }
            }
        }

        // Si la clave no fue encontrada, añádela
        if (!claveEncontrada) {
            contenidoNuevo += clave + "=" + valor + "\n";
        }

        // Sobrescribe el archivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            writer.write(contenidoNuevo);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al guardar configuración: " + e.getMessage());
    }
}

    private void cargarConfiguracion() {
    try (BufferedReader reader = new BufferedReader(new FileReader("src/configuracion.txt"))) {
        String linea;
        while ((linea = reader.readLine()) != null) {
            String[] partes = linea.split("=");
            String clave = partes[0];
            String valor = partes[1];

            switch (clave) {
                case "CPUsActivos":
                    CambiarnumCPUsCB.setSelectedItem(valor);
                    NumeroCPUSACTUALEs.setText(valor);
                    break;
                case "DuracionCiclos":
                    DuracionCiclosSpinner.setValue(Integer.parseInt(valor));
                    NumeroCICLOACTUAL.setText(valor);
                    cicloDuracion = Integer.parseInt(valor); // Actualiza la variable global
                    break;
            }
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al cargar configuración: " + e.getMessage());
    }
}

    
    private void NombreTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreTFActionPerformed

    private void CrearProcesoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearProcesoButtonActionPerformed
      
    try {
        
        int pcMarInicial = leerPCMAR();
        if (pcMarInicial == -1) {
            throw new IllegalStateException("No se pudo leer el valor inicial de PC/MAR.");
        }
        
        // Obtener datos de los campos
        String nombre = NombreTF.getText();
        int cantidadInstrucciones = (int) CantInstruccionesSpinner.getValue();
        String tipo = (String) TipoCB.getSelectedItem();
        int ciclosParaGenerarExcepcion = (int) CiclosParaGenSpinner.getValue();
        int ciclosParaSatisfacerExcepcion = (int) CiclosParaSatisExcSpinner.getValue();

        // Validar que el nombre no esté vacío
        if (nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }

        // Validar condiciones para CPU bound o I/O bound
        if ("CPU bound".equals(tipo)) {
            ciclosParaGenerarExcepcion = 0;
            ciclosParaSatisfacerExcepcion = 0;
        }
        
        if ("I/O bound".equals(tipo)&&ciclosParaGenerarExcepcion>=cantidadInstrucciones) {
            throw new IllegalArgumentException("Los ciclos para generar excepción no pueden ser iguales o mayores a la cant. de instrucciones");
        }
        // Crear el objeto Proceso
        Proceso proceso = new Proceso(
                nombre,
                cantidadInstrucciones,
                tipo,
                ciclosParaGenerarExcepcion,
                ciclosParaSatisfacerExcepcion
        );
        
        proceso.setCicloEnqueCola(MainClass.cicloGlobal);
        
        // Asignar PC y MAR iniciales
        proceso.setPC(pcMarInicial);
        proceso.setMAR(pcMarInicial);

        // Escribir el nuevo valor en PCMAR.txt
        escribirPCMAR(pcMarInicial + cantidadInstrucciones + 2);
        
        // Imprimir el objeto en la consola
        //System.out.println(proceso);
        
        // mandar proceso a la cola de listos
        colaListos.enqueue(proceso);
        //colaListos.imprimirCola();

        // Restablecer los valores de los campos
        resetForm();
        

        // Mostrar un mensaje de éxito
        JOptionPane.showMessageDialog(this, "Proceso creado con éxito:\n" + proceso, 
                                      "Éxito", JOptionPane.INFORMATION_MESSAGE);

    } catch (Exception e) {
        // Mostrar errores en caso de que algo falle
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }    
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_CrearProcesoButtonActionPerformed

    private void GuardarCambiosPlanificacionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarCambiosPlanificacionButtonActionPerformed
        String algoritmoSeleccionado = (String) PoliticadePlanificacionCB.getSelectedItem();
        MainClass.setPoliticaActual(algoritmoSeleccionado);
        // setea la variable politicaActual en el MainClass para ordenar la cola de listos segun esa politica.
       
        
        
        
        
    }//GEN-LAST:event_GuardarCambiosPlanificacionButtonActionPerformed

    private void PoliticadePlanificacionCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PoliticadePlanificacionCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PoliticadePlanificacionCBActionPerformed

    private void CambiarnumCPUsCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CambiarnumCPUsCBActionPerformed
        // TODO add your handling code here: AQUI NADA NO ES BOTON
    }//GEN-LAST:event_CambiarnumCPUsCBActionPerformed

    private void GuardarCambiosNumCPUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarCambiosNumCPUActionPerformed
         String cpusActivos = (String) CambiarnumCPUsCB.getSelectedItem();

    // Actualizar el valor en el label
    NumeroCPUSACTUALEs.setText(cpusActivos);

    // Guardar el nuevo valor en el archivo de configuración
    guardarConfiguracion("CPUsActivos", cpusActivos);

    // Cambiar el estado del CPU 3 según la nueva configuración
    if (cpusActivos.equals("2")) {
        cpu3.setActivo(false); // Desactivar CPU 3
         cpuContainer3.setBackground(new java.awt.Color(255, 102, 102)); // Fondo rojo
        cpuPane3.setBackground(new java.awt.Color(255, 102, 102)); // Fondo rojo del panel
        for (java.awt.Component component : cpuPane3.getComponents()) {
            if (component instanceof javax.swing.JLabel) {
                ((javax.swing.JLabel) component).setForeground(new java.awt.Color(255, 102, 102)); // Texto blanco
            }}
        
    } else if (cpusActivos.equals("3")) {
        cpu3.setActivo(true); // Activar CPU 3
        cpuContainer3.setBackground(new java.awt.Color(242,242,242)); // Fondo normal
        cpuPane3.setBackground(new java.awt.Color(242,242,242)); // Fondo normal del panel
        for (java.awt.Component component : cpuPane3.getComponents()) {
            if (component instanceof javax.swing.JLabel) {
                ((javax.swing.JLabel) component).setForeground(new java.awt.Color(0, 0, 0)); // Texto negro
            }
        }
    }
    
    cpuContainer3.repaint();
    // Mostrar mensaje de confirmación
    JOptionPane.showMessageDialog(this, "Número de CPUs guardado correctamente.");

    // Imprimir el estado de las CPUs para verificar
    //System.out.println("CPU 1: " + cpu1);
    //System.out.println("CPU 2: " + cpu2);
    //System.out.println("CPU 3: " + cpu3);
    
    
    }//GEN-LAST:event_GuardarCambiosNumCPUActionPerformed

    private void GuardarCambiosDuracionCiclosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarCambiosDuracionCiclosActionPerformed
        String duracionCiclos = String.valueOf(DuracionCiclosSpinner.getValue());
        cicloDuracion = Integer.parseInt(duracionCiclos); // Actualiza la variable global
    NumeroCICLOACTUAL.setText(duracionCiclos); // Actualiza el label
    guardarConfiguracion("DuracionCiclos", duracionCiclos); // Guarda en el archivo
    JOptionPane.showMessageDialog(this, "Duración de ciclos guardada correctamente.");
    }//GEN-LAST:event_GuardarCambiosDuracionCiclosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
        for (int i = 1; i <= 20; i++) {
            int pcMarInicial = leerPCMAR();
            if (pcMarInicial == -1) {
                throw new IllegalStateException("No se pudo leer el valor inicial de PC/MAR.");
            }

            // Generar datos automáticamente
            String nombre = "Proceso_" + i;
            int cantidadInstrucciones = new Random().nextInt(10) + 1; // Entre 1 y 10 instrucciones
            String tipo = (i % 2 == 0) ? "CPU bound" : "I/O bound"; // Alterna entre CPU bound e I/O bound
            int ciclosParaGenerarExcepcion = tipo.equals("I/O bound") ? new Random().nextInt(3) + 1 : 0;
            int ciclosParaSatisfacerExcepcion = tipo.equals("I/O bound") ? new Random().nextInt(2) + 1 : 0;

            // Crear el proceso
            Proceso proceso = new Proceso(
                nombre,
                cantidadInstrucciones,
                tipo,
                ciclosParaGenerarExcepcion,
                ciclosParaSatisfacerExcepcion
            );

            proceso.setCicloEnqueCola(MainClass.cicloGlobal);

            // Asignar PC y MAR iniciales
            proceso.setPC(pcMarInicial);
            proceso.setMAR(pcMarInicial);

            // Escribir el nuevo valor en PCMAR.txt
            escribirPCMAR(pcMarInicial + cantidadInstrucciones + 2);

            // Encolar el proceso en la cola de listos
            MainClass.colaListos.enqueue(proceso);
        }

        // Mostrar un mensaje de éxito
        JOptionPane.showMessageDialog(this, "20 procesos creados automáticamente.", 
                                      "Éxito", JOptionPane.INFORMATION_MESSAGE);

    } catch (Exception e) {
        // Manejar errores
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }    
        
    }//GEN-LAST:event_jButton1ActionPerformed

        // valores vuelven a ser 0 despues de crear un proceso
    private void resetForm() {
    NombreTF.setText(""); // Vaciar el campo de texto
    CantInstruccionesSpinner.setValue(0); // Restablecer el spinner a 0
    TipoCB.setSelectedIndex(0); // Seleccionar el primer elemento del ComboBox
    CiclosParaGenSpinner.setValue(0); // Restablecer el spinner a 0
    CiclosParaSatisExcSpinner.setValue(0); // Restablecer el spinner a 0
    CiclosParaGenSpinner.setEnabled(false); // Deshabilitar los spinners de ciclos
    CiclosParaSatisExcSpinner.setEnabled(false);
    
}
    
    public void actualizarCicloGlobal(int ciclo) {
    if (NumciclorrelojLabel != null) {
        NumciclorrelojLabel.setText(String.valueOf(ciclo));
    } else {
        System.out.println("Error: Label no inicializado.");
    }
}
    
    public void setColorCPU3ACTIVO() {
    
        cpuContainer3.setBackground(new java.awt.Color(242,242,242)); // Fondo normal
        cpuPane3.setBackground(new java.awt.Color(242,242,242)); // Fondo normal del panel
        for (java.awt.Component component : cpuPane3.getComponents()) {
            if (component instanceof javax.swing.JLabel) {
                ((javax.swing.JLabel) component).setForeground(new java.awt.Color(0, 0, 0)); // Texto negro
            }
        }        
    }
    
    public void setColorCPU3DESACTIVADO() {
    
         cpuContainer3.setBackground(new java.awt.Color(255, 102, 102)); // Fondo rojo
        cpuPane3.setBackground(new java.awt.Color(255, 102, 102)); // Fondo rojo del panel
        for (java.awt.Component component : cpuPane3.getComponents()) {
            if (component instanceof javax.swing.JLabel) {
                ((javax.swing.JLabel) component).setForeground(new java.awt.Color(255, 102, 102)); // Texto blanco
            }} 
    }
    
 private void configurarSpinners() {
    configurarSpinnersSoloFlechas(); // Desactiva la entrada manual
    agregarListenersDeValidacion(); // Añade validación para valores mayores a 0
}

private void configurarSpinnersSoloFlechas() {
    desactivarInputManual(CantInstruccionesSpinner);
    desactivarInputManual(CiclosParaGenSpinner);
    desactivarInputManual(CiclosParaSatisExcSpinner);
    desactivarInputManual(DuracionCiclosSpinner);
}

private void desactivarInputManual(javax.swing.JSpinner spinner) {
    // Obtener el editor del JSpinner y desactivar la edición del campo de texto
    javax.swing.JSpinner.DefaultEditor editor = (javax.swing.JSpinner.DefaultEditor) spinner.getEditor();
    editor.getTextField().setEditable(false);
}

private void agregarListenersDeValidacion() {
    agregarValidacionASpinner(CantInstruccionesSpinner);
    agregarValidacionASpinner(CiclosParaGenSpinner);
    agregarValidacionASpinner(CiclosParaSatisExcSpinner);
    agregarValidacionASpinner(DuracionCiclosSpinner);
}

private void agregarValidacionASpinner(javax.swing.JSpinner spinner) {
    spinner.addChangeListener(e -> {
        int valor = (int) spinner.getValue();
        if (valor <= 0) {
            // Restablece el valor a 1 si es 0 o negativo
            spinner.setValue(1);
            
        }
        else{}
    });
}

public void actualizarContenedor(Cola<Proceso> colaProcesos, javax.swing.JPanel container) {
    SwingUtilities.invokeLater(() -> {
        // Limpiar el contenedor antes de agregar nuevos paneles
        container.removeAll();

        // Recorrer la cola y crear un ListaPane para cada proceso
        Nodo<Proceso> nodoActual = colaProcesos.peekNode(); // Accede al nodo inicial
        while (nodoActual != null) {
            Proceso proceso = nodoActual.getDato();
            ListaPane panelProceso = new ListaPane(proceso);
            container.add(panelProceso); // Agregar el panel al contenedor
            nodoActual = nodoActual.getSiguiente(); // Avanzar al siguiente nodo
        }

        // Refrescar el contenedor para que los cambios sean visibles
        container.revalidate();
        container.repaint();
    });
}



// COLA LISTOS
public void iniciarActualizacionAutomatica(Cola<Proceso> colaListos, javax.swing.JPanel listosContainer,
                                           Cola<Proceso> colaBloqueados, javax.swing.JPanel bloqueadosContainer,
                                           Cola<Proceso> colaTerminados, javax.swing.JPanel TContainer) {
    Thread hiloActualizacion = new Thread(() -> {
        while (true) {
            try {
                Thread.sleep(100); // Actualizar cada 500 ms (ajustable)

                // Actualizar el contenedor de listos
                actualizarContenedor(colaListos, listosContainer);

                // Actualizar el contenedor de bloqueados
                actualizarContenedor(colaBloqueados, bloqueadosContainer);
                
                actualizarContenedor(colaTerminados, TContainer);

            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt(); // Manejar la interrupción
                break;
            }
        }
    });
    hiloActualizacion.setDaemon(true); // Terminará automáticamente cuando la aplicación cierre
    hiloActualizacion.start();
}


public void ActualizarEstadisticas() {
    new Thread(() -> {
        while (true) {
            try {
                Thread.sleep(100); // Pausa de 100 ms
                SwingUtilities.invokeLater(() -> {
                    ProcesosTotTerminadosLB.setText(Integer.toString(MainClass.ProcesosTotales));
                    ThroughputGen.setText(Double.toString(MainClass.ThroughputTotal));
                    CicloActLB.setText(Integer.toString(MainClass.cicloGlobal));
                    ioboundTot.setText(Integer.toString(MainClass.ProcesosIOtotales));
                    cpuboundTot.setText(Integer.toString(MainClass.ProcesosCPUtotales));
                    
                    //FCFS
                    TiempoFCFS.setText(Integer.toString(MainClass.TiempoFCFS));
                    nroProcesosFCFSLB.setText(Integer.toString(MainClass.nroProcesoFCFS));
                    IOFCFSLB.setText(Integer.toString(MainClass.ProcesosIOFCFS));
                    CPUFCFSLB.setText(Integer.toString(MainClass.ProcesosCPUFCFS));
                    THFCFS.setText(Double.toString(MainClass.ThroughputFCFS));
                    
                    //ROUND ROBIN
                    TiempoRR.setText(Integer.toString(MainClass.TiempoRR));
                    nroProcesosRRLB.setText(Integer.toString(MainClass.nroProcesoRR));
                    IORRLB.setText(Integer.toString(MainClass.ProcesosIORR));
                    CPURRLB.setText(Integer.toString(MainClass.ProcesosCPURR));
                    THRR.setText(Double.toString(MainClass.ThroughputRR));
                    
                    //SPN
                    TiempoSPN.setText(Integer.toString(MainClass.TiempoSPN));
                    nroProcesosSPNLB.setText(Integer.toString(MainClass.nroProcesoSPN));
                    IOSPNLB.setText(Integer.toString(MainClass.ProcesosIOSPN));
                    CPUSPNLB.setText(Integer.toString(MainClass.ProcesosCPUSPN));
                    THSPN.setText(Double.toString(MainClass.ThroughputSPN));
                    
                    
                    //SRT
                    TiempoSRT.setText(Integer.toString(MainClass.TiempoSRT));
                    nroProcesosSRT.setText(Integer.toString(MainClass.nroProcesoSRT));
                    IOSRTLB.setText(Integer.toString(MainClass.ProcesosIOSRT));
                    CPUSRTLB.setText(Integer.toString(MainClass.ProcesosCPUSRT));
                    THSRT.setText(Double.toString(MainClass.ThroughputSRT));
                    
                    //HRRN
                    TiempoHRRN.setText(Integer.toString(MainClass.TiempoHRRN));
                    nroProcesosHRRN.setText(Integer.toString(MainClass.nroProcesoHRRN));
                    IOHRRNLB.setText(Integer.toString(MainClass.ProcesosIOHRRN));
                    CPUHRRNLB.setText(Integer.toString(MainClass.ProcesosCPUHRRN));
                    THHRRN.setText(Double.toString(MainClass.ThroughputHRRN));
                    
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
                break;
            }
        }
    }).start();
}


private static final String RUTA_PCMAR = "src/PCMAR.txt"; // Cambia esto si el archivo está en otro lugar

private int leerPCMAR() {
    try (BufferedReader reader = new BufferedReader(new FileReader(RUTA_PCMAR))) {
        String linea = reader.readLine();
        return Integer.parseInt(linea.trim());
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Error al leer el archivo PCMAR.txt.",
                "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
        return -1; // Valor por defecto en caso de error
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Formato inválido en PCMAR.txt. Asegúrate de que contenga solo un número.",
                "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
        return -1;
    }
}

private void escribirPCMAR(int nuevoValor) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_PCMAR, false))) {
        writer.write(String.valueOf(nuevoValor));
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Error al escribir en el archivo PCMAR.txt.",
                "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
}
private void agregarGraficoThroughput() {
        GraficoThroughput grafico = new GraficoThroughput();
        CompTH.setLayout(new BorderLayout());
        CompTH.add(grafico, BorderLayout.CENTER);
        CompTH.revalidate();
    }

public void agregarGraficoTorta() {
    if (graficoTorta == null) {
        graficoTorta = new GraficoTorta();
       IOCPU.setLayout(new BorderLayout());
        IOCPU.add(graficoTorta, BorderLayout.CENTER);
    }
    IOCPU.validate(); // Refrescar el panel
    IOCPU.repaint();  // Repintar para reflejar cambios
}

public void actualizarGraficoTorta() {
    if (graficoTorta != null) {
        graficoTorta.actualizarDatos();
    }
}

public void iniciarActualizacionGraficoTorta() {
    new Thread(() -> {
        while (true) {
            try {
                Thread.sleep(1000); // Actualizar cada segundo
                SwingUtilities.invokeLater(() -> actualizarGraficoTorta());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }).start();
}

public void agregarGraficoBarrasTiempo() {
    if (graficoBarrasTiempo == null) {
        graficoBarrasTiempo = new GraficoBarrasTiempo();
        CompTiempos.setLayout(new BorderLayout());
        CompTiempos.add(graficoBarrasTiempo, BorderLayout.CENTER);
    }
    CompTiempos.validate(); // Refrescar el panel
    CompTiempos.repaint();  // Repintar para reflejar cambios
}

public void actualizarGraficoBarrasTiempo() {
    if (graficoBarrasTiempo != null) {
        graficoBarrasTiempo.actualizarDatos();
    }
}

public void iniciarActualizacionGraficoBarrasTiempo() {
    new Thread(() -> {
        while (true) {
            try {
                Thread.sleep(1000); // Actualizar cada segundo
                SwingUtilities.invokeLater(() -> actualizarGraficoBarrasTiempo());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }).start();
}
//COLA BLOQUEADOS



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
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Blista;
    private javax.swing.JLabel CPUFCFSLB;
    private javax.swing.JLabel CPUHRRNLB;
    private javax.swing.JLabel CPURRLB;
    private javax.swing.JLabel CPUSPNLB;
    private javax.swing.JLabel CPUSRTLB;
    private javax.swing.JLabel CambiarduracionCiclosLabel;
    private javax.swing.JComboBox<String> CambiarnumCPUsCB;
    private javax.swing.JLabel CambiarnumCPUsLabel;
    private javax.swing.JLabel CantInstruccionesLabel;
    private javax.swing.JSpinner CantInstruccionesSpinner;
    private javax.swing.JLabel CicloActLB;
    private javax.swing.JSpinner CiclosParaGenSpinner;
    private javax.swing.JLabel CiclosParaGenSpinner1;
    private javax.swing.JLabel CiclosParaGenSpinner2;
    private javax.swing.JSpinner CiclosParaSatisExcSpinner;
    private javax.swing.JLabel CiclosParaSatisExcSpinner1;
    private javax.swing.JLabel CiclosParaSatisExcSpinner2;
    private javax.swing.JPanel CompTH;
    private javax.swing.JPanel CompTiempos;
    private javax.swing.JPanel ConfiguracionTab;
    private javax.swing.JButton CrearProcesoButton;
    private javax.swing.JSpinner DuracionCiclosSpinner;
    private javax.swing.JPanel EstadisticasTab;
    private javax.swing.JPanel GraficosTab;
    private javax.swing.JButton GuardarCambiosDuracionCiclos;
    private javax.swing.JButton GuardarCambiosNumCPU;
    private javax.swing.JButton GuardarCambiosPlanificacionButton;
    private javax.swing.JPanel IOCPU;
    private javax.swing.JLabel IOFCFSLB;
    private javax.swing.JLabel IOHRRNLB;
    private javax.swing.JLabel IORRLB;
    private javax.swing.JLabel IOSPNLB;
    private javax.swing.JLabel IOSRTLB;
    private javax.swing.JPanel ListosContainer;
    private javax.swing.JLabel NombreLabel;
    private javax.swing.JTextField NombreTF;
    private javax.swing.JLabel NumciclorrelojLabel;
    private javax.swing.JLabel NumeroCICLOACTUAL;
    private javax.swing.JLabel NumeroCPUSACTUALEs;
    private javax.swing.JComboBox<String> PoliticadePlanificacionCB;
    private javax.swing.JLabel ProcesosTotTerminadosLB;
    private javax.swing.JLabel SegundostituloLabel;
    private javax.swing.JLabel THFCFS;
    private javax.swing.JLabel THHRRN;
    private javax.swing.JLabel THRR;
    private javax.swing.JLabel THSPN;
    private javax.swing.JLabel THSRT;
    private javax.swing.JTabbedPane TabContainer;
    private javax.swing.JLabel ThroughputGen;
    private javax.swing.JLabel TiempoFCFS;
    private javax.swing.JLabel TiempoHRRN;
    private javax.swing.JLabel TiempoRR;
    private javax.swing.JLabel TiempoSPN;
    private javax.swing.JLabel TiempoSRT;
    private javax.swing.JComboBox<String> TipoCB;
    private javax.swing.JLabel TipoLabel;
    private javax.swing.JLabel TituloCambiarPoliticadePlanificacion;
    private javax.swing.JLabel TituloCrearProceso;
    private javax.swing.JLabel TituloPpalConfiguracion;
    private javax.swing.JPanel Tlista;
    private javax.swing.JPanel cpuContainer1;
    private javax.swing.JPanel cpuContainer2;
    private javax.swing.JPanel cpuContainer3;
    private javax.swing.JLabel cpuboundTot;
    private javax.swing.JLabel ioboundTot;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel nroProcesosFCFSLB;
    private javax.swing.JLabel nroProcesosHRRN;
    private javax.swing.JLabel nroProcesosRRLB;
    private javax.swing.JLabel nroProcesosSPNLB;
    private javax.swing.JLabel nroProcesosSRT;
    // End of variables declaration//GEN-END:variables
}
