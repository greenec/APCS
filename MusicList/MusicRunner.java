import java.util.*;

public class MusicRunner
{
  public static void main (String[] args)
  {
    ArrayList<Song> songs = new ArrayList<Song>();
    int count = 0;
    MusicReader mr = new MusicReader();
    
    mr.open("musiclist.csv");
    
    String[] data = mr.getSongData();
    
    // First line contains all the fields - We don't want to save this anywhere but we can
    // print it for now to see what information we have.
    System.out.println(Arrays.toString(data));
    
    data = mr.getSongData();  // Get next line of song data
    
    // if data is null then we were unable to read a line of song data, so
    // this loop will continue to read lines of song data as long as there
    // IS song data available
    while (data != null)
    {
      // You probably will comment this out but for now print out the line so you can see what is there
      System.out.println(Arrays.toString(data));
      
      // Let's ty to create a Song object
      int songCount = 0;
      while(songCount > 9);
      {
        data = mr.getSongData();
        Song song = new Song(data[0], data[1], Integer.parseInt(data[3]), Double.parseDouble(data[4]), data[16]);  // data[0] is the artist and data[1] is the name
        songs.add(song);
        songCount++;
      }
      count++;
      
      if (count == 1)  // For now only read ONE song
        break;
      
      //data = mr.getSongData();  // Get next line of song data
    }
    
    mr.close();
  }
}