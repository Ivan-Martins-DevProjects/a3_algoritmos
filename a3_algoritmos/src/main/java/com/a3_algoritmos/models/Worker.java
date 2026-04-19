package com.a3_algoritmos.models;

public class Worker {
  protected String nome;
  protected String vinculo;
  protected int matricula;
  protected double salario;
  protected Beneficios beneficios;

  public Worker(
      String nome,
      int matricula,
      double salario,
      boolean convenioSaude,
      boolean vr,
      boolean vt) {

    this.nome = nome;
    this.matricula = matricula;
    this.salario = salario;
    this.beneficios = new Beneficios(convenioSaude, vr, vt);
  }

  protected double salarioComDescontos() {
    double convenioMaisVr = beneficios.getConvenioDiscount() + beneficios.getVrDiscount();
    double valorVt = salario * beneficios.getVtDiscount();

    double salarioFinal = salario - convenioMaisVr - valorVt;

    return salarioFinal;
  }

  public String getNome() {
    return nome;
  }

  public String getVinculo() {
    return vinculo;
  }

  public int getMatricula() {
    return matricula;
  }

  public double getSalario() {
    return salario;
  }

}
