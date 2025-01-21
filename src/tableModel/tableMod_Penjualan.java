/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.model_Penjualan;


/**
 *
 * @author aryam
 */
public class tableMod_Penjualan extends AbstractTableModel{
    
    private List<model_Penjualan> list = new ArrayList<>();
    
    public void tambahData(model_Penjualan modpen){
        list.add(modpen);
        fireTableRowsInserted(list.size() -1,list.size() -1);
        JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
    }
    
    public void perbaruiData(int row, model_Penjualan modpen){
        list.add(row, modpen);
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
    
    public void setData(List<model_Penjualan> list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData(int index, model_Penjualan modpen){
        list.set(index, modpen);
        fireTableRowsUpdated(index, index);
    }
    
    public model_Penjualan getData(int index){
        return list.get(index);
    }

    @Override
    public int getRowCount() {
        return list.size();
    }
    
    private final String[] columnNames = {"No", "ID Transaksi", "Tanggal", "Total Harga", "Bayar", "Diskon", "Kembali", "ID Kasir", "Nama Kasir"};

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            model_Penjualan model = list.get(rowIndex);
            if(columnIndex == 0) {
                return "  " + (rowIndex + 1);
            }else{
                switch (columnIndex) {
                    case 1:
                        return model.getIdPenjualan();
                    case 2:
                        return model.getTanggal();
                    case 3:
                        return model.getTotalHarga();
                    case 4:
                        return model.getBayar();
                    case 5:
                        return model.getDiskon();
                    case 6:
                        return model.getKembali();
                    case 7:
                        return model.getModelUser().getId_pengguna();
                    case 8:
                        return model.getModelUser().getFullname();
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
