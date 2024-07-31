package ht.keycheckfn;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "KeyPrefs";
    private static final String KEY_VALUE = "key_value";
    private static final String DEVICE_ID = "device_id";
    private Dialog keyDialog;
    private Handler handler;
    private Runnable verifyRunnable;
    private final int VERIFY_INTERVAL = 3000; // Thời gian kiểm tra lại (3 giây)
    private boolean isDialogVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new Handler();
        showKeyDialog();
    }

    private boolean isDeviceRegistered() {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        return prefs.contains(KEY_VALUE) && prefs.contains(DEVICE_ID);
    }

    private void setDeviceRegistered(String keyValue, String deviceId) {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(KEY_VALUE, keyValue);
        editor.putString(DEVICE_ID, deviceId);
        editor.apply();
    }

    private void clearDeviceRegistration() {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.remove(KEY_VALUE);
        editor.remove(DEVICE_ID);
        editor.apply();
    }

    private void showKeyDialog() {
        if (!isDialogVisible) {
            keyDialog = new Dialog(MainActivity.this);
            keyDialog.setContentView(R.layout.dialog_enter_key);

            // Không cho phép hủy dialog khi nhấn vào khoảng trống
            keyDialog.setCancelable(false);
            keyDialog.setCanceledOnTouchOutside(false);

            // Set the shape of the dialog
            if (keyDialog.getWindow() != null) {
                keyDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            }

            EditText editTextKey = keyDialog.findViewById(R.id.editTextKey);
            Button buttonCheckKey = keyDialog.findViewById(R.id.buttonCheckKey);

            buttonCheckKey.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String key = editTextKey.getText().toString().trim();
                    if (!key.isEmpty()) {
                        checkKey(key);
                    } else {
                        Toast.makeText(MainActivity.this, "Vui lòng nhập key !!", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            keyDialog.show();
            isDialogVisible = true;

            if (isDeviceRegistered()) {
                verifyKeyWithServer();
            }
        }
    }

    private void checkKey(String key) {
        String device_id = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("https://hunterlua.000webhostapp.com/apk/check_device.php");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    conn.setDoOutput(true);

                    OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
                    writer.write("key_value=" + key + "&device_id=" + device_id);
                    writer.flush();
                    writer.close();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    reader.close();

                    JSONObject jsonResponse = new JSONObject(response.toString());
                    String status = jsonResponse.getString("status");
                    String message = jsonResponse.getString("message");

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                            if (status.equals("success")) {
                                setDeviceRegistered(key, device_id);
                                keyDialog.dismiss();
                                isDialogVisible = false;
                                startVerifyLoop();
                            }
                        }
                    });

                } catch (Exception e) {
                    e.printStackTrace();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, "Lỗi kết nối", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        }).start();
    }

    private void verifyKeyWithServer() {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        String keyValue = prefs.getString(KEY_VALUE, null);
        String deviceId = prefs.getString(DEVICE_ID, null);

        if (keyValue == null || deviceId == null) {
            showKeyDialog();
            return;
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("https://hunterlua.000webhostapp.com/apk/verify_key.php");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    conn.setDoOutput(true);

                    OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
                    writer.write("key_value=" + keyValue + "&device_id=" + deviceId);
                    writer.flush();
                    writer.close();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    reader.close();

                    JSONObject jsonResponse = new JSONObject(response.toString());
                    String status = jsonResponse.getString("status");
                    String message = jsonResponse.getString("message");

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                            if (status.equals("success")) {
                                if (keyDialog.isShowing()) {
                                    keyDialog.dismiss();
                                    isDialogVisible = false;
                                }
                            } else {
                                clearDeviceRegistration();
                                if (!keyDialog.isShowing()) {
                                    showKeyDialog();
                                }
                            }
                        }
                    });

                } catch (Exception e) {
                    e.printStackTrace();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, "Lỗi kết nối", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        }).start();
    }

    private void startVerifyLoop() {
        if (verifyRunnable == null) {
            verifyRunnable = new Runnable() {
                @Override
                public void run() {
                    verifyKeyWithServer();
                    handler.postDelayed(this, VERIFY_INTERVAL);
                }
            };
        }
        handler.post(verifyRunnable);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(verifyRunnable);
    }
}
