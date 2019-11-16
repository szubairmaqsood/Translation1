/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_withcode;

import com.voicerss.tts.AudioCodec;
import com.voicerss.tts.AudioFormat;
import com.voicerss.tts.Languages;
import com.voicerss.tts.VoiceParameters;
import com.voicerss.tts.VoiceProvider;
import java.io.FileOutputStream;

/**
 *
 * @author zubair
 */
//This is module from french text to speech
public class VoiceRRS_textToSpeech {

    public void TextToSpeech(String Input,String Path,int Language) throws Exception
    {
        
        VoiceProvider tts = new VoiceProvider("33907c438dc24b06a63021eb08977276");
	VoiceParameters params;	
       // VoiceParameters params = new VoiceParameters(Input, Languages.French_France);
        
       if(Language==0)
       {
            params = new VoiceParameters(Input, Languages.English_UnitedStates);
           
       }
       
       else
       {
           params = new VoiceParameters(Input, Languages.French_France);
           
       }
        
        params.setCodec(AudioCodec.WAV);
        params.setFormat(AudioFormat.Format_44KHZ.AF_44khz_16bit_stereo);
        params.setBase64(false);
        params.setSSML(false);
        params.setRate(0);
		
        byte[] voice = tts.speech(params);
		
        FileOutputStream fos = new FileOutputStream(Path+".wav");
        fos.write(voice, 0, voice.length);
        fos.flush();
        fos.close();
        
    }
    /**
     * @param args the command line arguments
     */
    
   // public static void main(String[] args) throws Exception {
        // TODO code application logic here
       // VoiceRRS_textToSpeech TT=new VoiceRRS_textToSpeech();
        //TT.TextToSpeech("Haïti n'est-elle pas une nation comme toutes les autres nations?");
   // }
    
}
