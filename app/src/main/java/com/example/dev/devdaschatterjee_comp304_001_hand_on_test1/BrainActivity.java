package com.example.dev.devdaschatterjee_comp304_001_hand_on_test1;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Integer.parseInt;

public class BrainActivity extends AppCompatActivity {
    private CheckBox cb1, cb2, cb3, cb4;
    private String str1, str2, str3, str4;
    private ImageView imageView2;
    private TextView choose;
    private Button nextButton;
    private String message;
    Paint paint;
    Bitmap bitmap;
    Canvas canvas;
    private int csb1, csb2, csb3, csb4;
    private int x = 100;
    private int currentX;
    private int currentY;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brain);

        cb1 = findViewById(R.id.cb1);
        cb2 = findViewById(R.id.cb2);
        cb3 = findViewById(R.id.cb3);
        cb4 = findViewById(R.id.cb4);
        choose = findViewById(R.id.textView3);
        nextButton = findViewById(R.id.btnNext);
        imageView2 = findViewById(R.id.imageView2);

       drawGraph();
    }
    private void drawGraph () {
        Point windowSize = new Point();
        getWindowManager().getDefaultDisplay().getSize(windowSize);
        Bitmap bitmap = Bitmap.createBitmap(windowSize.x, 400, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);

        ImageView ivBitmap = findViewById(R.id.imageView2);
        ivBitmap.setImageBitmap(bitmap);

        canvas.drawColor(Color.DKGRAY);

        paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(15);

        currentX = 0;
        currentY = 200;
        canvas.drawPoint(0, 200, paint);
        String[] yChanges = getResources().getStringArray(R.array.y_interval);
        for (String yChange : yChanges) {
            drawLine(100, Integer.parseInt(yChange));
        }
    }
    private void drawLine ( int changesX, int changesY){
        int X = currentX + changesX;
        int Y = currentY + changesY;

        canvas.drawLine(currentX, currentY, X, Y, paint);

        currentX = X;
        currentY = Y;
    }

    public void onClickBtnNext(View v) {
        if (cb1.isChecked()) {
            str1 = cb1.getText().toString();
            message = str1;
        }
        if (cb2.isChecked()) {
            str2 = cb2.getText().toString();
            message = message + "\n" + str2;
        }
        if (cb3.isChecked()) {
            str3 = cb3.getText().toString();
            message = message + "\n" + str3;
        }
        if (cb4.isChecked()) {
            str4 = cb4.getText().toString();
            message = message + "\n" + str4;
        }

        Toast.makeText(this, message.toString(), Toast.LENGTH_LONG).show();
    }
}
