package com.zxm.coding.asm_plugin;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * Created by ZhangXinmin on 2020/6/1.
 * Copyright (c) 2020 . All rights reserved.
 */
public class LifecycleMethodVisitor extends MethodVisitor {
    private String className;
    private String methodName;

    public LifecycleMethodVisitor(MethodVisitor methodVisitor, String className,
                                  String methodName) {
        super(Opcodes.ASM5, methodVisitor);
        this.className = className;
        this.methodName = methodName;
    }

    @Override
    public void visitCode() {
        super.visitCode();

        System.out.println("MethodVisitor visitCode------");
        mv.visitLdcInsn("TAG");
        mv.visitLdcInsn(className + "---->" + methodName);
        mv.visitMethodInsn(Opcodes.INVOKESTATIC, "android/util/Log",
                "i", "(Ljava/lang/String;Ljava/lang/String;)I", false);
        mv.visitInsn(Opcodes.POP);
    }
}
