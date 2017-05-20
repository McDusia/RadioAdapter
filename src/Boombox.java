import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import javax.lang.model.type.NullType;

public class Boombox {

    private boolean power;
    private Mode mode;
    private Radio radio;
    private CD disc;
    private Tape tape;
    private MemoryCard memoryCard;


    public Boombox()
    {
        power = false;
        disc = null;
        tape = null;
        radio = new Radio();
        memoryCard = null;
    }

    public void on()
    {
        if(power)
            System.out.print("Error - Radio is already turned on.");
        else {
            System.out.print("Boombox is on.\n");
            mode = Mode.Wait;
            power = true;
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
        }else if(mode != Mode.CD)
            System.out.print("Error - wrong mode");
        else {
            System.out.print("Playing CD was stopped.");
            //todo is it necessary to null disc inside the Radio
            //disc = null;
            mode = Mode.Wait;
        }
    }


    public void nextSong()
    {
        if(mode != Mode.CD || !power)
            System.out.print("Error - You need to change to CD mode");
        else
            disc.nextSong();
    }

    public void playMemoryCard(MemoryCard givenCard)
    {
        if(!power){
            System.out.print("Power is off. I can't play music from memory card.");
        }else {
            if(memoryCard == null && givenCard == null ){
                System.out.print("I have no tape to play from.");
                return;
            }else if(givenCard != null){
                memoryCard = givenCard;
                }
            mode = Mode.MemoryCard;
            System.out.print("Reading memory card");
            System.out.print("Song title: " + memoryCard.getCurrentSong() + "\n\n");
        }
    }

    public void playTape(Tape givenTape)
    {
        if(!power) {
            System.out.print("Power is off. I can't play tape");
        }else {
            if(tape == null && givenTape == null){
                System.out.print("There is no tape to play.");
                return;
            }else if(givenTape!= null) {
                tape = givenTape;
                }
            mode = Mode.Tape;
            System.out.print("I am playing music from tape named:" + tape.getTitle() + "\n\n");
        }
    }

    public void playRadio()
    {
        if(!power){
            System.out.print("Power is off. I can't play Radio.");
        }else {
            mode = Mode.Radio;
            System.out.print("Playing the radio");
            System.out.print("Station: " + radio.getRadioProgram());
        }
    }


    public void changeRadioProgram(int nr){
        if(mode != Mode.Radio)
            System.out.print("Error - Radio is not in radio mode.");
        else {
            radio.changeProgram(nr);
            System.out.print("Radio station was changed." + radio.getRadioProgram());
        }
    }

    public void pause(){
        mode = Mode.Wait;
        System.out.print("Pause...");
    }
}
