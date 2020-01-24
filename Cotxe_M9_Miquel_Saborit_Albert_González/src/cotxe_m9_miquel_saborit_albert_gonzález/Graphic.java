/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cotxe_m9_miquel_saborit_albert_gonzález;

/**
 *
 * @author Miquel Saborit
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class Graphic extends JFrame {

    private JPanel contentPane;

    public int[] coord = {70, 220, 370, 520, 670};
    public int[] colX = coord.clone();
    public int[] filaY = coord.clone();
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Graphic frame = new Graphic();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Graphic() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(0, 0, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setBounds(0,0,800,600);
    }
    
    public void colorYellow(Graphics g) {
        Color color = new Color(255, 255, 126);
        g.setColor(color);
    }
    
    public void colorBlack(Graphics g) {
        Color color = new Color(0, 0, 0);
        g.setColor(color);
    }
    
    public void colorRed(Graphics g) {
        Color color = new Color(255, 0, 0);
        g.setColor(color);
    }
    
    public void colorGreen(Graphics g) {
        Color color = new Color(0, 255, 0);
        g.setColor(color);
    }
    
    public void paint (Graphics g)
    {
        super.paint(g);
        
        try {
            
            colorYellow(g);
            
            // COLUMNES
            // x y ancho alto
            
            for (int i : colX) {
                colorYellow(g);
                g.fillRect((int)calcX(i), (int)inicialY(), 30, (int)heightMax());
            }
            
            // FILES
            // x y ancho alto
            
            for (int i : filaY) {
                
                g.fillRect((int)inicialX(), (int)calcY(i), (int)widthMax(), 30);
            }
            
            //colorBlack(g);
            
            for (int i : colX) {
                
                for (int j : filaY) {
                
                    // CADA 150 AÑADIR SEMÁFOROS (30*30)
                    drawSemafor(i,j,"vertical", g);
                    
                }
                
            }
            
        } catch (Exception ex) {
            System.out.println("Error al inserir algun element al draw");
        }
        
    }
    
    public void drawSemafor(int i, int j, String type, Graphics g) {
    
        switch(type) {
            case "horizontal":
                    colorRed(g);
                    lines1(i,j,g);
                    
                    colorGreen(g);
                    lines2(i,j,g);
                
                break;
            case "vertical":
                
                    colorGreen(g);
                    lines1(i,j,g);
                    
                    colorRed(g);
                    lines2(i,j,g);
                
                break;
        }
        
    }
    
    public void lines1(int i, int j, Graphics g) {
    
        g.drawLine((int)calcX(i),(int)calcY(j),(int)calcX(i)+30, (int)calcY(j));
        g.drawLine((int)calcX(i),(int)calcY(j)+30,(int)calcX(i)+30,(int)calcY(j)+30);
        
    }
    
    public void lines2(int i, int j, Graphics g) {
    
        g.drawLine((int)calcX(i),(int)calcY(j),(int)calcX(i), (int)calcY(j)+30);
        g.drawLine((int)calcX(i)+30,(int)calcY(j),(int)calcX(i)+30,(int)calcY(j)+30);
        
    } 
    
    public double heightMax() {
        // 700 hasta el borde de la última fila
        // 730 hasta el final del frame
        return 730;
    }
    
    public double widthMax() {
        return 785;
    }
    
    public double inicialX() {
        return 8;
    }
    
    public double calcX(double factor) {
        if (factor < 0) {
            return (inicialX() - factor);
        } else if (factor > 0) {
            return (inicialX() + factor);
        } else {
            return inicialX();
        }
    }
    
    public double inicialY() {
        return 31;
    }
    
    public double calcY(double factor) {
        if (factor < 0) {
            return (inicialY() - factor);
        } else if (factor > 0) {
            return (inicialY() + factor);
        } else {
            return inicialY();
        }
    }
}