package br.com.dbsdev.meuautomovel.externo.service;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import br.com.dbsdev.meuautomovel.externo.service.model.Consumo;
import br.com.dbsdev.meuautomovel.externo.service.model.Veiculo;

public class ConsumoHttp {
    private static final String CONSUMO_URL_HTTP = "http://192.168.100.4:8080/consumo";

    public static boolean hasConexao(Context cxt){
        ConnectivityManager cm = (ConnectivityManager) cxt.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        return (info != null && info.isConnected());
    }

    public static List<Consumo> carregarConsumos(String placa){
        List<Consumo> listaRetorno = downloadConsumos(CONSUMO_URL_HTTP+ "/" + placa);
        return listaRetorno;
    }

    public static Consumo inserirConsumo(String placa, Consumo consumo){
        Consumo listaRetorno = salvarConsumo(CONSUMO_URL_HTTP, consumo);
        return listaRetorno;
    }

    private static List<Consumo> downloadConsumos(String enderecoWeb){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Consumo[]> response = restTemplate.getForEntity(enderecoWeb, Consumo[].class);
        return Arrays.asList( response.getBody() );
    }

    private static Consumo salvarConsumo(String enderecoWeb, Consumo consumo){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Consumo> response = restTemplate.postForEntity(enderecoWeb, consumo, Consumo.class);
        return response.getBody();
    }
}
