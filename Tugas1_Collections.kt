// data nilai mahasiswa yg berisi variabel nim, nama, matkul bertipe String dan nilai bertipe Integer
data class NilaiMahasiswa(
    val nim: String,
    val nama: String,
    val mataKuliah: String,
    val nilai: Int
)

// fungsi menentukan grade berdasarkan nilai
fun getGrade(nilai: Int): String {
    return when (nilai) {
        in 85..100 -> "A"
        in 70..84  -> "B"
        in 60..69  -> "C"
        in 50..59  -> "D"
        else       -> "E"
    }
}

fun main() {
    // list mahasiswa
    val mahasiswa = listOf(
        NilaiMahasiswa("2024001", "Jimmy Page", "Pemrograman", 97),
        NilaiMahasiswa("2024002", "Slash", "Pemrograman", 80),
        NilaiMahasiswa("2024003", "Bondan Prakoso", "Pemrograman", 67),
        NilaiMahasiswa("2024004", "Tom Morelo", "Pemrograman", 55),
        NilaiMahasiswa("2024005", "Lebah Ganteng", "Pemrograman", 73),
        NilaiMahasiswa("2024006", "Haikal Pembaik", "Pemrograman", 81),
        NilaiMahasiswa("2024007", "Hakam Ali", "Pemrograman", 77),
        NilaiMahasiswa("2024008", "Kurt Cobain", "Pemrograman", 93),
        NilaiMahasiswa("2024009", "Julian Casablancas", "Pemrograman", 95),
        NilaiMahasiswa("2024010", "David Gilmour", "Pemrograman", 41)
    )

    // variabel lulus, dinyatakan lulus jika nilai >= 70
    val lulus = mahasiswa.filter { it.nilai >= 70 }

    // variabel tidakLulus, dinyatakan tidak lulus jika nilai < 70
    val tidakLulus = mahasiswa.filter { it.nilai < 70 }

    // variabel rataRata, menghitung rata-rata nilai dengan fungsi average
    val rataRata = mahasiswa.map { it.nilai }.average()

    // variabel tertinggi, mencari mahasiswa dengan nilai tertinggi menggunakan fungsi maxByOrNull
    val tertinggi = mahasiswa.maxByOrNull { it.nilai }!!

    // variabel terendah, mencari mahasiswa dengan nilai terendah menggunakan fungsi minByOrNull
    val terendah = mahasiswa.minByOrNull { it.nilai }!!

    // variabel ascending, mengurutkan mahasiswa berdasarkan nilai dari yang terendah hingga tertinggi menggunakan fungsi sortedBy
    val ascending = mahasiswa.sortedBy { it.nilai }

    // variabel descending, mengurutkan mahasiswa berdasarkan nilai dari yang tertinggi hingga terendah menggunakan fungsi sortedByDescending
    val descending = mahasiswa.sortedByDescending { it.nilai }

    // variabel groupGrade, menentukan jumlah mahasiswa yang berada di grup grade yang sama
    val groupGrade = mahasiswa.groupBy { getGrade(it.nilai) }

    // identitas
    println("Nama   : Muhammad Ridho AIdil Furqon")
    println("NIM    : F1D02310127")
    println("Kelas  : C")

    // header
    println("\n===== DATA NILAI MAHASISWA =====\n")

    // padEnd untuk menambah jarak antar kata
    println("${"No".padEnd(5)} ${"NIM".padEnd(10)} ${"Nama".padEnd(20)} ${"Mata Kuliah".padEnd(15)} Nilai")

    // menampilkan list mahasiswa
    mahasiswa.forEachIndexed { i, m ->
        println("${(i + 1).toString().padEnd(5)} ${m.nim.padEnd(10)} ${m.nama.padEnd(20)} ${m.mataKuliah.padEnd(15)} ${m.nilai}")
    }

    // menampilkan statistik seluruh mahasiswa
    println("\n===== STATISTIK =====")
    println("Total Mahasiswa : ${mahasiswa.size}")
    println("Rata-rata Nilai : $rataRata")
    println("Nilai Tertinggi : ${tertinggi.nilai} (${tertinggi.nama})")
    println("Nilai Terendah  : ${terendah.nilai} (${terendah.nama})")

    // menampilkan mahasiswa yang LULUS berdasarkan nilai
    println("\n===== MAHASISWA LULUS =====")
    lulus.forEachIndexed { i, m ->
        println("${i + 1}. ${m.nama} - ${m.nilai} (${getGrade(m.nilai)})")
    }

    // menampilkan mahasiswa yang TIDAK LULUS berdasarkan nilai
    println("\n===== MAHASISWA TIDAK LULUS =====")
    tidakLulus.forEachIndexed { i, m ->
        println("${i + 1}. ${m.nama} - ${m.nilai} (${getGrade(m.nilai)})")
    }

    // menampilkan urutan mahasiswa secara ascending
    println("\n===== URUT NILAI ASCENDING =====")
    for (m in ascending)  println("${m.nama} - ${m.nilai} (${getGrade(m.nilai)})")

    // menampilkan urutan mahasiswa secara descending
    println("\n===== URUT NILAI DESCENDING =====")
    for (m in descending) println("${m.nama} - ${m.nilai} (${getGrade(m.nilai)})")

    // menampilkan jumlah mahasiswa yang berada pada grade yang sama
    println("\n===== JUMLAH PER GRADE =====")
    val urutanGrade = listOf("A", "B", "C", "D", "E")
    for (grade in urutanGrade) {
        val jumlah = groupGrade[grade]?.size ?: 0
        println("Grade $grade: $jumlah mahasiswa")
    }

    // input nama mahasiswa yang ingin dicara
    println("\n======== PENCARIAN ========")
    print("Nama Mahasiswa: ")
    val cari = readLine()

    // menamplkan hasil pencarian nama mahasiswa, yang berisi nim, nama, mata kuliah, nilai, dan grade
    println("\n===== HASIL PENCARIAN =====")
    val hasil = mahasiswa.filter { it.nama.contains(cari ?: "", ignoreCase = true) }
    if (hasil.isEmpty()) {
        println("Mahasiswa tidak ditemukan.")
    } else {
        for (m in hasil) println("${m.nim} - ${m.nama} - ${m.mataKuliah} - ${m.nilai} (${getGrade(m.nilai)})")
    }
}