package com.team.khipro

object KhiproData {
    val SHOR = mapOf(
        "o" to "অ", "a" to "আ", "i" to "ই", "ii" to "ঈ", "u" to "উ", "uu" to "ঊ", "q" to "ঋ", "e" to "এ", "oi" to "ঐ", "w" to "ও", "ou" to "ঔ", "ae" to "অ্যা",
        "wa" to "ওয়া", "wae" to "ওয়্যা", "we" to "ওয়ে", "ooo" to "অং", "oof" to "ঽ",
    )

    val FKAR = mapOf(
        "fuf" to "‌ু", "fuuf" to "‌ূ", "fqf" to "‌ৃ",
        "fa" to "া", "fi" to "ি", "fii" to "ী", "fu" to "ু", "fuu" to "ূ",
        "fq" to "ৃ", "fe" to "ে", "foi" to "ৈ", "fw" to "ো", "fou" to "ৌ",
        "fae" to "্যা", "fwa" to "োয়া", "fwe" to "োয়ে", "oo" to "ং"
    )

    val BYANJON = mapOf(
        "k" to "ক", "kh" to "খ", "g" to "গ", "gh" to "ঘ", "ngf" to "ঙ",
        "c" to "চ", "ch" to "ছ", "j" to "জ", "jh" to "ঝ", "nff" to "ঞ",
        "tf" to "ট", "tff" to "ঠ", "df" to "ড", "dff" to "ঢ", "nf" to "ণ",
        "t" to "ত", "th" to "থ", "d" to "দ", "dh" to "ধ", "n" to "ন",
        "p" to "প", "ph" to "ফ", "b" to "ব", "v" to "ভ", "m" to "ম",
        "z" to "য", "l" to "ল", "sh" to "শ", "sf" to "ষ", "s" to "স", "h" to "হ",
        "y" to "য়", "rf" to "ড়", "rff" to "ঢ়", ",," to "়"
    )

