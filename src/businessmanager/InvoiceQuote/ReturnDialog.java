/*
 * ReturnDialog.java
 *
 * Created on January 4, 2007, 8:38 PM
 */

package businessmanager.InvoiceQuote;
import RuntimeManagement.GlobalApplicationDaemon;

import businessmanager.Common.JTextFieldFilter;
import datavirtue.*;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.table.*;


/**
 *
 * @author  Sean K Anderson - Data Virtue
 * @rights Copyright Data Virtue 2006, 2007 All Rights Reserved.
 */

public class ReturnDialog extends javax.swing.JDialog {
    private boolean debug = false;

    /** Creates new form ReturnDialog */
    
    private GlobalApplicationDaemon application;
    private Image winIcon;
    public ReturnDialog(java.awt.Frame parent, boolean modal, Invoice i, GlobalApplicationDaemon application) {
        super(parent, modal);

        Toolkit tools = Toolkit.getDefaultToolkit();
        winIcon = tools.getImage(getClass().getResource("/businessmanager/res/Orange.png"));
        initComponents();
        this.application = application;
        qtyField.setDocument(new JTextFieldFilter(JTextFieldFilter.FLOAT));
        priceField.setDocument(new JTextFieldFilter(JTextFieldFilter.FLOAT));

        //Version 1.5
        props = application.getProps();
        
        //datePicker1.setDateFormat(new SimpleDateFormat(props.getProp("DATEFORMAT")));
        
        //datePicker1.setDateFormat(new SimpleDateFormat("MM/dd/yy"));
        
        java.awt.Dimension dim = DV.computeCenter((java.awt.Window) this);
        this.setLocation(dim.width, dim.height);
        
        invoice= i;
        //System.out.println("KEY: "+invoice_key);
         
        jTable1.setModel(invoice.getInvItems());
        
        if (debug) System.out.println("Return Dialog: invoice payment count "+jTable1.getModel().getRowCount());
        setView();
       
        this.setVisible(true);        
    }
    
    private void setView () {
       
        TableColumnModel cm = jTable1.getColumnModel();
        TableColumn tc;
        
        int [] cols = new int [] {0,0,0,4,4,4};
        
        for (int i = 0; i < cols.length; i++){
        
            tc = cm.getColumn(cols[i]);
        
            jTable1.removeColumn(tc);//remove key column                        
        
        }        
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
            tc = jTable1.getColumnModel().getColumn(0);
            tc.setPreferredWidth(40);
            tc = jTable1.getColumnModel().getColumn(2);
            tc.setPreferredWidth(350);
        
    }
    
    private void populateForm () {
        
        //Object [] item = new Object [10];
        
        int the_row = jTable1.getSelectedRow();
        
        for (int c = 0; c < item.length; c++){
                      
            item[c] = jTable1.getModel().getValueAt(the_row, c);
                        
        }
        
        qtyField.setText(DV.money((Float) item[3]));
        codeField.setText((String) item[4] );
        descField.setText((String) item[5]);
        priceField.setText(DV.money((Float)item[6]));
       
    }
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        codeField = new javax.swing.JTextField();
        descField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        datePicker1 = new com.michaelbaranov.microba.calendar.DatePicker();
        priceField = new javax.swing.JTextField();
        qtyField = new javax.swing.JTextField();
        jToolBar1 = new javax.swing.JToolBar();
        returnButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Product Return");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(0, 0, 0));
        jTable1.setSelectionBackground(new java.awt.Color(204, 255, 255));
        jTable1.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jTable1.setDefaultRenderer(java.lang.Float.class,  new FractionCellRenderer (10, 2, javax.swing.SwingConstants.RIGHT));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        codeField.setEditable(false);
        codeField.setFont(new java.awt.Font("Tahoma", 0, 18));

        descField.setEditable(false);
        descField.setFont(new java.awt.Font("Tahoma", 0, 18));

        jLabel1.setText("Ret Qty");

        jLabel2.setText("Code");

