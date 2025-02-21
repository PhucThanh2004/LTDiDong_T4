package vn.iotstar.imageview;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Switch switchBackground;
    ProgressBar progressBar;
    ConstraintLayout bg;
    int[] backgrounds = {R.drawable.back1, R.drawable.back2, R.drawable.back3, R.drawable.back4, R.drawable.back5};
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        switchBackground = findViewById(R.id.switchBackground);
        progressBar = findViewById(R.id.progressBar2);
        bg = findViewById(R.id.constraintLayout1);

        switchBackground.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                int index = random.nextInt(backgrounds.length);
                bg.setBackgroundResource(backgrounds[index]);

                Toast.makeText(MainActivity.this, "Hình nền: " + (index + 1), Toast.LENGTH_SHORT).show();

                // Tăng tiến trình ProgressBar
                int current = progressBar.getProgress();
                if (current >= progressBar.getMax()) {
                    current = 0;
                }
                progressBar.setProgress(current + 10);
            }
        });
    }
}
