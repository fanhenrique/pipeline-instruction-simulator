import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.lang.IllegalArgumentException;

public class Leitor{

	private FileReader file;
	private BufferedReader bFile;
	private ArrayList <Instrucao> instrucoes;

	public Leitor(String file) throws FileNotFoundException, IOException{

		this.file = new FileReader(new File(file));
		this.bFile = new BufferedReader(this.file);
		this.instrucoes = new ArrayList <Instrucao>();
	}

	public void le() throws IOException{
			
		String input = null;

		String[] linha = null;

		do{
			input = this.bFile.readLine();

			if(input == null){
				break;
			}

			linha = input.split(" ");

			if(!linha[1].equals("lw") && !linha[1].equals("sw")){

				Instrucao ins = new Instrucao(new Registrador(linha[2]), new Registrador(linha[3]), new Registrador(linha[4]), linha[1], linha[0]);	

				this.instrucoes.add(ins);
			}else{

				Instrucao ins = new Instrucao(new Registrador(linha[2]), new Registrador(linha[3]), linha[1], linha[0]); 

				this.instrucoes.add(ins);
			}

		}while(linha != null);
	}

	public ArrayList <Instrucao> getInstrucoes(){
		return this.instrucoes;
	}
}