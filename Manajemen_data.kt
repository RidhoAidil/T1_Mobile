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

    val lulus = mahasiswa.filter { it.nilai >= 70 }
    val tidakLulus = mahasiswa.filter { it.nilai < 70 }
    val rataRata = mahasiswa.map { it.nilai }.average()
    val tertinggi = mahasiswa.maxByOrNull { it.nilai }!!
    val terendah = mahasiswa.minByOrNull { it.nilai }!!
    val ascending = mahasiswa.sortedBy { it.nilai }
    val descending = mahasiswa.sortedByDescending { it.nilai }
    val groupGrade = mahasiswa.groupBy { getGrade(it.nilai) }

    println("Nama   : Muhammad Ridho AIdil Furqon")
    println("NIM    : F1D02310127")
    println("Kelas  : C")

    println("\n===== DATA NILAI MAHASISWA =====\n")
    println("${"No".padEnd(5)} ${"NIM".padEnd(10)} ${"Nama".padEnd(20)} ${"Mata Kuliah".padEnd(15)} Nilai")
    println("-".repeat(55))
    mahasiswa.forEachIndexed { i, m ->
        println("${(i + 1).toString().padEnd(5)} ${m.nim.padEnd(10)} ${m.nama.padEnd(20)} ${m.mataKuliah.padEnd(15)} ${m.nilai}")
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
    for (m in ascending)  println("${m.nama} - ${m.nilai} (${getGrade(m.nilai)})")

    println("\n===== URUT NILAI DESCENDING =====")
    for (m in descending) println("${m.nama} - ${m.nilai} (${getGrade(m.nilai)})")

    println("\n===== JUMLAH PER GRADE =====")
    val urutanGrade = listOf("A", "B", "C", "D", "E")
    for (grade in urutanGrade) {
        val jumlah = groupGrade[grade]?.size ?: 0
        println("Grade $grade: $jumlah mahasiswa")
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