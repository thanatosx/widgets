package net.thanatosx.loading;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;

/**
 * 极光loading
 * Created by thanatos on 16/7/11.
 */
public class AuroraLoadingView extends View{

    private static final int DELAY_TIME = 30;
    private static final int DEGREE = 10;

    private int mRadius;
    private Paint mBorderPaint;
    private RectF mDrawRect;
    private SweepGradient mGradientor;
    private int mColor;
    private int mBorderWidth;
    private int mCurrentDegree;
    private int cx;
    private int cy;

    public AuroraLoadingView(Context context) {
        super(context);
    }

    public AuroraLoadingView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AuroraLoadingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.AuroraLoadingView, 0, 0);
        mRadius = a.getDimensionPixelOffset(R.styleable.AuroraLoadingView_alvRadius, 0);
        mColor = a.getColor(R.styleable.AuroraLoadingView_alvColor, Color.RED);
        mBorderWidth = a.getDimensionPixelOffset(R.styleable.AuroraLoadingView_alvBorderWidth, 2);
        a.recycle();

        mBorderPaint = new Paint();
        mBorderPaint.setAntiAlias(true);
        mBorderPaint.setStyle(Paint.Style.STROKE);
        mBorderPaint.setStrokeWidth(5);

        mDrawRect = new RectF();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = resolveSize(mRadius * 2, widthMeasureSpec);
        int height = resolveSize(mRadius * 2 + 10, heightMeasureSpec);
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (w <= 0 || h <= 0){
            mRadius = 0;
            return;
        }
        mRadius = Math.min(w / 2, h / 2);
        cx = w / 2;
        cy = h / 2;
        mRadius = mRadius - mBorderWidth;
        mDrawRect.set(
                cx - mRadius, cy - mRadius,
                cx + mRadius, cy + mRadius
        );
        mGradientor = new SweepGradient(cx, cy, mColor & 0X00FFFFFF, mColor);
        mBorderPaint.setShader(mGradientor);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int count = canvas.save();
        canvas.rotate(mCurrentDegree, cx, cy);
        canvas.drawArc(mDrawRect, 0, 360, false, mBorderPaint);
        canvas.restoreToCount(count);
        mCurrentDegree += DEGREE;
        mCurrentDegree %= 360;
        postInvalidateDelayed(DELAY_TIME);
    }
}
