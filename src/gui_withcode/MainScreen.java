/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_withcode;
import javax.swing.*;  
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 *
 * @author zubair
 */
class BackgroundPanel extends JPanel
{
  Image image;
  public BackgroundPanel()
  {
    try
    {
      File pathToFile = new File("src/gui_withcode/SplashScreenImage.jpg");
      image = ImageIO.read(pathToFile);
    }
    catch (Exception e) { e.printStackTrace();}
  }
 
  //@Override
  //protected void paintComponent(Graphics g)
 /// {
 //   super.paintComponent(g); 
 //   if (image != null)
  //    g.drawImage(image, 0,0,this.getWidth(),300,this);
 // }
}


public class MainScreen {

    /**
     * @param args the command line arguments
     */
    static  JFrame f;
    static BackgroundPanel  panel;
    //static Image img = Toolkit.getDefaultToolkit().getImage("SplashScreenImage.jpg");
   static ImageIcon img = new ImageIcon("SplashScreenImage1.jpg");
    static JButton EF_TO_Haition, FromHaition_to_FE, Button3;
    static JLabel MainScreenMessage;
    public static void MainScreenWroking() throws InterruptedException {
        // TODO code application logic here
                    f = new JFrame("Main Screen");
                    f.getContentPane().setLayout(new FlowLayout());
                    
                    panel=new BackgroundPanel () ;
                    panel.setPreferredSize(new Dimension(800, 800));
                    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                  
                    MainScreenMessage=new JLabel("Multilingual Translation");
                    MainScreenMessage.setFont(new Font("Serif", Font.ITALIC, 30));
                    MainScreenMessage.setForeground (Color.red);
                            
		    EF_TO_Haition = new JButton("From English or French to Haiton Cerole");
                    EF_TO_Haition.setBackground(new java.awt.Color(43,122,120));
                    // EF_TO_Haition.setIcon(img);
                    FromHaition_to_FE = new JButton("From Haition Cerole to English or French");
                     FromHaition_to_FE.setBackground(new java.awt.Color(43,122,120));
                    
		    EF_TO_Haition.setActionCommand("EFH");
                    FromHaition_to_FE.setActionCommand("HEF");
                    
                    EF_TO_Haition.addActionListener(new ButtonClickListener()); 
                    FromHaition_to_FE .addActionListener(new ButtonClickListener()); 
                    
                   // EF_TO_Haition .setSize(new Dimension(200, 200));
                 //   FromHaition_to_FE.setSize(new Dimension(200, 200));
                    
                     
                    //EF_TO_Haition .setBorder(new LineBorder(Color.RED));
                   // FromHaition_to_FE.setBorder(new LineBorder(Color.RED));
                      
                    EF_TO_Haition.setToolTipText("English or French to Haition");
                    FromHaition_to_FE.setToolTipText("From Haition to Frennch or English");
                   
                     panel.add(MainScreenMessage);
                      panel.add(Box.createRigidArea(new Dimension(100, 100)));
		   //panel.add(Box.createRigidArea(new Dimension(0, 100)));
                   EF_TO_Haition.setAlignmentX(Component.CENTER_ALIGNMENT);
                   panel.add(EF_TO_Haition);
                   
                   panel.add(Box.createRigidArea(new Dimension(100, 100)));
		  panel.setBackground(new java.awt.Color(23,37,42));
                  FromHaition_to_FE.setAlignmentX(Component.CENTER_ALIGNMENT);
                  panel.add(FromHaition_to_FE);
                 // panel.setBackground(new java.awt.Color(23,37,42)); 
                  
                   f.setBackground(new java.awt.Color(23,37,42)); 
                   f.getContentPane().add(panel);
		   f.pack();
                   f.setSize(800, 800);
		   f.setVisible(true);
       
   
    }
    
     private static class ButtonClickListener implements ActionListener{
      public void actionPerformed(ActionEvent e) {
          
         String command = e.getActionCommand();  
         
         if( command.equals( "HEF" ))  {
          
           FromHaitionToEF HEF=new FromHaitionToEF();
           f.dispose();
         } else {
            EF_TO_Haition EFH=new EF_TO_Haition();
           f.dispose();
               
            //FromHaitionToEF =new FromHaitionToEF();
         }  	
      }		
   }
     
     public static void main(String[] args) throws InterruptedException {
          MainScreenWroking();
          
		
                 
     }
    
}
