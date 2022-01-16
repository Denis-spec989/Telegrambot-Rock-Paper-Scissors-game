package game;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.InlineQuery;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.model.request.InlineQueryResultArticle;
import com.pengrad.telegrambot.request.AnswerInlineQuery;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.EditMessageText;
import com.pengrad.telegrambot.request.SendMessage;

import java.util.ArrayList;
import java.util.List;

public class Bot {
   private final TelegramBot bot = new TelegramBot(System.getenv("BOT_TOKEN"));
    private final String PROCESSING_LABEL = "Processing...";
    private final static List<String> senderWins = new ArrayList<String>() {{
        add("02");
        add("10");
        add("21");
    }};
    public void serve() {
        bot.setUpdatesListener(updates -> {
            updates.forEach(this::process);
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });


    }

    private void process(Update update) {
        Message message = update.message();
        CallbackQuery callbackQuery = update.callbackQuery();
        InlineQuery inlineQuery = update.inlineQuery();


        BaseRequest request =null;

        if(message != null && message.viaBot() != null  && message.viaBot().username().equals("RPSGameD_bot"))
        {
            InlineKeyboardMarkup replyMarkup = message.replyMarkup();
            if(replyMarkup == null)
            {
                return;
            }
            InlineKeyboardButton[][] buttons = replyMarkup.inlineKeyboard();
            if(buttons == null)
            {
                return;
            }
            InlineKeyboardButton button = buttons[0][0];
            String buttonLabel =button.text();

            if(!buttonLabel.equals(PROCESSING_LABEL))
            {
                return;
            }
            Long chatId = message.chat().id();
            String senderName = message.from().firstName();
            String senderChose = button.callbackData();
            Integer messageId = message.messageId();

            request = new EditMessageText(chatId, messageId, message.text()).replyMarkup(new InlineKeyboardMarkup(
                            new InlineKeyboardButton("🗿").callbackData(String.format("%d %s %s %s %d", chatId, senderName, senderChose, "0",messageId)),
                            new InlineKeyboardButton("🧻").callbackData(String.format("%d %s %s %s %d", chatId, senderName, senderChose, "1",messageId)),
                            new InlineKeyboardButton("✂").callbackData(String.format("%d %s %s %s %d", chatId, senderName, senderChose, "2",messageId))
                    )
            );


        }
       else if (inlineQuery!=null)
        {
            InlineQueryResultArticle rock = buildInlineButton("rock","\uD83D\uDDFF Rock","0");
            InlineQueryResultArticle paper = buildInlineButton("paper","\uD83E\uDDFB Paper","1");
            InlineQueryResultArticle scissors = buildInlineButton("scissors","✂ Scissors","2");
            request = new AnswerInlineQuery(inlineQuery.id(),rock,paper,scissors).cacheTime(1);
        }
           else if( callbackQuery !=null)
        {
            String[] data = callbackQuery.data().split(" ");
            if(data.length <4)
            {
                return;

            }
            Long chatId =Long.parseLong(data[0]);
            String senderName = data[1];
            String senderChose = data[2];
            String opponentChose = data[3];
            String opponentName = callbackQuery.from().firstName();
            if(senderChose.equals(opponentChose))
            {
                request = new SendMessage(chatId , "Nobody wins =(");

            } else if (senderWins.contains(senderChose+opponentChose))
            {
                request = new SendMessage(chatId,String.format("%s (%s) was beaten by %s (%s)",opponentName,opponentChose,senderName,senderChose));
            } else
            {
                request = new SendMessage(chatId,String.format("%s (%s) was beaten by %s (%s)",senderName,senderChose,opponentName,opponentChose));
            }
        }

        if (request!=null) {
            bot.execute(request);
        }
    }

    private InlineQueryResultArticle buildInlineButton(String id,String title , String callbackData) {
        return new InlineQueryResultArticle(id, title, "I'm ready to fight").replyMarkup(new InlineKeyboardMarkup(new InlineKeyboardButton(PROCESSING_LABEL).callbackData(callbackData)));
    }
}
