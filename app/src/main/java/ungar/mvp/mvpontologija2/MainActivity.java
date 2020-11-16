package ungar.mvp.mvpontologija2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ungar.mvp.mvpontologija2.adapter.AdapterListe;
import ungar.mvp.mvpontologija2.model.Ontologija;
import ungar.mvp.mvpontologija2.presenter.OntologijaPresenter;
import ungar.mvp.mvpontologija2.presenter.OntologijaSucelje;
import ungar.mvp.mvpontologija2.presenter.RecyclerViewClickListener;

public class MainActivity extends AppCompatActivity implements OntologijaSucelje.View {

    private OntologijaSucelje.Presenter mPresenter;
    private RecyclerView recyclerView;
    private AdapterListe adapter;
    private List<Ontologija> ontologija;

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
        recyclerView = (RecyclerView) findViewById(R.id.lista);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ontologija = new ArrayList<>();
        adapter = new AdapterListe(ontologija, new RecyclerViewClickListener() {
            @Override
            public void onItemClick(Ontologija ontologija) {
                Snackbar.make(recyclerView, "Klik: "+ ontologija.getNaziv(), BaseTransientBottomBar.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onGetResult(List<Ontologija> ontologijaList) {

        ontologija.addAll(ontologijaList);
        adapter.notifyDataSetChanged();

    }

}