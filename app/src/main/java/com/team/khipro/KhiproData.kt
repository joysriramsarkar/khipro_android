package com.team.khipro

object KhiproData {
    val SHOR = mapOf(
        "o" to "অ", "a" to "আ", "i" to "ই", "ii" to "ঈ", "u" to "উ", "uu" to "ঊ", "q" to "ঋ", "e" to "এ", "wi" to "ঐ", "w" to "ও", "wu" to "ঔ", "ae" to "অ্যা",
        "wa" to "ওয়া", "wae" to "ওয়্যা", "we" to "ওয়ে", "ooo" to "অঃ", "off" to "ঽ",
    )

    val FKAR = mapOf(
        "uff" to "‌ু", "uuff" to "‌ূ", "qff" to "‌ৃ", "of" to "ঽ", "af" to "া", "if" to "ি", "iif" to "ী", "uf" to "ু", "uuf" to "ূ", "qf" to "ৃ", "ef" to "ে", "wif" to "ৈ", "wf" to "ো", "wuf" to "ৌ", "aef" to "্যা", "waf" to "োয়া", "wef" to "োয়ে", "oo" to "ঃ",
    )

    val BYANJON = mapOf(
        "k" to "ক", "kh" to "খ", "g" to "গ", "gh" to "ঘ", "ng" to "ঙ",
        "c" to "চ", "ch" to "ছ", "j" to "জ", "jh" to "ঝ", "nff" to "ঞ",
        "tf" to "ট", "tff" to "ঠ", "df" to "ড", "dff" to "ঢ", "nf" to "ণ",
        "t" to "ত", "th" to "থ", "d" to "দ", "dh" to "ধ", "n" to "ন",
        "p" to "প", "ph" to "ফ", "b" to "ব", "v" to "ভ", "m" to "ম",
        "z" to "য", "r" to "র", "l" to "ল", "sh" to "শ", "sf" to "ষ", "s" to "স", "h" to "হ",
        "y" to "য়", "rf" to "ড়", "rff" to "ঢ়", ",," to "়", "kf" to "ক্ষ", "zf" to "্য",
    )

    val JUKTOBORNO = mapOf(
        "kk" to "ক্ক", "kkh" to "ক্ষ", "ktf" to "ক্ট", "kt" to "ক্ত", "kb" to "ক্ব", "km" to "ক্ম", "ksf" to "ক্ষ", "kl" to "ক্ল", "ks" to "ক্স", "kf" to "ক্ষ",
        "gg" to "জ্ঞ", "gnf" to "গ্‌ণ", "gdh" to "গ্ধ", "gn" to "গ্ন", "gb" to "গ্‌ব", "gm" to "গ্ম", "gl" to "গ্ল",
        "ghn" to "ঘ্ন",
        "ngk" to "ঙ্ক", "ngkh" to "ঙ্খ", "ngg" to "ঙ্গ", "nggh" to "ঙ্ঘ", "ngm" to "ঙ্ম", "ngkf" to "ঙ্ক্ষ",
        "cc" to "চ্চ", "cch" to "চ্ছ", "cnff" to "চ্ঞ", "cb" to "চ্ব",
        "jj" to "জ্জ", "jjh" to "জ্ঝ", "jnff" to "জ্ঞ", "jb" to "জ্ব",
        "nffc" to "ঞ্চ", "nffch" to "ঞ্ছ", "nffj" to "ঞ্জ", "nffjh" to "ঞ্ঝ",
        "tftf" to "ট্ট", "tfb" to "ট্ব", "tfm" to "ট্ম",
        "dfdf" to "ড্ড", "dfb" to "ড্ব",
        "nftf" to "ণ্ট", "nftff" to "ণ্ঠ", "nfdf" to "ণ্ড", "nfdff" to "ণ্ঢ", "nfnf" to "ণ্ণ", "nfn" to "ণ্ণ", "nfb" to "ণ্ব", "nfm" to "ণ্ম",
        "ttf" to "ট্ট", "tt" to "ত্ত", "tth" to "ত্থ", "tn" to "ত্ন", "tb" to "ত্ব", "tm" to "ত্ম",
        "thb" to "থ্ব",
        "dg" to "দ্‌গ", "dgh" to "দ্‌ঘ", "ddf" to "ড্ড", "dd" to "দ্দ", "ddh" to "দ্ধ", "db" to "দ্ব", "dv" to "দ্ভ", "dm" to "দ্ম",
        "dhn" to "ধ্ন", "dhb" to "ধ্ব", "dhm" to "ধ্ম",
        "nc" to "ঞ্চ", "nch" to "ঞ্ছ", "nj" to "ঞ্জ", "njh" to "ঞ্ঝ", "ntf" to "ন্ট", "ntff" to "ন্ঠ", "ndf" to "ন্ড", "nnf" to "ণ্ণ", "nt" to "ন্ত", "nth" to "ন্থ", "nd" to "ন্দ", "ndh" to "ন্ধ", "nn" to "ন্ন", "nb" to "ন্ব", "nm" to "ন্ম", "ns" to "ন্স",
        "ptf" to "প্ট", "pt" to "প্ত", "pn" to "প্ন", "pp" to "প্প", "pl" to "প্ল", "ps" to "প্স",
        "phl" to "ফ্ল",
        "bj" to "ব্জ", "bd" to "ব্দ", "bdh" to "ব্ধ", "bb" to "ব্ব", "bl" to "ব্ল",
        "vb" to "ভ্ব", "vl" to "ভ্ল",
        "mn" to "ম্ন", "mp" to "ম্প", "mph" to "ম্ফ", "mb" to "ম্ব", "mv" to "ম্ভ", "mm" to "ম্ম", "ml" to "ম্ল",
        "lk" to "ল্ক", "lg" to "ল্গ", "ltf" to "ল্ট", "ldf" to "ল্ড", "lp" to "ল্প", "lph" to "ল্ফ", "lb" to "ল্ব", "lv" to "ল্‌ভ", "lm" to "ল্ম", "ll" to "ল্ল",
        "shc" to "শ্চ", "shch" to "শ্ছ", "shn" to "শ্ন", "shb" to "শ্ব", "shm" to "শ্ম", "shl" to "শ্ল",
        "sfk" to "ষ্ক", "sftf" to "ষ্ট", "sftff" to "ষ্ঠ", "sfnf" to "ষ্ণ", "sfn" to "ষ্ণ", "sfp" to "ষ্প", "sfph" to "ষ্ফ", "sfb" to "ষ্ব", "sfm" to "ষ্ম",
        "sk" to "স্ক", "skh" to "স্খ", "stf" to "স্ট", "st" to "স্ত", "sth" to "স্থ", "sn" to "স্ন", "sp" to "স্প", "sph" to "স্ফ", "sb" to "স্ব", "sm" to "স্ম", "sl" to "স্ল",
        "hnf" to "হ্ণ", "hn" to "হ্ন", "hb" to "হ্ব", "hm" to "হ্ম", "hl" to "হ্ল",
        "rfg" to "ড়্‌গ",
        "kfnf" to "ক্ষ্ণ", "kfn" to "ক্ষ্ণ", "kfb" to "ক্ষ্ব", "kfm" to "ক্ষ্ম",
        "rzf" to "র‍্য", "rz" to "র‍্য", "rrr" to "র্র",
        "ggg" to "গ্‌গ", "ngkkh" to "ঙ্ক্ষ", "ngksf" to "ঙ্ক্ষ", "ngkt" to "ঙ্‌ক্ত", "cchb" to "চ্ছ্ব", "jjb" to "জ্জ্ব", "ttb" to "ত্ত্ব", "ddb" to "দ্দ্ব", "ntb" to "ন্ত্ব", "ndb" to "ন্দ্ব", "stb" to "স্ত্ব", "spl" to "স্প্ল", "nstf" to "নস্ট", "mpl" to "মপ্ল",
    )

