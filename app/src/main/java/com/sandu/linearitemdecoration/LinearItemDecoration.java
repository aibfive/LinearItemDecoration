package com.sandu.linearitemdecoration;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

public class LinearItemDecoration extends RecyclerView.ItemDecoration {

    private Context context;
    private int dividerHeight;
    private Paint colorPaint = new Paint();

    public LinearItemDecoration(Context context){
        this.context = context;
        dividerHeight = context.getResources().getDimensionPixelSize(R.dimen.divider_height);
        colorPaint.setColor(Color.GREEN);
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();
        int count = parent.getChildCount();
        for(int i = 0; i < count - 1; i++){
            View view = parent.getChildAt(i);
            int top = view.getBottom();
            int bottom = view.getBottom() + dividerHeight;
            c.drawRect(left, top, right, bottom, colorPaint);
        }
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int count = parent.getChildCount();
        count = 7;
        int current = parent.getChildPosition(view);
        /*if(current == count - 1){
            outRect.bottom = 0;
        }else{
            outRect.bottom = dividerHeight;
        }*/
        if(current == 0){
            outRect.top = dividerHeight;
            outRect.bottom = dividerHeight;
        }else if(current == count - 1){
            outRect.bottom = dividerHeight;
        }else{
            outRect.bottom = dividerHeight;
        }
        Log.i("GG", view+"<--current-->"+current+"<---->"+outRect.bottom);
    }

}
