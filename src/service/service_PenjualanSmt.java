package service;

import java.util.List;
import model.model_PenjualanSmt;


public interface service_PenjualanSmt {
    void tambahData (model_PenjualanSmt mopsmt);
    void perbaruiData (model_PenjualanSmt mopsmt);
    void hapusData (model_PenjualanSmt mopsmt);
    
    List<model_PenjualanSmt> tampilData();
}
