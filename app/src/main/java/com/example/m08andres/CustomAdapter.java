package com.example.m08andres;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private Context context;
    private Activity activity;
    private List<Lista> mbData;

    public CustomAdapter(List<Lista> itemlist, Context context) {
        this.context = context;
        this.mbData = itemlist;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bindData(mbData.get(position));

    }

    @Override
    public int getItemCount() {
        return mbData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name, surname, city;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.user_name_txt);
            surname = itemView.findViewById(R.id.user_surname_txt);
            city = itemView.findViewById(R.id.user_city_txt);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String clickedName = mbData.get(getAdapterPosition()).getName();
                    showToast("Has clicado a " + clickedName);
                }
            });
        }

        void bindData(final Lista item){
            name.setText(item.getName());
            surname.setText(item.getSurname());
            city.setText(item.getCity());
        }

        private void showToast(String message) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        }
    }
}
