public class Instrucao{

	private Registrador r;
	private Registrador op1;
	private Registrador op2;
	private String operacao;
	private String nome;

	public Instrucao()
	{
		this.r = new Registrador("2");
		this.op1 = new Registrador("7");
		this.op2 = new Registrador("5");
		this.operacao = "vazio";
		this.nome = "vazio";
	}

	public Instrucao(Registrador r, Registrador op1, Registrador op2, String operacao, String nome){

		this.r = r;
		this.op1 = op1;
		this.op2 = op2;
		this.operacao = operacao;
		this.nome = nome;
	}

	public Instrucao(Registrador r, Registrador op1, String operacao, String nome){

		this.r = r;
		this.op1 = op1;
		this.op2 = new Registrador("#");
		this.operacao = operacao;
		this.nome = nome;
	}

	public Registrador getR(){
		return this.r;
	}

	public Registrador getOp1(){
		return this.op1;
	}

	public Registrador getOp2(){
		return this.op2;
	}

	public String getOperacao(){
		return this.operacao;
	}

	public String getNome(){
		return this.nome;
	}
}