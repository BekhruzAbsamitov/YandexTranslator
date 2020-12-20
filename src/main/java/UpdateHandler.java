import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class UpdateHandler {


    public ReplyKeyboardMarkup getReplyKeyboardMarkup() {

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);

        List<KeyboardRow> rows = new ArrayList<KeyboardRow>();
        KeyboardRow row1 = new KeyboardRow();
        row1.add(new KeyboardButton("EN-RU"));
        row1.add(new KeyboardButton("RU-EN"));
        rows.add(row1);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(new KeyboardButton("EN-TR"));
        row2.add(new KeyboardButton("TR-EN"));
        rows.add(row2);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(new KeyboardButton("TR-RU"));
        row3.add(new KeyboardButton("RU-TR"));
        rows.add(row3);

        replyKeyboardMarkup.setKeyboard(rows);
        return replyKeyboardMarkup;


        /*InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        InlineKeyboardButton keyboardButton1 = new InlineKeyboardButton();
        InlineKeyboardButton keyboardButton2 = new InlineKeyboardButton();
        keyboardButton1.setText("EN-RU");
        keyboardButton1.setCallbackData("en-ru");
        keyboardButton2.setText("RU-EN");
        keyboardButton2.setCallbackData("ru-en");
        List<InlineKeyboardButton> keyboardButtonList1 = new ArrayList<>();
        keyboardButtonList1.add(keyboardButton1);
        keyboardButtonList1.add(keyboardButton2);

        InlineKeyboardButton keyboardButton3 = new InlineKeyboardButton();
        keyboardButton3.setText("EN-TR");
        keyboardButton3.setCallbackData("en-tr");
        InlineKeyboardButton keyboardButton4 = new InlineKeyboardButton();
        keyboardButton4.setText("TR-EN");
        keyboardButton4.setCallbackData("tr-en");
        List<InlineKeyboardButton> keyboardButtonList2 = new ArrayList<>();
        keyboardButtonList2.add(keyboardButton3);
        keyboardButtonList2.add(keyboardButton4);

        InlineKeyboardButton keyboardButton5 = new InlineKeyboardButton();
        keyboardButton5.setText("TR-RU");
        keyboardButton5.setCallbackData("tr-ru");
        InlineKeyboardButton keyboardButton6 = new InlineKeyboardButton();
        keyboardButton6.setText("RU-TR");
        keyboardButton6.setCallbackData("ru-tr");

        List<InlineKeyboardButton> keyboardButtonList3 = new ArrayList<>();
        keyboardButtonList3.add(keyboardButton5);
        keyboardButtonList3.add(keyboardButton6);

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(keyboardButtonList1);
        rowList.add(keyboardButtonList2);
        rowList.add(keyboardButtonList3);

        inlineKeyboardMarkup.setKeyboard(rowList);*/

    }
}
