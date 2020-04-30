package br.com.dbsdev.meuautomovel.fragment;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.dbsdev.meuautomovel.R;
import br.com.dbsdev.meuautomovel.dummy.DummyContent;
import br.com.dbsdev.meuautomovel.dummy.DummyContent.DummyItem;
import br.com.dbsdev.meuautomovel.externo.service.ConsumoHttp;
import br.com.dbsdev.meuautomovel.externo.service.VeiculoHttp;
import br.com.dbsdev.meuautomovel.externo.service.model.Consumo;
import br.com.dbsdev.meuautomovel.externo.service.model.Veiculo;

public class ConsumoFragment extends Fragment {

    ConsumoFragment.ConsumosTask mTask;
    TextView mTextMensagem;
    ProgressBar mProgressBar;
    ListView mListView;

    List<Consumo> mConsumos;
    ArrayAdapter<Consumo> mAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate( savedInstanceState );
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View layout = inflater.inflate(R.layout.fragment_consumo_list, null);

        mTextMensagem = (TextView) layout.findViewById(android.R.id.empty);
        mProgressBar = (ProgressBar) layout.findViewById(R.id.progressBar);
        mListView = (ListView) layout.findViewById(R.id.list);
        mListView.setEmptyView(mTextMensagem);
        return layout;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){

        super.onActivityCreated(savedInstanceState);
        if(mConsumos == null){mConsumos = new ArrayList<Consumo>();}
        mAdapter = new ArrayAdapter<Consumo>(getActivity(), android.R.layout.simple_list_item_1, mConsumos);
        mListView.setAdapter(mAdapter);
        if(mTask == null)
        {
            if(ConsumoHttp.hasConexao(getActivity())){
                iniciarDownload();
            }
            else{
                mTextMensagem.setText("sem conexao");
            }
        }else if(mTask.getStatus() == AsyncTask.Status.RUNNING){
            exibirProgresso(true);
        }
    }

    public void exibirProgresso(boolean exibir){
        if(exibir){
            mTextMensagem.setText(("Baixando informações do veículo"));

        }
        mTextMensagem.setVisibility(exibir ? View.VISIBLE : View.GONE);
        mProgressBar.setVisibility(exibir ? View.VISIBLE : View.GONE);
    }

    public void iniciarDownload(){
        if(mTask == null || mTask.getStatus() != AsyncTask.Status.RUNNING){
            mTask = new ConsumoFragment.ConsumosTask();
            mTask.execute();
        }
    }

    class ConsumosTask extends AsyncTask<Void, Void, List<Consumo>>{

        @Override
        protected  void onPreExecute(){
            super.onPreExecute();
            exibirProgresso(true);
        }

        @Override
        protected List<Consumo> doInBackground(Void... voids) {
            return ConsumoHttp.carregarConsumos("32E");
        }

        @Override
        protected void onPostExecute(List<Consumo> Consumos){
            super.onPostExecute(Consumos);
            exibirProgresso(false);
            if(Consumos != null){
                mConsumos.clear();
                mConsumos.addAll(Consumos);
                mAdapter.notifyDataSetChanged();
            }
            else{
                mTextMensagem.setText("falha ao obter consumo, tente mais tarde");
            }
        }

    }

}