package org.henrique.service;

import org.henrique.entidades.UsuarioColetor;
import org.henrique.repositorio.UsuarioColetorRepository;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsuarioColetorService {

    private final UsuarioColetorRepository repositorio;

    public UsuarioColetorService(UsuarioColetorRepository repositorio) {
        this.repositorio = repositorio;
    }

    public String cadastrarUsuarioColetor(UsuarioColetor coletor) {

        String senha = coletor.getSenha();
        String nomeUsuario = coletor.getNomeUsuario();
        String email = coletor.getEmail();
        String cnpj = coletor.getCnpj();
        String cep = coletor.getCep();

        if(!validaCnpj(cnpj)) {
            throw new RuntimeException("Cnpj Inválido!");
        }

        else if(senha.length() < 8 || senha.length() > 32) {
            throw new RuntimeException("A senha não atende aos padrões exigidos!");
        }
        else if(nomeUsuario == null || nomeUsuario.equals("")) {
            throw new RuntimeException("Insira um nome válido!");
        }

        else if(cep == null || cep.equals("")) {
            throw new RuntimeException("Insira um CEP válido!");
        }

        else if(!validaEmail(email)) {
            throw new RuntimeException("E-mail Inválido");
        }

        repositorio.inserirColetor(coletor);
        return "Usuário Cadastrado com Sucesso!";
    }

    public boolean validaEmail(String email) {
        String regx = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern = Pattern.compile(regx);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public  boolean validaCnpj( String str_cnpj ) {
        try {
            str_cnpj = str_cnpj.replace('.', ' ');
            str_cnpj = str_cnpj.replace('/', ' ');
            str_cnpj = str_cnpj.replace('-', ' ');
            str_cnpj = str_cnpj.replaceAll(" ", "");
            int soma = 0, aux, dig;
            String cnpj_calc = str_cnpj.substring(0, 12);

            if (str_cnpj.length() != 14)
                return false;
            char[] chr_cnpj = str_cnpj.toCharArray();
            /* Primeira parte */
            for (int i = 0; i < 4; i++)
                if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9)
                    soma += (chr_cnpj[i] - 48) * (6 - (i + 1));
            for (int i = 0; i < 8; i++)
                if (chr_cnpj[i + 4] - 48 >= 0 && chr_cnpj[i + 4] - 48 <= 9)
                    soma += (chr_cnpj[i + 4] - 48) * (10 - (i + 1));
            dig = 11 - (soma % 11);
            cnpj_calc += (dig == 10 || dig == 11) ?
                    "0" : Integer.toString(dig);
            /* Segunda parte */
            soma = 0;
            for (int i = 0; i < 5; i++)
                if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9)
                    soma += (chr_cnpj[i] - 48) * (7 - (i + 1));
            for (int i = 0; i < 8; i++)
                if (chr_cnpj[i + 5] - 48 >= 0 && chr_cnpj[i + 5] - 48 <= 9)
                    soma += (chr_cnpj[i + 5] - 48) * (10 - (i + 1));
            dig = 11 - (soma % 11);
            cnpj_calc += (dig == 10 || dig == 11) ?
                    "0" : Integer.toString(dig);
            return str_cnpj.equals(cnpj_calc);
        } catch (Exception e) {
            System.err.println("Erro !" + e);
            return false;
        }

    }
}
