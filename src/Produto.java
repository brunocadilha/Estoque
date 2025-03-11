public class Produto {
    private String nome;
    private double preco;
    private int quantidade;

    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void adicionarEstoque(int quantidade) {
        this.quantidade = this.quantidade + quantidade;
    }

    public void removerEstoque(int quantidade) {
        if (this.quantidade < quantidade) {
            System.out.println("Quantidade insuficiente!");
        } else {
            this.quantidade = this.quantidade - quantidade;
        }
    }

    public double getValorTotalEstoque() {
        return this.quantidade * this.preco;
    }

    public void ExibirProduto() {
        System.out.println("Nome: " + this.getNome());
        System.out.println("Preço: " + this.getPreco());
        System.out.println("Quantidade: " + this.getQuantidade());
        System.out.println("Total: " + this.getValorTotalEstoque());
    }
}
