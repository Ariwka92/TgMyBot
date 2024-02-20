package org.example;

import net.thauvin.erik.crypto.CryptoException;
import net.thauvin.erik.crypto.CryptoPrice;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;

public class MyBot extends TelegramLongPollingBot {
    public MyBot(){
        super("6776672369:AAH3J9OReUw9aCaPi5uwFNyfsfSb7176XHQ");
    }
    @Override
    public void onUpdateReceived(Update update) {
        var chatId = update.getMessage().getChatId();
        var text = update.getMessage().getText();

        try {
            var message = new SendMessage();
            message.setChatId(chatId);

            if (text.equals("/start")){
                message.setText("Hello");
            } else if (text.equals("btc")){
                var price = CryptoPrice.spotPrice("BTC");
                message.setText("BTC price:" + price.getAmount().doubleValue());
            } else if (text.equals("eth")) {
                var price = CryptoPrice.spotPrice("ETH");
                message.setText("ETH price:" + price.getAmount().doubleValue());
            } else if (text.equals("atom")){
                var price = CryptoPrice.spotPrice("ATOM");
                message.setText("ATOM price:" + price.getAmount().doubleValue());
            }
            else if (text.equals("/all")){
                var price = CryptoPrice.spotPrice("BTC");
                message.setText("BTC price:" + price.getAmount().doubleValue() + "\n" + "ETH price:" + price.getAmount().doubleValue() + "\n" + ("ATOM price:" + price.getAmount().doubleValue()));
            }
            else if (text.equals("btc,eth")) {
                var price = CryptoPrice.spotPrice("BTC");
                message.setText("BTC price:" + price.getAmount().doubleValue() + "\n" + "ETH price:" + price.getAmount().doubleValue());
            }
            else if (text.equals("btc,eth,atom")) {
                var price = CryptoPrice.spotPrice("BTC");
                message.setText("BTC price:" + price.getAmount().doubleValue() + "\n" + "ETH price:" + price.getAmount().doubleValue() + "\n" + ("ATOM price:" + price.getAmount().doubleValue()));
            }

            execute(message);
        }catch (TelegramApiException e) {
            System.out.println("Error");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CryptoException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public String getBotUsername() {
        return "frolovam92_bot";
    }
}
