class Funcionario {
	private static int identificador = 0;
	private int id;
	private String nome;
	private String departamento;
	private double salario;
	private Data dataEntrada;
	private String rg;

	public Funcionario() {
		this.id = ++identificador;
	}

	public Funcionario(String nome, double salario) {
		setNome(nome);
		setSalario(salario);
		this.id = ++identificador;
	}

	//______GETTERS_________
	public int getId() {
		return this.id;
	}

	public String getNome() {
		return this.nome;
	}

	public String getDepartamento() {
		return this.departamento;
	}

	public double getSalario() {
		return this.salario;
	}

	public Data getDataEntrada() {
		return this.dataEntrada;
	}

	public String getRg() {
		return this.rg;
	}

	//______SETTERS_________
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public void setDataEntrada(int dia, int mes, int ano) {
		dataEntrada = new Data();
		dataEntrada.setData(dia, mes, ano);
		this.dataEntrada = dataEntrada;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	//___________MÉTODOS_____________________
	public void recebeAumento(double valor) {
		this.salario  += valor;
	}

	public double getGanhoAnual() {
		double ganhoAnual = this.salario * 12;
		return ganhoAnual;
	}

	public void mostra() {

        System.out.println(   "\nid: " + this.getId()
							+ "\nNome: " + this.nome 
                            + "\nDepartamento: " + this.departamento
                            + "\nSalário: " + this.salario
                            + "\nRG: " + this.rg
                            + "\nSalário: " + this.salario
							+ "\nData Entrada: " + this.dataEntrada.getDataFormatada()
                            + "\nGanho Anual: " + this.getGanhoAnual()
                            + "\n\n||==============================================||");
    }

}