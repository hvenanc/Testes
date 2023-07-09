import org.henrique.entidades.UsuarioColetor;
import org.henrique.repositorio.UsuarioColetorRepository;
import org.henrique.service.UsuarioColetorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestUsuarioColetor {

    @Test
    public void testCadastroUsuarioColetorComDadosValidos() {

        UsuarioColetor coletor = new UsuarioColetor();
        UsuarioColetorRepository repository = new UsuarioColetorRepository();
        UsuarioColetorService cadastro = new UsuarioColetorService(repository);

        coletor.setNomeUsuario("Juan e Priscila Limpeza Ltda");
        coletor.setCep("09350441");
        coletor.setEmail("marketing@juanepriscilalimpezaltda.com.br");
        coletor.setSenha("L1mpez@a");
        coletor.setCnpj("62140729000110");

        String teste = cadastro.cadastrarUsuarioColetor(coletor);
        Assertions.assertEquals("Usuário Cadastrado com Sucesso!",teste);

    }
}
