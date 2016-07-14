import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by akihiro on 2016/07/11.
 */
public class Http_DetailImage extends AsyncTask<Void, Void, String> {


    //前処理
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        // doInBackground前処理
    }

    @Override
    protected String doInBackground(Void... params) {
        HttpURLConnection con = null;
        URL url = null;
        String url_str = "http://localhost/asobiba_php/androidHTTP.php";

        try {
            url = new URL(url_str);
            con = (HttpURLConnection)url.openConnection();
            con.setInstanceFollowRedirects(false);
            con.setDoInput(true);           //データの読み込み
            con.setDoOutput(false);         //データの書き込み

            con.connect();                  //接続


            //本文の取得
            InputStream in = con.getInputStream();
            byte bodyByte[] = new byte[1024];
            in.read(bodyByte);
            in.close();



        } catch (MalformedURLException e) {
            Log.e("URLのえら", e.toString());
        } catch (IOException e) {
            Log.e("conえら", e.toString());
        }



        return null;
    }


    //後処理
    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        // doInBackground後処理
    }

}