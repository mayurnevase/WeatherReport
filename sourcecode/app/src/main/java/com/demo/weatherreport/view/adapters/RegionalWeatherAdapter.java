package com.demo.weatherreport.view.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.demo.weatherreport.R;
import com.demo.weatherreport.model.pojo.WeatherStat;

import org.w3c.dom.Text;

import java.util.List;

public class RegionalWeatherAdapter extends RecyclerView.Adapter<RegionalWeatherAdapter.RegionalWeatherViewHolder> {


    private List<WeatherStat> weatherStatList;
    private RegionalWeatherView regionalWeatherView;

    public RegionalWeatherAdapter(List<WeatherStat> weatherStatList, RegionalWeatherView regionalWeatherView) {

        this.regionalWeatherView = regionalWeatherView;
        this.weatherStatList = weatherStatList;
    }

    @NonNull
    @Override
    public RegionalWeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_weather_stat, parent, false);
        RegionalWeatherViewHolder viewHolder = new RegionalWeatherViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RegionalWeatherViewHolder holder, int position) {

        holder.tvRegion.setText(weatherStatList.get(position).getRegion());
    }

    @Override
    public int getItemCount() {
        return weatherStatList.size();
    }

    class RegionalWeatherViewHolder extends RecyclerView.ViewHolder {

        TextView tvRegion, tvMaxTemp, tvMinTemp, tvMeanTemp, tvRainfall, tvSunshine;

        public RegionalWeatherViewHolder(View itemView) {
            super(itemView);
            tvRegion = itemView.findViewById(R.id.tvRegion);
            tvMaxTemp = itemView.findViewById(R.id.tvMaxTemp);
            tvMinTemp = itemView.findViewById(R.id.tvMinTemp);
            tvMeanTemp = itemView.findViewById(R.id.tvMeanTemp);
            tvRainfall = itemView.findViewById(R.id.tvRainfall);
            tvSunshine = itemView.findViewById(R.id.tvSunshine);

            tvMaxTemp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    regionalWeatherView.onItemClick(weatherStatList.get(getAdapterPosition()).getMax_temp_url(), weatherStatList.get(getAdapterPosition()).getRegion(), "Max_Temp");
                }
            });

            tvMinTemp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    regionalWeatherView.onItemClick(weatherStatList.get(getAdapterPosition()).getMin_temp_url(), weatherStatList.get(getAdapterPosition()).getRegion(), "Min_Temp");
                }
            });

            tvSunshine.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    regionalWeatherView.onItemClick(weatherStatList.get(getAdapterPosition()).getSunshine_url(), weatherStatList.get(getAdapterPosition()).getRegion(), "Sunshine");
                }
            });

            tvMeanTemp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    regionalWeatherView.onItemClick(weatherStatList.get(getAdapterPosition()).getMean_temp_url(), weatherStatList.get(getAdapterPosition()).getRegion(), "Mean_Temp");
                }
            });

            tvRainfall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    regionalWeatherView.onItemClick(weatherStatList.get(getAdapterPosition()).getRainfall_url(), weatherStatList.get(getAdapterPosition()).getRegion(), "Rainfall");
                }
            });
        }
    }

    public interface RegionalWeatherView {
        void onItemClick(String url, String region, String statType);
    }


}
