import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class Lista extends AbstractTableModel{
		
	private final ArrayList<Instrucao> lista;

	public Lista(ArrayList<Instrucao> lista){
		this.lista = lista;
	}

	@Override
	public int getColumnCount(){
		return 5;
	}

	@Override
	public int getRowCount(){
		return lista.size();
	}

	@Override
	public Object getValueAt(int row, int column){
		Instrucao i = lista.get(row);

		switch(column){
			case 0:
				return i.getNome();
			case 1:
				return i.getOperacao();
			case 2:
				return i.getR().getNome();
			case 3:
				return i.getOp1().getNome();
			case 4:
				return i.getOp2().getNome();
			default:
				return null;
		}
	}

	@Override
	public String getColumnName(int column){
		switch(column){
			case 0:
				return "Instrução";
			case 1:
				return "Operação";
			case 2:
				return "Resultado";
			case 3:
				return "Operador 1";	
			case 4:
				return "Operador 2";	
			default:
				return "";
		}

	}

}
