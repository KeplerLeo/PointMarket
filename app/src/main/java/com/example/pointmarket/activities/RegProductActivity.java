package com.example.pointmarket.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pointmarket.R;
import com.example.pointmarket.model.Product;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class RegProductActivity extends AppCompatActivity {

    private Button btnReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regproduct);
        btnReg = (Button) findViewById(R.id.btnReg);
        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Snackbar snackbar = Snackbar
                        .make(v, "Método não implementado", Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });

}
}