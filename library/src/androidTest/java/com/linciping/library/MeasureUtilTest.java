package com.linciping.library;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.linciping.library.util.MeasureUtil;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author linciping
 *         2017/9/11
 */
@RunWith(AndroidJUnit4.class)
public class MeasureUtilTest {
    @Test
    public void getWindowWidth() throws Exception {
        Context appContext = InstrumentationRegistry.getTargetContext();
        System.out.println("screen width"+ MeasureUtil.getWindowWidth(appContext));
    }

    @Test
    public void getWindowHeight() throws Exception {
        Context appContext = InstrumentationRegistry.getTargetContext();
        System.out.println("screen width"+MeasureUtil.getWindowHeight(appContext));
    }

    @Test
    public void dp2px() throws Exception {

    }

    @Test
    public void px2dp() throws Exception {

    }

}