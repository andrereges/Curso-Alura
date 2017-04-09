class Empresa {

    String nome;
    String cnpj;
    String telefone;
    Funcionario[] funcionarios;

    void adiciona(Funcionario f) {

        for(int i = 0; i < this.funcionarios.length; i++) {
            if(funcionarios[i] == null) {
                this.funcionarios[i] = f;
                break;
            }
        }      
    }

    boolean contemFuncionario(Funcionario f) {
        boolean contem = false;

        for(int i = 0; i < this.funcionarios.length; i++) {
            if(f.equals(this.funcionarios[i])) {
                contem = !contem;
            }
        }
        
        return contem;
    }

    void mostraFuncionarios() {

        System.out.println("\n--- Lista de Funcionários ---\n");
        for(int i = 0; i < this.funcionarios.length; i++) {
            if(funcionarios == null) {continue;}
            System.out.println("ID: " + i   
                            + "\nNome: " + this.funcionarios[i].nome 
                            + "\nDepartamento: " + this.funcionarios[i].departamento
                            + "\nSalário: " + this.funcionarios[i].salario
                            + "\nRG: " + this.funcionarios[i].rg
                            + "\nSalário: " + this.funcionarios[i].salario
							+ "\nData Entrada: " + this.funcionarios[i].dataEntrada.getDataFormatada()
                            + "\nGanho Anual: " + this.funcionarios[i].calculaGanhoAnual()
                            + "\n\n||==============================================||\n");
        }           
    }

    void mostraInformacoesEmpresa() {
        System.out.println("__________Dados da Empresa__________\n");
        System.out.println("Nome da Empresa: " + this.nome);        
        System.out.println("CNPJ: " + cnpj);
        System.out.println("Telefone: " + telefone);
    }

    void mostraTodasAsInformacoes() {          
            mostraInformacoesEmpresa();
            mostraFuncionarios();
    }
}