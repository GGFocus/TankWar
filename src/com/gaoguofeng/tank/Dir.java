package com.gaoguofeng.tank;

/**
 * 枚举为什么比INT更好？
 * 1.在编译期间就可以发现问题，问题发现的越早越好。
 * 2.不能阻止任何人对int对象赋值，容易出错，用enum不能赋另外的值，会报错。
 */
public enum  Dir {
    L, U, R, D, STOP
}
