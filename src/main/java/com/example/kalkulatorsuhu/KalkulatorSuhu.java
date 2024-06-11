package com.example.kalkulatorsuhu;

public class KalkulatorSuhu {

    public int suhu;
    public String jenis_satuan_awal;
    
    public KalkulatorSuhu(int suhu, String jenis_satuan){
        this.suhu = suhu;
        this.jenis_satuan_awal = jenis_satuan;
    }

    public int getKelvin(){
        if (this.jenis_satuan_awal == "Celcius"){


            return this.suhu + 273;
        }else if(this.jenis_satuan_awal == "Fahrenheit"){

            return (5/9) * (this.suhu - 32) + 273;
        }else if (this.jenis_satuan_awal == "Kelvin"){
            return this.suhu;
        }
        return 0;

    }
    public int getCelcius(){
        if (this.jenis_satuan_awal.equals("Celcius")) {
            return this.suhu;
        } else if (this.jenis_satuan_awal.equals("Fahrenheit")) {
            return (int) ((this.suhu - 32) * (5.0 / 9.0));
        } else if (this.jenis_satuan_awal.equals("Kelvin")) {
            return this.suhu - 273;
        }
        return 0;

    }
    public int getFahrenheit(){
        if (this.jenis_satuan_awal.equals("Celcius")) {
            return (int) ((9.0/5.0) * this.suhu + 32);
        } else if (this.jenis_satuan_awal.equals("Fahrenheit")) {
            return this.suhu;
        } else if (this.jenis_satuan_awal.equals("Kelvin")) {
            return (int) ((9.0/5.0) * (this.suhu - 273) + 32);
        }
        return 0;
    }

    public void  changeSuhu(int suhu, String jenis_satuan){
        this.suhu = suhu;
        this.jenis_satuan_awal = jenis_satuan;
    }

}
