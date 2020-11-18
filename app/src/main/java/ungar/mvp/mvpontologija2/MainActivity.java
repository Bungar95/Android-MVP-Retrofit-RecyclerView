package ungar.mvp.mvpontologija2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;



import butterknife.ButterKnife;
import butterknife.OnClick;
import ungar.mvp.mvpontologija2.adapter.AdapterListe;
import ungar.mvp.mvpontologija2.model.Ontologija;
import ungar.mvp.mvpontologija2.presenter.OntologijaPresenter;
import ungar.mvp.mvpontologija2.presenter.OntologijaSucelje;
import ungar.mvp.mvpontologija2.presenter.RecyclerViewClickListener;

public class MainActivity extends AppCompatActivity implements OntologijaSucelje.View, RecyclerViewClickListener {

    private OntologijaSucelje.Presenter mPresenter;
    private AdapterListe adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mPresenter = new OntologijaPresenter(this);
        mPresenter.created();
    }

    @Override
    public void init() {
        adapter = new AdapterListe(this);
        adapter.setRecyclerViewClickListener(this);
        RecyclerView recyclerView = findViewById(R.id.lista);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onGetResult(List<Ontologija> ontologijaList) {
        adapter.setOntologija(ontologijaList);
        adapter.notifyDataSetChanged();

    }

    @OnClick(R.id.fab)
    public void noviElement() {
        noviActivity(new Ontologija(), "dodaj");}


    @Override
    public void onItemClick(Ontologija ontologija) {
        Snackbar.make(
                findViewById(R.id.coordinatorID),
                "Sifra: " + ontologija.getSifra() + ", " + ontologija.getNaziv(),
                BaseTransientBottomBar.LENGTH_SHORT
        ).show();
    }

    public void noviActivity(Ontologija ontologija, String namjera){
        Intent intent = new Intent(
                this,CUDActivity.class);
        intent.putExtra("ontologija",ontologija);
        intent.putExtra("namjera",namjera);
        startActivity(intent);

    }
}