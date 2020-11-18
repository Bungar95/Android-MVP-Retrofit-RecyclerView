package ungar.mvp.mvpontologija2.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import ungar.mvp.mvpontologija2.model.Ontologija;

public interface OntologijaService {
    @GET("search/")
    Call<List<Ontologija>> getOntologija();

}
