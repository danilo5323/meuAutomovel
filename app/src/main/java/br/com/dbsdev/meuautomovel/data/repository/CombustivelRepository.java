package br.com.dbsdev.meuautomovel.data.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

import br.com.dbsdev.meuautomovel.data.dto.Combustivel;
import br.com.dbsdev.meuautomovel.data.helper.CombustivelHelper;

public class CombustivelRepository {

    private CombustivelHelper helper;

    public CombustivelRepository(Context ctx){
        helper = new CombustivelHelper(ctx);

    }


    public long inserir(Combustivel senha){
        SQLiteDatabase db = helper.getWritableDatabase();

        if(senha.getCustoPorLitro() == null) throw new RuntimeException( "" );

        ContentValues cv = new ContentValues();
        cv.put( CombustivelHelper.COLUNA_CUSTO_POR_LITRO, senha.getCustoPorLitro());
        cv.put( CombustivelHelper.COLUNA_CUSTO_TOTAL, senha.getCustoTotal());
        cv.put( CombustivelHelper.COLUNA_ODOMETRO_TOTAL , senha.getOdometroTotal());
        cv.put( CombustivelHelper.COLUNA_ODOMETRO_PARCIAL , senha.getOdometroParcial());
        cv.put( CombustivelHelper.COLUNA_TIPO_COMBUSTIVEL , senha.getTipoCombustivel());
        cv.put( CombustivelHelper.COLUNA_QUANTIDADE_LITROS, senha.getQuantidadeLitro());
        cv.put( CombustivelHelper.COLUNA_NOME_POSTO , senha.getNomeDoPosto());
        cv.put( CombustivelHelper.COLUNA_DATA_ABASTECIMENTO, senha.getDataAbastecimento());
        cv.put( CombustivelHelper.COLUNA_MEDIA_CONSUMO, senha.getMediaConsumo());
        Long id = db.insert(CombustivelHelper.TABELA_REGISTRO_CONSUMO, null, cv);


        if(id!=-1)
            senha.setId(id);

        db.close();
        return id;
    }

    public List<Combustivel> getRegistros( ){
        SQLiteDatabase db = helper.getReadableDatabase();

        String sql  = "SELECT * FROM " + CombustivelHelper.TABELA_REGISTRO_CONSUMO + " ORDER BY " + CombustivelHelper.COLUNA_ID +" DESC";

        List<Combustivel> senhas = new ArrayList<>();

        String[] argumentos = null;
        Cursor cursor = db.rawQuery(sql, argumentos);
        while(cursor.moveToNext()){

            Long id = cursor.getLong( cursor.getColumnIndex( CombustivelHelper.COLUNA_ID));
            Float custoPorLitro = cursor.getFloat(cursor.getColumnIndex( CombustivelHelper.COLUNA_CUSTO_POR_LITRO));
            Float custoTotal = cursor.getFloat(cursor.getColumnIndex( CombustivelHelper.COLUNA_CUSTO_TOTAL));
            Float odometroTotal = cursor.getFloat(cursor.getColumnIndex(CombustivelHelper.COLUNA_ODOMETRO_TOTAL ));
            Float odometroParcial = cursor.getFloat(cursor.getColumnIndex(CombustivelHelper.COLUNA_ODOMETRO_PARCIAL ));
            String tipoCombustivel = cursor.getString(cursor.getColumnIndex(CombustivelHelper.COLUNA_TIPO_COMBUSTIVEL ));
            Float quantidadeLitro = cursor.getFloat(cursor.getColumnIndex(CombustivelHelper.COLUNA_QUANTIDADE_LITROS ));
            String nomeDoPosto  = cursor.getString(cursor.getColumnIndex(CombustivelHelper.COLUNA_NOME_POSTO ));
            String dataAbastecimento =  cursor.getString(cursor.getColumnIndex((CombustivelHelper.COLUNA_DATA_ABASTECIMENTO)))  ;
            Float media = Float.valueOf(cursor.getString( cursor.getColumnIndex(CombustivelHelper.COLUNA_MEDIA_CONSUMO) ));

            Combustivel combustivel = new Combustivel( id,
                    odometroTotal,
                     odometroParcial,
                     tipoCombustivel,
                     quantidadeLitro,
                    custoPorLitro,
                    custoTotal,
                    nomeDoPosto,
                    dataAbastecimento,
                    media) ;

                senhas.add(  combustivel );
        }

        cursor.close();
        db.close();
        return senhas;

    }
}
