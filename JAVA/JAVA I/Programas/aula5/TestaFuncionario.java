class TestaFuncionario {
    public static void main(String[] args) {
       
        Funcionario f = new Funcionario();

        f.setNome("Andre Riggs");
        f.setDepartamento("Tecnologia");
        f.setSalario(17893.21);
        f.setDataEntrada(10, 2, 2017);
        f.setRg("47367798-2");
        f.recebeAumento(3821.32);

        Funcionario f2 = new Funcionario();
        f2.setNome("Teco");
        f2.setDepartamento("Vendas");
        f2.setSalario(12213.21);
        f2.setDataEntrada(25, 2, 2017);
        f2.setRg("47367798-2");

        f.mostra();          
        f2.mostra();

    }
}