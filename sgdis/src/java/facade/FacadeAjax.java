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


/**
 *
 * @author anderson
 */
public class FacadeAjax {
    //lista com todas as categorias que um curso pode ter;
    public ArrayList getCategorias() throws Throwable, Exception{
        ArrayList<Categoria> listResult = new ArrayList();
        listResult = CategoriaDAO.getCategoriasDWR();
        return listResult;
    }
    //Curso;
    public Curso getCurso(int idCurso) throws Throwable, Exception{
        Curso cursoResult = new Curso();
        cursoResult = CursoDAO.getCursoByIdDWR(idCurso);
        return cursoResult;
    }
    
    
}
