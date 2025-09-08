package Entities;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import Enums.STATUS_PEDIDO;

public class Pedido {
    private final String id = UUID.randomUUID().toString();
    private final Date dataDoPedido = new Date();
    private STATUS_PEDIDO statusPedido = STATUS_PEDIDO.PENDENTE;
    private float valorDoPedido = 0;
    private boolean pedidoPago = false;

    public String getId() {
        return id;
    }

    public Date getDataDoPedido() {
        return dataDoPedido;
    }

    public float getValorDoPedido() {
        return valorDoPedido;
    }

    public STATUS_PEDIDO getStatusPedido() {
        return statusPedido;
    }

    public boolean isPedidoPago() {
        return pedidoPago;
    }

    public void realizarPedido(List<Produto> carrinho) {
        this.valorDoPedido = somarValorDoCarrinho(carrinho);
        System.out.println("Pedido realizado com sucesso. Agora faça o pagamento!");
        System.out.println("Valor total do pedido: " + this.valorDoPedido);
    }

    private float somarValorDoCarrinho(List<Produto> carrinho) {
        float total = 0;
        for (Produto produto : carrinho) {
            total += produto.getPreco();
        }
        return total;
    }

    public void fazerPagamento(float saldo) {
        if (this.valorDoPedido > saldo) {
            System.out.println("Saldo insuficiente. Tente novamente.");
            this.statusPedido = STATUS_PEDIDO.CANCELADO;
            return;
        }

        if (this.statusPedido == STATUS_PEDIDO.CANCELADO) {
            System.out.println("Pedido cancelado refaça o pedido novamente.");
            return;
        }

        this.pedidoPago = true;
        this.statusPedido = STATUS_PEDIDO.CONCLUIDO;
        System.out.println("Pagamento realizado com sucesso!");
    }
}
