package com.example.radva.szakdolgozat;

import android.Manifest;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewAnimator;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import static android.app.Activity.RESULT_OK;

/**
 * Created by radva on 2017. 12. 02..
 */

public class SettingsFragment extends Fragment {

    private static final String PROFILE_PICTURE_NAME = "ProfilePicture.jpg";

    private static final int CODE_CAMERA = 1000;
    private static final int MY_PERMISSIONS_REQUEST_CAMERA = 1001;

    private ImageView imgProfilePicture;
    private View btnTakePicture;
    private ImageLoadTask task;
    private TextView tvProfile;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_settings, container, false);

        imgProfilePicture = (ImageView) root.findViewById(R.id.imgProfilePicture);
        btnTakePicture = root.findViewById(R.id.btnTakePicture);
        tvProfile = (TextView) root.findViewById(R.id.tvProfile);

        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        String firstName = sharedPreferences.getString(Constants.PREFERENCES_USER_FIRST_NAME, "");
        String lastName = sharedPreferences.getString(Constants.PREFERENCES_USER_LAST_NAME, "");

        tvProfile.setText("Bejelentkezve, mint: " + firstName + " " + lastName);

        showProfilePicture();

        btnTakePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isPermissionGranted = checkPermissions();

                if (isPermissionGranted) {
                    takePhoto();
                }
            }
        });
    }

    private void takePhoto() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getContext().getPackageManager()) != null) {
            File photoFile = new File(getFilesDir(), PROFILE_PICTURE_NAME);
            try {
                photoFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (photoFile.exists()) {
                Uri photoURI = FileProvider.getUriForFile(getContext(),
                        "com.example.android.fileprovider",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, CODE_CAMERA);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_CAMERA: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    takePhoto();
                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    private boolean checkPermissions() {
        if (ContextCompat.checkSelfPermission(getActivity(),
                Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(
                    new String[]{Manifest.permission.CAMERA},
                    MY_PERMISSIONS_REQUEST_CAMERA);
            return false;
        } else {
            return true;
        }
    }

    private File getFilesDir() {
        return getContext().getFilesDir();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CODE_CAMERA && resultCode == RESULT_OK) {

            File file = new File(getFilesDir(), PROFILE_PICTURE_NAME);
            if (file.exists()) {
                showProfilePicture();

            }
        }
    }

    public static Bitmap decodeSampledBitmapFromResource(String path,
                                                         int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(path, options);
    }

    private static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }

    private void showProfilePicture() {

        File file = new File(getFilesDir(), PROFILE_PICTURE_NAME);

        if (file.exists()) {
            Bitmap bmp = decodeSampledBitmapFromResource(file.getAbsolutePath(), 200, 200);
            if (bmp != null) {
                imgProfilePicture.setImageBitmap(bmp);
                return;
            }
        }

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        String userId = sharedPreferences.getString(Constants.PREFERENCES_USER_ID, "");
        task = new ImageLoadTask();
        task.execute(userId);
    }

    class ImageLoadTask extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
                URL imageURL = new URL("https://graph.facebook.com/" + strings[0] + "/picture?type=large");
                return BitmapFactory.decodeStream(imageURL.openConnection().getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if (bitmap != null) {
                imgProfilePicture.setImageBitmap(bitmap);
                ObjectAnimator animator = ObjectAnimator.ofFloat(imgProfilePicture, "alpha", 0, 1);
                animator.setDuration(500);
                animator.start();
            }
        }
    }
}
