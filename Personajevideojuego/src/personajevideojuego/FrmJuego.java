package personajevideojuego;

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
public class FrmJuego extends javax.swing.JFrame implements KeyListener {

    int filas,columnas;
    int caminar;
    int correr;
    int salto;
    int izquierda,z,c,Z3,v;
    int X1=0;
    int Y1=170;
    int X3,Y3,X,Y,X2,Y2=600;
    int signo=1;
    public static int r=new Color(32,142,137).getRGB();
    public static int n=new Color(0,0,0).getRGB();
    public static int b=new Color(255,255,255).getRGB();
    public static int w=new Color(255,255,255).getRGB();
    public static int a=new Color(236,183,21).getRGB();
    public static int t=new Color(240,0,0).getRGB();
    public static int g=new Color(115,125,138).getRGB();
    public static int p=new Color(255,211,168).getRGB();
    public static int o=new Color(0,0,0).getRGB();
    public static int x=new Color(0,0,0).getRGB();
    int [][] paso2={               {b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b},
                                   {b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,n,n,b},
                                   {b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,n,n,n,n,n,n,n,a,a,n},
                                   {b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,n,a,a,a,a,a,a,a,a,a,n},
                                   {b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,n,a,a,a,a,a,a,a,a,a,a,n},
                                   {b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,n,a,a,a,a,a,a,a,a,a,a,n},
                                   {b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,n,a,a,a,a,a,p,p,p,p,p,n},
                                   {b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,n,a,a,a,p,a,p,p,p,p,p,n},
                                   {b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,n,a,a,a,p,a,p,p,p,p,p,n},
                                   {b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,n,a,a,a,p,p,p,p,w,w,p,n},
                                   {b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,n,a,a,a,p,p,p,p,w,n,p,n},
                                   {b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,n,a,a,a,p,p,p,w,n,p,n},
                                   {b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,n,n,n,n,p,p,p,p,p,p,w,w,p,n},
                                   {b,b,b,b,b,b,b,b,b,b,b,b,b,n,n,t,t,t,t,n,p,p,p,p,p,n,n,p,n},
                                   {b,b,b,b,b,b,b,b,b,b,b,b,n,p,p,t,t,t,t,t,n,n,p,p,p,p,p,n,b},
                                   {b,b,b,b,b,b,b,b,b,b,b,n,p,n,n,p,t,n,t,t,t,n,n,n,n,n,n,b,b},
                                   {b,b,b,b,b,b,b,b,b,b,b,n,n,p,p,n,n,t,t,t,t,t,t,t,n,b,b,b,b},
                                   {b,b,b,b,b,b,b,b,b,b,b,n,p,p,p,p,n,t,t,t,t,t,t,n,n,n,n,b,b},
                                   {b,b,b,b,b,b,b,b,b,b,b,b,n,p,p,n,n,n,r,r,r,n,n,p,n,p,p,n,b},
                                   {b,b,b,b,b,b,b,b,b,b,b,b,b,n,n,n,n,r,r,r,r,r,n,n,n,p,p,n,b},
                                   {b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,n,r,n,n,r,r,r,r,r,n,n,n,b,b},
                                   {b,b,b,b,b,b,b,b,b,b,b,b,b,b,n,r,r,r,r,n,r,r,r,r,n,b,b,b,b},
                                   {b,b,b,b,b,b,b,b,b,b,b,b,b,n,g,r,r,r,n,r,r,r,r,n,b,b,b,b,b},
                                   {b,b,b,b,b,b,b,b,b,b,b,b,b,n,g,g,g,n,n,g,g,g,g,n,b,b,b,b,b},
                                   {b,b,b,b,b,b,b,b,b,b,b,b,b,n,n,g,g,g,g,n,g,g,g,g,n,b,b,b,b},
                                   {b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,n,n,n,n,n,n,n,n,n,n,n,b,b,b},};
    
    
    int [][] paso1={               {b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,n,n,b,b,b},
                                   {b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,n,n,n,n,n,n,n,a,a,n,b,b},
                                   {b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,n,a,a,a,a,a,a,a,a,a,n,b,b},
                                   {b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,n,a,a,a,a,a,a,a,a,a,a,n,b,b},
                                   {b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,n,a,a,a,a,a,a,a,a,a,a,n,b,b},
                                   {b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,n,a,a,a,a,a,p,p,p,p,p,n,b,b},
                                   {b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,n,a,a,a,p,a,p,p,p,p,p,n,b,b},
                                   {b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,n,a,a,a,p,a,p,p,p,p,p,n,b,b},
                                   {b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,n,a,a,a,p,p,p,p,w,w,p,n,b,b},
                                   {b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,n,a,a,a,p,p,p,p,w,n,p,n,b,b},
                                   {b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,n,a,a,a,p,p,p,w,n,p,n,b,b},
                                   {b,b,b,b,b,b,b,b,b,b,b,b,b,n,n,n,n,p,p,p,p,p,p,w,w,p,n,b,b},
                                   {b,b,b,b,b,b,b,b,b,b,b,n,n,p,p,n,t,n,p,p,p,p,p,n,n,p,n,b,b},
                                   {b,b,b,b,b,b,b,b,b,b,n,p,p,p,n,t,t,t,n,n,p,p,p,p,p,n,b,b,b},
                                   {b,b,b,b,b,b,b,b,b,b,n,p,p,n,t,t,t,t,t,t,n,n,n,n,n,n,b,b,b},
                                   {b,b,b,b,b,b,b,b,b,b,n,p,n,t,t,t,t,t,t,t,t,p,p,p,p,n,b,b,b},
                                   {b,b,b,b,b,b,b,b,b,b,b,n,r,r,t,t,t,t,n,t,t,p,p,p,p,n,b,b,b},
                                   {b,b,b,b,b,b,n,n,n,b,b,n,r,r,r,r,t,n,n,n,p,p,p,p,n,b,b,b,b},
                                   {b,b,b,b,b,n,g,g,g,n,b,n,r,r,r,r,r,r,n,n,n,n,n,n,b,b,b,b,b},
                                   {b,b,b,b,n,g,g,g,r,r,n,n,r,r,r,r,r,n,r,r,r,r,r,n,n,n,n,n,n},
                                   {b,b,b,n,g,g,g,g,r,r,r,r,r,r,n,n,n,n,n,n,r,r,r,r,r,r,g,g,n},
                                   {b,b,n,g,g,g,g,r,r,r,r,r,r,n,b,b,b,b,b,n,r,r,r,r,r,g,g,n,n},
                                   {b,b,n,n,n,n,n,n,r,r,r,r,n,b,b,b,b,b,b,b,n,r,r,r,g,g,n,n,n},
                                   {b,b,b,b,b,b,b,b,n,n,n,n,n,b,b,b,b,b,b,b,b,n,r,g,g,n,n,n,b},
                                   {b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,n,g,n,n,n,b,b},
                                   {b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,n,n,n,b,b,b}};
    
