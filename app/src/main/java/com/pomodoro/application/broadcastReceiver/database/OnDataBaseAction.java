package com.pomodoro.application.broadcastReceiver.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.pomodoro.application.model.Task;

import java.util.List;

@Dao
public interface OnDataBaseAction {

    @Query("SELECT * FROM Task")
    List<Task> getAllTasksList();

    @Query("DELETE FROM Task")
    void truncateTheList();

    @Insert
    void insertDataIntoTaskList(Task task);

    @Query("DELETE FROM Task WHERE taskId = :taskId")
    void deleteTaskFromId(int taskId);

    @Query("SELECT * FROM Task WHERE taskId = :taskId")
    Task selectDataFromAnId(int taskId);

    @Query("UPDATE Task SET taskTitle = :taskTitle, taskDescription = :taskDescription, date = :taskDate WHERE taskId = :taskId")
    void updateAnExistingRow(int taskId, String taskTitle, String taskDescription, String taskDate);

}
