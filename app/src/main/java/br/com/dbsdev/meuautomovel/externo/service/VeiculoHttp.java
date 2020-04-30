package br.com.dbsdev.meuautomovel.externo.service;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.util.List;

import br.com.dbsdev.meuautomovel.externo.APITask;
import br.com.dbsdev.meuautomovel.externo.service.model.Veiculo;

public class VeiculoHttp {
    private static final String VEICULOS_URL_HTTP = "http://192.168.100.4:8080/veiculo";

    public static boolean hasConexao(Context cxt){
        ConnectivityManager cm = (ConnectivityManager) cxt.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        return (info != null && info.isConnected());
    }

    public static List<Veiculo> carregarVeiculos(){
        List<Veiculo> listaRetorno = APITask.downloadString(VEICULOS_URL_HTTP);
        return listaRetorno;
    }

}
