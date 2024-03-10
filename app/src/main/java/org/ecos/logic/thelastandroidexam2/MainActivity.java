package org.ecos.logic.thelastandroidexam2;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final int INSERT = 1;
    private static final int UPDATE = 2;
    public static final String OLD_NAME = "oldName";
    public static final String OLD_AGE = "oldAge";
    ActivityResultLauncher<Intent> launcher = null;

    protected final List<Personaje> theSimpsons = PersonajeCollection.getDatos();
    private RecyclerView recyclerView;
    private SimpsonAdapter simpsonAdapter;
    private int actionKind;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.simpsonAdapter = new SimpsonAdapter(theSimpsons);
        this.recyclerView = this.findViewById(R.id.simpson_recycler_view);
        this.recyclerView.setAdapter(simpsonAdapter);
        this.recyclerView.setLayoutManager(new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false));
        this.launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult activityResult) {
                if (activityResult.getResultCode()==RESULT_OK){
                    if(MainActivity.this.actionKind==INSERT) {
                        Intent data = activityResult.getData();
                        String nombre = data.getStringExtra(AddOrEdit.NAME_CHANGE);
                        int edad = 0;
                        try {
                            edad = Integer.parseInt(data.getStringExtra(AddOrEdit.AGE_CHANGE));
                        } catch (NumberFormatException e) {
                            edad = 0;
                        }

                        MainActivity.this.theSimpsons.add(new Personaje(100, nombre, nombre, edad, "", "", "", R.drawable.sinimagen));
                        MainActivity.this.simpsonAdapter.notifyDataSetChanged();
                    } else if (actionKind==UPDATE) {
                        Intent data = activityResult.getData();
                        String nombre = data.getStringExtra(AddOrEdit.NAME_CHANGE);
                        int edad = 0;
                        try {
                            edad = Integer.parseInt(data.getStringExtra(AddOrEdit.AGE_CHANGE));
                        } catch (NumberFormatException e) {
                            edad = 0;
                        }
                        MainActivity.this.theSimpsons.get(MainActivity.this.position).setNombre(nombre);
                        MainActivity.this.theSimpsons.get(MainActivity.this.position).setEdad(edad);

                        MainActivity.this.simpsonAdapter.notifyItemChanged(MainActivity.this.position);

                    }
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        menu.add("easter egg :3");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        this.position = simpsonAdapter.getSelectedPos();
        ActionBar actionBar = getSupportActionBar();

        if (position >= 0){
            int itemId = item.getItemId();
            if (itemId == R.id.menu_add) {
                MainActivity.this.actionKind = INSERT;
                Intent intent = new Intent(MainActivity.this.getApplicationContext(), AddOrEdit.class);
                launcher.launch(intent);
            } else if (itemId == R.id.menu_edit) {
                MainActivity.this.actionKind = UPDATE;
                Intent intent = new Intent(MainActivity.this.getApplicationContext(), AddOrEdit.class);
                Personaje personaje = theSimpsons.get(position);
                intent.putExtra(OLD_NAME, personaje.getNombre());
                intent.putExtra(OLD_AGE, personaje.getEdad()+"");
                launcher.launch(intent);
            } else if (itemId == R.id.menu_delete) {
                Log.i("COMPILE", "hello there");
            }
        }
        return super.onOptionsItemSelected(item);
    }
}