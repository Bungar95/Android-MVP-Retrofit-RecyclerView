package ungar.mvp.mvpontologija2.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import ungar.mvp.mvpontologija2.R;
import ungar.mvp.mvpontologija2.model.Ontologija;
import ungar.mvp.mvpontologija2.presenter.OntologijaSucelje;
import ungar.mvp.mvpontologija2.presenter.RecyclerViewClickListener;

import static java.security.AccessController.getContext;

public class AdapterListe extends RecyclerView.Adapter<AdapterListe.Red>{

    List<Ontologija> ontologija;
    RecyclerViewClickListener recyclerViewClickListener;

    public AdapterListe(List<Ontologija> ontologija, RecyclerViewClickListener listener) {
        this.ontologija = ontologija;
        this.recyclerViewClickListener = listener;
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
        red.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerViewClickListener.onItemClick(o);
            }
        });
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
