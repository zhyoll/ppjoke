package com.duotu.test.utils;

import android.content.res.AssetManager;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.duotu.test.model.BottomBar;
import com.duotu.test.model.Destination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * author : zhy
 * date   : 2020/11/1 19:52
 * desc   :
 */
public class AppConfig {

    private static HashMap<String, Destination> sDestConfig;

    private static BottomBar sBottomBar;

    public static HashMap<String, Destination> getDestConfig() {
        if (null == sDestConfig) {
            String content = parseFile("destination.json");
            sDestConfig = JSON.parseObject(content, new TypeReference<HashMap<String, Destination>>() {
            }.getType());
        }
        return sDestConfig;
    }

    private static String parseFile(String fileName) {
        AssetManager assets = AppGlobal.getApplication().getResources().getAssets();
        InputStream stream = null;
        BufferedReader reader = null;
        StringBuilder sb = null;
        try {
            stream = assets.open(fileName);
            reader = new BufferedReader(new InputStreamReader(stream));
            sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != reader) {
                    reader.close();
                }
                if (null != stream) {
                    stream.close();
                }
            } catch (Exception e) {

            }

        }
        return sb.toString();
    }

    public static BottomBar getBottomBar() {
        if (null == sBottomBar){
            String content = parseFile("main_tabs_config.json");
            sBottomBar = JSON.parseObject(content, BottomBar.class);
        }
        return sBottomBar;
    }
}
