
package pontodevendas;

import java.util.Date;

/**
 *
 * @author Pedro Dias
 */
public class Produto {
    private int codigo;
    private String nome;
    private String unidade;
    private double preco;
    private int qntEstoque;
    private Date dataUltimaVenda;
    
    public int obterCodigo(){
        return codigo;
    }
    public String obterNome(){
        return nome;
    }
    public String obterUnidade(){
        return unidade;
    }
    public double obterPreco(){
        return preco;
    }
    public int obterQntEstoque(){
        return qntEstoque;
    }
    public Date obterDataUltimaVenda(){
        return dataUltimaVenda;
    }
    
    public void alterarCodigo(int codigo){
        this.codigo = codigo;
    }
    public void alterarNome(String nome){
        this.nome = nome;
    }
    public void alterarUnidade(String unidade){
        this.unidade = unidade;
    }
    public void alterarPreco(double preco){
        this.preco = preco;
    }
    public void alterarQntEstoque(int qntEstoque){
        this.qntEstoque = qntEstoque;
    }
    public void alterarDataUltimaVenda(Date dataUltimaVenda){
        this.dataUltimaVenda = dataUltimaVenda;
    }
    
}
