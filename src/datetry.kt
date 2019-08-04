import java.util.*

fun main() {

    //simulasi bahwa install dana tuh 30 hari yang lalu
    val waktuPertamaInstallDana = Calendar.getInstance()
//    waktuPertamaInstallDana.timeInMillis = waktuPertamaInstallDana.timeInMillis - ( 86400000L * 30 )
    waktuPertamaInstallDana.timeInMillis = waktuPertamaInstallDana.timeInMillis


    //simulasi hari ini tuh 25 hari setelah pertama install dana, jadi 5 hari lagi harusnya skejulnya nyala
    val waktuSekarang = Calendar.getInstance()
//    waktuSekarang.timeInMillis = waktuSekarang.timeInMillis - ( 86400000L * 10 )
    waktuSekarang.timeInMillis = waktuSekarang.timeInMillis


    //eh kita nyalain hp nih, nah perlu skejul ulang kapan harusnya alarm ke trigger,
    //kita kalkulasi dari selisih hari waktu sekarang dengan waktu pertama install dana
    //kemudian jumlah hari tersebut di bagi dengan interval
    //kita akan dapat nilai magnitude yang akan dikalikan dengan interval hari
    //hasil perkalian itu akan ditambahkan dengan millis dari hari pertama install dana
    val intervalDay = 86400000
    val intervalConfig = 30
    val elapsedDay = ( waktuSekarang.timeInMillis - waktuPertamaInstallDana.timeInMillis ) / intervalDay.toDouble()
    println("Elapsed day " + elapsedDay)
    var magnitudeHasilKalkulasi = elapsedDay / intervalConfig
    println("Magnitude kalkulasi $magnitudeHasilKalkulasi")

    magnitudeHasilKalkulasi = Math.ceil(magnitudeHasilKalkulasi)

    val waktuBakalDiSkejul = Calendar.getInstance()
    waktuBakalDiSkejul.timeInMillis = waktuPertamaInstallDana.timeInMillis


    waktuBakalDiSkejul.timeInMillis = (waktuBakalDiSkejul.timeInMillis + ( 86400000L * 30 * magnitudeHasilKalkulasi)).toLong()
    println("Current ${waktuSekarang.get(Calendar.DAY_OF_YEAR)}")
    println("future ${waktuBakalDiSkejul.get(Calendar.DAY_OF_YEAR)}")
}