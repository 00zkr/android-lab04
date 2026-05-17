package com.example.lab04;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText titleInput;
    private EditText descriptionInput;
    private Spinner prioritySpinner;
    private TextView counterText;
    private ArrayAdapter<String> taskAdapter;
    private final ArrayList<Task> tasks = new ArrayList<>();
    private final ArrayList<String> taskLabels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleInput = findViewById(R.id.input_title);
        descriptionInput = findViewById(R.id.input_description);
        prioritySpinner = findViewById(R.id.spinner_priority);
        counterText = findViewById(R.id.text_counter);
        Button addButton = findViewById(R.id.button_add);
        Button clearButton = findViewById(R.id.button_clear);
        ListView taskList = findViewById(R.id.list_tasks);

        ArrayAdapter<CharSequence> priorityAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.task_priorities,
                android.R.layout.simple_spinner_item
        );
        priorityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        prioritySpinner.setAdapter(priorityAdapter);

        taskAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, taskLabels);
        taskList.setAdapter(taskAdapter);

        addSampleTasks();
        refreshList();

        addButton.setOnClickListener(v -> addTask());
        clearButton.setOnClickListener(v -> clearInputs());

        taskList.setOnItemClickListener((parent, view, position, id) -> openDetails(position));
        taskList.setOnItemLongClickListener((parent, view, position, id) -> {
            Task removedTask = tasks.remove(position);
            refreshList();
            Toast.makeText(this, removedTask.title + " supprimee", Toast.LENGTH_SHORT).show();
            return true;
        });
    }

    private void addTask() {
        String title = titleInput.getText().toString().trim();
        String description = descriptionInput.getText().toString().trim();
        String priority = prioritySpinner.getSelectedItem().toString();

        if (title.isEmpty()) {
            Toast.makeText(this, "Le titre est obligatoire", Toast.LENGTH_SHORT).show();
            return;
        }

        tasks.add(new Task(title, description, priority));
        refreshList();
        clearInputs();
        Toast.makeText(this, "Tache ajoutee", Toast.LENGTH_SHORT).show();
    }

    private void clearInputs() {
        titleInput.setText("");
        descriptionInput.setText("");
        prioritySpinner.setSelection(0);
        titleInput.requestFocus();
    }

    private void openDetails(int position) {
        Task task = tasks.get(position);
        Intent intent = new Intent(MainActivity.this, Screen2Activity.class);
        intent.putExtra("title", task.title);
        intent.putExtra("description", task.description);
        intent.putExtra("priority", task.priority);
        startActivity(intent);
    }

    private void refreshList() {
        taskLabels.clear();
        for (Task task : tasks) {
            taskLabels.add(task.priority + " - " + task.title);
        }
        taskAdapter.notifyDataSetChanged();
        counterText.setText("Nombre de taches : " + tasks.size());
    }

    private void addSampleTasks() {
        tasks.add(new Task("Lire le cours", "Reviser les notions Activity, Intent et ListView.", "Moyenne"));
        tasks.add(new Task("Preparer le TP", "Tester l'application sur emulateur ou telephone.", "Haute"));
        tasks.add(new Task("Envoyer le travail", "Pousser le projet sur GitHub apres verification.", "Basse"));
    }

    private static class Task {
        final String title;
        final String description;
        final String priority;

        Task(String title, String description, String priority) {
            this.title = title;
            this.description = description;
            this.priority = priority;
        }
    }
}
