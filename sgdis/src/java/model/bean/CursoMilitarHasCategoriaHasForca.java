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
public class CursoMilitarHasCategoriaHasForca {
    private final CursoMilitar cursomilitar = new CursoMilitar();
    private final Categoria cat = new Categoria();
    private final Forca forca = new Forca();
    
    public int getIdCursoMilitar() {
        return cursomilitar.getId();
    }

    public void setIdCursoMilitar(int idCursoMilitar) {
        cursomilitar.setId(idCursoMilitar);
    }

    public int getTipoCursoMilitar() {
        return cursomilitar.getTipo();
    }

    public void setTipoCursoMilitar(int tipoCursoMilitar) {
        cursomilitar.setTipo(tipoCursoMilitar);
    }

    public String getNomeCursoMilitar() {
        return cursomilitar.getNome();
    }

    public void setNomeCursoMilitar(String nomeCursoMilitar) {
        cursomilitar.setNome(nomeCursoMilitar);
    }
    
    public int getIdCategoria() {
        return cat.getId();
    }

    public void setIdCategoria(int idCategoria) {
        cat.setId(idCategoria);
    }

    public String getNomeCategoria() {
        return cat.getNome();
    }

    public void setNomeCategoria(String nomeCategoria) {
        cat.setNome(nomeCategoria);
    }

    public String getDescricaoCategoria() {
        return cat.getDescricao();
    }

    public void setDescricaoCategoria(String descricaoCategoria) {
        cat.setDescricao(descricaoCategoria);
    }
    
    public int getIdForca() {
        return forca.getId();
    }

    public void setIdForca(int idForca) {
        forca.setId(idForca);
    }

    public String getNomeForca() {
        return forca.getNome();
    }

    public void setNomeForca(String nomeForca) {
        forca.setNome(nomeForca);
    }

    public String getSiglaForca() {
        return forca.getSigla();
    }

    public void setSiglaForca(String siglaForca) {
        forca.setSigla(siglaForca);
    }
    
    public int getIdTipoForca() {
        return forca.getIdTipoForca();
    }

    public void setIdTipoForca(int id) {
        forca.setIdTipoForca(id);
    }

    public String getNomeTipoForca() {
        return forca.getNomeTipoForca();
    }

    public void setNomeTipoForca(String nome) {
        forca.setNomeTipoForca(nome);
    }
}
