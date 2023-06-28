import org.henrique.entidades.UsuarioFornecedor;
import org.henrique.repositorio.UsuarioFornecedorRepositorio;
import org.henrique.service.CadastroUsuarioFornecedor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestUsuarioFornecedor {

    @Test
    public void testeUsuarioComSenhaMenorque8Caracteres() {

        UsuarioFornecedor usuarioFornecedor = new UsuarioFornecedor();
        UsuarioFornecedorRepositorio repositorio = new UsuarioFornecedorRepositorio();
        CadastroUsuarioFornecedor cadastro = new CadastroUsuarioFornecedor(repositorio);

        usuarioFornecedor.setNomeCompleto("Henrique Venâncio");
        usuarioFornecedor.setNomeUsuario("hvs");
        usuarioFornecedor.setCpf("34844609033");
        usuarioFornecedor.setDataNascimento("24/04/2011");
        usuarioFornecedor.setSenha("788");
        usuarioFornecedor.setEmail("hvs@poli.br");

        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> cadastro.cadastraoUsuarioForncedor(usuarioFornecedor));

        String mensagem = "A senha não atende aos padrões exigidos!";

        Assertions.assertEquals(exception.getMessage(),mensagem);

    }

    @Test
    public void cadastrodeUsuarioFornecedorComDadosValidos() {

        UsuarioFornecedor usuarioFornecedor = new UsuarioFornecedor();
        UsuarioFornecedorRepositorio repositorio = new UsuarioFornecedorRepositorio();
        CadastroUsuarioFornecedor cadastro = new CadastroUsuarioFornecedor(repositorio);

        usuarioFornecedor.setNomeCompleto("Henrique Venâncio");
        usuarioFornecedor.setNomeUsuario("hvs");
        usuarioFornecedor.setCpf("34844609033");
        usuarioFornecedor.setDataNascimento("29/05/2011");
        usuarioFornecedor.setSenha("9400030448");
        usuarioFornecedor.setEmail("hvs@poli.br");

        String teste = cadastro.cadastraoUsuarioForncedor(usuarioFornecedor);
        Assertions.assertEquals("Usuário Cadastrado com Sucesso!",teste);

    }

    @Test
    public void testeUsuarioComNomeCompletoNulo() {

        UsuarioFornecedor usuarioFornecedor = new UsuarioFornecedor();
        UsuarioFornecedorRepositorio repositorio = new UsuarioFornecedorRepositorio();
        CadastroUsuarioFornecedor cadastro = new CadastroUsuarioFornecedor(repositorio);

        usuarioFornecedor.setNomeCompleto(null);
        usuarioFornecedor.setNomeUsuario("hvs");
        usuarioFornecedor.setCpf("58087777777");
        usuarioFornecedor.setDataNascimento("24/04/2011");
        usuarioFornecedor.setSenha("94003046");
        usuarioFornecedor.setEmail("hvs@poli.br");

        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> cadastro.cadastraoUsuarioForncedor(usuarioFornecedor));

        String mensagem = "Insira um nome válido!";

        Assertions.assertEquals(exception.getMessage(),mensagem);

    }

}
