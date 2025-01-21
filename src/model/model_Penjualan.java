package model;

public class model_Penjualan {



    public String getIdPenjualan() {
        return idPenjualan;
    }

    public void setIdPenjualan(String idPenjualan) {
        this.idPenjualan = idPenjualan;
    }

    public model_User getModelUser() {
        return modelUser;
    }

    public void setModelUser(model_User modelUser) {
        this.modelUser = modelUser;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public double getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(double totalHarga) {
        this.totalHarga = totalHarga;
    }

    public double getBayar() {
        return bayar;
    }

    public void setBayar(double bayar) {
        this.bayar = bayar;
    }

    public double getDiskon() {
        return diskon;
    }

    public void setDiskon(double diskon) {
        this.diskon = diskon;
    }

    public double getKembali() {
        return kembali;
    }

    public void setKembali(double kembali) {
        this.kembali = kembali;
    }
    




    public int getTotalJumlah() {
        return TotalJumlah;
    }

    public void setTotalJumlah(int TotalJumlah) {
        this.TotalJumlah = TotalJumlah;
    }
    private int TotalJumlah;
    private String idPenjualan;
    private model_User modelUser;
    private String tanggal;
    private double totalHarga;
    private double bayar;
    private double diskon;
    private double kembali;
    
}
