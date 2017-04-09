class TestaFuncionario {
    public static void main(String[] args) {
       
        Funcionario f = new Funcionario();

        f.nome = "Andre Riggs";
        f.departamento = "Tecnologia";
        f.salario = 17893.21;
        f.dataEntrada = new Data();
        f.dataEntrada.setData(14, 02, 2017);
        f.rg = "47367798-2";

        f.recebeAumento(3821.32);

        f.mostra();
    }
}