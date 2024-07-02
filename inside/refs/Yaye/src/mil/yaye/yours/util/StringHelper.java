package mil.yaye.yours.util;

import java.util.Random;
import java.util.StringTokenizer;
import java.math.BigDecimal;

public class StringHelper {

    public static int getRound(double dSource) {
        int iRound;
        //BigDecimal�Ĺ��캯������������double
        BigDecimal deSource = new BigDecimal(dSource);
        //deSource.setScale(0,BigDecimal.ROUND_HALF_UP) ����ֵ���� BigDecimal
        //intValue() ������BigDecimalת��Ϊint
        iRound = deSource.setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
        return iRound;
    }

    /**
     * 6��С���ĺ˶ԡ�
     *
     * @param  field        С��
     * @return boolean      OK:true��NG:false
     * @throws null
     */
    public static boolean isFolat(String field) {
        int dotCount = 0;
        int plusCount = 0;
        int discountCount = 0;

        for (int i = 0; i < field.length(); i++) {
            if (field.charAt(i) >= '0' && field.charAt(i) <= '9') {
            } else if (field.charAt(i) == '.') {
                dotCount++;
            } else if (field.charAt(i) == '-') {
                discountCount++;
            } else if (field.charAt(i) == '+') {
                plusCount++;
            } else {
                return false;
            }
        }

        if (dotCount > 1 || plusCount > 1 || discountCount > 1) {
            return false;
        }

        if (field.indexOf("-") > 0) {
            return false;
        }
        if (field.indexOf("+") > 0) {
            return false;
        }

        Float decimal;
        try {
            decimal = Float.valueOf(field);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 7�������ĺ˶ԡ�
     *
     * @param  field                                ����
     * @return boolean                             OK:true��NG:false
     * @throws null
     */
    public static boolean isInt(String field) {

        try {
            Short.parseShort(field);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static int stringToInt(String num) {
        int i = 0;
        try {
            return Integer.parseInt(num);
        } catch (Exception ex) {
            return 0;
        }
    }

    /**
     * 1�����ֵĺ˶ԡ�
     *
     * @param  field                               ����
     * @return boolean                            OK:true��NG:false
     * @throws null
     */
    public static boolean isDigital(String field) {
        int MAXLENGTH = 256;
        if (field.getBytes().length > MAXLENGTH) {
            return false;
        }

        for (int i = 0; i < field.length(); i++) {
            if (field.charAt(i) < '0' || field.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    public static String getUnicode(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        byte abyte0[] = new byte[s.length()];
        for (int i = 0; i < s.length(); i++) {
            abyte0[i] = (byte) s.charAt(i);
        }

        return new String(abyte0);
    }

    public static String getAscii(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        char[] buffer = new char[s.length() * 2];

        char c;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 0x100) {
                c = s.charAt(i);
                byte[] buf = ("" + c).getBytes();
                buffer[j++] = (char) buf[0];
                buffer[j++] = (char) buf[1];
            } else {
                buffer[j++] = s.charAt(i);
            }
        }

        return new String(buffer, 0, j);
    }

    public static String nullToString(Object o) {
        if (o == null) {
            return "";
        } else {
            return o.toString();
        }
    }

    /**
     * ��������������ַ���,û������seed
     *
     * @param length ����ַ����ĳ���
     * @return ����ַ���
     */
    public static String randomString(int length) {
        Random random = new Random();
        StringBuffer buffer = new StringBuffer(length);
        int iRandom1;
        int iRandom2;
        for (int i = 0; i < length; i++) {
            iRandom1 = random.nextInt(4);
            if (iRandom1 != 3) {
                iRandom2 = random.nextInt(25);
                buffer.append((char) ('a' + iRandom2));
            } else {
                iRandom2 = random.nextInt(9);
                buffer.append((char) ('0' + iRandom2));
            }
        }
        return buffer.toString();

    }

    /**
     * ����ת��
     * @param strT
     * @return
     */
    public static String toGBKString(String strT) {
        try {
            if (strT == null) {
                return "";
            } else {
                strT = new String(strT.getBytes("ISO8859_1"), "GBK");
                return strT;
            }
        } catch (Exception e) {
            return "";
        }
    }


    public static String compositeString(String[] strAry, String split) {

        if (strAry == null || strAry.length == 0) {
            return "";
        }
        StringBuffer retBuffer = new StringBuffer();
        for (int i = 0; i < strAry.length; i++) {
            retBuffer.append(strAry[i]);
            retBuffer.append(split);
        }
        return retBuffer.toString();
    }

    public static int splitSignCount(String strSplit, String sign) {
        String endStr = strSplit.substring(strSplit.length() - sign.length(),
                                           strSplit.length());
        if (!endStr.equals(sign)) {
            strSplit += sign;
        }

        StringTokenizer ST = new StringTokenizer(strSplit, sign);
        return ST.countTokens();
    }

    public static boolean checkStringIndexOf(String strSplit, String sign) {
        int iPos1 = strSplit.lastIndexOf(sign);
        int iPos2 = strSplit.length();
        if (iPos1 > -1 && iPos1 < iPos2) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkEmail(String strSplit) { //���E_mail
        if (strSplit == null) {
            return false;
        } else if (strSplit.length() < 5) {
            return false;
        } else {
            int iPos1 = strSplit.lastIndexOf("@");
            int iPos2 = strSplit.lastIndexOf(".");
            int iPos3 = strSplit.length();
            if (iPos1 > -1 && iPos2 > -1 && iPos1 < iPos3 && iPos1 < iPos3 &&
                (iPos1 + 1) < iPos2) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static boolean checkTel(String tel) { //���绰
        if (tel == null) {
            return false;
        }
        String telInString = "0123456789/,;-";
        for (int i = 0; i < tel.length(); i++) {
            if (telInString.indexOf(String.valueOf(tel.charAt(i))) < 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkNumber(String tel) { //�������
        if (tel == null) {
            return false;
        }
        String telInString = "0123456789";
        for (int i = 0; i < tel.length(); i++) {
            if (telInString.indexOf(String.valueOf(tel.charAt(i))) < 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkLong(String tel) {
        if (tel == null) {
            return false;
        }
        String telInString = "0123456789";
        for (int i = 0; i < tel.length(); i++) {
            if (telInString.indexOf(String.valueOf(tel.charAt(i))) < 0) {
                return false;
            }
        }
        return true;
    }


    public static boolean checkChinaChar(String str) { //����Ƿ������ķ�
        if (str == null) {
            return false;
        }
        int str_length = str.length();
        byte[] bytearr = str.getBytes();
        int byte_length = bytearr.length;
        if (str_length == byte_length) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkMemberId(String tel) {
        if (tel == null) {
            return false;
        }
        String telInString =
                "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_";
        for (int i = 0; i < tel.length(); i++) {
            if (telInString.indexOf(String.valueOf(tel.charAt(i))) < 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkDate(String sdate) { //�������
        if (sdate.length() != 10) {
            return false;
        } else {
            if (sdate.charAt(4) != '-' || sdate.charAt(7) != '-') {
                return false;
            }
            String telInString = "0123456789-";
            for (int i = 0; i < sdate.length(); i++) {
                if (telInString.indexOf(String.valueOf(sdate.charAt(i))) < 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public static String delNull(String content) {
        if (content == null) {
            return "";
        } else {
            return content.trim();
        }
    }

    public static int checkLength(String str, int leng) { //�����ַ�������
        if (str == null) {
            return 0;
        }
        int str_length = str.length();
        byte[] bytearr = str.getBytes();
        int byte_length = bytearr.length;
        if (byte_length > leng) {
            return (byte_length - leng + 2) / 2;
        } else {
            return -1;
        }
    }

    public static String readeRank(String str) {
        try {
            java.util.HashMap hashMapPope = new java.util.HashMap();
            hashMapPope.put("0", "��ѻ�Ա");
            hashMapPope.put("1", "��ͨ��Ա");
            hashMapPope.put("2", "����ͨ��Ա");
            hashMapPope.put("3", "���ʽ��ƹ�Ӧ��");
            if (hashMapPope.get(str) != null) {
                return hashMapPope.get(str).toString();
            } else {
                return "����֪";
            }
        } catch (Exception e) {
            return "����֪";
        }
    }

    public static String readeBizState(String str) { //��ҵ��Ϣ״̬
        try {
            java.util.HashMap hashMapPope = new java.util.HashMap();
            hashMapPope.put("0", "δ���");
            hashMapPope.put("1", "���ͨ��");
            hashMapPope.put("2", "���δͨ��");
            hashMapPope.put("3", "�ط�ͨ��");
            hashMapPope.put("4", "�ѳ���");
            hashMapPope.put("9", "��ɾ��");
            if (hashMapPope.get(str) != null) {
                return hashMapPope.get(str).toString();
            } else {
                return "����֪";
            }
        } catch (Exception e) {
            return "����֪";
        }
    }

    public static String readeNETState(String str) { //��ҵ���š���ҵ�˲š���ҵ���� ��״̬
        try {
            java.util.HashMap hashMapPope = new java.util.HashMap();
            hashMapPope.put("0", "δ���");
            hashMapPope.put("1", "���ͨ��");
            hashMapPope.put("2", "���δͨ��");
            hashMapPope.put("3", "�ط�ͨ��");
            hashMapPope.put("4", "�ѳ���");
            hashMapPope.put("8", "����ɾ��");
            hashMapPope.put("9", "��Աɾ��");
            if (hashMapPope.get(str) != null) {
                return hashMapPope.get(str).toString();
            } else {
                return "����֪";
            }
        } catch (Exception e) {
            return "����֪";
        }
    }

    public static String readeFileState(String str) {
        try {
            java.util.HashMap hashMapPope = new java.util.HashMap();
            hashMapPope.put("", "δע��");
            hashMapPope.put("0", "δ���");
            hashMapPope.put("1", "���ͨ��");
            hashMapPope.put("2", "���δͨ��");
            if (hashMapPope.get(str) != null) {
                return hashMapPope.get(str).toString();
            } else {
                return "����֪";
            }
        } catch (Exception e) {
            return "����֪";
        }
    }

    public static String returnLengthStr(String str, int length) {
        try {
            if (str == null) {
                return "";
            }
            int len = str.length();
            if (len > length) {
                str = str.substring(0, length) + "...";
            }
            return str;
        } catch (Exception e) {
            return "";
        }
    }

    public static String getLimitLengthString(int len, String str) {
        int iLen = len * 2;
        int counterOfDoubleByte = 0;
        String strRet = "";
        if (str == null) {
            return "";
        }
        try {
            byte[] b = str.getBytes("GBK");
            if (b.length <= iLen) {
                return str;
            }
            for (int i = 0; i < iLen; i++) {
                if (b[i] < 0) {
                    counterOfDoubleByte++;
                }
            }
            if (counterOfDoubleByte % 2 == 0) {
                strRet = new String(b, 0, iLen, "GBK");
                return strRet;
            } else {
                strRet = new String(b, 0, iLen - 1, "GBK");
                return strRet;
            }
        } catch (Exception ex) {
            return str.substring(0, len);
        } finally {
            strRet = null;
        }
    }

    public static String toHtml(String str) {
        try {
            str = str.replaceAll(" ", "&nbsp;");
            str = str.replaceAll("\\r\\n", "<br>");
        } catch (Exception e) {

        }
        return str;
    }

}
