package ungar.mvp.mvpontologija2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;

public class CUDActivity extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cud);
    }
}
