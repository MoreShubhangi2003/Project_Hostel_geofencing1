package com.example.hostel_geofencing;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Viewholder> {



    ArrayList<Leave> mList;
    private MyAdapter.RecyclerViewClickListener listener;

    public MyAdapter(ArrayList<Leave> mList, MyAdapter.RecyclerViewClickListener listener) {
        this.mList = mList;
        this.listener = listener;
    }



    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_list,parent,false);

        return new Viewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {

        Leave vacancy1 = mList.get(position);
        holder.txtbname.setText("Student Name: "+vacancy1.getSname());
        holder.txtaddress.setText("Parent Number: "+vacancy1.getPnumber());
        holder.txttype.setText("Reason: "+vacancy1.getReason());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public interface RecyclerViewClickListener{
        void onClick(View v, int position);
    }

    public class Viewholder extends RecyclerView.ViewHolder implements  View.OnClickListener{

        ImageView img1;
        TextView txtbname,txtaddress,txttype;

        public Viewholder(@NonNull View itemView) {
            super(itemView);


            txtbname = itemView.findViewById(R.id.txtbname);
            txtaddress = itemView.findViewById(R.id.txtprofile);
            txttype = itemView.findViewById(R.id.txtaddress);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onClick(view,getAdapterPosition());
        }
    }
}
