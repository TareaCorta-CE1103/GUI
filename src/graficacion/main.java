/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficacion;

import calculos.Constantes;
/**
 *
 * @author osboxes
 */
public class main extends javax.swing.JFrame implements Constantes{

    private int _metodo;
    private Ordenamientos _orde;
    private busquedas _busq;
    private borradores _borr;
    private inserciones _inse;
    /**
     * Creates new form main
     */
    public main() {
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

        insertBtn = new javax.swing.JButton();
        searchBtn = new javax.swing.JButton();
        DelBtn = new javax.swing.JButton();
        sortBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(550, 380));
        getContentPane().setLayout(null);

        insertBtn.setText("inserciones");
        insertBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertBtnActionPerformed(evt);
            }
        });
        getContentPane().add(insertBtn);
        insertBtn.setBounds(310, 240, 140, 37);

        searchBtn.setText("busquedas");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });
        getContentPane().add(searchBtn);
        searchBtn.setBounds(310, 130, 140, 37);

        DelBtn.setText("eliminaciones");
        DelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelBtnActionPerformed(evt);
            }
        });
        getContentPane().add(DelBtn);
        DelBtn.setBounds(50, 240, 160, 37);

        sortBtn.setText("ordenamientos");
        sortBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortBtnActionPerformed(evt);
            }
        });
        getContentPane().add(sortBtn);
        sortBtn.setBounds(40, 130, 180, 37);

        jLabel5.setText("Seleccione alguna de las categorías");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(90, 30, 340, 40);

        jMenu1.setText("Archivo");

        jMenuItem1.setText("Ayuda");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Salir");
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sortBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortBtnActionPerformed
        // TODO add your handling code here:
        _metodo=sort;
        _orde= new Ordenamientos();
        _orde.setVisible(true);
        _orde.setMensaje(_metodo);
        dispose();
    }//GEN-LAST:event_sortBtnActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        // TODO add your handling code here:
        _metodo=search;
        _busq= new busquedas();
        _busq.setMensaje(_metodo);
        _busq.setVisible(true);
        dispose();
    }//GEN-LAST:event_searchBtnActionPerformed

    private void DelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelBtnActionPerformed
        // TODO add your handling code here:
        _metodo=delete;
        _borr= new borradores();
        _borr.setMensaje(_metodo);
        _borr.setVisible(true);
        dispose();
    }//GEN-LAST:event_DelBtnActionPerformed

    private void insertBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertBtnActionPerformed
        // TODO add your handling code here:
        _metodo=insert;
        _inse= new inserciones();
        _inse.setMensaje(_metodo);
        _inse.setVisible(true);
        dispose();
    }//GEN-LAST:event_insertBtnActionPerformed

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
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DelBtn;
    private javax.swing.JButton insertBtn;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JButton searchBtn;
    private javax.swing.JButton sortBtn;
    // End of variables declaration//GEN-END:variables
}
