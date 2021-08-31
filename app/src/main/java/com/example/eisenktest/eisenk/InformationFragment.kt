package com.example.eisenktest.eisenk

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.eisenktest.R
import kotlinx.android.synthetic.main.information_layout.*

class InformationFragment : Fragment(R.layout.information_layout) {
    private val safeArgs: InformationFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (0..24).forEach { i ->
            if (safeArgs.extravert <= 12 && safeArgs.neurotizm <= 12) {
                result.text = "Siz FLEGMATIKsiz"
                temperamentType.text =
                    "Flegmatiklar — vazmin kishilardir. Ular uchun shoshmaslik va bosiqlik o‘ta xos. Bunday odamlar murakkab hayotiy vaziyatlarda kamharakatchan bo‘lishsa-da, qo‘yilgan maqsadga erishishda ancha dadil bo‘lishadi. Bilimni sekinroq o‘zlashtirsalar ham, puxta egallashadi. Agar sangvinik alangaga o‘xshatilsa (u tez yonib, tezda so‘nadi), flegmatik sekin va uzoq yonadigan alangaga o‘xshaydi. Biror narsaga tez javob qilish kerak bo‘lsa, flegmatiklar vaqtni boy berib qo‘yadilar. Bunday paytlarda sangvinikning ustunligi sezilib turadi. Qat’iylik, iroda va sabr-toqat talab qilinadigan ishlarda esa flegmatik ustun keladi."
            } else if (safeArgs.extravert <= 12 && safeArgs.neurotizm <= 24 && safeArgs.neurotizm >= 12) {
                result.text = "Siz MELANXOLIKsiz"
                temperamentType.text =
                    "Melanxoliklar — g‘amgin, jur’atsiz va ma’yus kishilardir. Salga charchash, biror ishga yetarlicha jur’at etmaslik, o‘z fikr va istaklarini qondira olmaslik ular uchun juda xos. Melanxoliklar, ko‘pincha, arzimagan qiyinchiliklarga bardosh bera olmaydilar, ularga qarshi kurashdan voz kechadilar. Sangviniklar va flegmatiklar esa qiyinchiliklarni oson yengishadi, xoleriklar esa ularni xatto yo‘q qilib yuboradilar. Melanxoliklarda ijobiy his-tuyg‘ulardan salbiy his-tuyg‘ular ustunlik qiladi. Baxtli voqealardan ular zavqlana olmaydi, noxush voqealar esa ularni tushkunlikka tushirib qo‘yadi. Melanxoliklarning tashqi ko‘rinishi doimo tushkunlik va g‘amgin odamni eslatadi. Ular depressiyaga moyil bo‘lishadi"
            } else if (safeArgs.extravert >= 12 && safeArgs.extravert <= 24 && safeArgs.neurotizm <= 12) {
                result.text = "Siz SANGVINIKsiz"
                temperamentType.text =
                    "Sangviniklar — sho‘x, quvnoq, tirishqoq va ta’sirchan kishilardir. Ular tevarak-atrofga tez moslashadi. Reaksiyalari yetarlicha kuchli yoki o‘rtamiyona bo‘ladi. Ular bilimni tez va osongina o‘zlashtirsalar-da, hamma vaqt ham puxta egallamaydilar. Muomalada ular ko‘proq shirinsuxan, quvnoq va gapdon odamlardir. Sangviniklar ishga osongina berilib ketib, jadal ishlashga qodir bo‘lishadi, lekin muntazam ravishda doimiy mehnat qilishga ancha qiynaladilar. Shu bilan birga ular tirishqoq va faol bo‘lishadi, boshqa kishilar bilan osongina til topishadi."
            } else if (safeArgs.extravert >= 12 && safeArgs.extravert <= 24 && safeArgs.neurotizm <= 24 && safeArgs.neurotizm >= 12) {
                result.text = "Siz XOLERIKsiz"
                temperamentType.text =
                    "Xoleriklar — kuchli, chaqqon, jizzaki va harakatchan odamlardir. Ularning o‘ziga xos xususiyati — jizzakilik va beqarorlik. Xoleriklar juda faol va ishchan bo‘lishadi. Biroq ular bir maromda ishlay olishmaydi, goh g‘ayrat bilan, goh imillab ishlashadi. Shuning uchun ham ehtiyotkorlik, sabr-toqat va chidam talab qilinadigan vaziyatlarda xoleriklar qiyin ahvolga tushib qolishadi."
            }
        }
        restart.setOnClickListener {
            findNavController().navigate(R.id.action_informationFragment_to_startingTestFragment)
        }
    }
}