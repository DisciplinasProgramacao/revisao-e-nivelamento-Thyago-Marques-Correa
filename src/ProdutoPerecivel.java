import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class ProdutoPerecivel extends Produto {
    private LocalDate dataValidade;

    public ProdutoPerecivel(String descricao, double precoCusto, double margemLucro, LocalDate dataValidade) {
        super(descricao, precoCusto, margemLucro);
        if (dataValidade.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("A data de validade fornecida (" + dataValidade + ") é anterior à data atual.");
        }
        this.dataValidade = dataValidade;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    @Override
    public double calcularPrecoVenda() {
        if (dataValidade.isBefore(LocalDate.now())) {
            throw new IllegalStateException("O produto '" + getDescricao() + "' está fora da validade desde " + dataValidade + ".");
        }
        long diasParaVencimento = ChronoUnit.DAYS.between(LocalDate.now(), dataValidade);
        double precoVenda = super.calcularPrecoVenda();
        if (diasParaVencimento <= 7) {
            return precoVenda * 0.75; // Desconto de 25%
        }
        return precoVenda;
    }

    @Override
    public String toString() {
        return super.toString() + ", Data de Validade: " + dataValidade;
    }
}