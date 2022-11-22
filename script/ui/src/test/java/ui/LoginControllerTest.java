package ui;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import java.io.IOException;

public class LoginControllerTest extends ApplicationTest {

    LoginController controller;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("Login.fxml"));
        Parent root = loader.load();
        controller = loader.getController();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @Test
    @DisplayName("Tests controller")
    public void testController() {
        assertNotNull(controller, "Controller should not be null.");
    }

    @Test
    @DisplayName("Tests login fields and login button visibility")
    public void testLogin() {
        clickOn("#usernameField");
        write("a");
        assertTrue(controller.getLoginButton().isDisabled(),
                "Button should be disabled when some fields are missing inputs");
        clickOn("#passwordField");
        write("i");
        assertFalse(controller.getLoginButton().isDisabled(),
                "User is supposed to be invalid to check that the invalid field works as intended");
        clickOn("#loginButton");
        assertTrue(controller.getInvalidField().isVisible(),
                "Button should be disabled when some fields are missing inputs");
        clickOn("#usernameField");
        press(KeyCode.BACK_SPACE);
        release(KeyCode.BACK_SPACE);
        assertTrue(controller.getLoginButton().isDisabled(),
                "Button should be disabled when some fields are missing inputs");
    }
}