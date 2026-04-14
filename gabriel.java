import java.util.ArrayList;
import java.util.Scanner;

public class FolhaDePagamento {

  public static void main(String[] args) {
    try (Scanner entrada = new Scanner(System.in)) {
      ArrayList<String> funcionarios = new ArrayList<>();

      int opcaoMenu;
      double salario = 2000.00;

      do { // Menu de opções
        System.out.print("""
            ======= SISTEMA DE FOLHA DE PAGAMENTO =======
            1 - Cadastrar Funcionário Padrão
            2 - Cadastrar Funcionário Comissionado
            3 - Cadastrar Funcionário por Produção
            4 - Gerar Folha de Pagamento
            5 - Sair
            Escolha uma opção: """);
        opcaoMenu = entrada.nextInt();
        entrada.nextLine(); // Limpar o buffer do scanner após ler um número
        switch (opcaoMenu) { // Processamento das opções do menu
          case 1 -> { // Cadastrar funcionário padrão
            System.out.print("Digite o nome do funcionário: ");
            String nome = entrada.nextLine();
            System.out.print("Digite a matricula do funcionário: ");
            String matricula = entrada.nextLine();
            String funcionarioPadrao = """
                ======= FUNCIONARIO PADRÃO =======
                Nome: %s
                Matrícula: %s
                Salário: R$ %.2f
                ==================================
                """.formatted(nome, matricula, salario);
            funcionarios.add(funcionarioPadrao);
            System.out.println("Funcionário padrão cadastrado com sucesso!");
          }
          case 2 -> { // Cadastrar funcionário comissionado
            System.out.print("Digite o nome do funcionário: ");
            String nome = entrada.nextLine();
            System.out.print("Digite a matricula do funcionário: ");
            String matricula = entrada.nextLine();
            System.out.print("Digite o valor total das vendas: ");
            double valorVendas = entrada.nextDouble();
            entrada.nextLine();
            System.out.print("Digite a taxa de comissão (%): ");
            double taxa = entrada.nextDouble();
            entrada.nextLine();
            double salarioComissionado = salario + comissionado(valorVendas, taxa); // Cálculo do salário do funcionário
                                                                                    // comissionado
            String funcionarioComissionado = """
                ======= FUNCIONARIO COMISSIONADO =======
                Nome: %s
                Matrícula: %s
                Salário: R$ %.2f
                ========================================
                """.formatted(nome, matricula, salarioComissionado);
            funcionarios.add(funcionarioComissionado);
            System.out.println("Funcionário comissionado cadastrado com sucesso!");
          }
          case 3 -> { // Cadastrar funcionário por produção
            System.out.print("Digite o nome do funcionário: ");
            String nome = entrada.nextLine();
            System.out.print("Digite a matricula do funcionário: ");
            String matricula = entrada.nextLine();
            System.out.print("Digite o valor unitário: ");
            double valorPeca = entrada.nextDouble();
            entrada.nextLine();
            System.out.print("Digite a quantidade produzida: ");
            double qtdProduzida = entrada.nextDouble();
            entrada.nextLine();
            double salarioProducao = salario + producao(valorPeca, qtdProduzida); // Cálculo do salário do funcionário
                                                                                  // por produção
            String funcionarioProducao = """
                ======= FUNCIONARIO POR PRODUÇÃO =======
                Nome: %s
                Matrícula: %s
                Salário: R$ %.2f
                ========================================

                """.formatted(nome, matricula, salarioProducao);
            funcionarios.add(funcionarioProducao);
            System.out.println("Funcionário por produção cadastrado com sucesso!");
          }
          case 4 -> { // Gerar a folha de pagamento
            System.out.println("======= FOLHA DE PAGAMENTO =======");
            if (funcionarios.isEmpty()) { // Verificar se há funcionários cadastrados
              System.out.println("Nenhum funcionário cadastrado.");
            } else { // Imprimir os detalhes de cada funcionário na folha de pagamento
              for (String funcionario : funcionarios) {
                System.out.println(funcionario);
              }
            }

          }
          case 5 -> { // Sair do sistema
            System.out.println("Saindo do sistema. Até mais!");
          }
          default -> // Opção inválida
            System.out.println("Opção inválida. Tente novamente.");

        }
      } while (opcaoMenu != 5); // Loop do menu até o usuário escolher sair
    }
  }

  public static double comissionado(double valorVendas, double taxaComissao) { // Cálculo da comissão
    return (valorVendas * taxaComissao) / 100;
  }

  public static double producao(double valorUni, double qtd) { // Cálculo do salário por produção
    return valorUni * qtd;
  }
}
