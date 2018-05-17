package singpaulee.com.tutorialuserinput;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //TODO 1
    EditText mEdtNama;
    RadioGroup mRadioGrup;
    Button mBtnKurang;
    Button mBtnTambah;
    TextView mTvJumlah;
    TextView mTvHargaSatuan;
    TextView mTvHargaTotal;
    Button mBtnPesan;

    //TODO 3
    int jumlahPesan;
    int hargaTotal;
    int hargaSatuan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO 2
        mEdtNama = findViewById(R.id.edt_nama);
        mRadioGrup = findViewById(R.id.radiogrup);
        mBtnKurang = findViewById(R.id.btn_kurang);
        mBtnTambah = findViewById(R.id.btn_tambah);
        mBtnPesan = findViewById(R.id.btn_pesan);
        mTvJumlah = findViewById(R.id.tv_jumlah);
        mTvHargaSatuan = findViewById(R.id.tv_harga_satuan);
        mTvHargaTotal = findViewById(R.id.tv_harga_total);
        mBtnPesan = findViewById(R.id.btn_pesan);

        //TODO 4
        jumlahPesan = 0;
        hargaTotal = 0;
        hargaSatuan = 7000;

        //TODO 5
        mTvHargaSatuan.setText(""+hargaSatuan);
        mTvHargaTotal.setText(""+hargaTotal);
        mTvJumlah.setText(""+jumlahPesan);

        mBtnPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //do something
                pesanSekarang();
            }
        });

        mBtnKurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //do something
                kurangJumlah();
            }
        });

        mBtnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //do something
                tambahJumlah();
            }
        });

    }

    //Method ini berfungsi menambah jumlah pesanan
    private void tambahJumlah(){
        jumlahPesan = jumlahPesan + 1;      //tambah jumlah
        hargaTotal = jumlahPesan * hargaSatuan;

        mTvJumlah.setText(""+jumlahPesan);  //tampilkan pada textview
        mTvHargaTotal.setText(""+hargaTotal);
    }

    //Method ini berfungsi menambah jumlah pesanan
    private void kurangJumlah(){
        jumlahPesan = jumlahPesan - 1;     //kurang jumlah

        if (jumlahPesan>=0){
            jumlahPesan = 0;
            hargaTotal = jumlahPesan * hargaSatuan;
            mTvJumlah.setText(""+jumlahPesan);  //tampilkan pada textview
            mTvHargaTotal.setText(""+hargaTotal);
        }else {
            Toast.makeText(this, "Jumlah tidak boleh minus", Toast.LENGTH_SHORT).show();
        }
    }

    private void pesanSekarang(){
        String nama; //variabel untuk menampung 'nama' yang diinput pengguna
        String kelamin; //variabel yang digunakan untuk menampung 'kelamin' yang diinput pengguna

        //mendapatkan 'nama' hasil inputan pengguna
        nama = mEdtNama.getText().toString();

        //mendapatkan 'kelamin' hasil pilihan pengguna
        int radioDipilih = mRadioGrup.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) findViewById(radioDipilih);
        kelamin = radioButton.getText().toString();

        //pindah activity
        Intent intent = new Intent(MainActivity.this,HasilActivity.class);
        //kirim data ke activity tujuan
        intent.putExtra("nama",nama);
        intent.putExtra("kelamin",kelamin);
        intent.putExtra("hargaSatuan",hargaSatuan);
        intent.putExtra("hargaTotal",hargaTotal);
        intent.putExtra("jumlah",jumlahPesan);
        //jalan!
        startActivity(intent);
    }
}
