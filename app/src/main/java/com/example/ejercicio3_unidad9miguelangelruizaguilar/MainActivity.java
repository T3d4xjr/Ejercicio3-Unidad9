package com.example.ejercicio3_unidad9miguelangelruizaguilar;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Conexión de elementos del diseño
        EditText reminderInput = findViewById(R.id.reminderInput);
        Spinner categorySpinner = findViewById(R.id.categorySpinner);
        Button setReminderButton = findViewById(R.id.setReminderButton);

        // Configurar Spinner con adaptador
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.categories, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(adapter);

        // Acción del botón
        setReminderButton.setOnClickListener(view -> {
            String reminderText = reminderInput.getText().toString();
            String selectedCategory = categorySpinner.getSelectedItem().toString();

            if (!reminderText.isEmpty()) {
                Toast.makeText(this, "Recordatorio: " + reminderText +
                        "\nCategoría: " + selectedCategory, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Por favor, completa el recordatorio.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
