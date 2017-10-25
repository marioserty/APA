/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp_apa;

import com.sun.javafx.geom.AreaOp;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

/**
 *
 * @author Mário
 */
public class TSP_APA {

    /**
     * @param args the command line arguments
     * Classe principal para problema do caixeiro viajante
     * obs:Solução Otima = 25395
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileReader file = new FileReader("brazil58.tsp");
        Grafo grafo = new Grafo(file);
        
        int[] sd = new int[100];
            
        for(int x = 0; x < 100; x++){
            Grupo g = new Grupo(58);
            for (int i = 0; i < 300_000; i++) {                
                g.random();
                if (g.pontuacao(g.getGrupoAtual()) < g.pontuacao(g.getMelhorGrupo())) {
                    g.achouMelhor();
                    System.out.println("Melhor: " + g.pontuacao(g.getMelhorGrupo()));
                } else {
                    g.achouPior();
                }
            }
            g.printGrupo(g.getMelhorGrupo());
            sd[x] = g.pontuacao(g.getMelhorGrupo());
        }
        
        for (int i = 0; i < sd.length; i++) {
            System.out.print(sd[i]+", ");
        }
        

    }
    
}