    val PHOLA = mapOf("r" to "র", "z" to "য")

    val REPH = mapOf("rr" to "র্", "r" to "র")

    val KAR = mapOf(
        "o" to "", "of" to "অ", "off" to "ঽ", "a" to "া", "af" to "আ", "i" to "ি", "if" to "ই", "ii" to "ী", "iif" to "ঈ", "u" to "ু", "uf" to "উ", "uu" to "ূ", "uuf" to "ঊ",
        "q" to "ৃ", "qf" to "ঋ", "e" to "ে", "ef" to "এ", "wi" to "ৈ", "wif" to "োই", "w" to "ো", "wf" to "ও", "wu" to "ৌ", "wuf" to "োউ", "ae" to "্যা", "aef" to "অ্যা",
        "uff" to "‌ু", "uuff" to "‌ূ", "qff" to "‌ৃ", "we" to "োয়ে", "wef" to "ওয়ে", "waf" to "ওয়া", "wa" to "োয়া", "wae" to "ওয়্যা", "oo" to "ঃ",
    )

    val ONGKO = mapOf(
        ".1" to ".১", ".2" to ".২", ".3" to ".৩", ".4" to ".৪", ".5" to ".৫", ".6" to ".৬", ".7" to ".৭", ".8" to ".৮", ".9" to ".৯", ".0" to ".০",
        "1" to "১", "2" to "২", "3" to "৩", "4" to "৪", "5" to "৫", "6" to "৬", "7" to "৭", "8" to "৮", "9" to "৯", "0" to "০",
    )

    val DIACRITIC = mapOf(
        "qq" to "্", "xx" to "্‌", "x" to "ং", "t/" to "ৎ", "/" to "ঁ", "//" to "/",
    )

    val BIRAM = mapOf(
        "." to "।", "..." to "...", ".." to ".", "$" to "৳", (("$" + "f")) to "₹", ",,," to ",,", ".f" to "॥", ".ff" to "৺",
        "+" to "+", "-" to "-", "=" to "=", "+f" to "×", "-f" to "÷", "=f" to "≠", "$$" to "$",
        "।f" to "॥", "।ff" to "৺",
    )

    val PRITHAYOK = mapOf(";" to ";")
    val AE = mapOf("ae" to "‍্যা")

    val GROUP_MAPS = mapOf(
        "shor" to SHOR, "fkar" to FKAR, "byanjon" to BYANJON, "juktoborno" to JUKTOBORNO, "reph" to REPH,
        "phola" to PHOLA, "kar" to KAR, "ongko" to ONGKO, "diacritic" to DIACRITIC, "biram" to BIRAM, "prithayok" to PRITHAYOK, "ae" to AE,
    )

    val STATE_GROUP_ORDER = mapOf(
        "init" to listOf("diacritic", "shor", "fkar", "prithayok", "ongko", "biram", "juktoborno", "reph", "byanjon"),
        "shor-state" to listOf("diacritic", "shor", "fkar", "biram", "prithayok", "ongko", "juktoborno", "reph", "byanjon"),
        "reph-state" to listOf("prithayok", "diacritic", "ae", "juktoborno", "byanjon", "kar"),
        "byanjon-state" to listOf("diacritic", "prithayok", "ongko", "biram", "kar", "juktoborno", "phola", "byanjon"),
    )

    val MAXLEN_PER_GROUP = GROUP_MAPS.mapValues { (_, map) -> map.keys.maxByOrNull { it.length }?.length ?: 0 }
}
