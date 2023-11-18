
package pontodevendas;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Pedro Dias
 */
public class ControladorItemVenda extends AbstractTableModel {
    
    //Tabela JanelaCadastroVenda
    private static final int COLUNA_NUMEROITEM = 0;
    private static final int COLUNA_CODIGO = 1;
    private static final int COLUNA_QNTVENDA = 2;
    private static final int COLUNA_PRECOPRODUTO = 3;
    private static final int COLUNA_ITEMTOTAL = 4;
   
    private String[] colunas = new String[]{"Número item","Código","Quantidade","Preço do Produto","Total do item"};
    private ArrayList<ItemVenda> itensVenda;

    public ControladorItemVenda() {
        this.itensVenda = new ArrayList<>();
    }
    
    
    @Override
    public int getColumnCount(){
    return colunas.length;
    }
    
    @Override
    public int getRowCount(){
    return itensVenda.size();
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
        ItemVenda itemVenda = itensVenda.get(row);
        switch(col){
            case COLUNA_NUMEROITEM:
                return itemVenda.obterNumeroItem();
            case COLUNA_CODIGO:
                return itemVenda.obterCodigo();
            case COLUNA_QNTVENDA:
                return itemVenda.obterQntVenda();
            case COLUNA_PRECOPRODUTO:
                return itemVenda.obterPrecoProduto();
            case COLUNA_ITEMTOTAL:
                return itemVenda.obterItemTotal();              
        }
        return ""; 
    }
    
    @Override
        public void setValueAt(Object aValue, int row, int column){
        ItemVenda itemVenda = itensVenda.get(row);
        switch(column){
            case COLUNA_NUMEROITEM:
                itemVenda.alterarNumeroItem(Integer.parseInt(aValue.toString()));
                break;
            case COLUNA_CODIGO:
                itemVenda.alterarCodigo(Integer.parseInt(aValue.toString()));
                break;
            case COLUNA_QNTVENDA:
                itemVenda.alterarQntVenda(Integer.parseInt(aValue.toString()));
                break;
            case COLUNA_PRECOPRODUTO:
                itemVenda.alterarPrecoProduto(Double.parseDouble(aValue.toString()));
                break;
            case COLUNA_ITEMTOTAL:
                itemVenda.alterarItemTotal(Double.parseDouble(aValue.toString()));
                break;
        }
    }
        
    //métodos para tabela
    public ItemVenda obterItemVendaTabela(int indice){
        return itensVenda.get(indice);
    }
    
    public void incluirItemVendaTabela(ItemVenda itemVenda){
        itensVenda.add(itemVenda);
        int ultimo = getRowCount()-1;
        fireTableRowsInserted(ultimo, ultimo);
    }
    
    public void alterarItemVendaTabela(int indice, ItemVenda itemVenda){
        itensVenda.set(indice, itemVenda);
        fireTableRowsUpdated(indice, indice);
    }
    
    public void removerItemVendaTabela(int indice){
        itensVenda.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }
    
    public void limparItensVendaTabela() {
        itensVenda.clear();
        fireTableDataChanged(); // Notifica a tabela sobre as mudanças
    }
    //

        
    public void incluirItemVenda(int numeroItem, int codigoProduto, int qntVenda, ControladorProduto controladorProduto) {
        Produto produto = controladorProduto.obterProdutoPorCodigo(codigoProduto);

        if (produto != null) {
            double precoProduto = produto.obterPreco();
            double itemTotal = precoProduto * qntVenda;

            ItemVenda itemVenda = new ItemVenda();
            itemVenda.alterarNumeroItem(numeroItem);
            itemVenda.alterarCodigo(codigoProduto);
            itemVenda.alterarQntVenda(qntVenda);
            itemVenda.alterarPrecoProduto(precoProduto);
            itemVenda.alterarItemTotal(itemTotal);

            itensVenda.add(itemVenda);
        } else {
            System.out.println("Produto não encontrado.");
        }
    }
    
    public void removerItemVenda(int numeroItem){
        for (int i = 0; i < itensVenda.size(); i++) {
            if (itensVenda.get(i).obterNumeroItem() == numeroItem) {
                itensVenda.remove(i);
                break;
            }
        }
    }
    
    public void limparItensVenda(){
        for (int i = 0; i < itensVenda.size(); i++) {
                itensVenda.remove(i);

        }
    }
    
    public ItemVenda obterItemVenda(int numeroItem) {
        for (ItemVenda item : itensVenda) {
            if (item.obterNumeroItem() == numeroItem) {
                System.out.println(item.obterItemTotal());
                return item;
            }
        }
        return null;
    }
    
    public ArrayList<ItemVenda> obterItensVenda() {
        return itensVenda;
    }
    
//    public void alterarItemVenda(int indiceItemVenda, ItemVenda itemVenda){
//        itensVenda.set(indiceItemVenda, itemVenda);
//    }
//    
//    public void consultarItemVenda(int codigo){
//        ItemVenda itemVenda = null;
//        for (int i = 0; i < itensVenda.size(); i++){
//            if(itensVenda.get(i).obterCodigo() == codigo){
//                itemVenda = itensVenda.get(i);
//                break;
//            }
//        }
//    }
}
