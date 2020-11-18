package ungar.mvp.mvpontologija2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ungar.mvp.mvpontologija2.R;
import ungar.mvp.mvpontologija2.model.Ontologija;
import ungar.mvp.mvpontologija2.presenter.RecyclerViewClickListener;

public class AdapterListe extends RecyclerView.Adapter<AdapterListe.Red>{

    List<Ontologija> ontologija;
    private LayoutInflater layoutInflater;
    RecyclerViewClickListener recyclerViewClickListener;

    public AdapterListe(Context context){
        layoutInflater = LayoutInflater.from(context);
        ontologija = new ArrayList<>();
    }

    public void setOntologija(List<Ontologija> ontologija) {
        this.ontologija = ontologija;
    }

    @Override
    public Red onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.red_liste, parent, false);
        return new Red(view);
    }

    @Override
    public void onBindViewHolder(Red red, int position) {
        Ontologija o = ontologija.get(position);
        red.naziv.setText(o.getNaziv());
        red.tip.setText(o.getTip());
        red.opis.setText(o.getOpis());
        red.anotacija.setText(o.getAnotacija());
        //Picasso.get().load(o.getUrlSlika()).into(red.slika);

    }
    @Override
    public int getItemCount() {
        return ontologija==null ? 0 : ontologija.size();
    }

    public class Red extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView naziv, tip, opis, anotacija;

        public Red(@NonNull View itemView) {
            super(itemView);
            naziv = itemView.findViewById(R.id.naziv);
            tip = itemView.findViewById(R.id.tip);
            opis = itemView.findViewById(R.id.opis);
            anotacija = itemView.findViewById(R.id.anotacija);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(recyclerViewClickListener!=null){
                recyclerViewClickListener.onItemClick(ontologija.get(getAdapterPosition()));
            }
        }
    }

    public void setRecyclerViewClickListener(RecyclerViewClickListener recyclerViewClickListener) {
        this.recyclerViewClickListener = recyclerViewClickListener;
    }
}
