/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dao;
import java.sql.Connection;
import connection.connectionFactory;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.bean.cliente;

/**
 *
 * @author Alex
 */
public class clienteDAO {
    public void incluiClient(cliente insere){
        
        Connection con = connectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("call novo_cliente (logradouro,bairro,numero,cep,cidade,complemento,uf,nome,sexo,email,telefone,celular,rg,cpf,data_nasci,placa,modelo,fabricante,ano_fab,cor,km,ano_modelo)"
                    + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1,insere.getLogradouro());
            stmt.setString(2,insere.getBairro());
            stmt.setInt(3,insere.getNumero());
            stmt.setString(4,insere.getCep());
            stmt.setString(5,insere.getCidade());
            stmt.setString(6,insere.getComplemento());
            stmt.setString(7,insere.getUf());
            stmt.setString(8,insere.getNome());
            stmt.setString(9,insere.getSexo());
            stmt.setString(10,insere.getSexo());
            stmt.setString(11,insere.getEmail());
            stmt.setString(12,insere.getTelefone());
            stmt.setString(13,insere.getCelular());
            stmt.setString(14,insere.getRg());
            stmt.setString(15,insere.getCpf());
            stmt.setString(16,insere.getData_nasci());
            stmt.setString(17,insere.getPlaca());
            stmt.setString(18,insere.getFabricante());
            stmt.setString(19,insere.getAno_fab());
            stmt.setString(20,insere.getCor());
            stmt.setInt(21,insere.getKm());
            stmt.setString(22,insere.getAno_modelo());
            
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inclui os dados!\n"+ex);
        }finally{
            connectionFactory.closeConnection(con,stmt);
        }
    }
}
