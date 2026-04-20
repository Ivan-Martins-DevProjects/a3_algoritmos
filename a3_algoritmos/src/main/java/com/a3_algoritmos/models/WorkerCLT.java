package com.a3_algoritmos.models;

public class WorkerCLT extends Worker {

  public WorkerCLT(
      String nome,
      int matricula,
      double salario,
      boolean convenioSaude,
      boolean vr,
      boolean vt) {

    super(nome, matricula, salario, convenioSaude, vr, vt);
    this.vinculo = "CLT";
  }

  public double calcularSalario() {
    return salarioComDescontos();
  }
}
