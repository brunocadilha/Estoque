import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        int opcao = -1;
        Produto[] produtos = new Produto[0];

        while (opcao != 0) {
            System.out.println("****MENU****");
            System.out.println("1 - Adicionar produto");
            System.out.println("2 - Adicionar quantidade");
            System.out.println("3 - Remover quantidade");
            System.out.println("4 - Apresentar produtos");
            System.out.println("0 - Sair");
            opcao = input.nextInt();
            input.nextLine();

            if (opcao == 1) {
                System.out.println("Informe o nome do produto:");
                String nome = input.nextLine();
        
                System.out.println("Informe o valor do produto:");
                double preco = input.nextDouble();
        
                System.out.println("Informe a quantidade do produto:");
                int quantidade = input.nextInt();
        
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

            } else if (opcao == 2) {
                System.out.println("Informe o nome do produto:");
                String nome = input.nextLine();

                for (int i = 0; i < produtos.length; i++) {
                    if (produtos[i] != null && produtos[i].getNome().equals(nome)) {
                        System.out.println("Informe a quantidade a ser adicionada:");
                        int quantidadeAdicionada = input.nextInt();

                        produtos[i].adicionarEstoque(quantidadeAdicionada);

                        produtos[i].ExibirProduto();
                    }
                }
            } else if (opcao == 3) {
                System.out.println("Informe o nome do produto:");
                String nome = input.nextLine();

                for (int i = 0; i < produtos.length; i++) {
                    if (produtos[i] != null && produtos[i].getNome().equals(nome)) {
                        System.out.println("Informe a quantidade a ser removida:");
                        int quantidadeRemovida = input.nextInt();
                
                        produtos[i].removerEstoque(quantidadeRemovida);

                        produtos[i].ExibirProduto();
                    }
                }
            } else if (opcao == 4) {
                for (int i = 0; i < produtos.length; i++) {
                    if (produtos[i] != null) {
                        System.out.println("Produto: " + i);
                        produtos[i].ExibirProduto();
                        System.out.println();
                    }
                }
            }
        }

        input.close();
    }
}
