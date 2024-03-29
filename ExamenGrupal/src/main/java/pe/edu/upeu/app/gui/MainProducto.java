/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package pe.edu.upeu.app.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pe.edu.upeu.app.dao.ProductoDAO;
import pe.edu.upeu.app.dao.ProductoDaoI;
import pe.edu.upeu.app.modelo.CategoriaTO;
import pe.edu.upeu.app.modelo.MarcaTO;

/**
 *
 * @author EP-Ing_Sist.-CALIDAD
 */
public class MainProducto extends javax.swing.JPanel {

    /**
     * Creates new form MainProducto
     */
    ProductoDaoI daoP;
    
    public MainProducto() {
        initComponents();
        
        daoP=new ProductoDAO();        
        for (MarcaTO marcaTO : daoP.listCmbMarca("")) {
            comboBoxSuggestion1.addItem(marcaTO);
        }               
        comboBoxSuggestion1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println(((MarcaTO)comboBoxSuggestion1.getSelectedItem()).getIdMarca());
            }
        });        
        
        for (CategoriaTO catTO : daoP.listCmbCategoria("")) {
            comboBoxSuggestion2.addItem(catTO);
        }               
        comboBoxSuggestion2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println(((CategoriaTO)comboBoxSuggestion2.getSelectedItem()).getIdCategoria());
            }
        });                
        //pp.add(combox);        
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
        comboBoxSuggestion1 = new pe.com.syscenterlife.comboauto.ComboBoxSuggestion();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comboBoxSuggestion2 = new pe.com.syscenterlife.comboauto.ComboBoxSuggestion();

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setText("Marca:");

        jLabel2.setText("Categoria:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(comboBoxSuggestion2, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                    .addComponent(comboBoxSuggestion1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboBoxSuggestion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboBoxSuggestion2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(168, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(213, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private pe.com.syscenterlife.comboauto.ComboBoxSuggestion comboBoxSuggestion1;
    private pe.com.syscenterlife.comboauto.ComboBoxSuggestion comboBoxSuggestion2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
