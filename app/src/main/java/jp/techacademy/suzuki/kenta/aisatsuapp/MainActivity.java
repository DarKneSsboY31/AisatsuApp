package jp.techacademy.suzuki.kenta.aisatsuapp;

import android.support.v7.app.AppCompatActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.TimePickerDialog;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity{

    //Textviewを定義
    TextView mTextView;
    //時間と分を定義
    int hour;
    int Minute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //mTextViewをID「Text」で設定
        mTextView = (TextView)findViewById(R.id.Text);

        //ボタンを設定、ID「BUTTON」。
        Button BUTTon = (Button)findViewById(R.id.BUTTON);
        BUTTon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //クリックしたときの動作
                if (v.getId() == R.id.BUTTON){
                    //showTimePickerDialogを起動
                    showTimePickerDialog();
                }
            }
        });
    }

    //showTimePickerDialodの中身
    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        hour = hourOfDay;
                        Minute = minute;
                        Log.d("UI-PARTS", String.valueOf(hourOfDay) + ":" + String.valueOf(minute));
                        if (hour >= 2 && hour < 10 && Minute >= 0 && Minute <= 59){
                            //設定した時間によってTextが変化
                            mTextView.setText("おはよう");
                        }
                        else if (hour >= 10 && hour < 18 && Minute >= 0 && Minute <= 59){
                            mTextView.setText("こんにちは");
                        }
                        else if (((hour >= 18 && hour < 25) ||( hour >= 0 && hour < 2)&& Minute >= 0 && Minute <= 59)){
                            mTextView.setText("こんばんは");
                        }
                    }
                },
                0, // 初期値（時間）
                0,  // 初期値（分）
                true);
        timePickerDialog.show();

    }
}

