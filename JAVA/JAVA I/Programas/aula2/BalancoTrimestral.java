class BalancoTrimestral {
    public static void main(String[] args) {

        int gastosJaneiro = 15000;
        int gastosFevereiro = 23000;
        int gastosMarco = 17000;

        int gastosTrimestre = gastosJaneiro 
                                + gastosFevereiro 
                                    + gastosMarco;
        int gastosMedia = gastosTrimestre / 3;

        System.out.println("Gasto do Trimestre: R$" + gastosTrimestre);
        System.out.println("Média dos Gastos do Trimestre: R$" + gastosMedia);
    }    
}