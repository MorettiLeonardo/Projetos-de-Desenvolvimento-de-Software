package Interfaces;

import java.util.List;

import Entities.Produto;

public interface PedidoService {
    void realizarPedido(List<Produto> carrinho);
}
