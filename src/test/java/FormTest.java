import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FormTest {

    @Test
    public void testGetId() {
        Form form = new Form(1, "Jeddah", "Contract1", "AlRawda",
                "21.22,39.12", "07/10/2024", "Fix Road", "Note 1");
        assertEquals(1, form.getId());
    }

    @Test
    public void testUpdateInfo() {
        Form form = new Form(1, "", "", "", "", "", "", "");
        form.updateInfo("Mecca", "Contract2", "Aziziyah", "22.11,39.55",
                "08/10/2024", "Lighting", "Updated Note");

        assertEquals("Mecca", form.municipality);
        assertEquals("Updated Note", form.notes);
    }
}
