import java.util.ArrayList;

public class Song {

    private String name;
    private String author;
    private ArrayList <Byte> sound;

    public void Song(String name, String author, ArrayList <Byte> sound)
    {
        this.name = name;
        this.author = author;
        this.sound = sound;
    }
    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public ArrayList <Byte> getSound()
    {
        return sound;
    }
}
