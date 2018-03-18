package com.example.lorealerick.a611.Models;

/**
 * Created by LoreAleRick on 18/03/2018.
 */

public class ModelBirthday {

    String nome;
    String data;

    public ModelBirthday(String nome, String data) {
        this.nome = nome;
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
