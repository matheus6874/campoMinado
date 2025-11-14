import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TesteSimples {
    @Test
    public void testeSimples1Mais1() {
        // Verifica se a soma de 1 + 1 (o valor REAL) é igual a 2 (o valor ESPERADO).
        // Se for diferente, o teste falha.
        assertEquals(2, 1 + 1, "O teste 1+1 deve sempre retornar 2.");
    }
}
