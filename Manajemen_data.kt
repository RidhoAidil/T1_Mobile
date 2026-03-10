data class NilaiMahasiswa(
    val nim: String,
    val nama: String,
    val mataKuliah: String,
    val nilai: Int
)

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
    val mahasiswa = listOf(
        NilaiMahasiswa("2024001", "Budi Santoso",  "Pemrograman", 85),
        NilaiMahasiswa("2024002", "Ani Wijaya",    "Pemrograman", 92),
        NilaiMahasiswa("2024003", "Citra Dewi",    "Pemrograman", 68),
        NilaiMahasiswa("2024004", "Dani Pratama",  "Pemrograman", 45),
        NilaiMahasiswa("2024005", "Eka Putri",     "Pemrograman", 74),
        NilaiMahasiswa("2024006", "Fajar Hadi",    "Pemrograman", 88),
        NilaiMahasiswa("2024007", "Gina Lestari",  "Pemrograman", 55),
        NilaiMahasiswa("2024008", "Hadi Saputra",  "Pemrograman", 63),
        NilaiMahasiswa("2024009", "Indra Kurnia",  "Pemrograman", 90),
        NilaiMahasiswa("2024010", "Joko Susilo",   "Pemrograman", 72)
    )

    var total = 0
    var tertinggi = mahasiswa[0]
    var terendah  = mahasiswa[0]
    val lulus      = mutableListOf<NilaiMahasiswa>()
    val tidakLulus = mutableListOf<NilaiMahasiswa>()

    for (m in mahasiswa) {
        total += m.nilai
        if (m.nilai > tertinggi.nilai) tertinggi = m
        if (m.nilai < terendah.nilai)  terendah  = m
        if (m.nilai >= 70) lulus.add(m) else tidakLulus.add(m)
    }

    // Fix: rataRata dihitung SETELAH loop, bukan sebelumnya
    val rataRata   = total.toDouble() / mahasiswa.size
    val ascending  = mahasiswa.sortedBy { it.nilai }
    val descending = mahasiswa.sortedByDescending { it.nilai }
    val groupGrade = mahasiswa.groupBy { getGrade(it.nilai) }

    println("===== DATA NILAI MAHASISWA =====\n")
    println("${"No".padEnd(5)} ${"NIM".padEnd(10)} ${"Nama".padEnd(15)} ${"Mata Kuliah".padEnd(15)} Nilai")
    mahasiswa.forEachIndexed { i, m ->
        println("${(i + 1).toString().padEnd(5)} ${m.nim.padEnd(10)} ${m.nama.padEnd(15)} ${m.mataKuliah.padEnd(15)} ${m.nilai}")
    }

    println("\n===== STATISTIK =====")
    println("Total Mahasiswa : ${mahasiswa.size}")
    println("Rata-rata Nilai : $rataRata")
    println("Nilai Tertinggi : ${tertinggi.nilai} (${tertinggi.nama})")
    println("Nilai Terendah  : ${terendah.nilai} (${terendah.nama})")

    println("\n===== MAHASISWA LULUS =====")
    lulus.forEachIndexed { i, m ->
        println("${i + 1}. ${m.nama} - ${m.nilai} (${getGrade(m.nilai)})")
    }

    println("\n===== MAHASISWA TIDAK LULUS =====")
    tidakLulus.forEachIndexed { i, m ->
        println("${i + 1}. ${m.nama} - ${m.nilai} (${getGrade(m.nilai)})")
    }

    println("\n===== URUT NILAI ASCENDING =====")
    for (m in ascending)  println("${m.nama} - ${m.nilai}")

    println("\n===== URUT NILAI DESCENDING =====")
    for (m in descending) println("${m.nama} - ${m.nilai}")

    println("\n===== JUMLAH PER GRADE =====")
    for ((grade, list) in groupGrade) {
        println("Grade $grade: ${list.size} mahasiswa")
    }

    println("\n======== PENCARIAN ========")
    print("Nama Mahasiswa: ")
    val cari = readLine()

    println("\n===== HASIL PENCARIAN =====")
    val hasil = mahasiswa.filter { it.nama.contains(cari ?: "", ignoreCase = true) }

    if (hasil.isEmpty()) {
        println("Mahasiswa tidak ditemukan.")
    } else {
        for (m in hasil) println("${m.nama} - ${m.nilai} (${getGrade(m.nilai)})")
    }
}