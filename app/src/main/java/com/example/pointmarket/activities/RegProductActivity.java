package com.example.pointmarket.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pointmarket.R;
import com.example.pointmarket.model.Product;
import com.example.pointmarket.util.FirebaseConf;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.List;

public class RegProductActivity extends AppCompatActivity {
    private DatabaseReference reference = FirebaseConf.getNoRaiz();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regproduct);
    }
    public void regProduto(View view){
        String name = ((EditText)findViewById(R.id.textViewName)).getText().toString();
        String desc = ((EditText)findViewById(R.id.textViewDescription)).getText().toString();
        Double value = Double.parseDouble(((EditText)findViewById(R.id.textViewValue)).getText().toString());
        Product prod = new Product(name, desc, value);
        DatabaseReference produtos = reference.child("produtos");
        //gera um identificador único para cada produto
        //salva o produto na base de dados
        produtos.push().setValue(prod).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(RegProductActivity.this, "Sucesso ao cadastrar produto!", Toast.LENGTH_SHORT).show();
                limparCampos();
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(RegProductActivity.this, "Erro ao cadastrar produto!", Toast.LENGTH_SHORT).show();
                    }
                });
    }
    private void limparCampos(){
        ((EditText)findViewById(R.id.textViewName)).setText("");
        ((EditText)findViewById(R.id.textViewDescription)).setText("");
        ((EditText)findViewById(R.id.textViewValue)).setText("");
    }
}