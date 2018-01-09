//package com.example.n00146163.appnavdrawer;
//
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.widget.Toast;
//
//import com.example.n00146163.appnavdrawer.Model.Patient;
//import com.example.n00146163.appnavdrawer.Sample.PatientAdapter;
//import com.example.n00146163.appnavdrawer.Sample.SampleDataProvider;
//
//public class DetailActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_detail);
//
////        String patientId = getIntent().getExtras().getString(PatientAdapter.PATIENT_ID_KEY);
////        Patient patient = SampleDataProvider.patientMap.get(patientId);
//        Patient patient = getIntent().getExtras().getParcelable(PatientAdapter.PATIENT_KEY);
//        if (patient != null) {
//            Toast.makeText(this, "Received patient " + patient.getName(), Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(this, "Didn't receive any data", Toast.LENGTH_SHORT).show();
//        }
//
//    }
//}

package com.example.n00146163.appnavdrawer;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.n00146163.appnavdrawer.Model.Patient;
import com.example.n00146163.appnavdrawer.Sample.PatientAdapter;
import com.example.n00146163.appnavdrawer.Sample.SampleDataProvider;
import com.example.n00146163.appnavdrawer.database.DataSource;

import java.io.InputStream;
import java.text.NumberFormat;
import java.util.Locale;

public class DetailActivity extends AppCompatActivity {

    private TextView tvPatientName, tvGender, tvAge;
    private ImageView itemImage;
    private String pid;
    private Patient patient;

    DataSource mDataSource;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        mDataSource = new DataSource(this);
        mDataSource.open();
        Intent getIntent = getIntent();

        pid = getIntent.getStringExtra("id");
        patient = getIntent().getExtras().getParcelable(PatientAdapter.PATIENT_KEY);
        if (patient == null) {
            throw new AssertionError("Null data item received!");
        }

        tvPatientName = (TextView) findViewById(R.id.tvPatientName);
        tvAge = (TextView) findViewById(R.id.tvAge);
        tvGender = (TextView) findViewById(R.id.tvGender);
        //itemImage = (ImageView) findViewById(R.id.itemImage);

        tvPatientName.setText(patient.getName());
        tvGender.setText(patient.getGender());
        tvAge.setText(patient.getPhoneNumber());
        InputStream inputStream = null;
        try {
//            String imageFile = patient.getPhoto();
//            inputStream = getAssets().open(imageFile);
//            Drawable d = Drawable.createFromStream(inputStream, null);
//            itemImage.setImageDrawable(d);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.patient_delete_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.delete) {
            Intent intent = new Intent(this, DeleteActivity.class);
            intent.putExtra(PatientAdapter.PATIENT_KEY, patient);
            startActivity(intent);
        }
        return true;
    }
    @Override
    protected void onPause() {
        super.onPause();

        Patient patient = getIntent().getExtras().getParcelable(PatientAdapter.PATIENT_KEY);
        // get the content from the TextViews and re-set the values of the dog object.
        // I have intentionally just done one field here, you can update more.
        patient.setName(tvPatientName.getText().toString());


        mDataSource = new DataSource(this);
        mDataSource.open();
        int result = mDataSource.updatePatient(patient);

    }


}


