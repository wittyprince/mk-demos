package com.mk.demos.logging.converter;

import ch.qos.logback.classic.pattern.MessageConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

/**
 * Sensitive converter
 * 日志脱敏过滤器
 *
 * @author WangChen
 * Created on 2023/6/2
 * @since 1.0
 */
public class SensitiveConverter extends MessageConverter {

    private final Logger logger = LoggerFactory.getLogger(SensitiveConverter.class);

    //"(\\1[3|4|5|7|8][0-9]\\d{8}[^\\d])|(^1[3|4|5|7|8][0-9]\\d{8})[^\\d]|([^\\d]1[3|4|5|7|8][0-9]\\d{8}[^\\d])";
    private static final String PHONE_REGEX = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\\\d{8}$";
    private static final String IDCARD_REGEX = "[^\\d]([1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx])[^\\d]|[^\\d](^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3})[^\\d]";
    private static final String KEY = "axedfqLGpu";

    /**
     * TODO
     * 思路是这个思路, 但是, 具体实现需要再验证
     *
     * 还有一种需求是在输出控制台进行过滤，这种需求可以通过layout方式来处理
     *
     */
    @Override
    public String convert(ILoggingEvent event) {
        // 获取原始日志
        String requestLogMsg = event.getFormattedMessage();
        // 获取返回脱敏后的日志
        return filterSensitive(requestLogMsg);
    }

    /**
     * 对敏感信息脱敏
     */
    private static String filterSensitive(String content) {
        try {
            if (StringUtils.isBlank(content)) {
                return content;
            }
            content = filterIdcard(content);
            content = filterMobile(content);
            return content;
        } catch (Exception e) {
            return content;
        }
    }

    /**
     * 身份证号脱敏
     */
    private static String filterIdcard(String num) {

        Pattern pattern = Pattern.compile(IDCARD_REGEX);
        Matcher matcher = pattern.matcher(num);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, baseSensitive(matcher.group(), 4, 4));
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    /**
     * 手机号码脱敏
     */
    private static String filterMobile(String num) {
        Pattern pattern = Pattern.compile(PHONE_REGEX);
        Matcher matcher = pattern.matcher(num);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, baseSensitive(matcher.group(), 3, 4));
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

//    private static String filterMobile(String msg) {
//
//        StringBuilder sb = new StringBuilder(msg);
//        Pattern pattern = Pattern.compile(PHONE_REGEX);
//        Matcher matcher = pattern.matcher(sb);
//        while (matcher.find()) {
//            IntStream.rangeClosed(1, matcher.groupCount()).forEach(group -> {
//                if (matcher.group(group) != null) {
//                    IntStream.range(matcher.start(group), matcher.end(group)).forEach(i -> sb.setCharAt(i, '*'));
//                }
//            });
//        }
//        return sb.toString();
//    }

    /**
     * 基础脱敏处理 指定起止展示长度 剩余用"KEY"中字符替换
     *
     * @param str         待脱敏的字符串
     * @param startLength 开始展示长度
     * @param endLength   末尾展示长度
     * @return 脱敏后的字符串
     */
    private static String baseSensitive(String str, int startLength, int endLength) {
        if (StringUtils.isBlank(str)) {
            return "";
        }
        String replacement = str.substring(startLength, str.length() - endLength);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < replacement.length(); i++) {
            char ch;
            if (replacement.charAt(i) >= '0' && replacement.charAt(i) <= '9') {
                ch = KEY.charAt(replacement.charAt(i) - '0');
            } else {
                ch = replacement.charAt(i);
            }
            sb.append(ch);
        }
        return StringUtils.left(str, startLength).concat(StringUtils.leftPad(StringUtils.right(str, endLength), str.length() - startLength, sb.toString()));
    }

    /**
     * 按"KEY"中字符解密
     */
    private static String decrypt(String str, int startLength, int endLength) {
        if (StringUtils.isBlank(str)) {
            return "";
        }
        String replacement = str.substring(startLength, str.length() - endLength);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < replacement.length(); i++) {
            int index = KEY.indexOf(replacement.charAt(i));
            if (index != -1) {
                sb.append(index);
            } else {
                sb.append(replacement.charAt(i));
            }
        }
        return StringUtils
                .left(str, startLength)
                .concat(StringUtils.leftPad(StringUtils.right(str, endLength), str.length() - startLength, sb.toString()));
    }

}
