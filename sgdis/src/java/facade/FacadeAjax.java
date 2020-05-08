/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.util.ArrayList;
import model.bean.*;
import model.dao.*;
/**
 *
 * @author anderson
 */
public class FacadeAjax {
    //Forca, Estado, OM, PostoGraduacao, QasQms
    public ArrayList<Forca> getForcasDWR() throws Throwable, Exception{
        ArrayList<Forca> forcas = new ArrayList();
        forcas = ForcaDAO.getForcasDWR();
        return forcas;
    }
    public ArrayList<Estado> getEstadosByForcaDWR(int idForca) throws Throwable, Exception{
        ArrayList<Estado> estados = new ArrayList();
        estados = ForcaHasEstadoDAO.getEstadosByForcaDWR(idForca);
        return estados;
    }
    public ArrayList<Om> getOmsByForcaAndEstadoDWR(int idForca, int idEstado) throws Throwable, Exception{
        ArrayList<Om> oms = new ArrayList();
        oms = OmDAO.getOmsByForcaAndEstadoDWR(idForca, idEstado);
        return oms;
    }
    public ArrayList<PostoGraduacao> getPGsByForcaExcetoCbSdDWR(int idForca) throws Throwable, Exception{
        ArrayList<PostoGraduacao> pgs = new ArrayList();
        pgs = PostoGraduacaoDAO.getPGsByForcaExcetoCbSdDWR(idForca);
        return pgs;
    }
    public ArrayList<PostoGraduacao> getPGsByForcaExcetoOfGenAndCbSdDWR(int idForca) throws Throwable, Exception{
        ArrayList<PostoGraduacao> pgs = new ArrayList();
        pgs = PostoGraduacaoDAO.getPGsByForcaExcetoOfGenAndCbSdDWR(idForca);
        return pgs;
    }
    public ArrayList<PostoGraduacao> getPGsByForcaDWR(int idForca) throws Throwable, Exception{
        ArrayList<PostoGraduacao> pgs = new ArrayList();
        pgs = PostoGraduacaoDAO.getPGsByForcaDWR(idForca);
        return pgs;
    }
    public ArrayList<PostoGraduacao> getPGsByForcaAndCatDWR(int idForca, int idCategoria) throws Throwable, Exception{
        ArrayList<PostoGraduacao> pgs = new ArrayList();
        pgs = PostoGraduacaoDAO.getPGsByForcaAndCatDWR(idForca, idCategoria);
        return pgs;
    }
    public Om getOmByIdDWR(int idOM) throws Throwable, Exception{
        Om om = OmDAO.getOmByIdDWR(idOM);
        return om;
    }
    public ArrayList<QasQms> getQasQmsDWR() throws Throwable, Exception{
        ArrayList<QasQms> qasqms = new ArrayList();
        qasqms = QasQmsDAO.getQasQmsDWR();
        return qasqms;
    }
    
    //Estado, Cidade
    public ArrayList<Estado> getEstadosDWR() throws Throwable, Exception{
        ArrayList<Estado> estados = new ArrayList();
        estados = EstadoDAO.getEstadosDWR();
        return estados;
    }public ArrayList<Cidade> getCidadesByEstadoDWR(int idEstado) throws Throwable, Exception{
        ArrayList<Cidade> cidades = new ArrayList();
        cidades = CidadeDAO.getCidadesByEstadoDWR(idEstado);
        return cidades;
    }
    
    //Estado Civil
    public ArrayList<EstadoCivil> getEstadosCivisDWR() throws Throwable, Exception{
        ArrayList<EstadoCivil> ecs = new ArrayList();
        ecs = EstadoCivilDAO.getEstadosCivisDWR();
        return ecs;
    }
    
    //Escola Formação
    public ArrayList<EscolaFormacao> getEscolasFormacaoByForcaDWR(int idForca) throws Throwable, Exception{
        ArrayList<EscolaFormacao> escolas = new ArrayList();
        escolas = EscolaFormacaoDAO.getEscolasFormacaoByForcaDWR(idForca);
        return escolas;
    }
    
    //Comportamentos
    public ArrayList<Comportamento> getComportamentosDWR() throws Throwable, Exception{
        ArrayList<Comportamento> comportamentos = new ArrayList();
        comportamentos = ComportamentoDAO.getComportamentosDWR();
        return comportamentos;
    }
    
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
    
    //Aluno
    public Aluno getAlunoByIdentidadeDWR(String idtAluno) throws Throwable, Exception{
        Aluno al = AlunoDAO.getAlunoByIdentidadeDWR(idtAluno);
        return al;
    }
}
