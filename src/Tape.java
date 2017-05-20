import java.util.Map;

public class Tape {
    private String title;
    private Map<Song,Integer> songList;

    public Tape(String title, Map<Song, Integer> songList) {
        this.title = title;
        this.songList = songList;
    }

    public Map<Song, Integer> getSongList() {
        return songList;
    }


    public String getTitle() {
        return title;
    }


}
