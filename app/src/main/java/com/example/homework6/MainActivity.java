package com.example.homework6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout container = findViewById(R.id.container);
        TextView textView = findViewById(R.id.text3_view);

        EditText editText = findViewById(R.id.edit_text);
        EditText editText1 = findViewById(R.id.edit2_text);

        Button button = findViewById(R.id.button);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 0) {
                    button.setBackgroundResource(R.drawable.bg_button1);
                }else {
                    button.setBackgroundResource(R.drawable.bg_button2);
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String login = editText.getText().toString();
                String password = editText1.getText().toString();

                if (login.equals("admin") && password.equals("admin") && editText.getText().length() > 0) {
                    button.setBackgroundResource(R.drawable.bg_button2);
                    container.setVisibility(View.GONE);
                    textView.setVisibility(View.GONE);
                    Toast.makeText(MainActivity.this, "Вы успешно зарегистрировались", Toast.LENGTH_SHORT).show();
                }
                if (!login.equals("admin") && !password.equals("admin") && editText.getText().length() > 0) {
                    button.setBackgroundResource(R.drawable.bg_button2);
                    Toast.makeText(MainActivity.this, "Неправильный логин или пароль", Toast.LENGTH_SHORT).show();
                }
                if (login.isEmpty() && password.isEmpty()){
                    Toast.makeText(MainActivity.this, "Заполните поля", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}