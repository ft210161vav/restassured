package User.GetUser;

import User.UserBaseTest;
import dto.User;
import lombok.Builder;
import lombok.Data;
import org.junit.jupiter.api.Test;
import services.UserService;

public class GetUserTest extends UserBaseTest {
    User user;

    public GetUserTest(UserService userService) {
        super(userService);
    }

    @Test
public void GetUserByName(){
        user=User.builder().build();
    }
}
