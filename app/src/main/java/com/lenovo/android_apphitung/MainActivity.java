package com.lenovo.android_apphitung;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText ed_sisi;
    Button btn;
    TextView hasil;
    Spinner spinnerPilihan;
    String[] pilihanHitung = {"Volume", "Keliling", "Luas Permukaan"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed_sisi = findViewById(R.id.ed_sisi);
        btn = findViewById(R.id.btn);
        hasil = findViewById(R.id.hasil);
        spinnerPilihan = findViewById(R.id.spinnerPilihan);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (spinnerPilihan.getSelectedItem(). toString().equals(pilihanHitung[0])) {
                    //rumusvolume
                    rumusvolume();
                    //ctrl+alt+m
                } else if (spinnerPilihan.getSelectedItem().toString().equals(pilihanHitung[1])) {
                    //rumuskeliling
                    Double sisi = Double.valueOf(ed_sisi.getText().toString());
                    rumusKeliling(sisi);
                } else if (spinnerPilihan.getSelectedItem().toString().equals(pilihanHitung[2])) {
                    //rumusluaspermukaan
                    Double sisi = Double.valueOf(ed_sisi.getText().toString());
                    Double hasill = rumusLuasPermukaan();
                    hasil.setText(hasill.toString());
                }
            }
        });

        //data
        //adapter
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, pilihanHitung);
        spinnerPilihan.setAdapter(adapter);
    }

    private Double rumusLuasPermukaan() {
        Double sisi = Double.valueOf(ed_sisi.getText().toString());
        Double hasill = 12 * sisi;
        return hasill;
    }

    private void rumusKeliling(Double sisi) {
        Double hasill = 6 * sisi * sisi;
        hasil.setText(hasill.toString());
    }

    private void rumusvolume() {
        Double sisi = Double.valueOf(ed_sisi.getText().toString());
        Double hasill = sisi * sisi * sisi;
        hasil.setText(hasill.toString());
    }
}
