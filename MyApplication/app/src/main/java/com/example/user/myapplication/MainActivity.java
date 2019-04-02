package com.example.user.myapplication;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Btn_yes =(Button)findViewById(R.id.Btn_yes);
        Btn_yes.setOnClickListener(this);
        Button Btn_no =(Button)findViewById(R.id.Btn_no);
        Btn_no.setOnClickListener(this);
        Button checkbox =(Button)findViewById(R.id.checkbox);
        checkbox.setOnClickListener(this);
        Button Btn_send =(Button)findViewById(R.id.Btn_send);
        Btn_send.setOnClickListener(this);

        SeekBar seekbar =(SeekBar)findViewById(R.id.seekbar);
        seekbar.setOnSeekBarChangeListener(this);
        seekbar.setMax(100);
    }

    public void onClick(View v){
        String str = new String();
        switch (v.getId()){
            case R.id.Btn_yes:
                str="\"예\"버튼을 눌렀습니다.";
                break;
            case R.id.Btn_no:
                str="\"아니오\"버튼을 눌렀습니다.";
                break;
            case R.id.Btn_send:
                str="\"전송\"버튼을 눌렀습니다.";

                AlertDialog.Builder builder =new AlertDialog.Builder(this);
                builder.setTitle("전송문자열");
                EditText editText=(EditText)findViewById(R.id.editText);
                String dialogStr =String.valueOf(editText.getText());
                builder.setMessage(dialogStr);
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setPositiveButton("ok",null);
                builder.setNegativeButton("Cancel",null);

                AlertDialog alter =builder.create();
                alter.show();
                break;

            case R.id.checkbox:
                CheckBox checkbox =(CheckBox)findViewById(R.id.checkbox);
                if(checkbox.isChecked())checkbox.setText("항상켜기");
                else checkbox.setText("항상켜지않기");

                str="체크박스를 눌렀습니다.";
                break;
        }
        Toast.makeText(getApplicationContext(),str, Toast.LENGTH_LONG).show();
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        Toast.makeText(getApplicationContext(),"밝기가 변경되었습니다.", Toast.LENGTH_LONG).show();

        String str = String.valueOf(progress);
        EditText textField=(EditText)findViewById(R.id.editText);
                textField.setText(str);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
