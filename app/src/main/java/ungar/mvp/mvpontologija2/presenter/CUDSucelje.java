package ungar.mvp.mvpontologija2.presenter;

import java.util.List;

import ungar.mvp.mvpontologija2.model.Ontologija;

public interface CUDSucelje {

    interface Presenter{
        Ontologija getOntologija();
        void created();

        void setNaziv(String naziv);
        void setTip(String tip);
        void setOpis(String opis);
        void setAnotacija(String anotacija);

        void dodajElement();
    }

    interface View {
        void init();
    }

    interface Model {
        void dodajElement(Ontologija ontologija);
    }

}
