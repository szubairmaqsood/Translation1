/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  gui_withcode;
import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.text.PDFTextStripper;

/**
 *
 * @author zubair
 */
public class PDF {
    
    //This documant load file on given path and return its pointer
    private PDDocument OpenPdf(String Path) throws IOException
    {
        File file = new File(Path);
        PDDocument document = PDDocument.load(file);
        return document;
    }
    //Creatin new Documant
    private PDDocument CreateNewDocumant()
    {
        PDDocument document = new PDDocument();  
        return document;
    }
    //Creating a new Page
    private PDPage CreateNewPage()
    {
     PDPage my_page = new PDPage();
     return my_page;
    }
    //Adding Page to Document
    private void AddPageToPdf(PDDocument document, PDPage my_page)
    {
        document.addPage(my_page);
    }
    //Save Document
    private void SaveDocument(PDDocument document,String Path) throws IOException
    {
          document.save(Path+".pdf");
    }
    
    private void ClosePdf( PDDocument document) throws IOException
    {
        //Closing the document
        document.close();
    }
    
    //This method get text from pdf
    public String GetTextFromPdf( String path) throws IOException
    {
        File file = new File(path); 
        PDDocument document = new PDDocument();
        document = PDDocument.load(file);
        //Instantiate PDFTextStripper class
      PDFTextStripper pdfStripper = new PDFTextStripper();
      //Retrieving text from PDF document
      String text = pdfStripper.getText(document);
      document.close();
      return text;
     
    }
    
    public void WriteTextOnPdf(String path,String text) throws IOException
    {
        PDDocument document=this.CreateNewDocumant();
         //Retrieving the pages of the document
       PDPage mypage =this.CreateNewPage();
       this.AddPageToPdf(document, mypage);
       document.save(path+".pdf");
      // document.close();
        
      PDPage page = document.getPage(0);
      PDPageContentStream contentStream = new PDPageContentStream(document, page);
      
      //Begin the Content stream 
      contentStream.beginText(); 
       
      //Setting the font to the Content stream  
      contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);

      //Setting the position for the line 
      contentStream.newLineAtOffset(25, 500);

      //String text = "This is the sample document and we are adding content to it.";

      //Adding text in the form of string 
      contentStream.showText(text);      

      //Ending the content stream
      contentStream.endText();

      System.out.println("Content added");

      //Closing the content stream
      contentStream.close();
      document.save(new File(path+".pdf"));
      document.close();
    }
}


