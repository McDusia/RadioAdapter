import javax.lang.model.type.NullType;

public class Boombox {

    private boolean power;
    private Mode mode;
    private Radio radio;
    private CD disc;
    private Tape tape;


    public void Boombox()
    {
        power = false;
        radio = new Radio();
    }

    public void on()
    {
        if(power)
            System.out.print("Error - Radio is turned on");
        else {
            mode = Mode.Wait;
            power = true;
            disc = null;
            tape = null;
        }
    }

    public void off()
    {
        power = false;
    }

    public void playCD(CD d)
    {
        if(!power)
            return;

        mode = Mode.CD;
        CD disc = d;
        System.out.print("Playing CD");
        System.out.print(disc.getTitle());

        disc.getCurrentSong();

        /*for(Song s : disc.getSongList()) {
            System.out.print(s.getName()+ "\n" + s.getAuthor());

            for(Byte b : s.getSound())
                System.out.print(b.toString());
        }*/
    }

    public void stopCD()
    {
        if(!power)
            return;
        if(mode != Mode.CD)
            System.out.print("Error - wrong mode");
        disc = null;
        mode = Mode.Wait;
    }

    public void nextSong()
    {
        if(mode != Mode.CD)
            System.out.print("Error - change to CD mode");
        disc.nextSong();
    }

    public void playMemoryCard(MemoryCard card)
    {
        if(!power)
            return;

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
        if(!power)
            return;
        mode = Mode.Tape;

    }

    public void playRadio()
    {
        if(!power)
            return;
        mode = Mode.Radio;
        System.out.print("Playing the radio");
        System.out.print("Station: " + radio.getRadioProgram());
    }


    public void changeRadioProgram(int nr){
        if(mode != Mode.Radio)
            System.out.print("Error - Radio is not in radio mode.");
        radio.changeProgram(nr);
    }

    public void pause(){
        mode = Mode.Wait;
        System.out.print("Pause...");
    }
}
