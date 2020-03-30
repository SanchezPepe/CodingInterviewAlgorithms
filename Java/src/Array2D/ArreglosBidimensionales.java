/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Array2D;

/**
 *
 * @author hca
 */
public class ArreglosBidimensionales {
    
    public static int sumaRen(int arre[][], int ren, int tCol){
        int suma = 0;
        for(int col = 0; col < tCol; col++)
            suma = suma + arre[ren][col];
        return suma;
    }
    
    public static int sumaCol(int arre[][], int col, int tRen){
        int suma = 0;
        for(int ren = 0; ren < tRen; ren++)
            suma = suma + arre[ren][col];
        return suma;
    }
    
    public static int sumaDiagP(int arre[][], int tam){
        int suma = 0;
        for(int i = 0; i < tam; i++)
            suma = suma + arre[i][i];
        return suma;
    }
    
    
    
    //MÉTODOS RECURSIVOS
    public static int sumaRenRec(int arre[][], int ren, int tCol){
        if(tCol == 0)
            return 0;
        else
            return arre[ren][tCol+1] + sumaRenRec(arre, ren, tCol-1);
    }
    
    public static int sumaDiagPRec(int arre[][], int tam){
        if(tam == 0)
            return 0;
        else
            return arre[tam-1][tam-1] + sumaDiagPRec(arre, tam-1);
    }
    
    public static int sumaD(int arre[][], int tam){
        if(tam == 0)
            return 0;
        else
            return arre[tam-1][tam-1] + sumaD(arre, tam-1);
    }
    
    public static int sumDiagSec(int arre[][], int tam){
        return sumDiagSec(arre, tam, 0);
    }
    
    private static int sumDiagSec(int arre[][], int tam, int tam2){
        if(tam == 0)
            return 0;
        else{
            return arre[tam-1][tam2] + sumDiagSec(arre, tam-1, tam2+1);
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
