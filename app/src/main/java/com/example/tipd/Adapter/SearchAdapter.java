package com.example.tipd.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.tipd.MainActivity2;
import com.example.tipd.MainActivity5;
import com.example.tipd.Model.product;
import com.example.tipd.R;

import java.util.List;





public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {

    private List<product> products;

    //public SearchAdapter(MainActivity2 mainActivity2, List<product> product) {
   // }

   // public void setProducts(List<product> products) {
     //   this.products = products;
   // }


     private Context context;


    public SearchAdapter(Context context, List<product> products) {
    this.context = context;
    this.products = products;
    }


    @Override
    public SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.layout_item, parent, false);

        SearchViewHolder searchViewHolder = new SearchViewHolder(itemView, context);
        return searchViewHolder;
    }

    @Override
    public void onBindViewHolder(SearchViewHolder holder, int position) {
        product pro = products.get(position);
        holder.hsCode.setText(products.get(position).getHsCode());
        holder.hsDescription.setText(products.get(position).getHsDescription());
        holder.unit.setText(products.get(position).getUnit());
        holder.vat.setText(products.get(position).getVat());




    }

    @Override
    public int getItemCount() {
        return products.size();
    }



    class SearchViewHolder extends RecyclerView.ViewHolder {

        public Context context;
        public TextView hsCode, hsDescription, unit, vat;


        public SearchViewHolder(View itemView,final Context context) {
            super(itemView);
            this.context = context;
            hsCode = (TextView) itemView.findViewById(R.id.hsCode);
            hsDescription = (TextView) itemView.findViewById(R.id.hsDescription);
            unit = (TextView) itemView.findViewById(R.id.un);
            vat = (TextView) itemView.findViewById(R.id.vat);



           itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    product pro = products.get(position);

                    Intent intent=new Intent(context, MainActivity5.class);
                    intent.putExtra("hsDescription", pro.getHsDescription());
                    intent.putExtra("vat", pro.getVat());
                    intent.putExtra("unit",pro.getUnit());
                    intent.putExtra("customsDuty",pro.getCustomsDuty());
                    intent.putExtra("surcharge",pro.getSurcharge());
                    intent.putExtra("pal",pro.getPal());
                    intent.putExtra("cessLevy",pro.getCessLevy());
                    intent.putExtra("exciseDuty",pro.getExciseDuty());
                    intent.putExtra("ridl",pro.getRidl());
                    intent.putExtra("srl",pro.getSrl());
                    intent.putExtra("nbt",pro.getNbt());
                    intent.putExtra("hsCode",pro.getHsCode());


                    context.startActivity(intent);
                }
            });

        }


    }
}
