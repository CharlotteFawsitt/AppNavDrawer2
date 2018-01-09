package com.example.n00146163.appnavdrawer.Sample;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.n00146163.appnavdrawer.DetailActivity;
import com.example.n00146163.appnavdrawer.Model.Patient;
import com.example.n00146163.appnavdrawer.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static android.support.design.R.styleable.RecyclerView;

/**
 * Created by n00146163 on 21/11/2017.
 */

public class PatientAdapter extends RecyclerView.Adapter<PatientAdapter.ViewHolder> {

    public static final String PATIENT_ID_KEY = "patient_id_key";
    public static final String PATIENT_KEY = "patient_key" ;
    private String pid;
    private List<Patient> mPatients;
    private Context mContext;
    public PatientAdapter(Context context, List<Patient> patients) {
        this.mContext = context;
        this.mPatients = patients;
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
        final Patient patient = mPatients.get(position);

        pid = patient.getPatientId();
        Log.d("log", "patient adapter bindVH");

        try {
            holder.tvName.setText(patient.getName());
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

               // String patientId = patient.getPatientId();
                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.putExtra(PATIENT_KEY, patient);
                intent.putExtra(PATIENT_ID_KEY, patient);
                intent.putExtra("id", pid);
                mContext.startActivity(intent);
////                v.finish();
//                ((Activity)mContext).finish();
            }
        });

//        holder.mView.setOnLongClickListener(new View.OnLongClickListener(){
//            @Override
//            public boolean onLongClick(View view) {
//                Toast.makeText(mContext, "You held " + patient.getName(),
//                        Toast.LENGTH_SHORT).show();
//                return false;
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return mPatients.size();
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
