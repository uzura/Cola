package net.jp.uzura.cola;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class Welcome4Fragment extends Fragment{


    public Welcome4Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_welcome4, container, false);

        Button startButton = (Button)v.findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                // ウェルカム画面を見せ終わったので、ウェルカム画面を表示しない設定に変更
                Context context = getActivity();
                SharedPreferences pref = context.getSharedPreferences("app",context.MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putBoolean("isShowWelcome",false);
                editor.commit();

                Intent intent = new Intent();
                intent.setClassName("net.jp.uzura.cola", "net.jp.uzura.cola.FunctionActivity");
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        return v;
    }


}
