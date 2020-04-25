/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.util.ArrayList;

import model.bean.Categoria;
import model.bean.Curso;
import model.dao.CategoriaDAO;
import model.dao.CursoDAO;
import model.dao.CursoHasCategoriaDAO;


/**
 *
 * @author anderson
 */
public class FacadeAjax {
    //lista com todas as categorias que um curso pode ter;
    public ArrayList<Categoria> getCategoriasDWR() throws Throwable, Exception{
        ArrayList<Categoria> listResult = new ArrayList();
        listResult = CategoriaDAO.getCategoriasDWR();
        return listResult;
    }
    public ArrayList<Categoria> getCategoriasByCursoDWR(int idCurso) throws Throwable, Exception{
        ArrayList<Categoria> listResult = new ArrayList();
        listResult = CursoHasCategoriaDAO.getCategoriasByCursoDWR(idCurso);
        return listResult;
    }
    //Curso;
    public Curso getCursoDWR(int idCurso) throws Throwable, Exception{
        Curso cursoResult = new Curso();
        cursoResult = CursoDAO.getCursoByIdDWR(idCurso);
        return cursoResult;
    }
    public ArrayList<Curso> getCursosDWR() throws Throwable, Exception{
        ArrayList<Curso> listResult = new ArrayList();
        listResult = CursoDAO.getCursosDWR();
        return listResult;
    }
    
    
    
}
