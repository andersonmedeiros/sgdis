/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.CategoriaDAO;
import dao.CursoDAO;
import dao.DisciplinaDAO;
import dao.ModalidadeDAO;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.xml.transform.Source;

/**
 *
 * @author andersondepaula
 */
public class teste {
    public static void main(String[] args) {
        /*CategoriaDAO catDAO = new CategoriaDAO();
        CursoDAO cDAO = new CursoDAO();
        Categoria cat = new Categoria();
        Curso c = new Curso();
        cat = catDAO.getCategoria(cDAO.getCurso(1).getIdCategoria());
        
        System.out.println(cat.getNome());
        
        String sigla = "VS";
        int ano = 2019;
        int var = 1;
        DecimalFormat df = new DecimalFormat("0000");
        String s = df.format(var);
        String cod = sigla + "_" + ano + "_" + s;
        System.out.println(cod);
        String[] t = cod.split("_");
        System.out.println(t[t.length-4]);*/
        
        String fase = "VS_2019_1_1";
        
            String tabela = "Assunto";
    
    //Atributos
    String codigo = "codigo";
    String nome = "nome";
    String chDiurna = "chDiurna";
    String chNoturna = "chNoturna";
    String codigoDisciplina = "codigoDisciplina";
        
        String GETAssuntosByCodDiscANDcodGradeANDidCurso = "SELECT * FROM " + tabela + " AS a" + 
                                                                     " INNER JOIN Disciplina AS d ON a.codigoDisciplina = d.codigo" +
                                                                     " INNER JOIN Fase AS f ON " + tabela + "." + codigoDisciplina + " = f.codigo AND f.codigoGrade = ? AND f.idCurso = ?;";
    
        
        String[] t = fase.split("_");
        System.out.println(GETAssuntosByCodDiscANDcodGradeANDidCurso);
        
        
        /*int variacao = Integer.parseInt(fase.replaceAll("VS_2019_1"+"_", ""));
        
        System.out.println(variacao+5);
        
        DisciplinaDAO d = new DisciplinaDAO();
       
    
        System.out.println(d.proxVariacao("VS_2019_1"));*/
    }
    
}
