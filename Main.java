import Entities.Cliente;
import Entities.Produto;

public class Main {

    public static void main(String[] args) {
        Cliente c = new Cliente("Leoanrdoi", "leonardo@gmail.conm", 1000);
        Produto iphone = new Produto("Iphone", 600);
        Produto mesa = new Produto("Mesa", 600);

        c.adicionarProdutoAoCarrinho(iphone);
        c.adicionarProdutoAoCarrinho(mesa);
        c.mostrarProdutosNoCarrinho();
        c.realizarPedido();
        c.realizarPagamentoDoPedido();
        c.fazerDeposito(1000);
        c.realizarPagamentoDoPedido();
    }
}