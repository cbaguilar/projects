package manFortress;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Console;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;


//Class for saving and writing to files and whatnot.


public class FileIO {

	public FileIO() {
		int[] intArr = null;
		char[] charArr = null;
		
		
		// Set up arrs and stuff. Should i make  them it static?
		
	}
	
	public static void writeIntToFile(DataOutput dout, int arr[]) throws IOException{
		dout.writeInt(arr.length);
		for(int a : arr) dout.writeInt(a);
		
	}
	
	public static int[] readIntFromFile(DataInputStream din) throws IOException{
		int arr[] = new int[din.readInt()];
		for(int i=0;i<arr.length;i++)
			arr[i] = din.readInt();
		return arr;
	}
	
	public static DataOutputStream GetOutputStreams(String fileLoc) throws IOException{
		FileOutputStream fos = new FileOutputStream(fileLoc);
		BufferedOutputStream buff = new BufferedOutputStream(fos);
		DataOutputStream dout = new DataOutputStream(buff);
		
		return dout;
		
		
	}

	public static DataInputStream GetInputStreams(String fileLoc) throws IOException{
		FileInputStream fos = new FileInputStream(fileLoc);
		BufferedInputStream buff = new BufferedInputStream(fos);
		DataInputStream din = new DataInputStream(buff);
		
		return din;
		
		
	}
}
