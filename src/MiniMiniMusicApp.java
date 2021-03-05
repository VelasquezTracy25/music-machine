import javax.sound.midi.*;

public class MiniMiniMusicApp {
    
    public static void main(String[] args){
        MiniMiniMusicApp mini = new MiniMiniMusicApp();
        mini.play();
    }

    
    
    public void play(){
        try{
            // Open a sequencer
            Sequencer player = MidiSystem.getSequencer();
            System.out.println("Start 'er up!");
            player.open();


            // Make a new sequence
            Sequence seq = new Sequence(Sequence.PPQ,4);

            //Create a new track from the sequence
            Track track = seq.createTrack();

            // Fill the track with MidiEvents and give the Sequence to the Sequencer
            ShortMessage a = new ShortMessage();
            a.setMessage(144, 1, 44, 100);
            MidiEvent noteOn = new MidiEvent(a, 1);
            track.add(noteOn);

            ShortMessage b = new ShortMessage();
            b.setMessage(128, 1, 44, 100);
            MidiEvent noteOff = new MidiEvent(b, 16);
            track.add(noteOff);

            player.setSequence(seq);

            //Start the sequencer
            player.start();
        } catch(Exception ex){
            ex.printStackTrace();        
        }
    }

}