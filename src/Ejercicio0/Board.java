/*
PLANTILLA BASE PARA CREACION DE ESCENARIOS.
 */
package Ejercicio0;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Board extends JPanel implements ActionListener
{
    private int xref;
    private int yref;
    private Timer timer; 
    private int ref1 = 0;
    
    
    public Board()
    {
      this.xref = 10;
      this.yref = 0;
      this.timer = new Timer(50, this);
      this.timer.start();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Image fondo = loadImage("fondo.png");
        g.drawImage(fondo, 0, 0, this);
        
        Image gato = loadImage("cats.gif");
//        g.drawImage(gato, 30, 100, 162, 180, 0, 0, 132, 80, this);
//        g.drawImage(gato, 162, 100, 294, 180, 132, 0, 264, 80, this);
        
        g.drawImage(gato, this.xref, 50, this.xref+132, 130, this.ref1*132, 0, (this.ref1*132)+132, 80,this);
        //
        
        
        
        g.setColor(Color.red);
        g.drawRect(this.xref,50 ,20, 20);
        Rectangle carro = new Rectangle(this.xref,50 ,20, 20);
        
        g.fillOval(40, this.yref, 15, 15);
        Rectangle oval = new Rectangle(40, this.yref, 15, 15);
        
        if(carro.intersects(oval)){
          //this.timer.stop();
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        this.xref++;
        this.yref++;
        if(this.ref1 <= 5)
        {
            this.ref1++;
        }else
        {
            this.ref1 = 0;
        }
        
      
        repaint();
    }
    
    
    
    public Image loadImage(String imageName)
    {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
        
    }

   

    
}