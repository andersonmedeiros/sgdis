/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author anderson
 */
public class Referencia {
    private String cpf, nome, sobrenome, email;
    private final GrauParentesco gp = new GrauParentesco();

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public int getIdGrauParentesco() {
        return gp.getId();
    }

    public void setIdGrauParentesco(int id) {
        gp.setId(id);
    }

    public String getNomeGrauParentesco() {
        return gp.getNome();
    }

    public void setNomeGrauParentesco(String nome) {
        gp.setNome(nome);
    }
}
