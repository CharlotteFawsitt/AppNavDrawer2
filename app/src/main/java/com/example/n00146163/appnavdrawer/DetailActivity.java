//package com.example.n00146163.appnavdrawer;
//
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.widget.Toast;
//
//import com.example.n00146163.appnavdrawer.Model.Patient;
//import com.example.n00146163.appnavdrawer.PatientAdapter;
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
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.n00146163.appnavdrawer.Model.Patient;
import com.example.n00146163.appnavdrawer.database.DataSource;

import java.io.InputStream;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView tvPatientName, tvGender, tvAge;
    ImageView itemImage;
    private String pid, image;
    private Patient patient;
    private static final int SELECT_PICTURE = 100;
    private static final String TAG = "DetailActivity";


    DataSource mDataSource;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        mDataSource = new DataSource(this);
        mDataSource.open();
        Intent getIntent = getIntent();
        findViewById(R.id.btnSelectImage).setOnClickListener(this);

        pid = getIntent.getStringExtra("id");
        patient = getIntent().getExtras().getParcelable(PatientAdapter.PATIENT_KEY);
        if (patient == null) {
            throw new AssertionError("Null data item received!");
        }

        tvPatientName = (TextView) findViewById(R.id.tvPatientName);
        tvAge = (TextView) findViewById(R.id.tvAge);
        tvGender = (TextView) findViewById(R.id.tvGender);
        itemImage = (ImageView) findViewById(R.id.Image);

        tvPatientName.setText(patient.getName());
        tvGender.setText(patient.getGender());
        tvAge.setText(patient.getPhoneNumber());
        InputStream inputStream = null;
        try {
            String imageFile = patient.getPhoto();
            Log.i("TEST", "PATH " + imageFile);
            inputStream = getAssets().open(imageFile);
            Drawable d = Drawable.createFromStream(inputStream, null);
            itemImage.setImageDrawable(d);
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

    /* Choose an image from Gallery */
    void openImageChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_PICTURE);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {
                // Get the url from data
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    // Get the path from the Uri
                    String path = getPathFromURI(selectedImageUri);

                    image = selectedImageUri.toString();
                    Log.i(TAG, "Image Path : " + image);
                    // Set the image in ImageView
                    ((ImageView) findViewById(R.id.Image)).setImageURI(selectedImageUri);
                }
            }
        }
    }

    /* Get the real path from the URI */
    public String getPathFromURI(Uri contentUri) {
        String res = null;
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(contentUri, proj, null, null, null);
        if (cursor.moveToFirst()) {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            res = cursor.getString(column_index);
        }
        cursor.close();
        return res;
    }

    @Override
    public void onClick(View v) {
        openImageChooser();
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
            finish();
        }
        else{
            onBackPressed();
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


