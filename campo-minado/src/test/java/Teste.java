import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Teste {
    @Test
    public void testarSeIgualADois() {
        int a = 1+1;
        assertEquals(2,a);
    }

    @Test
    public void testarSeIgualATres() {
        int a = 1+2;
        assertEquals(3,a);
    }
}
