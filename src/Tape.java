import java.util.List;

/**
 * Created by Madzia on 20.05.2017.
 */
public class Tape {
    private String title;
    private List<Song> songList;

    public void Tape(List <Song> songList)
    {
        this.songList = songList;
    }

    public String getTitle() {
        return title;
    }
    
    public List<Song> getSongList() {
        return songList;
    }
}
