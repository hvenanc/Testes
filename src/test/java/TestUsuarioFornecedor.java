import org.henrique.entidades.UsuarioFornecedor;
import org.henrique.repositorio.UsuarioFornecedorRepositorio;
import org.henrique.service.UsuarioFornecedorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestUsuarioFornecedor {

    @Test
    public void testeUsuarioComSenhaMenorque8Caracteres() {

        UsuarioFornecedor usuarioFornecedor = new UsuarioFornecedor();
        UsuarioFornecedorRepositorio repositorio = new UsuarioFornecedorRepositorio();
        UsuarioFornecedorService cadastro = new UsuarioFornecedorService(repositorio);

        usuarioFornecedor.setNomeCompleto("Henrique Venâncio");
        usuarioFornecedor.setNomeUsuario("hvs");
        usuarioFornecedor.setCpf("34844609033 ");
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
        UsuarioFornecedorService cadastro = new UsuarioFornecedorService(repositorio);

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
        UsuarioFornecedorService cadastro = new UsuarioFornecedorService(repositorio);

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

    @Test
    public void cadastroUsuarioComEmailJaCadastrado() {

        UsuarioFornecedor usuarioFornecedor = new UsuarioFornecedor();
        UsuarioFornecedor usuarioFornecedor1 = new UsuarioFornecedor();
        UsuarioFornecedorRepositorio repositorio = new UsuarioFornecedorRepositorio();
        UsuarioFornecedorService cadastro = new UsuarioFornecedorService(repositorio);

        usuarioFornecedor.setNomeCompleto("Henrique Venâncio");
        usuarioFornecedor.setNomeUsuario("hvs");
        usuarioFornecedor.setCpf("34844609033");
        usuarioFornecedor.setDataNascimento("29/05/2011");
        usuarioFornecedor.setSenha("9400030448");
        usuarioFornecedor.setEmail("hvs@poli.br");

        cadastro.cadastraoUsuarioForncedor(usuarioFornecedor);

        usuarioFornecedor1.setNomeCompleto("Helana Vitoria dos Santos");
        usuarioFornecedor1.setNomeUsuario("lena");
        usuarioFornecedor1.setCpf("09706331069");
        usuarioFornecedor1.setDataNascimento("24/05/2000");
        usuarioFornecedor1.setSenha("Çemha@201");
        usuarioFornecedor1.setEmail("hvs@poli.br");

        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> cadastro.cadastraoUsuarioForncedor(usuarioFornecedor1));

        String mensagem = "E-mail já cadastrado";

        Assertions.assertEquals(exception.getMessage(),mensagem);
    }


}
