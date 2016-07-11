import android.os.AsyncTask;

/**
 * Created by akihiro on 2016/07/11.
 */
public class Http_DetailImage extends AsyncTask<Void, Void, String> {
    @Override protected void onPreExecute() {
    super.onPreExecute();
            // doInBackground前処理
    }

    @Override
    protected String doInBackground(Void... params) {
        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        // doInBackground後処理
    }

}
