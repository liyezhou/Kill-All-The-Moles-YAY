package yezhou.game.trickinglabel;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView i=(ImageView) findViewById(R.id.imageView);
        i.setImageResource(R.drawable.moles);
        i.setAdjustViewBounds(true);

        BitmapFactory.Options dimensions = new BitmapFactory.Options();
        dimensions.inJustDecodeBounds = true;
        Bitmap mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.moles, dimensions);
        int height = dimensions.outHeight;
        int width =  dimensions.outWidth;

        i.setMaxHeight(150);
        //final double viewWidthToBitmapWidthRatio = (double) width / (double) height;
        //i.getLayoutParams().height = (int) (height*0.1 * viewWidthToBitmapWidthRatio);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void shift_around(View view){
        TextView A=(TextView) findViewById(R.id.label);
        RelativeLayout Frame= (RelativeLayout) findViewById(R.id.frame);
        ImageView I=(ImageView) findViewById(R.id.imageView);

        view.setX((int) (Math.random() * (Frame.getWidth()- I.getWidth())));
        view.setY((int) (Math.random() * (Frame.getHeight()- I.getHeight()) ));

        A.setText(String.valueOf(I.getWidth()));


    }

}
