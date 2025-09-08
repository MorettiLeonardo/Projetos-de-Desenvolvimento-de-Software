package Entities;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {
    private float saldo;
    private List<Produto> carrinho = new ArrayList<>();
    private List<Pedido> pedidos = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public Cliente(String nome, String email, float saldo) {
        super(nome, email);
        this.saldo = saldo;
    }

    public float getSaldo() {
        return saldo;
    }

    public void fazerDeposito(float valor) {
        try {
            if (valor <= 0) {
                throw new IllegalArgumentException("Valor inválido para depósito.");
            }
            this.saldo += valor;
            System.out.println("Depósito realizado com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void adicionarProdutoAoCarrinho(Produto produto) {
        carrinho.add(produto);
        System.out.println("Produto adicionado ao carrinho com sucesso!");
    }

    public void mostrarProdutosNoCarrinho() {
        for (Produto produto : carrinho) {
            System.out.println("Produto: " + produto.getNome());
            System.out.println("Preço: " + produto.getPreco());
        }
    }

    public void realizarPedido() {
        Pedido novoPedido = new Pedido();
        novoPedido.realizarPedido(carrinho);
        pedidos.add(novoPedido);
        carrinho.clear();
        System.out.println("Id do seu pedido: " + novoPedido.getId());
    }

    public Pedido buscarPedidoPorId(String idPedido) {
        for (Pedido pedido : pedidos) {
            if (pedido.getId().equals(idPedido)) {
                return pedido;
            }
        }
        return null;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Cliente: " + getNome());
        System.out.println("Email: " + getEmail());
        System.out.println("Saldo: R$ " + saldo);
    }

    public void realizarPagamentoDoPedido() {
        System.out.print("Digite o ID do pedido para realizar o pagamento: ");
        String idPedido = scanner.nextLine();
        Pedido pedido = buscarPedidoPorId(idPedido);
        if (pedido == null) {
            System.out.println("Pedido não encontrado.");
            return;
        }

        if (pedido.isPedidoPago()) {
            System.out.println("Pedido já foi pago.");
            return;
        }

        if (saldo < pedido.getValorDoPedido()) {
            System.out.println("Saldo insuficiente.");
            return;
        }

        System.out.println("Pedido pago com sucesso!");
        saldo -= pedido.getValorDoPedido();
    }
}
