package ungar.mvp.mvpontologija2.presenter;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ungar.mvp.mvpontologija2.model.Ontologija;

public interface OntologijaSucelje {

    interface View{
        void init();

        void onGetResult(List<Ontologija> ontologijaList);

    }

    interface Presenter{

        void created();

        void getOntologijaData();

    }
}
