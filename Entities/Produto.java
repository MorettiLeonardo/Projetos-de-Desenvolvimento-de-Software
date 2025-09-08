package Entities;

import java.util.UUID;

public class Produto {
    private final String id = UUID.randomUUID().toString();
    private final String nome;
    private final float preco;

    public Produto(String nome, float preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public float getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Produto{id='" + id + "', nome='" + nome + "', preco=" + preco + "}";
    }
}
