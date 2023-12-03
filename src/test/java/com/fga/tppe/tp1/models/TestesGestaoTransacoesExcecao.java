package com.fga.tppe.tp1.models;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.fga.tppe.tp1.models.Produto;

import static org.junit.jupiter.api.Assertions.*;

public class TestesGestaoTransacoes {
    private Produto produto;

    @BeforeEach
    public void setUp() {
        produto = new Produto();
        produto.setQuantidadeDisponivel(10); // Definindo a quantidade inicial como 10
        produto.setLimiteMinimo(20); // Definindo o limite mínimo como 20 para acionar o alerta de estoque baixo
    }

    @Test
    public void testRecebimentoMercadoria() {
        int quantidadeRecebida = 15;
        produto.receberMercadoria(quantidadeRecebida);

        int quantidadeEsperada = 25;
        assertEquals(quantidadeEsperada, produto.getQuantidadeDisponivel()); // Não deveria lançar exceção e o valor deveria ser validado corretamente, como atualizado
    }

    @Test
    public void testVendaMercadoriaNegativo() {
        int quantidadeParaVenda = -19;

        assertThrows(IllegalArgumentException.class, () -> {
            produto.venderMercadoria(quantidadeParaVenda);
        });
    }

    @Test
    public void testDevolucaoNegativo() {
        int quantidadeParaDevolver = -5;

        assertThrows(IllegalArgumentException.class, () -> {
            produto.devolverMercadoria(quantidadeParaDevolver);
        });
    }

    @Test
    public void testTransferenciaNegativo() {
        int quantidadeParaTransferir = -92;

        assertThrows(IllegalArgumentException.class, () -> {
            produto.transferirMercadoria(quantidadeParaTransferir);
        });
    }

    @Test
    public void testAjusteEstoqueNulo() {
        int QuantidadeTotalFinal = 0;
        produto.ajustarEstoque(QuantidadeTotalFinal);

        int quantidadeEsperada = 0;
        assertEquals(quantidadeEsperada, produto.getQuantidadeDisponivel()); // Não deveria lançar exceção e o valor deveria ser validado corretamente, como atualizado
    }

    @Test
    public void testAjusteEstoqueNegativo() {
        int QuantidadeTotalFinal = -450;
        produto.ajustarEstoque(QuantidadeTotalFinal);

        int quantidadeEsperada = -450;
        assertEquals(quantidadeEsperada, produto.getQuantidadeDisponivel()); // Não deveria lançar exceção e o valor deveria ser validado corretamente, como atualizado
    }
}