    int [][] paso3={               {b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b},
                                   {b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,n,n,b,b,b},
                                   {b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,n,n,n,n,n,n,n,a,a,n,b,b},
                                   {b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,n,n,a,a,a,a,a,a,a,a,a,n,b,b},
                                   {b,b,b,b,b,b,b,b,b,b,b,b,b,b,n,a,a,a,a,a,a,a,a,a,a,a,n,b,b},
                                   {b,b,b,b,b,b,b,b,b,b,b,b,b,b,n,a,a,a,a,a,a,a,a,a,a,a,n,b,b},
                                   {b,b,b,b,b,b,b,b,b,b,b,b,b,b,n,a,a,a,p,p,p,p,p,p,p,p,n,b,b},
                                   {b,b,b,b,b,b,b,b,b,b,b,b,b,b,n,a,p,a,p,p,p,p,p,p,p,p,n,b,b},
                                   {b,b,b,b,b,b,b,b,b,b,b,b,b,b,n,a,p,a,p,p,b,b,b,p,b,b,n,b,b},
                                   {b,b,b,b,b,b,b,b,b,b,b,b,b,b,n,a,p,p,p,b,b,n,n,p,n,b,n,b,b},
                                   {b,b,b,b,b,b,b,b,b,b,b,b,n,n,n,n,a,p,p,b,b,n,n,p,n,b,n,b,b},
                                   {b,b,b,b,b,b,b,b,b,b,n,n,p,t,t,n,n,p,p,p,b,b,b,p,b,p,n,b,b},
                                   {b,b,b,b,b,b,b,b,b,n,p,p,p,t,t,t,t,n,p,p,n,n,n,n,p,n,b,b,b},
                                   {b,b,b,b,b,b,b,b,n,p,p,p,p,n,n,t,t,t,n,p,p,p,p,p,n,n,n,b,b},
                                   {b,b,b,b,b,b,b,b,n,p,p,p,n,g,n,t,t,t,t,n,n,n,n,n,p,p,p,n,b},
                                   {b,b,b,b,b,b,b,b,b,n,n,n,g,n,t,t,t,t,t,t,t,t,p,n,p,p,p,n,b},
                                   {b,b,b,b,b,b,b,b,b,b,b,b,n,r,r,t,t,t,t,t,n,n,p,p,n,p,n,b,b},
                                   {b,b,b,b,b,b,b,n,n,n,b,b,n,r,r,r,r,r,r,n,n,g,n,n,n,n,b,b,b},
                                   {b,b,b,b,b,b,n,g,g,g,n,b,n,r,r,r,r,r,r,r,n,n,b,b,b,b,b,b,b},
                                   {b,b,b,b,b,n,g,g,g,r,r,n,n,n,r,r,r,r,r,n,r,r,n,n,n,n,n,n,n},
                                   {b,b,b,b,n,g,g,g,r,r,r,r,r,r,n,n,n,n,n,n,r,r,r,r,r,g,g,g,n},
                                   {b,b,b,b,n,g,g,g,r,r,r,r,r,r,n,b,b,b,b,n,r,r,r,r,g,g,n,n,n},
                                   {b,b,b,b,n,g,g,n,n,r,r,r,r,n,b,b,b,b,b,b,n,r,r,g,g,n,n,n,b},
                                   {b,b,b,b,n,n,n,b,b,n,n,n,n,n,b,b,b,b,b,b,b,n,r,g,n,n,n,b,b},
                                   {b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,n,g,n,n,b,b,b},
                                   {b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,n,n,b,b,b,b}};
    
