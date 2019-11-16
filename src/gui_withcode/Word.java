/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_withcode;

/**
 *
 * @author zubair
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

/**
 *
 * @author zubair
 */
public class Word {
    /**
    private XWPFDocument OpenWord(String Path) throws FileNotFoundException, IOException 
    {
    FileInputStream out = new FileInputStream( new File(Path));
    XWPFDocument docx = new XWPFDocument(out);
    return docx;
    }
    */
    //It creates a documant and return its reference
    private XWPFDocument CreateNewDocumant()
    {
    //Blank Document
      XWPFDocument document = new XWPFDocument();
      return document;
    }
    
    //Creating a new Page
    private  XWPFParagraph CreateNewParagraph(XWPFDocument document)
    {
     XWPFParagraph paragraph = document.createParagraph();
     return paragraph;
    }
    
    //Creating a new Paragrapgh
    private void  AddNewParagraph(XWPFDocument document,String text)
    {
       //create Paragraph
      XWPFParagraph paragraph =CreateNewParagraph(document);
      XWPFRun run = paragraph.createRun();
      run.setText(text);
    }
    
    //Save Document
    private void SaveandCloseDocument(XWPFDocument document, FileOutputStream out) throws IOException
    {
         document.write(out);
         out.close();
    }
    
    public String GetText(String Path) throws FileNotFoundException, IOException
    {
        
      XWPFDocument docx = new XWPFDocument(new FileInputStream(Path));
      //using XWPFWordExtractor Class
      XWPFWordExtractor we = new XWPFWordExtractor(docx);
      String text=we.getText();
     
      return text;
    }
    
    public void WriteOnDocumant(String Path,String input) throws FileNotFoundException, IOException
    {
        XWPFDocument document=CreateNewDocumant();
         FileOutputStream out = new FileOutputStream( new File(Path+".docx"));
        AddNewParagraph(document,input);
        this.SaveandCloseDocument(document, out);
        
    }
    
}

