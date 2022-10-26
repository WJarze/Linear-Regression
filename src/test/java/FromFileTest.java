
import java.io.File;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FromFileTest {
    File file;

    @BeforeEach
    void setUp() {
        //when

        file = new File ( "data.txt" );
    }
    @Test
    void shouldFailBecauseFileNotExist() {

        //given
        boolean bool = !file.exists ( );
        //then
        Assertions.assertFalse ( bool );
    }
}


