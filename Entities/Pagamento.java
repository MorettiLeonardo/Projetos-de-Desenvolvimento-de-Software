package Entities;

import java.util.Date;
import java.util.UUID;

import Enums.STATUS_PAGAMENTO;

public class Pagamento {
    private final String id = UUID.randomUUID().toString();
    private final Date dataPagamento = new Date();
    private float valor;
    private STATUS_PAGAMENTO status;

    public Pagamento(float valor) {
        this.valor = valor;
        this.status = STATUS_PAGAMENTO.PENDENTE;
    }

    public String getId() {
        return id;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public float getValor() {
        return valor;
    }

    public STATUS_PAGAMENTO getStatus() {
        return status;
    }

    public void confirmarPagamento() {
        if (status == STATUS_PAGAMENTO.CONCLUIDO) {
            System.out.println("O pagamento já foi concluído anteriormente.");
            return;
        }
        this.status = STATUS_PAGAMENTO.CONCLUIDO;
        System.out.println("Pagamento confirmado com sucesso!");
    }

    public void cancelarPagamento() {
        if (status == STATUS_PAGAMENTO.CONCLUIDO) {
            System.out.println("Não é possível cancelar um pagamento já concluído.");
            return;
        }
        this.status = STATUS_PAGAMENTO.CANCELADO;
        System.out.println("Pagamento cancelado.");
    }

    @Override
    public String toString() {
        return "Pagamento{id='" + id + "', valor=" + valor + ", status=" + status + "}";
    }
}
