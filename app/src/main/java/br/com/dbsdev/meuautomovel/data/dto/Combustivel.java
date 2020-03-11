package br.com.dbsdev.meuautomovel.data.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class Combustivel implements Serializable {

    Long id;

    Float OdometroTotal;
    Float OdometroParcial;
    String TipoCombustivel;
    Float QuantidadeLitro;
    Float CustoPorLitro;
    Float CustoTotal;
    String NomeDoPosto;
    String DataAbastecimento;
    Float MediaConsumo;

    public Float getMediaConsumo() {
        return MediaConsumo;
    }

    public void setMediaConsumo(Float mediaConsumo) {
        MediaConsumo = mediaConsumo;
    }

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

        if(odometroTotal == null) OdometroTotal = 0F;

        OdometroTotal = odometroTotal;
    }

    public Float getOdometroParcial() {
        return OdometroParcial;
    }

    public void setOdometroParcial(Float odometroParcial) {

        if(odometroParcial == null) throw new NumberFormatException("odometro não pode estar vazio");
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
        if(quantidadeLitro == null) throw new NumberFormatException( "Deve ser informado a quantidade de litros abastecidos" );
        QuantidadeLitro = quantidadeLitro;
    }

    public Float getCustoPorLitro() {

        return CustoPorLitro;
    }

    public void setCustoPorLitro(Float custoPorLitro) {
        if(custoPorLitro == null) throw new NumberFormatException( "Deve ser informado o custo por litro abastecido" );

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

    public Combustivel(Long _id, Float odometroTotal, Float odometroParcial, String tipoCombustivel, Float quantidadeLitro, Float custoPorLitro, Float custoTotal, String nomeDoPosto, String dataAbastecimento, Float mediaConsumo) {
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
        MediaConsumo = mediaConsumo;
    }

    @Override
    public String toString() {
        return "Combustivel{" +
                "id=" + id +
                ", OdometroTotal=" + OdometroTotal +
                ", OdometroParcial=" + OdometroParcial +
                ", TipoCombustivel='" + TipoCombustivel + '\'' +
                ", QuantidadeLitro=" + QuantidadeLitro +
                ", CustoPorLitro=" + CustoPorLitro +
                ", CustoTotal=" + CustoTotal +
                ", NomeDoPosto='" + NomeDoPosto + '\'' +
                ", DataAbastecimento='" + DataAbastecimento + '\'' +
                ", MediaConsumo=" + MediaConsumo +
                '}';
    }
}
