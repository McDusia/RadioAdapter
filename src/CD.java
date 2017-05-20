import java.util.List;

public class CD {
    private String title;
    private List<Song> songList;

    public void CD(String title, List <Song> songList)
    {
        this.title = title;
        this.songList = songList;
    }

    public String getTitle() {
        return title;
    }

    public List<Song> getSongList() {
        return songList;
    }

}
