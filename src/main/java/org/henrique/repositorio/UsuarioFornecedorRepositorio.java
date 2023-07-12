package org.henrique.repositorio;

import org.henrique.entidades.UsuarioColetor;
import org.henrique.entidades.UsuarioFornecedor;

import java.util.ArrayList;
import java.util.List;

public class UsuarioFornecedorRepositorio {
    private final List<UsuarioFornecedor> usuarios = new ArrayList<>();

    public void inserirUsuario(UsuarioFornecedor usuario) {
        usuarios.add(usuario);
    }

    public List<UsuarioFornecedor> getUsuarios() {
        return this.usuarios;
    }

}
