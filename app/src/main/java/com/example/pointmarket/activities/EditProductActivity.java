package com.example.pointmarket.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pointmarket.R;
import com.example.pointmarket.model.Product;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditProductActivity extends AppCompatActivity implements Button.OnClickListener {

    Button btnChange;
    String key;
    EditText name;
    EditText desc;
    EditText value;
    View root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editproduct);
        Intent intent = getIntent();
        name = findViewById(R.id.textViewName);
        name.setText(intent.getStringExtra("name"));
        desc = findViewById(R.id.textViewDescription);
        desc.setText(intent.getStringExtra("desc"));
        value = findViewById(R.id.textViewValue);
        value.setText(intent.getStringExtra("value"));
        key = intent.getStringExtra("key");
        btnChange = findViewById(R.id.btnChange);
        btnChange.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        new AlertDialog.Builder(this)
                .setTitle("Editando produto")
                .setMessage("Tem certeza que deseja editar esse produto?")
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("produtos").child(key);
                        Product p = new Product(name.getText().toString(), desc.getText().toString(), Double.parseDouble(value.getText().toString()) );
                        reference.setValue(p);
                        Intent intent = new Intent(EditProductActivity.this, MenuActivity.class);
                        startActivity(intent);
                    }}).setNegativeButton("Não", null).show();
    }
}
