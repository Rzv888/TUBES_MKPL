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


            return this.suhu + 273;
        }else if(this.jenis_satuan_awal == "Fahrenheit"){

            return (5/9) * (this.suhu - 32) + 273;
        }else if (this.jenis_satuan_awal == "Kelvin"){
            return this.suhu;
        }
        return 0;

    }
    int getCelcius(){
        if (this.jenis_satuan_awal == "Celcius"){

            return this.suhu;
        }else if(this.jenis_satuan_awal == "Fahrenheit"){
            return (5/9) * this.suhu - 32;
        }else if (this.jenis_satuan_awal == "Kelvin"){
            
            return  this.suhu - 273;
        }
        return 0;

    }
    int getFahrenheit(){
        if (this.jenis_satuan_awal == "Celcius"){

            return (9/5)* this. suhu + 32;
        }else if(this.jenis_satuan_awal == "Fahrenheit"){
            return this.suhu;
        }else if (this.jenis_satuan_awal == "Kelvin"){
            return (9/5)*(this.suhu - 273) + 273;
        }
        return 0;
    }

    void  changeSuhu(int suhu, String jenis_satuan){
        this.suhu = suhu;
        this.jenis_satuan_awal = jenis_satuan;
    }

}
