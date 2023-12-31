
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
        if(itensVenda == null) {
            return 5.0;
        }
        double valor = 0;
        for (ItemVenda item : itensVenda) {
            valor += item.obterItemTotal();
        }
        
        return valor;
    }
    
    public ArrayList<ItemVenda> obterItensVenda(){
        if(itensVenda == null) {
            return new ArrayList<ItemVenda>();
        }
        return itensVenda;
    }
    public void alterarDataVenda(LocalDate dataVenda){
        this.dataVenda = dataVenda;
    }
    public void alterarHoraVenda(LocalTime horaVenda){
        this.horaVenda = horaVenda;
    }
    
    public void alterarValorTotalVenda(Double valorTotalVenda){
        this.valorTotalVenda = valorTotalVenda;
    }
    
    public void alterarItensVenda(ArrayList<ItemVenda> itensVenda){
        this.itensVenda = itensVenda;
    }
    
    public boolean obterFormaPagamento() {
       return formaPagamento.obterFormaPagamento();
    }
    
    public String obterFormaPagamentoString() {
       return formaPagamento.obterFormaPagamentoString();
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
