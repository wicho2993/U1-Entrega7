package com.example.idgs_210660_examenu1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private int[] images = {
            R.drawable.dice_1,
            R.drawable.dice_2,
            R.drawable.dice_3,
            R.drawable.dice_4,
            R.drawable.dice_5,
            R.drawable.dice_6
    };
    private int currentImageIndex = 0;
    private static final String KEY_IMAGE_INDEX = "imageIndex";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Esta línea se añadió para establecer el archivo de diseño

        imageView = findViewById(R.id.imageView);
        Button button = findViewById(R.id.btn_girar);

        if (savedInstanceState != null) {
            currentImageIndex = savedInstanceState.getInt(KEY_IMAGE_INDEX, 0);
            imageView.setImageResource(images[currentImageIndex]);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                currentImageIndex = random.nextInt(images.length);
                imageView.setImageResource(images[currentImageIndex]);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save the current image index
        outState.putInt(KEY_IMAGE_INDEX, currentImageIndex);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Restore the current image index
        currentImageIndex = savedInstanceState.getInt(KEY_IMAGE_INDEX, 0);
        imageView.setImageResource(images[currentImageIndex]);
    }
}
