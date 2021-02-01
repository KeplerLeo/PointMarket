package com.example.pointmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listItens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listItens = findViewById(R.id.listItens);
        listItens.setOnItemClickListener(this);
    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        if (position == 0) {
            Intent intent = new Intent(this, RegisterProduct_Activity.class);
            startActivity(intent);
        }
        if (position == 1) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("*/*");
            intent.putExtra(Intent.EXTRA_EMAIL, "pointmarket@gmail.com");
            intent.putExtra(Intent.EXTRA_SUBJECT, "Contato pelo APP");
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }
        if (position == 2) {
            Intent intent = new Intent(this, About_Activity.class);
            startActivity(intent);
        }
    }
}