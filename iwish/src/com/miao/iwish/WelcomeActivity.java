package com.miao.iwish;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.widget.Toast;

public class WelcomeActivity extends Activity {
	private boolean isFirstIn = false;
	private static final String SHAREDPREFERENCES_NAME = "first_pref";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome);
		init();
	}

	/**
	 * 检测是否为第一次登录
	 */
	private void init() {
		// 取得相应的值，如果没有该值，说明还未写入，用true作为默认值ֵ
		SharedPreferences preferences = getSharedPreferences(
				SHAREDPREFERENCES_NAME, MODE_PRIVATE);

		// 取得相应的值，如果没有该值，说明还未写入，用true作为默认值ֵ
		isFirstIn = preferences.getBoolean("isFirstIn", true);

		// 判断程序与第几次运行，如果是第一次运行则跳转到引导界面，否则跳转到主界面
		if (isFirstIn) {
			Toast.makeText(WelcomeActivity.this, "第一次登录", 0).show();
			Editor editor = preferences.edit();
			// 存入数据
			editor.putBoolean("isFirstIn", false);
			// 提交修改
			editor.commit();
		} else {

			Toast.makeText(WelcomeActivity.this, "第二次登录", 0).show();
		}

	}
}
