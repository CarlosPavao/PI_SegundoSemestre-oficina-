/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.connectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Alex
 */
public class usuarioDAO {
public boolean validausuario(String login, String senha){
        Connection con = connectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean valida = false;
        
        try {
            stmt= con.prepareStatement("SELECT * FROM acesso WHERE login = ? and senha = ?");
            stmt.setString(1, login);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                
                valida = true;
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos!\n"+ex);
        }finally{
            connectionFactory.closeConnection(con,stmt);
        }
        
        return valida;
    }
}