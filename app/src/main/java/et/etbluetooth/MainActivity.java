package et.etbluetooth;

import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_ENABLE_BT = 200;
    private ListView listView;
//    private

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
        initListener();
    }

    public void initView() {
        listView = (ListView) findViewById(R.id.lv_bonded_evices);

//        listView.setAdapter();
    }

    public void initData() {

        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if(defaultAdapter ==null)

        {
            Toast.makeText(this, "Your device does not support Bluetooth", Toast.LENGTH_LONG);
            finish();
        }

        if(!defaultAdapter.isEnabled())

        {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        }

        Set<BluetoothDevice> bondedDevices = defaultAdapter.getBondedDevices();
        if(bondedDevices.size()>0) {
//            listView.setAdapter(new ArrayAdapter<String>(MainActivity.this, g));
        }

    }

    public void initListener() {

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_ENABLE_BT) {
            //open the device callback
        }
    }
}
