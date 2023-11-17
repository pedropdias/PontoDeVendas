
package pontodevendas;

//import java.util.Date;
import java.time.LocalTime;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Pedro Dias
 */
public class Venda {
    private LocalDate dataVenda;
    private LocalTime horaVenda;
    private double valorTotalVenda;
    private ArrayList<ItemVenda> itensVenda;
    private FormaPagamento formaPagamento = new FormaPagamento();
    
    public LocalDate obterDataVenda(){
         return dataVenda;
    }
    public LocalTime obterHoraVenda(){
        return horaVenda;
    }
    public double obterValorTotalVenda(){
        return valorTotalVenda;
    }
    public ArrayList<ItemVenda> obterItensVenda(){
        return itensVenda;
    }
    public void alterarDataVenda(LocalDate dataVenda){
        this.dataVenda = dataVenda;
    }
    public void alterarHoraVenda(LocalTime horaVenda){
        this.horaVenda = horaVenda;
    }
    public void alterarValorTotalVenda(double valorTotalVenda){
        this.valorTotalVenda = valorTotalVenda;
    }
    public void alterarItensVenda(ArrayList<ItemVenda> itensVenda){
        this.itensVenda = itensVenda;
    }
    
    public boolean obterFormaPagamento() {
       return formaPagamento.obterFormaPagamento();
    }
    
    public String obterNumCartao(){
        return formaPagamento.obterNumCartao();
    }
    
    public void alterarNumCartao(String numCartao){
        formaPagamento.alterarNumCartao(numCartao);
    }
    
    public void alterarFormaPagamento(boolean isDinheiro) {
        formaPagamento.alterarFormaPagamento(isDinheiro);
    }
}
