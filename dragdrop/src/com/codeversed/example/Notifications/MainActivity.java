package com.codeversed.example.Notifications;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.graphics.Matrix;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
 
public class MainActivity extends Activity implements OnTouchListener {
	  private final static int START_DRAGGING = 0;
	  private final static int STOP_DRAGGING = 1;

	  private Button btn;
	  private FrameLayout layout;
	  private int status;
	  private LayoutParams params;

	  private ImageView image;

	  /** Called when the activity is first created. */
	  @Override
	  public void onCreate(Bundle savedInstanceState) {
	   super.onCreate(savedInstanceState);
	   setContentView(R.layout.main);

	   layout = (FrameLayout) findViewById(R.id.LinearLayout01);
	   // layout.setOnTouchListener(this);

	   btn = (Button) findViewById(R.id.btn);
	   btn.setDrawingCacheEnabled(true);
	   btn.setOnTouchListener(this);

	   params = new LayoutParams(LayoutParams.WRAP_CONTENT,
	     LayoutParams.WRAP_CONTENT);

	  }

	  @Override
	  public boolean onTouch(View view, MotionEvent me) 
	  {
	   if (me.getAction() == MotionEvent.ACTION_DOWN) {
	    status = START_DRAGGING;
	    image = new ImageView(this);
	    image.setImageBitmap(btn.getDrawingCache());
	    layout.addView(image, params);
	   }
	   if (me.getAction() == MotionEvent.ACTION_UP) {
	    status = STOP_DRAGGING;
	    Log.i("Drag", "Stopped Dragging");
	   } else if (me.getAction() == MotionEvent.ACTION_MOVE) {
	    if (status == START_DRAGGING) {
	     System.out.println("Dragging");
	     image.setPadding((int) me.getRawX(), (int) me.getRawY(), 0, 0);
	     image.invalidate();
	    }
	   }
	   return false;
	  }
	 }
