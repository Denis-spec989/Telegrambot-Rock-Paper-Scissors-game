package game;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;

public class Bot {
   private final TelegramBot bot = new TelegramBot(System.getenv("BOT_TOKEN"));

    public void serve() {
        bot.setUpdatesListener(updates -> {
            updates.forEach(this::process);
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });


    }

    private void process(Update update) {
        Message message = update.message();
        CallbackQuery callbackQuery = update.callbackQuery();
        BaseRequest request =null;
        if(message != null)
        {
            long chatId = update.message().chat().id();
            request = new SendMessage(chatId, "Hello!");
        }
        if (request!=null) {
            bot.execute(request);
        }
    }
}
