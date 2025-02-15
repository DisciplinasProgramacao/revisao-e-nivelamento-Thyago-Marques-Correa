class ProdutoNaoPerecivel extends Produto {
    public ProdutoNaoPerecivel(String descricao, double precoCusto, double margemLucro) {
        super(descricao, precoCusto, margemLucro);
    }

    @Override
    public String toString() {
        return super.toString() + " (Não perecível)";
    }
}