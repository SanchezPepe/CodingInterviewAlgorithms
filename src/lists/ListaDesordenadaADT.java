/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lists;

/**
 *
 * @author hca
 */
public interface ListaDesordenadaADT <T> extends ListaADT <T>{
    
    public void agregaInicio();
    public void agregaFinal();
    public boolean agregaAntesQue();
    public boolean agregaDespuesQue();
    
}
