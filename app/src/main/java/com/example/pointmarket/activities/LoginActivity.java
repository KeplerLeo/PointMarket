package com.example.pointmarket.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.pointmarket.R;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    private TextInputLayout layoutEmail;
    private TextInputEditText txtEmail;
    private TextInputLayout layoutPass;
    private TextInputEditText txtPass;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        layoutEmail = findViewById(R.id.layoutEmail);
        txtEmail = findViewById(R.id.txtEmail);
        layoutPass = findViewById(R.id.layoutPass);
        txtPass = findViewById(R.id.txtPass);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validarCampos()){
                    Intent intent = new Intent(view.getContext(), MenuActivity.class);
                    startActivity(intent);
                }
                else{
                    Snackbar snackbar = Snackbar.make(view, "Login incorreto", Snackbar.LENGTH_LONG);

                    snackbar.show();
                }
            }
        });


    }
    private boolean validarCampos(){
        if(txtEmail.getText().toString().isEmpty()){
            layoutEmail.setErrorEnabled(true);
            layoutEmail.setError("Informe o seu e-mail");
            return false;
        }else{
            layoutEmail.setErrorEnabled(false);
        }

        if(txtPass.getText().toString().isEmpty()){
            layoutPass.setErrorEnabled(true);
            layoutPass.setError("Informe a sua senha");
            return false;
        }else{
            layoutPass.setErrorEnabled(false);
        }
        Log.d("validacao", "saiu no validar");
        return true;
    }

}