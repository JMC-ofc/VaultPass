/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vaultpass.model;

/**
 *
 * @author JMC
 */
public class Credencial{
    
    // Atributos
    private int id;
    private String rotulo;
    private String usuario;
    private String senha;

    public Credencial() {}

    // Métodos
    public int obterId(){
        return id;
    }

    public void definirId(int identificacao){
        id = identificacao;
    }

    public String obterRotulo(){
        return rotulo;
    }

    public void definirRotulo(String rotuloAux){
        rotulo = rotuloAux;
    }

    public String obterUsuario(){
        return usuario;
    }

    public void definirUsuario(String usuarioAux){
        usuario = usuarioAux;
    }

    public String obterSenha(){
        return senha;
    }

    public void definirSenha(String senhaAux){
        senha = senhaAux;
    }
}
