package br.com.dbsdev.meuautomovel.data.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MediaConsumoHelper extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "dbGastosVeiculo";
    private static final int VERSAO_BANCO = 1;
    public static final String TABELA_MEDIA_CONSUMO = "tbMediaConsumo";
    public static final String COLUNA_ID = "_id";
    public static final String COLUNA_MEDIA = "media";

    public MediaConsumoHelper(Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }


    private static String CREATE_TABLE_TABELA_MEDIA_CONSUMO =  "CREATE TABLE " + TABELA_MEDIA_CONSUMO + " (" +
            COLUNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUNA_MEDIA +  " DECIMAL);";

    private static String CREATE_TABLE_MEDIA_CONSUMO;
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                CREATE_TABLE_TABELA_MEDIA_CONSUMO
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}