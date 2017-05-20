import java.util.List;

public class MemoryCard {

    private List<Song> songList;

    public void MemoryCard(List <Song> songList)
    {
        this.songList = songList;
    }

    public List<Song> getSongList() {
        return songList;
    }

}
