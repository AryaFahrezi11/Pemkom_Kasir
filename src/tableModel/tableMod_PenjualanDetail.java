/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.model_PenjualanDetail;


/**
 *
 * @author aryam
 */
public class tableMod_PenjualanDetail extends AbstractTableModel{
    
    private List<model_PenjualanDetail> list = new ArrayList<>();
    
    public void tambahData(model_PenjualanDetail mopdet){
        list.add(mopdet);
        fireTableRowsInserted(list.size() -1,list.size() -1);
        JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
    }
    
    public void perbaruiData(int row, model_PenjualanDetail mopdet){
        list.add(row, mopdet);
        fireTableDataChanged();
        JOptionPane.showMessageDialog(null, "Data Berhasil Diperbarui");
    }
    
    public void hapusData(int index){
        list.remove(index);
        fireTableRowsDeleted(index, index);
        JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
    }
    
    public void clear(){
        list.clear();
        fireTableDataChanged();
    }
    
    public void setData(List<model_PenjualanDetail> list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData(int index, model_PenjualanDetail mopdet){
        list.set(index, mopdet);
        fireTableRowsUpdated(index, index);
    }
    
    public model_PenjualanDetail getData(int index){
        return list.get(index);
    }

    @Override
    public int getRowCount() {
        return list.size();
    }
    
    private final String[] columnNames = {"No", "ID Transaksi", "ID Produk", "Nama Produk", "Harga", "Jumlah", "Sub Total"};

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            model_PenjualanDetail model = list.get(rowIndex);
            if(columnIndex == 0) {
                return "  " + (rowIndex + 1);
            }else{
                switch (columnIndex) {
                    case 1:
                        return model.getModelPenjualan().getIdPenjualan();
                    case 2:
                        return model.getModelProduk().getId_produk();
                    case 3:
                        return model.getModelProduk().getNama_produk();
                    case 4:
                        return model.getModelProduk().getHarga_jual();
                    case 5:
                        return model.getJumlah();
                    case 6:
                        return model.getSubTotal();
                    default:
                        return null;
                }
            }  
        
    }
    
    @Override
    public String getColumnName(int column){
        return columnNames[column];
        }
    
}
