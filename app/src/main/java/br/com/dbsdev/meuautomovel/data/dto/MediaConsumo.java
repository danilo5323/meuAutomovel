package br.com.dbsdev.meuautomovel.data.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class MediaConsumo implements Serializable {


    String media;
    LocalDate dataAbastecimento;
    Long id;


    public MediaConsumo() {
        super();
    }

    public MediaConsumo(String media, LocalDate dataAbastecimento, Long id) {
        this.media = media;
        this.dataAbastecimento = dataAbastecimento;
        this.id = id;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public LocalDate getDataAbastecimento() {
        return dataAbastecimento;
    }

    public void setDataAbastecimento(LocalDate dataAbastecimento) {
        this.dataAbastecimento = dataAbastecimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
