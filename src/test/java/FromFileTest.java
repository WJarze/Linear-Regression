
import dataReader.fromFile.FromFile;
import java.io.File;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FromFileTest {
    FromFile fromFile = new FromFile ( );
    File file = fromFile.getFile ( );
    @Test
    void shouldFailBecauseFileNotExist() {
        //given
        boolean bool = !file.exists ( );
        //then
        Assertions.assertFalse ( bool );
    }
}


