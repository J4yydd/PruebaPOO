
package mx.edu.uaz.is.poo2.gb.gannetapp.igu;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import mx.edu.uaz.is.poo2.gb.gannetapp.logica.Agroquimico;
import mx.edu.uaz.is.poo2.gb.gannetapp.logica.Controladora;
import mx.edu.uaz.is.poo2.gb.gannetapp.igu.mensajes.Mensajes;

public class ConsultaAgroquimico extends javax.swing.JFrame {
    Controladora control= new Controladora();
    Mensajes mensajes = new Mensajes();
   
    public ConsultaAgroquimico() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAgroquimicos = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("VENTA DE AGROQUIMICOS");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setText("CONSULTA DE AGROQUIMICOS");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tablaAgroquimicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaAgroquimicos);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnEliminar)
                .addGap(18, 18, 18)
                .addComponent(btnModificar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(195, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 61, Short.MAX_VALUE))
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
//metodo que se encarga de cargar la tabla y mostrarla en pantalla
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
     cargarTabla();
    }//GEN-LAST:event_formWindowOpened

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

//primero tenemos que controlar que la tabla no este vacia
// control para que la tabla no este vacia
        if(tablaAgroquimicos.getRowCount()>0){
// valido que se selecciono un registro
            if(tablaAgroquimicos.getSelectedRow()!=-1){
            //obtener el id del agroquimico que quiero borrar
                int idAgro = Integer.parseInt(
                        String.valueOf( tablaAgroquimicos.getValueAt(tablaAgroquimicos.getSelectedRow(), 0)));
            control.borrarAgroquimico(idAgro);
            //mensaje que se borro correctamente 
           mensajes.mostrarMensaje("agroquimico borrado correctamente","Info","borrado exitoso");
            cargarTabla();
            }
        else {
                mensajes.mostrarMensaje("Debe seleccionar un registro para eliminar", "Error", "Error de Selección");
            }
        } else {
            mensajes.mostrarMensaje("No hay datos en la tabla,no se puede eliminar", "Error", "Tabla Vacía");
        }
        //revisar que se halla seleccionado un argoquimico que se desee borrar
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if(tablaAgroquimicos.getRowCount()>0){
            if(tablaAgroquimicos.getSelectedRow()!=-1){
               //obtenemos el id del agroquimico que quiero modificar
                int idAgro = Integer.parseInt(
                        String.valueOf( tablaAgroquimicos.getValueAt(tablaAgroquimicos.getSelectedRow(), 0)));
                
                ModifAgroquimico modif = new ModifAgroquimico(idAgro);
                modif.setVisible(true);
                modif.setLocationRelativeTo(null);
                // al darle click a modificar me llame a la nueva ventana y a la ventana de la tabla se cierre
                this.dispose();
            }
            
            
            else{ 
                mensajes.mostrarMensaje("Debe seleccionar un registro para modificar", "Error", "Error de Selección");
            }
        }
        else{
                    mensajes.mostrarMensaje("No hay datos en la tabla,no se puede modificar", "Error", "Tabla Vacía");

        }


    }//GEN-LAST:event_btnModificarActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaAgroquimicos;
    // End of variables declaration//GEN-END:variables

    private void cargarTabla() {
       
        DefaultTableModel modeloTabla =new DefaultTableModel(){
@Override
public boolean isCellEditable(int row,int column){
    return false;
}

    };
// ponemos titulo a las columnas 
String titulos[]={"Id", "Nombre","categoria","tipoPlaga","precio","alcance","capacidad" };
        modeloTabla.setColumnIdentifiers(titulos);
        // traer los agroquimicos desde la Base de datos
        List <Agroquimico> listaAgroquimicos = control.traerAgroquimicos();
        
        //setear los datos en la tabla
        if(listaAgroquimicos !=null){
            for(Agroquimico agro : listaAgroquimicos){
            Object[] object = {agro.getId(),agro.getNombre(),agro.getCategoria(),agro.getTipoPlaga(),agro.getPrecio(),agro.getAlcance(),agro.getCapacidad()};
            
            modeloTabla.addRow(object);
            }
        }
          tablaAgroquimicos.setModel(modeloTabla);
        
        }
}
