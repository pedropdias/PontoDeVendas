
package pontodevendas;

import java.time.LocalDate;
import java.time.LocalTime;
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
    private FormaPagamento formaPagamento = new FormaPagamento();

    public ControladorVenda(ControladorItemVenda controladorItemVenda, ControladorProduto controladorProduto) {
        this.vendas = new ArrayList<Venda>();
        this.controladorItemVenda = controladorItemVenda;
        this.controladorProduto = controladorProduto;
    }
    
    //Tabela JanelaVendas
    private static final int COLUNA_DATA = 0;
    private static final int COLUNA_HORA = 1;
    private static final int COLUNA_VALOR = 2;
    private static final int COLUNA_FORMAPAGAMENTO = 3;
    private String[] colunas = new String[]{"Data","Hora","Valor","Forma de Pagamento"};
    //
    
    
    
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
    switch(col){
        case COLUNA_DATA:
            return venda.obterDataVenda();
        case COLUNA_HORA:
            return venda.obterHoraVenda();
        case COLUNA_VALOR:
            return venda.obterValorTotalVenda();
        case COLUNA_FORMAPAGAMENTO:
            return venda.obterFormaPagamento();
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
            break;
        case COLUNA_VALOR:
            venda.alterarValorTotalVenda(Integer.parseInt(aValue.toString()));
            break;
        case COLUNA_FORMAPAGAMENTO:
            FormaPagamento formaPagamento = (FormaPagamento) aValue;

            if (formaPagamento != null) {
                if (formaPagamento.obterFormaPagamento()) { // Se for dinheiro
                    setValueAt("dinheiro", row, column);
                } else {
                    setValueAt(formaPagamento.obterNumCartao(), row, column);
                }
            }
            break;
            
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

    

    
    public void adicionarItemVenda(Venda venda, int numeroItem, int codigoProduto, int qntVenda) {
        controladorItemVenda.incluirItemVenda(numeroItem, codigoProduto, qntVenda, controladorProduto);
        atualizarValorTotalVenda(venda);
    }

    public void removerItemVenda(Venda venda, int numeroItem) {
        controladorItemVenda.removerItemVenda(numeroItem);
        atualizarValorTotalVenda(venda);
    }

    public void registrarVenda(Venda venda){//, FormaPagamento formaPagamento) {
        venda.alterarDataVenda(LocalDate.now());
        venda.alterarHoraVenda(LocalTime.now());
        venda.alterarItensVenda(controladorItemVenda.obterItensVenda());
        venda.alterarValorTotalVenda(calcularValorTotalVenda(venda));
        registrarFormaPagamento(venda, formaPagamento);
        vendas.add(venda);
        limparItensVenda(venda);
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
        venda.alterarNumCartao("2345");
    }

    public double calcularValorTotalVenda(Venda venda) {
        if(venda.obterItensVenda() == null){
            return 0.0;
        }
        double valorTotal = 0;
        for (ItemVenda item : venda.obterItensVenda()) {
            valorTotal += item.obterItemTotal();
        }
        return valorTotal;
    }

    public void atualizarValorTotalVenda(Venda venda) {
        venda.alterarValorTotalVenda(calcularValorTotalVenda(venda));
    }

    public void limparItensVenda(Venda venda) {
        controladorItemVenda.limparItensVenda();
    }
}
