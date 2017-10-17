/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp_apa;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author Mário
 */
public class Grupo {
    private LinkedList<Integer> grupoAtual = new LinkedList<Integer>();
    private LinkedList<Integer> melhorGrupo = new LinkedList<Integer>();
    
    public Grupo(){
        for (int i = 0; i < 58; i++) {
            this.grupoAtual.add(i);
            this.melhorGrupo.add(i);
            
        }
    }
    
    public void swap(){
        Random r = new Random();
        int i = r.nextInt(58);
        int j = r.nextInt(58);
        
        while (i == j) {
            j = r.nextInt(58);
        }
        int aux = grupoAtual.get(i);
        this.grupoAtual.set(i, grupoAtual.get(j));
        this.grupoAtual.set(j, aux);
    }
    
    public void insertion(){
        Random r = new Random();
        int i = r.nextInt(58);
        int j = r.nextInt(58);       
        
        while (i == j) {
            j = r.nextInt(58);
        }
        
        int aux = this.grupoAtual.get(i);
        this.grupoAtual.remove(i);
        this.grupoAtual.add(j, aux);
    }
    
    public void inversion(){
        LinkedList<Integer> inv = new LinkedList<Integer>();
        Random r = new Random();
        int i = r.nextInt(58);
        int j = r.nextInt(58);
        
        while (i == j) {
            j = r.nextInt(58);
        }
        
        if (j < i) {
            int aux = i;
            i = j;
            j = aux;
        }
        
        //System.out.println("Inicio:" + i + " Fim: " + j);
        
        for (int k = j; k >= i; k--) {
            inv.add(grupoAtual.get(k));
        }
        
        for (int k = i, l = 0; k <= j; k++, l++) {
            grupoAtual.set(k, inv.get(l));
        }
        
    }
    
    public void shuffle(){
        LinkedList<Integer> inv = new LinkedList<Integer>();
        Random r = new Random();
        int i = r.nextInt(58);
        int j = r.nextInt(58);
        
        while (i == j) {
            j = r.nextInt(58);
        }
        
        if (j < i) {
            int aux = i;
            i = j;
            j = aux;
        }
        
        for (int k = i; k <= j; k++) {
            inv.add(grupoAtual.get(k));
        }
        
        Collections.shuffle(inv);
        
        for (int k = i, l = 0; k <= j; k++, l++) {
            grupoAtual.set(k, inv.get(l));
        }
    }
    
    public void random(){
        Random r = new Random();
        int i = r.nextInt(4);
        
        switch(i){
            case 0:
                swap();
                break;
            case 1:
                insertion();
                break;
            case 2:
                inversion();
                break;
            case 3:
                shuffle();
                break;
        }
        
    }
    
    public void achouMelhor(){
        melhorGrupo.clear();
        for (int i = 0; i < grupoAtual.size(); i++) {
            melhorGrupo.add(i);
            melhorGrupo.set(i, grupoAtual.get(i));
        }
    }
    
    public void achouPior(){
        grupoAtual.clear();
        for (int i = 0; i < melhorGrupo.size(); i++) {
            grupoAtual.add(i);
            grupoAtual.set(i, melhorGrupo.get(i));
        }
    }
    
    public int pontuacao(LinkedList<Integer> g){
        int pont = 0;
        for (int i = 0; i < g.size() - 1; i++) {
            pont = pont + Grafo.mat[g.get(i)][g.get(i+1)];
        }
        pont = pont + Grafo.mat[g.get(57)][g.get(0)];
        return pont;
    }
    
    public void printGrupo(LinkedList<Integer> g){
        String s = "[";
        for (int i = 0; i < 58; i++) {
            s = s + " " + g.get(i);
        }
        s = s + "]";
        System.out.println(s);
    }

    public LinkedList<Integer> getGrupoAtual() {
        return grupoAtual;
    }

    public void setGrupoAtual(LinkedList<Integer> grupoAtual) {
        this.grupoAtual = grupoAtual;
    }

    public LinkedList<Integer> getMelhorGrupo() {
        return melhorGrupo;
    }

    public void setMelhorGrupo(LinkedList<Integer> melhorGrupo) {
        this.melhorGrupo = melhorGrupo;
    }

}
