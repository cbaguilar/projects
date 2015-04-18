package christian;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main
{
  JPanel window;
  Main parent;
  
  Main()
  {
    this.window = new JPanel();
    JPanel content = new JPanel();
    
    BoxLayout box = new BoxLayout(content, 1);
    content.setLayout(box);
    
    String json = "null";
    try
    {
      json = getFollowers();
    }
    catch (IOException a)
    {
      System.out.println("IO Error: " + a);
    }
    System.out.println(json);
    JSONParser parser = new JSONParser();
    String s = "[0,{\"1\":{\"2\":{\"3\":{\"4\":[5,{\"6\":7}]}}}}]";
    try
    {
      Object obj = parser.parse(json);
      JSONObject names = (JSONObject)obj;
      
      JSONArray list = (JSONArray)names.get("follows");
      for (int i = 1; i < 20; i++)
      {
        JSONObject follower = (JSONObject)list.get(i);
        JSONObject user = (JSONObject)follower.get("user");
        String name = (String)user.get("name");
        System.out.println(name);
        content.add(new JLabel(name));
      }
    }
    catch (ParseException pe)
    {
      System.out.println("position: " + pe);
      System.out.println(pe);
    }
    this.window.add(content);
    
    JFrame frame = new JFrame("Twitch Buff, Buffing out your twitch experience!");
    frame.setContentPane(this.window);
    
    frame.pack();
    
    frame.setVisible(true);
  }
  
  public static void main(String[] args)
    throws IOException
  {
    Main main = new Main();
  }
  
  public String getFollowers() throws IOException
  {
    URL oracle = null;
    String json = "";
    try
    {
      oracle = new URL("https://api.twitch.tv/kraken/channels/XeonSerendipity/follows/?limit=100");
    }
    catch (MalformedURLException e)
    {
      System.out.println("Couldn't get URL" + e);
    }
    BufferedReader in = new BufferedReader(
      new InputStreamReader(oracle.openStream()));
    String inputLine;
    while ((inputLine = in.readLine()) != null)
    {
      //String inputLiine;
      json = json + inputLine;
    }
    in.close();
    return json;
  }
}
