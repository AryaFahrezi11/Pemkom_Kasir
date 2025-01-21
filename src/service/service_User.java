/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.model_User;

/**
 *
 * @author aryam
 */
public interface service_User {
    void tambahData (model_User mod_user);
    void perbaruiData (model_User mod_user);
    void hapusData (model_User mod_user);
    
    model_User getByid (String id);
    
    List<model_User> getData();
    List<model_User> pencarian(String id);
    
    String nomor();
    boolean validateOldPassword(String username, String oldPassword);
    boolean changePassword(String username, String oldPassword, String newPassword);
}
