package com.example.hostel_geofencing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PermissionAdapter  extends RecyclerView.Adapter<PermissionAdapter.Viewholder>{


    ArrayList<Permission> mList;
    Context context;

    public PermissionAdapter(ArrayList<Permission> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list,parent,false);

        return new PermissionAdapter.Viewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        Permission vacancy1 = mList.get(position);
        holder.txtbname.setText("Student Name: "+vacancy1.getSname());
        holder.txtaddress.setText("Parent Number: "+vacancy1.getPnumer());
        holder.txttype.setText("Reason: "+vacancy1.getReason());
        holder.txtstatus.setText("Status: "+vacancy1.getStatus());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }



    public class Viewholder extends RecyclerView.ViewHolder {

        ImageView img1;
        TextView txtbname,txtaddress,txttype,txtstatus;

        public Viewholder(@NonNull View itemView) {
            super(itemView);


            txtbname = itemView.findViewById(R.id.txtbname);
            txtaddress = itemView.findViewById(R.id.txtprofile);
            txttype = itemView.findViewById(R.id.txtaddress);
            txtstatus = itemView.findViewById(R.id.txtstatus);

        }


    }
}
