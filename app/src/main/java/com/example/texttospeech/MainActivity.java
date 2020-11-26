package com.example.texttospeech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private TextToSpeech textToSpeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textToSpeech= new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i==TextToSpeech.SUCCESS){
                    int ttslang=textToSpeech.setLanguage(Locale.ENGLISH);

                }
                else{
                    Toast.makeText(MainActivity.this, "Initialization failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void convert(View view) {
        editText=findViewById(R.id.editText);
        String data=editText.getText().toString();
        textToSpeech.speak(data,TextToSpeech.QUEUE_FLUSH,null);
    }
}