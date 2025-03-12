public class Estoque {
    private String nome;
    private Produto[] produtos;

    public Estoque(String nome) {
        this.nome = nome;
        this.produtos = new Produto[0];
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void adicionarProduto(String nome, double preco, int quantidade) {
        Produto produto = new Produto(nome, preco, quantidade);
        
        System.out.println("Produto cadastrado!");
        produto.ExibirProduto();

        // construir um novo array
        Produto[] produtosNovo = new Produto[produtos.length + 1];

        // preencher com as informações antigas
        for (int i = 0; i < produtos.length; i++) {
            produtosNovo[i] = produtos[i];
        }

        // sobrescrever o array
        produtos = produtosNovo;

        // adiciono o produto na última posição
        produtos[produtosNovo.length - 1] = produto;
    }

    public Produto localizaProduto(String nome) {
        for (int i = 0; i < produtos.length; i++) {
            if (produtos[i] != null && produtos[i].getNome().equals(nome)) {
                return produtos[i];
            }
        }

        return null;
    }

    public void adicionarQuantidade(Produto produto, int quantidadeAdicionada) {
        produto.adicionarEstoque(quantidadeAdicionada);
        produto.ExibirProduto();
    }

    public void removerQuantidade(Produto produto, int quantidadeRemovida) {
        produto.removerEstoque(quantidadeRemovida);
        produto.ExibirProduto();
    }

    public void exibirProdutos() {
        for (int i = 0; i < produtos.length; i++) {
            if (produtos[i] != null) {
                System.out.println("Produto: " + i);
                produtos[i].ExibirProduto();
                System.out.println();
            }
        }
    }
}
