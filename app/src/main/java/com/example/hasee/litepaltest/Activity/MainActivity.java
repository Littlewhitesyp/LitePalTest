package com.example.hasee.litepaltest.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hasee.litepaltest.R;
import com.example.hasee.litepaltest.java.Application;

import org.litepal.LitePal;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView mResult;
    /**
     * 应用名
     */
    private EditText mName;
    /**
     * 账号
     */
    private EditText mAccount;
    /**
     * 密码
     */
    private EditText mInput;
    /**
     * 增加
     */
    private Button mAdd;
    /**
     * 删除
     */
    private Button mDelete;
    /**
     * 修改
     */
    private Button mModify;
    /**
     * 查询
     */
    private Button mQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }


    private void initView() {
        mResult = (TextView) findViewById(R.id.result);
        mName = (EditText) findViewById(R.id.name);
        mAccount = (EditText) findViewById(R.id.account);
        mInput = (EditText) findViewById(R.id.input);
        mAdd = (Button) findViewById(R.id.add);
        mAdd.setOnClickListener(this);
        mDelete = (Button) findViewById(R.id.delete);
        mDelete.setOnClickListener(this);
        mModify = (Button) findViewById(R.id.modify);
        mModify.setOnClickListener(this);
        mQuery = (Button) findViewById(R.id.query);
        mQuery.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String nameStr = null;
        String accountStr = null;
        String passwordStr = null;
        switch (v.getId()) {
            default:
                break;
            case R.id.add:
                nameStr = TextUtils.isEmpty(mName.getText().toString())?"QQ":mName.getText().toString();
                accountStr = TextUtils.isEmpty(mAccount.getText().toString())?"1219416835":mAccount.getText().toString();
                passwordStr = TextUtils.isEmpty(mInput.getText().toString())?"123":mInput.getText().toString();
                Application application = new Application();
                application.setName(nameStr);
                application.setAccount(accountStr);
                application.setPassword(passwordStr);
                application.save();
                break;
            case R.id.delete:
                LitePal.deleteAll(Application.class);
                break;
            case R.id.modify:
                Intent intent = new Intent(MainActivity.this,Contacts.class);
                startActivity(intent);
                break;
            case R.id.query:
                List<Application> applications = LitePal.findAll(Application.class);
                StringBuilder result = new StringBuilder();
                for(Application application1:applications)
                    result.append("应用："+application1.getName()+"\n"+
                                  "账号："+application1.getAccount()+"\n"+
                                  "密码："+application1.getPassword()+"\n\n"
                    );
                mResult.setText(result.toString());
                break;
        }
    }
}
