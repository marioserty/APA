/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp_apa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Mário
 * Classe de leitura
 * Representação do Grafo: Matriz de Adjacência
 */
public class Grafo {
    
    public static int mat[][] = new int[58][58];
    
    public Grafo(FileReader arquivo) throws IOException {
                
        BufferedReader leitor = new BufferedReader(arquivo);        
        
        //Lê cada linha da instância de entrada;
        for (int i = 0; leitor.ready(); i++) {
            
            //Lê cada valor das colunas;
            String[] linha = leitor.readLine().split(" ");            
            
            for (int j = 1 + i, k = 0; j < linha.length + i + 1; j++, k++) {
                this.mat[j][i] = this.mat[i][j] = Integer.valueOf(linha[k]);
            }
        }
    }

    public int getMat(int i, int j) {
        return mat[i][j];
    }

    public void setMat(int[][] mat) {
        this.mat = mat;
    }
    
    public void printMat(){
        for (int i = 0; i < 58; i++) {
            for (int j = 0; j < 58; j++) {
                System.out.print(" " + this.mat[i][j]);
            }
            System.out.println("");
        }
    }
    
}