/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vaultpass.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import vaultpass.model.Credencial;

/**
 *
 * @author JMC
 */

// Não mexer
public class CredencialDAO{
    
    // Método para inserir uma nova credencial na base de dados
    public boolean inserir(Credencial credencial){
        // Comando SQL com interrogações (?) para evitar falhas e SQL Injection
        String sql = "INSERT INTO credenciais (rotulo, usuario, senha) VALUES (?, ?, ?)";
        
        // Abre a conexão e prepara o comando SQL de forma segura
        try (Connection conn = Conexao.obterConexao();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            
            // Substitui as interrogações pelos dados reais que vieram do objeto Credencial
            stmt.setString(1, credencial.obterRotulo());
            stmt.setString(2, credencial.obterUsuario());
            stmt.setString(3, credencial.obterSenha());
            
            // Executa o comando de inserção no MySQL
            stmt.executeUpdate();
            return true; 
            
        } catch (SQLException erro) {
            System.err.println("Erro ao inserir credencial: " + erro.getMessage());
            return false; // Falha ao guardar
        }
    }
    public List<Credencial> listar() {
        List<Credencial> lista = new ArrayList<>();
        String sql = "SELECT rotulo, usuario, senha FROM credenciais";
        
        try (Connection conn = Conexao.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Credencial c = new Credencial();
                c.definirRotulo(rs.getString("rotulo"));
                c.definirUsuario(rs.getString("usuario"));
                c.definirSenha(rs.getString("senha"));
                lista.add(c);
            }
            
        } catch (SQLException erro) {
            System.err.println("Erro ao listar credenciais: " + erro.getMessage());
        }
        
        return lista;
    }
}