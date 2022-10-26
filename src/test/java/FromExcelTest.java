import java.io.File;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FromExcelTest {
    File file;

    @BeforeEach
    void setUp() {
        //when
        file = new File("data.xlsx");
    }

    @Test
    void shouldFailBecauseFileNotExist() {

        //given
        boolean bool = !file.exists ();
        //then
        Assertions.assertFalse ( bool );
    }
}
