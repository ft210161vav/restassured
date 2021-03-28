package User;

import services.UserService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Data
@Builder
@AllArgsConstructor
@JsonSerialize

public class UserBaseTest {
    protected UserService userService;
}
/*
Написать Api тесты. Используем https://petstore.swagger.io/

Тесты на создание пользователя.
Тесты на получение пользователя.
Для тестов написать пояснения(комменты, или тесткейсы, или java doc), что проверяем.

Критерии оценки:
+1 есть тест кейсы +1 используется RequestSpecification
 или ResponceSpecification +1 не менее 2-х тестов на создание пользователя
  +1 не менее 2-х тестов на получение пользователя по имени
 */