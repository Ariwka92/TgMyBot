package org.example;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) throws Exception {
        var api = new TelegramBotsApi(DefaultBotSession.class);
        api.registerBot(new MyBot());
     }
    }
    //frolovam92_bot
    //6776672369:AAH3J9OReUw9aCaPi5uwFNyfsfSb7176XHQ