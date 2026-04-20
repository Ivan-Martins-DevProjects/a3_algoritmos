package com.a3_algoritmos.models;

import java.util.ArrayList;
import java.util.List;

import com.a3_algoritmos.printInfo.PrintInformation;

public class ListaWorkers {
  private List<Worker> workers = new ArrayList<>();

  public void adicionarWorker(Worker worker) {
    workers.add(worker);

    System.out.println("Funcionário adicionado com sucesso");
  }

  public void removerWorker(String nome) {
    for (Worker w : workers) {
      if (w.nome.equals(nome)) {
        workers.remove(w);
        System.out.println("Funcionário encontrado com sucesso");
        break;
      } else {
        throw new RuntimeException("Nenhum funcionário com esse nome foi encontrado");
      }
    }
  }

  public void listarTodosOsFuncionarios() {
    if (workers.isEmpty()) {
      System.out.println("Lista de funcionários vazia");
    } else {
      PrintInformation.printTodosOsFuncionarios(workers);
    }
  }

  public void listarComissionados() {
    if (workers.isEmpty()) {
      System.out.println("Lista de funcionários vazia");
      return;
    }

    List<WorkerComissionado> listaFiltrada = new ArrayList<>();
    for (Worker w : workers) {
      if (w instanceof WorkerComissionado) {
        listaFiltrada.add((WorkerComissionado) w);
      }
    }

    PrintInformation.printFuncionariosComissionados(listaFiltrada);
  }

  public void listarCLT() {
    if (workers.isEmpty()) {
      System.out.println("Lista de funcionários vazia");
      return;
    }

    List<WorkerCLT> listaFiltrada = new ArrayList<>();
    for (Worker w : workers) {
      if (w instanceof WorkerCLT) {
        listaFiltrada.add((WorkerCLT) w);
      }
    }

    PrintInformation.printFuncionariosCLT(listaFiltrada);
  }
}
