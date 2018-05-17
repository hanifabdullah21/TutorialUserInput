package singpaulee.com.tutorialuserinput;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class HasilActivity extends AppCompatActivity {
    ImageView mIvGender;
    TextView mTvNama;
    TextView mTvJumlah;
    TextView mTvHargaSatuan;
    TextView mtvTotaHarga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        mIvGender = findViewById(R.id.iv_gender);
        mTvNama = findViewById(R.id.tv_nama);
        mTvJumlah = findViewById(R.id.tv_jumlah_pesan);
        mTvHargaSatuan = findViewById(R.id.tv_harga_satuan);
        mtvTotaHarga = findViewById(R.id.tv_total_harga);

        String nama = getIntent().getStringExtra("nama");
        String kelamin = getIntent().getStringExtra("kelamin");
        int hargaSatuan = getIntent().getIntExtra("hargaSatuan", 0);
        int hargaTotal = getIntent().getIntExtra("hargaTotal", 0);
        int jumlah = getIntent().getIntExtra("jumlah", 0);

        mTvNama.setText(""+nama);
        mTvHargaSatuan.setText(""+hargaSatuan);
        mtvTotaHarga.setText(""+hargaTotal);
        mTvJumlah.setText(""+jumlah);
        if (kelamin.equalsIgnoreCase("Laki-laki")){
            mIvGender.setImageResource(R.drawable.man);
        }else {
            mIvGender.setImageResource(R.drawable.women);
        }
    }

}
