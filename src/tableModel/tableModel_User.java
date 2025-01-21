/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.model_User;

/**
 *
 * @author aryam
 */
public class tableModel_User extends AbstractTableModel{
    private List<model_User> list = new ArrayList<>();
    
    public void tambahData(model_User mod_user){
        list.add(mod_user);
        fireTableRowsInserted(list.size() -1,list.size() -1);
        JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
    }
    public void perbaruiData(int row, model_User mod_user){
        list.add(row, mod_user);
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
    
    public void setData(List<model_User> list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData(int index, model_User mod_user){
        list.set(index, mod_user);
        fireTableRowsUpdated(index, index);
    }
    
    public model_User getData(int index){
        return list.get(index);
    }

    @Override
    public int getRowCount() {
        return list.size();
    }
    
    private final String[] columnNames = {"No", "ID User", "Nama", "Email", "No Telepon", "Username", "Password", "Role"};

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
            if (columnIndex == 0) {
                return "    " + (rowIndex + 1);
            }else{
                switch (columnIndex - 1){
                case 0: return list.get(rowIndex).getId_pengguna();
                case 1: return list.get(rowIndex).getFullname();
                case 2: return list.get(rowIndex).getEmail();
                case 3: return list.get(rowIndex).getTelepon();
                case 4: return list.get(rowIndex).getUsernama();
                case 5: return list.get(rowIndex).getPass();
                case 6: return list.get(rowIndex).getRole();

                default: return null;
            }
        
        }
        
    }
    @Override
    public String getColumnName(int column){
        if (column == 0) {
            return "   " + columnNames[column];
        }else{
            return columnNames[column];
        }
    }
    
}
