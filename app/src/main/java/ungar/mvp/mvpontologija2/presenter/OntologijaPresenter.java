package ungar.mvp.mvpontologija2.presenter;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ungar.mvp.mvpontologija2.model.Ontologija;
import ungar.mvp.mvpontologija2.network.OntologijaService;
import ungar.mvp.mvpontologija2.network.RetrofitKlijent;

public class OntologijaPresenter implements OntologijaSucelje.Presenter {

    OntologijaSucelje.View mView;

    public OntologijaPresenter(OntologijaSucelje.View mView) {
        this.mView = mView;
    }


    @Override
    public void created() {
        mView.init();
        this.getOntologijaData();
    }

    @Override
    public void getOntologijaData() {
        OntologijaService service = RetrofitKlijent.getRetrofitInstance().create(OntologijaService.class);
        Call<List<Ontologija>> call = service.getOntologija();
        call.enqueue(new Callback<List<Ontologija>>() {
            @Override
            public void onResponse(Call<List<Ontologija>> call, Response<List<Ontologija>> response) {
                List<Ontologija> ontologijaList = response.body();
                mView.onGetResult(ontologijaList);
            }

            @Override
            public void onFailure(Call<List<Ontologija>> call, Throwable t) {
                Log.d("Retrofit API", String.valueOf(t));
            }
        });
    }
}
