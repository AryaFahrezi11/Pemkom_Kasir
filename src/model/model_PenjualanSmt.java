package model;

public class model_PenjualanSmt {

    // Atribut modelProduk dan modelPenDet
    private model_Produk modelProduk;
    private model_PenjualanDetail modelPenDet;

    // Getter dan Setter untuk modelProduk
    public model_Produk getModelProduk() {
        return modelProduk;
    }

    public void setModelProduk(model_Produk modelProduk) {
        this.modelProduk = modelProduk;
    }

    // Getter dan Setter untuk modelPenDet
    public model_PenjualanDetail getModelPenDet() {
        return modelPenDet;
    }

    public void setModelPenDet(model_PenjualanDetail modelPenDet) {
        this.modelPenDet = modelPenDet;
    }

    // Metode untuk mengambil jumlah dan subTotal dari modelPenDet
    public int getJumlah() {
        return modelPenDet.getJumlah();
    }

    public void setJumlah(int jumlah) {
        modelPenDet.setJumlah(jumlah);
    }

    public long getSubTotal() {
        return (long) modelPenDet.getSubTotal();
    }

    public void setSubTotal(long subTotal) {
        modelPenDet.setSubTotal(subTotal);
    }
}
