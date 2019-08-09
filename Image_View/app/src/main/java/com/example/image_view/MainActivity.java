package com.example.image_view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    ImageView img;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Image_Select(View view){

        img = (ImageView)findViewById(R.id.image);
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/jpeg");
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK) {
            try {
                Uri image = data.getData();
                InputStream imagestream = getContentResolver().openInputStream(image);
                Bitmap selectedImage = BitmapFactory.decodeStream(imagestream);
                img.setImageBitmap(selectedImage);
            }
            catch(FileNotFoundException e){
                Toast.makeText(getApplicationContext(), "Error !!!", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(MainActivity.this, "Pick an Image First !!!", Toast.LENGTH_SHORT).show();
        }
    }

}
