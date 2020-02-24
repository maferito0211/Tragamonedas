package tragamonedas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hp
 */
public class FrmJuego extends javax.swing.JFrame {

    int aleatorio;
    int aleatorio2;
    int aleatorio3;
    int contador=0;
    int velocidad=0;
    int velocidad2=0;
    int apuesta;
    int credito;
    
    Timer temporizador = new Timer(50, new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {   
            
            contador++;
            velocidad++;
            velocidad2++;
          
            if (contador<80 && velocidad2==5)
            {
                aleatorio3=(int)(Math.random()*10+1);
                switch(aleatorio3)
                {
                    case 1: lblTres.setIcon(new ImageIcon(this.getClass().getResource("Uno.png")));
                        break;
                    case 2: lblTres.setIcon(new ImageIcon(this.getClass().getResource("Dos.png")));
                        break;
                    case 3: lblTres.setIcon(new ImageIcon(this.getClass().getResource("Tres.png")));
                        break;
                    case 4: lblTres.setIcon(new ImageIcon(this.getClass().getResource("Cuatro.png")));
                        break;
                    case 5: lblTres.setIcon(new ImageIcon(this.getClass().getResource("Cinco.png")));
                        break;
                    case 6: lblTres.setIcon(new ImageIcon(this.getClass().getResource("Seis.png")));
                        break;
                    case 7: lblTres.setIcon(new ImageIcon(this.getClass().getResource("Siete.png")));
                        break;
                    case 8: lblTres.setIcon(new ImageIcon(this.getClass().getResource("Ocho.png")));
                        break;
                    case 9: lblTres.setIcon(new ImageIcon(this.getClass().getResource("Nueve.png")));
                        break;
                    case 10: lblTres.setIcon(new ImageIcon(this.getClass().getResource("Diez.png")));
                        break;
                }
                velocidad2=0;
            }
            
            if (contador<40 && velocidad==3)
            {
                aleatorio2=(int)(Math.random()*10+1);
                switch(aleatorio2)
                {
                    case 1: lblDos.setIcon(new ImageIcon(this.getClass().getResource("Uno.png")));
                        break;
                    case 2: lblDos.setIcon(new ImageIcon(this.getClass().getResource("Dos.png")));
                        break;
                    case 3: lblDos.setIcon(new ImageIcon(this.getClass().getResource("Tres.png")));
                        break;
                    case 4: lblDos.setIcon(new ImageIcon(this.getClass().getResource("Cuatro.png")));
                        break;
                    case 5: lblDos.setIcon(new ImageIcon(this.getClass().getResource("Cinco.png")));
                        break;
                    case 6: lblDos.setIcon(new ImageIcon(this.getClass().getResource("Seis.png")));
                        break;
                    case 7: lblDos.setIcon(new ImageIcon(this.getClass().getResource("Siete.png")));
                        break;
                    case 8: lblDos.setIcon(new ImageIcon(this.getClass().getResource("Ocho.png")));
                        break;
                    case 9: lblDos.setIcon(new ImageIcon(this.getClass().getResource("Nueve.png")));
                        break;
                    case 10: lblDos.setIcon(new ImageIcon(this.getClass().getResource("Diez.png")));
                        break;
                }
                velocidad=0;
            }
            
            if (contador<20)
            {
                aleatorio=(int)(Math.random()*10+1);
                switch(aleatorio)
                {
                    case 1: lblUno.setIcon(new ImageIcon(this.getClass().getResource("Uno.png")));
                        break;
                    case 2: lblUno.setIcon(new ImageIcon(this.getClass().getResource("Dos.png")));
                        break;
                    case 3: lblUno.setIcon(new ImageIcon(this.getClass().getResource("Tres.png")));
                        break;
                    case 4: lblUno.setIcon(new ImageIcon(this.getClass().getResource("Cuatro.png")));
                        break;
                    case 5: lblUno.setIcon(new ImageIcon(this.getClass().getResource("Cinco.png")));
                        break;
                    case 6: lblUno.setIcon(new ImageIcon(this.getClass().getResource("Seis.png")));
                        break;
                    case 7: lblUno.setIcon(new ImageIcon(this.getClass().getResource("Siete.png")));
                        break;
                    case 8: lblUno.setIcon(new ImageIcon(this.getClass().getResource("Ocho.png")));
                        break;
                    case 9: lblUno.setIcon(new ImageIcon(this.getClass().getResource("Nueve.png")));
                        break;
                    case 10: lblUno.setIcon(new ImageIcon(this.getClass().getResource("Diez.png")));
                        break;
                }
            }
            
            
            if (contador==80)
            {
                if (aleatorio==aleatorio2 && aleatorio2==aleatorio3)
                {
                    if (aleatorio==7)
                    {
                        JOptionPane.showMessageDialog(null,"Ganaste el triple de lo apostado");
                        String variable=(String) cbxApuesta.getSelectedItem();
                        apuesta=(Integer.parseInt(txtCredito.getText()))+(2*(Integer.parseInt(variable)));
                        txtCredito.setText(String.valueOf(apuesta));
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Ganaste el doble de lo apostado");
                        String variable=(String) cbxApuesta.getSelectedItem();
                        apuesta=(Integer.parseInt(txtCredito.getText()))+(Integer.parseInt(variable));
                        txtCredito.setText(String.valueOf(apuesta));
                    }
                    
                }
                
                else if ((aleatorio==aleatorio2 && aleatorio3==10) || (aleatorio2==aleatorio3 && aleatorio==10) || (aleatorio==aleatorio3 && aleatorio2==10))
                {
                    JOptionPane.showMessageDialog(null,"Se gana lo apostado");
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Se pierde lo apostado");
                    String variable=(String) cbxApuesta.getSelectedItem();
                    apuesta=(Integer.parseInt(txtCredito.getText()))-(Integer.parseInt(variable));
                    txtCredito.setText(String.valueOf(apuesta));
                }
                System.out.print(aleatorio);
                System.out.print(aleatorio2);
                System.out.print(aleatorio3);
                temporizador.stop();
            }
            
        }
    });
    
    public FrmJuego() {
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

        lblUno = new javax.swing.JLabel();
        lblDos = new javax.swing.JLabel();
        lblTres = new javax.swing.JLabel();
        cbxApuesta = new javax.swing.JComboBox();
        btnApostar = new javax.swing.JButton();
        txtCredito = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(java.awt.Color.white);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lblUno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tragamonedas/Siete.png"))); // NOI18N

        lblDos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tragamonedas/Siete.png"))); // NOI18N

        lblTres.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tragamonedas/Diez.png"))); // NOI18N

        cbxApuesta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "5", "10", "20", "50", "100" }));

        btnApostar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnApostar.setText("¡APOSTAR!");
        btnApostar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApostarActionPerformed(evt);
            }
        });

        txtCredito.setText("100");
        txtCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCreditoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Apuesta:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Crédito:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(lblUno)
                .addGap(84, 84, 84)
                .addComponent(lblDos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addComponent(lblTres)
                .addGap(60, 60, 60))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxApuesta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(322, 322, 322))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnApostar)
                        .addGap(287, 287, 287))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDos)
                    .addComponent(lblUno)
                    .addComponent(lblTres))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxApuesta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(42, 42, 42)
                .addComponent(btnApostar)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
    }//GEN-LAST:event_formWindowOpened

    private void btnApostarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApostarActionPerformed
        String variable=(String) cbxApuesta.getSelectedItem();
        apuesta=Integer.parseInt(variable);
        credito=Integer.parseInt(txtCredito.getText());
        if (apuesta<=credito)
        {
            contador=0;
            velocidad=0;
            velocidad2=0;
            temporizador.start();
        }
        else
        {
            JOptionPane.showMessageDialog(null,"No hay suficiente crédito");
        }
    }//GEN-LAST:event_btnApostarActionPerformed

    private void txtCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCreditoActionPerformed
       
    }//GEN-LAST:event_txtCreditoActionPerformed

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
            java.util.logging.Logger.getLogger(FrmJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmJuego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApostar;
    private javax.swing.JComboBox cbxApuesta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblDos;
    private javax.swing.JLabel lblTres;
    private javax.swing.JLabel lblUno;
    private javax.swing.JTextField txtCredito;
    // End of variables declaration//GEN-END:variables
}
