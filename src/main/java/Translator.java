import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import model.Def;
import model.Tr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Translator extends TelegramLongPollingBot {
    Map<Long, String> hashMap = new HashMap<>();

    @Override
    public void onUpdateReceived(Update update) {
        Long chatId = update.getMessage().getChatId();
        String text = update.getMessage().getText();
        String firstName = update.getMessage().getChat().getFirstName();

        SendMessage sendMessage = new SendMessage();
        UpdateHandler handler = new UpdateHandler();

        sendMessage.setChatId(chatId);

        if (update.hasMessage() && update.getMessage().hasText()) {
            switch (text) {
                case "/start":
                    sendMessage.setText("Hi " + firstName + "!\n\nChoose language...");
                    sendMessage.setReplyMarkup(handler.getReplyKeyboardMarkup());
                    executeMessage(sendMessage);
                    break;
                case "EN-RU":
                case "RU-EN":
                case "TR-RU":
                case "RU-TR":
                case "EN-TR":
                case "TR-EN":
                    hashMap.put(chatId, text.toLowerCase());
                    break;
                default:
                    String lang = hashMap.get(chatId);
                    String replace = text.replace(" ", "%20");
                    String translatedText = getTranslatedText(replace, lang);
                    sendMessage.setText(translatedText);
                    executeMessage(sendMessage);
            }
        }
    }

    public void executeMessage(SendMessage message) {
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public String getTranslatedText(String str, String lang) {
        String res = "";
        try {
            URL url = new URL("https://dictionary.yandex.net/api/v1/dicservice.json/lookup?key=" +
                    "dict.1.1.20201115T052020Z.0a475afbefc631bb.ef97dd38c6a08ab7f820eb849f5a77dc21bd21c4&lang="
                    + lang + "&text=" + str);
            URLConnection urlConnection = url.openConnection();
            Gson gson = new Gson();
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
            JsonElement jsonElement = jsonObject.getAsJsonArray("def");

            Type type = new TypeToken<ArrayList<Def>>() {
            }.getType();
            List<Def> list = gson.fromJson(jsonElement, type);

            for (Def def : list) {
                System.out.println(def);
                System.out.println();
                for (Tr tr : def.getTr()) {
                    System.out.println(tr);
                    System.out.println();
                    res = tr.getText();
                    break;
                }
                break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return res;
    }


    @Override
    public String getBotUsername() {
        return "just_translated_bot";
    }

    @Override
    public String getBotToken() {
        return "1427218476:AAHEofx55TOX_xCy63aOlWuncd2MdmIOO7k";
    }


}
