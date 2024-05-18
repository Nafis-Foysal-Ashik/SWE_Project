package com.example.study;// ShowTaskActivity.java
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

        // Get the data from the intent
        List<DailyTask> taskList = getIntent().getParcelableArrayListExtra("taskList");

        if (taskList != null) {
            for (DailyTask task : taskList) {
                addTaskToView(task);
            }
        }
    }

    private void addTaskToView(DailyTask task) {
        TextView taskView = new TextView(this);
        taskView.setText(task.getName() + (task.isCompleted() ? " (Completed)" : ""));
        taskView.setTextSize(18);
        taskView.setPadding(0, 8, 0, 8);
        taskContainer.addView(taskView);
    }
}
