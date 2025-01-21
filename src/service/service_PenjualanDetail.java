package service;

import java.util.List;
import model.model_PenjualanDetail;


public interface service_PenjualanDetail {
    void tambahData (model_PenjualanDetail mopdet);
    void sumTotal   (model_PenjualanDetail mopdet);
    void sumJumlah   (model_PenjualanDetail mopdet);
    void hapusDataSementara();
    
    List<model_PenjualanDetail> tampilData(String id);
    List<model_PenjualanDetail> pencarianData(String id, String kataKunci);
    
}
