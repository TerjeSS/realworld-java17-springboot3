package io.shirohoo.realworld.domain.article;

import com.microsoft.playwright.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.awt.Desktop;
import java.net.URI;
import java.nio.file.Paths;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.Media;

//http://192.168.14.236:5173
public class ConvertArticle {
    public static void main(String[] args) throws IOException {

        /*Runtime rt = Runtime.getRuntime();
        String url = "http://localhost:5173/#/article/Try-to-transmit-the-HTTP-card-maybe-it-will-override-the-multi-byte-hard-drive!-120863";
        rt.exec("rundll32 url.dll,FileProtocolHandler " + url);*/

        try (Playwright playwright = Playwright.create()) {
            BrowserType webkit = playwright.webkit();
            Browser browser = webkit.launch();
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("http://localhost:5173/#/article/Try-to-transmit-the-HTTP-card-maybe-it-will-override-the-multi-byte-hard-drive!-120863");
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot.png")));
            //page.emulateMedia(new Page.EmulateMediaOptions().setMedia(Media.SCREEN));
            //page.pdf(new Page.PdfOptions().setPath(Paths.get("page.pdf")));
            browser.close();
        }

    }

}
