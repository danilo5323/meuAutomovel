package br.com.dbsdev.meuautomovel.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import br.com.dbsdev.meuautomovel.R;
import br.com.dbsdev.meuautomovel.data.dto.Combustivel;

public class AdapterConsumo extends  RecyclerView.Adapter<AdapterConsumo.MyViewHolder> {
    private List<Combustivel> mDataset;
    public AdapterConsumo(List<Combustivel> combustiveis) {
        this.mDataset =   combustiveis ;

    }



    // Provide a suitable constructor (depends on the kind of dataset)
    public AdapterConsumo(Combustivel[] myDataset) {
        mDataset = Arrays.asList(  myDataset );
    }

    // Create new views (invoked by the layout manager)
    @Override
    public AdapterConsumo.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLista =  LayoutInflater.from(parent.getContext()) .inflate(R.layout.adapter_consumo_combustivel, parent, false);

        // MyViewHolder vh =;
        return  new MyViewHolder(itemLista);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Combustivel combustivel = mDataset.get( position  );

        String data =  combustivel.getDataAbastecimento();


       // data =
        holder.textViewDataAbastecimento  .setText( "data do abastecimento: " + data);
        holder.textViewTipoCombustivel  .setText( "combustivel: " + combustivel.getTipoCombustivel());
        holder.textViewCustoTotal    .setText( "total:  R$" +    ( combustivel.getCustoTotal()) ) ;
        holder.textViewLitrosAbastecidos .setText( "litros: " +  combustivel.getQuantidadeLitro());
        holder.textViewMeidaConsumo  .setText(     "media: " +   combustivel.getMediaConsumo() );
        holder.textViewOdometroParcial  .setText(  "odometro parcial: " +  combustivel.getOdometroParcial());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size() ;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewOdometroParcial ;
        TextView textViewTipoCombustivel;
        TextView textViewLitrosAbastecidos;
        TextView textViewCustoTotal;
        TextView textViewMeidaConsumo;
        TextView textViewDataAbastecimento;

        public MyViewHolder(View v) {
            super(v);
            textViewDataAbastecimento = v.findViewById( R.id.textViewDataAbastecimentoViewHolder);
            textViewOdometroParcial = v.findViewById( R.id.textViewOdometroParcialViewHolder);
            textViewTipoCombustivel = v.findViewById( R.id.textViewTipoCombustivelViewHolder);
            textViewLitrosAbastecidos = v.findViewById( R.id.textViewLitrosAbastecidosViewHolder);
            textViewCustoTotal = v.findViewById( R.id.textViewCustoTotalViewHolder);
            textViewMeidaConsumo = v.findViewById( R.id.textViewMediaViewHolder);


        }
    }
}
