/*package com.christian;
//import java.io.*;  
//import java.net.*;  

import java.io.*;  
import java.net.*;  
public class Networking {  
	private static byte[] intToByteArray(int value) 
	{ return new byte[] { 
	 (byte)(value >>> 24), (byte)(value >> 16 & 0xff), 
	 (byte)(value >> 8 & 0xff), (byte)(value & 0xff) }; 
	}
	
	
	DataOutputStream out;
	Socket client;
	BufferedReader inFromUser;
	
    Networking(String address,int port) throws UnknownHostException, IOException{  
        String sentence;  
        byte[] length;
        //String modifiedSentence;  
        //Create a standard input stream  
        inFromUser=new BufferedReader(new InputStreamReader(System.in));  
        //Create a client socket and connect to the server  
        client=new Socket(address,port );  
        //Create output Stream attached to socket  
        out=new DataOutputStream(client.getOutputStream());  
        //Create input stream and attached it to socket  
        //BufferedReader inFromServer=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));  
        //Read text from user  
        sentence=inFromUser.readLine();  
        //Send line to server  
        length = intToByteArray( sentence.length() );
        System.out.println(length+sentence);

   
       
        //Read a modified sentence from the user 
        
        //modifiedSentence=inFromServer.readLine();  
        //System.out.println("FROM SERVER"+modifiedSentence);  
        client.close();  
  
  
  
    }  
    
    public void send(String data) throws IOException{
        try { // write message size, then the message 
            byte[] sizeBytes = intToByteArray( sentence.length() ); 
            for (int i = 0; i < 4; i++)
            {
            outToServer.write(sizeBytes[i]); 
            System.out.println(sizeBytes[i]);
            }
            outToServer.write(sentence.getBytes()); 
           
            } 
            catch (IOException e) { 
            System.err.println("Couldn't send: " + sentence); 
             
            }
 
	   
   }
  
} */