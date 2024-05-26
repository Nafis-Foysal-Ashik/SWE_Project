package com.example.study;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class ShowTaskActivity extends AppCompatActivity {
    private LinearLayout taskContainer;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_task);

        taskContainer = findViewById(R.id.taskContainer);

        List<DailyTask> taskList = getIntent().getParcelableArrayListExtra("taskList");

        if (taskList != null) {
            for (DailyTask task : taskList) {
                addTaskToView(task);
            }
        }
    }

    private void addTaskToView(DailyTask task) {
        TextView taskView = new TextView(this);
        String taskInfo = task.getName() + "\nTime: " + task.getNotes() + (task.isCompleted() ? " (Completed)" : "");
        taskView.setText(taskInfo);
        taskView.setTextSize(18);
        taskView.setPadding(250, 40, 0, 25);
        taskContainer.addView(taskView);
    }
}
