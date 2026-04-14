import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    Executor executor = new Executor(entrada);
    List<Map<String, Object>> listaFuncionarios = new ArrayList<>();

    int opcaoMenu;
    do {
      opcaoMenu = executor.menuPrincipal();
      Map<String, Object> dadosFuncionario;

      switch (opcaoMenu) {
        case 1:
          dadosFuncionario = executor.cadastroPadrao();
          listaFuncionarios.add(dadosFuncionario);
          break;

        case 2:
          executor.listarFuncionarios(listaFuncionarios);
          break;

        case 3:
          break;

        default:
          break;
      }
    } while (opcaoMenu != 5);

  }
}

public class Executor {
  Scanner scanner;
  double salario = 2000;

  public Executor(Scanner scanner) {
    this.scanner = scanner;
  }

  public int menuPrincipal() {
    PrintElements.mainMenu();
    int opcaoMenu = scanner.nextInt();
    scanner.nextLine();

    return opcaoMenu;
  }

  public void listarFuncionarios(List<Map<String, Object>> funcionarios) {
    System.out.println("======= LISTA DE FUNCIONÁRIOS =======");

    for (Map<String, Object> f : funcionarios) {
      String mensagem = """
          ----------------------------------
          Nome: %s
          Matrícula: %s
          Modalidade: %s
          Salário: R$ %.2f
          ----------------------------------
          """.formatted(
          f.get("nome"),
          f.get("matricula"),
          f.get("tipo"),
          f.get("salario"));

      System.out.println(mensagem);
    }

  }

  public Map<String, Object> cadastroPadrao() {
    PrintElements.inputNome();
    String nome = scanner.nextLine();

    PrintElements.inputMatricula();
    String matricula = scanner.nextLine();

    PrintElements.funcionarioInfo("padrão", nome, matricula, salario);

    Map<String, Object> response = new HashMap<>();
    response.put("tipo", "padrão");
    response.put("nome", nome);
    response.put("matricula", matricula);
    response.put("salario", salario);

    return response;
  }
}

public class PrintElements {

  public static void mainMenu() {
    System.out.print("""
        ======= SISTEMA DE FOLHA DE PAGAMENTO =======
        1 - Cadastrar Funcionário Padrão
        2 - Cadastrar Funcionário Comissionado
        3 - Listar Funcionários
        4 - Gerar Folha de Pagamento
        5 - Sair
        Escolha uma opção: """);

    return;
  }

  public static void funcionarioInfo(String tipoDeFuncionario, String nome, String matricula, double salario) {
    String funcionarioInfo = """
        ======= FUNCIONARIO %s =======
        Nome: %s
        Matrícula: %s
        Salário: R$ %.2f
        ==================================
        """.formatted(tipoDeFuncionario.toUpperCase(), nome, matricula, salario);
    System.out.println(funcionarioInfo);
  }

  public static void inputNome() {
    System.out.println("Digite o nome do funcionário: ");
  }

  public static void inputMatricula() {
    System.out.println("Digite a matricula do funcionário: ");
  }

  public static void inputTotalVendas() {
    System.out.println("Digite o valor total das vendas: ");
  }

  public static void inputComissao() {
    System.out.println("Digite a taxa de comissão (%): ");
  }
}
