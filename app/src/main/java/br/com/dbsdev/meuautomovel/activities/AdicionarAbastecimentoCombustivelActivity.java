package br.com.dbsdev.meuautomovel.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.dbsdev.meuautomovel.R;

public class AdicionarAbastecimentoCombustivelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_abastecimento_combustivel);



        Button botaoAdicionar = findViewById(R.id.buttonAdicionarMediaConsumo);
        botaoAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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
}
