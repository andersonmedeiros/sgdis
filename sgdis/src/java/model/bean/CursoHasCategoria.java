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
public class CursoHasCategoria {    
    private final Curso curso = new Curso();
    private final Categoria categoria = new Categoria();
    
    
    public int getIdCurso(){
        return curso.getId();
    }
    
    public void setIdCurso(int idCurso){
        this.curso.setId(idCurso);
    }
    
    public String getNomeCurso(){
        return curso.getNome();
    }
    
    public void setNomeCurso(String nomeCurso){
        this.curso.setNome(nomeCurso);
    }
    
    public String getSiglaCurso() {
        return curso.getSigla();
    }

    public void setSiglaCurso(String siglaCurso) {
        this.curso.setSigla(siglaCurso);
    }

    public String getPortariaCurso() {
        return curso.getPortaria();
    }

    public void setPortariaCurso(String portariaCurso) {
        this.curso.setPortaria(portariaCurso);
    }

    public String getDescricaoCurso() {
        return curso.getDescricao();
    }

    public void setDescricaoCurso(String descricaoCurso) {
        this.curso.setDescricao(descricaoCurso);
    }
    
    public int getIdCategoria() {
        return categoria.getId();
    }

    public void setIdCategoria(int idCategoria) {
        this.categoria.setId(idCategoria);
    }

    public String getNomeCategoria() {
        return categoria.getNome();
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.categoria.setNome(nomeCategoria);
    }

    public String getDescricaoCategoria() {
        return categoria.getDescricao();
    }

    public void setDescricaoCategoria(String descricaoCategoria) {
        this.categoria.setDescricao(descricaoCategoria);
    }   
}
