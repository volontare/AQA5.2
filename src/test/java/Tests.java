import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class Tests {
    private final UserGenerator userGenerator = new UserGenerator();

    @BeforeEach
    void setUp() {
        open("http://localhost:9999");
    }

    @Test
    void shouldTestValidActive() {
        UserData data = userGenerator.generateActiveUser();
        $("[name='login']").setValue(data.getLogin());
        $("[name='password'").setValue(data.getPassword());
        $("[data-test-id='action-login']").click();
        $(withText("Личный кабинет")).waitUntil(Condition.visible, 3000);
    }

    @Test
    void shouldTestValidBlockedUser() {
        UserData data = userGenerator.generateBlockedUser();
        $("[name='login']").setValue(data.getLogin());
        $("[name='password'").setValue(data.getPassword());
        $("[data-test-id='action-login']").click();
        $(withText("Пользователь заблокирован")).waitUntil(Condition.visible, 3000);
    }
    @Test
    void shouldTestActiveInvalidLogin() {
        UserData data = userGenerator.generateActiveUserInvalidLogin();
        $("[name='login']").setValue(data.getLogin());
        $("[name='password'").setValue(data.getPassword());
        $("[data-test-id='action-login']").click();
        $(withText("Неверно указан логин или пароль")).waitUntil(Condition.visible, 3000);
    }
    @Test
    void shouldTestActiveInvalidPassword() {
        UserData data = userGenerator.generateActiveUserInvalidPassword();
        $("[name='login']").setValue(data.getLogin());
        $("[name='password'").setValue(data.getPassword());
        $("[data-test-id='action-login']").click();
        $(withText("Неверно указан логин или пароль")).waitUntil(Condition.visible, 3000);
    }
    @Test
    void shouldTestBlockedInvalidLogin() {
        UserData data = userGenerator.generateBlockedUserInvalidLogin();
        $("[name='login']").setValue(data.getLogin());
        $("[name='password'").setValue(data.getPassword());
        $("[data-test-id='action-login']").click();
        $(withText("Неверно указан логин или пароль")).waitUntil(Condition.visible, 3000);
    }
    @Test
    void shouldTestBlockedInvalidPassword() {
        UserData data = userGenerator.generateBlockedUserInvalidPassword();
        $("[name='login']").setValue(data.getLogin());
        $("[name='password'").setValue(data.getPassword());
        $("[data-test-id='action-login']").click();
        $(withText("Неверно указан логин или пароль")).waitUntil(Condition.visible, 3000);
    }
}
