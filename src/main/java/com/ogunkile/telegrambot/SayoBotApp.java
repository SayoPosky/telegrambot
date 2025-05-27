package com.ogunkile.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class SayoBotApp {
  public static void main(String[] args) {
    try {
      TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);
      api.registerBot(new SayoBot());
      System.out.println("✅ Bot started...");
    } catch (TelegramApiException e) {
      e.printStackTrace();
    }
  }
}
