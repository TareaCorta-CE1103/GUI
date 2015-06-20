/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficacion;

import calculos.Constantes;
import lists.ListaSimple;

/**
 * clase que es un jframe, esta clase sirve para abrir la ventana que va 
 * dejarnos decidir que tipos de metodos de borrado podemos hacer para los 
 * metodos que se tengan.
 * @author osboxes
 */
public class borradores extends javax.swing.JFrame implements Constantes{

    private int _metodo;
    private Grafico chartab;
    private ListaSimple _metodos;
    /**
     * Creates new form borradores
     */
    public borradores() {
        _metodos=new ListaSimple();
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

        jLabel3 = new javax.swing.JLabel();
        DeleteBox = new javax.swing.JComboBox();
        Calc = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        MethArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(530, 400));

        jLabel3.setText("Borrados");

        DeleteBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All sorted linked list", "Binary Search Tree", "AVL Tree", "Splay Tree", "Red-Black Tree" }));
        DeleteBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBoxActionPerformed(evt);
            }
        });

        Calc.setText("Calcular");
        Calc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalcActionPerformed(evt);
            }
        });

        MethArea.setEditable(false);
        MethArea.setColumns(20);
        MethArea.setRows(5);
        MethArea.setText("Metodos a calcular:\n");
        jScrollPane2.setViewportView(MethArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(DeleteBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)
                        .addComponent(Calc)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel3)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DeleteBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Calc))
                .addGap(53, 53, 53)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * metodo que detecta cuando el boton de calcular se es presionado, 
     * inicializa la clase que nos crea la grafica y cierra esa JFrame.
     * @param evt 
     */
    private void CalcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalcActionPerformed
        // TODO add your handling code here:
        chartab=new Grafico(_metodos);
        dispose();
    }//GEN-LAST:event_CalcActionPerformed

    /**
     * metodo que detecta las acciones realizadas por el comboBox cuando 
     * seleccionamos un metodo de borrado; segun lo que hayamos elejido lo 
     * ingresa a una lista, que almacenara los metodos que vamos a realizar.
     * @param evt 
     */
    private void DeleteBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBoxActionPerformed
        // TODO add your handling code here:
        if(DeleteBox.getSelectedIndex()==cero){
            _metodos.enQueue_none_repeat((_metodo*diez)+Ldoble);
            setMetodo(Ldoble);
        }
        else if(DeleteBox.getSelectedIndex()==uno){
            _metodos.enQueue_none_repeat((_metodo*diez)+BinarioT);
            setMetodo(BinarioT);
        }
        else if(DeleteBox.getSelectedIndex()==dos){
            _metodos.enQueue_none_repeat((_metodo*diez)+AVL);
            setMetodo(AVL);
        }
        else if(DeleteBox.getSelectedIndex()==tres){
            _metodos.enQueue_none_repeat((_metodo*diez)+Splay);
            setMetodo(Splay);
        }
        else if(DeleteBox.getSelectedIndex()==cuatro){
            _metodos.enQueue_none_repeat((_metodo*diez)+R_N);
            setMetodo(R_N);
        }
    }//GEN-LAST:event_DeleteBoxActionPerformed

    /**
     * metodo que recibe un mensaje y es el que establece antes para que este 
     * el tipo de metodo que vamos a calcular; si recibe un uno, se calcula una
     * insercion, un dos es para borrado, 3 es para busqueda y 4 para 
     * ordenamiento.
     * @param mensaje dato tipo entero, recibe el dato segun el tipo de 
     * operacion que se quiera realizar.
     */
    public void setMensaje(int mensaje){
        this._metodo=mensaje;
    }
    
    /**
     * metodo para agregar datos de texto para saber que metodos vamos a calcular
     * cuando queramos hacer una comparacion de duracion en tiempo.
     * @param mensaje dato tipo entero, este es el metodo que se pide.
     */
    private void setMetodo(int mensaje){
        if(mensaje==Ldoble)
            MethArea.append('\n'+ "Lista enlazada");
        else if(mensaje==BinarioT)
            MethArea.append('\n'+ "Arbol binario");
        else if(mensaje==AVL)
            MethArea.append('\n'+ "Arbol AVL");
        else if(mensaje==Splay)
            MethArea.append('\n'+ "Arbol Splay");
        else 
            MethArea.append('\n'+ "Arbol Rojo y Negro");
    }
    
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
            java.util.logging.Logger.getLogger(borradores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(borradores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(borradores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(borradores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new borradores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Calc;
    private javax.swing.JComboBox DeleteBox;
    private javax.swing.JTextArea MethArea;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
