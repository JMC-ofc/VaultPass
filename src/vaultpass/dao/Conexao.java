/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vaultpass.dao;

//Bibliotecas para o SQL
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
        
/**
 *
 * @author JMC
 */
public class Conexao{
    
    // Não mexer
    private static final String URL = "jdbc:mysql://localhost:3306/vaultpass?useSSL=false&serverTimezone=UTC";
    // use do MySQL
    private static final String UTILIZADOR = "root";
    // Senha do MySQL
    private static final String PASSWORD = "V1V4_!#16-03viva";
    
    // Método para abrir e devolver a conexão com a base de dados
    public static Connection obterConexao() {
        try{
            // Regista o driver e estabelece a ligação
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, UTILIZADOR, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.err.println("Driver do MySQL não encontrado: " + e.getMessage());
            return null;
        } catch (SQLException e) {
            System.err.println("Erro ao conectar à base de dados: " + e.getMessage());
            return null;
        }
    }
}

