/*
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hugegreenbug.awesomelauncher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;

import com.android.ex.carousel.CarouselView;
import com.android.ex.carousel.CarouselViewHelper;

public class LauncherActivity extends Activity {
    private static final String TAG = "LauncherActivity";
    private static final int CARD_SLOTS = 56;
    private static final int TOTAL_CARDS = 100;
    private static final int TEXTURE_HEIGHT = 100;
    private static final int TEXTURE_WIDTH = 100;
    private static final int SLOTS_VISIBLE = 10;

    protected static final boolean DBG = false;
    private static final int DETAIL_TEXTURE_WIDTH = 200;
    private static final int DETAIL_TEXTURE_HEIGHT = 80;
    private static final int VISIBLE_DETAIL_COUNT = 3;
    private static final int ICON_SIZE = 48;
    private static boolean INCREMENTAL_ADD = false; // To debug incrementally adding cards
    private CarouselView mView;
    private Paint mPaint = new Paint();
    private CarouselViewHelper mHelper;
    private Bitmap mGlossyOverlay;
    private Bitmap mBorder;
    private ArrayList<ApplicationInfo> mApplications;
    
    class LocalCarouselViewHelper extends CarouselViewHelper {
        private static final int PIXEL_BORDER = 0;
        private DetailTextureParameters mDetailTextureParameters
                = new DetailTextureParameters(5.0f, 5.0f, 3.0f, 10.0f);

        LocalCarouselViewHelper(Context context) {
            super(context);
        }

        @Override
        public void onCardSelected(final int id) {
          //  postMessage("Selection", "Card " + id + " was selected");
        	 ApplicationInfo app = (ApplicationInfo) mApplications.get(id);
             startActivity(app.intent);
        }

        @Override
        public void onDetailSelected(final int id, int x, int y) {
            postMessage("Selection", "Detail for card " + id + " was selected");
        }

        @Override
        public void onCardLongPress(int n, int touchPosition[], Rect detailCoordinates) {
        //    postMessage("Selection", "Long press on card " + n);
        }

        @Override
        public DetailTextureParameters getDetailTextureParameters(int id) {
            return mDetailTextureParameters;
        }

        @Override
        public Bitmap getTexture(int n) {
        
        	
            Bitmap bitmap = Bitmap.createBitmap(TEXTURE_WIDTH, TEXTURE_HEIGHT,
                    Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            canvas.drawARGB(0, 0, 0, 0);
            mPaint.setColor(0x00808080);
            canvas.drawRect(2, 2, TEXTURE_WIDTH-2, TEXTURE_HEIGHT-2, mPaint);
            mPaint.setTextSize(12.0f);
            mPaint.setAntiAlias(true);
            mPaint.setDither(false);
            mPaint.setColor(0xffffffff);
            if (mApplications == null || mApplications.size() < n + 1)
            	canvas.drawBitmap(mGlossyOverlay, null,
            			new Rect(PIXEL_BORDER, PIXEL_BORDER,
            					TEXTURE_WIDTH - PIXEL_BORDER, TEXTURE_HEIGHT - PIXEL_BORDER), mPaint);
            else {
                float textWidth = Math.max(0.0f, (TEXTURE_WIDTH - 
                		mPaint.measureText(mApplications.get(n).title.toString()))/2.0f);
            	canvas.drawText(mApplications.get(n).title.toString(), textWidth, TEXTURE_HEIGHT - 4, mPaint);
            	Drawable d = mApplications.get(n).icon;
            	Bitmap icon = ((BitmapDrawable) d).getBitmap();
            	Bitmap scaledIcon;
            	if (icon.getWidth() != ICON_SIZE || icon.getHeight() != ICON_SIZE) {
            		scaledIcon = Bitmap.createScaledBitmap(icon, ICON_SIZE, ICON_SIZE, true);
            	} else 
            		scaledIcon = icon;

            	canvas.drawBitmap(scaledIcon, null,
            			new Rect((TEXTURE_WIDTH - scaledIcon.getWidth())/2, (TEXTURE_HEIGHT - scaledIcon.getHeight())/2,
            					(TEXTURE_WIDTH - scaledIcon.getWidth())/2 + scaledIcon.getWidth(), 
            					(TEXTURE_HEIGHT - scaledIcon.getHeight())/2 + scaledIcon.getHeight()), 
            					mPaint);
            	
            	if (icon != scaledIcon)
            		scaledIcon.recycle();

            }
            
            return bitmap;
        }

        @Override
        public Bitmap getDetailTexture(int n) {
            /*Bitmap bitmap = Bitmap.createBitmap(DETAIL_TEXTURE_WIDTH, DETAIL_TEXTURE_HEIGHT,
                    Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            canvas.drawARGB(32, 10, 10, 10);
            mPaint.setTextSize(15.0f);
            mPaint.setAntiAlias(true);
            
            if (mApplications.size() >= n+1)
            	canvas.drawText(mApplications.get(n).title.toString(), 0, DETAIL_TEXTURE_HEIGHT/2, mPaint);
            
            return bitmap;*/
        	
        	return null;
        }
    };

    private Runnable mAddCardRunnable = new Runnable() {
        public void run() {
            if (mView.getCardCount() < TOTAL_CARDS) {
                mView.createCards(mView.getCardCount() + 1);
                mView.postDelayed(mAddCardRunnable, 2000);
            }
        }
    };

    void postMessage(final CharSequence title, final CharSequence msg) {
        runOnUiThread(new Runnable() {
            public void run() {
                new AlertDialog.Builder(LauncherActivity.this)
                    .setTitle(title)
                    .setMessage(msg)
                    .setPositiveButton("OK", null)
                    .create()
                    .show();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.carousel_test);
        mView = (CarouselView) findViewById(R.id.carousel);
        mView.getHolder().setFormat(PixelFormat.RGBA_8888);
        mPaint.setColor(0xffffffff);
        final Resources res = getResources();
        mApplications = null;

        loadApps(false);

        mHelper = new LocalCarouselViewHelper(this);
        mHelper.setCarouselView(mView);
        Display display = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
        setOrientation(display.getRotation());
        mView.createCards(INCREMENTAL_ADD ? 1: mApplications.size());
        mView.setStartAngle(-4.2f);
        mBorder = BitmapFactory.decodeResource(res, R.drawable.border);
        mView.setDefaultBitmap(mBorder);
        mView.setLoadingBitmap(mBorder);
        mView.setBackgroundColor(0.25f, 0.25f, 0.5f, 1.0f);
        mView.setRezInCardCount(3.0f);
        mView.setFadeInDuration(250);
        mView.setDragModel(CarouselView.DRAG_MODEL_CYLINDER_INSIDE);
        if (INCREMENTAL_ADD) {
            mView.postDelayed(mAddCardRunnable, 2000);
        }

        mGlossyOverlay = BitmapFactory.decodeResource(res, R.drawable.glossy_overlay);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) 
        	setOrientation(Surface.ROTATION_90);
        else
        	setOrientation(Surface.ROTATION_0);
    }
    
    private void setOrientation(int orientation) {
    	if (orientation == Surface.ROTATION_90 || orientation == Surface.ROTATION_270) {
    		mView.setSlotCount(mApplications.size()/4);
    		mView.setVisibleSlots(4);
    		mView.setVisibleDetails(4);
    		mView.setRadius(10.0f);
    		mView.setRowCount(8);
    		mView.setFov(90.0f);
    	} else if (orientation == Surface.ROTATION_0 || orientation == Surface.ROTATION_180) {
    		mView.setSlotCount(mApplications.size()/2);
    		mView.setVisibleSlots(5);
    		mView.setVisibleDetails(7);
    		mView.setRadius(14.0f);
    		mView.setRowCount(4);
    		mView.setFov(45.0f);
    	}

    }
    
    private float wedgeAngle(float slots, float slotCount) {
        return (float) ((slots * 2.0f * Math.PI) / slotCount);
    }

    private void loadApps(boolean isLaunching) {
        if (isLaunching && mApplications != null) {
            return;
        }

        PackageManager manager = getPackageManager();

        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);

        final List<ResolveInfo> apps = manager.queryIntentActivities(mainIntent, 0);
        Collections.sort(apps, new ResolveInfo.DisplayNameComparator(manager));

        if (apps != null) {
            final int count = apps.size();

            if (mApplications == null) {
                mApplications = new ArrayList<ApplicationInfo>(count);
            }
            
            mApplications.clear();

            for (int i = 0; i < count; i++) {
                ApplicationInfo application = new ApplicationInfo();
                ResolveInfo info = apps.get(i);

                application.title = info.loadLabel(manager);
                application.setActivity(new ComponentName(
                        info.activityInfo.applicationInfo.packageName,
                        info.activityInfo.name),
                        Intent.FLAG_ACTIVITY_NEW_TASK
                        | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
                application.icon = info.activityInfo.loadIcon(manager);

                mApplications.add(application);
            }
        }
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        mHelper.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mHelper.onPause();
    }

}
