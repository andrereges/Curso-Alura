class TestaEmpresa {
    public static void main(String[] args) {
       
        Empresa empresa = new Empresa(2);

        empresa.setNome("Ultimate Fight ChampionShip");
        empresa.setCnpj("121208912312031-12");
        empresa.setTelefone("+1 211-3222"); 

        Funcionario f = new Funcionario();
        f.setNome("Andre Riggs");
        f.setDepartamento("Tecnologia");
        f.setSalario(17893.21);
        f.setDataEntrada(14, 2, 2017);
        f.setRg("47367798-2");

        empresa.setFuncionario(f);

        Funcionario f2 = new Funcionario();
        f2.setNome("Teco");
        f2.setDepartamento("Vendas");
        f2.setSalario(12422.43);
        f2.setDataEntrada(02, 12, 2017);
        f2.setRg("7823188133-x");
        
        empresa.setFuncionario(f2);
        //empresa.mostraInformacoesEmpresa();
        empresa.mostraFuncionarios();
        //empresa.mostraTodasAsInformacoes();
        //System.out.println(empresa.getFuncionario(0).getNome());

        //boolean contem = empresa.isFuncionario(f2);

        //System.out.println("Contem o funcionario? " + contem);

    }
}