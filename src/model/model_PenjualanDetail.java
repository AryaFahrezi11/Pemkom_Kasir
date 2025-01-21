package model;

public class model_PenjualanDetail {

    public model_Penjualan getModelPenjualan() {
        return modelPenjualan;
    }

    public void setModelPenjualan(model_Penjualan modelPenjualan) {
        this.modelPenjualan = modelPenjualan;
    }

    public model_Produk getModelProduk() {
        return modelProduk;
    }

    public void setModelProduk(model_Produk modelProduk) {
        this.modelProduk = modelProduk;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
    private model_Penjualan modelPenjualan;
    private model_Produk modelProduk;
    private int jumlah;
    private double subTotal;
    
}
