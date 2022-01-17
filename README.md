# Телеграм бот-игра камень-ножницы-бумага.
____
Телеграм бот-игра камень-ножницы-бумага , которого можно добавить в свой чат и играть с друзьями.
___
## Оглавление
1. [Описание приложения](#anchor1)
2. [Демо](#anchor2)
3. [Используемые технологии в проекте](#anchor3)
4. [Техническое описание проекта](#anchor4)
___
<a id="anchor1"></a>
### 1.Описание приложения
Данное приложения было написано на open-source среде разработки **IntelliJ IDEA** с использованием **JDK 16**. Настройка проекта будет указана в пункте [Техническое описание проекта](#anchor4)

**Цель проекта** - создать бота-игру на языке Java без БД.
___
<a id="anchor2"></a>
### 2.Демо проекта
**Запускаем программу IntelliJ IDEA** 

![avat](https://raw.githubusercontent.com/Denis-spec989/Telegrambot-Rock-Paper-Scissors-game/master/assets/scr7.jpg)


**Переходим в группу Telegram с ужа добавленным и настроенным ботом. Пишем в сообщении @RPSGameD_bot и выбираем один из 3-х вариантов.**

![avat](https://raw.githubusercontent.com/Denis-spec989/Telegrambot-Rock-Paper-Scissors-game/master/assets/scr1.jpg)

**Выбираю камень**

![avat](https://raw.githubusercontent.com/Denis-spec989/Telegrambot-Rock-Paper-Scissors-game/master/assets/scr2.jpg)

**Отправляем сообщение и ждем , когда противник выберет один из 3-х своих вариантов(нажав одну из кнопок под нашим сообщением)**

![avat](https://raw.githubusercontent.com/Denis-spec989/Telegrambot-Rock-Paper-Scissors-game/master/assets/scr3.jpg)

**После того как противник выбрал свой вариант, бот обрабатывает наши варианты и выдает сообщение, что получилась ничья**

![avat](https://raw.githubusercontent.com/Denis-spec989/Telegrambot-Rock-Paper-Scissors-game/master/assets/scr4.jpg)

**Попробуем еще раз, теперь противник создал игру**

![avat](https://raw.githubusercontent.com/Denis-spec989/Telegrambot-Rock-Paper-Scissors-game/master/assets/scr5.jpg)

**Выбираю бумагу и проигрываю:cry:**

![avat](https://raw.githubusercontent.com/Denis-spec989/Telegrambot-Rock-Paper-Scissors-game/master/assets/scr6.jpg)
___
### 3.Используемые технологии в проекте
<a id="anchor3"></a>
:heavy_check_mark: Java Collections
:heavy_check_mark: Java Telegram Bot API https://github.com/pengrad/java-telegram-bot-api
:heavy_check_mark: Maven
___
<a id="anchor4"></a>
### 4.Техническое описание проекта
Для запуска вашего бота первым делом необходимо создать его в боте BotFather, включить Inline mode , отключить Group Privacy в настройках вашего бота.
Регистрация бота проходит без каких-либо необходимых навыков, путем взаимодействия в Отцом Ботов @BotFather.

Последовательность действий для создания любого бота одинаковая:

Открываем @BotFather и запускаем его (Старт/Start). 
В списке предложенных команд выбираем: /newbot - create a new bot, нажимаем на эту команду, или вводим ее вручную в поле для ввода сообщений.
Вам предложат указать как будут звать бота, в дальнейшем название бота можно будет поменять. Вводите название в поле для ввода сообщений.
Далее вам предложат указать имя, по которому бот будет доступен для пользователей. Имя пишите, используя латинский алфавит, цифры и нижнее подчеркивание. Еще одно важное условие - имя должно оканчиваться на "bot". Можно также с большой буквы "Bot", или "_bot" или "_Bot".
Если все прошло без замечаний со стороны @BotFather, то по итогу вам выведется на экран Token API, если вы его сразу использовать не будете, то можно его куда-нибудь записать. Также его можно запросить снова если вы его забыли или потеряли. Редактировать бота можно у @BotFather, для этого запросите список ваших ботов /mybots, выберите из списка нужного бота и далее при необходимости вы можете отредактировать его информацию, для этого в меню бота выберите Edit Bot.

После того , как вы получили Token , заходим в IntelliJ IDEA и вставляем его в конфигурацию класса стартер.

**Starter->Edit configurations...->заменяем input_yours_token на ваш токен и нажимаем Apply->Ok**

![avat](https://raw.githubusercontent.com/Denis-spec989/Telegrambot-Rock-Paper-Scissors-game/master/assets/scr9.jpg)

**Меняем в строке на название вашего бота**

![avat](https://raw.githubusercontent.com/Denis-spec989/Telegrambot-Rock-Paper-Scissors-game/master/assets/scr10.jpg)

Далее создаем группу в телеграме , добавляем туда бота и даём права администратора с правом назначения администраторов. **Всё**
**Запускаем приложение и начинаем игру по аналогии с демо**

P.S Бот будет работать , пока запущена программа в **IntelliJ IDEA**. Если есть желание постоянной работы бота , задеплойте его на [heroku](https://www.heroku.com/).
___
Автор: Игнатов Денис
e-mail: proanglerdenis@gmail.com









