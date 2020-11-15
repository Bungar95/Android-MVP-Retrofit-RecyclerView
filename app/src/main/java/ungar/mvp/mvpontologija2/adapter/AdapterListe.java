package ungar.mvp.mvpontologija2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ungar.mvp.mvpontologija2.R;
import ungar.mvp.mvpontologija2.model.Ontologija;

public class AdapterListe extends RecyclerView.Adapter<AdapterListe.Red> {

    List<Ontologija> ontologija;

    public AdapterListe(List<Ontologija> ontologija) {
        this.ontologija = ontologija;
    }

    @Override
    public Red onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.red_liste, parent, false);
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
        /*red.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ontologijaClickListener.onItemClick(o);
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return ontologija==null ? 0 : ontologija.size();
    }

    public class Red extends RecyclerView.ViewHolder {

        TextView naziv, tip, opis, anotacija;

        public Red(View itemView) {
            super(itemView);
            naziv = itemView.findViewById(R.id.naziv);
            tip = itemView.findViewById(R.id.tip);
            opis = itemView.findViewById(R.id.opis);
            anotacija = itemView.findViewById(R.id.anotacija);
        }
    }
}
