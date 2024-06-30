//package lab10;


import java.awt.Button;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;




public class Animate extends JPanel implements ActionListener {

Timer t;

//Point array for drawing a star
private final double points[][] = {
{ 0+100, 85+100 }, { 75+100, 75+100 }, { 100+100, 10+100 }, { 125+100, 75+100 },
{ 200+100, 85+100 }, { 150+100, 125+100 }, { 160+100, 190+100 }, { 100+100, 150+100 },
{ 40+100, 190+100 }, { 50+100, 125+100 }, { 0+100, 85+100 }
};

//
//private final double x1Points[] = {0, 75, 100, 125,200,150,160,100,40,50,0};
//private final double y1Points[] = {85, 75, 10, 75,85,125,190,150,190,125,85};

//Variables to change size of the star
private double scale = 1;
private double delta = 0.01;

// Constructor
public Animate() 
{
     Panel panel=new Panel();
     panel.setBounds(0,0,600,30);
    
     
     panel.setBackground(Color.BLACK);
    Button button4=new Button("Set Default");//
     button4.setBounds(100,100,70,40);
     button4.setBackground(Color.WHITE);
     button4.addActionListener(this);
     
     Button button=new Button("Start Animation");//
     button.setBounds(100,100,70,40);
     button.setBackground(Color.WHITE);
     button.addActionListener(this);
     
     Button button1=new Button("Stop Animation");//
     button1.setBounds(100,100,70,40);
     button1.setBackground(Color.WHITE);
     button1.addActionListener(this);
     
     Button button2=new Button("Translate Right");//
     button2.setBounds(100,100,70,40);
     button2.setBackground(Color.WHITE);
     button2.addActionListener(this);
     
     Button button3=new Button("Comet Animation");//
     button3.setBounds(100,100,70,40);
     button3.setBackground(Color.WHITE);
     button3.addActionListener(this);
     
    
     
    panel.add(button4);  
    panel.add(button);
    panel.add(button1);
    panel.add(button2);
    panel.add(button3); 
    
     
    this.add(panel);
     this.setLayout(null);  

     
     
     t= new Timer(10,this);
     
     
     //      int   m_interval  = 10;  // Milliseconds between updates.
//       Timer m_timer = null; 
//       m_timer = new Timer(m_interval, new TimerAction());
////         
//   javax.swing.Timer t = new javax.swing.Timer(1000, new Animate());
//   t.start();
         
         //m_timer.start();
         
// create a timer, I used 10 for delay
// start timer
     
}
public void paint(Graphics g) {
    //int h=getHeight();
    //int w=getWidth();
     
     Graphics2D g2d = (Graphics2D) g;
    
     
     //g2d.translate(-150,-100);/////LAST EDIT
     
     Rectangle2D.Float r1 = new Rectangle2D.Float(400,400, 400, 400);
        GradientPaint g2 = new GradientPaint(400,400, Color.blue,200,200, Color.DARK_GRAY, false); 

        GeneralPath polygon=new GeneralPath();
        polygon.moveTo(points[0][0],  points[0][1]);
        
        
        for (int index = 0; index < points.length; index++) 
        {
                polygon.lineTo(points[index][0], points[index][1]);
        };
        
        
//      g2d.translate(w/2, h/2);
        
        g2d.scale(scale, scale);

        
        
//
//      System.out.print("Height is:" + h );
//      System.out.print( "Width is:" + w);
//      
        
        
//      GeneralPath polygon = 
//              new GeneralPath(GeneralPath.WIND_EVEN_ODD,
//                              x1Points.length);
//      polygon.moveTo(x1Points[0], y1Points[0]);

        

        
        
        
        
        r1.setRect(0, 0 , 600, 600);
        g2d.setPaint(g2); // Gradient color fill
        g2d.fill(r1); // Fill the rectangle
        //g2d.setPaint(Color.WHITE); // Outline in black
        g2d.draw(r1); // Fill the rectangle
//      polygon.closePath();
        polygon.closePath();
        g2d.setPaint(Color.YELLOW);
        g2d.fill(polygon);
        
        
        
//      g2D.draw(polygon);      
//      g2D.setColor(Color.yellow);
//      g2D.fill(polygon);
//      
        
     
// Create a rectangle background
// Fill it with gradient paint that you have used in previous labs
// Create a general path
// Instantiate the GeneralPath class
// Use lineTo() to initialize coordinate of the GeneralPath
// Connect all the coordinates of the star
// Scale star for animation
// Set color and fill star

}



public static void main(String[] args) {

        JFrame w = new JFrame("Star Animation");
       w.setBounds(600, 100, 600, 600);
        w.add(new Animate());
        //w.setSize(400, 400);
        w.setVisible(true);
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
                
        w.getContentPane().add(new Animate());
        
     // Initialize frame
// Set frame size to 400x400
// Set visibility
// Set default close operation

}






public void actionPerformed(ActionEvent evt) 
{       

     String command = evt.getActionCommand();

    if ("Exit".equals(command))
    {
   System.exit(0);
    }
     
      
      
    else if (command == "Start Animation")
    {
         
         //scale=scale+delta;
        
            t.start();
                        
    }
     
    else if (command == "Stop Animation")
        {
             
             
            
                t.stop();
                            
        }
     
    else if (command == "Translate Right")
        {
         points[0][0]=points[0][0]+20;
         points[1][0]=points[1][0]+20;
         points[2][0]=points[2][0]+20;
         points[3][0]=points[3][0]+20;
         points[4][0]=points[4][0]+20;
         points[5][0]=points[5][0]+20;
         points[6][0]=points[6][0]+20;
         points[7][0]=points[7][0]+20;
         points[8][0]=points[8][0]+20;
         points[9][0]=points[9][0]+20;
         points[10][0]=points[10][0]+20;
             
            
                
                    
        }

    
    else if (command == "Comet Animation")
        {
              
    
        t.start();
         
         points[0][0]=points[0][0]+30*14;
         points[1][0]=points[1][0]+30*14;
         points[2][0]=points[2][0]+30*14;
         points[3][0]=points[3][0]+30*14;
         points[4][0]=points[4][0]+30*14;
         points[5][0]=points[5][0]+30*14;
         points[6][0]=points[6][0]+30*14;
         points[7][0]=points[7][0]+30*14;
         points[8][0]=points[8][0]+30*14;
         points[9][0]=points[9][0]+30*14;
         points[10][0]=points[10][0]+30*14;
         
            
        
                repaint();
        
                
            
        
        }
     
    else if (command == "Set Default")
        {
         
        
         points[0][0]=100;       
         points[0][1]=185;
         
         points[1][0]=175;
         points[1][1]=175;
    
         points[2][0]=200;
         points[2][1]=110;
         
         points[3][0]=225;
         points[3][1]=175;
         
         points[4][0]=300;
         points[4][1]=185;
         
         points[5][0]=250;
         points[5][1]=225;
         
         points[6][0]=260;
         points[6][1]=290;
         
         points[7][0]=200;
         points[7][1]=250;
         
         points[8][0]=140;
         points[8][1]=290;
         
         points[9][0]=150;
         points[9][1]=225;
        
         points[10][0]=100;
         points[10][1]=185;
         
            
        
                //repaint();
        
                
            
        
        }
     
      if (scale<0.01) 
     {
        
         delta=-delta;
         
     }
     
     else if (scale>0.99) 
     {
         delta=-delta;
        
     }
     
     
      
      scale=scale+delta;
     
     repaint();
     
     
// Change the scale variable by using delta
// If scale < 0.01 or 0.99 < scale you can change the sign of delta
// So that it grows when it's small and shrinks when it's big
// Add delta to scale and repaint
}
}