package org.ecos.logic.thelastandroidexam2;

import static org.ecos.logic.thelastandroidexam2.MainActivity.OLD_AGE;
import static org.ecos.logic.thelastandroidexam2.MainActivity.OLD_NAME;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddOrEdit extends AppCompatActivity {

    public static final String NAME_CHANGE = "nameChange";
    public static final String AGE_CHANGE = "ageChange";
    private EditText nameChange;
    private EditText ageChange;
    private Button saveChanges;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_or_edit);

        nameChange = findViewById(R.id.age_change_view);
        ageChange = findViewById(R.id.name_change_view);

        Intent intent1 = getIntent();
        if(intent1 !=null) {
            nameChange.setText( intent1.getStringExtra(OLD_NAME));
            ageChange.setText( intent1.getStringExtra(OLD_AGE)+"");
        }


        saveChanges = findViewById(R.id.save_button);
        saveChanges.setOnClickListener(v -> {
            Intent intent = new Intent();

            intent.putExtra(NAME_CHANGE, nameChange.getText().toString());
            intent.putExtra(AGE_CHANGE, ageChange.getText().toString());
            setResult(RESULT_OK, intent);
            finish();
        });
    }
}