    int [][] paso4={               {b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,n,n,b,b,b,b,b,b,b,b,b,b,b},
                                   {b,b,b,b,b,b,b,b,b,n,n,n,n,n,n,n,a,a,n,b,b,b,b,b,b,b,b,b,b},
                                   {b,b,n,n,b,b,b,n,n,a,a,a,a,a,a,a,a,a,n,b,b,b,b,b,b,b,b,b,b},
                                   {b,n,p,p,n,b,n,a,a,a,a,a,a,a,a,a,a,a,n,b,b,b,b,b,b,b,b,b,b},
                                   {n,p,p,p,p,n,n,a,a,a,a,a,a,a,a,a,a,a,n,b,b,b,b,b,b,b,b,b,b},
                                   {n,p,p,p,n,n,n,a,a,a,p,p,p,p,p,p,p,p,n,b,b,b,b,b,b,n,n,b,b},
                                   {b,n,p,p,n,p,n,a,p,a,p,p,p,p,p,p,p,p,n,b,b,b,b,b,n,p,p,n,b},
                                   {b,b,n,p,p,p,p,a,p,a,p,p,b,b,b,p,b,b,n,b,b,b,b,n,p,p,p,p,n},
                                   {b,b,b,n,p,p,p,a,p,p,p,b,b,n,n,p,n,b,n,b,b,b,n,p,n,p,p,p,n},
                                   {b,b,b,b,n,p,p,t,a,p,p,b,b,n,n,p,n,b,n,n,n,n,p,p,p,p,p,n,b},
                                   {b,b,b,b,b,n,t,t,n,p,p,p,b,b,b,p,b,p,n,t,t,p,p,p,p,n,n,b,b},
                                   {b,b,b,b,b,b,n,t,t,n,p,p,p,n,n,n,p,n,t,t,t,p,p,p,n,b,b,b,b},
                                   {b,b,b,b,b,b,b,n,t,t,n,p,n,n,n,n,n,t,t,t,t,n,n,n,b,b,b,b,b},
                                   {b,b,b,b,b,b,b,n,t,t,t,n,p,n,n,n,t,t,n,n,n,b,b,b,b,b,b,b,b},
                                   {b,b,b,b,b,b,b,b,n,t,t,t,t,t,t,t,t,n,b,b,b,b,b,b,b,b,b,b,b},
                                   {b,b,b,b,b,b,b,b,n,t,t,t,t,t,t,t,t,n,b,b,b,b,b,b,b,b,b,b,b},
                                   {b,b,b,b,b,b,b,b,n,t,t,t,t,t,t,t,t,n,n,n,b,b,b,b,b,b,b,b,b},
                                   {b,b,b,b,b,b,b,b,n,r,r,r,r,r,r,r,r,r,r,r,n,b,b,b,b,b,b,b,b},
                                   {b,b,b,b,b,b,b,b,n,r,r,r,r,r,r,r,r,r,r,r,r,n,b,b,b,b,b,b,b},
                                   {b,b,b,b,b,b,b,b,n,r,r,r,r,r,r,r,r,r,r,r,r,n,b,b,b,b,b,b,b},
                                   {b,b,b,b,b,b,b,b,n,r,r,r,r,n,n,n,n,r,r,r,r,n,b,b,b,b,b,b,b},
                                   {b,b,b,b,b,b,b,b,n,r,r,r,n,b,b,b,b,n,g,g,g,g,n,b,b,b,b,b,b},
                                   {b,b,b,b,b,b,b,b,n,r,r,r,n,b,b,b,b,n,g,g,g,g,g,n,b,b,b,b,b},
                                   {b,b,b,b,b,b,b,b,n,r,r,r,n,b,b,b,b,n,n,g,g,g,g,n,b,b,b,b,b},
                                   {b,b,b,b,b,b,b,b,n,r,r,r,g,n,b,b,b,b,b,n,n,n,n,b,b,b,b,b,b},
                                   {b,b,b,b,b,b,b,b,b,n,g,g,g,n,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b},
                                   {b,b,b,b,b,b,b,b,b,n,g,g,g,n,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b},
                                   {b,b,b,b,b,b,b,b,b,n,g,g,g,n,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b},
                                   {b,b,b,b,b,b,b,b,b,n,g,g,g,n,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b},
                                   {b,b,b,b,b,b,b,b,b,n,g,g,g,n,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b},
                                   {b,b,b,b,b,b,b,b,b,b,n,n,n,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b},};
    public FrmJuego() {
        initComponents();
        addKeyListener(this);
        this.getContentPane().setBackground(Color.WHITE);
    }
    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
    public void keyPressed(KeyEvent e)
    {
       if(e.getKeyCode()==39)
       {
            z++;
            signo=1;
            if(c==1)
            {
                if(z==1)
                {
                    X2-=68;
                }
                else if(z==2)
                {
                    X1-=68;
                }
                else if(z==3)
                {
                    X-=68;
                }
                else
                {
                    X1-=68; 
                }
            }
            if(z==1)
            {
                X1=X2+10;
                Y1=170;
                Y=1000;
                Y2=1000;
                Z3=X1;
            }
            else if(z==2)
            {
                X=X1+10;
                Y=170;
                Y1=1000;
                Y2=1000;
                Z3=X;
            }
            else if(z==3)
            {
                X1=X+10;
                Y1=170;
                Y=1000;
                Y2=1000;
                Z3=X1;
            }
            else
            {
                X2=X1+10;
                Y2=170;
                Y=1000;
                Y1=1000;
                z=0;
                Z3=X2;
            }
            c=0;
            v=1;
       }
       if(e.getKeyCode()==37)
       {
            z++;
            signo=-1;
            if(c==0)
            {
                if(z==1)
                {
                    X2+=68;
                }
                else if(z==2)
                {
                    X1+=68;
                }
                else if(z==3)
                {
                    X+=68;
                }
                else
                {
                    X1+=68; 
                }
            }
            if(z==1)
            {
                X1=X2-10;
                Y1=170;
                Y=1000;
                Y2=1000;
                Z3=X1;
            }
            else if(z==2)
            {
                X=X1-10;
                Y=170;
                Y1=1000;
                Y2=1000;
                Z3=X;
            }
            else if(z==3)
            {
                X1=X-10;
                Y1=170;
                Y=1000;
                Y2=1000;
                Z3=X1;
            }
            else
            {
                X2=X1-10;
                Y2=170;
                Y=1000;
                Y1=1000;
                z=0;
                Z3=X2;
            }
            c=1;
            v=1;
       }
       if(e.getKeyCode()==38)
       {
           if(c==0)
            {
                
                if(v==1)
                {
                    X3=Z3;
                    Y3=170-20;
                    Y=1000;
                    Y1=1000;
                    Y2=1000;
                }
                else if(v==2)
                {
                    X3=Z3+10;
                    Y3=170-50;
                    Y=1000;
                    Y1=1000;
                    Y2=1000;
                }
                else if(v==3)
                {
                    X3=Z3+20;
                    Y3=170-20;
                    Y=1000;
                    Y1=1000;
                    Y2=1000;
                }
                else
                {
                    X3=1000;
                    Y2=1000;
                    Y=1000;
                    Y1=170;
                    X1=Z3+20;
                    
                }
                v++;
            }
           else
            {
                if(v==1)
                {
                    X3=Z3;
                    Y3=170-20;
                    Y=1000;
                    Y1=1000;
                    Y2=1000;
                }
                else if(v==2)
                {
                    X3=Z3-10;
                    Y3=170-50;
                    Y=1000;
                    Y1=1000;
                    Y2=1000;
                }
                else if(v==3)
                {
                    X3=Z3-20;
                    Y3=170-20;
                    Y=1000;
                    Y1=1000;
                    Y2=1000;
                }
                else
                {
                    X3=1000;
                    Y2=1000;
                    Y=1000;
                    Y1=170;
                    X1=Z3-20;
                    
                }
                v++;
            }
       }
    }  
    public void paint(Graphics g)
    {
       super.paint(g);
        for(filas=0;filas<26*2;filas++)
        {
            for(columnas=0;columnas<29*2;columnas++)
            {
                g.setColor(new Color(paso2[filas/2][columnas/2]));
                g.drawRect(X1+(columnas*signo),Y1+filas,1,1);
               
            }
        }
        for(filas=0;filas<26*2;filas++)
        {
            for(columnas=0;columnas<29*2;columnas++)
            {
                g.setColor(new Color(paso1[filas/2][columnas/2]));
                g.drawRect(X+(columnas*signo),Y+filas,1,1);
               
            }
        }
        for(filas=0;filas<26*2;filas++)
        {
            for(columnas=0;columnas<29*2;columnas++)
            {
                g.setColor(new Color(paso3[filas/2][columnas/2]));
                g.drawRect(X2+(columnas*signo),Y2+filas,1,1);
               
            }
        }
        for(filas=0;filas<26*2;filas++)
        {
            for(columnas=0;columnas<29*2;columnas++)
            {
                g.setColor(new Color(paso4[filas/2][columnas/2]));
                g.drawRect(X3+(columnas*signo),Y3+filas,1,1);
               
            }
        }
    }
    
    Timer temporizador = new Timer (1000, new ActionListener ()
    {
        public void actionPerformed(ActionEvent e)
        {
            repaint();           
        }
        
    });
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
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
    // End of variables declaration//GEN-END:variables
}
