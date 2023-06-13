import org.henrique.entidades.UsuarioFornecedor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestUsuarioFornecedor {

    UsuarioFornecedor usuario = new UsuarioFornecedor(null,"hvs",
            "12130044407","24/04/2001","hvs@poli.br","12345678");

    @Test
    public void testeUsuarioComSenhaMenorque8Caracteres() {
        Assertions.assertTrue(usuario.validaSenha(usuario.getSenha()));
    }

    @Test
    public void testeUsuarioComNomeCompletoNulo() {
        Assertions.assertTrue(usuario.validaNome(usuario.getNomeCompleto()));
    }
}
