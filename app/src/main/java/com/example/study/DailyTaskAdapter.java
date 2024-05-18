package com.example.study;// DailyTaskAdapter.java
import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class DailyTaskAdapter extends RecyclerView.Adapter<DailyTaskAdapter.DailyTaskViewHolder> {
    private List<DailyTask> dailyTaskList;
    private Context context;

    public DailyTaskAdapter(Context context, List<DailyTask> dailyTaskList) {
        this.context = context;
        this.dailyTaskList = dailyTaskList;
    }

    @NonNull
    @Override
    public DailyTaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_daily_routine, parent, false);
        return new DailyTaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DailyTaskViewHolder holder, int position) {
        DailyTask dailyTask = dailyTaskList.get(position);
        holder.textViewTaskName.setText(dailyTask.getName());
        holder.editTextTaskNotes.setText(dailyTask.getNotes());
        holder.checkBoxTaskCompleted.setChecked(dailyTask.isCompleted());

        // Update the task's notes when the EditText changes
        holder.editTextTaskNotes.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                dailyTask.setNotes(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        // Update the task's completed status when the CheckBox is checked/unchecked
        holder.checkBoxTaskCompleted.setOnCheckedChangeListener((buttonView, isChecked) -> {
            dailyTask.setCompleted(isChecked);
        });

        // Set click listener to open ShowTaskActivity
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ShowTaskActivity.class);
            intent.putExtra("taskName", dailyTask.getName());
            intent.putExtra("taskNotes", dailyTask.getNotes());
            intent.putExtra("taskCompleted", dailyTask.isCompleted());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return dailyTaskList.size();
    }

    static class DailyTaskViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTaskName;
        EditText editTextTaskNotes;
        CheckBox checkBoxTaskCompleted;

        public DailyTaskViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTaskName = itemView.findViewById(R.id.textViewTaskName);
            editTextTaskNotes = itemView.findViewById(R.id.editTextTaskNotes);
            checkBoxTaskCompleted = itemView.findViewById(R.id.checkBoxTaskCompleted);
        }
    }
}
