package com.example.areageometric;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Spinner sp_shapes;
    private EditText rectangle_width, rectangle_height,cirle_radius,triangle_base,triangle_height;
    private TextView view_calcualat;
    private Button btn_calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp_shapes = findViewById(R.id.areas_shapes);
        rectangle_width = findViewById(R.id.areas_ractangle_width);
        rectangle_height = findViewById(R.id.areas_ractangle_Height);
        triangle_base = findViewById(R.id.areas_triangle_base);
        triangle_height = findViewById(R.id.areas_triangle_Height);
        cirle_radius = findViewById(R.id.circle_radius);
        view_calcualat = findViewById(R.id.view_calcualat);
        btn_calculate = findViewById(R.id.btn_calculate);

        sp_shapes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i){
                    case 0:
                        //spiner select
                        rectangle_height.setVisibility(view.GONE);
                        rectangle_width.setVisibility(view.GONE);
                        triangle_base.setVisibility(view.GONE);
                        triangle_height.setVisibility(view.GONE);
                        cirle_radius.setVisibility(view.GONE);
                        break;
                    case 1:
                    // rectangle
                    rectangle_height.setVisibility(view.VISIBLE);
                    rectangle_width.setVisibility(view.VISIBLE);
                    triangle_base.setVisibility(view.GONE);
                    triangle_height.setVisibility(view.GONE);
                        cirle_radius.setVisibility(view.GONE);
                    break;
                    case 2:
                        //cirle
                        rectangle_height.setVisibility(view.GONE);
                        rectangle_width.setVisibility(view.GONE);
                        triangle_base.setVisibility(view.GONE);
                        triangle_height.setVisibility(view.GONE);
                        cirle_radius.setVisibility(view.VISIBLE);
                        break;
                    case 3:
                        //triangle
                        rectangle_height.setVisibility(view.GONE);
                        rectangle_width.setVisibility(view.GONE);
                        triangle_base.setVisibility(view.VISIBLE);
                        triangle_height.setVisibility(view.VISIBLE);
                        cirle_radius.setVisibility(view.GONE);
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int index = sp_shapes.getSelectedItemPosition();
                double area = 0;

                switch (index){
                    case 1:
                        //rectangle
                        double rect_width = Double.parseDouble(rectangle_width.getText().toString());
                        double rect_height = Double.parseDouble(rectangle_height.getText().toString());
                        area = rect_width * rect_height;
                        break;
                    case 2:
                        //circle
                        double circ_radius = Double.parseDouble(cirle_radius.getText().toString());
                        area = Math.PI * Math.pow(circ_radius,2);
                        break;
                    case 3:
                        //triangle
                        double tri_base = Double.parseDouble(rectangle_width.getText().toString());
                        double tri_height = Double.parseDouble(rectangle_height.getText().toString());
                        area = tri_base * 0.5 * tri_height;
                        break;

                }
                view_calcualat.setText(area+"");
            }
        });

    }
}