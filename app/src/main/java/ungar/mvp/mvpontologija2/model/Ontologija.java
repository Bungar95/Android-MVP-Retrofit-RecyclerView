package ungar.mvp.mvpontologija2.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Ontologija implements Serializable {

    private int sifra;
    private String naziv;
    private String tip;
    private String opis;
    private String anotacija;
}
