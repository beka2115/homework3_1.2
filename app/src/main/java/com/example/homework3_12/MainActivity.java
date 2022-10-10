package com.example.homework3_12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button send;
    EditText email, subject, text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        send = findViewById(R.id.send);
        email = findViewById(R.id.email);
        subject = findViewById(R.id.tema);
        text = findViewById(R.id.masage);
    }

    public void onClick(View view) {
        if (!email.getText().toString().isEmpty() && !subject.getText().toString().isEmpty() &&
                !text.getText().toString().isEmpty()) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email.getText().toString()});
            intent.putExtra(Intent.EXTRA_SUBJECT, subject.getText().toString());
            intent.putExtra(Intent.EXTRA_TEXT, text.getText().toString());
            intent.setType("message/rfc822");
            startActivity(intent);
        } else {
            Toast.makeText(this, "ОШИБКА", Toast.LENGTH_SHORT).show();
        }


    }
}
