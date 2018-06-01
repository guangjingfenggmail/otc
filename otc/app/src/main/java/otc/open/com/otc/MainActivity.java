package otc.open.com.otc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.txtConent)
    TextView mTxtConent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //绑定activity
        ButterKnife.bind(this);
    }

    @OnClick(R.id.txtConent)
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.txtConent:
                Toast.makeText(this,"toast",Toast.LENGTH_LONG).show();
                break;
        }
    }
}
