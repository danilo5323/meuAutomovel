package br.com.dbsdev.meuautomovel.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import br.com.dbsdev.meuautomovel.R;
import br.com.dbsdev.meuautomovel.externo.service.VeiculoHttp;
import br.com.dbsdev.meuautomovel.externo.service.model.Veiculo;

public class VeiculoFragment extends Fragment {

    VeiculosTask mTask;
    TextView mTextMensagem;
    ProgressBar mProgressBar;
    ListView mListView;

    List<Veiculo> mVeiculos;
    ArrayAdapter<Veiculo> mAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate( savedInstanceState );
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View layout = inflater.inflate(R.layout.fragment_veiculo_list, null);

        mTextMensagem = (TextView) layout.findViewById(android.R.id.empty);
        mProgressBar = (ProgressBar) layout.findViewById(R.id.progressBar);
        mListView = (ListView) layout.findViewById(R.id.list);
        mListView.setEmptyView(mTextMensagem);
        return layout;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){

        super.onActivityCreated(savedInstanceState);
        if(mVeiculos == null){mVeiculos = new ArrayList<Veiculo>();}
        mAdapter = new ArrayAdapter<Veiculo>(getActivity(), android.R.layout.simple_list_item_1, mVeiculos);
        mListView.setAdapter(mAdapter);
        if(mTask == null)
        {
            if(VeiculoHttp.hasConexao(getActivity())){
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
            mTask = new VeiculosTask();
            mTask.execute();
        }
    }

    class VeiculosTask extends AsyncTask<Void, Void, List<Veiculo>>{

        @Override
        protected  void onPreExecute(){
            super.onPreExecute();
            exibirProgresso(true);
        }

        @Override
        protected List<Veiculo> doInBackground(Void... voids) {
            return VeiculoHttp.carregarVeiculos();
        }

        @Override
        protected void onPostExecute(List<Veiculo> veiculos){
            super.onPostExecute(veiculos);
            exibirProgresso(false);
            if(veiculos != null){
                mVeiculos.clear();
                mVeiculos.addAll(veiculos);
                mAdapter.notifyDataSetChanged();
            }
            else{
                mTextMensagem.setText("falha ao obter veiculos, tente mais tarde");
            }
        }

    }
}
