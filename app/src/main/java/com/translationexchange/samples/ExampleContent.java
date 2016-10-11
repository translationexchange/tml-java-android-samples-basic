package com.translationexchange.samples;

import com.translationexchange.android.TmlAndroid;
import com.translationexchange.android.utils.ViewUtils;
import com.translationexchange.core.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExampleContent {

    public static final List<ExampleItem> ITEMS = new ArrayList<>();

    static {
        ITEMS.add(new ExampleItem("Hello World"));
        ITEMS.add(new ExampleItem("Hello [italic: World]", Utils.buildMap(
                "italic", Utils.buildMap("style", "italic")), true));
        ITEMS.add(new ExampleItem("Hello [bold: World]", Utils.buildMap(
                "bold", Utils.buildMap("style", "bold")), true));
        ITEMS.add(new ExampleItem("Hello [custom: World]", Utils.buildMap(
                "custom", Utils.buildMap("style", "bold_italic", "underline", "single")), true));
        ITEMS.add(new ExampleItem("Hello [yellow: World]", Utils.buildMap(
                "yellow", Utils.buildMap("color", "yellow")), true));
        ITEMS.add(new ExampleItem("[style: Adjust fonts] using an attribute dictionary.", Utils.buildMap(
                "style", Utils.buildMap("style", "bold")), true));
        ITEMS.add(new ExampleItem("Hello {user}", Utils.buildMap("user", TmlAndroid.translate("Alexander"))));
        ITEMS.add(new ExampleItem("Hello [indent: {user}]", Utils.buildMap(
                "indent", Utils.buildMap("color", "red"), "user", TmlAndroid.translate("Alexander")), true));
        ITEMS.add(new ExampleItem("Do you speak {language}?", Utils.buildMap(
                "language", TmlAndroid.translate("English"))));
        ITEMS.add(new ExampleItem("{user.name} just turned {user.age} years old", Utils.buildMap(
                "user", Utils.buildMap("name", "Michael", "age", "25"))));
        ITEMS.add(new ExampleItem("You have messages: {count}", Utils.buildMap(
                "count", "1")));
        ITEMS.add(new ExampleItem("You have {count || one: message, other: messages}", Utils.buildMap(
                "count", "1")));
        ITEMS.add(new ExampleItem("You have {count || message, messages}", Utils.buildMap(
                "count", "2")));
        ITEMS.add(new ExampleItem("You have {count || message}", Utils.buildMap(
                "count", "3")));
        ITEMS.add(new ExampleItem("You have {count | a message, #count# messages}", Utils.buildMap(
                "count", "1")));
        ITEMS.add(new ExampleItem("You have {count | a message, #count# messages}", Utils.buildMap(
                "count", "3")));
        ITEMS.add(new ExampleItem("You have [red: {count}] {count | message}", Utils.buildMap(
                "red", Utils.buildMap("color", "red"), "count", "3"), true));
        ITEMS.add(new ExampleItem("{user} liked this post.", Utils.buildMap(
                "user", Utils.buildMap(
                        "object", Utils.buildMap("name", "Michael", "gender", "male"),
                        "attribute", "name"))));
        ITEMS.add(new ExampleItem("{user | He, She} liked this post.", Utils.buildMap(
                "user", Utils.buildMap("gender", "male"))));
        ITEMS.add(new ExampleItem("{user | He, She} liked this movie.", Utils.buildMap(
                "user", Utils.buildMap("gender", "female"))));
        ITEMS.add(new ExampleItem("{user} uploaded {count|| photo} to {user| his, her} photo album.", Utils.buildMap(
                "user", Utils.buildMap(
                        "object", Utils.buildMap("name", "Michael", "gender", "male"),
                        "attribute", "name"),
                "count", 1)));
        ITEMS.add(new ExampleItem("[underline: {user}] uploaded [indent: {count || photo}] to [underline: {user | his, her} photo album].", Utils.buildMap(
                "underline", Utils.buildMap("underline", "single"),
                "indent", Utils.buildMap(
                        "style", "italic",
                        "color", "#FFAABB",
                        "typeface", "sans-serif-thin",
                        "size", ViewUtils.convertPixelsToSp(SampleApplication.getInstance(), 22)),
                "user", Utils.buildMap(
                        "object", Utils.buildMap("name", "Michael", "gender", "male"),
                        "attribute", "name"
                ),
                "count", 1), true));
        ITEMS.add(new ExampleItem("{actor} added [bold: {count || photo}] to {target::pos} photo album.", Utils.buildMap(
                "bold", Utils.buildMap("style", "bold"),
                "actor", Utils.buildMap(
                        "object", Utils.buildMap("name", "Peter", "gender", "male"),
                        "attribute", "name"),
                "target", Utils.buildMap(
                        "object", Utils.buildMap("name", "Anna", "gender", "female"),
                        "attribute", "name"),
                "count", 3)));
        ITEMS.add(new ExampleItem("{actor} added [bold: {count || photo}] to {target::pos} photo album.", Utils.buildMap(
                "bold", Utils.buildMap("style", "bold"),
                "actor", Utils.buildMap(
                        "object", Utils.buildMap("name", "Anna", "gender", "female"),
                        "attribute", "name"),
                "target", Utils.buildMap(
                        "object", Utils.buildMap("name", "Peter", "gender", "male"),
                        "attribute", "name"),
                "count", 1), true));
        ITEMS.add(new ExampleItem("{actor} tagged {target} in {actor | his, her} blog post.", Utils.buildMap(
                "actor", Utils.buildMap(
                        "object", Utils.buildMap("name", TmlAndroid.translate("Anna"), "gender", "female"),
                        "attribute", "name"),
                "target", Utils.buildMap(
                        "object", Utils.buildMap("name", TmlAndroid.translate("Peter"), "gender", "male"),
                        "attribute", "name"))));
        ITEMS.add(new ExampleItem("System [bold: bold font] followed by [italic: italic font].", Utils.buildMap(
                "bold", Utils.buildMap("style", "bold", "size", ViewUtils.convertPixelsToSp(SampleApplication.getInstance(), 20)),
                "italic", Utils.buildMap("style", "italic", "size", ViewUtils.convertPixelsToSp(SampleApplication.getInstance(), 10))), true));
        ITEMS.add(new ExampleItem("[purple: Background color] can also be changed using the same methods.", Utils.buildMap(
                "purple", Utils.buildMap("background", "#ffff00")), true));
        ITEMS.add(new ExampleItem("You can [font1: mix fonts [font2: and colors] in any way] you like.", Utils.buildMap(
                "font1", Utils.buildMap(
                        "style", "italic",
                        "color", "#FFAABB",
                        "typeface", "sans-serif-thin",
                        "size", ViewUtils.convertPixelsToSp(SampleApplication.getInstance(), 22)),
                "font2", Utils.buildMap(
                        "style", "bold",
                        "color", "#FF00FF",
                        "typeface", "sans-serif-light",
                        "background", "#00FFFF",
                        "size", ViewUtils.convertPixelsToSp(SampleApplication.getInstance(), 30))), true));
        ITEMS.add(new ExampleItem("You can [strike: use a strike-through] as well.", Utils.buildMap(
                "strike", Utils.buildMap("strike-through", "1")), true));
    }

    public static class ExampleItem {
        public String label;
        public Map<String, Object> tokens;
        public boolean isSpannable;

        ExampleItem(String label) {
            this.label = label;
        }

        ExampleItem(String label, Map<String, Object> tokens) {
            this.label = label;
            this.tokens = tokens;
        }

        ExampleItem(String label, Map<String, Object> tokens, boolean isSpannable) {
            this.label = label;
            this.tokens = tokens;
            this.isSpannable = isSpannable;
        }
    }
}
