package sg.edu.rp.c346.dynamicspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    Spinner spn1;
    Spinner spn2;
    Button btnUpdate;
    Spinner spnYesNo;

    ArrayList<String>alNumbers;
    ArrayAdapter<String>aaNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spn1 = findViewById(R.id.spinner1);
        spn2 = findViewById(R.id.spinner2);
        btnUpdate = findViewById(R.id.buttonUpdate);

        //initialise the ArrayList
        alNumbers = new ArrayList<>();

        //alNumbers.add("2");
        // alNumbers.add("4");
        //alNumbers.add("6");

        //Get string-array and store as an Array
        String[] strNumbers = getResources().getStringArray(R.array.even_numbers);

        //Convert Array to List and add to the ArrayList

        alNumbers.addAll(Arrays.asList(strNumbers));


        //create an ArrayList using the default spinner layout anf the ArrayList

        aaNumbers = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, alNumbers);

        //Bind the ArrayAdapter to the Spinner
        spn2.setAdapter((aaNumbers));

        //Implement the button onCLick() method
        // to load the correct number list when it is click

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = spn1.getSelectedItemPosition();
                alNumbers.clear();

                if (pos == 0) {
                    String[] strNumbers = getResources().getStringArray(R.array.even_numbers);
                    alNumbers.addAll(Arrays.asList(strNumbers));
                    aaNumbers.notifyDataSetChanged();


                } else {
                    String[] strNumbers = getResources().getStringArray(R.array.odd_numbers);
                    alNumbers.addAll(Arrays.asList(strNumbers));
                    aaNumbers.notifyDataSetChanged();
                }
            }
        });

            spnYesNo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                    switch(i){
                        case 0:
                            alNumbers.clear();
                            String[] strNumbers = getResources().getStringArray(R.array.even_numbers);
                            alNumbers.addAll(Arrays.asList(strNumbers));
                            aaNumbers.notifyDataSetChanged();


                            break;
                        case 1:
                            alNumbers.clear();
                            String[] strNumber = getResources().getStringArray(R.array.odd_numbers);
                            alNumbers.addAll(Arrays.asList(strNumber));
                            aaNumbers.notifyDataSetChanged();


                            break;
                    }

                }


                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        }

        }







