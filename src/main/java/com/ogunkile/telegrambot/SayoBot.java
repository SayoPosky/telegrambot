package com.ogunkile.telegrambot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;


public class SayoBot extends TelegramLongPollingBot {

  static String BOT_USERNAME = System.getenv("BOT_USERNAME");
  static String BOT_TOKEN = System.getenv("BOT_TOKEN");


  @Override
  public void clearWebhook() {
    // Skip webhook removal to avoid 401 error
  }


  @Override
  public String getBotUsername() {
    return BOT_USERNAME;
  }

  @Override
  public String getBotToken() {
    return BOT_TOKEN;
  }

  @Override
  public void onUpdateReceived(Update update) {
    if (update.hasMessage() && update.getMessage().hasText()) {
      String messageText = update.getMessage().getText();
      String chatId = update.getMessage().getChatId().toString();
      String reply = "";

      switch (messageText) {
        case "/start":
        case "/hello":
          reply = "👋 Hello World! Welcome to Oluwasayo's Bot.";
          break;
        case "/about":
          reply = "👤 Ogunkile Oluwasayo (75801)\nStudent of Computer Science";
          break;
        case "/help":
          reply = "Type \n/about for info,\n/course for course info, \n/fact for a cool fact!";
          break;
        case "/course":
          reply = "54DPH Internet technologies DK-L-2024/25";
          break;
        case "/fact":
          reply = "💡 Did you know? The first computer bug was a real moth in 1947!";
          break;
        default:
          reply = "❓ Unknown command. Try /help";
      }

      try {
        SendMessage message = new SendMessage(chatId, reply);
        execute(message);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
