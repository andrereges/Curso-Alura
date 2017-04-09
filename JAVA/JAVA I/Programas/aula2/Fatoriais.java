class Fatoriais {
    public static void main(String[] args) {
        long fatorial = 1;
        for (int i = 1; i < 21; i++) {
            fatorial *= i;
            System.out.println("Fatorial de "+i+ " = " +fatorial);
        }

        /*Isso acontece porque, a partir de 16!, 
        o valor supera o limite superior do tipo int.
        O tipo long consegue armazenar o cálculo dos fatoriais até 20!
        */
    }
}