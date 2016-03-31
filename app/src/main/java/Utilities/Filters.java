package Utilities;

/**
 * Created by DELL1 on 3/27/2016.
 */
public class Filters {

    public  boolean filter(int current, int threshold)
    {
        if(current<threshold)
            return true;
        else
            return false;
    }
}
