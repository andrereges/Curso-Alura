class Data {
   private String dataFormatada;

    void setData(int dia, int mes, int ano) {
        this.dataFormatada = dia + "/" + mes + "/" + ano;
    }

    String getDataFormatada() {
        return this.dataFormatada;
    }
}