    val JUKTOBORNO = mapOf(
        "rz" to "র‍্য", "kk" to "ক্ক", "ktf" to "ক্ট", "ktfr" to "ক্ট্র", "kt" to "ক্ত", "ktr" to "ক্ত্র", "kb" to "ক্ব", "km" to "ক্ম", "kz" to "ক্য", "kr" to "ক্র", "kl" to "ক্ল",
        "kf" to "ক্ষ", "ksf" to "ক্ষ", "kkh" to "ক্ষ", "kfnf" to "ক্ষ্ণ", "kfn" to "ক্ষ্ণ", "ksfnf" to "ক্ষ্ণ", "ksfn" to "ক্ষ্ণ", "kkhn" to "ক্ষ্ণ", "kkhnf" to "ক্ষ্ণ", "kfb" to "ক্ষ্ব", "ksfb" to "ক্ষ্ব", "kkhb" to "ক্ষ্ব", "kfm" to "ক্ষ্ম",
        "kkhm" to "ক্ষ্ম", "ksfm" to "ক্ষ্ম", "kfz" to "ক্ষ্য", "ksfz" to "ক্ষ্য", "kkhz" to "ক্ষ্য", "ks" to "ক্স", "khz" to "খ্য", "khr" to "খ্র",
        "ggg" to "গ্গ", "gnf" to "গ্‌ণ", "gdh" to "গ্ধ", "gdhz" to "গ্ধ্য", "gdhr" to "গ্ধ্র", "gn" to "গ্ন", "gnz" to "গ্ন্য", "gb" to "গ্ব", "gm" to "গ্ম", "gz" to "গ্য", "gr" to "গ্র", "grz" to "গ্র্য", "gl" to "গ্ল",
        "ghn" to "ঘ্ন", "ghr" to "ঘ্র",
        "ngk" to "ঙ্ক", "ngkt" to "ঙ্‌ক্ত", "ngkz" to "ঙ্ক্য", "ngkr" to "ঙ্ক্র", "ngkf" to "ঙ্ক্ষ", "ngkkh" to "ঙ্ক্ষ", "ngksf" to "ঙ্ক্ষ", "ngkh" to "ঙ্খ", "ngg" to "ঙ্গ", "nggz" to "ঙ্গ্য", "nggh" to "ঙ্ঘ", "ngghz" to "ঙ্ঘ্য", "ngghr" to "ঙ্ঘ্র", "ngm" to "ঙ্ম",
        "ngfk" to "ঙ্ক", "ngfkt" to "ঙ্‌ক্ত", "ngfkz" to "ঙ্ক্য", "ngfkr" to "ঙ্ক্র", "ngfkf" to "ঙ্ক্ষ", "ngfkkh" to "ঙ্ক্ষ", "ngfksf" to "ঙ্ক্ষ", "ngfkh" to "ঙ্খ", "ngfg" to "ঙ্গ", "ngfgz" to "ঙ্গ্য", "ngfgh" to "ঙ্ঘ", "ngfghz" to "ঙ্ঘ্য", "ngfghr" to "ঙ্ঘ্র", "ngfm" to "ঙ্ম",
        "cc" to "চ্চ", "cch" to "চ্ছ", "cchb" to "চ্ছ্ব", "cchr" to "চ্ছ্র", "cnff" to "চ্ঞ", "cb" to "চ্ব", "cz" to "চ্য", "jj" to "জ্জ", "jjb" to "জ্জ্ব", "jjh" to "জ্ঝ", "gg" to "জ্ঞ", "jnff" to "জ্ঞ", "jb" to "জ্ব", "jz" to "জ্য", "jr" to "জ্র",
        "nc" to "ঞ্চ", "nffc" to "ঞ্চ", "nj" to "ঞ্জ", "nffj" to "ঞ্জ", "njh" to "ঞ্ঝ", "nffjh" to "ঞ্ঝ", "nch" to "ঞ্ছ", "nffch" to "ঞ্ছ", "ttf" to "ট্ট", "tftf" to "ট্ট", "tfb" to "ট্ব", "tfm" to "ট্ম", "tfz" to "ট্য", "tfr" to "ট্র",
        "ddf" to "ড্ড", "dfdf" to "ড্ড", "dfb" to "ড্ব", "dfz" to "ড্য", "dfr" to "ড্র", "rfg" to "ড়্‌গ", "dffz" to "ঢ্য", "dffr" to "ঢ্র",
        "nftf" to "ণ্ট", "nftff" to "ণ্ঠ", "nftffz" to "ণ্ঠ্য", "nfdf" to "ণ্ড", "nfdfz" to "ণ্ড্য", "nfdfr" to "ণ্ড্র", "nfdff" to "ণ্ঢ", "nfnf" to "ণ্ণ", "nfn" to "ণ্ণ", "nfb" to "ণ্ব", "nfm" to "ণ্ম", "nfz" to "ণ্য",
        "tt" to "ত্ত", "ttb" to "ত্ত্ব", "ttz" to "ত্ত্য", "tth" to "ত্থ", "tn" to "ত্ন", "tb" to "ত্ব", "tm" to "ত্ম", "tmz" to "ত্ম্য", "tz" to "ত্য", "tr" to "ত্র", "trz" to "ত্র্য", "thb" to "থ্ব", "thz" to "থ্য", "thr" to "থ্র",
        "dg" to "দ্‌গ", "dgh" to "দ্‌ঘ", "dd" to "দ্দ", "ddb" to "দ্দ্ব", "ddh" to "দ্ধ", "db" to "দ্ব", "dv" to "দ্ভ", "dvr" to "দ্ভ্র", "dm" to "দ্ম", "dz" to "দ্য", "dr" to "দ্র", "drz" to "দ্র্য",
        "dhn" to "ধ্ন", "dhb" to "ধ্ব", "dhm" to "ধ্ম", "dhz" to "ধ্য", "dhr" to "ধ্র",
        "ntf" to "ন্ট", "ntfr" to "ন্ট্র", "ntff" to "ন্ঠ", "ndf" to "ন্ড", "ndfr" to "ন্ড্র", "nt" to "ন্ত", "ntb" to "ন্ত্ব", "ntr" to "ন্ত্র", "ntrz" to "ন্ত্র্য", "nth" to "ন্থ", "nthr" to "ন্থ্র", "nd" to "ন্দ", "ndb" to "ন্দ্ব", "ndz" to "ন্দ্য",
        "ndr" to "ন্দ্র", "ndh" to "ন্ধ", "ndhz" to "ন্ধ্য", "ndhr" to "ন্ধ্র", "nn" to "ন্ন", "nb" to "ন্ব", "nm" to "ন্ম", "nz" to "ন্য", "ns" to "ন্স",
        "ptf" to "প্ট", "pt" to "প্ত", "pn" to "প্ন", "pp" to "প্প", "pz" to "প্য", "pr" to "প্র", "pl" to "প্ল", "ps" to "প্স", "phr" to "ফ্র", "phl" to "ফ্ল", "bj" to "ব্জ", "bd" to "ব্দ", "bdh" to "ব্ধ", "bb" to "ব্ব", "bz" to "ব্য", "br" to "ব্র", "bl" to "ব্ল", "vb" to "ভ্ব", "vz" to "ভ্য", "vr" to "ভ্র", "vl" to "ভ্ল",
        "mn" to "ম্ন", "mp" to "ম্প", "mpr" to "ম্প্র", "mph" to "ম্ফ", "mb" to "ম্ব", "mbr" to "ম্ব্র", "mv" to "ম্ভ", "mvr" to "ম্ভ্র", "mm" to "ম্ম", "mz" to "ম্য", "mr" to "ম্র", "ml" to "ম্ল", "zz" to "য্য",
        "lk" to "ল্ক", "lkz" to "ল্ক্য", "lg" to "ল্গ", "ltf" to "ল্ট", "ldf" to "ল্ড", "lp" to "ল্প", "lph" to "ল্ফ", "lb" to "ল্ব", "lv" to "ল্‌ভ", "lm" to "ল্ম", "lz" to "ল্য", "ll" to "ল্ল",
        "shc" to "শ্চ", "shch" to "শ্ছ", "shn" to "শ্ন", "shb" to "শ্ব", "shm" to "শ্ম", "shz" to "শ্য", "shr" to "শ্র", "shl" to "শ্ল",
        "sfk" to "ষ্ক", "sfkr" to "ষ্ক্র", "sftf" to "ষ্ট", "sftfz" to "ষ্ট্য", "sftfr" to "ষ্ট্র", "sftff" to "ষ্ঠ", "sftffz" to "ষ্ঠ্য", "sfnf" to "ষ্ণ", "sfn" to "ষ্ণ", "sfp" to "ষ্প", "sfpr" to "ষ্প্র", "sfph" to "ষ্ফ", "sfb" to "ষ্ব", "sfm" to "ষ্ম", "sfz" to "ষ্য",
        "sk" to "স্ক", "skr" to "স্ক্র", "skh" to "স্খ", "stf" to "স্ট", "stfr" to "স্ট্র", "st" to "স্ত", "stb" to "স্ত্ব", "stz" to "স্ত্য", "str" to "স্ত্র", "sth" to "স্থ", "sthz" to "স্থ্য", "sn" to "স্ন", "sp" to "স্প", "spr" to "স্প্র", "spl" to "স্প্ল", "sph" to "স্ফ", "sb" to "স্ব", "sm" to "স্ম", "sz" to "স্য", "sr" to "স্র", "sl" to "স্ল",
        "hn" to "হ্ন", "hnf" to "হ্ণ", "hb" to "হ্ব", "hm" to "হ্ম", "hz" to "হ্য", "hr" to "হ্র", "hl" to "হ্ল",
        "ksh" to "কশ", "kks" to "কক্স", "nsh" to "নশ", "psh" to "পশ", "ld" to "লদ", "gd" to "গদ", "ngkk" to "ঙ্কক", "ngks" to "ঙ্কস", "ngfkk" to "ঙ্কক", "ngfks" to "ঙ্কস",
        "cn" to "চন", "cngf" to "চঙ", "cnz" to "চন্য", "cnf" to "চণ", "cnm" to "চন্ম", "cngk" to "চঙ্ক", "cngkt" to "চঙ্‌ক্ত", "cngkz" to "চঙ্ক্য", "cngkr" to "চঙ্ক্র", "cngkf" to "চঙ্ক্ষ", "cngkkh" to "চঙ্ক্ষ", "cngksf" to "চঙ্ক্ষ", "cngkh" to "চঙ্খ", "cngg" to "চঙ্গ", "cnggz" to "চঙ্গ্য", "cnggh" to "চঙ্ঘ", "cngghz" to "চঙ্ঘ্য", "cngghr" to "চঙ্ঘ্র", "cngm" to "চঙ্ম",
        "cngfk" to "চঙ্ক", "cngfkt" to "চঙ্‌ক্ত", "cngfkz" to "চঙ্ক্য", "cngfkr" to "চঙ্ক্র", "cngfkf" to "চঙ্ক্ষ", "cngfkkh" to "চঙ্ক্ষ", "cngfksf" to "চঙ্ক্ষ", "cngfkh" to "চঙ্খ", "cngfg" to "চঙ্গ", "cngfgz" to "চঙ্গ্য", "cngfgh" to "চঙ্ঘ", "cngfghz" to "চঙ্ঘ্য", "cngfghr" to "চঙ্ঘ্র", "cngfm" to "চঙ্ম",
        "cnc" to "চঞ্চ", "cnffc" to "চঞ্চ", "cnj" to "চঞ্জ", "cnffj" to "চঞ্জ", "cnjh" to "চঞ্ঝ", "cnffjh" to "চঞ্ঝ", "cnch" to "চঞ্ছ", "cnffch" to "চঞ্ছ",
        "cnftf" to "চণ্ট", "cnftff" to "চণ্ঠ", "cnftffz" to "চণ্ঠ্য", "cnfdf" to "চণ্ড", "cnfdfz" to "চণ্ড্য", "cnfdfr" to "চণ্ড্র", "cnfdff" to "চণ্ঢ", "cnfnf" to "চণ্ণ", "cnfn" to "চণ্ণ", "cnfb" to "চণ্ব", "cnfm" to "চণ্ম", "cnfz" to "চণ্য",
        "cntf" to "চন্ট", "cntfr" to "চন্ট্র", "cntff" to "চণ্ঠ", "cndf" to "চণ্ড", "cndfr" to "চণ্ড্র", "cnt" to "চন্ত", "cntb" to "চন্ত্ব", "cntr" to "চন্ত্র", "cntrz" to "চন্ত্র্য", "cnth" to "চন্থ", "cnthr" to "চন্থ্র", "cnd" to "চন্দ", "cndb" to "চন্দ্ব", "cndz" to "চন্দ্য",
        "cndr" to "চন্দ্র", "cndh" to "চন্ধ", "cndhz" to "চন্ধ্য", "cndhr" to "চন্ধ্র", "cnn" to "চন্ন", "cnb" to "চন্ব", "cns" to "চন্স",
        "cnft" to "চণত", "cnfd" to "চণদ", "cnfth" to "চণথ", "cnfdh" to "চণধ", "cndff" to "চনঢ",
        "cngkth" to "চঙ্কথ", "cngkrf" to "চঙ্কড়", "cngkrff" to "চঙ্কঢ়", "cngghrf" to "চঙ্ঘড়", "cngghrff" to "চঙ্ঘঢ়", "cngfkth" to "চঙ্কথ", "cngfkrf" to "চঙ্কড়", "cngfkrff" to "চঙ্কঢ়", "cngfghrf" to "চঙ্ঘড়", "cngfghrff" to "চঙ্ঘঢ়",
        "cnfdfrf" to "চণ্ডড়", "cnfdfrff" to "চণ্ডঢ়", "jntfrf" to "জন্টড়", "jntfrff" to "জন্টঢ়", "jndfrf" to "জন্ডড়", "jndfrff" to "জন্ডঢ়", "jntrf" to "জন্তড়", "jntrff" to "জন্তঢ়", "jnthrf" to "জন্থড়",
        "jnstf" to "জন্স্ট", "jnst" to "জন্স্ত", "jnsk" to "জন্স্ক", "jnthrff" to "জন্থঢ়", "jndrf" to "জন্দড়", "jndrff" to "জন্দড়", "jndhrf" to "জন্ধড়", "jndhrff" to "জন্ধঢ়", "jngksh" to "জঙ্কশ", "jngfksh" to "জঙ্কশ",
        "tft" to "টত", "dfd" to "ডদ", "nft" to "ণত", "nfd" to "ণদ", "lt" to "লত", "sft" to "ষত", "nfth" to "ণথ", "nfdh" to "ণধ", "sfth" to "ষথ", "ktff" to "কঠ", "ptff" to "পঠ", "ltff" to "লঠ", "stff" to "সঠ",
        "dfdff" to "ডঢ", "ndff" to "নঢ", "ktfrf" to "ক্টড়", "ktfrff" to "ক্টঢ়", "kth" to "কথ", "ktrf" to "ক্তড়", "ktrff" to "ক্তঢ়", "krf" to "কড়", "krff" to "কঢ়", "khrf" to "খড়", "khrff" to "খঢ়", "gggh" to "জ্ঞঘ", "gdff" to "গঢ", "gdhrf" to "গ্ধড়",
        "gdhrff" to "গ্ধঢ়", "grf" to "গড়", "grff" to "গঢ়", "ghrf" to "ঘড়", "ghrff" to "ঘঢ়", "ngkth" to "ঙ্কথ", "ngkrf" to "ঙ্কড়", "ngkrff" to "ঙ্কঢ়", "ngghrf" to "ঙ্ঘড়", "ngghrff" to "ঙ্ঘঢ়", "cchrf" to "চ্ছড়", "cchrff" to "চ্ছঢ়",
        "ngfkth" to "ঙ্কথ", "ngfkrf" to "ঙ্কড়", "ngfkrff" to "ঙ্কঢ়", "ngfghrf" to "ঙ্ঘড়", "ngfghrff" to "ঙ্ঘঢ়", "tfrf" to "টড়", "tfrff" to "টঢ়", "dfrf" to "ডড়", "dfrff" to "ডঢ়", "rfgh" to "ড়ঘ", "dffrf" to "ঢড়", "dffrff" to "ঢঢ়",
        "nfdfrf" to "ণ্ডড়", "nfdfrff" to "ণ্ডঢ়", "trf" to "তড়", "trff" to "তঢ়", "thrf" to "থড়", "thrff" to "থঢ়", "dvrf" to "দ্ভড়", "dvrff" to "দ্ভঢ়", "drf" to "দড়", "drff" to "দঢ়", "dhrf" to "ধড়", "dhrff" to "ধঢ়",
        "ntfrf" to "ন্টড়", "ntfrff" to "ন্টঢ়", "ndfrf" to "ন্ডড়", "ndfrff" to "ন্ডঢ়", "ntrf" to "ন্তড়", "ntrff" to "ন্তঢ়", "nthrf" to "ন্থড়", "nstf" to "নস্ট", "nst" to "নস্ত", "nsk" to "নস্ক", "nthrff" to "ন্থঢ়", "ndrf" to "ন্দড়", "ndrff" to "ন্দঢ়", "ndhrf" to "ন্ধড়", "ndhrff" to "ন্ধঢ়",
        "pth" to "পথ", "pph" to "পফ", "prf" to "পড়", "prff" to "পঢ়", "phrf" to "ফড়", "phrff" to "ফঢ়", "bjh" to "বঝ", "brf" to "বড়", "brff" to "বঢ়", "mpl" to "মপ্ল", "vrf" to "ভড়", "vrff" to "ভঢ়", "mprf" to "ম্পড়", "mprff" to "ম্পঢ়", "mbrf" to "ম্বড়", "mbrff" to "ম্বঢ়", "mvrf" to "ম্ভড়", "mvrff" to "ম্ভঢ়", "mrf" to "মড়", "mrff" to "মঢ়", "lkh" to "লখ", "lgh" to "লঘ", "shrf" to "শড়", "shrff" to "শঢ়", "sfkh" to "ষখ",
        "sfkrf" to "ষ্কড়", "sfkrff" to "ষ্কঢ়", "sftfrf" to "ষ্টড়", "sftfrff" to "ষ্টঢ়", "sfprf" to "ষ্পড়", "sfprff" to "ষ্পঢ়", "skrf" to "স্কড়", "skrff" to "স্কঢ়", "stfrf" to "স্টড়", "stfrff" to "স্টঢ়", "strf" to "স্তড়", "strff" to "স্তঢ়", "sprf" to "স্পড়", "sprff" to "স্পঢ়",
        "srf" to "সড়", "srff" to "সঢ়", "hrf" to "হড়", "hrff" to "হঢ়", "ldh" to "লধ", "ngksh" to "ঙ্কশ", "tfth" to "টথ", "dfdh" to "ডধ", "lth" to "লথ", "ngfksh" to "ঙ্কশ", "lks" to "ল্কস",
        "kkf" to "কক্ষ", "lkf" to "লক্ষ", "sfkf" to "ষক্ষ", "skf" to "সক্ষ", "kkkh" to "কক্ষ", "lkkh" to "লক্ষ", "sfkkh" to "ষক্ষ", "skkh" to "সক্ষ", "kksf" to "কক্ষ", "lksf" to "লক্ষ", "sfksf" to "ষক্ষ", "sksf" to "সক্ষ", "yr" to "য়র",
        "gnj" to "গঞ্জ", "pnj" to "পঞ্জ", "mnj" to "মঞ্জ", "snj" to "সঞ্জ", "gndf" to "গন্ড", "mndf" to "মন্ড", "tnt" to "তন্ত", "tntr" to "তন্ত্র", "mnt" to "মন্ত", "mntr" to "মন্ত্র", "snt" to "সন্ত", "sntr" to "সন্ত্র", "hnt" to "হন্ত",
        "tnd" to "তন্দ", "nnd" to "নন্দ", "mnd" to "মন্দ", "snd" to "সন্দ", "gndh" to "গন্ধ", "gndhz" to "গন্ধ্য", "sndh" to "সন্ধ", "sndhz" to "সন্ধ্য"
    )

