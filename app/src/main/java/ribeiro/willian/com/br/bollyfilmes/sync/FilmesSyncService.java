package ribeiro.willian.com.br.bollyfilmes.sync;

import android.app.Service;
import android.bluetooth.BluetoothClass;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Willian on 07/01/2017.
 */

public class FilmesSyncService extends Service {

    private static FilmesSyncAdapter filmesSyncAdapter = null;

    private static final Object lock = new Object();

    @Override
    public void onCreate() {
        synchronized (lock){
            if(filmesSyncAdapter == null){
                filmesSyncAdapter = new FilmesSyncAdapter(getApplicationContext(), true);
            }
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return filmesSyncAdapter.getSyncAdapterBinder();
    }
}
