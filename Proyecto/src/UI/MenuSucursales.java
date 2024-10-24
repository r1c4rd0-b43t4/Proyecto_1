/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import Proyecto.Grafo;
import static UI.CargaRed_1.grafo;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.Viewer;

/**
 *
 * @author HP
 */
public class MenuSucursales extends javax.swing.JFrame {

    /**
     * Creates new form MenuSucursales
     */
    public MenuSucursales(Grafo grafo) {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Cargar_Redes = new javax.swing.JButton();
        Mostrar_Grafo = new javax.swing.JButton();
        Establecer_t = new javax.swing.JButton();
        Colocar_Sucursal = new javax.swing.JButton();
        Ver_Cobertura = new javax.swing.JButton();
        Agregar_Linea = new javax.swing.JButton();
        Cargar_Red = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        Cargar_Redes.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.GreyInline"));
        Cargar_Redes.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        Cargar_Redes.setForeground(new java.awt.Color(255, 255, 255));
        Cargar_Redes.setText("Cargar Redes");
        Cargar_Redes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Mostrar_Grafo.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.GreyInline"));
        Mostrar_Grafo.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        Mostrar_Grafo.setForeground(new java.awt.Color(255, 255, 255));
        Mostrar_Grafo.setText("Mostrar Grafo");
        Mostrar_Grafo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Mostrar_Grafo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mostrar_GrafoActionPerformed(evt);
            }
        });
        getContentPane().add(Mostrar_Grafo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 170, 40));

        Establecer_t.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.GreyInline"));
        Establecer_t.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        Establecer_t.setForeground(new java.awt.Color(255, 255, 255));
        Establecer_t.setText("Establecer t");
        Establecer_t.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(Establecer_t, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 170, 40));

        Colocar_Sucursal.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.GreyInline"));
        Colocar_Sucursal.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        Colocar_Sucursal.setForeground(new java.awt.Color(255, 255, 255));
        Colocar_Sucursal.setText("Colocar Sucursal");
        Colocar_Sucursal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(Colocar_Sucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 170, 40));

        Ver_Cobertura.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.GreyInline"));
        Ver_Cobertura.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        Ver_Cobertura.setForeground(new java.awt.Color(255, 255, 255));
        Ver_Cobertura.setText("Ver  Cobertura");
        Ver_Cobertura.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(Ver_Cobertura, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 170, 40));

        Agregar_Linea.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.GreyInline"));
        Agregar_Linea.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        Agregar_Linea.setForeground(new java.awt.Color(255, 255, 255));
        Agregar_Linea.setText("Agregar Línea");
        Agregar_Linea.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(Agregar_Linea, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 170, 40));

        Cargar_Red.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.GreyInline"));
        Cargar_Red.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        Cargar_Red.setForeground(new java.awt.Color(255, 255, 255));
        Cargar_Red.setText("Cargar nueva Red");
        Cargar_Red.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(Cargar_Red, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 170, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/fondo-logo.png"))); // NOI18N
        jLabel3.setText(" ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Mostrar_GrafoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mostrar_GrafoActionPerformed
     
  
    }//GEN-LAST:event_Mostrar_GrafoActionPerformed

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
            java.util.logging.Logger.getLogger(MenuSucursales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuSucursales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuSucursales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuSucursales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuSucursales(grafo).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Agregar_Linea;
    private javax.swing.JButton Cargar_Red;
    private javax.swing.JButton Cargar_Redes;
    private javax.swing.JButton Colocar_Sucursal;
    private javax.swing.JButton Establecer_t;
    private javax.swing.JButton Mostrar_Grafo;
    private javax.swing.JButton Ver_Cobertura;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
