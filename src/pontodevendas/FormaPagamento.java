/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pontodevendas;

/**
 *
 * @author Pedro Dias
 */
public class FormaPagamento {
    private boolean isDinheiro;
    private String numCartao;

    public FormaPagamento() {
        this.isDinheiro = true;
    }
    
    public boolean obterFormaPagamento(){
        return isDinheiro;
    }
    public String obterFormaPagamentoString(){
        if (isDinheiro) {
            return "Dinheiro";
        } else {
            return "Cartão: " + numCartao;
        }
    }
    public String obterNumCartao(){
        return numCartao;
    }
    public void alterarFormaPagamento(boolean isDinheiro){
        this.isDinheiro = isDinheiro;
    }
    public void alterarNumCartao(String numCartao){
        this.numCartao = numCartao;
    }
}
