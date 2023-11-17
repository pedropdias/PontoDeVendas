/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pontodevendas;

/**
 *
 * @author Pedro Dias
 */
public class ItemVenda {
    private int numeroItem;
    private int codigo;
    private int qntVenda;
    private double precoProduto;
    private double itemTotal;
    
    public int obterNumeroItem(){
        return numeroItem;
    }
    public int obterCodigo(){
        return codigo;
    }
    public int obterQntVenda(){
        return qntVenda;
    }
    public double obterPrecoProduto(){
        return precoProduto;
    }
    public double obterItemTotal(){
        return itemTotal;
    }
    public void alterarNumeroItem(int numeroItem){
        this.numeroItem = numeroItem;
    }
    public void alterarCodigo(int codigo){
        this.codigo = codigo;
    }
    public void alterarQntVenda(int qntVenda){
        this.qntVenda = qntVenda;
    }
    public void alterarPrecoProduto(double precoProduto){
        this.precoProduto = precoProduto;
    }
    public void alterarItemTotal(double itemTotal){
        this.itemTotal = itemTotal;
    }
}
