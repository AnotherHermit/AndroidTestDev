package io.anotherhermit.applytheme.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import io.anotherhermit.applytheme.R;
import io.anotherhermit.applytheme.model.Landscape;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private static final String TAG = RecyclerAdapter.class.getSimpleName();
    private static final int PRIME_ROW = 0;
    private static final int NON_PRIME_ROW = 1;


    private List<Landscape> mData;
    private LayoutInflater mInflater;

    public RecyclerAdapter(Context context, List<Landscape> mData) {
        this.mData = mData;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        Log.i(TAG, "onCreateViewHolder");

        switch (viewType) {
            case PRIME_ROW:
                ViewGroup primeRow = (ViewGroup) mInflater.inflate(R.layout.list_item_prime, parent, false);
                MyViewHolder_PRIME holderPrime = new MyViewHolder_PRIME(primeRow);
                return holderPrime;

            case NON_PRIME_ROW:
            default:
                ViewGroup nonPrimeRow = (ViewGroup) mInflater.inflate(R.layout.list_item_non_prime, parent, false);
                MyViewHolder_NOT_PRIME holderNonPrime = new MyViewHolder_NOT_PRIME(nonPrimeRow);
                return holderNonPrime;
        }
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
//        Log.i(TAG, "onBindViewHolder " + position);

        Landscape currentObj = mData.get(position);

        switch (holder.getItemViewType()) {
            case PRIME_ROW:
                MyViewHolder_PRIME holderPrime = (MyViewHolder_PRIME) holder;
                holderPrime.setData(currentObj);
                break;

            case NON_PRIME_ROW:
                MyViewHolder_NOT_PRIME holderNonPrime = (MyViewHolder_NOT_PRIME) holder;
                holderNonPrime.setData(currentObj);
                break;
        }
//        holder.setData(currentObj, position);
//        holder.setListeners();
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public int getItemViewType(int position) {
        Landscape landscape = mData.get(position);
        if (landscape.isPrime())
            return PRIME_ROW;
        else
            return NON_PRIME_ROW;
    }

    public void removeItem(int position) {
        mData.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, mData.size());
    }

    public void addItem(int position, Landscape landscape) {
        mData.add(position, landscape);
        notifyItemInserted(position);
        notifyItemRangeChanged(position, mData.size());
    }

    class MyViewHolder extends RecyclerView.ViewHolder /*implements View.OnClickListener*/ {
//        TextView title;
//        ImageView imgThumb;
//        ImageView imgDelete, imdAdd;
//        int position;
//        Landscape current;

        public MyViewHolder(View itemView) {
            super(itemView);
//            title       = (TextView)  itemView.findViewById(R.id.tvTitle);
//            imgThumb    = (ImageView) itemView.findViewById(R.id.img_row);
//            imgDelete   = (ImageView) itemView.findViewById(R.id.img_row_delete);
//            imdAdd      = (ImageView) itemView.findViewById(R.id.img_row_add);

        }
//
//        public void setData(Landscape current, int position) {
//            this.title.setText(current.getTitle());
//            this.imgThumb.setImageResource(current.getImageID());
//            this.position = position;
//            this.current = current;
//        }
//
//        public void setListeners() {
//            imgDelete.setOnClickListener(MyViewHolder.this);
//            imdAdd.setOnClickListener(MyViewHolder.this);
//        }
//
//        @Override
//        public void onClick(View v) {
//            Log.i(TAG, "onClick before operation at position: " + position + "   Size: " + mData.size());
//            switch (v.getId()) {
//                case R.id.img_row_delete:
//                    removeItem(position);
//                    break;
//                case R.id.img_row_add:
//                    addItem(position, current);
//                    break;
//                default:
//                    break;
//            }
//            Log.i(TAG, "onClick after operation - Size: " + mData.size()); // + "\n\n" + mData.toString());
//        }
    }

    public class MyViewHolder_PRIME extends MyViewHolder {
        TextView title;
        ImageView imgThumb, imgRowType;

        public MyViewHolder_PRIME(View itemView) {
            super(itemView);
            title       = (TextView)  itemView.findViewById(R.id.tvTitle);
            imgThumb    = (ImageView) itemView.findViewById(R.id.img_row);
            imgRowType  = (ImageView) itemView.findViewById(R.id.img_row_prime);
        }

        public void setData(Landscape current) {
            this.title.setText(current.getTitle());
            this.imgThumb.setImageResource(current.getImageID());
            this.imgRowType.setImageResource(R.drawable.ic_prime);
        }
    }

    public class MyViewHolder_NOT_PRIME extends MyViewHolder {
        TextView title;
        ImageView imgThumb, imgRowType;

        public MyViewHolder_NOT_PRIME(View itemView) {
            super(itemView);
            title       = (TextView)  itemView.findViewById(R.id.tvTitle);
            imgThumb    = (ImageView) itemView.findViewById(R.id.img_row);
            imgRowType  = (ImageView) itemView.findViewById(R.id.img_row_not_prime);
        }

        public void setData(Landscape current) {
            this.title.setText(current.getTitle());
            this.imgThumb.setImageResource(current.getImageID());
            this.imgRowType.setImageResource(R.drawable.ic_not_prime);
        }
    }


}
