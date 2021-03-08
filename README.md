# UserMvcWebService
User MVC Web Service realization
Релизация web Restful сервиса

Технологии используемые в проекте:
- Spring boot
- Apache Tomcat
- NamedParameterJdbcTemplate (на основе классического JdbcTemplate)

База данных:
- PostgreSql

Формат обмена данными:
- JSON

Описание метода контроллера UserController

@GetMapping("users")
public List<User> getUserList()

При вызове метода GET отдает JSON с перечнем всех сущностей User, хранимых в БД

@GetMapping("/user/{id}")
public User getUser(@PathVariable("id") int id)

При вызове метода GET c указанием ID будет передан JSON с описанием сущности User, запрошенной через ID

@PostMapping("/save")
public void addUser(@RequestBody User user)

При вызове метода POST в теле которого будет описана сущность User формата:
{
    "name":"String",
    "pass":"String",
    "mail":"String"
}
Сущность будет записана в БД

@PutMapping("/update")
public void updateUser(@RequestBody User user)
При вызове метода POST в теле которого будет описана сущность User формата:
{
    "id":integer
    "name":"String",
    "pass":"String",
    "mail":"String"
}
По переданному ID сущность будет перезаписана согласно переданному сообщению JSON

@DeleteMapping("/delete/{id}")
public void deleteUser(@PathVariable("id") int id)

При вызове метода DELETE c указанием ID будет произведено удаление соответствующей сущности из БД
