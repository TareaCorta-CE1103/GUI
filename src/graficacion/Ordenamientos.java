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
 * dejarnos decidir que tipos de metodos de ordenamiento podemos hacer para los 
 * metodos de ordenamiento.
 * @author osboxes
 */
public class Ordenamientos extends javax.swing.JFrame implements Constantes{

    private int _metodo;
    private Grafico chartab;
    private ListaSimple _metodos;
    
    /**
     * Creates new form sorts
     */
    public Ordenamientos(){
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

        jLabel1 = new javax.swing.JLabel();
        SortBox = new javax.swing.JComboBox();
        Calc = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        MethArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(550, 410));

        jLabel1.setText("Ordenamientos");

        SortBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "BubbleSort", "SelectionSort", "InsertionSort", "MergeSort", "QuickSort", "HeapSort", "RaddixSort" }));
        SortBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SortBoxActionPerformed(evt);
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
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(SortBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(148, 148, 148)
                            .addComponent(Calc))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(260, 260, 260))))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SortBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Calc))
                .addGap(62, 62, 62)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * metodo que detecta las acciones realizadas por el comboBox cuando 
     * seleccionamos un metodo de ordenamiento; segun lo que hayamos elejido lo 
     * ingresa a una lista, que almacenara los metodos que vamos a realizar.
     * @param evt 
     */
    private void SortBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SortBoxActionPerformed
        // TODO add your handling code here:
        if(SortBox.getSelectedIndex()==cero){
            _metodos.enQueue_none_repeat((_metodo*diez)+burbujaS);
            setMetodo(burbujaS);
        }
        else if(SortBox.getSelectedIndex()==uno){
            _metodos.enQueue_none_repeat((_metodo*diez)+selecS);
            setMetodo(selecS);
        }
        else if(SortBox.getSelectedIndex()==dos){
            _metodos.enQueue_none_repeat((_metodo*diez)+insertS);
            setMetodo(insertS);
        }
        else if(SortBox.getSelectedIndex()==tres){
            _metodos.enQueue_none_repeat((_metodo*diez)+mergeS);
            setMetodo(mergeS);
        }
        else if(SortBox.getSelectedIndex()==cuatro){
            _metodos.enQueue_none_repeat((_metodo*diez)+quickS);
            setMetodo(quickS);
        }
        else if(SortBox.getSelectedIndex()==cinco){
            _metodos.enQueue_none_repeat((_metodo*diez)+heapS);
            setMetodo(heapS);
        }
        else if(SortBox.getSelectedIndex()==seis){
            _metodos.enQueue_none_repeat((_metodo*diez)+raddixS);
            setMetodo(raddixS);
        }
    }//GEN-LAST:event_SortBoxActionPerformed

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
        if(mensaje==burbujaS)
            MethArea.append('\n'+ "Bubble");
        else if(mensaje==selecS)
            MethArea.append('\n'+ "Selection");
        else if(mensaje==insertS)
            MethArea.append('\n'+ "Insert");
        else if(mensaje==mergeS)
            MethArea.append('\n'+ "Merge");
        else if(mensaje==quickS)
            MethArea.append('\n'+ "Quick");
        else if(mensaje==heapS)
            MethArea.append('\n'+ "Heap");
        else 
            MethArea.append('\n'+ "raddix");
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
            java.util.logging.Logger.getLogger(Ordenamientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ordenamientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ordenamientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ordenamientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ordenamientos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Calc;
    private javax.swing.JTextArea MethArea;
    public static javax.swing.JComboBox SortBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
