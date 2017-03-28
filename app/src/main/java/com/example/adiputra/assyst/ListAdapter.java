package com.example.adiputra.assyst;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {

    private java.util.List listData;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView lokasi, latitude, longitude, radius, message;
//        TextView id;

        public MyViewHolder(View view) {
            super(view);
            //id = (TextView) view.findViewById(R.id.id);
            lokasi = (TextView) view.findViewById(R.id.lokasi);
            latitude = (TextView) view.findViewById(R.id.latitude);
            longitude = (TextView) view.findViewById(R.id.longitude);
            radius = (TextView) view.findViewById(R.id.radius);
            message = (TextView) view.findViewById(R.id.message);
        }
    }


    public ListAdapter(java.util.List listData) {
        this.listData = listData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //tambah (List)
        List l = (List) listData.get(position);
        //holder.id.setText(l.getId());
        holder.lokasi.setText(l.getLokasi());
        holder.latitude.setText(l.getLatitude());
        holder.longitude.setText(l.getLongitude());
        holder.radius.setText(l.getRadius());
        holder.message.setText(l.getMessage());
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }
}