package com.jasjotsingh.elasticprogressbar;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import it.michelelacorte.elasticprogressbar.ElasticDownloadView;

public class MainActivity extends AppCompatActivity {
    ElasticDownloadView mElasticDownloadView;
    EditText editText;
    Button buttonSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mElasticDownloadView = findViewById(R.id.elastic_download_view);
        editText = findViewById(R.id.editText);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer total = Integer.parseInt(editText.getText().toString());
                for (Integer i = 0;i<=total;++i){
                    mElasticDownloadView.startIntro();
                    mElasticDownloadView.setProgress(i);
                    if (i==total){
                        mElasticDownloadView.isAnimationFinished();
                        mElasticDownloadView.success();
                        mElasticDownloadView.startIntro();
                    }else{
                        mElasticDownloadView.fail();
                    }

                }


            }
        });

    }
}