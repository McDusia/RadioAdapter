import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import javax.lang.model.type.NullType;

public class Boombox {

    private boolean power;
    private Mode mode;
    private Radio radio;
    private CD disc;
    private Tape tape;


    public Boombox()
    {
        power = false;
        //radio = new Radio();
    }

    public void on()
    {
        if(power)
            System.out.print("Error - Radio is already turned on.");
        else {
            System.out.print("Boombox is on.\n");
            mode = Mode.Wait;
            power = true;
            disc = null;
            tape = null;
            radio = new Radio();
        }
    }

    public void off()
    {
        if(!power)
            System.out.print("Error - Radio is already turned off.");
        else {
            power = false;
            System.out.print("Power is off.");
        }
    }

    public void startPlayingCD(CD d)
    {
        if(!power){
            System.out.print("Power is off. I can't play CD.");
            return;
        }

        mode = Mode.CD;
        disc = d;
        System.out.print("CD title: " + disc.getTitle()+ "\n");
        System.out.print("Song title: " + disc.getCurrentSong() + "\n\n");
    }

    public void stopPlayingCD()
    {
        if(!power){
            System.out.print("Power is off.");
            return;
        }else if(mode != Mode.CD)
            System.out.print("Error - wrong mode");

        System.out.print("Playing CD was stopped.");
        disc = null;
        mode = Mode.Wait;
    }


    public void nextSong()
    {
        if(mode != Mode.CD)
            System.out.print("Error - You need to change to CD mode");
        else
            disc.nextSong();
    }

    public void playMemoryCard(MemoryCard card)
    {
        if(!power){
            System.out.print("Power is off. I can't play music from memory card.");
            return;
        }

        mode = Mode.MemoryCard;
        System.out.print("Reading memory card");
        System.out.print("Card reading failure");
        //??
        for(Song s : card.getSongList()) {
            System.out.print(s.getName()+ "\n" + s.getAuthor());

            for(Byte b : s.getSound())
                System.out.print(b.toString());
        }
    }

    public void playTape()
    {
        if(!power){
            System.out.print("Power is off. I can't play tape");
            return;}
        mode = Mode.Tape;

    }

    public void playRadio()
    {
        if(!power){
            System.out.print("Power is off. I can't play Radio.");
            return;}
        mode = Mode.Radio;
        System.out.print("Playing the radio");
        System.out.print("Station: " + radio.getRadioProgram());
    }


    public void changeRadioProgram(int nr){
        if(mode != Mode.Radio)
            System.out.print("Error - Radio is not in radio mode.");
        radio.changeProgram(nr);
        System.out.print("Radio station was changed.");
    }

    public void pause(){
        mode = Mode.Wait;
        System.out.print("Pause...");
    }
}
