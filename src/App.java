import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class App {
    public static void main(String[] args) {
        Produto produto1 = new ProdutoNaoPerecivel("Cadeira", 100.0, 0.3);
        System.out.println(produto1);

        Produto produto2 = new ProdutoPerecivel("Leite", 4.0, 0.2, LocalDate.now().plusDays(5));
        System.out.println(produto2);

        try {
            Produto produto3 = new ProdutoPerecivel("Iogurte", 2.0, 0.2, LocalDate.now().minusDays(1));
            System.out.println(produto3.calcularPrecoVenda());
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.err.println("Erro ao processar produto: " + e.getMessage());
        }
    }
}