    val PHOLA = mapOf("r" to "র", "z" to "য")

    val NG = mapOf(
        "ng" to "ং", "gng" to "গং", "ghng" to "ঘং", "cng" to "চং", "jng" to "জং", "nng" to "নং", "nfng" to "ণং", "tng" to "তং", "dhng" to "ধং", "png" to "পং", "mng" to "মং", "shng" to "শং", "sfng" to "ষং", "sng" to "সং", "hng" to "হং", "kfng" to "ক্ষং", "kkhng" to "ক্ষং", "ksfng" to "ক্ষং",
        "ngo" to "ঙ", "nga" to "ঙা", "ngi" to "ঙি", "ngii" to "ঙী", "ngu" to "ঙু", "nguff" to "ঙ‌ু", "nguu" to "ঙূ", "nguuff" to "ঙ‌ূ", "ngq" to "ঙৃ", "ngqff" to "ঙ‌ৃ", "nge" to "ঙে", "ngoi" to "ঙৈ", "ngw" to "ঙো", "ngou" to "ঙৌ", "ngae" to "ঙ্যা",
        "ngof" to "ঙঅ", "ngaf" to "ঙআ", "ngif" to "ঙই", "ngiif" to "ঙঈ", "nguf" to "ঙউ", "nguuf" to "ঙঊ", "ngqf" to "ঙঋ", "ngef" to "ঙএ", "ngoif" to "ঙঐ", "ngwf" to "ঙও", "ngouf" to "ঙঔ", "ngaef" to "ঙঅ্যা"
    )

