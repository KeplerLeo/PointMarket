package com.example.pointmarket.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pointmarket.R;
import com.example.pointmarket.adapter.MyAdapter;
import com.example.pointmarket.model.Product;

public class ListFragment extends Fragment {

    RecyclerView recyclerView;
    public static ListFragment newInstance() {
        return new ListFragment();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_list, container, false);
        recyclerView = root.findViewById(R.id.recyclerView);
        //configurar o adapter - que formata que o layout de cada item do recycler
        MyAdapter myAdapter = new MyAdapter(Product.startList(), getContext());
        recyclerView.setAdapter(myAdapter);
        //linha de código usada para otimizar o recycler
        recyclerView.setHasFixedSize(true);

        //configurar o gerenciador de layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        //definindo o layout do recycler
        recyclerView.setLayoutManager(layoutManager);

        return root;
    }
}