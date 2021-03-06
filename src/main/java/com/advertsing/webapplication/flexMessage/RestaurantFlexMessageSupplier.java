package com.advertsing.webapplication.flexMessage;

import com.advertsing.webapplication.entity.broadcastmanagement.Message;
import com.advertsing.webapplication.repository.broadcastmanagement.MessageRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.linecorp.bot.model.action.URIAction;
import com.linecorp.bot.model.message.FlexMessage;
import com.linecorp.bot.model.message.flex.component.*;
import com.linecorp.bot.model.message.flex.component.Button.ButtonHeight;
import com.linecorp.bot.model.message.flex.component.Image.ImageAspectMode;
import com.linecorp.bot.model.message.flex.component.Image.ImageAspectRatio;
import com.linecorp.bot.model.message.flex.container.Bubble;
import com.linecorp.bot.model.message.flex.unit.FlexFontSize;
import com.linecorp.bot.model.message.flex.unit.FlexLayout;
import com.linecorp.bot.model.message.flex.unit.FlexMarginSize;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.function.Supplier;

import static java.util.Arrays.asList;

@Slf4j
public class RestaurantFlexMessageSupplier implements Supplier<FlexMessage> {
    @Autowired
    MessageRepository messageRepository;

    @SneakyThrows
    @Override
    public FlexMessage get() {
        final Image heroBlock = createHeroBlock();
        final Box bodyBlock = createBodyBlock();
        final Box footerBlock = createFooterBlock();
         String jsonInString = "";
        final Bubble bubbleContainer = Bubble.builder()
                .hero(heroBlock)
                .body(bodyBlock)
                .footer(footerBlock)
                .build();
        String jsonString  = "{ \n" +
                "    \"type\": \"bubble\",\n" +
                "    \"direction\": \"ltr\",\n" +
                "    \"header\": {\n" +
                "      \"type\": \"box\",\n" +
                "      \"layout\": \"vertical\",\n" +
                "      \"contents\": [\n" +
                "        {\n" +
                "          \"type\": \"text\",\n" +
                "          \"text\": \"Header\",\n" +
                "          \"align\": \"center\"\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    \"hero\": {\n" +
                "      \"type\": \"image\",\n" +
                "      \"url\": \"https://developers.line.biz/assets/images/services/bot-designer-icon.png\",\n" +
                "      \"size\": \"full\",\n" +
                "      \"aspectRatio\": \"1.51:1\",\n" +
                "      \"aspectMode\": \"fit\"\n" +
                "    },\n" +
                "    \"body\": {\n" +
                "      \"type\": \"box\",\n" +
                "      \"layout\": \"vertical\",\n" +
                "      \"contents\": [\n" +
                "        {\n" +
                "          \"type\": \"text\",\n" +
                "          \"text\": \"Body\",\n" +
                "          \"align\": \"center\"\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    \"footer\": {\n" +
                "      \"type\": \"box\",\n" +
                "      \"layout\": \"horizontal\",\n" +
                "      \"contents\": [\n" +
                "        {\n" +
                "          \"type\": \"button\",\n" +
                "          \"action\": {\n" +
                "            \"type\": \"uri\",\n" +
                "            \"label\": \"Button\",\n" +
                "            \"uri\": \"https://linecorp.com\"\n" +
                "          }\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "}";


//
//        for (Message message:messageList
//             ) {
//           if(message.getSend_date() == "6/4/2020") {
//               jsonInString = message.getMessageJson();
//           }
//        }
        //JSON from String to Object
        ObjectMapper mapper = new ObjectMapper();
        Bubble bubble = mapper.readValue(jsonString, Bubble.class);

        return new FlexMessage("Restaurant", bubble);
    }

    private Image createHeroBlock() {
        return Image.builder()
                .url("https://2553d2b9.ngrok.io/img/cafe.png")
                .size(Image.ImageSize.FULL_WIDTH)
                .aspectRatio(com.linecorp.bot.model.message.flex.component.Image.ImageAspectRatio.R20TO13)
                .aspectMode(com.linecorp.bot.model.message.flex.component.Image.ImageAspectMode.Cover)
                .action(new URIAction("label", "http://example.com"))
                .build();
    }

    private Box createBodyBlock() {
        final Text title = Text.builder()
                .text("Brown Cafe")
                .weight(Text.TextWeight.BOLD)
                .size(FlexFontSize.XL)
                .build();
        final Box review = createReviewBox();
        final Box info = createInfoBox();

        return Box.builder()
                .layout(FlexLayout.VERTICAL)
                .contents(asList(title, review, info))
                .build();
    }

    private Box createInfoBox() {
        final Box place = Box.builder()
                .layout(FlexLayout.BASELINE)
                .spacing(FlexMarginSize.SM)
                .contents(asList(
                        Text.builder()
                                .text("Place")
                                .color("#aaaaaa")
                                .size(FlexFontSize.SM)
                                .flex(1)
                                .build(),
                        Text.builder()
                                .text("Silom, Bangkok")
                                .wrap(true)
                                .color("#666666")
                                .flex(5)
                                .build()
                )).build();
        final Box time = Box.builder()
                .layout(FlexLayout.BASELINE)
                .spacing(FlexMarginSize.SM)
                .contents(asList(
                        Text.builder().text("Time")
                                .color("#aaaaaa")
                                .size(FlexFontSize.SM)
                                .flex(1)
                                .build(),
                        Text.builder()
                                .text("10:00 - 23:00")
                                .wrap(true)
                                .color("#666666")
                                .size(FlexFontSize.SM)
                                .flex(5)
                                .build()
                )).build();
        return Box.builder()
                .layout(FlexLayout.VERTICAL)
                .margin(FlexMarginSize.LG)
                .spacing(FlexMarginSize.SM)
                .contents(asList(place, time))
                .build();
    }

    private Box createReviewBox() {
        final Icon goldStar = Icon.builder()
                .size(FlexFontSize.SM)
                .url("https://2553d2b9.ngrok.io/img/gold_star.png")
                .build();
        final Icon grayStar = Icon.builder()
                .size(FlexFontSize.SM)
                .url("https://2553d2b9.ngrok.io/img/gray_star.png")
                .build();
        final Text point = Text.builder()
                .text("4.0")
                .size(FlexFontSize.SM)
                .color("#999999")
                .margin(FlexMarginSize.MD)
                .flex(0)
                .build();

        return Box.builder()
                .layout(FlexLayout.BASELINE)
                .margin(FlexMarginSize.MD)
                .contents(asList(goldStar, goldStar, goldStar, goldStar, grayStar, point))
                .build();
    }

    private Box createFooterBlock() {
        final Spacer spacer = Spacer.builder().size(FlexMarginSize.SM).build();
        final Button callAction = Button.builder()
                .style(Button.ButtonStyle.LINK)
                .height(ButtonHeight.MEDIUM)
                .action(new URIAction("CALL", "tel:00000"))
                .build();
        final Separator separator = Separator.builder().build();
        final Button websiteAction = Button.builder()
                .style(Button.ButtonStyle.LINK)
                .height(ButtonHeight.SMALL)
                .action(new URIAction("WEBSITE", "https://example.com"))
                .build();

        return Box.builder()
                .layout(FlexLayout.VERTICAL)
                .spacing(FlexMarginSize.SM)
                .contents(asList(spacer, callAction, separator, websiteAction))
                .build();

    }
}