public class Produto {
    private String descricao;
    private double precoCusto;
    private double margemLucro;

    public Produto(String descricao, double precoCusto, double margemLucro) {
        this.descricao = descricao;
        this.precoCusto = precoCusto;
        this.margemLucro = margemLucro > 0 ? margemLucro : 0.2; // Margem padrão de 20%
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public double getMargemLucro() {
        return margemLucro;
    }

    public double calcularPrecoVenda() {
        return precoCusto * (1 + margemLucro);
    }

    @Override
    public String toString() {
        return "Produto: " + descricao +
                ", Preço de Venda: R$ " + String.format("%.2f", calcularPrecoVenda());
    }
}