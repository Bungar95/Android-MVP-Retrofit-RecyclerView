package ungar.mvp.mvpontologija2.presenter;

import java.util.List;

import ungar.mvp.mvpontologija2.model.Ontologija;

public class CUDPresenter implements CUDSucelje.Presenter{

    private CUDSucelje.View mView;
    private CUDSucelje.Model model;
    private Ontologija ontologija;

    public CUDPresenter(CUDSucelje.View mView, Ontologija ontologija){
        this.mView = mView;
        this.model = model;
        this.ontologija = ontologija;
    }


    @Override
    public Ontologija getOntologija() {
        return ontologija;
    }

    @Override
    public void created() {
        mView.init();
    }

    @Override
    public void setNaziv(String naziv) {
        ontologija.setNaziv(naziv);
    }

    @Override
    public void setTip(String tip) {
        ontologija.setTip(tip);
    }

    @Override
    public void setOpis(String opis) {
        ontologija.setOpis(opis);
    }

    @Override
    public void setAnotacija(String anotacija) {
        ontologija.setAnotacija(anotacija);
    }

    @Override
    public void dodajElement() {
        model.dodajElement(ontologija);
    }
}