        jLabel3.setText("Description");

        jLabel4.setText("Credit Amt");

        datePicker1.setToolTipText("Return Date");
        datePicker1.setFieldEditable(false);
        datePicker1.setShowNoneButton(false);
        datePicker1.setStripTime(true);

        priceField.setFont(new java.awt.Font("Tahoma", 0, 18));
        priceField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        qtyField.setFont(new java.awt.Font("Tahoma", 0, 18));
        qtyField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        returnButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/businessmanager/res/Aha-24/enabled/OK.png"))); // NOI18N
        returnButton.setText("Process");
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(returnButton);

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(qtyField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 72, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel1))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(codeField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                            .add(jLabel2))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(descField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                            .add(jLabel3))
                        .add(6, 6, 6)
                        .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel3Layout.createSequentialGroup()
                                .add(priceField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jToolBar1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 101, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(jLabel4)))
                    .add(datePicker1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 122, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(datePicker1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 16, Short.MAX_VALUE)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(jLabel2)
                    .add(jLabel4)
                    .add(jLabel1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jToolBar1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, descField)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, codeField)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, priceField)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, qtyField))
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jPanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /* The never ending nightmare method from hell
     that most likely contains more than one error. */
    /** 
     Return product to inventory
     *  
     Refund money to customer
     */

    private void processReturnTEST(){
        if (jTable1.getSelectedRow() > -1){

        }else {
            return;
        }

        if (!DV.validFloatString(priceField.getText())){
            javax.swing.JOptionPane.showMessageDialog(null,
                    "The credit amount must be a valid decimal number.");
            priceField.selectAll();
            priceField.requestFocus();
            return;
        }
        if (!DV.validFloatString(qtyField.getText())){
            javax.swing.JOptionPane.showMessageDialog(null,
                    "The quantity must be a valid decimal number.");
            qtyField.selectAll();
            qtyField.requestFocus();
            return;
        }

        if (debug) System.out.println("Selected Row: "+jTable1.getSelectedRow());
        int selectedRow = jTable1.getSelectedRow();
        
        float refundAmount = Float.parseFloat(priceField.getText());
        float userSuppliedReturnQty = Float.parseFloat(qtyField.getText());
        long date = datePicker1.getDate().getTime();
        
        int retStat = invoice.returnItem(selectedRow,
                userSuppliedReturnQty, refundAmount, date);
                //invoice.saveInvoice();
        if (debug) System.out.println("Return status: "+retStat);
        if (retStat > 0) this.dispose();
        if (retStat == -4){

            javax.swing.JOptionPane.showMessageDialog(null,
                    "You cannot use partial quantities on this item.");
            return;
        }
    }
    
    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
        
        //if (!DV.isValidShortDate(dateField.getText(), true)) return; /* DATE CHECK */
        processReturnTEST();
        
    }//GEN-LAST:event_returnButtonActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
    int mouseButton = evt.getButton();
    if (mouseButton == evt.BUTTON2 || mouseButton == evt.BUTTON3) return;    
        if (jTable1.getSelectedRow() > -1){
            
            String code = (String)jTable1.getModel().getValueAt(jTable1.getSelectedRow(),4);
            if (code.equalsIgnoreCase("RETURN")){
                
                qtyField.setText("0.0");
                codeField.setText("");
                descField.setText("");
                priceField.setText("");
                returnButton.setEnabled(false);
                return;
                
            }
            returnButton.setEnabled(true);
            populateForm();
            
        }
        
        
    }//GEN-LAST:event_jTable1MouseClicked
    
      
    private Settings props;   
    private Object [] item = new Object [10];
    private Invoice invoice;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField codeField;
    private com.michaelbaranov.microba.calendar.DatePicker datePicker1;
    private javax.swing.JTextField descField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField priceField;
    private javax.swing.JTextField qtyField;
    private javax.swing.JButton returnButton;
    // End of variables declaration//GEN-END:variables
    
}
