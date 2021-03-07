package com.example.pointmarket.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pointmarket.R;
import com.google.android.material.snackbar.Snackbar;

public class EditProductActivity extends AppCompatActivity {

    private Button btnChange;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editproduct);
        TextView name = findViewById(R.id.textViewName);
        TextView desc = findViewById(R.id.textViewDescription);
        TextView value = findViewById(R.id.textViewValue);
        Intent intent = getIntent();
        name.setText(intent.getStringExtra("NAME"));
        desc.setText(intent.getStringExtra("DESC"));
        value.setText(intent.getStringExtra("VALUE"));

        btnChange = (Button) findViewById(R.id.btnChange);
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar
                        .make(v, "Método não implementado", Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });
    }
}