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
public class Taf {
    int id;
    Date dataUltTaf;
    String mencao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataUltTaf() {
        return dataUltTaf;
    }

    public void setDataUltTaf(Date dataUltTaf) {
        this.dataUltTaf = dataUltTaf;
    }

    public String getMencao() {
        return mencao;
    }

    public void setMencao(String mencao) {
        this.mencao = mencao;
    }
}
