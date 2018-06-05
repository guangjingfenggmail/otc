package otc.open.com.otc.ui.activity;

import android.support.v7.widget.AppCompatButton;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import otc.open.com.otc.R;
import otc.open.com.otc.base.BaseActivity;
import otc.open.com.otc.contract.LoginContract;
import otc.open.com.otc.presenter.LoginPresenter;

/**
 * ****************************************************************************************************************************************************************************
 *
 * @author :guangjing.feng
 * @createTime: 2018/6/5.
 * @version:1.1.0
 * @modifyTime:
 * @modifyAuthor:
 * @description: *****************************************************************************************************************************************************************************
 **/
public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.LoginView {

    @BindView(R.id.input_email)   //账号
            EditText inputEmail;
    @BindView(R.id.input_password) //密码
            EditText inputPassword;
    @BindView(R.id.btn_login)
    AppCompatButton btnLogin;

    @Override
    protected LoginPresenter initPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected void initVaules() {

    }

    @Override
    protected void bindView() {
        ButterKnife.bind(this);
    }

    @Override
    protected int getInflateLayoutId() {
        return R.layout.activity_login_main;
    }


    @Override
    public void onClick(View v) {

    }

    @Override
    public String getUserName() {
        return inputEmail.getText().toString().trim();
    }

    @Override
    public String getPwd() {
        return inputPassword.getText().toString().trim();
    }

    @Override
    public void loginSuccess(String str) {
//        toast(str);
    }

    @Override
    public void loginFail(String failMsg) {
//        toast(failMsg);
    }


    public boolean checkNull() {
        boolean isNull = false;
        if (TextUtils.isEmpty(getUserName())) {
            inputEmail.setError("账号不能为空");
            isNull = true;
        } else if (TextUtils.isEmpty(getPwd())) {
            inputPassword.setError("密码不能为空");
            isNull = true;
        }
        return isNull;
    }
}