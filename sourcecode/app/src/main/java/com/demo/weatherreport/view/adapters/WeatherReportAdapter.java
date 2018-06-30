package com.demo.weatherreport.view.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HeaderViewListAdapter;
import android.widget.TextView;

import com.demo.weatherreport.R;
import com.demo.weatherreport.model.pojo.ResWeatherReport;

import java.util.List;

public class WeatherReportAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<ResWeatherReport> resWeatherReportList;

    public WeatherReportAdapter(List<ResWeatherReport> resWeatherReportList) {
        this.resWeatherReportList = resWeatherReportList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_weather_report_header, parent, false);
            TableHeaderViewHolder viewHolder = new TableHeaderViewHolder(view);
            return viewHolder;
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_weather_report, parent, false);
            WeatherReportViewHolder viewHolder = new WeatherReportViewHolder(view);
            return viewHolder;
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof WeatherReportViewHolder) {
            WeatherReportViewHolder weatherReportViewHolder = (WeatherReportViewHolder) holder;
            weatherReportViewHolder.tvYear.setText(resWeatherReportList.get(position).getData()[2]);
            weatherReportViewHolder.tvJan.setText(resWeatherReportList.get(position).getData()[3]);
            weatherReportViewHolder.tvFeb.setText(resWeatherReportList.get(position).getData()[4]);
            weatherReportViewHolder.tvMar.setText(resWeatherReportList.get(position).getData()[5]);
            weatherReportViewHolder.tvApr.setText(resWeatherReportList.get(position).getData()[6]);
            weatherReportViewHolder.tvMay.setText(resWeatherReportList.get(position).getData()[7]);
            weatherReportViewHolder.tvJun.setText(resWeatherReportList.get(position).getData()[8]);
            weatherReportViewHolder.tvJul.setText(resWeatherReportList.get(position).getData()[9]);
            weatherReportViewHolder.tvAug.setText(resWeatherReportList.get(position).getData()[10]);
            weatherReportViewHolder.tvSept.setText(resWeatherReportList.get(position).getData()[11]);
            weatherReportViewHolder.tvOct.setText(resWeatherReportList.get(position).getData()[12]);
            weatherReportViewHolder.tvNov.setText(resWeatherReportList.get(position).getData()[13]);
            weatherReportViewHolder.tvDec.setText(resWeatherReportList.get(position).getData()[14]);
            weatherReportViewHolder.tvWin.setText(resWeatherReportList.get(position).getData()[15]);
            weatherReportViewHolder.tvSpr.setText(resWeatherReportList.get(position).getData()[16]);
            weatherReportViewHolder.tvSum.setText(resWeatherReportList.get(position).getData()[17]);
            weatherReportViewHolder.tvAut.setText(resWeatherReportList.get(position).getData()[18]);
            weatherReportViewHolder.tvAnn.setText(resWeatherReportList.get(position).getData()[19]);
        } else {

            TableHeaderViewHolder tableHeaderViewHolder = (TableHeaderViewHolder) holder;
            tableHeaderViewHolder.tvYear.setText(resWeatherReportList.get(position).getData()[2]);
            tableHeaderViewHolder.tvJan.setText(resWeatherReportList.get(position).getData()[3]);
            tableHeaderViewHolder.tvFeb.setText(resWeatherReportList.get(position).getData()[4]);
            tableHeaderViewHolder.tvMar.setText(resWeatherReportList.get(position).getData()[5]);
            tableHeaderViewHolder.tvApr.setText(resWeatherReportList.get(position).getData()[6]);
            tableHeaderViewHolder.tvMay.setText(resWeatherReportList.get(position).getData()[7]);
            tableHeaderViewHolder.tvJun.setText(resWeatherReportList.get(position).getData()[8]);
            tableHeaderViewHolder.tvJul.setText(resWeatherReportList.get(position).getData()[9]);
            tableHeaderViewHolder.tvAug.setText(resWeatherReportList.get(position).getData()[10]);
            tableHeaderViewHolder.tvSept.setText(resWeatherReportList.get(position).getData()[11]);
            tableHeaderViewHolder.tvOct.setText(resWeatherReportList.get(position).getData()[12]);
            tableHeaderViewHolder.tvNov.setText(resWeatherReportList.get(position).getData()[13]);
            tableHeaderViewHolder.tvDec.setText(resWeatherReportList.get(position).getData()[14]);
            tableHeaderViewHolder.tvWin.setText(resWeatherReportList.get(position).getData()[15]);
            tableHeaderViewHolder.tvSpr.setText(resWeatherReportList.get(position).getData()[16]);
            tableHeaderViewHolder.tvSum.setText(resWeatherReportList.get(position).getData()[17]);
            tableHeaderViewHolder.tvAut.setText(resWeatherReportList.get(position).getData()[18]);
            tableHeaderViewHolder.tvAnn.setText(resWeatherReportList.get(position).getData()[19]);
        }


    }

    @Override
    public int getItemCount() {
        return resWeatherReportList.size();
    }

    public class WeatherReportViewHolder extends RecyclerView.ViewHolder {
        TextView tvYear, tvJan, tvFeb, tvMar, tvApr, tvMay, tvJun, tvJul, tvAug, tvSept, tvOct, tvNov, tvDec, tvWin, tvSpr, tvSum, tvAut, tvAnn;

        public WeatherReportViewHolder(View itemView) {
            super(itemView);
            tvYear = itemView.findViewById(R.id.tvYear);
            tvJan = itemView.findViewById(R.id.tvJan);
            tvFeb = itemView.findViewById(R.id.tvFeb);
            tvMar = itemView.findViewById(R.id.tvMar);
            tvApr = itemView.findViewById(R.id.tvApr);
            tvMay = itemView.findViewById(R.id.tvMay);
            tvJun = itemView.findViewById(R.id.tvJun);
            tvJul = itemView.findViewById(R.id.tvJul);
            tvAug = itemView.findViewById(R.id.tvAug);
            tvSept = itemView.findViewById(R.id.tvSept);
            tvOct = itemView.findViewById(R.id.tvOct);
            tvNov = itemView.findViewById(R.id.tvNov);
            tvDec = itemView.findViewById(R.id.tvDec);
            tvWin = itemView.findViewById(R.id.tvWin);
            tvSpr = itemView.findViewById(R.id.tvSpr);
            tvSum = itemView.findViewById(R.id.tvSum);
            tvAut = itemView.findViewById(R.id.tvAut);
            tvAnn = itemView.findViewById(R.id.tvAnn);


        }
    }


    public class TableHeaderViewHolder extends RecyclerView.ViewHolder {
        TextView tvYear, tvJan, tvFeb, tvMar, tvApr, tvMay, tvJun, tvJul, tvAug, tvSept, tvOct, tvNov, tvDec, tvWin, tvSpr, tvSum, tvAut, tvAnn;

        public TableHeaderViewHolder(View itemView) {
            super(itemView);
            tvYear = itemView.findViewById(R.id.tvYear);
            tvJan = itemView.findViewById(R.id.tvJan);
            tvFeb = itemView.findViewById(R.id.tvFeb);
            tvMar = itemView.findViewById(R.id.tvMar);
            tvApr = itemView.findViewById(R.id.tvApr);
            tvMay = itemView.findViewById(R.id.tvMay);
            tvJun = itemView.findViewById(R.id.tvJun);
            tvJul = itemView.findViewById(R.id.tvJul);
            tvAug = itemView.findViewById(R.id.tvAug);
            tvSept = itemView.findViewById(R.id.tvSept);
            tvOct = itemView.findViewById(R.id.tvOct);
            tvNov = itemView.findViewById(R.id.tvNov);
            tvDec = itemView.findViewById(R.id.tvDec);
            tvWin = itemView.findViewById(R.id.tvWin);
            tvSpr = itemView.findViewById(R.id.tvSpr);
            tvSum = itemView.findViewById(R.id.tvSum);
            tvAut = itemView.findViewById(R.id.tvAut);
            tvAnn = itemView.findViewById(R.id.tvAnn);
        }
    }
}
