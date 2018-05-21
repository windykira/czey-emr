package com.haoze.utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 汉字格式化工具。
 *
 * @author maxl
 * @time 2018-05-13。
 */
public class ChineseCharactersCode {

    private static Properties wbCode;

    public static String getPinyinCode(String chineseCharacters) throws BadHanyuPinyinOutputFormatCombination {
        HanyuPinyinOutputFormat hypyfm = new HanyuPinyinOutputFormat();
        hypyfm.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        hypyfm.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        hypyfm.setVCharType(HanyuPinyinVCharType.WITH_V);

        char[] ch = chineseCharacters.toCharArray();
        StringBuilder simplePrint = new StringBuilder();
        for (int i = 0; i < ch.length; ++i) {
            String[] temp = PinyinHelper.toHanyuPinyinStringArray(ch[i], hypyfm);
            simplePrint.append(temp[0].charAt(0));
        }
        return simplePrint.toString();
    }

    public static Map<Character,String[]> getWuBiCode(String characters) {

        Map<Character,String[]> codeMap = new HashMap();
        int length = characters.length();
        for (int i = 0; i < length; i++) {
            char c = characters.charAt(i);
            if (c < 0x4E00 || c > 0x9FA5) {
                codeMap.put(c,null);
            }
            String result = wbCode.getProperty(Integer.toHexString(c).toUpperCase());
            if (result == null) {
                codeMap.put(c,null);
            }
            if (result.contains(",")) {
                codeMap.put(c,result.split(","));
            } else {
                codeMap.put(c,new String[]{result});
            }
        }
        return codeMap;
    }

    static {

        wbCode = new Properties();
        try {
            wbCode.load(new BufferedInputStream(ChineseCharactersCode.class.getResourceAsStream("/wbCode.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