    val REPH = mapOf("rr" to "র্", "r" to "র")

    val KAR = mapOf(
        "o" to "", "of" to "অ", "oof" to "ঽ", "a" to "া", "af" to "আ", "i" to "ি", "if" to "ই", "ii" to "ী", "iif" to "ঈ", "u" to "ু", "uf" to "উ", "uu" to "ূ", "uuf" to "ঊ",
        "q" to "ৃ", "qf" to "ঋ", "e" to "ে", "ef" to "এ", "oi" to "ৈ", "oif" to "ঐ", "w" to "ো", "wf" to "ও", "ou" to "ৌ", "ouf" to "ঔ", "ae" to "্যা", "aef" to "অ্যা",
        "uff" to "‌ু", "uuff" to "‌ূ", "qff" to "‌ৃ", "we" to "োয়ে", "wef" to "ওয়ে", "waf" to "ওয়া", "wa" to "োয়া", "wae" to "ওয়্যা", "oo" to "ং"
    )

    val ONGKO = mapOf(
        ".1" to ".১", ".2" to ".২", ".3" to ".৩", ".4" to ".৪", ".5" to ".৫", ".6" to ".৬", ".7" to ".৭", ".8" to ".৮", ".9" to ".৯", ".0" to ".০",
        "1" to "১", "2" to "২", "3" to "৩", "4" to "৪", "5" to "৫", "6" to "৬", "7" to "৭", "8" to "৮", "9" to "৯", "0" to "০"
    )

