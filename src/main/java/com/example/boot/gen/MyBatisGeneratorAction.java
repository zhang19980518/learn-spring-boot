package com.example.boot.gen;

import pro.chenggang.project.reactive.mybatis.support.generator.core.MybatisDynamicCodeGenerator;

/**
 * @author Gang Cheng
 * @date 2021-12-26.
 */
public class MyBatisGeneratorAction {

    public static void main(String[] args) {
        MybatisDynamicCodeGenerator.withYamlConfiguration()
                .customConfigure()
                .applyGenerateBasePackageFromClass(MyBatisGeneratorAction.class)
                .customizeGeneratorProperties()
                .targetPackageBuilder()
                .basePackage("com.example.boot")
                .thenPropertiesBuilder()
                .thenConfigurer()
                .toGenerator()
                .generate();
    }

}
