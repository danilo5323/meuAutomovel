package br.com.dbsdev.meuautomovel.externo.service.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Consumo implements Serializable {

  private static final long serialVersionUID = 1L;
  private Long id;

  private String dataAbastecimento;
  private BigDecimal precoCombustivel;
  private Double quantidadeLitros;
  private Double mediaConsumoParcial;
  private Double mediaGeral10Dias;
  private Double mediaConsumo;
  private String tipoCombustivel;
  private Double custoPorKm;
  private Long odometroParcial;
  private BigDecimal custoTotal;
  private String nomePosto;

  public Consumo() {
    super();
  }
 

  public Consumo(Long id, String dataAbastecimento, BigDecimal precoCombustivel, Double mediaConsumoParcial,
      Double mediaGeral10Dias, Double mediaConsumo, String tipoCombustivel, Double custoPorKm, BigDecimal custoTotal,
      String nomePosto, Double quantidadeLitros, Long odometroParcial ) {
    super();
    this.id = id;
    this.dataAbastecimento = dataAbastecimento;
    this.precoCombustivel = precoCombustivel;
    this.mediaConsumoParcial = mediaConsumoParcial;
    this.mediaGeral10Dias = mediaGeral10Dias;
    this.mediaConsumo = mediaConsumo;
    this.tipoCombustivel = tipoCombustivel;
    this.custoPorKm = custoPorKm;
    this.custoTotal = custoTotal;
    this.nomePosto = nomePosto;
    this.quantidadeLitros = quantidadeLitros;
    this.odometroParcial = odometroParcial;

  }



  public void setQuantidadeLitros(Double quantidadeLitros) {
    this.quantidadeLitros = quantidadeLitros;
  }

  public void setOdometroParcial(Long odometroParcial) {
    this.odometroParcial = odometroParcial;
  }

  public Double getQuantidadeLitros() {
    return quantidadeLitros;
  }

  public Long getOdometroParcial() {
    return odometroParcial;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDataAbastecimento() {
    return dataAbastecimento;
  }

  public void setDataAbastecimento(String dataAbastecimento) {
    this.dataAbastecimento = dataAbastecimento;
  }

  public BigDecimal getPrecoCombustivel() {
    return precoCombustivel;
  }

  public void setPrecoCombustivel(BigDecimal precoCombustivel) {
    this.precoCombustivel = precoCombustivel;
  }

  public Double getMediaConsumoParcial() {
    return mediaConsumoParcial;
  }

  public void setMediaConsumoParcial(Double mediaConsumoParcial) {
    this.mediaConsumoParcial = mediaConsumoParcial;
  }

  public Double getMediaGeral10Dias() {
    return mediaGeral10Dias;
  }

  public void setMediaGeral10Dias(Double mediaGeral10Dias) {
    this.mediaGeral10Dias = mediaGeral10Dias;
  }

  public Double getMediaConsumo() {
    return mediaConsumo;
  }

  public void setMediaConsumo(Double mediaConsumo) {
    this.mediaConsumo = mediaConsumo;
  }

  public String getTipoCombustivel() {
    return tipoCombustivel;
  }

  public void setTipoCombustivel(String tipoCombustivel) {
    this.tipoCombustivel = tipoCombustivel;
  }

  public Double getCustoPorKm() {
    return custoPorKm;
  }

  public void setCustoPorKm(Double custoPorKm) {
    this.custoPorKm = custoPorKm;
  }

  public BigDecimal getCustoTotal() {
    return custoTotal;
  }

  public void setCustoTotal(BigDecimal custoTotal) {
    this.custoTotal = custoTotal;
  }

  public String getNomePosto() {
    return nomePosto;
  }

  public void setNomePosto(String nomePosto) {
    this.nomePosto = nomePosto;
  }


  @Override
  public String toString() {
    return "Consumo{" +
            "id=" + id +
            ", dataAbastecimento='" + dataAbastecimento + '\'' +
            ", precoCombustivel=" + precoCombustivel +
            ", quantidadeLitros=" + quantidadeLitros +
            ", mediaConsumoParcial=" + mediaConsumoParcial +
            ", mediaGeral10Dias=" + mediaGeral10Dias +
            ", mediaConsumo=" + mediaConsumo +
            ", tipoCombustivel='" + tipoCombustivel + '\'' +
            ", custoPorKm=" + custoPorKm +
            ", odometroParcial=" + odometroParcial +
            ", custoTotal=" + custoTotal +
            ", nomePosto='" + nomePosto + '\'' +
            '}';
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Consumo other = (Consumo) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

}
