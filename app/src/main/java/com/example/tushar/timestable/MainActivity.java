package com.example.tushar.timestable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SeekBar seekBar;
    ListView listView;
    int tablevalue;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar=findViewById(R.id.seekBar);
        listView=findViewById(R.id.timetable);
        textView=findViewById(R.id.textView);
        seekBar.setMax(20);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tablevalue=progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                    makelist(tablevalue);
                    textView.setText("Showing Tables for "+Integer.toString(tablevalue));
            }
        });


    }

    private void makelist(int tablevalue) {
        ArrayList<String> ints=new ArrayList<String>();
        for(int i=1;i<=20;i++){
            ints.add("\t" + tablevalue+"x"+i + "\t\t   =    \t\t"+Integer.toString(tablevalue*i)  );
        }

        ArrayAdapter<String> integerArrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,ints);
        listView.setAdapter(integerArrayAdapter);
    }


}
