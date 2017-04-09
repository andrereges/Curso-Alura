class TestaEmpresa {
    public static void main(String[] args) {
       
        Empresa empresa = new Empresa();
        empresa.funcionarios = new Funcionario[2];

        empresa.nome = "Ultimate Fight ChampionShip";
        empresa.cnpj = "121208912312031-12";
        empresa.telefone = "+1 211-3222"; 

        Funcionario f = new Funcionario();
        f.nome = "Andre Riggs";
        f.departamento = "Tecnologia";
        f.salario = 17893.21;
        f.dataEntrada = new Data();
        f.dataEntrada.setData(14, 02, 2017);
        f.rg = "47367798-2";

        empresa.adiciona(f);

        Funcionario f2 = new Funcionario();
        f2.nome = "Teco";
        f2.departamento = "UFC";
        f2.salario = 12789.91;
        f2.dataEntrada = new Data();
        f2.dataEntrada.setData(12, 8, 2016);
        f2.rg = "13213123-X";
        
        empresa.adiciona(f2);
        //empresa.mostraInformacoesEmpresa();
        //empresa.mostraFuncionarios();
        //empresa.mostraTodasAsInformacoes();

        boolean contem = empresa.contemFuncionario(f2);

        System.out.println("Contem o funcionario? " + contem);

    }
}