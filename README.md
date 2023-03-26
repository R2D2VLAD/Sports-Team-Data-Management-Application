REST-full сервис, по управлению спортивными командами
Стек технологий:
1)Среда разработки: IntelliJ IDEA ULTIMATE 2022.2.2
2)Java 17
3)Spring Boot 2.7.7
4)Maven
5)Liquibase
6)PostgreSql
7)Hibernate

Инструкция по запуску приложения:
1)Загрузить исходный код себе на ПК, и открыть его в среде разработки;
2)Подключиться к своей базе данных и в файле "application.properties" указать данные своей БД,
чтобы liquibase мог созать в вашей БД необходимые объекты;
3)Запустить проект и перейти в браузер, ввести запрос "http://localhost:8090/swagger-ui/index.html#/"
4)Теперь можно создавать необходимые объеты и управлять ими!

Описание методов API:
УПРАВЛЕНИЕ СПОРТИВНЫМИ КОМАНДАМИ
1)Get("Team/{id}") - Endpoint для получения участников конкретных спортивных команд по определенным настройкам -
Нужно выбрать позицию в команде и ввести id команды;
2)Put("Team/{id}") - Endpoint для изменения данных спортивных команд по id -
Нужно ввести id команды и записать новые данные этой команды;
3)Delete("Team/{id}") - Endpoint для удаления спортивных команд по id -
Нужно ввести id команды, которую хотите удалить;
4)Get("/Team") - Endpoint для получения всех команд по определенным фильтрам -
Нужно выбрать тип спорта и ввести два значения - год с которого начинается
и год по который заканчивается поиск команд по их году основания;
5)Post("/Team") - Endpoint для добавления спортивных команд -
Нужно указать данные команды;

УАПРАВЛЕНИЕ УЧАСТНИКАМИ СПОРТИВНЫХ КОМАНД
1)Put("TeamMembers/{id},{idTeam}") - Endpoint для изменения данных участников спортивных команд по id -
Нужно ввести id участника, id спортивной команды и внести изменения в данные;
2)Put("TeamMembers/{idTeam},{idMembers},{idTeam2}") - Endpoint для перевода участников одной команды в другую -
Нужно ввести id команды из которой будет перевод, id участника этой команды, id команды в которую будет производиться перевод
и ввести данные этого участника;
3)Post("TeamMembers/{id}) - Endpoint для добавления участников спортивных команд -
Нужно ввести id команды в которую будет происходить добавление участника и ввести его данные;
4)Get("/TeamMembers") - Endpoint для получения всех участников спортивных команд -
Нужно нажать на кнопку и произведется поиск всех участников спортивных команд;
5)Delete("TeamMembers/{id},{idTeam}") - Endpoint для удаления участников спортивных команд по id -
Нужно ввести id участника и id команды;