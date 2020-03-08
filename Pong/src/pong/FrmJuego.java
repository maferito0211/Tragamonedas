package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
public class FrmJuego extends javax.swing.JFrame implements KeyListener{

    /**
     * Creates new form FrmJuego
     */
    int pelotaX=290;
    int pelotaY=195;
    int signoy=1;
    int signox=2;
    int paleta1=161;
    int paleta11;
    int paleta21;
    int paleta12;
    int paleta22;
    int paleta13;
    int paleta23;
    int paleta2=161;
    int jugador1=0;
    int jugador2=0;
    int aleatorio=(int)(Math.random()*6+1);
    public FrmJuego() {
        initComponents();
        addKeyListener(this);
    }
    
    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
    public void keyPressed(KeyEvent e)
    {
       System.out.println(e.getKeyCode());
       if(e.getKeyCode()==87 && paleta1>=40)
       {
           paleta1-=10;
       }
       if(e.getKeyCode()==83 && paleta1<=316)
       {
           paleta1+=10;
       }
       if(e.getKeyCode()==38 && paleta2>=40)
       {
           paleta2-=10;
       }
       if(e.getKeyCode()==40 && paleta2<=316)
       {
           paleta2+=10;
       }
    
    }

    
    public void paint(Graphics g)
    {
        super.paint(g);
        g.setColor(Color.GRAY);
        g.fillRect(299, 0, 2, 400);
        g.fillRect(23, 0, 2, 400);
        g.fillRect(575, 0, 2, 400);
        g.setColor(Color.BLACK);
        g.fillOval(pelotaX, pelotaY, 20, 20);
        g.fillRect(0, paleta1, 25, 75);
        g.fillRect(575, paleta2, 25, 75);
    }
    
    
    Timer temporizador = new Timer (10, new ActionListener ()
    {
        public void actionPerformed(ActionEvent e)
        {
            paleta11=paleta1+15;
            paleta21=paleta2+15;
            paleta12=paleta1+40;
            paleta22=paleta2+40;
            paleta13=paleta1+72;
            paleta23=paleta2+72;
            if (aleatorio==1)
            {
                pelotaX+=signox;
                pelotaY-=signoy;
            }
            else if (aleatorio==2)
            {
                pelotaX+=signox;
            }
            else if (aleatorio==3)
            {
                pelotaX+=signox;
                pelotaY+=signoy;
            }
            else if (aleatorio==4)
            {
                pelotaX-=signox;
                pelotaY-=signoy;
            }
            else if (aleatorio==5)
            {
                pelotaX-=signox;
            }
            else if (aleatorio==6)
            {
                pelotaX-=signox;
                pelotaY+=signoy;
            }
            if((pelotaX<=25 && pelotaY<=paleta11 && pelotaY>(paleta1-15)))
            {
                aleatorio=1;
            }
            else if ((pelotaX>=555 && pelotaY<=paleta21 && pelotaY>paleta2-15))
            {
                aleatorio=4;
            }
            else if((pelotaX<=25 && pelotaY<=paleta12 && pelotaY>paleta11))
            {
                aleatorio=2;
            }
            else if((pelotaX>=555 && pelotaY<=paleta22 && pelotaY>paleta21))
            {
                aleatorio=5;
            }
            else if((pelotaX<=25 && pelotaY<=paleta13 && pelotaY>paleta12))
            {
                aleatorio=3;
            }
            else if ((pelotaX>=555 && pelotaY<=paleta23 && pelotaY>paleta22))
            {
                aleatorio=6;
            }
            else if (pelotaX<=9 || pelotaX>=575 || pelotaY<=38 || pelotaY>=372)
            {
                if (pelotaX<=9)
                {
                    jugador2++;
                    lblJugador2.setText(String.valueOf(jugador2));
                    aleatorio=(int)(Math.random()*3+1);
                    pelotaX=290;
                    pelotaY=195;
                    
                }
                else if (pelotaX>=575)
                {
                    jugador1++;
                    lblJugador1.setText(String.valueOf(jugador1));
                    aleatorio=(int)(Math.random()*(6-4+1)+4);
                    pelotaX=290;
                    pelotaY=195;
                }
                else if (aleatorio==1)
                {
                    aleatorio=3;
                }
                else if (aleatorio==3)
                {
                    aleatorio=1;
                }
                else if (aleatorio==4)
                {
                    aleatorio=6;
                }
                else
                {
                    aleatorio=4;
                }
            }
            repaint();
            
        }
    
});
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblJugador2 = new javax.swing.JLabel();
        lblJugador1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(600, 400));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lblJugador2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblJugador2.setText("0");

        lblJugador1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblJugador1.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(lblJugador1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 184, Short.MAX_VALUE)
                .addComponent(lblJugador2)
                .addGap(98, 98, 98))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJugador2)
                    .addComponent(lblJugador1))
                .addContainerGap(217, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        temporizador.start();
    }//GEN-LAST:event_formWindowOpened

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
    private javax.swing.JLabel lblJugador1;
    private javax.swing.JLabel lblJugador2;
    // End of variables declaration//GEN-END:variables
}
