package tableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.model_PenjualanSmt;

/**
 *
 * @author aryam
 */
public class tableMod_PenjualanSmt extends AbstractTableModel {
    
    private List<model_PenjualanSmt> list = new ArrayList<>();
    
    // Menambahkan data baru
    public void tambahData(model_PenjualanSmt mopsmt) {
        list.add(mopsmt);
        fireTableRowsInserted(list.size() - 1, list.size() - 1);
        JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
    }
    
    // Memperbarui data di baris tertentu
    public void perbaruiData(int row, model_PenjualanSmt mopsmt) {
        // Menggunakan set() untuk menggantikan data di baris tertentu
        list.set(row, mopsmt); 
        fireTableRowsUpdated(row, row);  // Memberi tahu JTable bahwa data pada baris tersebut telah diperbarui
        JOptionPane.showMessageDialog(null, "Data Berhasil Diperbarui");
    }
    
    // Menghapus data di baris tertentu
    public void hapusData(int index) {
        list.remove(index);
        fireTableRowsDeleted(index, index);
        JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
    }
    
    // Menghapus semua data dalam tabel
    public void clear() {
        list.clear();
        fireTableDataChanged();
    }
    
    // Mengatur data dari luar
    public void setData(List<model_PenjualanSmt> list) {
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    
    // Mengatur data di baris tertentu
    public void setData(int index, model_PenjualanSmt mopsmt) {
        list.set(index, mopsmt);
        fireTableRowsUpdated(index, index);
    }
    
    // Mendapatkan data pada baris tertentu
    public model_PenjualanSmt getData(int index) {
        return list.get(index);
    }

    @Override
    public int getRowCount() {
        return list.size();
    }
    
    private final String[] columnNames = {"No", "ID Produk", "Nama Produk", "Harga", "Stok", "Jumlah", "Sub Total"};

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        model_PenjualanSmt model = list.get(rowIndex);
        if (columnIndex == 0) {
            return "  " + (rowIndex + 1);
        } else {
            switch (columnIndex) {
                case 1:
                    return model.getModelProduk().getId_produk();
                case 2:
                    return model.getModelProduk().getNama_produk();
                case 3:
                    return model.getModelProduk().getHarga_jual();
                case 4:
                    return model.getModelProduk().getStok();
                case 5: // Kolom Jumlah
                    return model.getModelPenDet().getJumlah(); // Mengambil jumlah yang sudah diperbarui
                case 6: // Kolom SubTotal
                    return model.getModelPenDet().getSubTotal(); // Mengambil subtotal yang sudah diperbarui
                default:
                    return null;
            }
        }   
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
