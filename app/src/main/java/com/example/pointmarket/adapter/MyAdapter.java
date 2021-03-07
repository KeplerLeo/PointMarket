package com.example.pointmarket.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pointmarket.R;
import com.example.pointmarket.activities.EditProductActivity;
import com.example.pointmarket.model.Product;
import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    List<Product> listProducts;
    private Context context;
    public MyAdapter(List<Product> products, Context context) {
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
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder myViewHolder, int i) {
        //exibe os itens no Recycler
        Product p = listProducts.get(i);
        myViewHolder.name.setText(p.getName());
        myViewHolder.desc.setText(p.getDesc());
        myViewHolder.value.setText(p.getDesc());
        myViewHolder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removerItem(i);
            }
        });
        myViewHolder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EditProductActivity.class);
                intent.putExtra("NAME", listProducts.get(i).getName());
                intent.putExtra("DESC", listProducts.get(i).getDesc());
                intent.putExtra("VALUE", listProducts.get(i).getValue());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
        }
    private void removerItem(int position){
        listProducts.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, listProducts.size());
    }

    @Override
    public int getItemCount() {
        //retorna a quantidade de itens que será exibida
        return listProducts.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        //dados da pessoa que serão exibidos no recycler
        TextView name;
        TextView desc;
        TextView value;
        ImageButton btnEdit;
        ImageButton btnDelete;

        public MyViewHolder(View itemView){
            super(itemView);
            //passa uma referência para os componentes que estão na interface
            name = itemView.findViewById(R.id.textViewName);
            desc = itemView.findViewById(R.id.textViewDescription);
            value = itemView.findViewById(R.id.textViewValue);
            btnEdit = itemView.findViewById(R.id.btnEdit);
            btnDelete = itemView.findViewById(R.id.btnDelete);
        }
    }
}
