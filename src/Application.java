import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        System.out.println("No to zaczynamy!");

        Boombox box = new Boombox();
        box.on();
        List <Song> songs;
        ArrayList<Byte> sound = new ArrayList<>();
        byte[] bytes = {69, 121, 101, 45, 62, 118, 101, 114, 61, 101, 98};

        for(byte b: bytes )
            sound.add(b);

        Song s1 = new Song("Wonderful World", "Louis Armstrong", sound);
        CD disc = new CD("Ed Sheran Album",new LinkedList<>());

        box.startPlayingCD(disc);
    }


}

