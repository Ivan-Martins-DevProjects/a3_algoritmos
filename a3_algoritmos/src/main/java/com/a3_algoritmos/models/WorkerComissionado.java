package com.a3_algoritmos.models;

public class WorkerComissionado extends Worker {
  int comissao;
  double vendas;

  public WorkerComissionado(
      String nome,
      int matricula,
      double salario,
      int comissao,
      double vendas,
      boolean convenioSaude,
      boolean vr,
      boolean vt) {

    super(nome, matricula, salario, convenioSaude, vr, vt);
    this.vinculo = "comissionado";
    this.comissao = comissao;
    this.vendas = vendas;
  }

  public double calcularSalario() {
    double salarioComDescontos = salarioComDescontos();
    double saldoVendas = calcularComissao();

    double salarioFinal = salarioComDescontos + saldoVendas;

    return salarioFinal;
  }

  private double calcularComissao() {
    double saldoVendas = vendas * (comissao / 100);

    return saldoVendas;
  }
}
