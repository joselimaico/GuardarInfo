package com.example.root.guardarinfo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         textView = (TextView) findViewById(R.id.textView);
    }

    public void writeFile(View view) {
        String filename = "file.txt";
        FileOutputStream outputStream;

        String string = "Sistemas sistemas sistemas sistemas!";

        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(string.getBytes());
            outputStream.close();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("File not found" + e);
        }
    }
    public void readFile(View view) {
        String filename = "file.txt";
        FileInputStream inputStream;
        try {
            inputStream = openFileInput(filename);
            byte fileContent[] = new byte[(int) inputStream.getChannel().size()];
            inputStream.read(fileContent);
            String s= new String(fileContent);
            textView.setText(s);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("File not found" + e);
        }
    }



    }
