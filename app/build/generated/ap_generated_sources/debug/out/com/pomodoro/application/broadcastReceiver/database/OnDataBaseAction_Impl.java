package com.pomodoro.application.broadcastReceiver.database;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.pomodoro.application.model.Task;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class OnDataBaseAction_Impl implements OnDataBaseAction {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Task> __insertionAdapterOfTask;

  private final SharedSQLiteStatement __preparedStmtOfTruncateTheList;

  private final SharedSQLiteStatement __preparedStmtOfDeleteTaskFromId;

  private final SharedSQLiteStatement __preparedStmtOfUpdateAnExistingRow;

  public OnDataBaseAction_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTask = new EntityInsertionAdapter<Task>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Task` (`taskId`,`taskTitle`,`date`,`taskDescription`,`isComplete`,`firstAlarmTime`,`secondAlarmTime`,`lastAlarm`,`event`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Task value) {
        stmt.bindLong(1, value.getTaskId());
        if (value.getTaskTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTaskTitle());
        }
        if (value.getDate() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDate());
        }
        if (value.getTaskDescrption() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTaskDescrption());
        }
        final int _tmp;
        _tmp = value.isComplete() ? 1 : 0;
        stmt.bindLong(5, _tmp);
        if (value.getFirstAlarmTime() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getFirstAlarmTime());
        }
        if (value.getSecondAlarmTime() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getSecondAlarmTime());
        }
        if (value.getLastAlarm() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getLastAlarm());
        }
        if (value.getEvent() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getEvent());
        }
      }
    };
    this.__preparedStmtOfTruncateTheList = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Task";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteTaskFromId = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Task WHERE taskId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateAnExistingRow = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Task SET taskTitle = ?, taskDescription = ?, date = ? WHERE taskId = ?";
        return _query;
      }
    };
  }

  @Override
  public void insertDataIntoTaskList(final Task task) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfTask.insert(task);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void truncateTheList() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfTruncateTheList.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfTruncateTheList.release(_stmt);
    }
  }

  @Override
  public void deleteTaskFromId(final int taskId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteTaskFromId.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, taskId);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteTaskFromId.release(_stmt);
    }
  }

  @Override
  public void updateAnExistingRow(final int taskId, final String taskTitle,
      final String taskDescription, final String taskDate) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateAnExistingRow.acquire();
    int _argIndex = 1;
    if (taskTitle == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, taskTitle);
    }
    _argIndex = 2;
    if (taskDescription == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, taskDescription);
    }
    _argIndex = 3;
    if (taskDate == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, taskDate);
    }
    _argIndex = 4;
    _stmt.bindLong(_argIndex, taskId);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateAnExistingRow.release(_stmt);
    }
  }

  @Override
  public List<Task> getAllTasksList() {
    final String _sql = "SELECT * FROM Task";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTaskId = CursorUtil.getColumnIndexOrThrow(_cursor, "taskId");
      final int _cursorIndexOfTaskTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "taskTitle");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
      final int _cursorIndexOfTaskDescrption = CursorUtil.getColumnIndexOrThrow(_cursor, "taskDescription");
      final int _cursorIndexOfIsComplete = CursorUtil.getColumnIndexOrThrow(_cursor, "isComplete");
      final int _cursorIndexOfFirstAlarmTime = CursorUtil.getColumnIndexOrThrow(_cursor, "firstAlarmTime");
      final int _cursorIndexOfSecondAlarmTime = CursorUtil.getColumnIndexOrThrow(_cursor, "secondAlarmTime");
      final int _cursorIndexOfLastAlarm = CursorUtil.getColumnIndexOrThrow(_cursor, "lastAlarm");
      final int _cursorIndexOfEvent = CursorUtil.getColumnIndexOrThrow(_cursor, "event");
      final List<Task> _result = new ArrayList<Task>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Task _item;
        _item = new Task();
        final int _tmpTaskId;
        _tmpTaskId = _cursor.getInt(_cursorIndexOfTaskId);
        _item.setTaskId(_tmpTaskId);
        final String _tmpTaskTitle;
        _tmpTaskTitle = _cursor.getString(_cursorIndexOfTaskTitle);
        _item.setTaskTitle(_tmpTaskTitle);
        final String _tmpDate;
        _tmpDate = _cursor.getString(_cursorIndexOfDate);
        _item.setDate(_tmpDate);
        final String _tmpTaskDescrption;
        _tmpTaskDescrption = _cursor.getString(_cursorIndexOfTaskDescrption);
        _item.setTaskDescrption(_tmpTaskDescrption);
        final boolean _tmpIsComplete;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsComplete);
        _tmpIsComplete = _tmp != 0;
        _item.setComplete(_tmpIsComplete);
        final String _tmpFirstAlarmTime;
        _tmpFirstAlarmTime = _cursor.getString(_cursorIndexOfFirstAlarmTime);
        _item.setFirstAlarmTime(_tmpFirstAlarmTime);
        final String _tmpSecondAlarmTime;
        _tmpSecondAlarmTime = _cursor.getString(_cursorIndexOfSecondAlarmTime);
        _item.setSecondAlarmTime(_tmpSecondAlarmTime);
        final String _tmpLastAlarm;
        _tmpLastAlarm = _cursor.getString(_cursorIndexOfLastAlarm);
        _item.setLastAlarm(_tmpLastAlarm);
        final String _tmpEvent;
        _tmpEvent = _cursor.getString(_cursorIndexOfEvent);
        _item.setEvent(_tmpEvent);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Task selectDataFromAnId(final int taskId) {
    final String _sql = "SELECT * FROM Task WHERE taskId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, taskId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTaskId = CursorUtil.getColumnIndexOrThrow(_cursor, "taskId");
      final int _cursorIndexOfTaskTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "taskTitle");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
      final int _cursorIndexOfTaskDescrption = CursorUtil.getColumnIndexOrThrow(_cursor, "taskDescription");
      final int _cursorIndexOfIsComplete = CursorUtil.getColumnIndexOrThrow(_cursor, "isComplete");
      final int _cursorIndexOfFirstAlarmTime = CursorUtil.getColumnIndexOrThrow(_cursor, "firstAlarmTime");
      final int _cursorIndexOfSecondAlarmTime = CursorUtil.getColumnIndexOrThrow(_cursor, "secondAlarmTime");
      final int _cursorIndexOfLastAlarm = CursorUtil.getColumnIndexOrThrow(_cursor, "lastAlarm");
      final int _cursorIndexOfEvent = CursorUtil.getColumnIndexOrThrow(_cursor, "event");
      final Task _result;
      if(_cursor.moveToFirst()) {
        _result = new Task();
        final int _tmpTaskId;
        _tmpTaskId = _cursor.getInt(_cursorIndexOfTaskId);
        _result.setTaskId(_tmpTaskId);
        final String _tmpTaskTitle;
        _tmpTaskTitle = _cursor.getString(_cursorIndexOfTaskTitle);
        _result.setTaskTitle(_tmpTaskTitle);
        final String _tmpDate;
        _tmpDate = _cursor.getString(_cursorIndexOfDate);
        _result.setDate(_tmpDate);
        final String _tmpTaskDescrption;
        _tmpTaskDescrption = _cursor.getString(_cursorIndexOfTaskDescrption);
        _result.setTaskDescrption(_tmpTaskDescrption);
        final boolean _tmpIsComplete;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsComplete);
        _tmpIsComplete = _tmp != 0;
        _result.setComplete(_tmpIsComplete);
        final String _tmpFirstAlarmTime;
        _tmpFirstAlarmTime = _cursor.getString(_cursorIndexOfFirstAlarmTime);
        _result.setFirstAlarmTime(_tmpFirstAlarmTime);
        final String _tmpSecondAlarmTime;
        _tmpSecondAlarmTime = _cursor.getString(_cursorIndexOfSecondAlarmTime);
        _result.setSecondAlarmTime(_tmpSecondAlarmTime);
        final String _tmpLastAlarm;
        _tmpLastAlarm = _cursor.getString(_cursorIndexOfLastAlarm);
        _result.setLastAlarm(_tmpLastAlarm);
        final String _tmpEvent;
        _tmpEvent = _cursor.getString(_cursorIndexOfEvent);
        _result.setEvent(_tmpEvent);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
