package com.pucit.hostelhubupdated;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyNotificationAdapter extends RecyclerView.Adapter<MyNotificationAdapter.ViewHolder> {


    Context application;
    List<Notification> data;

    public MyNotificationAdapter(Context application, List<Notification> data) {
        this.application = application;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_notificationlist_view,parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Notification i = data.get(position);
        holder.name.setText(i.getName());
        holder.d.setText(i.getDate());
        holder.det.setText(i.getDetail());
        holder.notif=i;
    }



    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView d;
        TextView det;
        public Notification notif;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.rl_tv_name_nlist);
            d = itemView.findViewById(R.id.rl_tv_date_nlist);
            det = itemView.findViewById(R.id.rl_tv_detail_nlist);

        }
    }
}
