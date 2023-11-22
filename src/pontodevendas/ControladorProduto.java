
package pontodevendas;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import java.util.Date;

/**
 *
 * @author Pedro Dias
 */
public class ControladorProduto extends AbstractTableModel {
    
    private static final int COLUNA_NOME = 0;
    private static final int COLUNA_CODIGO = 1;
    private static final int COLUNA_UNIDADE = 2;
    private static final int COLUNA_PRECO = 3;
    private static final int COLUNA_QNT_ESTOQUE = 4;
    private static final int COLUNA_DATA_ULTIMA_VENDA = 5;
    
    private String[] colunas = new String[]{"Nome", "Codigo", "Unidade", "Preco", "Estoque", "Ultima Venda"};
    private ArrayList<Produto> produtos;
    
    public ControladorProduto(){
        this.produtos = new ArrayList<Produto>();
    }
    
    @Override
    public int getColumnCount(){
        return colunas.length;
    }
    
    @Override
    public int getRowCount(){
        return produtos.size();
    }
    
    @Override
    public String getColumnName(int columnIndex){
        return colunas[columnIndex];
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return false;
    }
    
    @Override
    public Object getValueAt(int row, int col){
        Produto produto = produtos.get(row);
        DecimalFormat decimalFormat = new DecimalFormat("0.##");
        switch(col){
            case COLUNA_NOME:
                return produto.obterNome();
            case COLUNA_CODIGO:
                return produto.obterCodigo();
            case COLUNA_UNIDADE:
                return produto.obterUnidade();
            case COLUNA_PRECO:
                return decimalFormat.format(produto.obterPreco());
            case COLUNA_QNT_ESTOQUE:
                return produto.obterQntEstoque();
            case COLUNA_DATA_ULTIMA_VENDA:
                return produto.obterDataUltimaVenda();
        }
        return "";
    }
    
    @Override
    public void setValueAt(Object aValue, int row, int column){
        Produto produto = produtos.get(row);
        switch(column){
            case COLUNA_NOME:
                produto.alterarNome(aValue.toString());
            case COLUNA_CODIGO:
                produto.alterarCodigo(Integer.parseInt(aValue.toString()));
            case COLUNA_UNIDADE:
                produto.alterarUnidade(aValue.toString());
            case COLUNA_PRECO:
                produto.alterarPreco(Double.parseDouble(aValue.toString()));
            case COLUNA_QNT_ESTOQUE:
                produto.alterarQntEstoque(Integer.parseInt(aValue.toString()));
            case COLUNA_DATA_ULTIMA_VENDA:
                if (aValue instanceof String) {
                String novaDataString = (String) aValue;

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    Date novaData = dateFormat.parse(novaDataString);
                    produto.alterarDataUltimaVenda(novaData);
                } catch (ParseException e) {
                
                }
            }
        }
    }
    
    
      
      public Produto obterProduto(int indice){
          return produtos.get(indice);
      }
      
      public void incluirProduto(Produto produto){
          produtos.add(produto);
          int ultimo = getRowCount()-1;
          fireTableRowsInserted(ultimo, ultimo);
      }
      
      public void removerProduto(int indice){
          produtos.remove(indice);
          fireTableRowsDeleted(indice, indice);
      }
      
      public void alterarProduto(int indice, Produto produto){
          produtos.set(indice, produto);
          fireTableRowsUpdated(indice, indice);
      }
      
      public Produto obterProdutoPorCodigo(int codigo) {
        for (Produto produto : produtos) {
            if (produto.obterCodigo() == codigo) {
//                System.out.println(produto.obterNome());
                return produto;
            }
        }
        return null;
    }
//    
//    public String consultarProdutoByCodigo(int codigo){
//        Produto produto = null;
//        for (int i = 0; i < produtos.size(); i++){
//            if(produtos.get(i).obterCodigo() == codigo){
//                produto = produtos.get(i);
//                break;
//            }
//        } return produto.obterNome();
//    }
//    
//    public ArrayList obterListaProdutos(){
//        for (Produto produto: produtos) {
//            
//        }
//        return 
//    }


}