    val DIACRITIC = mapOf(
        "qq" to "্", "xx" to "্‌", "t/" to "ৎ", "x" to "ঃ", "/" to "ঁ", "//" to "/", "`" to "`", "``" to "‌", "```" to "``", "~" to "~", "~~" to "‍", "~~~" to "~~"
    )

    val BIRAM = mapOf(
        "." to "।", "..." to "...", ".." to ".", "$" to "৳", "\$f" to "₹", ",,," to ",,", ".f" to "॥", ".ff" to "৺",
        "+" to "+", "-" to "-", "=" to "=", "+f" to "×", "-f" to "÷", "=f" to "≠", "$$" to "$"
    )

    val PRITHAYOK = mapOf(";" to "", ";;" to ";")
    val AE = mapOf("ae" to "‍্যা")

    val GROUP_MAPS = mapOf(
        "shor" to SHOR, "fkar" to FKAR, "byanjon" to BYANJON, "juktoborno" to JUKTOBORNO, "ng" to NG, "reph" to REPH,
        "phola" to PHOLA, "kar" to KAR, "ongko" to ONGKO, "diacritic" to DIACRITIC, "biram" to BIRAM, "prithayok" to PRITHAYOK, "ae" to AE
    )

    val STATE_GROUP_ORDER = mapOf(
        "init" to listOf("diacritic", "ng", "shor", "fkar", "prithayok", "ongko", "biram", "reph", "juktoborno", "byanjon"),
        "shor-state" to listOf("diacritic", "ng", "shor", "fkar", "biram", "prithayok", "ongko", "reph", "juktoborno", "byanjon"),
        "reph-state" to listOf("prithayok", "diacritic", "ng", "ae", "juktoborno", "byanjon", "kar"),
        "byanjon-state" to listOf("diacritic", "ng", "prithayok", "ongko", "biram", "kar", "juktoborno", "phola", "byanjon")
    )

    val MAXLEN_PER_GROUP = GROUP_MAPS.mapValues { (_, map) -> map.keys.maxByOrNull { it.length }?.length ?: 0 }
}
