/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author andersondepaula
 */
public class Assunto {
    String codigo, nome, codigoDisciplina;
    int ch_diurna, ch_noturna;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigoDisciplina() {
        return codigoDisciplina;
    }

    public void setCodigoDisciplina(String codigoDisciplina) {
        this.codigoDisciplina = codigoDisciplina;
    }

    public int getCh_diurna() {
        return ch_diurna;
    }

    public void setCh_diurna(int ch_diurna) {
        this.ch_diurna = ch_diurna;
    }

    public int getCh_noturna() {
        return ch_noturna;
    }

    public void setCh_noturna(int ch_noturna) {
        this.ch_noturna = ch_noturna;
    }  
}
