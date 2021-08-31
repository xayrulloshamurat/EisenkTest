package com.example.eisenktest.eisenk

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.eisenktest.R
import kotlinx.android.synthetic.main.result_layout.*

class ResultFragment : Fragment(R.layout.result_layout) {
    private val safeArgs: ResultFragmentArgs by navArgs()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var lieScore = false


        extravertItem.text = "Extrovert/Introvert:${safeArgs.extravert}"
        if (safeArgs.extravert >= 0 && safeArgs.extravert <= 10) {
            extravertInformation.text = "Siz introvertsiz, ichingizda yopiqsiz!"
        } else if (safeArgs.extravert >= 11 && safeArgs.extravert <= 14) {
            extravertInformation.text = "Siz ambivertsiz, kerak bo'lganda muloqot qilasiz"
        } else if (safeArgs.extravert >= 15 && safeArgs.extravert <= 24) {
            extravertInformation.text =
                "Siz ekstrovertsiz, chiquvchi, tashqi olam bilan tez kirishasiz"
        }

        neurotizmItem.text = "Neurotizm : ${safeArgs.neurotizm}"
        if (safeArgs.neurotizm >= 0 && safeArgs.neurotizm <= 10) {
            neurotizmInformation.text = "Sizda hissiy barqarorlik bor"
        } else if (safeArgs.neurotizm >= 11 && safeArgs.neurotizm <= 16) {
            neurotizmInformation.text = "Siz hissiyotlarga moyil , beriluvchan shaxssiz"
        } else if (safeArgs.neurotizm >= 17 && safeArgs.neurotizm <= 22) {
            neurotizmInformation.text = "Sizda asab tizimi chayqalishining individual belgilari bor"
        } else if (safeArgs.neurotizm >= 23 && safeArgs.neurotizm <= 24) {
            neurotizmInformation.text =
                "Sizda patalogiya bilan chegaralangan nevrotikizm, buzilish , nevroz bo'lishi mumkin"
        }
        lieItem.text = "Yolg'on shkalasi: ${safeArgs.lie}"
        if (safeArgs.lie >= 0 && safeArgs.lie <= 3) {
            lieInformation.text = "Javoblarga ishonish mumkin!"
            lieScore = true
        } else if (safeArgs.lie >= 4 && safeArgs.lie <= 5) {
            lieScore = true
            lieInformation.text =
                "Bergan javoblaringiz shubhali. Testni qaytadan ishlash tavsiya qilinadi"
        } else if (safeArgs.lie >= 6 && safeArgs.lie <= 9) {
            lieInformation.text =
                "Siz haqiqatni yolg'on bilan bezashga qiziqasiz. Testni qaytadan ishlang. Yolg'onlardan foydalanmang"
        }

        if (lieScore == true) {
            information.isVisible = true
        } else {
            information.isVisible = false
        }

        information.setOnClickListener {
            val actions = ResultFragmentDirections.actionResultFragmentToInformationFragment(
                safeArgs.extravert,
                safeArgs.neurotizm,
                safeArgs.lie
            )
            findNavController().navigate(actions)
        }


//        (0..24).forEach { i ->
//            if(safeArgs.extravert <= 12 && safeArgs.neurotizm <=12 ){
//                result.text = "FLEGMATIK"
//                temperamentType.text = "Flegmatiklar — vazmin kishilardir. Ular uchun shoshmaslik va bosiqlik o‘ta xos. Bunday odamlar murakkab hayotiy vaziyatlarda kamharakatchan bo‘lishsa-da, qo‘yilgan maqsadga erishishda ancha dadil bo‘lishadi. Bilimni sekinroq o‘zlashtirsalar ham, puxta egallashadi. Agar sangvinik alangaga o‘xshatilsa (u tez yonib, tezda so‘nadi), flegmatik sekin va uzoq yonadigan alangaga o‘xshaydi. Biror narsaga tez javob qilish kerak bo‘lsa, flegmatiklar vaqtni boy berib qo‘yadilar. Bunday paytlarda sangvinikning ustunligi sezilib turadi. Qat’iylik, iroda va sabr-toqat talab qilinadigan ishlarda esa flegmatik ustun keladi."
//            }else if(safeArgs.extravert <=12 && safeArgs.neurotizm <= 24 &&  safeArgs.neurotizm >= 12 ){
//                result.text = "MELANXOLIK"
//                temperamentType.text = "Melanxoliklar — g‘amgin, jur’atsiz va ma’yus kishilardir. Salga charchash, biror ishga yetarlicha jur’at etmaslik, o‘z fikr va istaklarini qondira olmaslik ular uchun juda xos. Melanxoliklar, ko‘pincha, arzimagan qiyinchiliklarga bardosh bera olmaydilar, ularga qarshi kurashdan voz kechadilar. Sangviniklar va flegmatiklar esa qiyinchiliklarni oson yengishadi, xoleriklar esa ularni xatto yo‘q qilib yuboradilar. Melanxoliklarda ijobiy his-tuyg‘ulardan salbiy his-tuyg‘ular ustunlik qiladi. Baxtli voqealardan ular zavqlana olmaydi, noxush voqealar esa ularni tushkunlikka tushirib qo‘yadi. Melanxoliklarning tashqi ko‘rinishi doimo tushkunlik va g‘amgin odamni eslatadi. Ular depressiyaga moyil bo‘lishadi"
//            }else if(safeArgs.extravert >=12 && safeArgs.extravert <=24 && safeArgs.neurotizm <= 12){
//                result.text = "SANGVINIK"
//                temperamentType.text = "Sangviniklar — sho‘x, quvnoq, tirishqoq va ta’sirchan kishilardir. Ular tevarak-atrofga tez moslashadi. Reaksiyalari yetarlicha kuchli yoki o‘rtamiyona bo‘ladi. Ular bilimni tez va osongina o‘zlashtirsalar-da, hamma vaqt ham puxta egallamaydilar. Muomalada ular ko‘proq shirinsuxan, quvnoq va gapdon odamlardir. Sangviniklar ishga osongina berilib ketib, jadal ishlashga qodir bo‘lishadi, lekin muntazam ravishda doimiy mehnat qilishga ancha qiynaladilar. Shu bilan birga ular tirishqoq va faol bo‘lishadi, boshqa kishilar bilan osongina til topishadi."
//            }else if(safeArgs.extravert >=12 && safeArgs.extravert <=24 && safeArgs.neurotizm <= 24 && safeArgs.neurotizm >= 12){
//                result.text = "XOLERIK"
//                temperamentType.text = "Xoleriklar — kuchli, chaqqon, jizzaki va harakatchan odamlardir. Ularning o‘ziga xos xususiyati — jizzakilik va beqarorlik. Xoleriklar juda faol va ishchan bo‘lishadi. Biroq ular bir maromda ishlay olishmaydi, goh g‘ayrat bilan, goh imillab ishlashadi. Shuning uchun ham ehtiyotkorlik, sabr-toqat va chidam talab qilinadigan vaziyatlarda xoleriklar qiyin ahvolga tushib qolishadi."
//            }
//        }
//        (0 .. 24).forEach { i ->
//            if(safeArgs.extravert >= 8 && safeArgs.extravert<=16 && safeArgs.neurotizm >=8 && safeArgs.neurotizm <= 16 && safeArgs.lie <=3) {
//                resultQuiz.text = "Siz imtihondan o'tdingiz!"
//            }else{
//                resultQuiz.text = "Siz imtihondan o'tmadingiz!"
//            }
//        }

    }
}
