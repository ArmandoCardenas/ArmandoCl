package com.armandocl.dev.sisinfov2.Classes;

import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by armando.cardenas on 23/10/2015.
 */
public class SISINFOWebClient extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if (Uri.parse(url).getHost().endsWith("https://sii.itcelaya.edu.mx")){

        }
        return true;
    }
}
