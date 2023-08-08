import java.util.*;
public class Album {
    private String albumName;
    private String artistName;

    private List<Song>songsList;


    public Album(String albumName, String artistName) {
        this.albumName = albumName;
        this.artistName = artistName;
        songsList = new ArrayList<>();
    }

    public boolean findSongByTitle(String title)
    {
      for(Song s:songsList)
      {
          if(s.getTitle().equals(title)) return true;

      }
      return false;
    }

    public String addNewSongToAlbum(String title,double duration)
    {
        if(findSongByTitle(title)) return "Already Present";
        songsList.add(new Song(title,duration));
        return "Song Added to the Album Successfully";
    }

    public String addSongToPlayList(int songNo, ArrayList<Song>playList)
    {
        //songNo-> 1 2 3 4 5
        //songlist is zero based-> 0 1 2 3 4

        int index = songNo-1;
        if(index >=0 && index<= songsList.size())
        {
            Song song = songsList.get(index);

            if(playList.contains(song))
            {
                return "already present";
            }
            else {
                playList.add(song);
                return "song has been added to the playlist successfully";
            }
        }
        else
        {
            return "Song No is out of Range";
        }
    }
}
