import org.henrique.entidades.UsuarioColetor;
import org.henrique.repositorio.UsuarioColetorRepository;
import org.henrique.service.UsuarioColetorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

public class TestUsuarioColetor {
    @Test
    public void testCadastroUsuarioColetorComDadosValidos() {

        UsuarioColetor coletor = new UsuarioColetor();
        UsuarioColetorRepository repository = new UsuarioColetorRepository();
        UsuarioColetorService cadastro = new UsuarioColetorService(repository);

        coletor.setNomeUsuario("Juan e Priscila Limpeza Ltda");
        coletor.setCep("09350-441");
        coletor.setEmail("marketing@juanepriscilalimpezaltda.com.br");
        coletor.setSenha("L1mpez@a");
        coletor.setCnpj("62140729000110");

        String teste = cadastro.cadastrarUsuarioColetor(coletor);
        Assertions.assertEquals("Usuário Cadastrado com Sucesso!",teste);

    }

    @Test
    public void testCadastroUsuarioColetorJaCadastrado() {

        UsuarioColetor coletor = new UsuarioColetor();
        UsuarioColetorRepository repository = new UsuarioColetorRepository();
        UsuarioColetorService cadastro = new UsuarioColetorService(repository);

        coletor.setNomeUsuario("Juan e Priscila Limpeza Ltda");
        coletor.setCep("09350-441");
        coletor.setEmail("marketing@juanepriscilalimpezaltda.com.br");
        coletor.setSenha("L1mpez@a");
        coletor.setCnpj("62140729000110");

       cadastro.cadastrarUsuarioColetor(coletor);

        UsuarioColetor coletor2 = coletor;

        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> cadastro.cadastrarUsuarioColetor(coletor2));

        String mensagem = "Usuário já cadastrado no sistema!";

        Assertions.assertEquals(exception.getMessage(),mensagem);

    }

    @Test
    public void testCadastroUsuarioColetorComCepInvalido() {

        UsuarioColetor coletor = new UsuarioColetor();
        UsuarioColetorRepository repository = new UsuarioColetorRepository();
        UsuarioColetorService cadastro = new UsuarioColetorService(repository);

        coletor.setNomeUsuario("Juan e Priscila Limpeza Ltda");
        coletor.setCep("as");
        coletor.setEmail("marketing@juanepriscilalimpezaltda.com.br");
        coletor.setSenha("L1mpez@a");
        coletor.setCnpj("62140729000110");

        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> cadastro.cadastrarUsuarioColetor(coletor));

        String mensagem = "CEP inválido!";

        Assertions.assertEquals(exception.getMessage(),mensagem);

    }

    @Test
    public void cadastroUsuarioColetorComCNPJInvalido() {

        UsuarioColetor coletor = new UsuarioColetor();
        UsuarioColetorRepository repository = new UsuarioColetorRepository();
        UsuarioColetorService cadastro = new UsuarioColetorService(repository);

        coletor.setNomeUsuario("Juan e Priscila Limpeza Ltda");
        coletor.setCep("09350-441");
        coletor.setEmail("marketing@juanepriscilalimpezaltda.com.br");
        coletor.setSenha("L1mpez@a");
        coletor.setCnpj("10100729000110");

        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> cadastro.cadastrarUsuarioColetor(coletor));

        String mensagem = "Cnpj Inválido!";

        Assertions.assertEquals(exception.getMessage(), mensagem);

    }
}
