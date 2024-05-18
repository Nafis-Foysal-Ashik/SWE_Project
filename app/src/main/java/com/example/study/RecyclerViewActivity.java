package com.example.study;// RecyclerViewActivity.java
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DailyTaskAdapter dailyTaskAdapter;
    private List<DailyTask> dailyTaskList;
    private EditText editTextNewTask;
    private Button buttonAddTask;
    private Button buttonShowTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        editTextNewTask = findViewById(R.id.editTextNewTask);
        buttonAddTask = findViewById(R.id.buttonAddTask);
        buttonShowTasks = findViewById(R.id.buttonShowTasks);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize your data
        dailyTaskList = new ArrayList<>();
        dailyTaskList.add(new DailyTask("Wake up"));
        dailyTaskList.add(new DailyTask("Exercise"));
        dailyTaskList.add(new DailyTask("Breakfast"));
        dailyTaskList.add(new DailyTask("Study"));
        dailyTaskList.add(new DailyTask("Lunch"));
        dailyTaskList.add(new DailyTask("Work on Project"));
        dailyTaskList.add(new DailyTask("Dinner"));
        dailyTaskList.add(new DailyTask("Read a book"));
        dailyTaskList.add(new DailyTask("Sleep"));

        dailyTaskAdapter = new DailyTaskAdapter(this, dailyTaskList);
        recyclerView.setAdapter(dailyTaskAdapter);

        buttonAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taskName = editTextNewTask.getText().toString().trim();
                if (!TextUtils.isEmpty(taskName)) {
                    dailyTaskList.add(new DailyTask(taskName));
                    dailyTaskAdapter.notifyItemInserted(dailyTaskList.size() - 1);
                    editTextNewTask.setText("");
                    recyclerView.smoothScrollToPosition(dailyTaskList.size() - 1);
                }
            }
        });

        buttonShowTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclerViewActivity.this, ShowTaskActivity.class);
                intent.putParcelableArrayListExtra("taskList", new ArrayList<>(dailyTaskList));
                startActivity(intent);
            }
        });
    }
}
