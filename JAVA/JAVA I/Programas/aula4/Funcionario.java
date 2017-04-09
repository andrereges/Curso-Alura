class Funcionario {
	String nome;
	String departamento;
	double salario;
	Data dataEntrada;
	String rg;

	void recebeAumento(double valor) {
		this.salario  += valor;
	}

	double calculaGanhoAnual() {
		double ganhoAnual = this.salario * 12;
		return ganhoAnual;
	}

	void mostra() {

        System.out.println(   "\nNome: " + this.nome 
                            + "\nDepartamento: " + this.departamento
                            + "\nSalário: " + this.salario
                            + "\nRG: " + this.rg
                            + "\nSalário: " + this.salario
							+ "\nData Entrada: " + this.dataEntrada.getDataFormatada()
                            + "\nGanho Anual: " + this.calculaGanhoAnual()
                            + "\n\n||==============================================||");
    }

}