package com.nieyue.test;


import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

/**
 * Created by 聂跃 on 2018/7/18.
 * 解析动态网页
 */
public class Test {
    protected static void aa() throws IOException{
        // 屏蔽HtmlUnit等系统 log
        //LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log","org.apache.commons.logging.impl.NoOpLog");
        //java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
        //java.util.logging.Logger.getLogger("org.apache.http.client").setLevel(Level.OFF);

        String url = "https://im.qq.com/download/index.shtml";
        url = "http://app.nalu888.cn/home/gooddetail.html?goodid=5";
        url = "https://detail.tmall.hk/hk/item.htm?id=565907350514&spm=a223v.7835278.t0.1.7b902312fjYghl&pvid=0ec3778d-cb87-4023-aa65-22e47adec164&scm=1007.12144.81309.9011_8949&utparam={%22x_hestia_source%22:%228949%22,%22x_mt%22:10,%22x_object_id%22:565907350514,%22x_object_type%22:%22item%22,%22x_pos%22:1,%22x_pvid%22:%220ec3778d-cb87-4023-aa65-22e47adec164%22,%22x_src%22:%228949%22}";
        System.out.println("Loading page now-----------------------------------------------: "+url);

        // HtmlUnit 模拟浏览器
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        webClient.getOptions().setJavaScriptEnabled(true);              // 启用JS解释器，默认为true
        webClient.getOptions().setCssEnabled(false);                    // 禁用css支持
        webClient.getOptions().setThrowExceptionOnScriptError(false);   // js运行错误时，是否抛出异常
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setTimeout(10 * 1000);                   // 设置连接超时时间
        HtmlPage page = webClient.getPage(url);
        webClient.waitForBackgroundJavaScript(30 * 1000);               // 等待js后台执行30秒

        String pageAsXml = page.asXml();

        // Jsoup解析处理
        //Document doc = Jsoup.parse(pageAsXml, url);
        Document doc = Jsoup.parse(pageAsXml);
        Element idd = doc.getElementById("cur_online");
        idd = doc.getElementsByClass("tm-price").get(0);
        // 此处省略其他操作
       // System.out.println(doc.toString());
        System.out.println(idd.text());
    }

    public static void main(String[] args)throws IOException {
            aa();
    }
}
