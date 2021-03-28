package User.CreateUser;

import User.UserBaseTest;
import dto.User;
import dto.UserOut;
import io.restassured.response.Response;
import lombok.Builder;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import services.UserService;

import static org.hamcrest.Matchers.*;

/**
 * CreateUserTest
 *
 * @author Alexander Suvorov
 */

public class CreateUserTest extends UserBaseTest {

    public CreateUserTest(UserService userService) {
        super(userService);
    }

    @Test
    public void checkCreateUser() {
        Response response;
        User user;
        String expectedEmail = "Test@mail.ru";
        String actualType;
        String type = "unknown";
        String errorMessageType = "Incorrect userName";
        String expectedType = "unknown";
        Long id = 101L;

        user =   User.builder()
                .email(expectedEmail)
                .firstName("FirstName")
                .id(id)
                .lastName("LastName")
                .password("Password")
                .phone("8-920-920-23-23")
                .username("Ivan")
                .userStatus(10L)
                .build();

        response = userService.addUserRequest(user);

        //1
        response
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .time(lessThan(5000L))
                .body("type", equalTo(expectedType))
                .body("message", comparesEqualTo(id.toString()));

        
        //Json path  = Groovy's GPath
        // https://www.javadoc.io/doc/io.rest-assured/json-path/3.0.0/io/restassured/path/json/JsonPath.html
        // Первый/последний
        // store.book[1..5].title
        //условия в фигурных скобках

        // Мачеры hamcrest
        // Логически  (allOf, anyOff)
        // Коллекция  (hasItem, hasKey)
        // Текст  (startsWith, endsWith, containsString)
        // Объекты (hasItem, hasKey, ...)    body("store.book.category", hasItem("fiction"))
        //Поддерживает методы min, max, size

  /*      { "store": {
            "book": [
            { "category": "reference",
                    "author": "Nigel Rees",
                    "title": "Sayings of the Century",
                    "price": 8.95
            },
            { "category": "fiction",
                    "author": "J. R. R. Tolkien",
                    "title": "The Lord of the Rings",
                    "isbn": "0-395-19395-8",
                    "price": 22.99
            }
                    ],
            "bicycle": {
                "color": "red",
                        "price": 19.95
            }
        }
        }*/

        //2
        actualType = response.jsonPath().get("type");
        Assertions.assertEquals(type, actualType, errorMessageType);


        //3
       /* actualEmail = response.
                then()
                .extract()
                .body()
                .as(User.class).getMEmail();

        Assertions.assertEquals(expectedEmail, actualEmail, errorMessageEmail);*/

        //Hamcrest vs  Assertions  ?

        //.body(matchesJsonSchemaInClasspath("schemaName.json"));

    }
}
