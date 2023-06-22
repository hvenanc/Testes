package org.henrique;

import org.henrique.entidades.UsuarioFornecedor;
import org.henrique.repositorio.UsuarioFornecedorRepositorio;
import org.henrique.service.CadastroUsuarioFornecedor;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        UsuarioFornecedor usuarioFornecedor = new UsuarioFornecedor();

        usuarioFornecedor.setNomeCompleto("Henrique Venâncio");
        usuarioFornecedor.setNomeUsuario("hvs");
        usuarioFornecedor.setCpf("13130094407");
        usuarioFornecedor.setDataNascimento("24/04/2011");
        usuarioFornecedor.setSenha("12");
        usuarioFornecedor.setEmail("hvspoli.br");

        UsuarioFornecedorRepositorio dados = new UsuarioFornecedorRepositorio();
        dados.inserirUsuario(usuarioFornecedor);
        List<UsuarioFornecedor> usuarios = dados.getUsuarios();
        System.out.println(usuarios.get(0).getEmail());


    }
}