package com.example.kalkulatorsuhu;

public class KalkulatorSuhu {

    int suhu;
    String jenis_satuan_awal;
    
    KalkulatorSuhu(int suhu, String jenis_satuan){
        this.suhu = suhu;
        this.jenis_satuan_awal = jenis_satuan;
    }

    int getKelvin(){
        if (this.jenis_satuan_awal == "Celcius"){

            return 0;
        }else if(this.jenis_satuan_awal == "Kelvin"){
            return 0;
        }
        return 0;

    }
    int getCelcius(){
        return 0;

    }
    int getFahrenheit(){
        return 0;
    }

    void  changeSuhu(int suhu, String jenis_satuan){
        this.suhu = suhu;
        this.jenis_satuan_awal = jenis_satuan;
    }

}
