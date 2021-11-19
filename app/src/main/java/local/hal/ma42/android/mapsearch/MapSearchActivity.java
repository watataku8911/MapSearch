package local.hal.ma42.android.mapsearch;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * MA42 Androidサンプル14 暗黙的インテント2
 *
 * 画面表示用アクティビティクラス。
 *
 * @author Shinzo SAITO
 */
public class MapSearchActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_search);
    }

    /**
     * 地図検索ボタンがクリックされたときの処理。
     *
     * @param view 画面部分
     */
    public void searchButtonClick(View view) {
        try {
            TextView etKeyword = findViewById(R.id.etKeyword);
            String keyword = etKeyword.getText().toString();
            keyword = URLEncoder.encode(keyword, "utf-8");
            Uri uri = Uri.parse("geo:0,0?q=" + keyword);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        catch(UnsupportedEncodingException ex) {
            Log.e("MapSearchActivity", "keyword変換失敗", ex);
        }
    }
}
