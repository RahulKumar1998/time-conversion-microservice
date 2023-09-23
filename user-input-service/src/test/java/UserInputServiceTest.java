import org.example.service.UserInputService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;



import static org.junit.jupiter.api.Assertions.assertEquals;


public class UserInputServiceTest {

    @InjectMocks
    private UserInputService userInputService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void testHandleUserInputForValidMidday(){
        String result = userInputService.handleUserInput("12:00");
        assertEquals("Its midday!", result);
    }

    @Test
    public void testHandleUserInputForValidMidnight(){
        String result = userInputService.handleUserInput("00:00");
        assertEquals("Its midnight!", result);
    }

    @Test
    public void testHandleUserInputForInvalidFormat() {
        try {
            userInputService.handleUserInput("invalid_input");
        } catch (RuntimeException e) {
            assertEquals("Invalid input format: invalid_input", e.getMessage());
        }
    }
}
