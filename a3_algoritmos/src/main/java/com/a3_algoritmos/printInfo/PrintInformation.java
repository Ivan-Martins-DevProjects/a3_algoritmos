package com.a3_algoritmos.printInfo;

import java.util.List;

import com.a3_algoritmos.models.Worker;
import com.a3_algoritmos.models.WorkerCLT;
import com.a3_algoritmos.models.WorkerComissionado;

public class PrintInformation {

  public static void printTodosOsFuncionarios(List<Worker> workers) {
    System.out.println("======================= Todos os Funcionários ======================");

    for (Worker w : workers) {
      System.out.printf("""
          *******************************
          ------ Informações
          > Nome: %s,
          > Vínculo: %s,
          > Matricula: %d,

          ------ Salario
          > Salario: %.2f,

          ------ Beneficios
          > Convênio Médico: %b,
          > VR: %b,
          > VT: %b
          *******************************
          """,
          w.getNome(),
          w.getVinculo(),
          w.getMatricula(),
          w.getSalario(),
          w.beneficios.getConvenio(),
          w.beneficios.getVr(),
          w.beneficios.getVt());
    }
  }

  public static void printFuncionariosComissionados(List<WorkerComissionado> workers) {
    System.out.println("======================= Funcionários Comissionados ======================");

    for (WorkerComissionado w : workers) {
      System.out.printf("""
          *******************************
          ------ Informações
          > Nome: %s,
          > Matricula: %d,
          > Salario: R$ %.2f,

          ------ Salario
          > Vendas: R$ %.2f,
          > Comissao: %s,
          > Descontos: %.2f
          > Salario do Mês: R$ %.2f,

          ------ Beneficios
          > Convênio Médico: %b,
          > VR: %b,
          > VT: %b
          *******************************
          """,
          w.getNome(),
          w.getMatricula(),
          w.getSalario(),
          w.getVendas(),
          w.getComissao() + "%",
          w.getDiscounts(),
          w.calcularSalario(),
          w.beneficios.getConvenio(),
          w.beneficios.getVr(),
          w.beneficios.getVt());
    }
  }

  public static void printFuncionariosCLT(List<WorkerCLT> workers) {
    System.out.println("======================= Funcionários CLT ======================");

    for (WorkerCLT w : workers) {
      System.out.printf("""
          *******************************
          ------ Informações
          > Nome: %s,
          > Matricula: %d,

          ------ Salario
          > Salario: R$ %.2f,
          > Descontos: %.2f
          > Salario do Mês: R$ %.2f,

          ------ Beneficios
          > Convênio Médico: %b,
          > VR: %b,
          > VT: %b
          *******************************
          """,
          w.getNome(),
          w.getMatricula(),
          w.getSalario(),
          w.getDiscounts(),
          w.calcularSalario(),
          w.beneficios.getConvenio(),
          w.beneficios.getVr(),
          w.beneficios.getVt());
    }
  }
}
