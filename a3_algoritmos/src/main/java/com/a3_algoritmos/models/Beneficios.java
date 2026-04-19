package com.a3_algoritmos.models;

public class Beneficios {
  boolean convenioSaude;
  boolean vr;
  boolean vt;

  double convenioSaudeDiscount = 120;
  double vrDiscount = 120;
  int vtDiscount = 6;

  public Beneficios(boolean convenioSaude, boolean vr, boolean vt) {
    this.convenioSaude = convenioSaude;
    this.vr = vr;
    this.vt = vt;
  }

  public double getConvenioDiscount() {
    return convenioSaudeDiscount;
  }

  public double getVrDiscount() {
    return vrDiscount;
  }

  public int getVtDiscount() {
    return vtDiscount;
  }

  public boolean getConvenio() {
    return convenioSaude;
  }

  public boolean getVr() {
    return vr;
  }

  public boolean getVt() {
    return vt;
  }
}
