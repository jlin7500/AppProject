package sample;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import javax.sound.midi.*;

public class Controller{

    public void main(String[] args)
    {
        try{
            /* Create a new Sythesizer and open it. Most of
             * the methods you will want to use to expand on this
             * example can be found in the Java documentation here:
             * https://docs.oracle.com/javase/7/docs/api/javax/sound/midi/Synthesizer.html
             */
            Synthesizer midiSynth = MidiSystem.getSynthesizer();
            midiSynth.open();

            //get and load default instrument and channel lists
            Instrument[] instr = midiSynth.getDefaultSoundbank().getInstruments();
            MidiChannel[] mChannels = midiSynth.getChannels();

            midiSynth.loadInstrument(instr[0]);//load an instrument

            int note = 45;

            mChannels[0].noteOn(note, 300);//On channel 0, play note number 60 with velocity 100
            try { Thread.sleep(1000); // wait time in milliseconds to control duration
            } catch( InterruptedException e ) { }
            mChannels[0].noteOff(note);//turn of the note


        } catch (MidiUnavailableException e) {}
    }

}