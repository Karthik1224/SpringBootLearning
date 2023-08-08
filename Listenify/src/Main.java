import java.sql.SQLOutput;
import java.util.*;
public class Main {
    public static void main(String[] args) {

        Album a1 = new Album("Best Telugu Songs","M.M Keeravani");
        a1.addNewSongToAlbum("Yevvadanta yevvadanta",4.30);
        a1.addNewSongToAlbum("Pacha bottesina",4.50);

        Album a2 = new Album("Latest Hindi Songs","Arjit Singh");
        a2.addNewSongToAlbum("Kesariya",3.50);
        a2.addNewSongToAlbum("apna bana le piya",4.30);
        a2.addNewSongToAlbum("Deva Deva",4.40);

        ArrayList<Song>playList = new ArrayList<>();
        a1.addSongToPlayList(2,playList);
        a2.addSongToPlayList(1,playList);
        a2.addSongToPlayList(3,playList);
        a2.addSongToPlayList(2,playList);

        play(playList);
    }
    public static void play(ArrayList<Song>playList)
    {
           menu();
        System.out.println("Now Playing :");
          int cuurentIndex = 0;
           System.out.println(playList.get(cuurentIndex).toString());
           Scanner sc = new Scanner(System.in);
           int choice = sc.nextInt();



           boolean isOver = false;
           while(isOver==false)
           {
               switch (choice)
               {
                   case 1:
                       if(cuurentIndex == playList.size()-1)
                       {
                           System.out.println("You are at the last song");
                       }
                       else
                       {
                           cuurentIndex++;
                           System.out.println(playList.get(cuurentIndex).toString());
                       }
                       break;


                   case 2:
                       if(cuurentIndex==0)
                       {
                           System.out.println("You are at the fisrt song");
                       }
                       else
                       {
                           cuurentIndex--;
                           System.out.println(playList.get(cuurentIndex).toString());
                       }
                       break;

                   case 3:
                       System.out.println(playList.get(cuurentIndex).toString());
                       break;

                   case 4:
                       menu();
                       break;

                   case 5:
                       playlist(playList);
                       break;

                   case 6:
                       deleteSong(cuurentIndex,playList);
                       break;
                   case 7:
                       isOver=true;
                       break;


               }
               choice = sc.nextInt();
           }
    }
    public static void menu()
    {
        System.out.println("Enter Your choice");
        System.out.println("1. Go to Next song");
        System.out.println("2. Go to previous song");
        System.out.println("3. Repeat the song");
        System.out.println("4. Print choice menu");
        System.out.println("5. Print playlist");
        System.out.println("6. Delete Current song");
        System.out.println("7. Close the playlist");
    }

    public static void playlist(ArrayList<Song>playList)
    {
         for(Song s:playList)
         {
             System.out.println(s.toString());
         }
    }
    public static void deleteSong(int index,ArrayList<Song>playList)
    {
        System.out.println("Removed Song :"+playList.get(index).toString()+playList.remove(playList.get(index)));
    }
}