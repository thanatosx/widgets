package net.thanatosx.widgets;

import android.animation.Animator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewAnimationUtils;
import android.view.WindowManager;
import android.widget.LinearLayout;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by thanatos on 16/8/22.
 */

public class SearchActivity extends AppCompatActivity{

    @Bind(R.id.view_root) LinearLayout mViewRoot;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);

        mViewRoot.post(new Runnable() {
            @Override
            public void run() {
                Animator animator = ViewAnimationUtils.createCircularReveal(
                        mViewRoot, mViewRoot.getWidth(), 0, 0, mViewRoot.getHeight() / 2);
                animator.setDuration(1000);
                animator.start();
            }
        });
    }
}
