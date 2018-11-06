package com.api.starwars.common.util;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class ExternalRequestHttp {

    public String getRequestSWApi()  throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL("https://swapi.co/api/planets/");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
        conn.setRequestProperty("content-type", "application/json");
        conn.setRequestProperty("Accept", "application/json");
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        return result.toString();
    }
}
