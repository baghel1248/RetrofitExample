package com.example.retrofitexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.Myviewholder> {
    List<Student> slist;

    public RecyclerAdapter(List<Student> slist) {
        this.slist = slist;
    }


    @NonNull
    @Override
    public Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.resource_item,parent,false);
        return new Myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myviewholder holder, int position) {
        holder.name.setText(slist.get(position).getName());
        holder.id.setText(slist.get(position).getId());
    }

    @Override
    public int getItemCount() {
        return slist.size();
    }

    public class Myviewholder extends RecyclerView.ViewHolder {

        TextView name;
        TextView id;


        public Myviewholder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.nametextview);
            id=itemView.findViewById(R.id.idtextview);
        }
    }
}
