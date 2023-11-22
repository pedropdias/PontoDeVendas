
package pontodevendas;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Pedro Dias
 */
public class ControladorVenda extends AbstractTableModel {
    private ArrayList<Venda> vendas;
    private ControladorItemVenda controladorItemVenda;
    private ControladorProduto controladorProduto;
    private FormaPagamento formaPagamento;

//    public ControladorVenda(ControladorItemVenda controladorItemVenda, ControladorProduto controladorProduto) {
    public ControladorVenda(ControladorProduto controladorProduto) {
        this.vendas = new ArrayList<Venda>();
        this.formaPagamento = new FormaPagamento(); // aqui a instancia
        this.controladorProduto = controladorProduto;
    }
    
    //Tabela JanelaVendas
    private static final int COLUNA_DATA = 0;
    private static final int COLUNA_HORA = 1;
    private static final int COLUNA_VALOR = 2;
    private static final int COLUNA_FORMAPAGAMENTO = 3;
    private String[] colunas = new String[]{"Data","Hora","Valor","Forma de Pagamento"};
    //
    
    private static final String PATTERN_TIME = "HH:mm:ss";
    
    
    
    @Override
    public int getColumnCount(){
    return colunas.length;
    }
    
    @Override
    public int getRowCount(){
    return vendas.size();
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
    Venda venda = vendas.get(row);
    DecimalFormat decimalFormat = new DecimalFormat("0.##");
    DateTimeFormatter horaFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
    switch(col){
        case COLUNA_DATA:
            return venda.obterDataVenda();
        case COLUNA_HORA:
            return venda.obterHoraVenda().format(horaFormat);
        case COLUNA_VALOR:
            return decimalFormat.format(venda.obterValorTotalVenda());
        case COLUNA_FORMAPAGAMENTO:
            return venda.obterFormaPagamento() ? "Dinheiro" : "Cartão";
        }
        return ""; 
    }
    
    @Override
    public void setValueAt(Object aValue, int row, int column){
    Venda venda = vendas.get(row);
    switch(column){
        case COLUNA_DATA:
            String dataString = aValue.toString();
            try {
                LocalDate dataVenda = LocalDate.parse(dataString);
                venda.alterarDataVenda(dataVenda);
            } catch (DateTimeParseException e) {
                // Lidar com o caso em que a String não pode ser convertida para LocalDate
                System.out.println("Formato de data inválido: " + dataString);
            }
    break;
        case COLUNA_HORA:
            String horaString = aValue.toString();
            try {
                LocalTime horaVenda = LocalTime.parse(horaString);
                venda.alterarHoraVenda(horaVenda);
            } catch (DateTimeParseException e) {
                // Lidar com o caso em que a String não pode ser convertida para LocalTime
                System.out.println("Formato de hora inválido: " + horaString);
            }
            
        case COLUNA_VALOR:
            venda.alterarValorTotalVenda(Double.parseDouble(aValue.toString()));
            
        case COLUNA_FORMAPAGAMENTO:
            FormaPagamento formaPagamento = (FormaPagamento) aValue;

            if (formaPagamento != null) {
                if (formaPagamento.obterFormaPagamento()) { // Se for dinheiro
                    setValueAt("Dinheiro", row, column);
                } else {
                    setValueAt("Cartão", row, column);
                }
            }
            
            
        }
    }
    
    
    public Venda obterVenda(int indice){
        return vendas.get(indice);
    }
    public void incluirVenda(Venda venda){
        vendas.add(venda);
        int ultimo = getRowCount()-1;
        fireTableRowsInserted(ultimo, ultimo);
    }
    public void alterarVenda(int indice, Venda venda){
        vendas.set(indice, venda);
        fireTableRowsUpdated(indice, indice);
    }
    public void removerVenda(int indice){
        vendas.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }

    

    
    public void adicionarItemVenda(Venda venda, int numeroItem, int codigoProduto, int qntVenda) {;
        ArrayList<ItemVenda> auxItensVenda = venda.obterItensVenda();
        ItemVenda auxItem = new ItemVenda();
        
        Produto auxProduto = controladorProduto.obterProdutoPorCodigo(codigoProduto);
        
        auxItem.alterarCodigo(codigoProduto);
        auxItem.alterarNumeroItem(numeroItem);
        auxItem.alterarQntVenda(qntVenda);
        auxItem.alterarPrecoProduto(auxProduto.obterPreco());
        auxItem.alterarItemTotal(0.0);
        
        auxItensVenda.add(auxItem);
        
        venda.alterarItensVenda(auxItensVenda);
        fireTableDataChanged();
    }

    public void removerItemVenda(Venda venda, int numeroItem) {
    }

    public void registrarVenda(Venda venda){//, FormaPagamento formaPagamento) {
        
        venda.alterarDataVenda(LocalDate.now());
        venda.alterarHoraVenda(LocalTime.now());
        registrarFormaPagamento(venda, formaPagamento);
        vendas.add(venda);
    }

    public Venda consultarVenda(int indice) {
        if (indice >= 0 && indice < vendas.size()) {
            return vendas.get(indice);
        } else {
            return null;
        }
    }

    public void registrarFormaPagamento(Venda venda, FormaPagamento formaPagamentot) {
        venda.alterarFormaPagamento(formaPagamentot.obterFormaPagamento());
        venda.alterarNumCartao(formaPagamentot.obterNumCartao());
    }
}
