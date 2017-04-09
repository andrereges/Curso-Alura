class Data {
   private String dataFormatada;

    void setData(int dia, int mes, int ano) {
        
        if(mes == 2 && dia > 29) {
            return;
        }

        this.dataFormatada = dia + "/" + mes + "/" + ano;
    }

    String getDataFormatada() {
        return this.dataFormatada;
    }
}