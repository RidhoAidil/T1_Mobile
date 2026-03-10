fun main() {
    println("Nama   : Muhammad Ridho AIdil Furqon")
    println("NIM    : F1D02310127")
    println("Kelas  : C")
    println("\n===== SISTEM PENILAIAN =====\n")
    print("Masukkan Nama Mahasiswa: ")
    val nama = readLine()!!
    print("Masukkan Nilai UTS: ")
    val uts = readLine()!!.toInt()
    print("Masukkan Nilai UAS: ")
    val uas = readLine()!!.toInt()
    print("Masukkan Nilai Tugas: ")
    val tugas = readLine()!!.toInt()

    val nilaiAkhir = (uts * 0.3) + (uas * 0.4) + (tugas * 0.3)
    val status = if (nilaiAkhir >= 60) "LULUS" else "TIDAK LULUS"

    var grade = ""
    var keterangan = ""

    when (nilaiAkhir.toInt()) {
        in 85..100 -> {
            grade = "A"
            keterangan = "Sangat Baik"
        }
        in 70..84 -> {
            grade = "B"
            keterangan = "Baik"
        }
        in 60..69 -> {
            grade = "C"
            keterangan = "Cukup"
        }
        in 50..59 -> {
            grade = "D"
            keterangan = "Kurang"
        }
        else -> {
            grade = "E"
            keterangan = "Sangat Kurang"
        }
    }

    println("\n===== HASIL PENILAIAN =====")
    println("Nama         : $nama")
    println("Nilai UTS    : $uts (Bobot 30%)")
    println("Nilai UAS    : $uas (Bobot 40%)")
    println("Nilai Tugas  : $tugas (Bobot 30%)")
    println("--------------------------------")
    println("Nilai Akhir  : $nilaiAkhir")
    println("Grade        : $grade")
    println("Keterangan   : $keterangan")
    println("Status       : $status")

    if (nilaiAkhir >= 60) {
        print("\nSelamat! Anda dinyatakan LULUS")
    } else print("\nMohon maaf! Anda dinyatakan TIDAK LULUS")
}