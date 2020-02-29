package br.com.dbsdev.meuautomovel.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Date;

import br.com.dbsdev.meuautomovel.R;
import br.com.dbsdev.meuautomovel.data.dto.Combustivel;
import br.com.dbsdev.meuautomovel.data.repository.CombustivelRepository;

public class AdicionarAbastecimentoCombustivelActivity extends AppCompatActivity {

    private CombustivelRepository cRepository = null;

    private EditText inputOdometroTotal = null;
    private EditText inputOdometroParcial = null;
    private EditText inputTipoCombustivel = null;
    private EditText inputQuantidadeLitro = null;
    private EditText inputCustoPorLitro = null;
    private EditText inputCustoTotal = null;
    private EditText inputNomeDoPosto = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_abastecimento_combustivel);

        cRepository = new CombustivelRepository( this.getApplicationContext());

        setFields();

        Button botaoAdicionar = findViewById(R.id.buttonAdicionarMediaConsumo);
        botaoAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                Float OdometroTotal = Float.valueOf( inputOdometroTotal.getEditableText().toString());
                Long OdometroParcial = Long.valueOf( inputOdometroParcial.getEditableText().toString());
                String TipoCombustivel = inputTipoCombustivel.getEditableText().toString();
                Float QuantidadeLitro =  Float.valueOf(inputQuantidadeLitro.getEditableText().toString());
                Float CustoPorLitro =Float.valueOf( inputCustoPorLitro.getEditableText().toString());
                Float CustoTotal = Float.valueOf(inputCustoTotal.getEditableText().toString());
                String NomeDoPosto = inputCustoTotal.getEditableText().toString();
                String DataAbastecimento = (new Date()).toString();

                cRepository.inserir(
                  new Combustivel( null, OdometroTotal, OdometroParcial, TipoCombustivel, QuantidadeLitro, CustoPorLitro, CustoTotal, NomeDoPosto, DataAbastecimento)
                );

                ativarActivityVoltar(view);

                // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)  .setAction("Action", null).show();
            }
        });
    }




    public  void ativarActivityVoltar(View view){
        finish();
    }

    public static class SettingsFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey);
        }
    }



    private void setFields(){
        this.inputOdometroTotal = findViewById(  R.id.editTextOdometroTotal );;
        this.inputOdometroParcial = findViewById(  R.id.editTextOdometroParcial );
        this.inputTipoCombustivel = findViewById( R.id.editTextTipoCombustivel);
        this.inputQuantidadeLitro = findViewById( R.id.editTextQuantidadeLitros);
        this.inputCustoPorLitro = findViewById((R.id.editTextCustoPorLitro));
        this.inputCustoTotal = findViewById((R.id.editTextCustoTotal));
        this.inputNomeDoPosto = findViewById((R.id.editTextPosto));
    }
}
