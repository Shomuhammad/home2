package com.example.a2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button enter;
    private TextView textView;
    private TextView textView2;
    private TextView textView3;
    private TextWatcher textWatcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username_ic);
        password = findViewById(R.id.password_ic);
        textView = findViewById(R.id.text12_ic);
        textView2 = findViewById(R.id.text10_ic);
        textView3 = findViewById(R.id.ключ_ic);
        enter = findViewById(R.id.enter_ic);

        textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (username.getText().toString().length() > 0 && password.getText().toString().length() > 0) {
                    enter.setBackground(getDrawable(R.drawable.ic_orange));
                } else {
                    enter.setBackground(getDrawable(R.drawable.ic_button));
                    enter.setBackgroundColor(getColor(R.color.orange));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
        username.addTextChangedListener(textWatcher);
        password.addTextChangedListener(textWatcher);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
                    Toast.makeText(MainActivity.this, "Вы успешно зарегистрировались",Toast.LENGTH_LONG).show();
                    textView.setVisibility(View.INVISIBLE);
                    username.setVisibility(View.INVISIBLE);
                   password.setVisibility(View.INVISIBLE);
                    enter.setVisibility(View.INVISIBLE);
                    textView2.setVisibility(View.INVISIBLE);
                    textView3.setVisibility(View.INVISIBLE);
                }else {
                    Toast.makeText(MainActivity.this, "Неправильный логин и пароль",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}