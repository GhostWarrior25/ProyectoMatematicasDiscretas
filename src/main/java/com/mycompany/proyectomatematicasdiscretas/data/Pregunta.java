/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectomatematicasdiscretas.data;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author luidbrav
 */
public class Pregunta implements Serializable {
    private String enunciado;
    private ArrayList<String> alternativas;
    private String opcionCorrecta;
    private String dificultad;
    private String tema;

    
    public Pregunta(String enunciado, ArrayList<String> alternativas, String opcionCorrecta, String dificultad, String tema){
       this.enunciado= enunciado;
       this.alternativas = alternativas;
       this.opcionCorrecta = opcionCorrecta;
       this.dificultad = dificultad;
       this.tema = tema;
    }

    /**
     * @return the enunciado
     */
    public String getEnunciado() {
        return enunciado;
    }

    /**
     * @param enunciado the enunciado to set
     */
    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    /**
     * @return the alternativas
     */
    public ArrayList<String> getAlternativas() {
        return alternativas;
    }

    /**
     * @param alternativas the alternativas to set
     */
    public void setAlternativas(ArrayList<String> alternativas) {
        this.alternativas = alternativas;
    }

    /**
     * @return the opcionCorrecta
     */
    public String getOpcionCorrecta() {
        return opcionCorrecta;
    }

    /**
     * @param opcionCorrecta the opcionCorrecta to set
     */
    public void setOpcionCorrecta(String opcionCorrecta) {
        this.opcionCorrecta = opcionCorrecta;
    }





    /**
     * @return the dificultad
     */
    public String getDificultad() {
        return dificultad;
    }

    /**
     * @param dificultad the dificultad to set
     */
    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    /**
     * @return the tema
     */
    public String getTema() {
        return tema;
    }

    /**
     * @param tema the tema to set
     */
    public void setTema(String tema) {
        this.tema = tema;
    }
    
}
