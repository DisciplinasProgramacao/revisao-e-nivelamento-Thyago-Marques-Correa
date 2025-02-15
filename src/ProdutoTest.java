import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProdutoTest {
    static Produto produto;

    @BeforeEach
    public void prepare() {
        produto = new Produto("Produto teste", 100, 0.1);
    }

    @Test
    public void calculaPrecoCorretamente() {
        assertEquals(110.0, produto.calcularPrecoVenda(), 0.01);
    }

    @Test
    public void stringComDescricaoEValor() {
        String desc = produto.toString();
        assertTrue(desc.contains("Produto teste") && desc.contains("R$ 110.00"));
    }

    @Test
    public void naoCriaProdutoComPrecoNegativo() {
        assertThrows(IllegalArgumentException.class, () -> new Produto("teste", -5, 0.5));
    }

    @Test
    public void naoCriaProdutoComMargemNegativa() {
        assertThrows(IllegalArgumentException.class, () -> new Produto("teste", 5, -1));
    }
}