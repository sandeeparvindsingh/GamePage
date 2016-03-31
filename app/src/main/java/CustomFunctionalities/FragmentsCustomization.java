package CustomFunctionalities;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.Typeface;

import app.text.fonts.Font;

/**
 * Created by DELL1 on 3/27/2016.
 */
public class FragmentsCustomization extends Fragment implements Font {
    @Override
    public Typeface changeFont() {

        Typeface face= Typeface.createFromAsset(getActivity().getAssets(), "fonts/textgood.ttf");
    return face;
    }
    public  boolean filter(int current, int threshold)
    {

        if(current<threshold)
            return true;
        else
            return false;
    }

}
