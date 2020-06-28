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
public class ForcaHasEstado {
    private final Forca forca = new Forca();
    private final Estado estado = new Estado();
    
    //Forca
    public int getIdForca() {
        return forca.getId();
    }

    public void setIdForca(int id) {
        forca.setId(id);
    }

    public String getNomeForca() {
        return forca.getNome();
    }

    public void setNomeForca(String nome) {
        forca.setSigla(nome);
    }

    public String getSiglaForca() {
        return forca.getSigla();
    }

    public void setSiglaForca(String sigla) {
        forca.setSigla(sigla);
    }
    
    public int getIdTipoForca() {
        return forca.getId();
    }

    public void setIdTipoForca(int id) {
        forca.setId(id);
    }

    public String getNomeTipoForca() {
        return forca.getNome();
    }

    public void setNomeTipoForca(String nome) {
        forca.setNome(nome);
    }
    
    //Estado
    public int getIdEstado() {
        return estado.getId();
    }

    public void setIdEstado(int id) {
        estado.setId(id);
    }

    public String getNomeEstado() {
        return estado.getNome();
    }

    public void setNomeEstado(String nome) {
        estado.setNome(nome);
    }

    public String getSiglaEstado() {
        return estado.getSigla();
    }

    public void setSiglaEstado(String sigla) {
        estado.setSigla(sigla);
    }
    
    public int getIdRegiao() {
        return estado.getId();
    }

    public void setIdRegiao(int id) {
        estado.setId(id);
    }

    public String getNomeRegiao() {
        return estado.getNome();
    }

    public void setNomeRegiao(String nome) {
        estado.setNome(nome);
    }
}
