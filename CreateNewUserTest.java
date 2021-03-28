package User.CreateUser;

import User.UserBaseTest;
import com.sun.codemodel.JAnnotationArrayMember;
import dto.User;
import dto.UserOut;
import lombok.Builder;
import lombok.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import services.UserService;

import static dto.User.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class CreateNewUserTest extends UserBaseTest {
    User user;

    public CreateNewUserTest(UserService userService) {
        super(userService);
    }

    @Test
    public void checkCreateUser(){

    user.setEmail("expectedEmail");
    user.setFirstName("FirstName");
    user.setLastName("LastName");
    user.setPhone("8-920-920-23-23");
    user.setUsername("Ivan");
    user.setPassword("Password");
    user.setUserStatus(10L);
    user.setId(10L);

    userService.addUserRequest(user)
               .then()
               .time(lessThan(100L));
       //Assertions.assertEquals("200", code, "Some message!!!");
    }
}
