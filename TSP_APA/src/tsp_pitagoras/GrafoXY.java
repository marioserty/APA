/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp_pitagoras;

/**
 *
 * @author Mário
 */
public class GrafoXY {
    public static int[][] cidades = new int[100][2];
    
    public GrafoXY(){
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 2; j++) {
                cidades[i][j] = (int)(Math.random() * 500);
            }
        }
    }
    
    public int checkX(int cidade){
        return cidades[cidade][0];
    }
    
    public int checkY(int cidade){
        return cidades[cidade][1];
    }
    
}
