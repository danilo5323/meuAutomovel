package br.com.dbsdev.meuautomovel.externo.service.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Raiz
 * 
 * @author danilo
 *
 */
public class Veiculo implements Serializable {

  private static final long serialVersionUID = 1L;
  private Long id;
  private Double capacidadeTanque;
  private String placa;
  private String codigoFipe;
  private Double valorCompra;
  private Double autonomiaMinima;
  private Double mediaConsumoTotal;
  private Double autonomiaTanque;
  private Double precoRevendaFipe;

  public Veiculo() {
    super();
  }

  public Veiculo(Long id, Double capacidadeTanque, String placa, String codigoFipe, Double valorCompra,
      Double autonomiaMinima, Double mediaConsumoTotal, Double autonomiaTanque, Double precoRevendaFipe) {
    super();
    this.id = id;
    this.capacidadeTanque = capacidadeTanque;
    this.placa = placa;
    this.codigoFipe = codigoFipe;
    this.valorCompra = valorCompra;
    this.autonomiaMinima = autonomiaMinima;
    this.mediaConsumoTotal = mediaConsumoTotal;
    this.autonomiaTanque = autonomiaTanque;
    this.precoRevendaFipe = precoRevendaFipe;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Double getCapacidadeTanque() {
    return capacidadeTanque;
  }

  public void setCapacidadeTanque(Double capacidadeTanque) {
    this.capacidadeTanque = capacidadeTanque;
  }

  public String getPlaca() {
    return placa;
  }

  public void setPlaca(String placa) {
    this.placa = placa;
  }

  public String getCodigoFipe() {
    return codigoFipe;
  }

  public void setCodigoFipe(String codigoFipe) {
    this.codigoFipe = codigoFipe;
  }

  public Double getValorCompra() {
    return valorCompra;
  }

  public void setValorCompra(Double valorCompra) {
    this.valorCompra = valorCompra;
  }

  public Double getAutonomiaMinima() {
    return autonomiaMinima;
  }

  public void setAutonomiaMinima(Double autonomiaMinima) {
    this.autonomiaMinima = autonomiaMinima;
  }

  public Double getMediaConsumoTotal() {
    return mediaConsumoTotal;
  }

  public void setMediaConsumoTotal(Double mediaConsumoTotal) {
    this.mediaConsumoTotal = mediaConsumoTotal;
  }

  public Double getAutonomiaTanque() {
    return autonomiaTanque;
  }

  public void setAutonomiaTanque(Double autonomiaTanque) {
    this.autonomiaTanque = autonomiaTanque;
  }

  public Double getPrecoRevendaFipe() {
    return precoRevendaFipe;
  }

  public void setPrecoRevendaFipe(Double precoRevendaFipe) {
    this.precoRevendaFipe = precoRevendaFipe;
  }


  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((placa == null) ? 0 : placa.hashCode());
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
    Veiculo other = (Veiculo) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (placa == null) {
      if (other.placa != null)
        return false;
    } else if (!placa.equals(other.placa))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Veiculo [id=" + id + ", capacidadeTanque=" + capacidadeTanque + ", placa=" + placa + ", codigoFipe="
        + codigoFipe + ", valorCompra=" + valorCompra + ", autonomiaMinima=" + autonomiaMinima + ", mediaConsumoTotal="
        + mediaConsumoTotal + ", autonomiaTanque=" + autonomiaTanque + ", precoRevendaFipe=" + precoRevendaFipe
        + "]";
  }

  public static Veiculo setVeiculo(Veiculo c, Veiculo veiculo) {
    c.setAutonomiaMinima(veiculo.getAutonomiaMinima());
    c.setAutonomiaTanque(veiculo.getAutonomiaTanque());
    c.setCapacidadeTanque(veiculo.getCapacidadeTanque());
    c.setCodigoFipe(veiculo.getCodigoFipe());
    c.setPlaca(veiculo.getPlaca());
    c.setMediaConsumoTotal(veiculo.getMediaConsumoTotal());
    c.setPrecoRevendaFipe(veiculo.getPrecoRevendaFipe());
    c.setValorCompra(veiculo.getValorCompra()); 
    return c;
  }

}
