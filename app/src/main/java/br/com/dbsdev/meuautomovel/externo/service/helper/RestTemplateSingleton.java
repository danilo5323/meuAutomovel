package br.com.dbsdev.meuautomovel.externo.service.helper;

import android.content.Context;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Collections;

/**
 * Created by wolmir on 18/12/17.
 */
public class RestTemplateSingleton {

    private static RestTemplateSingleton restTemplateSingleton;
    private RestTemplate restTemplate;

    private RestTemplateSingleton(Context context) {
        restTemplate = new RestTemplate();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(objectMapper);

        restTemplate.getMessageConverters().add(converter);
        restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
    }

    public static RestTemplateSingleton getInstance(Context context) {
        if ( restTemplateSingleton == null ) {
            restTemplateSingleton = new RestTemplateSingleton(context);
        }
        return restTemplateSingleton;
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

}
