package vn.iotstar.linearlayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class LayoutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout2);

        // Lắng nghe sự kiện chạm vào màn hình để quay lại MainActivity
        View layout2 = findViewById(R.id.layout2);
        layout2.setOnClickListener(view -> {
            Intent intent = new Intent(LayoutActivity.this, MainActivity.class);
            startActivity(intent);
            finish(); // Đóng activity hiện tại
        });
    }
}
