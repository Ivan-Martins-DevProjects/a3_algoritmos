package com.a3_algoritmos.models;

public class Worker {
  protected String nome;
  protected String vinculo;
  protected int matricula;
  protected double salario;
  public Beneficios beneficios;

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

  public double getDiscounts() {
    double convenioMaisVr = beneficios.getConvenioDiscount() + beneficios.getVrDiscount();
    double valorVt = salario * beneficios.getVtDiscount();

    return convenioMaisVr + valorVt;
  }

  protected double salarioComDescontos() {

    double salarioFinal = salario - getDiscounts();

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
