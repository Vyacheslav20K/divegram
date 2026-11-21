package org.divegram.gvs;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;

import org.telegram.ui.ActionBar.Theme;

public class DiveGramThemeApplier {

    private static final String PREFS = "divegram_theme_prefs";
    private static final String KEY_APPLIED_ONCE = "purple_theme_applied_v1";

    public static void applyPurpleThemeIfNeeded(Context context) {
        if (context == null) return;
        SharedPreferences prefs = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        if (prefs.getBoolean(KEY_APPLIED_ONCE, false)) {
            return;
        }
        applyPurplePalette();
        prefs.edit().putBoolean(KEY_APPLIED_ONCE, true).apply();
    }

    public static void applyPurplePalette() {
        try {
            Theme.setColor(Theme.key_actionBarDefault, Color.parseColor("#4A148C"), false);
            Theme.setColor(Theme.key_actionBarDefaultSelector, Color.parseColor("#6A1B9A"), false);
            Theme.setColor(Theme.key_actionBarDefaultIcon, Color.parseColor("#FFFFFF"), false);
            Theme.setColor(Theme.key_actionBarDefaultTitle, Color.parseColor("#FFFFFF"), false);
            Theme.setColor(Theme.key_actionBarDefaultSubtitle, Color.parseColor("#E1BEE7"), false);

            Theme.setColor(Theme.key_windowBackgroundWhite, Color.parseColor("#120D1D"), false);
            Theme.setColor(Theme.key_windowBackgroundGray, Color.parseColor("#0B0812"), false);
            Theme.setColor(Theme.key_windowBackgroundWhiteBlackText, Color.parseColor("#F3E5F5"), false);
            Theme.setColor(Theme.key_windowBackgroundWhiteGrayText, Color.parseColor("#B39DDB"), false);

            Theme.setColor(Theme.key_chats_actionBackground, Color.parseColor("#7C4DFF"), false);
            Theme.setColor(Theme.key_chats_actionPressedBackground, Color.parseColor("#651FFF"), false);
            Theme.setColor(Theme.key_chats_unreadCounter, Color.parseColor("#9575CD"), false);
            Theme.setColor(Theme.key_chats_unreadCounterText, Color.parseColor("#FFFFFF"), false);

            Theme.setColor(Theme.key_chat_outBubble, Color.parseColor("#512DA8"), false);
            Theme.setColor(Theme.key_chat_outBubbleSelected, Color.parseColor("#673AB7"), false);
            Theme.setColor(Theme.key_chat_inBubble, Color.parseColor("#1F1830"), false);
            Theme.setColor(Theme.key_chat_inBubbleSelected, Color.parseColor("#2C2244"), false);
            Theme.setColor(Theme.key_chat_messageTextOut, Color.parseColor("#FFFFFF"), false);
            Theme.setColor(Theme.key_chat_messageTextIn, Color.parseColor("#EDE7F6"), false);

            Theme.saveThemeColors();
        } catch (Throwable ignored) {
            // Безопасный fallback, если в конкретной ревизии Telegram сигнатура метода отличается
        }
    }
}
