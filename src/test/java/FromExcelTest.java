import dataReader.fromExcel.FromExcel;
import java.io.File;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FromExcelTest {
    FromExcel fromExcel = new FromExcel ( );
    File file = fromExcel.getFile ( );

    @Test
    void shouldFailBecauseFileNotExist() {
        //given
        boolean bool = !file.exists ( );
        //then
        Assertions.assertFalse ( bool );
    }
}
