import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    Executor executor = new Executor(entrada);
    List<FuncionarioPadrao> listaFuncionarios = new ArrayList<>();

    int opcaoMenu;
    do {
      opcaoMenu = executor.menuPrincipal();
      FuncionarioPadrao funcionario;

      switch (opcaoMenu) {
        case 1:
          funcionario = executor.cadastroPadrao();
          if (!executor.VerificarMatriculaExistente(listaFuncionarios, funcionario.matricula)) {
            listaFuncionarios.add(funcionario);
            break;
          } else {
            System.out.println("Matrícula já cadastrada");
            break;
          }

        case 2:
          executor.listarFuncionarios(listaFuncionarios);
          break;

        case 3:
          break;

        default:
          System.out.println("Opção inváida, por favor escolha uma das opções acima!");
      }

      boolean continuar = executor.continuarOperacao();
      if (continuar) {
        continue;
      } else {
        System.out.println("Até a próxima!");
        return;
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

  public boolean VerificarMatriculaExistente(List<FuncionarioPadrao> funcionarios, int matricula) {
    for (FuncionarioPadrao f : funcionarios) {
      if (f.matricula == matricula) {
        return true;
      }
    }
    return false;
  }

  public void listarFuncionarios(List<FuncionarioPadrao> funcionarios) {
    if (funcionarios.isEmpty()) {
      System.out.println("Lista de funcionarios vazia");
      return;
    }
    System.out.println("======= LISTA DE FUNCIONÁRIOS =======");

    for (FuncionarioPadrao f : funcionarios) {
      String mensagem = """
          ----------------------------------
          Nome: %s
          Matrícula: %s
          Modalidade: %s
          Salário: R$ %.2f
          ----------------------------------
          """.formatted(
          f.nome,
          f.matricula,
          f.tipo,
          f.salario);

      System.out.println(mensagem);
    }
  }

  public FuncionarioPadrao cadastroPadrao() {
    PrintElements.inputNome();
    String nome = scanner.nextLine();

    PrintElements.inputMatricula();
    int matricula = scanner.nextInt();
    scanner.nextLine();

    System.out.println("Funcionário CLT criado com sucesso!");
    PrintElements.funcionarioInfo("CLT", nome, matricula, salario);

    FuncionarioPadrao user = new FuncionarioPadrao("CLT", nome, matricula, salario);
    return user;
  }

  public boolean continuarOperacao() {
    while (true) {
      PrintElements.cuntinuarOperacao();
      String response = scanner.nextLine().trim().toLowerCase();

      if (response.isEmpty()) {
        System.out.println("Digite 's' para sim ou 'n' para não.");
        continue;
      }

      char primeiraLetra = response.charAt(0);

      if (primeiraLetra == 's') {
        return true;
      } else if (primeiraLetra == 'n') {
        return false;
      }

      System.out.println("Digite 's' para sim ou 'n' para não.");
    }
  }
}

public class FuncionarioPadrao {
  String tipo;
  String nome;
  int matricula;
  double salario;

  public FuncionarioPadrao(String tipo, String nome, int matricula, double salario) {
    new Validator(tipo, matricula);

    this.tipo = tipo;
    this.nome = nome.substring(0, 1).toUpperCase() + nome.substring(1).toLowerCase();
    this.matricula = matricula;
    this.salario = salario;
  }

  class Validator {
    private Validator(String tipo, int matricula) {
      checkTipo(tipo);
      checkMatricula(matricula);
    }

    private void checkTipo(String tipo) {
      List<String> opcoes = Arrays.asList("CLT", "comissionado");

      if (!opcoes.contains(tipo.toUpperCase())) {
        throw new RuntimeException("Tipo de funcionário inválido");
      }
    }

    private void checkMatricula(int matricula) {
      if (matricula >= 1000) {
        throw new RuntimeException("Matrícula inválida, escolha uma matricula entre 0 e 999");
      }
    }
  }
}

public class PrintElements {

  public static void mainMenu() {
    System.out.println("""
        ======= SISTEMA DE FOLHA DE PAGAMENTO =======
        1 - Cadastrar Funcionário
        2 - Listar Funcionários
        3 - Sair
        Escolha uma opção: """);

    return;
  }

  public static void funcionarioInfo(String tipoDeFuncionario, String nome, int matricula, double salario) {
    String funcionarioInfo = """
        ======= FUNCIONARIO %s =======
        Nome: %s
        Matrícula: %s
        Salário: R$ %.2f
        ==================================
        """.formatted(tipoDeFuncionario.toUpperCase(),
        nome.substring(0, 1).toUpperCase() + nome.substring(1).toLowerCase(),
        matricula,
        salario);
    System.out.println(funcionarioInfo);
  }

  public static void cuntinuarOperacao() {
    System.out.println("Deseja realizar outra operação? [s/n]");
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
