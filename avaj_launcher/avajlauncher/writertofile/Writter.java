package avajlauncher.writertofile;

import java.io.*;
import avajlauncher.towers.*;
import avajlauncher.air.*;
import avajlauncher.simulator.*;


public class Writter {

	public void	writetofile(String str) {
		try
		{
			File file = new File("simulation.txt");


		 BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
    writer.append("\n");
    writer.append(str);
		writer.close();
		}
		catch (IOException e)
		{
			System.out.println(e.toString());
		}

	}


}
