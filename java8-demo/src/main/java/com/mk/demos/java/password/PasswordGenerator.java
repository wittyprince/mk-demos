package com.mk.demos.java.password;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 随机生成含有指定字符的密码串
 *
 * @author WangChen
 * Created on 2019/11/14 17:37
 * @since 1.0
 */
public class PasswordGenerator {

    public static final char[] allowedSpecialCharacters = {
            '`', '~', '@', '#', '$', '%', '^', '&',
            '*', '(', ')', '-', '_', '=', '+', '[',
            '{', '}', ']', '\\', '|', ';', ':', '"',
            '\'', ',', '<', '.', '>', '/', '?'};//密码能包含的特殊字符
    private static final int letterRange = 26;
    private static final int numberRange = 10;
    private static final int spCharacterRange = allowedSpecialCharacters.length;
    private static final Random random = new Random();
    private int passwordLength;//密码的长度
    private int minVariousType;//密码包含字符的最少种类

    public PasswordGenerator(int passwordLength) {
        this.passwordLength = passwordLength;
        this.minVariousType = 4;
    }

    public PasswordGenerator(int passwordLength, int minVariousType) {
        if (minVariousType > CharacterType.values().length) {
            minVariousType = CharacterType.values().length;
        }
        if (minVariousType > passwordLength) {
            minVariousType = passwordLength;
        }
        this.passwordLength = passwordLength;
        this.minVariousType = minVariousType;
    }

    public String generate() {
        char[] password = new char[passwordLength];
        List<Integer> pwCharsIndex = new ArrayList<>();
        for (int i = 0; i < password.length; i++) {
            pwCharsIndex.add(i);
        }
        List<CharacterType> takeTypes = new ArrayList<>(Arrays.asList(CharacterType.values()));
        List<CharacterType> fixedTypes = Arrays.asList(CharacterType.values());
        int typeCount = 0;
        while (pwCharsIndex.size() > 0) {
            int pwIndex = pwCharsIndex.remove(random.nextInt(pwCharsIndex.size()));//随机填充一位密码
            Character c;
            if (typeCount < minVariousType) {//生成不同种类字符
                c = generateCharacter(takeTypes.remove(random.nextInt(takeTypes.size())));
                typeCount++;
            } else {//随机生成所有种类密码
                c = generateCharacter(fixedTypes.get(random.nextInt(fixedTypes.size())));
            }
            password[pwIndex] = c;
        }
        return String.valueOf(password);
    }

    private Character generateCharacter(CharacterType type) {
        Character c = null;
        int rand;
        switch (type) {
            case LOWERCASE://随机小写字母
                rand = random.nextInt(letterRange);
                rand += 97;
                c = (char) rand;
                break;
            case UPPERCASE://随机大写字母
                rand = random.nextInt(letterRange);
                rand += 65;
                c = (char) rand;
                break;
            case NUMBER://随机数字
                rand = random.nextInt(numberRange);
                rand += 48;
                c = (char) rand;
                break;
            case SPECIAL_CHARACTER://随机特殊字符
                rand = random.nextInt(spCharacterRange);
                c = allowedSpecialCharacters[rand];
                break;
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(new PasswordGenerator(8).generate());
    }

    enum CharacterType {
        LOWERCASE,
        UPPERCASE,
        NUMBER,
        SPECIAL_CHARACTER
    }
}
