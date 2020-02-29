package br.com.dbsdev.meuautomovel.data.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CombustivelHelper extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "dbGastosVeiculo";
    private static final int VERSAO_BANCO = 1;
    public static final String TABELA_REGISTRO_CONSUMO = "tbRegistroConsumo";
    public static final String COLUNA_ID = "_id";

    public static final String COLUNA_ODOMETRO_TOTAL    = "OdometroTotal";
    public static final String COLUNA_ODOMETRO_PARCIAL  = "OdometroParcial";
    public static final String COLUNA_TIPO_COMBUSTIVEL  = "TipoCombustivel";
    public static final String COLUNA_QUANTIDADE_LITROS = "QuantidadeLitro";
    public static final String COLUNA_CUSTO_POR_LITRO   = "CustoPorLitro";
    public static final String COLUNA_CUSTO_TOTAL       = "CustoTotal";
    public static final String COLUNA_NOME_POSTO        = "NomeDoPosto";
    public static final String COLUNA_DATA_ABASTECIMENTO = "DataAbastecimento";
    public CombustivelHelper(Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    private static String CREATE_TABLE_TABELA_REGISTRO_CONSUMO =  "CREATE TABLE " + TABELA_REGISTRO_CONSUMO + " (" +
            COLUNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUNA_ODOMETRO_TOTAL + " TEXT, " +
            COLUNA_ODOMETRO_PARCIAL + " TEXT, " +
            COLUNA_TIPO_COMBUSTIVEL + " TEXT, " +
            COLUNA_QUANTIDADE_LITROS + " TEXT, " +
            COLUNA_CUSTO_POR_LITRO + " TEXT, " +
            COLUNA_CUSTO_TOTAL + " TEXT, " +
            COLUNA_DATA_ABASTECIMENTO + " TEXT, " +
            COLUNA_NOME_POSTO  + " TEXT);";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
               CREATE_TABLE_TABELA_REGISTRO_CONSUMO
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}