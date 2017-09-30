package jp.techacademy.yoshie.sekiguchi.aisatsuapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.app.TimePickerDialog;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //button1にListener登録して待機状態にする
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.textView);
    }

    @Override
    public void onClick(View v) {
        //onClick時、TimePickerDialog表示
        showTimePickerDialog();
    }

    //TimePickerDialogを表示
    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Log.d("UI-PARTS", String.valueOf(hourOfDay) + ":" + String.valueOf(minute));

                        //時刻によってText表示する
                        if (hourOfDay >= 2 && hourOfDay < 10) {
                            mTextView.setText("おはよう。今の時刻は、" + String.valueOf(hourOfDay) + "時" + String.valueOf(minute) + "分です。");
                        } else if (hourOfDay >= 10 && hourOfDay < 18) {
                            mTextView.setText("こんにちは。今の時刻は、" + String.valueOf(hourOfDay) + "時" + String.valueOf(minute) + "分です。");
                        } else {
                            mTextView.setText("こんばんは。今の時刻は、" + String.valueOf(hourOfDay) + "時" + String.valueOf(minute) + "分です。");
                        }
                    }
                },
                0, // 初期値（時間）
                0,  // 初期値（分）
                true);
        timePickerDialog.show();
    }
}