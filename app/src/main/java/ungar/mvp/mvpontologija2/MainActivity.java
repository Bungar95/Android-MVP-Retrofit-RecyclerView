package ungar.mvp.mvpontologija2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;



import butterknife.ButterKnife;
import ungar.mvp.mvpontologija2.adapter.AdapterListe;
import ungar.mvp.mvpontologija2.model.Ontologija;
import ungar.mvp.mvpontologija2.presenter.OntologijaPresenter;
import ungar.mvp.mvpontologija2.presenter.OntologijaSucelje;
import ungar.mvp.mvpontologija2.presenter.RecyclerViewClickListener;

public class MainActivity extends AppCompatActivity implements OntologijaSucelje.View, RecyclerViewClickListener {

    private OntologijaSucelje.Presenter mPresenter;
    private RecyclerView recyclerView;
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
        recyclerView = findViewById(R.id.lista);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onGetResult(List<Ontologija> ontologijaList) {
        adapter.setOntologija(ontologijaList);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onItemClick(Ontologija ontologija) {
        Snackbar.make(recyclerView, "klik", BaseTransientBottomBar.LENGTH_SHORT).show();
    }
}