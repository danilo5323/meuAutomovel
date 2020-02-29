package br.com.dbsdev.meuautomovel.data.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class Combustivel implements Serializable {

    Long id;

    Float OdometroTotal;
    Long OdometroParcial;
    String TipoCombustivel;
    Float QuantidadeLitro;
    Float CustoPorLitro;
    Float CustoTotal;
    String NomeDoPosto;
    String DataAbastecimento;




    public Long getId() {
        return id;
    }

    public void setId(Long _id) {
        id = _id;
    }

    public Float getOdometroTotal() {
        return OdometroTotal;
    }

    public void setOdometroTotal(Float odometroTotal) {
        OdometroTotal = odometroTotal;
    }

    public Long getOdometroParcial() {
        return OdometroParcial;
    }

    public void setOdometroParcial(Long odometroParcial) {
        OdometroParcial = odometroParcial;
    }

    public String getTipoCombustivel() {
        return TipoCombustivel;
    }

    public void setTipoCombustivel(String tipoCombustivel) {
        TipoCombustivel = tipoCombustivel;
    }

    public Float getQuantidadeLitro() {
        return QuantidadeLitro;
    }

    public void setQuantidadeLitro(Float quantidadeLitro) {
        QuantidadeLitro = quantidadeLitro;
    }

    public Float getCustoPorLitro() {
        return CustoPorLitro;
    }

    public void setCustoPorLitro(Float custoPorLitro) {
        CustoPorLitro = custoPorLitro;
    }

    public Float getCustoTotal() {
        return CustoTotal;
    }

    public void setCustoTotal(Float custoTotal) {
        CustoTotal = custoTotal;
    }

    public String getNomeDoPosto() {
        return NomeDoPosto;
    }

    public void setNomeDoPosto(String nomeDoPosto) {
        NomeDoPosto = nomeDoPosto;
    }

    public String getDataAbastecimento() {
        return DataAbastecimento;
    }

    public void setDataAbastecimento(String dataAbastecimento) {
        DataAbastecimento = dataAbastecimento;
    }

    public Combustivel() {
        super();
    }

    public Combustivel(Long _id, Float odometroTotal, Long odometroParcial, String tipoCombustivel, Float quantidadeLitro, Float custoPorLitro, Float custoTotal, String nomeDoPosto, String dataAbastecimento) {
        super();
        id = _id;
        OdometroTotal = odometroTotal;
        OdometroParcial = odometroParcial;
        TipoCombustivel = tipoCombustivel;
        QuantidadeLitro = quantidadeLitro;
        CustoPorLitro = custoPorLitro;
        CustoTotal = custoTotal;
        NomeDoPosto = nomeDoPosto;
        DataAbastecimento = dataAbastecimento;
    }

    @Override
    public String toString() {
        return "Combustivel{" +
                "_id=" + id +
                ", OdometroTotal=" + OdometroTotal +
                ", OdometroParcial=" + OdometroParcial +
                ", TipoCombustivel='" + TipoCombustivel + '\'' +
                ", QuantidadeLitro=" + QuantidadeLitro +
                ", CustoPorLitro=" + CustoPorLitro +
                ", CustoTotal=" + CustoTotal +
                ", NomeDoPosto='" + NomeDoPosto + '\'' +
                ", DataAbastecimento=" + DataAbastecimento +
                '}';
    }
}
