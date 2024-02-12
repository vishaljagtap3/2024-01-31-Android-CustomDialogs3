package in.bitcode.customdialogs3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button btnPickImage;
    private ImageView imgProfilePic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        btnPickImage = findViewById(R.id.btnPickImage);
        imgProfilePic = findViewById(R.id.imgProfilePic);

        btnPickImage.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int[] imageIds = {R.drawable.flag, R.drawable.us_flag, R.drawable.laptop, R.mipmap.ic_launcher};

                        ImagePickerDialog imagePickerDialog = new ImagePickerDialog(
                                MainActivity.this,
                                imageIds,
                                "Select profile pic"
                        );
                        imagePickerDialog.setOnImageSelectedListener(new MyOnImageSelectedListener());
                        imagePickerDialog.show();
                    }
                }
        );
    }

    private class MyOnImageSelectedListener implements ImagePickerDialog.OnImageSelectedListener {
        @Override
        public void onImageSelected(ImagePickerDialog imagePickerDialog, int imageId) {
            imgProfilePic.setImageResource(imageId);
            imagePickerDialog.dismiss();
        }
    }
}