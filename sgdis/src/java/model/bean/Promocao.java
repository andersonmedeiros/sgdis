/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.sql.Date;

/**
 *
 * @author anderson
 */
public class Promocao {
    int id;
    Date dataultpromocao, dataqapromocao;
    String qapromocao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataultpromocao() {
        return dataultpromocao;
    }

    public void setDataultpromocao(Date dataultpromocao) {
        this.dataultpromocao = dataultpromocao;
    }

    public Date getDataqapromocao() {
        return dataqapromocao;
    }

    public void setDataqapromocao(Date dataqapromocao) {
        this.dataqapromocao = dataqapromocao;
    }

    public String getQapromocao() {
        return qapromocao;
    }

    public void setQapromocao(String qapromocao) {
        this.qapromocao = qapromocao;
    }
}
