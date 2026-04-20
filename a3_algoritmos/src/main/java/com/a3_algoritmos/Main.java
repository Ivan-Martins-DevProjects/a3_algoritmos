package com.a3_algoritmos;

import com.a3_algoritmos.models.ListaWorkers;
import com.a3_algoritmos.models.WorkerCLT;
import com.a3_algoritmos.models.WorkerComissionado;

public class Main {

  public static void main(String[] args) {
    WorkerComissionado workerComissionado = new WorkerComissionado(
        "Ivan",
        123,
        4000,
        10,
        4000,
        true,
        true,
        true);

    WorkerCLT workerCLT = new WorkerCLT(
        "Claudio",
        123,
        2000,
        true,
        true,
        true);

    ListaWorkers lista = new ListaWorkers();

    for (int i = 0; i < 3; i++) {
      lista.adicionarWorker(workerComissionado);
      lista.adicionarWorker(workerCLT);
    }

    lista.listarTodosOsFuncionarios();
  }
}
