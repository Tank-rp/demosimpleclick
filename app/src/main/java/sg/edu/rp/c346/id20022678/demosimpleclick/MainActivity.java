package sg.edu.rp.c346.id20022678.demosimpleclick;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    //Step 1 : Declare the field variables
    TextView tvDisplay;
    Button btnDisplay;
    EditText etInput;
    ToggleButton tbtn;
    RadioGroup rgGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Step 2: Link the field variable to UI components in layout
        tvDisplay = findViewById(R.id.textViewDisplay);
        btnDisplay = findViewById(R.id.buttonDisplay);
        etInput = findViewById(R.id.editTextInput);
        tbtn = findViewById(R.id.toggleButtonEnabled);
        rgGender = findViewById(R.id.RadioGroupGender);

        btnDisplay.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                String stringResponse = etInput.getText().toString();
                tvDisplay.setText(stringResponse);
            }
        });

        tbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tbtn.isChecked() == true){
                    etInput.setEnabled(false);
                    tvDisplay.setEnabled(false);
                }
                else {
                    etInput.setEnabled(true);
                    tvDisplay.setEnabled(true);
                }
            }
        });

        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringResponse = etInput.getText().toString();
                int checkRadioId = rgGender.getCheckedRadioButtonId();
                if(checkRadioId == R.id.radioButtonGenderMale) {
                    stringResponse = "He says " + stringResponse;
                }
                else {
                    stringResponse = "She says " + stringResponse;
                }
                tvDisplay.setText(stringResponse);
            }
        });
    }
}