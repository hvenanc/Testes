package org.henrique.repositorio;

import org.henrique.entidades.UsuarioColetor;

import java.util.ArrayList;
import java.util.List;

public class UsuarioColetorRepository {

    private final List<UsuarioColetor> coletores = new ArrayList<>();

    public void inserirColetor(UsuarioColetor usuarioColetor) {
        coletores.add(usuarioColetor);
    }

    public List<UsuarioColetor> getColetores() {
        return this.coletores;
    }
}
