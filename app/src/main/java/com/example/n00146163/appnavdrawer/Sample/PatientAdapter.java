package com.example.n00146163.appnavdrawer.Sample;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.n00146163.appnavdrawer.Model.Patient;
import com.example.n00146163.appnavdrawer.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by n00146163 on 21/11/2017.
 */

public class PatientAdapter extends RecyclerView.Adapter<PatientAdapter.ViewHolder> {

    private List<Patient> mItems;
    private Context mContext;
    public PatientAdapter(Context context, List<Patient> items) {
        this.mContext = context;
        this.mItems = items;
    }



    @Override
    public PatientAdapter.ViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);

        View itemView = inflater.inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);

        Log.d("log", "patient adapter");

        return viewHolder;
    }
    public void onBindViewHolder(PatientAdapter.ViewHolder holder, int position) {

        // mItems is the array list of dogs, position is the current position required
        // get method returns the complete Dog object
        final Patient item = mItems.get(position);

        Log.d("log", "patient adapter bindVH");

        try {
            holder.tvName.setText(item.getName());
//            String imageFile = item.getPhoto();
//            InputStream inputStream = mContext.getAssets().open(imageFile);
//            Drawable d = Drawable.createFromStream(inputStream, null);
//            holder.imageView.setImageDrawable(d);
        } catch (Exception e) {
            e.printStackTrace();
        }

// if the user clicks this ViewHolder do something – this will eventually
// open up a new activity to allow the user to edit this Item in the list.
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "You selected " + item.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvName;
        public ImageView imageView;
        public View mView;

        public ViewHolder(View itemView) {
            super(itemView);

            tvName = (TextView) itemView.findViewById(R.id.itemNameText);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            mView = itemView;
        }
    }
}
