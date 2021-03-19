package uk.lgl.modmenu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {

    public String GameActivity = "com.unity3d.player.UnityPlayerActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //To launch mod menu
        StaticActivity.Start(this);

        //To load lib only
        //StaticActivity.LoadLib(this);

        //To launch game activity
        try {
            //Start service
            MainActivity.this.startActivity(new Intent(MainActivity.this, Class.forName(MainActivity.this.GameActivity)));
        } catch (ClassNotFoundException e) {
            //Uncomment this if you are following METHOD 2 of CHANGING FILES
            //Toast.makeText(MainActivity.this, "Error. Game's main activity does not exist", Toast.LENGTH_LONG).show();
            e.printStackTrace();
            return;
        }
    }
}
