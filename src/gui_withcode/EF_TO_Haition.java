/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_withcode;

import static gui_withcode.MainScreen.EF_TO_Haition;
import static gui_withcode.MainScreen.FromHaition_to_FE;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author zubair
 */


class BackgroundPanelFEH extends JPanel
{
  Image image;
  public BackgroundPanelFEH()
  {
    try
    {
      File pathToFile = new File("src/gui_withcode/HaitionToFrenchOrEnglish.jpg");
      image = ImageIO.read(pathToFile);
    }
    catch (Exception e) { e.printStackTrace();}
  }
 
  //@Override
 // protected void paintComponent(Graphics g)
 // {
 //   super.paintComponent(g); 
 //   if (image != null)
  //    g.drawImage(image, 0,0,300,200,this);
  //}
}
public class EF_TO_Haition {
    static JFrame f;
    static BackgroundPanelFEH panel;
    static JButton Open;
    static JButton Save;
    static JLabel SelectFile;
    static JList LanuageList;
    static JList OutPutFormatList;
    static String text="No Input";
    static String TranslatedText;
    
    public EF_TO_Haition()
    {
        
     f = new JFrame("From English or French to Haition  ");
     panel = new BackgroundPanelFEH();
     
         
         
         
     
     
     panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
     
     
      
    JLabel OutPutLanguageLabel= new JLabel("Select Input Language"); 
    OutPutLanguageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
     OutPutLanguageLabel.setForeground (Color.red);
     
     
     
       JLabel OutPutLabelFormat= new JLabel("Select OutPut Format"); 
   OutPutLabelFormat.setForeground (Color.red);
    OutPutLabelFormat.setBackground(new java.awt.Color(43,122,120));
   OutPutLabelFormat.setAlignmentX(Component.CENTER_ALIGNMENT);
    
        //String array to store weekdays 
    String Languages[]= { "English","French"}; 
    String OutPutFormat[]= { "PDF","DOCX","WAV"};       
        //create list 
     LanuageList= new JList(Languages); 
    LanuageList.setAlignmentX(Component.CENTER_ALIGNMENT);
    LanuageList.setSelectedIndex(0);
    Open=new JButton("Select input file which can be audio(.wav) or documant(.docx or .pdf)");
    Open.setAlignmentX(Component.CENTER_ALIGNMENT);
    Open.setBackground(new java.awt.Color(43,122,120));
    
    OutPutFormatList= new JList(OutPutFormat); 
    OutPutFormatList.setAlignmentX(Component.CENTER_ALIGNMENT);
    OutPutFormatList.setSelectedIndex(0);
    
    
    Save=new JButton("Translate and Save output file");
    Save.setAlignmentX(Component.CENTER_ALIGNMENT);
    Save.setBackground(new java.awt.Color(43,122,120));
    SelectFile=new JLabel();
    SelectFile.setAlignmentX(Component.CENTER_ALIGNMENT);
    
    
    
      Open.setActionCommand("Open");
      Save.setActionCommand("Save"); 
      Open.addActionListener(new ButtonClickListener()); 
      Save.addActionListener(new ButtonClickListener());   
      
      
   
        
      panel.add(Box.createRigidArea(new Dimension(0, 50)));
     panel.add(Open);
     panel.add(Box.createRigidArea(new Dimension(0, 50)));
     panel.add(OutPutLanguageLabel);
    panel.add(Box.createRigidArea(new Dimension(0, 50)));
     panel.add(LanuageList);
     panel.add(Box.createRigidArea(new Dimension(0, 50)));
     panel.add(OutPutLabelFormat);
     panel.add(Box.createRigidArea(new Dimension(0, 50)));
     panel.add(OutPutFormatList);
     panel.add(Box.createRigidArea(new Dimension(0, 50)));
     panel.add(Save);
     panel.add(Box.createRigidArea(new Dimension(0, 50)));
     
     //panel.add(SelectFile);
     //panel.add(Box.createRigidArea(new Dimension(0, 50)));
     panel.setBackground(new java.awt.Color(23,37,42));
     f.add(panel);
       
    
      f.pack();
      f.setVisible(true);
    }
    
