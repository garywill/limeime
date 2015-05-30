

package net.toload.main.hd.candidate;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;

import net.toload.main.hd.R;

public class CandidateInInputViewContainer extends LinearLayout  implements OnTouchListener {

	private static final boolean DEBUG = false;
	private static final String TAG = "CandiInputViewContainer";
    private View mButtonExpand;
    private View mButtonRightExpand;
    private CandidateView mCandidates;

    
    public CandidateInInputViewContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
        if(DEBUG)
    		Log.i(TAG,"CandidateInInputViewContainer() constructor");
    }

    public void initViews() {
    	if(DEBUG)
    		Log.i(TAG,"initViews()");
        if (mCandidates == null) {
            mButtonRightExpand = findViewById(R.id.candidate_right_parent);
            mButtonExpand = findViewById(R.id.candidate_right);
            if (mButtonExpand != null) {
                mButtonExpand.setOnTouchListener(this);
            }
            mCandidates = (CandidateView) findViewById(R.id.candidatesView);
            
        }
    }

    @Override
    public void requestLayout() {
        if(DEBUG)
            Log.i(TAG,"requestLayout()");

    	if (mCandidates != null) {
            int availableWidth = mCandidates.getWidth();
            int neededWidth = mCandidates.computeHorizontalScrollRange();

            if(DEBUG)
                Log.i(TAG,"requestLayout() availableWidth:" + availableWidth+ " neededWidth:" + neededWidth);


            boolean rightVisible =  availableWidth < neededWidth;
            if(mCandidates.isCandidateExpanded())
            	rightVisible = false;
            
            if (mButtonRightExpand != null) {
                mButtonRightExpand.setVisibility(rightVisible ? VISIBLE : GONE);
            }
        }
        super.requestLayout();
    }

    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (v == mButtonExpand) {
              	mCandidates.showCandidatePopup();
            	
            }
        }
        return false;
    }

    
}
