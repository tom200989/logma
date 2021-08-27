// package com.logma.logma.ui;
//
// import android.os.Bundle;
// import android.util.Log;
// import android.view.View;
//
// import com.logma.logma.R;
// import com.logma.logma.tool.Logma;
//
// import androidx.appcompat.app.AppCompatActivity;
//
// public class MainActivity extends AppCompatActivity {
//
//     int count = 0;
//
//     @Override
//     protected void onCreate(Bundle savedInstanceState) {
//         super.onCreate(savedInstanceState);
//         setContentView(R.layout.activity_main);
//         Log.i("ma_pudu", "onCreate: ");
//         Logma.isd("ma_pudu", "测试打印");
//         Logma.isd("ma_pudu", "打印成功");
//         findViewById(R.id.tv_click).setOnClickListener(new View.OnClickListener() {
//             @Override
//             public void onClick(View v) {
//                 Logma.isd("ma_pudu", "点击打印: " + (++count));
//             }
//         });
//     }
// }
