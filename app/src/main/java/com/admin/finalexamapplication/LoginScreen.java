package com.admin.finalexamapplication;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginScreen extends Activity {


    @Override
    protected void onCreate(Bundle saveInstanceState){

        super.onCreate(saveInstanceState);
        setContentView(R.layout.loginscreen);
        Button LogInButton = findViewById(R.id.LoginButton);


//    if (LogInButton != null) {

        final String Username = "Admin";
        final String Password = "12345";
        LogInButton.setOnClickListener(v -> {
            EditText textInputUsername = findViewById(R.id.InputUsername);
            String rigthuser = textInputUsername.getText().toString().trim();
            EditText textInputPassword = findViewById(R.id.InputPassword);
            String rightpass = textInputPassword.getText().toString().trim();
          if (rigthuser.equals(Username) && rightpass.equals(Password)) {
                Toast.makeText(LoginScreen.this, "Log In Successfully!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginScreen.this, ApetizerActivity.class);
                startActivity(intent);
                finish(); // Close the LoginScreen


            } else {
                // Log or throw an exception to detect layout mismatches during development
                Toast.makeText(LoginScreen.this, "Incorrect Username or Password \n Please Retry", Toast.LENGTH_SHORT).show();
                textInputPassword.setText(null);
            }

        });


        CheckBox showPass = findViewById(R.id.password_toggle);
        EditText textInputPassword = findViewById(R.id.InputPassword);
        showPass.setOnCheckedChangeListener((buttonView, isChecked) -> {

            int start = textInputPassword.getSelectionStart(); // Save cursor position
            int end = textInputPassword.getSelectionEnd();

            if (isChecked) {
                textInputPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            } else {
                textInputPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            }

            textInputPassword.setSelection(start, end);
        });
//    }


    }


}
