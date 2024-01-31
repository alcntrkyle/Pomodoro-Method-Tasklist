// Generated code from Butter Knife. Do not modify!
package com.pomodoro.application.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.pomodoro.application.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TaskAdapter$TaskViewHolder_ViewBinding implements Unbinder {
  private TaskAdapter.TaskViewHolder target;

  @UiThread
  public TaskAdapter$TaskViewHolder_ViewBinding(TaskAdapter.TaskViewHolder target, View source) {
    this.target = target;

    target.day = Utils.findRequiredViewAsType(source, R.id.day, "field 'day'", TextView.class);
    target.date = Utils.findRequiredViewAsType(source, R.id.date, "field 'date'", TextView.class);
    target.month = Utils.findRequiredViewAsType(source, R.id.month, "field 'month'", TextView.class);
    target.title = Utils.findRequiredViewAsType(source, R.id.title, "field 'title'", TextView.class);
    target.description = Utils.findRequiredViewAsType(source, R.id.description, "field 'description'", TextView.class);
    target.status = Utils.findRequiredViewAsType(source, R.id.status, "field 'status'", TextView.class);
    target.options = Utils.findRequiredViewAsType(source, R.id.options, "field 'options'", ImageView.class);
    target.time = Utils.findRequiredViewAsType(source, R.id.time, "field 'time'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    TaskAdapter.TaskViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.day = null;
    target.date = null;
    target.month = null;
    target.title = null;
    target.description = null;
    target.status = null;
    target.options = null;
    target.time = null;
  }
}
