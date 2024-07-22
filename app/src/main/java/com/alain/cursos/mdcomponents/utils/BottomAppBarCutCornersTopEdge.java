package com.alain.cursos.mdcomponents.utils;

import com.google.android.material.bottomappbar.BottomAppBarTopEdgeTreatment;
import com.google.android.material.shape.ShapePath;

/* *
 * Project: MD Components from com.alain.cursos.mdcomponents.utils
 * Created by Alain Nicolás Tello on 02/04/2020 at 01:34 PM
 * All rights reserved 2020.
 * Course Material Design and Theming for Android, UX/UI.
 * More info: https://www.udemy.com/course/material-design-theming-diseno-profesional-para-android/
 *
 * Others:
 * Course Specialize in Firebase for Android 2020 with MVP
 * More info: https://www.udemy.com/especialidad-en-firebase-para-android-con-mvp-profesional/
 */
public class BottomAppBarCutCornersTopEdge extends BottomAppBarTopEdgeTreatment {

    private final float fabMargin;
    private final float cradleVerticalOffset;

    public BottomAppBarCutCornersTopEdge(
            float fabMargin, float roundedCornerRadius, float cradleVerticalOffset) {
        super(fabMargin, roundedCornerRadius, cradleVerticalOffset);
        this.fabMargin = fabMargin;
        this.cradleVerticalOffset = cradleVerticalOffset;
    }

    @Override
    @SuppressWarnings("RestrictTo")
    public void getEdgePath(float length, float center, float interpolation, ShapePath shapePath) {
        float fabDiameter = getFabDiameter();
        if (fabDiameter == 0) {
            shapePath.lineTo(length, 0);
            return;
        }

        float diamondSize = fabDiameter / 2f;
        float middle = center + getHorizontalOffset();

        float verticalOffsetRatio = cradleVerticalOffset / diamondSize;
        if (verticalOffsetRatio >= 1.0f) {
            shapePath.lineTo(length, 0);
            return;
        }

        shapePath.lineTo(middle - (fabMargin + diamondSize - cradleVerticalOffset), 0);

        shapePath.lineTo(middle, (diamondSize - cradleVerticalOffset + fabMargin) * interpolation);

        shapePath.lineTo(middle + (fabMargin + diamondSize - cradleVerticalOffset), 0);

        shapePath.lineTo(length, 0);
    }
}