package com.sahabatdeveloper.kk5_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class kuis extends AppCompatActivity {
    TextView pertanyaan;
    RadioGroup rg;
    RadioButton PilihanA, PilihanB, PilihanC, PilihanD;
    int nomor =0;
    public static int hasil,benar,salah;
    ImageButton x3;



    String[] pertanyaan_kuis = new String[]{
            "1. Ibukota Indonesia",
            "2. Presiden pertama",
            "3. Lambang negara",
            "4. Lagu Kebangsaan",
            "5. Bendera Indonesia"
    };
    String[] pilihan_jawaban = new String[]{
            "Jogja","Bandung","Jakarta","Makassar",
            "Soekarno","Soeharto","Habibie","Joko Widodo",
            "Elang Merah","Harimau","Komodo","Garuda Pancasila",
            "Indonesia merdeka","Majulah","Indonesia raya","Bhineka",
            "Putih abu","merah putih","Putih merah","biru","bintang",
};
    String[] jawaban_benar = new String[]{
            "Jakarta",
            "Soekarno",
            "Garuda Pancasila",
            "Indonesia raya",
            "merah putih",
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis);

        ImageButton x3 = (ImageButton)findViewById(R.id.x3);

        pertanyaan = (TextView)findViewById(R.id.pertanyaan);
        rg = (RadioGroup)findViewById(R.id.radio_group);
        PilihanA = (RadioButton) findViewById(R.id.pilihanA);
        PilihanB = (RadioButton) findViewById(R.id.pilihanB);
        PilihanC = (RadioButton) findViewById(R.id.pilihanC);
        PilihanD = (RadioButton) findViewById(R.id.pilihanD);

        pertanyaan.setText(pertanyaan_kuis[nomor]);
        PilihanA.setText(pilihan_jawaban[0]);
        PilihanB.setText(pilihan_jawaban[1]);
        PilihanC.setText(pilihan_jawaban[2]);
        PilihanD.setText(pilihan_jawaban[3]);

        rg.check(0);
        benar = 0;
        salah = 0;
        x3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void next(View view){
        if(PilihanA.isChecked()|| PilihanB.isChecked()||PilihanC.isChecked()||PilihanD.isChecked()){
        RadioButton jawaban_user = (RadioButton)findViewById(rg.getCheckedRadioButtonId());
        String ambil_jawaban_user = jawaban_user.getText().toString();
        rg.check(0);
        if(ambil_jawaban_user.equalsIgnoreCase(jawaban_benar[nomor]))benar++;
        else salah++;
        nomor++;
        if(nomor < pertanyaan_kuis.length){
            pertanyaan.setText(pertanyaan_kuis[nomor]);
            PilihanA.setText(pilihan_jawaban[(nomor*4)+0]);
            PilihanB.setText(pilihan_jawaban[(nomor*4)+1]);
            PilihanC.setText(pilihan_jawaban[(nomor*4)+2]);
            PilihanD.setText(pilihan_jawaban[(nomor*4)+3]);

        }else{
            hasil = benar * 20;
            Intent selesai = new Intent(getApplicationContext(), hasilkuis.class);
            startActivity(selesai);
        }

    }
    else{
            Toast.makeText(this, "Pilih Jawaban dulu",Toast.LENGTH_SHORT).show();
        }
    }

}
