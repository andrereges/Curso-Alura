class While {
    public static void main(String[] args) {
       
        int numeroSoma = 1;

        while(numeroSoma < 1000) {
            
            System.out.println(numeroSoma);
            numeroSoma += numeroSoma;

            if(numeroSoma > 1000){
                System.out.println(1000);
            }
        }
    }
}