class Gerente extends Funcionario {
    private int senha;
    private int numeroDeFuncionariosGerenciados;

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public void setNumeroDeFuncionariosGerenciados(int numeroDeFuncionariosGerenciados) {
        this.numeroDeFuncionariosGerenciados = numeroDeFuncionariosGerenciados;
    }

    public int getNumeroDeFuncionariosGerenciados() {
        return this.numeroDeFuncionariosGerenciados;
    }

    @Override
    public double getBonificacao() {
        return this.salario * 0.15;
        // return super.getBonificacao() + 1000; bonificação da classe mãe.
    }

    public boolean autentica(int senha) {
        
        if (this.senha == senha) {
            System.out.println("Acesso Permitido!");
            return true;
        } else {
            System.out.println("Acesso Negado!");
            return false;
        }

    }
}