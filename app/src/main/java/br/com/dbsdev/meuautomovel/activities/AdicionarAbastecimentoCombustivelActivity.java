package br.com.dbsdev.meuautomovel.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;
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

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_abastecimento_combustivel);

        cRepository = new CombustivelRepository( this.getApplicationContext());

        setFields();

        Button botaoAdicionar = findViewById(R.id.buttonAdicionarMediaConsumo);
        botaoAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    Boolean faltaAlgumCampo = false;

                    String velueOdometroTotal = inputOdometroTotal.getEditableText().toString();
                    if (velueOdometroTotal.isEmpty())
                        throw new RuntimeException(" campo Odometro total não foi informado");
                    Float odometroTotal = Float.valueOf(velueOdometroTotal);

                    String valueOdometroParcial = inputOdometroParcial.getEditableText().toString();
                    if (valueOdometroParcial.isEmpty())
                        throw new RuntimeException( "odometro parcial não foi informado");
                    Float odometroParcial = Float.valueOf(valueOdometroParcial);


                    String tipoCombustivel = inputTipoCombustivel.getEditableText().toString();
                    if (tipoCombustivel.isEmpty()) throw new RuntimeException( "tipo de combustivel não foi informado");

                    String valueQuantidadeLitro = inputQuantidadeLitro.getEditableText().toString();
                    if (valueQuantidadeLitro.isEmpty()) throw new RuntimeException( "quantidade de litros abastecidos não foi informado");
                    Float quantidadeLitro = Float.valueOf(valueQuantidadeLitro);

                    String valueCustoPorLitro = inputCustoPorLitro.getEditableText().toString();
                    if (valueCustoPorLitro.isEmpty()) throw new RuntimeException( "custo por litro abastecidos não foi informado");
                    Float custoPorLitro = Float.valueOf(valueCustoPorLitro);

                    String valueCustoTotal = inputCustoTotal.getEditableText().toString();
                    if (valueCustoTotal.isEmpty()) throw new RuntimeException( "custo total abastecidos não foi informado");
                    Float custoTotal = Float.valueOf(valueCustoTotal);


                    String nomeDoPosto = inputCustoTotal.getEditableText().toString();
                    if (nomeDoPosto.isEmpty())throw new RuntimeException( "nome do posto abastecidos não foi informado");

                    String dataAbastecimento = (new Date()).toString();


                    Float media = odometroParcial / quantidadeLitro;


                    cRepository.inserir(
                            new Combustivel(null, odometroTotal, odometroParcial, tipoCombustivel, quantidadeLitro, custoPorLitro, custoTotal, nomeDoPosto, dataAbastecimento, media)
                    );

                    ativarActivityVoltar(view);
                }catch
                (RuntimeException e) {
                    Snackbar.make(view, e.getMessage(), Snackbar.LENGTH_LONG)  .setAction("Action", null).show();
                }

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
