package org.henrique.service;

import org.henrique.entidades.UsuarioFornecedor;
import org.henrique.repositorio.UsuarioFornecedorRepositorio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CadastroUsuarioFornecedor {
    private final UsuarioFornecedorRepositorio repositorio;

    public CadastroUsuarioFornecedor(UsuarioFornecedorRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public String cadastraoUsuarioForncedor(UsuarioFornecedor usuario) {

        String nomeCompleto = usuario.getNomeCompleto();
        String nomeUsuario = usuario.getNomeUsuario();
        String senha = usuario.getSenha();
        String cpf = usuario.getCpf();
        String data = usuario.getDataNascimento();
        String email = usuario.getEmail();

        if(senha.length() < 8 || senha.length() > 32) {
            throw new RuntimeException("A senha não atende aos padrões exigidos!");
        }
        else if(nomeCompleto == null || nomeCompleto.equals("")) {
            throw new RuntimeException("Insira um nome válido!");
        }
        else if(nomeUsuario == null || nomeUsuario.equals("")) {
            throw new RuntimeException("Insira um nome de usuário válido!");
        }
        else if(!validaCPF(cpf)) {
            throw new RuntimeException("CPF Inválido");
        }
        else if(!validaData(data)) {
            throw new RuntimeException("Data Inválida");
        }
        else if(!validaEmail(email)) {
            throw new RuntimeException("E-mail Inválido");
        }

        repositorio.inserirUsuario(usuario);
        return "Usuário Cadastrado com Sucesso!";
    }

    public boolean validaData(String data) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);

        try {
            sdf.parse(data);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public boolean validaCPF(String CPF) {
        if (CPF.equals("00000000000") || CPF.equals("11111111111") ||
                CPF.equals("22222222222") || CPF.equals("33333333333") ||
                CPF.equals("44444444444") || CPF.equals("55555555555") ||
                CPF.equals("66666666666") || CPF.equals("77777777777") ||
                CPF.equals("88888888888") || CPF.equals("99999999999") ||
                (CPF.length() != 11))
            return (false);

        char dig10, dig11;
        int sm, i, r, num, peso;


        try {
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {

                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char) (r + 48);
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else dig11 = (char) (r + 48);

            return (dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10));
        } catch (InputMismatchException erro) {
            return (false);
        }
    }

    public boolean validaEmail(String email) {
        String regx = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern = Pattern.compile(regx);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
