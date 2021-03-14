import java.util.ArrayList;
import java.util.Scanner;

class Pipeline
{
	private ArrayList <String> bi;
	private ArrayList <String> di;
	private ArrayList <String> ex;
	private ArrayList <String> mem;

	public Pipeline()
	{
		this.bi = new ArrayList <String> ();
		this.di = new ArrayList <String> ();
		this.ex = new ArrayList <String> ();
		this.mem = new ArrayList <String> ();
	}

	public boolean igual(String a, String b)
	{
		if(a.equals(b)) return true;
		else return false;
	}

	public void ordenaPipeline(ArrayList <Instrucao> inst)
	{
		int bolha = 0;
		Instrucao aux1 = new Instrucao();
		Instrucao aux2 = new Instrucao();
		Instrucao ula = new Instrucao();

		for(int i=0; i < inst.size(); i++)
		{
			Instrucao aux = inst.get(i);

			if(i < 3 && i >= 0)
			{
				if(i == 0)
				{
					bi.add(aux.getNome());
					di.add("  ");
					ex.add("  ");
					mem.add("  ");

					aux1 = aux;
				}
				
				else if(i == 1)
				{
					bi.add(aux.getNome());
					di.add(aux1.getNome());
					ex.add("  ");
					mem.add("  ");

					aux2 = aux1;
					aux1 = aux;
				}

				else if(i == 2)
				{
					bi.add(aux.getNome());
					di.add(aux1.getNome());
					ex.add(aux2.getNome());
					mem.add("  ");

					ula = aux2;
					aux2 = aux1;
					aux1 = aux;
				}
			}

			else
			{

				if((igual(aux2.getOp1().getNome(), ula.getR().getNome()) || igual(aux2.getOp2().getNome(), ula.getR().getNome())) && bolha == 0)
				{
					bi.add(aux1.getNome());
					di.add(aux2.getNome());
					ex.add("Bolha");
					mem.add(ula.getNome());

					i--;
					bolha = 3;
				}
				
				else if((!igual(aux2.getOp1().getNome(), ula.getR().getNome()) || !igual(aux2.getOp2().getNome(), ula.getR().getNome())) && bolha == 0)
				{
					bi.add(aux.getNome());
					di.add(aux1.getNome());
					ex.add(aux2.getNome());
					mem.add(ula.getNome());

					ula = aux2;
					aux2 = aux1;
					aux1 = aux;

					bolha = 0;
				}

				else if(bolha == 3)
				{
					bi.add(aux.getNome());
					di.add(aux1.getNome());
					ex.add(aux2.getNome());
					mem.add("Bolha");

					ula = aux2;
					aux2 = aux1;
					aux1 = aux;
					bolha = 4;
				}

				else if((igual(aux2.getOp1().getNome(), ula.getR().getNome()) || igual(aux2.getOp2().getNome(), ula.getR().getNome())) && bolha == 4)
				{	
					bi.add(aux1.getNome());
					di.add(aux2.getNome());
					ex.add("Bolha");
					mem.add(ula.getNome());

					i--;
					bolha = 3;

				}

				else
				{
					bi.add(aux.getNome());
					di.add(aux1.getNome());
					ex.add(aux2.getNome());
					mem.add(ula.getNome());

					ula = aux2;
					aux2 = aux1;
					aux1 = aux;

					bolha = 0;
				}
			}
		}

		for(int i=0; i<4 ; i++)
		{
				if(i == 0)
				{
					bi.add("  ");
					di.add(aux1.getNome());
					ex.add(aux2.getNome());
					mem.add(ula.getNome());
				}
				
				else if(i == 1)
				{
					bi.add("  ");
					di.add("  ");
					ex.add(aux1.getNome());
					mem.add(aux2.getNome());
				}

				else if(i == 2)
				{
					bi.add("  ");
					di.add("  ");
					ex.add("  ");
					mem.add(aux1.getNome());
				}
				else
				{
					bi.add("  ");
					di.add("  ");
					ex.add("  ");
					mem.add("  ");
				}
		}
	}

	public ArrayList <String> getBi()
	{
		return this.bi;
	}

	public ArrayList <String> getDi()
	{
		return this.di;
	}

	public ArrayList <String> getEx()
	{
		return this.ex;
	}

	public ArrayList <String> getMem()
	{
		return this.mem;
	}
}