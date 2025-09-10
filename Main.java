import Entities.Cliente;
import Entities.Produto;

public class Main {
    public static void main(String[] args) {
        // Criar produtos
        Produto p1 = new Produto("Notebook", 3000);
        Produto p2 = new Produto("Mouse Gamer", 150);
        Produto p3 = new Produto("Teclado Mecânico", 350);

        // Criar cliente com saldo inicial
        Cliente cliente = new Cliente("Leonardo", "leo@email.com", 500);
        cliente.exibirInformacoes();

        // Cliente faz depósito
        cliente.fazerDeposito(3000);
        cliente.exibirInformacoes();

        // Adicionar produtos no carrinho
        cliente.adicionarProdutoAoCarrinho(p1);
        cliente.adicionarProdutoAoCarrinho(p2);
        cliente.adicionarProdutoAoCarrinho(p3);

        // Mostrar carrinho
        System.out.println("\n--- Produtos no carrinho ---");
        cliente.mostrarProdutosNoCarrinho();

        // Realizar pedido
        System.out.println("\n--- Realizando pedido ---");
        cliente.realizarPedido();

        // Realizar pagamento
        System.out.println("\n--- Pagando pedido ---");
        cliente.realizarPagamentoDoPedido();

        // Tentar pagar de novo (tratamento de já pago)
        System.out.println("\n--- Tentando pagar novamente ---");
        cliente.realizarPagamentoDoPedido();

        // Exibir informações finais do cliente
        System.out.println("\n--- Informações do cliente ---");
        cliente.exibirInformacoes();
    }
}
