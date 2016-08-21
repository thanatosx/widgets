package net.thanatosx.charts;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * 饼状图
 * Created by thanatos on 16/6/26.
 */
public class PieChartView extends View{

    private int mBorderWidth;
    private int mBorderColor;
    private int mTextFontSize;
    private int mTextColor;
    private int mRadius;
    private boolean onTouchOne;
    private float mStartDegree = 0.0F;
    private Path mAcrossPath;
    private RectF mPieRect;
    private Paint mBorderPaint;
    private Paint mSectorPaint;
    private Paint mTextPaint;
    private List<Sector> sectors = new ArrayList<>();

    public PieChartView(Context context) {
        super(context);
    }

    public PieChartView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PieChartView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray a = context.obtainStyledAttributes(
                attrs, R.styleable.PieChartView, 0, 0);

        mBorderWidth = a.getDimensionPixelSize(R.styleable.PieChartView_pcvBorderWidth, 1);
        mBorderColor = a.getColor(R.styleable.PieChartView_pcvBorderColor, 0xFF000000);
        mTextColor = a.getColor(R.styleable.PieChartView_pcvTextColor, 0XFF000000);
        mTextFontSize = a.getDimensionPixelSize(R.styleable.PieChartView_pcvTextFontSize, 12);

        mRadius = a.getDimensionPixelSize(R.styleable.PieChartView_pcvRadius, 0);

        a.recycle();

        mBorderPaint = new Paint();
        mBorderPaint.setAntiAlias(true);
        mBorderPaint.setStyle(Paint.Style.STROKE);
        mBorderPaint.setColor(mBorderColor);
        mBorderPaint.setStrokeWidth(mBorderWidth);
        mBorderPaint.setDither(false);

        mSectorPaint = new Paint();
        mSectorPaint.setAntiAlias(true);

        mTextPaint = new Paint();
        mTextPaint.setAntiAlias(true);
        mTextPaint.setTextSize(mTextFontSize);
        mTextPaint.setColor(mTextColor);

        mAcrossPath = new Path();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = resolveSize(mRadius * 2 + getPaddingLeft() + getPaddingRight(), widthMeasureSpec);
        int height = resolveSize(mRadius * 2 + getPaddingTop() + getPaddingBottom(), heightMeasureSpec);

        mRadius = Math.min(width - getPaddingLeft() - getPaddingRight(),
                height - getPaddingTop() - getPaddingBottom()) / 2;

        setMeasuredDimension(width, height);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (mPieRect == null) mPieRect = new RectF();
        int left = ((w - getPaddingLeft() - getPaddingRight()) - mRadius * 2) / 2 + getPaddingLeft();
        int top = ((h - getPaddingTop() - getPaddingBottom()) - mRadius * 2) / 2 + getPaddingTop();
        int right = left + mRadius * 2;
        int bottom = top + mRadius * 2;
        mPieRect.set(left, top, right, bottom);

        float mAngleIndex = mStartDegree;
        float mCenterX = mPieRect.centerX();
        float mCenterY = mPieRect.centerY();

        for (Sector sector : sectors){
            sector.setCenterPoint(mPieRect.centerX(), mPieRect.centerY());
            sector.mStartAngle = mAngleIndex;
            mAngleIndex += sector.mRotateAngle;

            double a;
            double b;
            if (TextUtils.isEmpty(sector.title)) continue;
            double radian = (mAngleIndex - sector.mRotateAngle / 2) * 2 * Math.PI / 360;
            a = Math.sin(radian) * mRadius;
            b = Math.cos(radian) * mRadius;
            sector.setAcrossPoint(mCenterX + b, mCenterY + a);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mRadius == 0) return;

        int count = canvas.save();

        canvas.drawCircle(mPieRect.centerX(), mPieRect.centerY(), mRadius, mBorderPaint);

        for (Sector sector : sectors){
            mSectorPaint.setStyle(Paint.Style.FILL);
            mSectorPaint.setColor(sector.color);
            if (onTouchOne && !sector.isTouching){
                mSectorPaint.setAlpha(100);
            }
            canvas.drawArc(mPieRect, sector.mStartAngle, sector.mRotateAngle, true, mSectorPaint);
            if (mBorderWidth > 0){
                mSectorPaint.setStyle(Paint.Style.STROKE);
                mSectorPaint.setColor(mBorderColor);
                mSectorPaint.setStrokeWidth(mBorderWidth);
                canvas.drawArc(mPieRect, sector.mStartAngle, sector.mRotateAngle, true, mSectorPaint);
            }
            if (!TextUtils.isEmpty(sector.title)){
                mAcrossPath.reset();
                mAcrossPath.moveTo(mPieRect.centerX(), mPieRect.centerY());
                mAcrossPath.lineTo(sector.mAcrossPoint.x, sector.mAcrossPoint.y);
                canvas.drawTextOnPath(sector.title, mAcrossPath, mRadius / 2, mTextFontSize / 2, mTextPaint);
            }
        }

        canvas.restoreToCount(count);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                float x = event.getX();
                float y = event.getY();
                float cx = mPieRect.centerX();
                float cy = mPieRect.centerY();
                if (Math.pow(x - cx, 2) + Math.pow(y - cy, 2) > Math.pow(mRadius, 2)) break;

                float dx = x - cx;
                float dy = y - cy;
                double angle;
                if (dx <= 0){
                    angle = (360 + (180 / Math.PI) * Math.atan(dy / dx)) % 360;
                }else{
                    angle = 180 + (180 / Math.PI) * Math.atan(dy / dx);
                }
                for (Sector sector : sectors){
                    if (!sector.isHere(angle)) {
                        sector.isTouching = false;
                        continue;
                    }
                    sector.isTouching = true;
                    onTouchOne = true;
                }
                if (onTouchOne) invalidate();
                return onTouchOne;

            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                onTouchOne = false;
                invalidate();
                break;
        }
        return super.onTouchEvent(event);
    }

    public void addData(float rate, int color, String title){
        if (rate <= 0.0) return;
        Sector sector = new Sector();
        sector.mRotateAngle = rate * 360;
        sector.title = title;
        sector.color = color;
        sectors.add(sector);
    }

    private static class Sector{
        public float mStartAngle;
        public float mRotateAngle;
        public Point mCenterPoint;
        public Point mAcrossPoint; //扇形中线与弧的交点
        public boolean isTouching;
        public int color;
        public String title;

        public void setCenterPoint(int x, int y){
            mCenterPoint = new Point(x, y);
        }

        public void setCenterPoint(float x, float y){
            setCenterPoint((int) x, (int) y);
        }

        public void setAcrossPoint(double x, double y){
            setAcrossPoint((int) x, (int) y);
        }

        public void setAcrossPoint(int x, int y){
            mAcrossPoint = new Point(x, y);
        }

        public boolean isHere(double angle){
            angle = (angle + 180) % 360; // offset 180 digresses because canvas.drawArc draw place where begin in 180 which relative our coordination
            return angle >= mStartAngle && angle <= (mStartAngle + mRotateAngle);
        }
    }
}
