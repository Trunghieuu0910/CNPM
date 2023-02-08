/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


/**
 *
 * @author Admin
 */
public class User {
    private String account;
    private String role;
    public User() {
        
    }
    public User(String account, String role) {
        this.account = account;
        this.role = role;
    }
    
    public String getRole() {
        return role;
    }
    
}
