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
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.api.StreamSpeechRecognizer;
import java.io.FileNotFoundException;
import java.io.IOException;


 


public class Speech_TO_Text_English {


  
     public static String Speech_TO_Text_Englis_Convertor(String Path) throws FileNotFoundException, IOException {
       Configuration configuration = new Configuration();
       String FinalResult="";

       configuration.setAcousticModelPath("resource/edu/cmu/sphinx/models/en-us/en-us");
       configuration.setDictionaryPath("resource/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
       configuration.setLanguageModelPath("resource/edu/cmu/sphinx/models/en-us/en-us.lm.bin");

       StreamSpeechRecognizer recognizer = new StreamSpeechRecognizer(configuration);
       //File starting = new File(System.getProperty("user.dir"));
	InputStream stream = new FileInputStream(new File(Path));

       recognizer.startRecognition(stream);
	SpeechResult result;
        while ((result = recognizer.getResult()) != null) {
	    //System.out.format("Hypothesis: %s\n", result.getHypothesis());
           FinalResult = FinalResult+result.getHypothesis();
	}
        //System.out.println(result);
	recognizer.stopRecognition();
        return  FinalResult;
    }
}