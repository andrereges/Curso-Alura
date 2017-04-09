class Empresa {

    private String nome;
    private String cnpj;
    private String telefone;
    private Funcionario[] funcionarios;


    public Empresa(int qtdFuncionarios) {
        funcionarios = new Funcionario[qtdFuncionarios];
    }

    //______GETTERS_________
	public String getNome() {
		return this.nome;
	}

    public String getCnpj() {
		return this.cnpj;
	}

    public String getTelefone() {
		return this.telefone;
	}
    
    public Funcionario getFuncionario(int posicao) {
        return this.funcionarios[posicao];
    }

    //______SETTERS_________
	public void setNome(String nome) {
		this.nome = nome;
	}

    public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

    public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

    //___________MÉTODOS_____________________
   public void setFuncionario(Funcionario f) {

        for(int i = 0; i < this.funcionarios.length; i++) {
            if(funcionarios[i] == null) {
                this.funcionarios[i] = f;
                break;
            }
        }      
    }

    public boolean isFuncionario(Funcionario f) {
        boolean contem = false;

        for(int i = 0; i < this.funcionarios.length; i++) {
            if(f.equals(this.funcionarios[i])) {
                contem = !contem;
            }
        }
        
        return contem;
    }

    public void mostraFuncionarios() {

        System.out.println("\n--- Lista de Funcionários ---\n");
        for(int i = 0; i < this.funcionarios.length; i++) {
            if(funcionarios == null) {continue;}
            System.out.println("ID: " + i   
                            + "\nNome: " + this.getFuncionario(i).getNome() 
                            + "\nDepartamento: " + this.getFuncionario(i).getDepartamento() 
                            + "\nSalário: " + this.getFuncionario(i).getSalario() 
                            + "\nRG: " + this.getFuncionario(i).getRg() 
                            + "\nSalário: " + this.getFuncionario(i).getSalario() 
							+ "\nData Entrada: " + this.getFuncionario(i).getDataEntrada().getDataFormatada()
                            + "\nGanho Anual: " + this.getFuncionario(i).getGanhoAnual()
                            + "\n\n||==============================================||\n");
        }           
    }

    public void mostraInformacoesEmpresa() {
        System.out.println("__________Dados da Empresa__________\n");
        System.out.println("Nome da Empresa: " + this.getNome());        
        System.out.println("CNPJ: " + this.getCnpj());
        System.out.println("Telefone: " + this.getTelefone());
    }

    public void mostraTodasAsInformacoes() {          
            mostraInformacoesEmpresa();
            mostraFuncionarios();
    }
}