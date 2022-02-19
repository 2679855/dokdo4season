package com.mycooco.dokdo;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.mycooco.dokdo.vo.Season;

import java.io.IOException;
import java.io.InputStream;

public class Helper {

    public static String getPrevImage(Season season) {

        return season.getPrevImage();
    }

    public static String getNextImage(Season season) {

        return season.getNextImage();
    }

    public static Bitmap getBitMap(AssetManager am, String fileName) {

        InputStream is = null ;

        try {
            is = am.open(fileName) ;

            Bitmap bm = BitmapFactory.decodeStream(is);

            return bm;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
