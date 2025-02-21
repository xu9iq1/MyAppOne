package com.xu9iq1.myappone;

import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 适配异形屏
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main);

        // 确保视图内容不会被系统栏遮挡
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 隐藏状态栏
        // getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        TextView mHeaderTextView = findViewById(R.id.headerTextView);
        mHeaderTextView.setText("FORZA FERRARI\n\n" + mHeaderTextView.getText().toString());

        // 显示颜色模式
        TextView mColorModeTextView = findViewById(R.id.colorModeTextView);
        mColorModeTextView.setText(mColorModeTextView.getText().toString() + this.getString(R.string.color_mode));

        // 按钮点击交互
        Button mClickToToastButton = findViewById(R.id.clickButton);
        TextView mTimeTextView = findViewById(R.id.timeTextView);
        mClickToToastButton.setOnClickListener(v -> {
            mTimeTextView.setText(new SimpleDateFormat("yyyy年MM月dd日 EEEE\nHH时mm分ss秒", Locale.CHINA).format(new Date()));
            Toast.makeText(this, R.string.toast, Toast.LENGTH_SHORT).show();
        });
    }
}