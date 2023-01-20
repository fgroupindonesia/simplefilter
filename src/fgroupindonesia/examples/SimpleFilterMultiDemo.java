
package fgroupindonesia.examples;

import fgroupindonesia.swing.SimpleFilter;

/**
 * this is the 2nd example
 * @author fgroupindonesia
 */
public class SimpleFilterMultiDemo extends javax.swing.JFrame {

    /**
     * Creates new form SimpleFilterMultiDemo
     */
    
    SimpleFilter sf = new SimpleFilter(true);
    
    public SimpleFilterMultiDemo() {
        initComponents();
        
        // 2nd example for many combobox as filtering components
        sf.setFilterComponents(comboboxKota, comboboxKendaraan);
        sf.setColumnPositionRef(1, 3);
        sf.setTable(jTable1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        comboboxKota = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        comboboxKendaraan = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Integer(1), "bandung",  new Integer(100), "truk",  new Integer(1999)},
                { new Integer(2), "bandung",  new Integer(200), "mobil",  new Integer(1998)},
                { new Integer(3), "bekasi",  new Integer(500), "bus",  new Integer(1995)},
                { new Integer(4), "jakarta",  new Integer(100), "bus",  new Integer(1994)},
                { new Integer(5), "jakarta",  new Integer(111), "mobil",  new Integer(1995)},
                { new Integer(6), "surabaya",  new Integer(444), "bus",  new Integer(1997)},
                { new Integer(7), "bandung",  new Integer(500), "mobil",  new Integer(1997)},
                { new Integer(8), "bekasi",  new Integer(100), "truk",  new Integer(1996)},
                { new Integer(9), "jakarta",  new Integer(500), "truk",  new Integer(1996)}
            },
            new String [] {
                "No", "Kota", "Jumlah Pengguna", "Dominasi Kendaraan", "Tahun"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(45);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(45);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(45);
            jTable1.getColumnModel().getColumn(2).setMinWidth(100);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(100);
            jTable1.getColumnModel().getColumn(3).setMinWidth(150);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(150);
            jTable1.getColumnModel().getColumn(4).setMinWidth(50);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(50);
        }

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jLabel1.setText("Kota : ");
        jPanel1.add(jLabel1);

        comboboxKota.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "bandung", "jakarta", "surabaya", "bekasi" }));
        jPanel1.add(comboboxKota);

        jLabel2.setText("Kendaraan");
        jPanel1.add(jLabel2);

        comboboxKendaraan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "mobil", "bus", "truk" }));
        jPanel1.add(comboboxKendaraan);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(SimpleFilterMultiDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SimpleFilterMultiDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SimpleFilterMultiDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SimpleFilterMultiDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SimpleFilterMultiDemo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboboxKendaraan;
    private javax.swing.JComboBox<String> comboboxKota;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
