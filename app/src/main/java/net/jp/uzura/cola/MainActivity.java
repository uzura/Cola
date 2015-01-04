package net.jp.uzura.cola;

import com.crittercism.app.Crittercism;
import com.viewpagerindicator.CirclePageIndicator;


import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;


public class MainActivity extends ActionBarActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Crittercism
        Crittercism.initialize(getApplicationContext(), getString(R.string.crittercism_app_id)); //Crittercism App ID

        setContentView(R.layout.activity_main);

        // ViewPager with fragment
        FragmentManager manager = getSupportFragmentManager();
        final ViewPager viewPager = (ViewPager)findViewById(R.id.pager);
        final WelcomeFragmentPagerAdapter adapter = new WelcomeFragmentPagerAdapter(manager);
        viewPager.setAdapter(adapter);

        //CirclePageIndicator
        CirclePageIndicator mIndicator = (CirclePageIndicator)findViewById(R.id.indicator);
        mIndicator.setViewPager(viewPager);
    }

    @Override
    public void onResume() {
        super.onResume();

        // ウェルカム画面の表示設定がOFFならウェルカム画面を飛ばす
        SharedPreferences pref = getSharedPreferences("app",MODE_PRIVATE);
        Boolean isShowWelcome = pref.getBoolean("isShowWelcome",true);

        // メニューからウェルカム画面を表示させるときは設定にかかわらず見せる
        Intent i = getIntent();
        Boolean isForceShow = i.getBooleanExtra("isForceShow",false);

        if ( !isShowWelcome && !isForceShow){
            Intent intent = new Intent();
            intent.setClassName("net.jp.uzura.cola", "net.jp.uzura.cola.FunctionActivity");
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish(); // 戻るキーでアプリを終了できるようにこのActivityは終了させる
        }
    }
}
