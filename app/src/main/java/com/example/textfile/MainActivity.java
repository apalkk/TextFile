package com.example.textfile;


import android.os.Bundle;

import android.view.View;

import android.widget.EditText;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static final String FILE_NAME="example.txt";

    EditText mEditText;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mEditText=findViewById(R.id.edit_text);

    }

    public void save(View view) {

        String text=mEditText.getText().toString();

        FileOutputStream fileOutputStream=null;

        try{

            fileOutputStream=openFileOutput(FILE_NAME,MODE_PRIVATE);

            fileOutputStream.write(text.getBytes());

            mEditText.getText().clear();

            Toast.makeText(this,"Saved to" +getFilesDir() +"/"+FILE_NAME,Toast.LENGTH_LONG).show();

        }

        catch(FileNotFoundException e)

        {

            e.printStackTrace();

        }

        catch(IOException e){

            e.printStackTrace();

        }

        finally {

            if(fileOutputStream!=null){

                try{

                    fileOutputStream.close();

                }

                catch(IOException e)

                {

                    e.printStackTrace();

                }

            }

        }

    }

}