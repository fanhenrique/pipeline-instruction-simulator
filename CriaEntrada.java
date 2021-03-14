import java.io.FileWriter;
import java.io.File;
import java.io.BufferedWriter;
import java.util.Random;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CriaEntrada{
	
	public static void main(String[] args) throws FileNotFoundException, IOException{

		FileWriter file = new FileWriter(new File("entrada.txt"));
		BufferedWriter bFile = new BufferedWriter(file);

		Random r = new Random();

		for(int i = 0; i < 50; i++){

			int ins = r.nextInt(2);

			if(ins == 0){
				int op = r.nextInt(4);
				String o = null;

				switch(op){
					case 0:
						o = "and";
						break;
					case 1:
						o = "or";
						break;
					case 2:
						o = "add";
						break;
					case 3:
						o = "sub";
						break;
				} 


				bFile.write("I"+i+" "+o+" R"+r.nextInt(10)+" R"+r.nextInt(10)+" R"+r.nextInt(10)+"\n");
			}else{

				int op = r.nextInt(2);
				String o = null;

				switch(op){
					case 0:
						o = "lw";
						break;
					case 1:
						o = "sw";
						break;
				} 

				bFile.write("I"+i+" "+o+" R"+r.nextInt(10)+" R"+r.nextInt(10)+"\n");

			}

		}

			
		bFile.close();
		file.close();		


	}
}