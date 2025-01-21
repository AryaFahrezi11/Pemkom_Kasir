package service;

import java.util.List;
import model.model_Penjualan;


public interface service_Penjualan {
    void tambahData (model_Penjualan mopen);
    
    List<model_Penjualan> tampilData();
    List<model_Penjualan> pencarianData(String id);
    
    String noTransaksi();
}
