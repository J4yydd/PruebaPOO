
package mx.edu.uaz.is.poo2.gb.gannetapp.igu;
import javax.swing.*;
import java.io.File;
import mx.edu.uaz.is.poo2.gb.gannetapp.logica.ExcelImporter;

public class Principal extends javax.swing.JFrame {

   
    public Principal() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnAltaAgroquimico = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnConsulta = new javax.swing.JButton();
        btnReceta = new javax.swing.JButton();
        btnImportarExcel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("VENTA DE AGROQUIMICOS");

        btnAltaAgroquimico.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnAltaAgroquimico.setText("Alta agroqumico");
        btnAltaAgroquimico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltaAgroquimicoActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\aleja\\OneDrive\\Imágenes\\caps\\th (2) (1).jpeg")); // NOI18N

        btnSalir.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnConsulta.setText("Consulta, borrar y modificar");
        btnConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaActionPerformed(evt);
            }
        });

        btnReceta.setText("generar recetas");
        btnReceta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecetaActionPerformed(evt);
            }
        });

        btnImportarExcel.setText("importar agroquimicos desde archivo exel");
        btnImportarExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportarExcelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAltaAgroquimico, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnReceta, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnConsulta)))
                    .addComponent(btnImportarExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAltaAgroquimico)
                        .addGap(27, 27, 27)
                        .addComponent(btnConsulta)
                        .addGap(29, 29, 29)
                        .addComponent(btnReceta)
                        .addGap(18, 18, 18)
                        .addComponent(btnImportarExcel)
                        .addGap(30, 30, 30)
                        .addComponent(btnSalir)
                        .addGap(147, 147, 147))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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

    private void btnAltaAgroquimicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaAgroquimicoActionPerformed

        AltaAgroquimico alta = new AltaAgroquimico();
        alta.setVisible(true);
        alta.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_btnAltaAgroquimicoActionPerformed

    private void btnConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaActionPerformed
        ConsultaAgroquimico consu = new ConsultaAgroquimico();
        consu.setVisible(true);
        consu.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnConsultaActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnRecetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecetaActionPerformed
 Receta receta = new Receta();  // Crear una instancia de la ventana Receta
    receta.setVisible(true);  // Hace visible la ventana de receta
    receta.setLocationRelativeTo(null);  // Centrar la ventana en la pantalla

    }//GEN-LAST:event_btnRecetaActionPerformed
//metodo del btnImportarExel para importar agroquimicos desde un archivo exel a nuestra BD
    private void btnImportarExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportarExcelActionPerformed
         JFileChooser fileChooser = new JFileChooser();
        
        fileChooser.setDialogTitle("Seleccione el archivo Excel");

        int userSelection = fileChooser.showOpenDialog(this);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            ExcelImporter importer = new ExcelImporter();
            importer.importarAgroquimicos(file.getAbsolutePath());

            JOptionPane.showMessageDialog(this, "Importación completada con éxito.");
        }
    }//GEN-LAST:event_btnImportarExcelActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAltaAgroquimico;
    private javax.swing.JButton btnConsulta;
    private javax.swing.JButton btnImportarExcel;
    private javax.swing.JButton btnReceta;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
