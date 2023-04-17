package com.example.inventory_app_20;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;

public class Item_Add_Fragment extends Fragment {
    private static final int PICK_IMAGE_REQUEST = 1;

    private Button ButtonChooseImage;
    private Button ButtonUpload;
    private TextView mTextViewShowUploads;
    private EditText ItemName;
    private EditText ItemCategory;
    private ImageView mImageView;
    private ProgressBar mProgressBar;


    private Uri mImageUri;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public Item_Add_Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==100 && data !=null && data.getData()!=null ){
           mImageUri = data.getData();
            Picasso.get().load(mImageUri).into(mImageView);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void openFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,100);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item__add_, container, false);
        ButtonChooseImage = view.findViewById(R.id.button_choose_image);
        ButtonUpload = view.findViewById(R.id.button_upload);
        mTextViewShowUploads = view.findViewById(R.id.text_view_show_uploads);
        ItemName = view.findViewById(R.id.item_name);
        ItemCategory = view.findViewById(R.id.item_category);
        mImageView = view.findViewById(R.id.image_view);
        mProgressBar = view.findViewById(R.id.progress_bar);

        ButtonChooseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser();
            }
        });
        ButtonUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mTextViewShowUploads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        // Inflate the layout for this fragment
        return view;
    }
}