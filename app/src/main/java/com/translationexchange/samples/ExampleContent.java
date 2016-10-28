package com.translationexchange.samples;

import com.translationexchange.android.Tml;
import com.translationexchange.android.utils.ViewUtils;
import com.translationexchange.core.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExampleContent {

    public static List<ExampleItem> getExampleItems() {
        List<ExampleItem> ITEMS = new ArrayList<>();
        ITEMS.add(new ExampleItem("Hello World"));
        ITEMS.add(new ExampleItem("Hello [italic: World]", Utils.map(
                "italic", Utils.map("style", "italic")), true));
        ITEMS.add(new ExampleItem("Hello [bold: World]", Utils.map(
                "bold", Utils.map("style", "bold")), true));
        ITEMS.add(new ExampleItem("Hello [custom: World]", Utils.map(
                "custom", Utils.map("style", "bold_italic", "underline", "single")), true));
        ITEMS.add(new ExampleItem("Hello [yellow: World]", Utils.map(
                "yellow", Utils.map("color", "yellow")), true));
        ITEMS.add(new ExampleItem("[style: Adjust fonts] using an attribute dictionary.", Utils.map(
                "style", Utils.map("style", "bold")), true));
        ITEMS.add(new ExampleItem("Hello {user}", Utils.map("user", Tml.tr("Alexander"))));
        ITEMS.add(new ExampleItem("Hello [indent: {user}]", Utils.map(
                "indent", Utils.map("color", "red"), "user", Tml.tr("Alexander")), true));
        ITEMS.add(new ExampleItem("Do you speak {language}?", Utils.map(
                "language", Tml.tr("English"))));
        ITEMS.add(new ExampleItem("{user.name} just turned {user.age} years old", Utils.map(
                "user", Utils.map("name", "Michael", "age", "25"))));
        ITEMS.add(new ExampleItem("You have messages: {count}", Utils.map(
                "count", "1")));
        ITEMS.add(new ExampleItem("You have {count || one: message, other: messages}", Utils.map(
                "count", "1")));
        ITEMS.add(new ExampleItem("You have {count || message, messages}", Utils.map(
                "count", "2")));
        ITEMS.add(new ExampleItem("You have {count || message}", Utils.map(
                "count", "3")));
        ITEMS.add(new ExampleItem("You have {count | a message, #count# messages}", Utils.map(
                "count", "1")));
        ITEMS.add(new ExampleItem("You have {count | a message, #count# messages}", Utils.map(
                "count", "3")));
        ITEMS.add(new ExampleItem("You have [red: {count}] {count | message}", Utils.map(
                "red", Utils.map("color", "red"), "count", "3"), true));
        ITEMS.add(new ExampleItem("{user} liked this post.", Utils.map(
                "user", Utils.map(
                        "object", Utils.map("name", "Michael", "gender", "male"),
                        "attribute", "name"))));
        ITEMS.add(new ExampleItem("{user | He, She} liked this post.", Utils.map(
                "user", Utils.map("gender", "male"))));
        ITEMS.add(new ExampleItem("{user | He, She} liked this movie.", Utils.map(
                "user", Utils.map("gender", "female"))));
        ITEMS.add(new ExampleItem("{user} uploaded {count|| photo} to {user| his, her} photo album.", Utils.map(
                "user", Utils.map(
                        "object", Utils.map("name", "Michael", "gender", "male"),
                        "attribute", "name"),
                "count", 1)));
        ITEMS.add(new ExampleItem("[underline: {user}] uploaded [indent: {count || photo}] to [underline: {user | his, her} photo album].", Utils.map(
                "underline", Utils.map("underline", "single"),
                "indent", Utils.map(
                        "style", "italic",
                        "color", "#FFAABB",
                        "typeface", "sans-serif-thin",
                        "size", ViewUtils.convertPixelsToSp(SampleApplication.getInstance(), 22)),
                "user", Utils.map(
                        "object", Utils.map("name", "Michael", "gender", "male"),
                        "attribute", "name"
                ),
                "count", 1), true));
        ITEMS.add(new ExampleItem("{actor} added [bold: {count || photo}] to {target::pos} photo album.", Utils.map(
                "bold", Utils.map("style", "bold"),
                "actor", Utils.map(
                        "object", Utils.map("name", "Peter", "gender", "male"),
                        "attribute", "name"),
                "target", Utils.map(
                        "object", Utils.map("name", "Anna", "gender", "female"),
                        "attribute", "name"),
                "count", 3)));
        ITEMS.add(new ExampleItem("{actor} added [bold: {count || photo}] to {target::pos} photo album.", Utils.map(
                "bold", Utils.map("style", "bold"),
                "actor", Utils.map(
                        "object", Utils.map("name", "Anna", "gender", "female"),
                        "attribute", "name"),
                "target", Utils.map(
                        "object", Utils.map("name", "Peter", "gender", "male"),
                        "attribute", "name"),
                "count", 1), true));
        ITEMS.add(new ExampleItem("{actor} tagged {target} in {actor | his, her} blog post.", Utils.map(
                "actor", Utils.map(
                        "object", Utils.map("name", Tml.tr("Anna"), "gender", "female"),
                        "attribute", "name"),
                "target", Utils.map(
                        "object", Utils.map("name", Tml.tr("Peter"), "gender", "male"),
                        "attribute", "name"))));
        ITEMS.add(new ExampleItem("System [bold: bold font] followed by [italic: italic font].", Utils.map(
                "bold", Utils.map("style", "bold", "size", ViewUtils.convertPixelsToSp(SampleApplication.getInstance(), 20)),
                "italic", Utils.map("style", "italic", "size", ViewUtils.convertPixelsToSp(SampleApplication.getInstance(), 10))), true));
        ITEMS.add(new ExampleItem("[purple: Background color] can also be changed using the same methods.", Utils.map(
                "purple", Utils.map("background", "#ffff00")), true));
        ITEMS.add(new ExampleItem("You can [font1: mix fonts [font2: and colors] in any way] you like.", Utils.map(
                "font1", Utils.map(
                        "style", "italic",
                        "color", "#FFAABB",
                        "typeface", "sans-serif-thin",
                        "size", ViewUtils.convertPixelsToSp(SampleApplication.getInstance(), 22)),
                "font2", Utils.map(
                        "style", "bold",
                        "color", "#FF00FF",
                        "typeface", "sans-serif-light",
                        "background", "#00FFFF",
                        "size", ViewUtils.convertPixelsToSp(SampleApplication.getInstance(), 30))), true));
        ITEMS.add(new ExampleItem("You can [strike: use a strike-through] as well.", Utils.map(
                "strike", Utils.map("strike-through", "1")), true));
        return ITEMS;
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
