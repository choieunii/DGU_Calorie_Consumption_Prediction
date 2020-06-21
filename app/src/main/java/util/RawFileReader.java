package util;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import model.ResultData;
import teeu.dgu_calorie_consumption_prediction.R;

public class RawFileReader {
    public static Map<String, ResultData> readCSV(Context context) {
        Map<String,ResultData> map = new HashMap<>();
        InputStream inputStream = context.getResources().openRawResource(R.raw.data);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(inputStream, "MS949"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        int line = 0;

        try {
            String str;
            while( (str = reader.readLine()) != null) {
                line++;
                if(line == 1)
                    continue;

                String s[] = str.split(",");
                map.put(s[0]+"_"+s[1], new ResultData(s[0], s[1], Integer.parseInt(s[2]), Double.parseDouble(s[3]), Integer.parseInt(s[4])));
//                Log.d("MYTAG", "s[] : " + s[0] + ", " + s[1] + ", " + s[2] + ", " + s[3] + ", " + s[4]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return map;
    }
}
