package com.demo.weatherreport.view.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.demo.weatherreport.R;
import com.demo.weatherreport.model.pojo.ResGeometryData;

import java.util.List;

public class GeometryListAdapter extends RecyclerView.Adapter<GeometryListAdapter.GeometryListViewHolder> {

    List<ResGeometryData> resGeometryDataList;
    GeometryListView geometryListView;

    public GeometryListAdapter(List<ResGeometryData> resGeometryDataList, GeometryListView geometryListView) {
        this.resGeometryDataList = resGeometryDataList;
        this.geometryListView = geometryListView;
    }

    @NonNull
    @Override
    public GeometryListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_geometry, parent, false);
        GeometryListViewHolder viewHolder = new GeometryListViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GeometryListViewHolder holder, int position) {

        holder.tvName.setText(resGeometryDataList.get(position).getFarmName());
        holder.tvAreaName.setText(resGeometryDataList.get(position).getFarmLocation());
    }

    @Override
    public int getItemCount() {
        return resGeometryDataList.size();
    }

    public class GeometryListViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvAreaName;

        public GeometryListViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvAreaName = itemView.findViewById(R.id.tvArea);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    geometryListView.onItemClick(resGeometryDataList.get(getAdapterPosition()));
                }
            });
        }
    }

    public interface GeometryListView {
        void onItemClick(ResGeometryData resGeometryData);
    }
}
