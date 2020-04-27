/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.util.ArrayList;

import model.bean.Categoria;
import model.bean.Curso;
import model.bean.Tentativa;
import model.bean.Turma;
import model.dao.CategoriaDAO;
import model.dao.CursoDAO;
import model.dao.CursoHasCategoriaDAO;
import model.dao.TentativaDAO;
import model.dao.TurmaDAO;


/**
 *
 * @author anderson
 */
public class FacadeAjax {
    //Categoria
    public ArrayList<Categoria> getCategoriasDWR() throws Throwable, Exception{
        ArrayList<Categoria> categorias = new ArrayList();
        categorias = CategoriaDAO.getCategoriasDWR();
        return categorias;
    }
    public ArrayList<Categoria> getCategoriasByCursoDWR(int idCurso) throws Throwable, Exception{
        ArrayList<Categoria> categorias = new ArrayList();
        categorias = CursoHasCategoriaDAO.getCategoriasByCursoDWR(idCurso);
        return categorias;
    }
    
    //Curso;
    public Curso getCursoDWR(int idCurso) throws Throwable, Exception{
        Curso curso = new Curso();
        curso = CursoDAO.getCursoByIdDWR(idCurso);
        return curso;
    }
    public ArrayList<Curso> getCursosDWR() throws Throwable, Exception{
        ArrayList<Curso> cursos = new ArrayList();
        cursos = CursoDAO.getCursosDWR();
        return cursos;
    }
    
    //Turma
    public ArrayList<Turma> getTurmasByCursoAndCategoriaDWR(int idCurso, int idCategoria) throws Throwable, Exception{
        ArrayList<Turma> turmas = new ArrayList();
        turmas = TurmaDAO.getTurmasByCursoAndCategoriaDWR(idCurso, idCategoria);
        return turmas;
    }
    
    //Tentativas
    public int getQtdeTentativasByCandidatoAndCursoDWR(String idtAluno, int idCurso) throws Throwable, Exception{
       return TentativaDAO.getQtdeTentativasByCandidatoAndCurso(idtAluno, idCurso);
    }
    
    public ArrayList<Tentativa> getTentativasByCandidatoAndCursoDWR(String idtAluno, int idCurso) throws Throwable, Exception{
        ArrayList<Tentativa> tentativas = new ArrayList();
        tentativas = TentativaDAO.getTentativasByCandidatoAndCursoDWR(idtAluno, idCurso);
        return tentativas;
    }
    
    
}
