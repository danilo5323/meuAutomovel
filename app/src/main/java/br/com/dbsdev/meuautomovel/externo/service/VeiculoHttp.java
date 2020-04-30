package br.com.dbsdev.meuautomovel.externo.service;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import br.com.dbsdev.meuautomovel.externo.service.model.Veiculo;

public class VeiculoHttp {
    private static final String VEICULOS_URL_HTTP = "http://192.168.100.4:8080/veiculo";

    public static boolean hasConexao(Context cxt){
        ConnectivityManager cm = (ConnectivityManager) cxt.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        return (info != null && info.isConnected());
    }

    public static List<Veiculo> carregarVeiculos(){
        List<Veiculo> listaRetorno = downloadVeiculos(VEICULOS_URL_HTTP);
        return listaRetorno;
    }

    public static List<Veiculo> downloadVeiculos(String enderecoWeb){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Veiculo[]> response = restTemplate.getForEntity(enderecoWeb, Veiculo[].class);
        return Arrays.asList( response.getBody() );
    }

}
