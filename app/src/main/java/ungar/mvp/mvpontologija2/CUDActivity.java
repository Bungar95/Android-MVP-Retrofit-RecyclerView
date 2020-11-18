package ungar.mvp.mvpontologija2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import butterknife.BindView;
import ungar.mvp.mvpontologija2.model.Ontologija;
import ungar.mvp.mvpontologija2.presenter.CUDPresenter;
import ungar.mvp.mvpontologija2.presenter.CUDSucelje;

public class CUDActivity extends AppCompatActivity implements CUDSucelje.View {

    @BindView(R.id.editNaziv)
    EditText naziv;
    @BindView(R.id.editTip)
    EditText tip;
    @BindView(R.id.editOpis)
    EditText opis;
    @BindView(R.id.editAnotacije)
    EditText anotacije;
    @BindView(R.id.btnDodaj)
    Button btnDodaj;

    private CUDSucelje.Presenter mPresenter;
    private Ontologija ontologija;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cud);
        mPresenter = new CUDPresenter(this, ontologija);
        mPresenter.created();
    }

    @Override
    public void init() {
        /* Dodati ću CUD nakon što implementiram Room bazu podataka */
        Snackbar.make(findViewById(R.id.cudLayout),"Trenutno ne radi.", BaseTransientBottomBar.LENGTH_LONG).show();
    }
}
