import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        int opcao = -1;
        Estoque estoque = new Estoque("Várzea");

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

                estoque.adicionarProduto(nome, preco, quantidade);

            } else if (opcao == 2) {
                System.out.println("Informe o nome do produto:");
                String nome = input.nextLine();

                Produto produto = estoque.localizaProduto(nome);

                if (produto != null) {
                    System.out.println("Informe a quantidade a ser adicionada:");
                    int quantidadeAdicionada = input.nextInt();

                    estoque.adicionarQuantidade(produto, quantidadeAdicionada);
                } else {
                    System.out.println("Produto não localizado!");
                }
            } else if (opcao == 3) {
                System.out.println("Informe o nome do produto:");
                String nome = input.nextLine();

                Produto produto = estoque.localizaProduto(nome);

                if (produto != null) {
                    System.out.println("Informe a quantidade a ser removida:");
                    int quantidadeRemovida = input.nextInt();

                    estoque.removerQuantidade(produto, quantidadeRemovida);
                } else {
                    System.out.println("Produto não localizado!");
                }
            } else if (opcao == 4) {
                estoque.exibirProdutos();
            }
        }

        input.close();
    }
}
