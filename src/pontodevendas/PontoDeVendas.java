
package pontodevendas;

/**
 *
 * @author Pedro Dias
 */
public class PontoDeVendas {

    public static void main(String[] args) {
        
//          JanelaProdutos quadroDialogo = new JanelaProdutos(null, true);
//          quadroDialogo.setLocationRelativeTo(null);
//          quadroDialogo.setVisible(true);
        
        Produto coquinha = new Produto();
        Produto batatinha = new Produto();
        java.util.Date date=new java.util.Date();  
        coquinha.alterarCodigo(1234);
        coquinha.alterarNome("Coca-Cola");
        coquinha.alterarPreco(5.99);
        coquinha.alterarQntEstoque(12);
        coquinha.alterarDataUltimaVenda(date);
        batatinha.alterarCodigo(4321);
        batatinha.alterarNome("Batata");
        batatinha.alterarPreco(7.99);
        batatinha.alterarQntEstoque(25);
        batatinha.alterarDataUltimaVenda(date);
        
        System.out.println(coquinha.obterCodigo());
        System.out.println(coquinha.obterPreco());
        System.out.println(coquinha.obterQntEstoque());
        System.out.println(coquinha.obterDataUltimaVenda());
        System.out.println(batatinha.obterCodigo());
        System.out.println(batatinha.obterPreco());
        System.out.println(batatinha.obterQntEstoque());
        System.out.println(batatinha.obterDataUltimaVenda());
        
        ControladorProduto controladorProduto = new ControladorProduto();
        
        controladorProduto.incluirProduto(batatinha);
        controladorProduto.incluirProduto(coquinha);
        System.out.println(controladorProduto.obterProdutoPorCodigo(4321));
        
        ControladorItemVenda controladorItemVenda = new ControladorItemVenda();
        
        controladorItemVenda.incluirItemVenda(47, 1234, 4, controladorProduto);
        
        System.out.println(controladorItemVenda.obterItemVenda(47));
        
        ControladorVenda controladorVenda = new ControladorVenda(controladorItemVenda, controladorProduto);
        Venda venda = new Venda();
        controladorVenda.adicionarItemVenda(venda, 47, 1234, 5);
        controladorVenda.registrarVenda(venda);
        
        System.out.println(venda.obterDataVenda());
        System.out.println(venda.obterHoraVenda());
        System.out.println(venda.obterValorTotalVenda());
        System.out.println(venda.obterItensVenda());
        
        
        Produto produto = new Produto();
        produto.alterarCodigo(1234);
        produto.alterarNome("Coca-Cola");
        produto.alterarPreco(5.99);
        produto.alterarQntEstoque(12);
        produto.alterarDataUltimaVenda(date);
        
        
        
        FormaPagamento formaPagamento = new FormaPagamento();
        controladorVenda.registrarFormaPagamento(venda, formaPagamento);
        
//        JanelaVendas janelaVendas = new JanelaVendas(null, true);
//        janelaVendas.setLocationRelativeTo(null);
//        janelaVendas.setVisible(true);

          JanelaCadastroVenda janelaCadastroVenda = new JanelaCadastroVenda(null, true);
          janelaCadastroVenda.setLocationRelativeTo(null);
          janelaCadastroVenda.setVisible(true);
        
    }
    
}
