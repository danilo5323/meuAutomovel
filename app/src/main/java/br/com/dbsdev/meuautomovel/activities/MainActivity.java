package br.com.dbsdev.meuautomovel.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

import br.com.dbsdev.meuautomovel.R;
import br.com.dbsdev.meuautomovel.data.dto.Combustivel;
import br.com.dbsdev.meuautomovel.data.repository.CombustivelRepository;
import br.com.dbsdev.meuautomovel.adapter.AdapterConsumo;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerViewMedia = null;

    private CombustivelRepository cRepository = null;

    private TextView viewMediaGeral = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cRepository = new CombustivelRepository( this.getApplicationContext());

        setContentView(R.layout.activity_main);

        viewMediaGeral = findViewById( R.id.textViewMediaGeral);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);

        recyclerViewMedia = findViewById( R.id.recyclerViewMedia);



        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sendMessage(view);

               // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)  .setAction("Action", null).show();
            }
        });
    }

    private void setLista(){
        List<Combustivel> combustiveis = cRepository.getRegistros();

        AdapterConsumo adapter = new AdapterConsumo( combustiveis  );

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewMedia.setLayoutManager(layoutManager);
        recyclerViewMedia.setHasFixedSize(true);

        recyclerViewMedia.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));

        recyclerViewMedia.setAdapter(adapter);

    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, AdicionarAbastecimentoCombustivelActivity.class);
        intent.putExtra(Intent.EXTRA_REFERRER, "carregando");
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        setLista();
        setCamposValor();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        setLista();
        setCamposValor();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setCamposValor(){
        String media = "media geral de consumo: 40 km/l";
        viewMediaGeral.setText( media );
    }
}
