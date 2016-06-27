package com.coffee.coffeeweather.view.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.annimon.stream.Stream;
import com.coffee.coffeeweather.R;
import com.coffee.coffeeweather.models.City;
import com.coffee.coffeeweather.view.bases.BaseRvAdapter;
import com.coffee.coffeeweather.view.bases.BaseRvHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/26.
 */
public class SelectCityAdapter extends BaseRvAdapter<List<City>> implements Filterable{


    private List<City> mDatas;
    private SelectCityFilter mFilter;
    private List<City> defalutData;


    public SelectCityAdapter(Context context, List<City> datas) {
        super(context, datas);
        mDatas = datas;
        defalutData=datas;
    }

    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }
    private OnItemClickListener mListener;

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    @Override
    public int getItemCount() {
        return mDatas==null?0:mDatas.size();
    }

    @Override
    public int getLayoutRes() {
        return R.layout.item_city_select;

    }

    @Override
    public BaseRvHolder<List<City>> getHolder(View view) {
        return new SelectCityHolder(view);
    }

    //为了能够根据搜索结果动态更改
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        BaseRvHolder mBaseHolder = (BaseRvHolder) holder;
        mBaseHolder.setData(position,mDatas);
    }

    @Override
    public Filter getFilter() {
        if (mFilter == null) {
            mFilter = new SelectCityFilter();
        }
        return mFilter;
    }

    private class SelectCityFilter extends Filter{

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            if(constraint==null||constraint.length()==0){
                results.values=null;
                results.count=0;
            }else{
                String prefixString= constraint.toString().trim().toLowerCase();
                ArrayList<City> newValues=new ArrayList<>();

                Stream.of(mDatas).filter(city->city.getProvince().contains(prefixString)
                        ||city.getCity().contains(prefixString)
                        ||city.getName().contains(prefixString)
                        ||city.getPinyin().contains(prefixString))
                        .forEach(newValues::add);
                results.values=newValues;
                results.count=newValues.size();
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mDatas = (List<City>) results.values;
            if (results.count > 0) {
                notifyDataSetChanged();//重绘当前可见区域
            } else {
                mDatas = defalutData;
                notifyDataSetChanged();//会重绘控件（还原到初始状态）
            }
            System.out.println("----------"+results.count+":"+mDatas);
        }
    }

    public List<City> getCurrentCities(){
        return mDatas;
    }

    public class SelectCityHolder extends BaseRvHolder<List<City>> {

        private final TextView mTv;

        public SelectCityHolder(View itemView) {
            super(itemView);
            mTv = (TextView) itemView.findViewById(R.id.tv);

            itemView.setOnClickListener((v)->{
                if(mListener!=null){
                    mListener.onItemClick(itemView,getAdapterPosition());
                }
            });
        }

        @Override
        public void setData(int position, List<City> data) {
            City city = data.get(position);
            String cityName=city.getProvince()+"-"+city.getCity()+"-"+city.getName();
            mTv.setText(cityName);


        }
    }
}
