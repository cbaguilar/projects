package christian;

import java.awt.Dimension;
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
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

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
      Long total = (Long) names.get("_total");
      System.out.println(total+" Followers");
      for (int i = 0; i < 20; i++)
      {
    	System.out.println(i);
        JSONObject follower = (JSONObject)list.get(i);
        JSONObject user = (JSONObject)follower.get("user");
        String name = (String)user.get("name");
        System.out.println(name);
        
        JSONObject _links = (JSONObject)user.get("_links");
        String logo = (String)user.get("logo");
        String bio = (String)_links.get("bio");
        
        System.out.println(_links);
        
        System.out.println(logo);
        
        JTextPane info = new JTextPane();
        info.setContentType("text/html");
        info.setText("<html> <table> <tr> <td width='100'><p><img src="+logo+" width = 50 height = 50></td></tr></table></html>");
        
        content.add(new JLabel(name));
        content.add(info);
      }
    }
    catch (ParseException pe)
    {
      System.out.println("position: " + pe);
      System.out.println(pe);
    }
    JScrollPane scroll = new JScrollPane(content);
    scroll.setPreferredSize(new Dimension(200,500));
   
    
    this.window.add(scroll);
    
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
      oracle = new URL("https://api.twitch.tv/kraken/channels/XeonSerendipity/follows/?limit=20");
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
