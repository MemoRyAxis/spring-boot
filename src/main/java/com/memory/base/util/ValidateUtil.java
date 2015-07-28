package com.memory.base.util;

import java.util.regex.Pattern;

import org.springframework.util.StringUtils;

public class ValidateUtil {

  public static final String BANK_CARD = "^[0-9]{16,19}$";
  public static final String MOBILE = "^[1][3,4,5,7,8][0-9]{9}$";
  public static final String PHONE = "^[0][1-9][0-9]{1,2}-[0-9]{5,10}$";
  public static final String PHONE_WITHOUT_ZONE = "^[1-9]{1}[0-9]{5,8}$";

  private static final Pattern BANK_CARD_PATTERN = Pattern.compile(BANK_CARD);
  private static final Pattern MOBILE_PATTERN = Pattern.compile(MOBILE);
  private static final Pattern PHONE_PATTERN = Pattern.compile(PHONE);
  private static final Pattern PHONE_WITHOUT_ZONE_PATTERN = Pattern.compile(PHONE_WITHOUT_ZONE);

  /**
   * verify whether the string given is a bank card number
   * 
   */
  public static boolean isBankCard(String bankCard) {
    if (!BANK_CARD_PATTERN.matcher(bankCard).matches()) {
      return false;
    }

    char bit = getBankCardCheckCode(bankCard.substring(0, bankCard.length() - 1));
    if (bit == 'N') {
      return false;
    }
    return bankCard.charAt(bankCard.length() - 1) == bit;
  }

  /**
   * luhn algorithm
   */
  private static char getBankCardCheckCode(String nonCheckCodeCardId) {
    if (nonCheckCodeCardId == null || nonCheckCodeCardId.trim().length() == 0
        || !nonCheckCodeCardId.matches("\\d+")) {
      return 'N';
    }
    char[] chs = nonCheckCodeCardId.trim().toCharArray();
    int luhmSum = 0;
    for (int i = chs.length - 1, j = 0; i >= 0; i--, j++) {
      int k = chs[i] - '0';
      if (j % 2 == 0) {
        k *= 2;
        k = k / 10 + k % 10;
      }
      luhmSum += k;
    }
    return (luhmSum % 10 == 0) ? '0' : (char) ((10 - luhmSum % 10) + '0');
  }

  /**
   * verify whether the string given is a mobile number
   * 
   */
  public static boolean isMobile(String mobile) {
    if (StringUtils.isEmpty(mobile)) return false;
    return MOBILE_PATTERN.matcher(mobile).matches();
  }

  /**
   * verify whether the string given is a phone number
   * 
   */
  public static boolean isPhone(String phone) {
    if (StringUtils.isEmpty(phone)) return false;
    boolean isMatch = false;
    if (phone.length() > 9) {
      isMatch = PHONE_PATTERN.matcher(phone).matches();
    } else {
      isMatch = PHONE_WITHOUT_ZONE_PATTERN.matcher(phone).matches();
    }
    return isMatch;
  }
}
