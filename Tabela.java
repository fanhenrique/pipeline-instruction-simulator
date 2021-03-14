import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class Tabela extends AbstractTableModel{

	private final ArrayList<String> b;
	private final ArrayList<String> d;
	private final ArrayList<String> e;
	private final ArrayList<String> m;
	
	public Tabela(ArrayList<String> b, ArrayList<String> d, ArrayList<String> e, ArrayList<String> m){
		this.b = b;
		this.d = d;
		this.e = e;
		this.m = m;
	}

	@Override
	public int getColumnCount(){
		return 4;
	}

	@Override
	public int getRowCount(){
		return b.size();
	}

	@Override
	public Object getValueAt(int row, int column){

		switch(column){
			case 0:
				return b.get(row);
			case 1:
				return d.get(row);
			case 2:
				return e.get(row);
			case 3:	
				return m.get(row);
			default:
				return null;
		}
	}

	@Override
	public String getColumnName(int column){
		switch(column){
			case 0:
				return "Busca";
			case 1:
				return "Decodifica";
			case 2:
				return "Executa";
			case 3:
				return "Memória";
			default:
				return "";
		}

	}

}