    private static String fileExtension(String path) {
     
      if(path.lastIndexOf(".") != -1 && path.lastIndexOf(".") != 0)
         return path.substring(path.lastIndexOf(".") + 1);
      else
         return "";
   }
     static private void Translate() throws IOException
    {
         int InputLangaugeIndex=LanuageList.getSelectedIndex();
         String InputLanguage;
         if(InputLangaugeIndex==0)
         {
             InputLanguage="en";
         }
         else
         {
           InputLanguage="fr";  
         }
       TranslatedText= new TranslateAPI().translate(text,InputLanguage,"ht" );
       System.out.println(TranslatedText);
        System.out.println(TranslatedText);
        
    }
    static private void ConvertToOutPutAndSave(String path) throws IOException, Exception
    {
        //Saving to pdf
       if(OutPutFormatList.getSelectedIndex()==0)
       {
           Translate();
           PDF Pdfii=new PDF();
           Pdfii.WriteTextOnPdf(path,TranslatedText);
           
       }
       //Docx
       else if(OutPutFormatList.getSelectedIndex()==1)
       {
           Translate();
           Word Wordi=new Word();
           Wordi.WriteOnDocumant(path,TranslatedText);
           
       }
       //WAV FORMAT
       else
       {
          // Translate();
           // VoiceRRS_textToSpeech VRRS=new  VoiceRRS_textToSpeech();
           //System.out.println("Soubd");
          //VRRS.TextToSpeech(TranslatedText,path,LanuageList.getSelectedIndex());
       }
        
    }
   
   static  private void OpenFile() throws IOException
    {
        
      if(fileExtension(SelectFile.getText()).equals("pdf"))
      { 
          PDF Pdfii=new PDF();
          text=(Pdfii.GetTextFromPdf(SelectFile.getText()));
          text=URLEncoder.encode(text, StandardCharsets.UTF_8.toString());
          //Translate();
      }
      else if (fileExtension(SelectFile.getText()).equals("docx")){
        Word Wordi=new Word();
       text =Wordi.GetText(SelectFile.getText());
       System.out.println(text);
       text=URLEncoder.encode(text, StandardCharsets.UTF_8.toString());
       //Translate();
      }
      
       else if (fileExtension(SelectFile.getText()).equals("wav") || fileExtension(SelectFile.getText()).equals("mp3")){
       //System.out.println("Currenlty Haition sound is not supported");
       //JOptionPane.showMessageDialog(f, "Currenlty Haition sound is not supported");
           if( LanuageList.getSelectedIndex()==0)
           {
               text=Speech_TO_Text_English.Speech_TO_Text_Englis_Convertor(SelectFile.getText());
               
           }else{
               text= Speech_TO_Text_French.Speech_TO_Text_French_Convertor(SelectFile.getText());
           }
                  
      }
      else
       {
           System.out.println("Format not supported");
           JOptionPane.showMessageDialog(f, "Format not supported");
       }
    }
    
      private static class ButtonClickListener implements ActionListener{
      public void actionPerformed(ActionEvent e) {
         
         String command = e.getActionCommand();  
         
         if( command.equals( "Open" ))  {
             // create an object of JFileChooser class 
            JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 
             // invoke the showsOpenDialog function to show the save dialog 
            int r = j.showOpenDialog(null); 
            // if the user selects a file 
            if (r == JFileChooser.APPROVE_OPTION) 
             { // set the label to the path of the selected file 
                SelectFile.setText(j.getSelectedFile().getAbsolutePath()); 
                try {
                    OpenFile();
                } catch (IOException ex) {
                    Logger.getLogger(FromHaitionToEF.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
            // if the user cancelled the operation 
            else
                 SelectFile.setText("the user cancelled the operation"); 
         } else {
             // create an object of JFileChooser class 
            JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 
  
            // invoke the showsSaveDialog function to show the save dialog 
            int r = j.showSaveDialog(null); 
  
            // if the user selects a file 
            if (r == JFileChooser.APPROVE_OPTION) 
  
            { 
                // set the label to the path of the selected file 
                SelectFile.setText(j.getSelectedFile().getAbsolutePath()); 
                try {
                    ConvertToOutPutAndSave(j.getSelectedFile().getAbsolutePath());
                } catch (IOException ex) {
                    Logger.getLogger(FromHaitionToEF.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(FromHaitionToEF.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
            // if the user cancelled the operation 
            else
                 SelectFile.setText("the user cancelled the operation"); 
        } 
         }  	
      }		
   }
    

