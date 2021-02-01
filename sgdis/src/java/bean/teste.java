/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import model.dao.CategoriaDAO;
import model.dao.CursoDAO;
import dao.DisciplinaDAO;
import dao.ModalidadeDAO;
import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.xml.transform.Source;
import model.bean.AlunoHasMedicacao;
import model.bean.Endereco;
import model.dao.AlunoDAO;
import model.dao.ComandanteDAO;
import model.dao.EnderecoDAO;
import model.dao.OmDAO;
import model.dao.TurmaDAO;
import model.dao.TurmaHasAlunoDAO;

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
        
   /*     String fase = "VS_2019_1_1";
        
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
    
        */
        /*Date di = new Date(2020 - 1900, 04 - 1, 27);
        Date df = new Date(2020 - 1900, 04 - 1, 30);
        
        /*String[] t = fase.split("_");
        System.out.println(GETAssuntosByCodDiscANDcodGradeANDidCurso);
        
        TurmaDAO tDAO = new TurmaDAO();
        System.out.println(di + " " + df + " " + tDAO.getExisteTurma(1, 1, di, df));*/
        
        
        /*int variacao = Integer.parseInt(fase.replaceAll("VS_2019_1"+"_", ""));
        
        System.out.println(variacao+5);
        
        DisciplinaDAO d = new DisciplinaDAO();
       
    
        System.out.println(d.proxVariacao("VS_2019_1"));*/
        
        String data = "2019-10-29";
        String dtNascAlSeparada[] = data.split("-");
        Date dataNascAl = new Date(Calendar.YEAR, Calendar.MONTH, 2);
        
        Calendar hoje = Calendar.getInstance();
        DateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd"); 
        DateFormat horaFormat = new SimpleDateFormat("HH:mm:ss"); 
        String dataSaida[] = dataFormat.format(hoje.getTime()).split("-");
        String horaSaida[] = horaFormat.format(hoje.getTime()).split(":");
        
        Date dataa = new Date(Integer.parseInt(dataSaida[0]) - 1900, Integer.parseInt(dataSaida[1]) - 1, Integer.parseInt(dataSaida[2]));
        Time saida = new Time(Integer.parseInt(horaSaida[0]), Integer.parseInt(horaSaida[1]), Integer.parseInt(horaSaida[2]));
        System.out.println(dataa.toString() + "   " + saida.toString());
        
                
     
        /*
        AlunoHasMedicacao alunomedicacao = new AlunoHasMedicacao();
        alunomedicacao.setIdentidadeAluno("teste");
        alunomedicacao.setIdMedicacao(5);
        alunomedicacao.setTipo(2);
        
        System.out.println(alunomedicacao.getIdentidadeAluno());
        System.out.println(alunomedicacao.getIdMedicacao());
        System.out.println(alunomedicacao.getFrequencia());
        System.out.println(alunomedicacao.getPeriodo());
        System.out.println(alunomedicacao.getTipo());
        
        EnderecoDAO endDAO = new EnderecoDAO();
        Endereco endCigs = endDAO.getEnderecoExistente("69033000", "AVENIDA SÃO JORGE", "", "", "SÃO JORGE", 256);
        
        System.out.println("c: " + endCigs);
        System.out.println("c: " + endCigs.getId());*/
        
        
        //System.out.println(TurmaHasAlunoDAO.getAlunosByTurmaDWR(5).get(0).getIdOM());
        //System.out.println(TurmaHasAlunoDAO.getAlunosByTurmaDWR(5).get(1).getIdentidade());
        
        OmDAO omDAO = new OmDAO();
        AlunoDAO alDAO= new AlunoDAO();
        //System.out.println(alDAO.getAlunoByIdentidade("7774442222").getAbrevPGrad());
        
        String tempo[] = "10:20:18".split(":");
        String tempo2[] = "10:20:19".split(":");
        
        
        Time corrida = new Time(0,41,2);
        Time indice = new Time(0,40,0);
        
        
        System.out.println("cor: " + corrida.toString());
        System.out.println("indice: " + indice.toString());
        
        if(corrida.after(indice)){
            System.out.println("Inapto");
        }else{
            System.out.println("apto");
        }
    }
    
}
