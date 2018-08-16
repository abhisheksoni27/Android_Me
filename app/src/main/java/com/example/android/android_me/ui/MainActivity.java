/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.android_me.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.android.android_me.R;

public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener {

    private int headIndex, bodyIndex, legIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button nextButton = findViewById(R.id.next_button);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();

                b.putInt("head", headIndex);
                b.putInt("body", bodyIndex);
                b.putInt("leg", legIndex);

                Intent intent = new Intent(getApplicationContext(), AndroidMeActivity.class);

                intent.putExtras(b);

                startActivity(intent);
            }
        });
    }

    @Override
    public void onImageSelected(int position) {
        Toast.makeText(this, "Position: " + String.valueOf(position), Toast.LENGTH_SHORT).show();

        int bodyPartNumber = position / 12; // Could be: 0, 1 or 2

        int currentIndex = position - 12 * bodyPartNumber;

        switch (bodyPartNumber) {
            case 0:
                headIndex = currentIndex;
                break;
            case 1:
                bodyIndex = currentIndex;
                break;
            case 2:
                legIndex = currentIndex;
                break;
        }
    }

}
