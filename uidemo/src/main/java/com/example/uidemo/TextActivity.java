package com.example.uidemo;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.text.util.Linkify;
import android.view.View;
import android.widget.TextView;

public class TextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text2);

        //对id为html_txt的文本控件设置包含html标签的文本，并让它展示对应的效果
        //1.获取该控件
        TextView v = findViewById(R.id.html_txt);

        //2.准备文本（含html标签）
        //<font>   <big>  <small>  <i>  <b>  <tt>  <br>  <p>  <a>  <img>
        String str = "<font color='#ff0000'>这是红色的字体</font><br>" +
                "<big>这是大号字体</big><br>" +
                "<small>这是小号字体</small><br>" +
                "<i>imooc</i><br>" +
                "<b>加粗字体</b><br>" +
                "<tt>iMoOc</tt>" +
                "<p>这是一个新段落</p>" +
                "<a href='http://www.baidu.com'>百度</a>";

        //3.设置
        v.setText(Html.fromHtml(str));
        v.setMovementMethod(LinkMovementMethod.getInstance());

        //==================================
        //为文本设置链接动作
        //1.找到指定的文本控件
        TextView autoTxt = findViewById(R.id.auto_link_txt);
        //2.设置文本
        autoTxt.setText("13399887766");
        //3.设置链接动作
        autoTxt.setAutoLinkMask(Linkify.PHONE_NUMBERS);
        autoTxt.setMovementMethod(LinkMovementMethod.getInstance());

        //==============================
        //设置动作、样式
        //1.找控件
        TextView moveTxt = findViewById(R.id.move_txt);
        //2.准备文本
        String txt = "请登录官网或联系后台";

        //3.格式化调整文本
        SpannableString ss1 = new SpannableString(txt);
        ss1.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View view) {
                //登录官网   http://www.imooc.com
                //意图：参数1：你要做什么   参数2：去哪里
                Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.imooc.com"));
                startActivity(it);

            }
        }, 1, 5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        ss1.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:13788667755"));
                startActivity(it);
            }
        }, 6, 10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //4.设置
        moveTxt.setText(ss1);
        moveTxt.setMovementMethod(LinkMovementMethod.getInstance());

        //===================================
        //样式文本
        //1.找控件
        TextView styleTxt = findViewById(R.id.style_txt);
        //2.准备文本
        String txt2 = "红色背景，蓝色文字";

        //3.格式化调整文本
        SpannableString ss2 = new SpannableString(txt2);
        ss2.setSpan(new BackgroundColorSpan(Color.RED),
                0,4,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss2.setSpan(new CharacterStyle() {
            @Override
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(Color.BLUE);
                textPaint.bgColor = Color.YELLOW;
            }
        },5,9,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //4.设置
        styleTxt.setText(ss2);
    }
}
