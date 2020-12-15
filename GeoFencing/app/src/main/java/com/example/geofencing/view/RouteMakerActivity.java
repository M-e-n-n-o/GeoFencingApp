package com.example.geofencing.view;

import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import com.example.geofencing.R;
import com.example.geofencing.view_model.FitHandler;

public class RouteMakerActivity extends AppCompatActivity {

    private FitHandler fitHandler;

    private EditText cityEdit;
    private EditText streetEdit;
    private EditText numberEdit;
    private SwitchCompat lapSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_maker);

        this.cityEdit = findViewById(R.id.edit_plaats);
        this.streetEdit = findViewById(R.id.edit_straat);
        this.numberEdit = findViewById(R.id.edit_nummer);
        this.lapSwitch = findViewById(R.id.switch_make_lap);

        this.fitHandler = FitHandler.getInstance();
    }

    public void startRouteClicked(View view) {
        //TODO vind een route naar de opgegeven plek

        String city = this.cityEdit.getText().toString();
        String street = this.streetEdit.getText().toString();
        String number = this.numberEdit.getText().toString();
        boolean makeLap = this.lapSwitch.isChecked();

        this.fitHandler.findQuickestPathTo(city, street, number, makeLap);
    }
}