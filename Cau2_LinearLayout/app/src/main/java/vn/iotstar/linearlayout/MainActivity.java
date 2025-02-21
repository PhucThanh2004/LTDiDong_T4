package vn.iotstar.linearlayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Lắng nghe sự kiện chạm vào màn hình
        View mainLayout = findViewById(R.id.main);
        mainLayout.setOnClickListener(view -> {
            // Chuyển sang LayoutActivity
            Intent intent = new Intent(MainActivity.this, LayoutActivity.class);
            startActivity(intent);
        });

        // Điều chỉnh padding khi có thay đổi về hệ thống
        ViewCompat.setOnApplyWindowInsetsListener(mainLayout, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
