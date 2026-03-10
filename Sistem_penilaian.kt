fun main() {
    // identitas
    println("Nama   : Muhammad Ridho AIdil Furqon")
    println("NIM    : F1D02310127")
    println("Kelas  : C")

    // header
    println("\n===== SISTEM PENILAIAN =====\n")

    // form masukkan nama
    print("Masukkan Nama Mahasiswa: ")
    val nama = readLine()!!

    // form masukkan nilai uts menggunakan toInt supaya tipe data dari nilai uts berubah menjadi integer
    print("Masukkan Nilai UTS (0-100): ")
    val uts = readLine()!!.toInt()

    // form masukkan nilai uas menggunakan toInt supaya tipe data dari nilai uas berubah menjadi integer
    print("Masukkan Nilai UAS (0-100): ")
    val uas = readLine()!!.toInt()

    // form masukkan nilai tugas menggunakan toInt supaya tipe data dari nilai tugas berubah menjadi integer
    print("Masukkan Nilai Tugas(0-100): ")
    val tugas = readLine()!!.toInt()

    // membuat variabel nilaiAkhir yang menghitung nilai akhir dengan menambahkan hasil kali bobot dengan nilai uts, uas, dan tugas
    val nilaiAkhir = (uts * 0.3) + (uas * 0.4) + (tugas * 0.3)

    //membuat variabel status yang jika nilai lebih dari sama dengan 60 dinyatakan LULUS, selain dari itu dinyatakan TIDAK LULUS
    val status = if (nilaiAkhir >= 60) "LULUS" else "TIDAK LULUS"

    // variabel grade dan keterangan yang bertipe String
    var grade = ""
    var keterangan = ""

    // aturan penilaian
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

    // print saja supaya mirip di contoh output
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

    // ini juga sama, bedanya disini ada if else yang dimana jika nilai akhir >= 60 maka akan mengeluarkan kalimat "Selamat! Anda dinyatakan LULUS.", selain dari itu akan mengeluarkan kalimat "Mohon maaf! Anda dinyatakan TIDAK LULUS"
    if (nilaiAkhir >= 60) {
        print("\nSelamat! Anda dinyatakan LULUS.")
    } else print("\nMohon maaf! Anda dinyatakan TIDAK LULUS.")
}