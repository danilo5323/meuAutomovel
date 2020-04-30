package br.com.dbsdev.meuautomovel.externo;

import android.os.AsyncTask;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.dbsdev.meuautomovel.externo.service.model.Veiculo;

public class APITask extends AsyncTask<String, Void, List<String>> {

    @Override
    protected List<String> doInBackground(String... strings) {
        return null;
    }


    public static List<Veiculo> downloadString(String enderecoWeb){

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Veiculo[]> response = restTemplate.getForEntity(enderecoWeb, Veiculo[].class);
        return Arrays.asList( response.getBody() );
    }
}
