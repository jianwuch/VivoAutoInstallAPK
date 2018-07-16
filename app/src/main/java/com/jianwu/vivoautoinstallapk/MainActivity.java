package com.jianwu.vivoautoinstallapk;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        password = findViewById(R.id.password);

        password.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    savePwd();
                    return true;
                }
                return false;
            }
        });
    }

    private void savePwd() {
        String pwdStr = password.getText().toString().trim();
        if (TextUtils.isEmpty(pwdStr)) {
            return;
        }

        SharePreferencesUtils.setParam(getApplication(), AppConstants.KEY_PASSWORD, pwdStr);
        Toast.makeText(getApplication(), "保存成功", Toast.LENGTH_SHORT).show();
    }
}
