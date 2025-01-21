/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.model_Produk;

/**
 *
 * @author aryam
 */
public class tableMod_Produk extends AbstractTableModel {

    private List<model_Produk> list = new ArrayList<>();

    // Nama kolom tabel
    private final String[] columnNames = {"ID Produk", "Nama Produk", "Harga Beli", "Harga Jual", "Stok", "Satuan"};

    // Menambahkan data baru ke dalam tabel
    public void tambahData(model_Produk mod_bar) {
        list.add(mod_bar);
        fireTableRowsInserted(list.size() - 1, list.size() - 1);
        JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
    }

    // Memperbarui data yang ada di tabel
    public void perbaruiData(int row, model_Produk mod_bar) {
        if (row >= 0 && row < list.size()) {
            list.set(row, mod_bar);
            fireTableRowsUpdated(row, row);
            JOptionPane.showMessageDialog(null, "Data Berhasil Diperbarui");
        } else {
            JOptionPane.showMessageDialog(null, "Indeks tidak valid!");
        }
    }

    // Menghapus data dari tabel berdasarkan indeks
    public void hapusData(int index) {
        if (index >= 0 && index < list.size()) {
            list.remove(index);
            fireTableRowsDeleted(index, index);
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
        } else {
            JOptionPane.showMessageDialog(null, "Indeks tidak valid!");
        }
    }

    // Menghapus semua data dari tabel
    public void clear() {
        list.clear();
        fireTableDataChanged();
    }

    // Menetapkan data baru ke tabel
    public void setData(List<model_Produk> list) {
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }

    // Mengambil data pada indeks tertentu
    public model_Produk getData(int index) {
        if (index >= 0 && index < list.size()) {
            return list.get(index);
        }
        return null;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        model_Produk produk = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return produk.getId_produk();
            case 1:
                return produk.getNama_produk();
            case 2:
                return produk.getHarga_beli();
            case 3:
                return produk.getHarga_jual();
            case 4:
                return produk.getStok(); // Jumlah sama dengan stok
            case 5:
                return produk.getSatuan();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
