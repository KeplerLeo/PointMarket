package com.example.pointmarket.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pointmarket.R;
import com.example.pointmarket.activities.EditProductActivity;
import com.example.pointmarket.model.Product;
import com.example.pointmarket.util.FirebaseConf;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    List<Product> listProducts;
    Context context;
    public MyAdapter(Context context, List<Product> products) {
        this.listProducts = products;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //chamado para criar as visualizações - somente as primeiras que aparecem para o usuário
        //convertendo o XML em uma visualização
        //cria um objeto do tipo view
        View itemList = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.adapter_card, viewGroup, false);
        //retorna o itemList que é passado para o construtor da MyViewHolder
        return new MyViewHolder(itemList);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder myViewHolder, @SuppressLint("RecyclerView") final int position) {
        //exibe os itens no Recycler
        final Product product = listProducts.get(position);
        myViewHolder.name.setText(product.getName());
        myViewHolder.desc.setText(product.getDesc());
        myViewHolder.value.setText(String.valueOf(product.getValue()));
        myViewHolder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removerItem(position);
            }
        });
        myViewHolder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EditProductActivity.class);
                intent.putExtra("key", product.getId());
                intent.putExtra("name", product.getName());
                intent.putExtra("desc", product.getDesc());
                intent.putExtra("value", String.valueOf(product.getValue()));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.getApplicationContext().startActivity(intent);
            }
        });
    }
    public void removerItem(final int position) {
        new AlertDialog.Builder(context)
                .setTitle("Deletando produto")
                .setMessage("Tem certeza que deseja deletar esse produto?")
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        final DatabaseReference reference = FirebaseConf.getNo("produtos");
                        reference.child(listProducts.get(position).getId()).removeValue();
                        listProducts.remove(position);
                        notifyItemRemoved(position);

                    }}).setNegativeButton("Não", null).show();
    }
    @Override
    public int getItemCount() {
        //retorna a quantidade de itens que será exibida
        return listProducts != null ? listProducts.size() : 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        //dados da pessoa que serão exibidos no recycler
        TextView name;
        TextView desc;
        TextView value;
        ImageButton btnDelete;
        ImageButton btnEdit;

        public MyViewHolder(View itemView){
            super(itemView);
            //passa uma referência para os componentes que estão na interface
            name = itemView.findViewById(R.id.textViewName);
            desc = itemView.findViewById(R.id.textViewDescription);
            value = itemView.findViewById(R.id.textViewValue);
            btnDelete =  itemView.findViewById(R.id.btnDelete);
            btnEdit =  itemView.findViewById(R.id.btnEdit);
        }
    }
}
