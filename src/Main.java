public class Main {
    public static void main(String[] args) {
        // Criando o estoque e carregando produtos
        EstoqueProdutos estoque = new EstoqueProdutos();
        estoque.carregarProdutos();

        // Criando produtos
        Produto produto1 = new Produto(1, 23.0, "Limpeza");
        Produto produto2 = new Produto(2, 1543.0, "Eletrônico");

        // Criando itens do pedido
        ItemPedido item1 = new ItemPedido(2, produto1);
        ItemPedido item2 = new ItemPedido(1, produto2);

        // Criando pedido
        Pedido pedido = new Pedido();

        // Adicionando itens ao pedido verificando o estoque
        pedido.adicionarItem(item1, estoque);
        pedido.adicionarItem(item2, estoque);

        // Imprimindo cupom fiscal
        pedido.cupomFiscal();

        // Exibindo o estoque restante
        System.out.println("Estoque após o pedido:");
        for (Object p : estoque.verEstoque()) {
            System.out.println(p);
        }
    }
}
