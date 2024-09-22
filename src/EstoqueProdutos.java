import java.util.ArrayList;
import java.util.List;

public class EstoqueProdutos implements Estoque{

    private List<ItemEstoque> listaEstoque = new ArrayList<>();

    @Override
    public void carregarProdutos() {
        Produto produto1 = new Produto(1, 23.0, "Limpeza");
        Produto produto2 = new Produto(2, 62.0, "Eletronico");

        listaEstoque.add(new ItemEstoque(produto1, 100));
        listaEstoque.add(new ItemEstoque(produto2, 50));
    }

    @Override
    public boolean remover(int id, int quantidade) {
        for(ItemEstoque item : listaEstoque){
            if(item.getProduto().getCodigo() == id){
                if(item.getQuantidade() >= quantidade){
                    item.setQuantidade(item.getQuantidade() - quantidade);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public List<ItemEstoque> verEstoque() {
        return listaEstoque;
    }

    class ItemEstoque {
        private Produto produto;
        private int quantidade;

        public ItemEstoque(Produto produto, int quantidade) {
            this.produto = produto;
            this.quantidade = quantidade;
        }

        public Produto getProduto(){
            return produto;
        }

        public int getQuantidade(){
            return quantidade;
        }

        public void setQuantidade(int quantidade){
            this.quantidade = quantidade;
        }

        @Override
        public String toString() {
            return "Produto: codigo=" + produto.getCodigo() + ", preco=" + produto.getPreco() +
                    ", categoria=" + produto.getCategoria() + ", quantidade=" + quantidade;
        }

    }

}
