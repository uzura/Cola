package net.jp.uzura.cola;

import android.content.Intent;
import android.os.Vibrator;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class FunctionActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function);

        // 振動ボタン
        Button vibratorButton = (Button)findViewById(R.id.vibratorButton);
        vibratorButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Vibrator vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);
                vibrator.vibrate(1000);
                Log.v("Button", "onClick");
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_function, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if(id == R.id.action_usage){
            Intent intent = new Intent();
            intent.setClassName("net.jp.uzura.cola", "net.jp.uzura.cola.MainActivity");
            startActivity(intent);
            return true;
        }else if (id == R.id.action_legal) {
            Intent intent = new Intent();
            intent.setClassName("net.jp.uzura.cola", "net.jp.uzura.cola.LegalActivity");
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
