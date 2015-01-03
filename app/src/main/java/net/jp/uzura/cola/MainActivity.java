package net.jp.uzura.cola;

import com.crittercism.app.Crittercism;
import com.viewpagerindicator.CirclePageIndicator;


import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.os.Vibrator;
import android.widget.Button;
import android.view.View;
import android.util.Log;
import android.content.Intent;

import net.jp.uzura.cola.R;


public class MainActivity extends ActionBarActivity implements BlankFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Crittercism
        Crittercism.initialize(getApplicationContext(), getString(R.string.crittercism_app_id)); //Crittercism App ID

        setContentView(R.layout.activity_main);

        /*
        // 振動ボタン
        Button btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                vibrator.vibrate(1000);
                Log.v("Button", "onClick");
            }
        });

        Button btn2 = (Button)findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClassName("net.jp.uzura.cola", "net.jp.uzura.cola.Welcome1Activity");
                intent.putExtra("net.jp.uzura.cola.testString", "!TEST STRING!");
                startActivity(intent);
            }
        });*/

        // ViewPager with fragment
        FragmentManager manager = getSupportFragmentManager(); //http://www.united-bears.co.jp/blog/archives/160
        final ViewPager viewPager = (ViewPager)findViewById(R.id.pager);
        final TestFragmentPagerAdapter adapter = new TestFragmentPagerAdapter(manager);
        viewPager.setAdapter(adapter);

        //CirclePageIndicator
        CirclePageIndicator mIndicator = (CirclePageIndicator)findViewById(R.id.indicator);
        mIndicator.setViewPager(viewPager);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    // for fragment
    public void onFragmentInteraction(Uri uri) {
        // TODO Auto-generated method stub
    }
}
