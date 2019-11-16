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
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.api.StreamSpeechRecognizer;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author zubair
 */
public class Speech_TO_Text_French {

    /**
     * @param args the command line arguments
     */
    public static String Speech_TO_Text_French_Convertor(String Path) throws IOException {
        // TODO code application logic here
        Configuration configuration = new Configuration();
        String FinalResult="";

        configuration.setAcousticModelPath("fresource/edu/cmu/sphinx/models/fr-french/fr-french");
       configuration.setDictionaryPath("fresource/edu/cmu/sphinx/models/fr-french/fr.dict");
       configuration.setLanguageModelPath("fresource/edu/cmu/sphinx/models/fr-french/fr-small.lm.bin");

	StreamSpeechRecognizer recognizer = new StreamSpeechRecognizer(configuration);
       //File starting = new File(System.getProperty("user.dir"));
	InputStream stream = new FileInputStream(new File(Path));

       recognizer.startRecognition(stream);
	SpeechResult result;
        while ((result = recognizer.getResult()) != null) {
	    System.out.format("Hypothesis: %s\n", result.getHypothesis());
            FinalResult+=result.getHypothesis();
	}
        //System.out.println(result);
	recognizer.stopRecognition();
        return FinalResult;
    }
    
}
