import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private double valorTotal;
    private List<ItemPedido> listaItemPedido = new ArrayList<>();

    public Pedido(double valorTotal, List<ItemPedido> listaItemPedido) {
        this.valorTotal = valorTotal;
        this.listaItemPedido = listaItemPedido;
    }

    public Pedido() {
    }

    public void adicionarItem(ItemPedido item, EstoqueProdutos estoque) {
        // Verifica se o estoque permite a remoção do produto na quantidade especificada
        if (estoque.remover(item.getProduto().getCodigo(), item.getQuantidade())) {
            listaItemPedido.add(item); // Adiciona o item no pedido
            calcularTotal(); // Recalcula o total do pedido
        } else {
            System.out.println("Produto não disponível no estoque ou quantidade insuficiente.");
        }
    }


    public double calcularTotal(){
        valorTotal = 0;
        // calculando o valor total dos items
        for (ItemPedido item : listaItemPedido){
            valorTotal += item.getProduto().getPreco() * item.getQuantidade();
        }
        return valorTotal;
    }

    public void cupomFiscal(){
        System.out.println("cupom fiscal: ");
        for(ItemPedido item : listaItemPedido){
            System.out.println("Produto: " + item.getProduto().getCategoria()
                    + " - Quantidade: " + item.getQuantidade()
                    + " - Preco: " + item.getProduto().getPreco());
        }
        System.out.println("Valor Total: " + valorTotal);
    }


}
