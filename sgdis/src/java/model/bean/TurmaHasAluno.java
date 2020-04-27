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
public class TurmaHasAluno {
    int idTurma, idTentativa;
    String idtAluno;

    public int getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }

    public int getIdTentativa() {
        return idTentativa;
    }

    public void setIdTentativa(int idTentativa) {
        this.idTentativa = idTentativa;
    }

    public String getIdtAluno() {
        return idtAluno;
    }

    public void setIdtAluno(String idtAluno) {
        this.idtAluno = idtAluno;
    }   
}
